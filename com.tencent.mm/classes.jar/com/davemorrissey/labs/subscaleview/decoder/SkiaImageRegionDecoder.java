package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaImageRegionDecoder
  implements ImageRegionDecoder
{
  private final Bitmap.Config bitmapConfig;
  private BitmapRegionDecoder decoder;
  private final ReadWriteLock decoderLock;
  
  public SkiaImageRegionDecoder()
  {
    this((byte)0);
  }
  
  private SkiaImageRegionDecoder(byte paramByte)
  {
    AppMethodBeat.i(157343);
    this.decoderLock = new ReentrantReadWriteLock(true);
    Bitmap.Config localConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
    if (localConfig != null)
    {
      this.bitmapConfig = localConfig;
      AppMethodBeat.o(157343);
      return;
    }
    this.bitmapConfig = Bitmap.Config.RGB_565;
    AppMethodBeat.o(157343);
  }
  
  private Lock getDecodeLock()
  {
    AppMethodBeat.i(157348);
    if (Build.VERSION.SDK_INT < 21)
    {
      localLock = this.decoderLock.writeLock();
      AppMethodBeat.o(157348);
      return localLock;
    }
    Lock localLock = this.decoderLock.readLock();
    AppMethodBeat.o(157348);
    return localLock;
  }
  
  public final Bitmap decodeRegion(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(157345);
    getDecodeLock().lock();
    try
    {
      if ((this.decoder == null) || (this.decoder.isRecycled())) {
        break label116;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      localOptions.inPreferredConfig = this.bitmapConfig;
      paramRect = this.decoder.decodeRegion(paramRect, localOptions);
      if (paramRect == null)
      {
        paramRect = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        AppMethodBeat.o(157345);
        throw paramRect;
      }
    }
    finally
    {
      getDecodeLock().unlock();
      AppMethodBeat.o(157345);
    }
    getDecodeLock().unlock();
    AppMethodBeat.o(157345);
    return paramRect;
    label116:
    paramRect = new IllegalStateException("Cannot decode region after decoder has been recycled");
    AppMethodBeat.o(157345);
    throw paramRect;
  }
  
  /* Error */
  public final android.graphics.Point init(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokevirtual 123	android/net/Uri:toString	()Ljava/lang/String;
    //   9: ldc 125
    //   11: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +186 -> 200
    //   17: aload_2
    //   18: invokevirtual 134	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   21: astore 5
    //   23: aload_1
    //   24: invokevirtual 139	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: aload 5
    //   29: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +109 -> 141
    //   35: aload_1
    //   36: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: astore 4
    //   41: aload_2
    //   42: invokevirtual 151	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface 157 1 0
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_2
    //   55: if_icmpne +100 -> 155
    //   58: aload_2
    //   59: iconst_0
    //   60: invokeinterface 161 2 0
    //   65: checkcast 127	java/lang/String
    //   68: ldc 163
    //   70: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +82 -> 155
    //   76: aload 4
    //   78: aload_2
    //   79: iconst_1
    //   80: invokeinterface 161 2 0
    //   85: checkcast 127	java/lang/String
    //   88: ldc 163
    //   90: aload 5
    //   92: invokevirtual 169	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   95: istore_3
    //   96: aload_0
    //   97: aload_1
    //   98: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   101: iload_3
    //   102: invokevirtual 173	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   105: iconst_0
    //   106: invokestatic 177	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   109: putfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   112: new 179	android/graphics/Point
    //   115: dup
    //   116: aload_0
    //   117: getfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   120: invokevirtual 182	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   123: aload_0
    //   124: getfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   127: invokevirtual 185	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   130: invokespecial 188	android/graphics/Point:<init>	(II)V
    //   133: astore_1
    //   134: ldc 117
    //   136: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: areturn
    //   141: aload_1
    //   142: invokevirtual 192	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   145: aload 5
    //   147: invokevirtual 198	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   150: astore 4
    //   152: goto -111 -> 41
    //   155: iload_3
    //   156: iconst_1
    //   157: if_icmpne +38 -> 195
    //   160: aload_2
    //   161: iconst_0
    //   162: invokeinterface 161 2 0
    //   167: checkcast 200	java/lang/CharSequence
    //   170: invokestatic 206	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +22 -> 195
    //   176: aload_2
    //   177: iconst_0
    //   178: invokeinterface 161 2 0
    //   183: checkcast 127	java/lang/String
    //   186: iconst_0
    //   187: invokestatic 212	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   190: istore_3
    //   191: goto -95 -> 96
    //   194: astore_2
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -101 -> 96
    //   200: aload_2
    //   201: aconst_null
    //   202: invokestatic 218	com/tencent/mm/vfs/y:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/k$f;)Ljava/io/InputStream;
    //   205: astore_2
    //   206: aload_0
    //   207: aload_2
    //   208: iconst_0
    //   209: invokestatic 177	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   212: putfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   215: aload_2
    //   216: ifnull -104 -> 112
    //   219: aload_2
    //   220: invokevirtual 223	java/io/InputStream:close	()V
    //   223: goto -111 -> 112
    //   226: astore_1
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 223	java/io/InputStream:close	()V
    //   235: ldc 117
    //   237: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_2
    //   243: aload_1
    //   244: aload_2
    //   245: invokevirtual 229	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   248: goto -13 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	SkiaImageRegionDecoder
    //   0	251	1	paramContext	android.content.Context
    //   0	251	2	paramUri	android.net.Uri
    //   52	145	3	i	int
    //   39	112	4	localResources	android.content.res.Resources
    //   21	125	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   176	191	194	java/lang/NumberFormatException
    //   206	215	226	finally
    //   231	235	242	finally
  }
  
  /* Error */
  public final boolean isReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 231
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   18: invokevirtual 85	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   21: ifne +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 231
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 231
    //   39: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	SkiaImageRegionDecoder
    //   25	12	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	45	finally
    //   26	31	45	finally
    //   37	42	45	finally
  }
  
  /* Error */
  public final void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 233
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 34	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoderLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   11: invokeinterface 64 1 0
    //   16: invokeinterface 77 1 0
    //   21: aload_0
    //   22: getfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   25: invokevirtual 235	android/graphics/BitmapRegionDecoder:recycle	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 79	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoder	Landroid/graphics/BitmapRegionDecoder;
    //   33: aload_0
    //   34: getfield 34	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoderLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   37: invokeinterface 64 1 0
    //   42: invokeinterface 107 1 0
    //   47: ldc 233
    //   49: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 34	com/davemorrissey/labs/subscaleview/decoder/SkiaImageRegionDecoder:decoderLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   60: invokeinterface 64 1 0
    //   65: invokeinterface 107 1 0
    //   70: ldc 233
    //   72: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	SkiaImageRegionDecoder
    //   55	21	1	localObject1	Object
    //   77	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	33	55	finally
    //   2	21	77	finally
    //   33	52	77	finally
    //   56	77	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder
 * JD-Core Version:    0.7.0.1
 */