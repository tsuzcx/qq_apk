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
    AppMethodBeat.i(17925);
    TAG = UrlRedirectCache.class.getSimpleName();
    REDIRECT_CONTENT_TAG = TAG + "_Redirect";
    AppMethodBeat.o(17925);
  }
  
  static void cacheUriRedirect(Uri paramUri1, Uri paramUri2)
  {
    AppMethodBeat.i(17923);
    if ((paramUri1 == null) || (paramUri2 == null))
    {
      AppMethodBeat.o(17923);
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
      AppMethodBeat.o(17923);
    }
  }
  
  static void clearCache()
  {
    AppMethodBeat.i(17924);
    try
    {
      getCache().clearCache();
      AppMethodBeat.o(17924);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + localIOException.getMessage());
      AppMethodBeat.o(17924);
    }
  }
  
  static FileLruCache getCache()
  {
    try
    {
      AppMethodBeat.i(17921);
      if (urlRedirectCache == null) {
        urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
      }
      FileLruCache localFileLruCache = urlRedirectCache;
      AppMethodBeat.o(17921);
      return localFileLruCache;
    }
    finally {}
  }
  
  /* Error */
  static Uri getRedirectedUri(Uri paramUri)
  {
    // Byte code:
    //   0: sipush 17922
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 17922
    //   13: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 57	android/net/Uri:toString	()Ljava/lang/String;
    //   22: astore_3
    //   23: invokestatic 54	com/facebook/internal/UrlRedirectCache:getCache	()Lcom/facebook/internal/FileLruCache;
    //   26: astore 5
    //   28: iconst_0
    //   29: istore_1
    //   30: aconst_null
    //   31: astore_0
    //   32: aload 5
    //   34: aload_3
    //   35: getstatic 41	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   38: invokevirtual 118	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +88 -> 133
    //   48: iconst_1
    //   49: istore_1
    //   50: new 120	java/io/InputStreamReader
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: astore_3
    //   60: sipush 128
    //   63: newarray char
    //   65: astore_0
    //   66: new 27	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aload_3
    //   76: aload_0
    //   77: iconst_0
    //   78: sipush 128
    //   81: invokevirtual 127	java/io/InputStreamReader:read	([CII)I
    //   84: istore_2
    //   85: iload_2
    //   86: ifle +28 -> 114
    //   89: aload 4
    //   91: aload_0
    //   92: iconst_0
    //   93: iload_2
    //   94: invokevirtual 130	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: goto -23 -> 75
    //   101: astore_0
    //   102: aload_3
    //   103: invokestatic 81	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   106: sipush 17922
    //   109: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: areturn
    //   114: aload_3
    //   115: invokestatic 81	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   118: aload 4
    //   120: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: aload 4
    //   129: astore_3
    //   130: goto -98 -> 32
    //   133: iload_1
    //   134: ifeq +20 -> 154
    //   137: aload_3
    //   138: invokestatic 134	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   141: astore_3
    //   142: aload_0
    //   143: invokestatic 81	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   146: sipush 17922
    //   149: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_3
    //   153: areturn
    //   154: aload_0
    //   155: invokestatic 81	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   158: goto -52 -> 106
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: invokestatic 81	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   168: sipush 17922
    //   171: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    //   176: astore 4
    //   178: aload_3
    //   179: astore_0
    //   180: aload 4
    //   182: astore_3
    //   183: goto -19 -> 164
    //   186: astore_3
    //   187: goto -23 -> 164
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_3
    //   193: goto -91 -> 102
    //   196: astore_3
    //   197: aload_0
    //   198: astore_3
    //   199: goto -97 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramUri	Uri
    //   29	105	1	i	int
    //   84	10	2	j	int
    //   22	131	3	localObject1	Object
    //   161	18	3	localObject2	Object
    //   182	1	3	localObject3	Object
    //   186	1	3	localObject4	Object
    //   192	1	3	localObject5	Object
    //   196	1	3	localIOException	IOException
    //   198	1	3	localUri	Uri
    //   41	87	4	localObject6	Object
    //   176	5	4	localObject7	Object
    //   26	7	5	localFileLruCache	FileLruCache
    // Exception table:
    //   from	to	target	type
    //   60	75	101	java/io/IOException
    //   75	85	101	java/io/IOException
    //   89	98	101	java/io/IOException
    //   114	125	101	java/io/IOException
    //   23	28	161	finally
    //   60	75	176	finally
    //   75	85	176	finally
    //   89	98	176	finally
    //   114	125	176	finally
    //   32	43	186	finally
    //   50	60	186	finally
    //   137	142	186	finally
    //   23	28	190	java/io/IOException
    //   32	43	196	java/io/IOException
    //   50	60	196	java/io/IOException
    //   137	142	196	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.UrlRedirectCache
 * JD-Core Version:    0.7.0.1
 */