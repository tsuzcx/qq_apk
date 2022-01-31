package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;

class UrlRedirectCache
{
  private static final String REDIRECT_CONTENT_TAG;
  static final String TAG;
  private static FileLruCache urlRedirectCache;
  
  static
  {
    AppMethodBeat.i(72489);
    TAG = UrlRedirectCache.class.getSimpleName();
    REDIRECT_CONTENT_TAG = TAG + "_Redirect";
    AppMethodBeat.o(72489);
  }
  
  static void cacheUriRedirect(Uri paramUri1, Uri paramUri2)
  {
    AppMethodBeat.i(72487);
    if ((paramUri1 == null) || (paramUri2 == null))
    {
      AppMethodBeat.o(72487);
      return;
    }
    Uri localUri2 = null;
    Uri localUri1 = null;
    try
    {
      paramUri1 = getCache().openPutStream(paramUri1.toString(), REDIRECT_CONTENT_TAG);
      localUri1 = paramUri1;
      localUri2 = paramUri1;
      paramUri1.write(paramUri2.toString().getBytes());
      return;
    }
    catch (IOException paramUri1) {}finally
    {
      Utility.closeQuietly(localUri2);
      AppMethodBeat.o(72487);
    }
  }
  
  static void clearCache()
  {
    AppMethodBeat.i(72488);
    try
    {
      getCache().clearCache();
      AppMethodBeat.o(72488);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + localIOException.getMessage());
      AppMethodBeat.o(72488);
    }
  }
  
  static FileLruCache getCache()
  {
    try
    {
      AppMethodBeat.i(72485);
      if (urlRedirectCache == null) {
        urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
      }
      FileLruCache localFileLruCache = urlRedirectCache;
      AppMethodBeat.o(72485);
      return localFileLruCache;
    }
    finally {}
  }
  
  /* Error */
  static Uri getRedirectedUri(Uri paramUri)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 119
    //   11: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 59	android/net/Uri:toString	()Ljava/lang/String;
    //   20: astore_3
    //   21: invokestatic 56	com/facebook/internal/UrlRedirectCache:getCache	()Lcom/facebook/internal/FileLruCache;
    //   24: astore 5
    //   26: iconst_0
    //   27: istore_1
    //   28: aconst_null
    //   29: astore_0
    //   30: aload 5
    //   32: aload_3
    //   33: getstatic 42	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   36: invokevirtual 123	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +87 -> 130
    //   46: iconst_1
    //   47: istore_1
    //   48: new 125	java/io/InputStreamReader
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: sipush 128
    //   61: newarray char
    //   63: astore_0
    //   64: new 28	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   71: astore 4
    //   73: aload_3
    //   74: aload_0
    //   75: iconst_0
    //   76: sipush 128
    //   79: invokevirtual 132	java/io/InputStreamReader:read	([CII)I
    //   82: istore_2
    //   83: iload_2
    //   84: ifle +27 -> 111
    //   87: aload 4
    //   89: aload_0
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 135	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: goto -23 -> 73
    //   99: astore_0
    //   100: aload_3
    //   101: invokestatic 83	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   104: ldc 119
    //   106: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: aload_3
    //   112: invokestatic 83	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   115: aload 4
    //   117: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 4
    //   122: aload_3
    //   123: astore_0
    //   124: aload 4
    //   126: astore_3
    //   127: goto -97 -> 30
    //   130: iload_1
    //   131: ifeq +19 -> 150
    //   134: aload_3
    //   135: invokestatic 139	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   138: astore_3
    //   139: aload_0
    //   140: invokestatic 83	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   143: ldc 119
    //   145: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_3
    //   149: areturn
    //   150: aload_0
    //   151: invokestatic 83	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   154: goto -50 -> 104
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: invokestatic 83	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   164: ldc 119
    //   166: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_3
    //   170: athrow
    //   171: astore 4
    //   173: aload_3
    //   174: astore_0
    //   175: aload 4
    //   177: astore_3
    //   178: goto -18 -> 160
    //   181: astore_3
    //   182: goto -22 -> 160
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_3
    //   188: goto -88 -> 100
    //   191: astore_3
    //   192: aload_0
    //   193: astore_3
    //   194: goto -94 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramUri	Uri
    //   27	104	1	i	int
    //   82	10	2	j	int
    //   20	129	3	localObject1	Object
    //   157	17	3	localObject2	Object
    //   177	1	3	localObject3	Object
    //   181	1	3	localObject4	Object
    //   187	1	3	localObject5	Object
    //   191	1	3	localIOException	IOException
    //   193	1	3	localUri	Uri
    //   39	86	4	localObject6	Object
    //   171	5	4	localObject7	Object
    //   24	7	5	localFileLruCache	FileLruCache
    // Exception table:
    //   from	to	target	type
    //   58	73	99	java/io/IOException
    //   73	83	99	java/io/IOException
    //   87	96	99	java/io/IOException
    //   111	122	99	java/io/IOException
    //   21	26	157	finally
    //   58	73	171	finally
    //   73	83	171	finally
    //   87	96	171	finally
    //   111	122	171	finally
    //   30	41	181	finally
    //   48	58	181	finally
    //   134	139	181	finally
    //   21	26	185	java/io/IOException
    //   30	41	191	java/io/IOException
    //   48	58	191	java/io/IOException
    //   134	139	191	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.internal.UrlRedirectCache
 * JD-Core Version:    0.7.0.1
 */