package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FFmpegMetadataRetriever
{
  public static final String METADATA_CHAPTER_COUNT = "chapter_count";
  public static final String METADATA_KEY_ALBUM = "album";
  public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
  public static final String METADATA_KEY_ARTIST = "artist";
  public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
  public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
  public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
  public static final String METADATA_KEY_COMMENT = "comment";
  public static final String METADATA_KEY_COMPOSER = "composer";
  public static final String METADATA_KEY_COPYRIGHT = "copyright";
  public static final String METADATA_KEY_CREATION_TIME = "creation_time";
  public static final String METADATA_KEY_DATE = "date";
  public static final String METADATA_KEY_DISC = "disc";
  public static final String METADATA_KEY_DURATION = "duration";
  public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
  public static final String METADATA_KEY_ENCODER = "encoder";
  public static final String METADATA_KEY_FILENAME = "filename";
  public static final String METADATA_KEY_FILESIZE = "filesize";
  public static final String METADATA_KEY_FRAMERATE = "framerate";
  public static final String METADATA_KEY_GENRE = "genre";
  public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
  public static final String METADATA_KEY_LANGUAGE = "language";
  public static final String METADATA_KEY_PERFORMER = "performer";
  public static final String METADATA_KEY_PUBLISHER = "publisher";
  public static final String METADATA_KEY_SERVICE_NAME = "service_name";
  public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
  public static final String METADATA_KEY_TITLE = "title";
  public static final String METADATA_KEY_TRACK = "track";
  public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
  public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
  public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
  public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
  public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
  public static final int OPTION_CLOSEST = 3;
  public static final int OPTION_CLOSEST_SYNC = 2;
  public static final int OPTION_NEXT_SYNC = 1;
  public static final int OPTION_PREVIOUS_SYNC = 0;
  private static final String TAG = "FFmpegMetadataRetriever";
  private long mNativeContext;
  private Bitmap reuse;
  
  static
  {
    AppMethodBeat.i(107628);
    native_init();
    AppMethodBeat.o(107628);
  }
  
  public FFmpegMetadataRetriever()
  {
    AppMethodBeat.i(107609);
    native_setup();
    AppMethodBeat.o(107609);
  }
  
  private native byte[] _getFrameAtTime(long paramLong, int paramInt);
  
  private native byte[] _getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void _setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  private void _setDataSourceVFS(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(107612);
    _setDataSource(q.k(paramString, false), paramArrayOfString1, paramArrayOfString2);
    AppMethodBeat.o(107612);
  }
  
  private Bitmap getBitmapFromPixels(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107622);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(107622);
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = getVideoWidth();
    }
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = getVideoHeight();
    }
    if ((i <= 0) || (paramInt1 <= 0))
    {
      paramArrayOfByte = new IllegalStateException(String.format(Locale.CHINA, "Can not get bitmap width and height [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
      AppMethodBeat.o(107622);
      throw paramArrayOfByte;
    }
    Bitmap localBitmap2 = this.reuse;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    }
    localBitmap1.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    AppMethodBeat.o(107622);
    return localBitmap1;
  }
  
  private native void native_finalize();
  
  private final native HashMap<String, String> native_getMetadata(boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap);
  
  private static native void native_init();
  
  private native void native_setup();
  
  public native String extractMetadata(String paramString);
  
  public native String extractMetadataFromChapter(String paramString, int paramInt);
  
  protected void finalize()
  {
    AppMethodBeat.i(107627);
    try
    {
      native_finalize();
      return;
    }
    catch (Exception localException)
    {
      ae.e("FFmpegMetadataRetriever", "do nothing");
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(107627);
    }
  }
  
  public Bitmap getFrameAtTime()
  {
    AppMethodBeat.i(107618);
    Bitmap localBitmap = getFrameAtTime(-1L, 2);
    AppMethodBeat.o(107618);
    return localBitmap;
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    AppMethodBeat.i(107617);
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, 2);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, -1, -1);
    }
    AppMethodBeat.o(107617);
    return localBitmap;
  }
  
  public Bitmap getFrameAtTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(107616);
    if ((paramInt < 0) || (paramInt > 3))
    {
      localObject = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(107616);
      throw ((Throwable)localObject);
    }
    Object localObject = null;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, paramInt);
    if (arrayOfByte != null) {
      localObject = getBitmapFromPixels(arrayOfByte, -1, -1);
    }
    AppMethodBeat.o(107616);
    return localObject;
  }
  
  public a getMetadata()
  {
    int i = 0;
    AppMethodBeat.i(107615);
    a locala = new a();
    HashMap localHashMap = native_getMetadata(false, false, null);
    if (localHashMap == null)
    {
      AppMethodBeat.o(107615);
      return null;
    }
    if (localHashMap == null) {}
    while (i == 0)
    {
      AppMethodBeat.o(107615);
      return null;
      locala.wdq = localHashMap;
      i = 1;
    }
    AppMethodBeat.o(107615);
    return locala;
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107620);
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, 0, paramInt1, paramInt2);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(107620);
    return localBitmap;
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107619);
    if ((paramInt1 < 0) || (paramInt1 > 3))
    {
      localObject = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(107619);
      throw ((Throwable)localObject);
    }
    Object localObject = null;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, paramInt1, paramInt2, paramInt3);
    if (arrayOfByte != null) {
      localObject = getBitmapFromPixels(arrayOfByte, paramInt2, paramInt3);
    }
    AppMethodBeat.o(107619);
    return localObject;
  }
  
  public byte[] getScaledFrameAtTimeUndecoded(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107626);
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, 2, paramInt1, paramInt2);
    AppMethodBeat.o(107626);
    return arrayOfByte;
  }
  
  public int getVideoHeight()
  {
    int i = 0;
    AppMethodBeat.i(107625);
    for (;;)
    {
      try
      {
        String str2 = extractMetadata("rotate");
        if ((!"90".equals(str2)) && (!"270".equals(str2))) {
          continue;
        }
        str1 = extractMetadata("video_width");
        ae.d("FFmpegMetadataRetriever", "video height %s rotate %s", new Object[] { str1, str2 });
        int j = Integer.valueOf(str1).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        String str1;
        ae.e("FFmpegMetadataRetriever", "can not get video height %s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(107625);
      return i;
      str1 = extractMetadata("video_height");
    }
  }
  
  public int getVideoRotation()
  {
    int i = 0;
    AppMethodBeat.i(107624);
    try
    {
      int j = Integer.valueOf(extractMetadata("rotate")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("FFmpegMetadataRetriever", "can not get video rotation. %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(107624);
    return i;
  }
  
  public int getVideoWidth()
  {
    int i = 0;
    AppMethodBeat.i(107623);
    for (;;)
    {
      try
      {
        str = extractMetadata("rotate");
        if ((!"90".equals(str)) && (!"270".equals(str))) {
          continue;
        }
        str = extractMetadata("video_height");
        int j = Integer.valueOf(str).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        String str;
        ae.e("FFmpegMetadataRetriever", "can not get video width %s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(107623);
      return i;
      str = extractMetadata("video_width");
    }
  }
  
  public native void release();
  
  public void reuseBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(107621);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(107621);
      return;
    }
    if (this.reuse != null) {
      this.reuse.recycle();
    }
    this.reuse = paramBitmap;
    AppMethodBeat.o(107621);
  }
  
  /* Error */
  public void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 346
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnonnull +19 -> 26
    //   10: new 261	java/lang/IllegalArgumentException
    //   13: dup
    //   14: invokespecial 347	java/lang/IllegalArgumentException:<init>	()V
    //   17: astore_1
    //   18: ldc_w 346
    //   21: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_1
    //   25: athrow
    //   26: aload_2
    //   27: invokevirtual 352	android/net/Uri:getScheme	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +13 -> 45
    //   35: aload_3
    //   36: ldc_w 354
    //   39: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +18 -> 60
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 357	android/net/Uri:getPath	()Ljava/lang/String;
    //   50: invokevirtual 359	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   53: ldc_w 346
    //   56: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: aconst_null
    //   61: astore_3
    //   62: aload_1
    //   63: invokevirtual 365	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   66: astore_1
    //   67: aload_1
    //   68: aload_2
    //   69: ldc_w 367
    //   72: invokevirtual 373	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnonnull +66 -> 143
    //   80: new 261	java/lang/IllegalArgumentException
    //   83: dup
    //   84: invokespecial 347	java/lang/IllegalArgumentException:<init>	()V
    //   87: astore_3
    //   88: ldc_w 346
    //   91: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: athrow
    //   96: astore_3
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 378	android/content/res/AssetFileDescriptor:close	()V
    //   105: aload_0
    //   106: aload_2
    //   107: invokevirtual 381	android/net/Uri:toString	()Ljava/lang/String;
    //   110: invokevirtual 359	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   113: ldc_w 346
    //   116: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_1
    //   121: new 261	java/lang/IllegalArgumentException
    //   124: dup
    //   125: invokespecial 347	java/lang/IllegalArgumentException:<init>	()V
    //   128: astore_1
    //   129: ldc_w 346
    //   132: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_3
    //   139: astore_1
    //   140: goto -43 -> 97
    //   143: aload_1
    //   144: invokevirtual 385	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   147: astore_3
    //   148: aload_3
    //   149: invokevirtual 391	java/io/FileDescriptor:valid	()Z
    //   152: ifne +40 -> 192
    //   155: new 261	java/lang/IllegalArgumentException
    //   158: dup
    //   159: invokespecial 347	java/lang/IllegalArgumentException:<init>	()V
    //   162: astore_3
    //   163: ldc_w 346
    //   166: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_3
    //   170: athrow
    //   171: astore_2
    //   172: aload_1
    //   173: astore_3
    //   174: aload_2
    //   175: astore_1
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 378	android/content/res/AssetFileDescriptor:close	()V
    //   184: ldc_w 346
    //   187: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_1
    //   193: invokevirtual 395	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   196: lconst_0
    //   197: lcmp
    //   198: ifge +23 -> 221
    //   201: aload_0
    //   202: aload_3
    //   203: invokevirtual 398	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 378	android/content/res/AssetFileDescriptor:close	()V
    //   214: ldc_w 346
    //   217: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: aload_0
    //   222: aload_3
    //   223: aload_1
    //   224: invokevirtual 401	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   227: aload_1
    //   228: invokevirtual 395	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   231: invokevirtual 404	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   234: goto -28 -> 206
    //   237: astore_1
    //   238: ldc_w 346
    //   241: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: return
    //   245: astore_1
    //   246: goto -141 -> 105
    //   249: astore_2
    //   250: goto -66 -> 184
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_3
    //   256: goto -80 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	FFmpegMetadataRetriever
    //   0	259	1	paramContext	android.content.Context
    //   0	259	2	paramUri	android.net.Uri
    //   30	65	3	localObject1	Object
    //   96	43	3	localSecurityException	java.lang.SecurityException
    //   147	109	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   80	96	96	java/lang/SecurityException
    //   143	171	96	java/lang/SecurityException
    //   192	206	96	java/lang/SecurityException
    //   221	234	96	java/lang/SecurityException
    //   67	76	120	java/io/FileNotFoundException
    //   62	67	137	java/lang/SecurityException
    //   67	76	137	java/lang/SecurityException
    //   121	137	137	java/lang/SecurityException
    //   80	96	171	finally
    //   143	171	171	finally
    //   192	206	171	finally
    //   221	234	171	finally
    //   210	214	237	java/io/IOException
    //   101	105	245	java/io/IOException
    //   180	184	249	java/io/IOException
    //   62	67	253	finally
    //   67	76	253	finally
    //   121	137	253	finally
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(107613);
    setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
    AppMethodBeat.o(107613);
  }
  
  public native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(107610);
    _setDataSourceVFS(paramString, null, null);
    AppMethodBeat.o(107610);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(107611);
    String[] arrayOfString1 = new String[paramMap.size()];
    String[] arrayOfString2 = new String[paramMap.size()];
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      arrayOfString1[i] = ((String)localEntry.getKey());
      arrayOfString2[i] = ((String)localEntry.getValue());
      i += 1;
    }
    _setDataSourceVFS(paramString, arrayOfString1, arrayOfString2);
    AppMethodBeat.o(107611);
  }
  
  public final class a
  {
    HashMap<String, String> wdq;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever
 * JD-Core Version:    0.7.0.1
 */