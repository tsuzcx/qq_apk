package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mm.sdk.platformtools.y;
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
  
  static {}
  
  public FFmpegMetadataRetriever()
  {
    native_setup();
  }
  
  private native byte[] _getFrameAtTime(long paramLong, int paramInt);
  
  private native byte[] _getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void _setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  private Bitmap getBitmapFromPixels(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
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
    if ((i <= 0) || (paramInt1 <= 0)) {
      throw new IllegalStateException(String.format(Locale.CHINA, "Can not get bitmap width and height [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
    }
    Bitmap localBitmap2 = this.reuse;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    }
    localBitmap1.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
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
    try
    {
      native_finalize();
      return;
    }
    catch (Exception localException)
    {
      y.e("FFmpegMetadataRetriever", "do nothing");
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public Bitmap getFrameAtTime()
  {
    return getFrameAtTime(-1L, 2);
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, 2);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, -1, -1);
    }
    return localBitmap;
  }
  
  public Bitmap getFrameAtTime(long paramLong, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("Unsupported option: " + paramInt);
    }
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, paramInt);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, -1, -1);
    }
    return localBitmap;
  }
  
  public FFmpegMetadataRetriever.a getMetadata()
  {
    int i = 0;
    FFmpegMetadataRetriever.a locala = new FFmpegMetadataRetriever.a(this);
    HashMap localHashMap = native_getMetadata(false, false, null);
    if (localHashMap == null) {}
    for (;;)
    {
      return null;
      if (localHashMap == null) {}
      while (i != 0)
      {
        return locala;
        locala.mlr = localHashMap;
        i = 1;
      }
    }
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, 0, paramInt1, paramInt2);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, paramInt1, paramInt2);
    }
    return localBitmap;
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3)) {
      throw new IllegalArgumentException("Unsupported option: " + paramInt1);
    }
    Bitmap localBitmap = null;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, paramInt1, paramInt2, paramInt3);
    if (arrayOfByte != null) {
      localBitmap = getBitmapFromPixels(arrayOfByte, paramInt2, paramInt3);
    }
    return localBitmap;
  }
  
  public byte[] getScaledFrameAtTimeUndecoded(long paramLong, int paramInt1, int paramInt2)
  {
    return _getScaledFrameAtTime(paramLong, 2, paramInt1, paramInt2);
  }
  
  public int getVideoHeight()
  {
    try
    {
      String str2 = extractMetadata("rotate");
      if (("90".equals(str2)) || ("270".equals(str2))) {}
      for (String str1 = extractMetadata("video_width");; str1 = extractMetadata("video_height"))
      {
        y.d("FFmpegMetadataRetriever", "video height %s rotate %s", new Object[] { str1, str2 });
        return Integer.valueOf(str1).intValue();
      }
      return 0;
    }
    catch (Exception localException)
    {
      y.e("FFmpegMetadataRetriever", "can not get video height %s", new Object[] { localException.getMessage() });
    }
  }
  
  public int getVideoRotation()
  {
    try
    {
      int i = Integer.valueOf(extractMetadata("rotate")).intValue();
      return i;
    }
    catch (Exception localException)
    {
      y.e("FFmpegMetadataRetriever", "can not get video rotation. %s", new Object[] { localException.getMessage() });
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    try
    {
      String str = extractMetadata("rotate");
      if (("90".equals(str)) || ("270".equals(str))) {}
      for (str = extractMetadata("video_height");; str = extractMetadata("video_width")) {
        return Integer.valueOf(str).intValue();
      }
      return 0;
    }
    catch (Exception localException)
    {
      y.e("FFmpegMetadataRetriever", "can not get video width %s", new Object[] { localException.getMessage() });
    }
  }
  
  public native void release();
  
  public void reuseBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.reuse != null) {
      this.reuse.recycle();
    }
    this.reuse = paramBitmap;
  }
  
  /* Error */
  public void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +11 -> 12
    //   4: new 234	java/lang/IllegalArgumentException
    //   7: dup
    //   8: invokespecial 315	java/lang/IllegalArgumentException:<init>	()V
    //   11: athrow
    //   12: aload_2
    //   13: invokevirtual 320	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +13 -> 31
    //   21: aload_3
    //   22: ldc_w 322
    //   25: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +12 -> 40
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 325	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokevirtual 327	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   39: return
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_1
    //   43: invokevirtual 333	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: astore_1
    //   47: aload_1
    //   48: aload_2
    //   49: ldc_w 335
    //   52: invokevirtual 341	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnonnull +44 -> 101
    //   60: new 234	java/lang/IllegalArgumentException
    //   63: dup
    //   64: invokespecial 315	java/lang/IllegalArgumentException:<init>	()V
    //   67: athrow
    //   68: astore_3
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 346	android/content/res/AssetFileDescriptor:close	()V
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual 347	android/net/Uri:toString	()Ljava/lang/String;
    //   82: invokevirtual 327	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   85: return
    //   86: astore_1
    //   87: new 234	java/lang/IllegalArgumentException
    //   90: dup
    //   91: invokespecial 315	java/lang/IllegalArgumentException:<init>	()V
    //   94: athrow
    //   95: astore_1
    //   96: aload_3
    //   97: astore_1
    //   98: goto -29 -> 69
    //   101: aload_1
    //   102: invokevirtual 351	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   105: astore_3
    //   106: aload_3
    //   107: invokevirtual 357	java/io/FileDescriptor:valid	()Z
    //   110: ifne +26 -> 136
    //   113: new 234	java/lang/IllegalArgumentException
    //   116: dup
    //   117: invokespecial 315	java/lang/IllegalArgumentException:<init>	()V
    //   120: athrow
    //   121: astore_2
    //   122: aload_1
    //   123: astore_3
    //   124: aload_2
    //   125: astore_1
    //   126: aload_3
    //   127: ifnull +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 346	android/content/res/AssetFileDescriptor:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: aload_1
    //   137: invokevirtual 361	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   140: lconst_0
    //   141: lcmp
    //   142: ifge +19 -> 161
    //   145: aload_0
    //   146: aload_3
    //   147: invokevirtual 364	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   150: aload_1
    //   151: ifnull -112 -> 39
    //   154: aload_1
    //   155: invokevirtual 346	android/content/res/AssetFileDescriptor:close	()V
    //   158: return
    //   159: astore_1
    //   160: return
    //   161: aload_0
    //   162: aload_3
    //   163: aload_1
    //   164: invokevirtual 367	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   167: aload_1
    //   168: invokevirtual 361	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   171: invokevirtual 370	com/tencent/mm/plugin/mmsight/segment/FFmpegMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   174: goto -24 -> 150
    //   177: astore_1
    //   178: goto -101 -> 77
    //   181: astore_2
    //   182: goto -48 -> 134
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_3
    //   188: goto -62 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	FFmpegMetadataRetriever
    //   0	191	1	paramContext	android.content.Context
    //   0	191	2	paramUri	android.net.Uri
    //   16	26	3	str	String
    //   68	29	3	localSecurityException	java.lang.SecurityException
    //   105	83	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	68	68	java/lang/SecurityException
    //   101	121	68	java/lang/SecurityException
    //   136	150	68	java/lang/SecurityException
    //   161	174	68	java/lang/SecurityException
    //   47	56	86	java/io/FileNotFoundException
    //   42	47	95	java/lang/SecurityException
    //   47	56	95	java/lang/SecurityException
    //   87	95	95	java/lang/SecurityException
    //   60	68	121	finally
    //   101	121	121	finally
    //   136	150	121	finally
    //   161	174	121	finally
    //   154	158	159	java/io/IOException
    //   73	77	177	java/io/IOException
    //   130	134	181	java/io/IOException
    //   42	47	185	finally
    //   47	56	185	finally
    //   87	95	185	finally
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
  }
  
  public native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  public void setDataSource(String paramString)
  {
    _setDataSource(paramString, null, null);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
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
    _setDataSource(paramString, arrayOfString1, arrayOfString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever
 * JD-Core Version:    0.7.0.1
 */