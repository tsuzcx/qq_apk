package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class ApngImage
  implements Runnable
{
  private static final byte COLOR_GREYALPHA = 4;
  private static final byte COLOR_GREYSCALE = 0;
  private static final byte COLOR_INDEXED = 3;
  private static final byte COLOR_TRUEALPHA = 6;
  private static final byte COLOR_TRUECOLOR = 2;
  public static final int DENSITY_NONE = 0;
  private static final int IDAT = 1229209940;
  private static final int IEND = 1229278788;
  private static final int IHDR = 1229472850;
  protected static final int MaxStackSize = 4096;
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final int PLTE = 1347179589;
  private static final byte[] SIGNATURE;
  private static final String TAG = "ApngImage";
  private static final int acTL = 1633899596;
  private static final int fcTL = 1717785676;
  private static final int fdAT = 1717846356;
  private static ArgumentsRunnable<WeakReference<ApngImage>> sAccumulativeRunnable;
  private static Handler sHandler;
  protected static boolean sPaused = false;
  protected static final ArrayList<WeakReference<ApngImage>> sPendingActions;
  private static final int tRNS = 1951551059;
  private int bitdepth = 0;
  private byte[] buffer;
  private int bytesPerPixel = 0;
  private boolean cacheFirstFrame;
  private Vector<WeakReference<AnimationCallback>> callbacks = new Vector();
  private int chunkLength;
  private int chunkRemaining;
  private int chunkType;
  private int colorType = 0;
  protected long contentIndex;
  private CRC32 crc;
  private Bitmap curFrame;
  private int cur_blend_op = 0;
  private int cur_ch_height = 0;
  private int cur_ch_width = 0;
  private int cur_delay_den = 0;
  private int cur_delay_num = 0;
  private int cur_dispose_op = 0;
  private int cur_x_offset = 0;
  private int cur_y_offset = 0;
  protected int currentFrameDelay;
  private int delay = 0;
  protected RandomAccessFile file;
  public Bitmap firstFrame;
  private int height = 0;
  private boolean mDecodeNextFrameEnd = true;
  protected boolean mIsInPendingAction = false;
  private int mTaskType;
  private Bitmap nextFrame;
  private int next_blend_op = 0;
  private int next_ch_height = 0;
  private int next_ch_width = 0;
  private int next_delay_den = 0;
  private int next_delay_num = 0;
  private int next_dispose_op = 0;
  private int next_x_offset = 0;
  private int next_y_offset = 0;
  private int numFrames = 0;
  private int numPlays = 0;
  private boolean onlyOneFrame = false;
  private Paint paint = new Paint();
  private Paint paintTransparentBlack = new Paint();
  private byte[] palette;
  private byte[] paletteA;
  private int[] prev_data;
  private byte[] transPixel;
  private int width = 0;
  
  static
  {
    if (!ApngImage.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SIGNATURE = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
      sPaused = false;
      sPendingActions = new ArrayList(105)
      {
        private void ensureCapacity()
        {
          int i = size();
          if (i > 100) {
            removeRange(0, i - 100 - 1);
          }
        }
        
        public boolean add(WeakReference<ApngImage> paramAnonymousWeakReference)
        {
          boolean bool = super.add(paramAnonymousWeakReference);
          ensureCapacity();
          return bool;
        }
      };
      return;
    }
  }
  
  public ApngImage(File paramFile, boolean paramBoolean)
    throws IOException
  {
    try
    {
      this.file = new RandomAccessFile(paramFile, "r");
      init(paramBoolean);
      return;
    }
    catch (IOException paramFile)
    {
      if (this.file == null) {}
    }
    try
    {
      this.file.close();
      label207:
      throw paramFile;
    }
    catch (Exception localException)
    {
      break label207;
    }
  }
  
  public ApngImage(RandomAccessFile paramRandomAccessFile, boolean paramBoolean)
    throws IOException
  {
    try
    {
      this.file = paramRandomAccessFile;
      init(paramBoolean);
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      if (this.file == null) {}
    }
    try
    {
      this.file.close();
      label198:
      throw paramRandomAccessFile;
    }
    catch (Exception localException)
    {
      break label198;
    }
  }
  
  private int ARGBtoColor(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  private void checkChunkLength(int paramInt)
    throws IOException
  {
    if (this.chunkLength != paramInt) {
      throw new IOException("Chunk has wrong size");
    }
  }
  
  private static boolean checkSignature(byte[] paramArrayOfByte)
  {
    int i = 0;
    for (;;)
    {
      if (i >= SIGNATURE.length) {
        return true;
      }
      if (paramArrayOfByte[i] != SIGNATURE[i]) {
        return false;
      }
      i += 1;
    }
  }
  
  private void closeChunk()
    throws IOException
  {
    if (this.chunkRemaining > 0) {
      this.file.seek(this.file.getFilePointer() + this.chunkRemaining + 4L);
    }
    int i;
    do
    {
      this.chunkRemaining = 0;
      this.chunkLength = 0;
      this.chunkType = 0;
      return;
      readFully(this.buffer, 0, 4);
      i = readInt(this.buffer, 0);
    } while ((int)this.crc.getValue() == i);
    throw new IOException("Invalid CRC");
  }
  
  private void expand1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfByte1[((i >> 3) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 7)] = ((byte)(k & 0x1));
      case 7: 
        paramArrayOfByte2[(i + 6)] = ((byte)(k >> 1 & 0x1));
      case 6: 
        paramArrayOfByte2[(i + 5)] = ((byte)(k >> 2 & 0x1));
      case 5: 
        paramArrayOfByte2[(i + 4)] = ((byte)(k >> 3 & 0x1));
      case 4: 
        paramArrayOfByte2[(i + 3)] = ((byte)(k >> 4 & 0x1));
      case 3: 
        paramArrayOfByte2[(i + 2)] = ((byte)(k >> 5 & 0x1));
      case 2: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k >> 6 & 0x1));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 7));
      i += 8;
    }
  }
  
  private void expand2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfByte1[((i >> 2) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 3)] = ((byte)(k & 0x3));
      case 3: 
        paramArrayOfByte2[(i + 2)] = ((byte)(k >> 2 & 0x3));
      case 2: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k >> 4 & 0x3));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 6));
      i += 4;
    }
  }
  
  private void expand4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfByte1[((i >> 1) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k & 0xF));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 4));
      i += 2;
    }
  }
  
  private void init(boolean paramBoolean)
    throws IOException
  {
    this.crc = new CRC32();
    this.buffer = new byte[4096];
    this.paint.setAntiAlias(true);
    this.paintTransparentBlack.setAntiAlias(true);
    this.paintTransparentBlack.setColor(0);
    readFully(this.buffer, 0, SIGNATURE.length);
    if (!checkSignature(this.buffer)) {
      throw new IOException("Not a valid PNG file");
    }
    this.cacheFirstFrame = paramBoolean;
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {
      this.firstFrame = this.curFrame;
    }
    if (this.onlyOneFrame)
    {
      this.firstFrame = this.curFrame;
      this.nextFrame = null;
    }
  }
  
  private void invalidateSelf()
  {
    int i = 0;
    if (i >= this.callbacks.size()) {
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      this.callbacks.remove(i);
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break;
      ((AnimationCallback)localWeakReference.get()).invalidateSelf();
    }
  }
  
  /* Error */
  public static boolean needDecodeAnimation(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 222	java/io/RandomAccessFile
    //   10: dup
    //   11: aload_0
    //   12: ldc 224
    //   14: invokespecial 227	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_0
    //   18: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   21: arraylength
    //   22: newarray byte
    //   24: astore_3
    //   25: aload_0
    //   26: aload_3
    //   27: invokevirtual 344	java/io/RandomAccessFile:read	([B)I
    //   30: pop
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   37: arraylength
    //   38: if_icmplt +19 -> 57
    //   41: aload_0
    //   42: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   53: iconst_1
    //   54: istore_2
    //   55: iload_2
    //   56: ireturn
    //   57: aload_3
    //   58: iload_1
    //   59: baload
    //   60: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   63: iload_1
    //   64: baload
    //   65: if_icmpeq +17 -> 82
    //   68: aload_0
    //   69: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: istore_1
    //   86: goto -53 -> 33
    //   89: astore_0
    //   90: aload 4
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull -39 -> 55
    //   97: aload_0
    //   98: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_0
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: goto -38 -> 80
    //   121: astore_0
    //   122: goto -69 -> 53
    //   125: astore_3
    //   126: goto -11 -> 115
    //   129: astore 4
    //   131: aload_0
    //   132: astore_3
    //   133: aload 4
    //   135: astore_0
    //   136: goto -29 -> 107
    //   139: astore_3
    //   140: goto -47 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	File
    //   32	54	1	i	int
    //   1	55	2	bool	boolean
    //   3	109	3	arrayOfByte	byte[]
    //   125	1	3	localIOException	IOException
    //   132	1	3	localFile	File
    //   139	1	3	localException	Exception
    //   5	86	4	localObject1	Object
    //   129	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	89	java/lang/Exception
    //   97	101	103	java/io/IOException
    //   7	18	106	finally
    //   76	80	117	java/io/IOException
    //   49	53	121	java/io/IOException
    //   111	115	125	java/io/IOException
    //   18	31	129	finally
    //   33	45	129	finally
    //   57	72	129	finally
    //   18	31	139	java/lang/Exception
    //   33	45	139	java/lang/Exception
    //   57	72	139	java/lang/Exception
  }
  
  private void openChunk()
    throws IOException
  {
    readFully(this.buffer, 0, 8);
    this.chunkLength = readInt(this.buffer, 0);
    this.chunkType = readInt(this.buffer, 4);
    this.chunkRemaining = this.chunkLength;
    this.crc.reset();
    this.crc.update(this.buffer, 4, 4);
  }
  
  private void openChunk(int paramInt)
    throws IOException
  {
    openChunk();
    if (this.chunkType != paramInt) {
      throw new IOException("Expected chunk: " + Integer.toHexString(paramInt));
    }
  }
  
  public static final void pauseAll()
  {
    sPaused = true;
  }
  
  private void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  private int readChunk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt2;
    if (paramInt2 > this.chunkRemaining) {
      i = this.chunkRemaining;
    }
    readFully(paramArrayOfByte, paramInt1, i);
    this.crc.update(paramArrayOfByte, paramInt1, i);
    this.chunkRemaining -= i;
    return i;
  }
  
  private void readChunkUnzip(Inflater paramInflater, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int j = paramInt1;
    int i = paramInt2;
    if (!$assertionsDisabled)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramArrayOfByte == this.buffer) {
        throw new AssertionError();
      }
    }
    label136:
    do
    {
      try
      {
        paramInt1 = paramInflater.inflate(paramArrayOfByte, j, i);
        if (paramInt1 > 0) {
          break label136;
        }
        if (paramInflater.finished()) {
          throw new EOFException();
        }
      }
      catch (DataFormatException paramInflater)
      {
        throw ((IOException)new IOException("inflate error").initCause(paramInflater));
      }
      if (paramInflater.needsInput())
      {
        refillInflater(paramInflater, paramInt3);
        paramInt1 = i;
      }
      else
      {
        throw new IOException("Can't inflate " + i + " bytes");
        j += paramInt1;
        paramInt1 = i - paramInt1;
      }
      i = paramInt1;
    } while (paramInt1 > 0);
  }
  
  private void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    do
    {
      i = this.file.read(paramArrayOfByte, paramInt1, paramInt2);
      if ((i < 0) && (i != -1)) {
        throw new EOFException();
      }
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  private void readIDAT()
    throws IOException
  {
    this.nextFrame = Bitmap.createBitmap(Bitmap.createBitmap(decodeChunk(1229209940, this.width, this.height), this.width, this.height, Bitmap.Config.ARGB_8888));
    if (this.cacheFirstFrame) {
      this.firstFrame = this.nextFrame;
    }
  }
  
  private void readIEND()
    throws IOException
  {}
  
  private void readIHDR()
    throws IOException
  {
    checkChunkLength(13);
    readChunk(this.buffer, 0, 13);
    this.width = readInt(this.buffer, 0);
    this.height = readInt(this.buffer, 4);
    this.bitdepth = (this.buffer[8] & 0xFF);
    this.colorType = (this.buffer[9] & 0xFF);
    this.prev_data = new int[this.width * this.height];
    switch (this.colorType)
    {
    case 1: 
    case 5: 
    default: 
      throw new IOException("unsupported color format: " + this.colorType);
    case 0: 
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 1;
    }
    while (this.buffer[10] != 0)
    {
      throw new IOException("unsupported compression method");
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 2;
      continue;
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 3;
      continue;
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 4;
      continue;
      switch (this.bitdepth)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 1;
    }
    if (this.buffer[11] != 0) {
      throw new IOException("unsupported filtering method");
    }
    if (this.buffer[12] != 0) {
      throw new IOException("unsupported interlace method");
    }
  }
  
  private int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private void readPLTE()
    throws IOException
  {
    int i = this.chunkLength / 3;
    if ((i < 1) || (i > 256) || (this.chunkLength % 3 != 0)) {
      throw new IOException("PLTE chunk has wrong length");
    }
    this.palette = new byte[i * 3];
    readChunk(this.palette, 0, this.palette.length);
  }
  
  private int readShort(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  private void readacTL()
    throws IOException
  {
    this.contentIndex = this.file.getFilePointer();
    checkChunkLength(8);
    readChunk(this.buffer, 0, 8);
    this.numFrames = readInt(this.buffer, 0);
    if (this.numFrames == 1) {
      this.onlyOneFrame = true;
    }
    this.numPlays = readInt(this.buffer, 4);
  }
  
  private void readfcTL()
    throws IOException
  {
    checkChunkLength(26);
    readChunk(this.buffer, 0, 26);
    this.next_ch_width = readInt(this.buffer, 4);
    this.next_ch_height = readInt(this.buffer, 8);
    this.next_x_offset = readInt(this.buffer, 12);
    this.next_y_offset = readInt(this.buffer, 16);
    this.next_delay_num = readShort(this.buffer, 20);
    this.next_delay_den = readShort(this.buffer, 22);
    this.next_dispose_op = this.buffer[24];
    this.next_blend_op = this.buffer[25];
    if (this.next_delay_den == 0)
    {
      this.delay = 100;
      return;
    }
    this.delay = (this.next_delay_num * 1000 / this.next_delay_den);
  }
  
  private void readfdAT()
    throws IOException
  {
    readChunk(this.buffer, 0, 4);
    int[] arrayOfInt1 = decodeChunk(1717846356, this.next_ch_width, this.next_ch_height);
    Bitmap localBitmap1 = Bitmap.createBitmap(arrayOfInt1, this.next_ch_width, this.next_ch_height, Bitmap.Config.ARGB_8888);
    Bitmap localBitmap2 = this.curFrame.copy(Bitmap.Config.ARGB_8888, true);
    if ((this.next_dispose_op != 0) && (this.next_dispose_op != 1) && (this.next_dispose_op != 2)) {
      throw new IOException("Incorrect frame dispose: " + Integer.toHexString(this.next_dispose_op));
    }
    localBitmap2.getPixels(this.prev_data, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
    int[] arrayOfInt2;
    if (this.next_blend_op == 0) {
      if (this.next_dispose_op == 0) {
        if (this.cur_dispose_op == 1)
        {
          arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
          Arrays.fill(arrayOfInt2, 0);
          localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
          localBitmap2.setPixels(arrayOfInt1, 0, this.next_ch_width, this.next_x_offset, this.next_y_offset, this.next_ch_width, this.next_ch_height);
        }
      }
    }
    for (;;)
    {
      new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
      this.nextFrame = Bitmap.createBitmap(localBitmap2);
      return;
      if (this.cur_dispose_op != 2) {
        break;
      }
      localBitmap2.setPixels(this.prev_data, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
      break;
      if (this.next_dispose_op == 1)
      {
        arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
        Arrays.fill(arrayOfInt2, 0);
        localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
        break;
      }
      if ((this.next_dispose_op != 2) || (this.cur_dispose_op != 1)) {
        break;
      }
      arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
      Arrays.fill(arrayOfInt2, 0);
      localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
      break;
      if (this.next_blend_op == 1) {
        if (this.next_dispose_op == 0)
        {
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
        else if (this.next_dispose_op == 1)
        {
          Arrays.fill(arrayOfInt1, 0);
          localBitmap2.setPixels(arrayOfInt1, 0, this.next_ch_width, this.next_x_offset, this.next_y_offset, this.next_ch_width, this.next_ch_height);
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
        else if (this.next_dispose_op == 2)
        {
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
      }
    }
  }
  
  private void readtRNS()
    throws IOException
  {
    switch (this.colorType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      checkChunkLength(2);
      this.transPixel = new byte[2];
      readChunk(this.transPixel, 0, 2);
      return;
    case 2: 
      checkChunkLength(6);
      this.transPixel = new byte[6];
      readChunk(this.transPixel, 0, 6);
      return;
    }
    if (this.palette == null) {
      throw new IOException("tRNS chunk without PLTE chunk");
    }
    this.paletteA = new byte[this.palette.length / 3];
    Arrays.fill(this.paletteA, (byte)-1);
    readChunk(this.paletteA, 0, this.paletteA.length);
  }
  
  private void refillInflater(Inflater paramInflater, int paramInt)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (this.chunkRemaining != 0)
      {
        paramInt = readChunk(this.buffer, 0, this.buffer.length);
        paramInflater.setInput(this.buffer, i, paramInt - i);
        return;
      }
      closeChunk();
      openChunk(paramInt);
      if (paramInt == 1717846356) {
        i = 4;
      }
    }
  }
  
  public static final void resumeAll()
  {
    sPaused = false;
    int i = sPendingActions.size() - 1;
    for (;;)
    {
      if (i < 0)
      {
        sPendingActions.clear();
        return;
      }
      ApngImage localApngImage = (ApngImage)((WeakReference)sPendingActions.get(i)).get();
      if (localApngImage != null) {
        localApngImage.reDraw();
      }
      i -= 1;
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  private void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    int i = 0;
    if (i >= this.callbacks.size()) {
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      this.callbacks.remove(i);
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break;
      ((AnimationCallback)localWeakReference.get()).scheduleSelf(paramRunnable, paramLong);
    }
  }
  
  private void unfilter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws IOException
  {
    switch (paramArrayOfByte1[0])
    {
    default: 
      throw new IOException("invalide filter type in scanline: " + paramArrayOfByte1[0]);
    case 1: 
      unfilterSub(paramArrayOfByte1);
    case 0: 
      return;
    case 2: 
      unfilterUp(paramArrayOfByte1, paramArrayOfByte2);
      return;
    case 3: 
      unfilterAverage(paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    unfilterPaeth(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private void unfilterAverage(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = this.bytesPerPixel;
    int i = 1;
    int k;
    if (i > j) {
      k = paramArrayOfByte1.length;
    }
    for (;;)
    {
      if (i >= k)
      {
        return;
        paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + (byte)((paramArrayOfByte2[i] & 0xFF) >>> 1)));
        i += 1;
        break;
      }
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + (byte)((paramArrayOfByte2[i] & 0xFF) + (paramArrayOfByte1[(i - j)] & 0xFF) >>> 1)));
      i += 1;
    }
  }
  
  private void unfilterPaeth(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i4 = this.bytesPerPixel;
    int i = 1;
    int j;
    for (;;)
    {
      if (i > i4)
      {
        int i5 = paramArrayOfByte1.length;
        j = i;
        if (j < i5) {
          break;
        }
        return;
      }
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + paramArrayOfByte2[i]));
      i += 1;
    }
    int i1 = paramArrayOfByte1[(j - i4)] & 0xFF;
    int n = paramArrayOfByte2[j] & 0xFF;
    int i2 = paramArrayOfByte2[(j - i4)] & 0xFF;
    int i3 = i1 + n - i2;
    int k = i3 - i1;
    i = k;
    if (k < 0) {
      i = -k;
    }
    int m = i3 - n;
    k = m;
    if (m < 0) {
      k = -m;
    }
    i3 -= i2;
    m = i3;
    if (i3 < 0) {
      m = -i3;
    }
    if ((i <= k) && (i <= m)) {
      i = i1;
    }
    for (;;)
    {
      paramArrayOfByte1[j] = ((byte)(paramArrayOfByte1[j] + (byte)i));
      j += 1;
      break;
      i = i2;
      if (k <= m) {
        i = n;
      }
    }
  }
  
  private void unfilterSub(byte[] paramArrayOfByte)
  {
    int j = this.bytesPerPixel;
    int i = j + 1;
    int k = paramArrayOfByte.length;
    for (;;)
    {
      if (i >= k) {
        return;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + paramArrayOfByte[(i - j)]));
      i += 1;
    }
  }
  
  private void unfilterUp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte1.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + paramArrayOfByte2[i]));
      i += 1;
    }
  }
  
  public void addCallBack(AnimationCallback paramAnimationCallback)
  {
    if (paramAnimationCallback != null) {
      this.callbacks.add(new WeakReference(paramAnimationCallback));
    }
  }
  
  public void applyNextFrame()
  {
    try
    {
      this.curFrame = this.nextFrame;
      this.cur_ch_width = this.next_ch_width;
      this.cur_ch_height = this.next_ch_height;
      this.cur_x_offset = this.next_x_offset;
      this.cur_y_offset = this.next_y_offset;
      this.cur_delay_num = this.next_delay_num;
      this.cur_delay_den = this.next_delay_den;
      this.cur_dispose_op = this.next_dispose_op;
      this.cur_blend_op = this.next_blend_op;
      System.out.println("delay:" + this.delay);
      this.currentFrameDelay = this.delay;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int[] decodeChunk(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   4: iload_2
    //   5: imul
    //   6: bipush 7
    //   8: iadd
    //   9: bipush 8
    //   11: idiv
    //   12: aload_0
    //   13: getfield 202	com/tencent/image/ApngImage:bytesPerPixel	I
    //   16: imul
    //   17: istore 9
    //   19: iconst_0
    //   20: istore 10
    //   22: iload 9
    //   24: iconst_1
    //   25: iadd
    //   26: newarray byte
    //   28: astore 16
    //   30: iload 9
    //   32: iconst_1
    //   33: iadd
    //   34: newarray byte
    //   36: astore 15
    //   38: aload_0
    //   39: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   42: bipush 8
    //   44: if_icmpge +46 -> 90
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: newarray byte
    //   52: astore 17
    //   54: iload_2
    //   55: iload_3
    //   56: imul
    //   57: newarray int
    //   59: astore 20
    //   61: new 386	java/util/zip/Inflater
    //   64: dup
    //   65: invokespecial 570	java/util/zip/Inflater:<init>	()V
    //   68: astore 19
    //   70: iconst_0
    //   71: istore 9
    //   73: iload 10
    //   75: istore_2
    //   76: iload 9
    //   78: iload_3
    //   79: if_icmplt +17 -> 96
    //   82: aload 19
    //   84: invokevirtual 573	java/util/zip/Inflater:end	()V
    //   87: aload 20
    //   89: areturn
    //   90: aconst_null
    //   91: astore 17
    //   93: goto -39 -> 54
    //   96: aload_0
    //   97: aload 19
    //   99: aload 16
    //   101: iconst_0
    //   102: aload 16
    //   104: arraylength
    //   105: iload_1
    //   106: invokespecial 575	com/tencent/image/ApngImage:readChunkUnzip	(Ljava/util/zip/Inflater;[BIII)V
    //   109: aload_0
    //   110: aload 16
    //   112: aload 15
    //   114: invokespecial 577	com/tencent/image/ApngImage:unfilter	([B[B)V
    //   117: aload_0
    //   118: getfield 200	com/tencent/image/ApngImage:colorType	I
    //   121: tableswitch	default:+679 -> 800, 0:+334->455, 1:+43->164, 2:+64->185, 3:+356->477, 4:+345->466, 5:+43->164, 6:+276->397
    //   165: iconst_m1
    //   166: fstore_0
    //   167: dup
    //   168: ldc_w 581
    //   171: invokespecial 582	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore 15
    //   177: aload 19
    //   179: invokevirtual 573	java/util/zip/Inflater:end	()V
    //   182: aload 15
    //   184: athrow
    //   185: aload_0
    //   186: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   189: ifnull +156 -> 345
    //   192: aload_0
    //   193: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   196: iconst_1
    //   197: baload
    //   198: istore 11
    //   200: aload_0
    //   201: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   204: iconst_3
    //   205: baload
    //   206: istore 12
    //   208: aload_0
    //   209: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   212: iconst_5
    //   213: baload
    //   214: istore 13
    //   216: iconst_1
    //   217: istore 10
    //   219: aload 16
    //   221: arraylength
    //   222: istore 14
    //   224: iload 10
    //   226: iload 14
    //   228: if_icmplt +24 -> 252
    //   231: aload 15
    //   233: astore 18
    //   235: aload 16
    //   237: astore 15
    //   239: iload 9
    //   241: iconst_1
    //   242: iadd
    //   243: istore 9
    //   245: aload 18
    //   247: astore 16
    //   249: goto -173 -> 76
    //   252: aload 16
    //   254: iload 10
    //   256: baload
    //   257: istore 6
    //   259: aload 16
    //   261: iload 10
    //   263: iconst_1
    //   264: iadd
    //   265: baload
    //   266: istore 7
    //   268: aload 16
    //   270: iload 10
    //   272: iconst_2
    //   273: iadd
    //   274: baload
    //   275: istore 8
    //   277: iconst_m1
    //   278: istore 5
    //   280: iload 5
    //   282: istore 4
    //   284: iload 6
    //   286: iload 11
    //   288: if_icmpne +28 -> 316
    //   291: iload 5
    //   293: istore 4
    //   295: iload 7
    //   297: iload 12
    //   299: if_icmpne +17 -> 316
    //   302: iload 5
    //   304: istore 4
    //   306: iload 8
    //   308: iload 13
    //   310: if_icmpne +6 -> 316
    //   313: iconst_0
    //   314: istore 4
    //   316: aload 20
    //   318: iload_2
    //   319: aload_0
    //   320: iload 4
    //   322: iload 6
    //   324: iload 7
    //   326: iload 8
    //   328: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   331: iastore
    //   332: iload 10
    //   334: iconst_3
    //   335: iadd
    //   336: istore 10
    //   338: iload_2
    //   339: iconst_1
    //   340: iadd
    //   341: istore_2
    //   342: goto -118 -> 224
    //   345: iconst_1
    //   346: istore 10
    //   348: aload 16
    //   350: arraylength
    //   351: istore 11
    //   353: goto +450 -> 803
    //   356: aload 20
    //   358: iload_2
    //   359: aload_0
    //   360: iconst_m1
    //   361: aload 16
    //   363: iload 10
    //   365: baload
    //   366: aload 16
    //   368: iload 10
    //   370: iconst_1
    //   371: iadd
    //   372: baload
    //   373: aload 16
    //   375: iload 10
    //   377: iconst_2
    //   378: iadd
    //   379: baload
    //   380: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   383: iastore
    //   384: iload 10
    //   386: iconst_3
    //   387: iadd
    //   388: istore 10
    //   390: iload_2
    //   391: iconst_1
    //   392: iadd
    //   393: istore_2
    //   394: goto +409 -> 803
    //   397: iconst_1
    //   398: istore 10
    //   400: aload 16
    //   402: arraylength
    //   403: istore 11
    //   405: goto +408 -> 813
    //   408: aload 20
    //   410: iload_2
    //   411: aload_0
    //   412: aload 16
    //   414: iload 10
    //   416: iconst_3
    //   417: iadd
    //   418: baload
    //   419: aload 16
    //   421: iload 10
    //   423: baload
    //   424: aload 16
    //   426: iload 10
    //   428: iconst_1
    //   429: iadd
    //   430: baload
    //   431: aload 16
    //   433: iload 10
    //   435: iconst_2
    //   436: iadd
    //   437: baload
    //   438: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   441: iastore
    //   442: iload 10
    //   444: iconst_4
    //   445: iadd
    //   446: istore 10
    //   448: iload_2
    //   449: iconst_1
    //   450: iadd
    //   451: istore_2
    //   452: goto +361 -> 813
    //   455: iconst_1
    //   456: istore 10
    //   458: aload 16
    //   460: arraylength
    //   461: istore 11
    //   463: goto +360 -> 823
    //   466: iconst_1
    //   467: istore 10
    //   469: aload 16
    //   471: arraylength
    //   472: istore 11
    //   474: goto +385 -> 859
    //   477: aload_0
    //   478: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   481: tableswitch	default:+425 -> 906, 1:+98->579, 2:+87->568, 3:+47->528, 4:+76->557, 5:+47->528, 6:+47->528, 7:+47->528, 8:+428->909
    //   529: iconst_m1
    //   530: fstore_0
    //   531: dup
    //   532: ldc_w 586
    //   535: invokespecial 582	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   538: athrow
    //   539: aload_0
    //   540: getfield 503	com/tencent/image/ApngImage:paletteA	[B
    //   543: ifnull +147 -> 690
    //   546: iconst_1
    //   547: istore 11
    //   549: aload 16
    //   551: arraylength
    //   552: istore 12
    //   554: goto +362 -> 916
    //   557: aload_0
    //   558: aload 16
    //   560: aload 17
    //   562: invokespecial 588	com/tencent/image/ApngImage:expand4	([B[B)V
    //   565: goto -26 -> 539
    //   568: aload_0
    //   569: aload 16
    //   571: aload 17
    //   573: invokespecial 590	com/tencent/image/ApngImage:expand2	([B[B)V
    //   576: goto -37 -> 539
    //   579: aload_0
    //   580: aload 16
    //   582: aload 17
    //   584: invokespecial 592	com/tencent/image/ApngImage:expand1	([B[B)V
    //   587: goto -48 -> 539
    //   590: aload 16
    //   592: iload 11
    //   594: baload
    //   595: sipush 255
    //   598: iand
    //   599: istore 13
    //   601: iload_2
    //   602: istore 10
    //   604: aload_0
    //   605: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   608: iload 13
    //   610: iconst_3
    //   611: imul
    //   612: iconst_0
    //   613: iadd
    //   614: baload
    //   615: istore 4
    //   617: iload_2
    //   618: istore 10
    //   620: aload_0
    //   621: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   624: iload 13
    //   626: iconst_3
    //   627: imul
    //   628: iconst_1
    //   629: iadd
    //   630: baload
    //   631: istore 5
    //   633: iload_2
    //   634: istore 10
    //   636: aload_0
    //   637: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   640: iload 13
    //   642: iconst_3
    //   643: imul
    //   644: iconst_2
    //   645: iadd
    //   646: baload
    //   647: istore 6
    //   649: iload_2
    //   650: istore 10
    //   652: aload_0
    //   653: getfield 503	com/tencent/image/ApngImage:paletteA	[B
    //   656: iload 13
    //   658: baload
    //   659: istore 7
    //   661: aload 20
    //   663: iload_2
    //   664: aload_0
    //   665: iload 7
    //   667: iload 4
    //   669: iload 5
    //   671: iload 6
    //   673: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   676: iastore
    //   677: iload 11
    //   679: iconst_1
    //   680: iadd
    //   681: istore 11
    //   683: iload_2
    //   684: iconst_1
    //   685: iadd
    //   686: istore_2
    //   687: goto +229 -> 916
    //   690: iconst_1
    //   691: istore 11
    //   693: aload 16
    //   695: arraylength
    //   696: istore 12
    //   698: iload 11
    //   700: iload 12
    //   702: if_icmplt +6 -> 708
    //   705: goto -474 -> 231
    //   708: aload 16
    //   710: iload 11
    //   712: baload
    //   713: sipush 255
    //   716: iand
    //   717: istore 13
    //   719: iload_2
    //   720: istore 10
    //   722: aload_0
    //   723: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   726: iload 13
    //   728: iconst_3
    //   729: imul
    //   730: iconst_0
    //   731: iadd
    //   732: baload
    //   733: istore 4
    //   735: iload_2
    //   736: istore 10
    //   738: aload_0
    //   739: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   742: iload 13
    //   744: iconst_3
    //   745: imul
    //   746: iconst_1
    //   747: iadd
    //   748: baload
    //   749: istore 5
    //   751: iload_2
    //   752: istore 10
    //   754: aload_0
    //   755: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   758: iload 13
    //   760: iconst_3
    //   761: imul
    //   762: iconst_2
    //   763: iadd
    //   764: baload
    //   765: istore 6
    //   767: aload 20
    //   769: iload_2
    //   770: aload_0
    //   771: iconst_m1
    //   772: iload 4
    //   774: iload 5
    //   776: iload 6
    //   778: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   781: iastore
    //   782: iload 11
    //   784: iconst_1
    //   785: iadd
    //   786: istore 11
    //   788: iload_2
    //   789: iconst_1
    //   790: iadd
    //   791: istore_2
    //   792: goto -94 -> 698
    //   795: astore 15
    //   797: goto -620 -> 177
    //   800: goto -636 -> 164
    //   803: iload 10
    //   805: iload 11
    //   807: if_icmplt -451 -> 356
    //   810: goto -579 -> 231
    //   813: iload 10
    //   815: iload 11
    //   817: if_icmplt -409 -> 408
    //   820: goto -589 -> 231
    //   823: iload 10
    //   825: iload 11
    //   827: if_icmplt +6 -> 833
    //   830: goto -599 -> 231
    //   833: aload 20
    //   835: iload_2
    //   836: aload 16
    //   838: iload 10
    //   840: baload
    //   841: ldc_w 593
    //   844: imul
    //   845: iastore
    //   846: iload 10
    //   848: iconst_1
    //   849: iadd
    //   850: istore 10
    //   852: iload_2
    //   853: iconst_1
    //   854: iadd
    //   855: istore_2
    //   856: goto -33 -> 823
    //   859: iload 10
    //   861: iload 11
    //   863: if_icmplt +6 -> 869
    //   866: goto -635 -> 231
    //   869: aload 20
    //   871: iload_2
    //   872: aload 16
    //   874: iload 10
    //   876: baload
    //   877: ldc_w 593
    //   880: imul
    //   881: aload 16
    //   883: iload 10
    //   885: iconst_1
    //   886: iadd
    //   887: baload
    //   888: bipush 6
    //   890: ishl
    //   891: iadd
    //   892: iastore
    //   893: iload 10
    //   895: iconst_2
    //   896: iadd
    //   897: istore 10
    //   899: iload_2
    //   900: iconst_1
    //   901: iadd
    //   902: istore_2
    //   903: goto -44 -> 859
    //   906: goto -378 -> 528
    //   909: aload 16
    //   911: astore 17
    //   913: goto -374 -> 539
    //   916: iload 11
    //   918: iload 12
    //   920: if_icmplt -330 -> 590
    //   923: goto -692 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	ApngImage
    //   0	926	1	paramInt1	int
    //   0	926	2	paramInt2	int
    //   0	926	3	paramInt3	int
    //   282	491	4	b1	byte
    //   278	497	5	b2	byte
    //   257	66	6	i	int
    //   647	130	6	b3	byte
    //   266	59	7	j	int
    //   659	7	7	b4	byte
    //   275	52	8	b5	byte
    //   17	227	9	k	int
    //   20	878	10	m	int
    //   198	723	11	n	int
    //   206	715	12	i1	int
    //   214	548	13	i2	int
    //   222	7	14	i3	int
    //   36	77	15	arrayOfByte	byte[]
    //   175	57	15	localObject1	Object
    //   237	1	15	localObject2	Object
    //   795	1	15	localObject3	Object
    //   28	882	16	localObject4	Object
    //   52	860	17	localObject5	Object
    //   233	13	18	localObject6	Object
    //   68	110	19	localInflater	Inflater
    //   59	811	20	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   96	164	175	finally
    //   164	175	175	finally
    //   185	216	175	finally
    //   219	224	175	finally
    //   316	332	175	finally
    //   348	353	175	finally
    //   356	384	175	finally
    //   400	405	175	finally
    //   408	442	175	finally
    //   458	463	175	finally
    //   469	474	175	finally
    //   477	528	175	finally
    //   528	539	175	finally
    //   539	546	175	finally
    //   549	554	175	finally
    //   557	565	175	finally
    //   568	576	175	finally
    //   579	587	175	finally
    //   661	677	175	finally
    //   693	698	175	finally
    //   767	782	175	finally
    //   604	617	795	finally
    //   620	633	795	finally
    //   636	649	795	finally
    //   652	661	795	finally
    //   722	735	795	finally
    //   738	751	795	finally
    //   754	767	795	finally
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    this.mDecodeNextFrameEnd = true;
    if (!sPaused) {
      invalidateSelf();
    }
    while (this.mIsInPendingAction) {
      return;
    }
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    if (sHandler == null)
    {
      sHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable(null);
    }
    if ((this.onlyOneFrame) || ((!paramBoolean) && (this.firstFrame != null))) {
      paramCanvas.drawBitmap(this.firstFrame, null, paramRect, paramPaint);
    }
    do
    {
      return;
      if (this.curFrame != null) {
        paramCanvas.drawBitmap(this.curFrame, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  public void drawFrame(Canvas paramCanvas) {}
  
  protected void executeNewTask()
  {
    long l1;
    long l2;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = getDelay();
    }
    try
    {
      Utils.executeAsyncTaskOnSerialExcuter(new DecodeNextFrameAsyncTask(l1 + l2), null);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  public int getByteSize()
  {
    if (this.onlyOneFrame) {
      return Utils.getBitmapSize(this.firstFrame);
    }
    int j = this.width;
    int k = this.height;
    if (this.firstFrame != null) {}
    for (int i = Utils.getBitmapSize(this.firstFrame);; i = 0) {
      return i + (j * k * 4 * 2 + 4096);
    }
  }
  
  public Bitmap getCurrentFrame()
  {
    return this.curFrame;
  }
  
  public int getDelay()
  {
    System.out.println("currentFrameDelay:" + this.currentFrameDelay);
    return this.currentFrameDelay;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLoopCount()
  {
    return this.numPlays;
  }
  
  protected boolean getNextFrame()
    throws IOException
  {
    boolean bool = true;
    int i = 0;
    for (;;)
    {
      if (i >= 10000)
      {
        try
        {
          if ((this.colorType != 3) || (this.palette != null)) {
            break label235;
          }
          throw new IOException("Missing PLTE chunk");
        }
        finally {}
      }
      else
      {
        openChunk();
        switch (this.chunkType)
        {
        }
      }
      while (this.chunkType != 1229278788)
      {
        closeChunk();
        break;
        readIHDR();
        continue;
        readIDAT();
        closeChunk();
        for (;;)
        {
          return bool;
          readPLTE();
          break;
          readtRNS();
          break;
          readacTL();
          this.contentIndex = this.file.getFilePointer();
          break;
          readfcTL();
          break;
          readfdAT();
          closeChunk();
          continue;
          readIEND();
          this.file.seek(this.contentIndex + 4L);
          break;
          label235:
          bool = false;
        }
      }
      i += 1;
    }
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(this.height, 160, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(this.width, 160, paramInt);
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean hasAlpha()
  {
    return (hasAlphaChannel()) || (this.paletteA != null) || (this.transPixel != null);
  }
  
  public boolean hasAlphaChannel()
  {
    return (this.colorType == 6) || (this.colorType == 4);
  }
  
  protected void initHandlerAndRunnable()
  {
    if (sHandler == null)
    {
      sHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable(null);
    }
  }
  
  public boolean isRGB()
  {
    return (this.colorType == 6) || (this.colorType == 2) || (this.colorType == 3);
  }
  
  void onDecodeNextFrameCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode canceled. " + this.file);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameFailed(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode error. " + this.file, paramThrowable);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameSuccessed(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      long l = SystemClock.uptimeMillis();
      if (l < paramLong) {
        sHandler.postDelayed(this, paramLong - l);
      }
    }
    else
    {
      return;
    }
    sHandler.post(this);
  }
  
  public void overwriteTRNS(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (hasAlphaChannel()) {
      throw new UnsupportedOperationException("image has an alpha channel");
    }
    byte[] arrayOfByte = this.palette;
    if (arrayOfByte == null)
    {
      arrayOfByte = new byte[6];
      arrayOfByte[1] = paramByte1;
      arrayOfByte[3] = paramByte2;
      arrayOfByte[5] = paramByte3;
      this.transPixel = arrayOfByte;
    }
    for (;;)
    {
      return;
      this.paletteA = new byte[arrayOfByte.length / 3];
      int j = 0;
      int i = 0;
      while (j < arrayOfByte.length)
      {
        if ((arrayOfByte[j] != paramByte1) || (arrayOfByte[(j + 1)] != paramByte2) || (arrayOfByte[(j + 2)] != paramByte3)) {
          this.paletteA[i] = -1;
        }
        j += 3;
        i += 1;
      }
    }
  }
  
  public void removeCallBack(AnimationCallback paramAnimationCallback)
  {
    int i = 0;
    if (i >= this.callbacks.size()) {
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
    int j;
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      this.callbacks.remove(i);
      j = i - 1;
    }
    do
    {
      i = j + 1;
      break;
      j = i;
    } while (localWeakReference.get() != paramAnimationCallback);
    this.callbacks.remove(i);
  }
  
  public void run()
  {
    sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(this) });
  }
  
  class DecodeNextFrameAsyncTask
    extends AsyncTask<Void, Void, Object>
  {
    long nextFrameDrawingTime;
    
    public DecodeNextFrameAsyncTask(long paramLong)
    {
      this.nextFrameDrawingTime = paramLong;
    }
    
    protected Object doInBackground(Void... paramVarArgs)
    {
      try
      {
        boolean bool = ApngImage.this.getNextFrame();
        ApngImage.this.onDecodeNextFrameSuccessed(bool, this.nextFrameDrawingTime);
        return null;
      }
      catch (Throwable paramVarArgs) {}
      return paramVarArgs;
    }
    
    protected void onCancelled()
    {
      ApngImage.this.onDecodeNextFrameCanceled();
    }
    
    protected void onPostExecute(Object paramObject)
    {
      if ((paramObject instanceof Throwable)) {
        ApngImage.this.onDecodeNextFrameFailed((Throwable)paramObject);
      }
    }
  }
  
  private class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<ApngImage>>
  {
    private long lastRefreshTime = 0L;
    
    private DoAccumulativeRunnable() {}
    
    protected void run(List<WeakReference<ApngImage>> paramList)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext())
        {
          this.lastRefreshTime = SystemClock.uptimeMillis();
          return;
        }
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (ApngImage)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ApngImage)localObject).doApplyNextFrame();
          }
        }
      }
    }
    
    protected void submit()
    {
      long l = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l - this.lastRefreshTime > 100L))
      {
        run();
        this.lastRefreshTime = l;
        return;
      }
      ApngImage.sHandler.postDelayed(this, 100L - (l - this.lastRefreshTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.ApngImage
 * JD-Core Version:    0.7.0.1
 */