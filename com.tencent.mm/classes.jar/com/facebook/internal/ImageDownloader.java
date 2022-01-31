package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader
{
  private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
  private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
  private static WorkQueue cacheReadQueue;
  private static WorkQueue downloadQueue;
  private static Handler handler;
  private static final Map<RequestKey, ImageDownloader.DownloaderContext> pendingRequests;
  
  static
  {
    AppMethodBeat.i(72387);
    downloadQueue = new WorkQueue(8);
    cacheReadQueue = new WorkQueue(2);
    pendingRequests = new HashMap();
    AppMethodBeat.o(72387);
  }
  
  public static boolean cancelRequest(ImageRequest arg0)
  {
    AppMethodBeat.i(72374);
    RequestKey localRequestKey = new RequestKey(???.getImageUri(), ???.getCallerTag());
    for (;;)
    {
      synchronized (pendingRequests)
      {
        ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext)pendingRequests.get(localRequestKey);
        if (localDownloaderContext != null)
        {
          if (localDownloaderContext.workItem.cancel())
          {
            pendingRequests.remove(localRequestKey);
            bool = true;
            AppMethodBeat.o(72374);
            return bool;
          }
          localDownloaderContext.isCancelled = true;
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(72376);
    ImageResponseCache.clearCache(paramContext);
    UrlRedirectCache.clearCache();
    AppMethodBeat.o(72376);
  }
  
  /* Error */
  private static void download(RequestKey paramRequestKey, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 120
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_1
    //   9: istore_2
    //   10: new 122	java/net/URL
    //   13: dup
    //   14: aload_0
    //   15: getfield 126	com/facebook/internal/ImageDownloader$RequestKey:uri	Landroid/net/Uri;
    //   18: invokevirtual 132	android/net/Uri:toString	()Ljava/lang/String;
    //   21: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 139	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 141	java/net/HttpURLConnection
    //   30: astore 4
    //   32: aload 4
    //   34: iconst_0
    //   35: invokevirtual 145	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   38: aload 4
    //   40: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   43: lookupswitch	default:+473->516, 200:+284->327, 301:+186->229, 302:+186->229
    //   77: iconst_1
    //   78: invokevirtual 153	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   81: astore 6
    //   83: aload 6
    //   85: astore_1
    //   86: aload 6
    //   88: astore 5
    //   90: new 155	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   97: astore 8
    //   99: aload 6
    //   101: ifnull +299 -> 400
    //   104: aload 6
    //   106: astore_1
    //   107: aload 6
    //   109: astore 5
    //   111: new 158	java/io/InputStreamReader
    //   114: dup
    //   115: aload 6
    //   117: invokespecial 161	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   120: astore 9
    //   122: aload 6
    //   124: astore_1
    //   125: aload 6
    //   127: astore 5
    //   129: sipush 128
    //   132: newarray char
    //   134: astore 10
    //   136: aload 6
    //   138: astore_1
    //   139: aload 6
    //   141: astore 5
    //   143: aload 9
    //   145: aload 10
    //   147: iconst_0
    //   148: sipush 128
    //   151: invokevirtual 165	java/io/InputStreamReader:read	([CII)I
    //   154: istore_3
    //   155: iload_3
    //   156: ifle +202 -> 358
    //   159: aload 6
    //   161: astore_1
    //   162: aload 6
    //   164: astore 5
    //   166: aload 8
    //   168: aload 10
    //   170: iconst_0
    //   171: iload_3
    //   172: invokevirtual 169	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: goto -40 -> 136
    //   179: astore 6
    //   181: iconst_1
    //   182: istore_2
    //   183: aload 4
    //   185: astore 5
    //   187: aload_1
    //   188: astore 4
    //   190: aload 6
    //   192: astore_1
    //   193: aload 4
    //   195: invokestatic 175	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   198: aload 5
    //   200: invokestatic 179	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   203: aload 7
    //   205: astore 5
    //   207: aload_1
    //   208: astore 4
    //   210: iload_2
    //   211: ifeq +12 -> 223
    //   214: aload_0
    //   215: aload 4
    //   217: aload 5
    //   219: iconst_0
    //   220: invokestatic 183	com/facebook/internal/ImageDownloader:issueResponse	(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
    //   223: ldc 120
    //   225: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: aload 4
    //   231: ldc 185
    //   233: invokevirtual 189	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore_1
    //   237: aload_1
    //   238: invokestatic 193	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   241: ifne +262 -> 503
    //   244: aload_1
    //   245: invokestatic 197	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 126	com/facebook/internal/ImageDownloader$RequestKey:uri	Landroid/net/Uri;
    //   253: aload_1
    //   254: invokestatic 201	com/facebook/internal/UrlRedirectCache:cacheUriRedirect	(Landroid/net/Uri;Landroid/net/Uri;)V
    //   257: aload_0
    //   258: invokestatic 205	com/facebook/internal/ImageDownloader:removePendingRequest	(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
    //   261: astore 5
    //   263: aload 5
    //   265: ifnull +32 -> 297
    //   268: aload 5
    //   270: getfield 106	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
    //   273: ifne +24 -> 297
    //   276: aload 5
    //   278: getfield 209	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
    //   281: new 12	com/facebook/internal/ImageDownloader$RequestKey
    //   284: dup
    //   285: aload_1
    //   286: aload_0
    //   287: getfield 213	com/facebook/internal/ImageDownloader$RequestKey:tag	Ljava/lang/Object;
    //   290: invokespecial 83	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Landroid/net/Uri;Ljava/lang/Object;)V
    //   293: iconst_0
    //   294: invokestatic 217	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
    //   297: iconst_0
    //   298: istore_2
    //   299: aconst_null
    //   300: astore_1
    //   301: aconst_null
    //   302: astore 5
    //   304: aconst_null
    //   305: astore 6
    //   307: aload 6
    //   309: invokestatic 175	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   312: aload 4
    //   314: invokestatic 179	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   317: aload 5
    //   319: astore 4
    //   321: aload_1
    //   322: astore 5
    //   324: goto -114 -> 210
    //   327: aload_1
    //   328: aload 4
    //   330: invokestatic 221	com/facebook/internal/ImageResponseCache:interceptAndCacheImageStream	(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   333: astore 6
    //   335: aload 6
    //   337: astore_1
    //   338: aload 6
    //   340: astore 5
    //   342: aload 6
    //   344: invokestatic 227	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   347: astore 8
    //   349: aconst_null
    //   350: astore 5
    //   352: aload 8
    //   354: astore_1
    //   355: goto -48 -> 307
    //   358: aload 6
    //   360: astore_1
    //   361: aload 6
    //   363: astore 5
    //   365: aload 9
    //   367: invokestatic 175	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   370: aload 6
    //   372: astore_1
    //   373: aload 6
    //   375: astore 5
    //   377: new 229	com/facebook/FacebookException
    //   380: dup
    //   381: aload 8
    //   383: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokespecial 231	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   389: astore 8
    //   391: aconst_null
    //   392: astore_1
    //   393: aload 8
    //   395: astore 5
    //   397: goto -90 -> 307
    //   400: aload 6
    //   402: astore_1
    //   403: aload 6
    //   405: astore 5
    //   407: aload 8
    //   409: ldc 233
    //   411: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: goto -45 -> 370
    //   418: astore_0
    //   419: aload 4
    //   421: astore_1
    //   422: aload 5
    //   424: invokestatic 175	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   427: aload_1
    //   428: invokestatic 179	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   431: ldc 120
    //   433: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: aload_0
    //   437: athrow
    //   438: astore_0
    //   439: aconst_null
    //   440: astore 5
    //   442: aconst_null
    //   443: astore_1
    //   444: goto -22 -> 422
    //   447: astore_0
    //   448: aconst_null
    //   449: astore 5
    //   451: aload 4
    //   453: astore_1
    //   454: goto -32 -> 422
    //   457: astore_1
    //   458: iconst_1
    //   459: istore_2
    //   460: aconst_null
    //   461: astore 4
    //   463: aconst_null
    //   464: astore 5
    //   466: goto -273 -> 193
    //   469: astore_1
    //   470: iconst_1
    //   471: istore_2
    //   472: aconst_null
    //   473: astore 6
    //   475: aload 4
    //   477: astore 5
    //   479: aload 6
    //   481: astore 4
    //   483: goto -290 -> 193
    //   486: astore_1
    //   487: iconst_0
    //   488: istore_2
    //   489: aconst_null
    //   490: astore 6
    //   492: aload 4
    //   494: astore 5
    //   496: aload 6
    //   498: astore 4
    //   500: goto -307 -> 193
    //   503: iconst_0
    //   504: istore_2
    //   505: aconst_null
    //   506: astore_1
    //   507: aconst_null
    //   508: astore 5
    //   510: aconst_null
    //   511: astore 6
    //   513: goto -206 -> 307
    //   516: goto -440 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramRequestKey	RequestKey
    //   0	519	1	paramContext	Context
    //   9	496	2	i	int
    //   154	18	3	j	int
    //   30	469	4	localObject1	Object
    //   88	421	5	localObject2	Object
    //   81	82	6	localInputStream	java.io.InputStream
    //   179	12	6	localIOException	java.io.IOException
    //   305	207	6	localObject3	Object
    //   1	203	7	localObject4	Object
    //   97	311	8	localObject5	Object
    //   120	246	9	localInputStreamReader	java.io.InputStreamReader
    //   134	35	10	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   90	99	179	java/io/IOException
    //   111	122	179	java/io/IOException
    //   129	136	179	java/io/IOException
    //   143	155	179	java/io/IOException
    //   166	176	179	java/io/IOException
    //   342	349	179	java/io/IOException
    //   365	370	179	java/io/IOException
    //   377	391	179	java/io/IOException
    //   407	415	179	java/io/IOException
    //   90	99	418	finally
    //   111	122	418	finally
    //   129	136	418	finally
    //   143	155	418	finally
    //   166	176	418	finally
    //   342	349	418	finally
    //   365	370	418	finally
    //   377	391	418	finally
    //   407	415	418	finally
    //   10	32	438	finally
    //   32	76	447	finally
    //   76	83	447	finally
    //   229	263	447	finally
    //   268	297	447	finally
    //   327	335	447	finally
    //   10	32	457	java/io/IOException
    //   32	76	469	java/io/IOException
    //   76	83	469	java/io/IOException
    //   327	335	469	java/io/IOException
    //   229	263	486	java/io/IOException
    //   268	297	486	java/io/IOException
  }
  
  public static void downloadAsync(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(72373);
    if (paramImageRequest == null)
    {
      AppMethodBeat.o(72373);
      return;
    }
    RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    synchronized (pendingRequests)
    {
      ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext)pendingRequests.get(localRequestKey);
      if (localDownloaderContext != null)
      {
        localDownloaderContext.request = paramImageRequest;
        localDownloaderContext.isCancelled = false;
        localDownloaderContext.workItem.moveToFront();
        AppMethodBeat.o(72373);
        return;
      }
      enqueueCacheRead(paramImageRequest, localRequestKey, paramImageRequest.isCachedRedirectAllowed());
    }
  }
  
  private static void enqueueCacheRead(ImageRequest paramImageRequest, RequestKey paramRequestKey, boolean paramBoolean)
  {
    AppMethodBeat.i(72377);
    enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new ImageDownloader.CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
    AppMethodBeat.o(72377);
  }
  
  private static void enqueueDownload(ImageRequest paramImageRequest, RequestKey paramRequestKey)
  {
    AppMethodBeat.i(72378);
    enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new ImageDownloader.DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
    AppMethodBeat.o(72378);
  }
  
  private static void enqueueRequest(ImageRequest paramImageRequest, RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable)
  {
    AppMethodBeat.i(72379);
    synchronized (pendingRequests)
    {
      ImageDownloader.DownloaderContext localDownloaderContext = new ImageDownloader.DownloaderContext(null);
      localDownloaderContext.request = paramImageRequest;
      pendingRequests.put(paramRequestKey, localDownloaderContext);
      localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
      AppMethodBeat.o(72379);
      return;
    }
  }
  
  private static Handler getHandler()
  {
    try
    {
      AppMethodBeat.i(72383);
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      AppMethodBeat.o(72383);
      return localHandler;
    }
    finally {}
  }
  
  private static void issueResponse(RequestKey paramRequestKey, Exception paramException, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(72380);
    paramRequestKey = removePendingRequest(paramRequestKey);
    if ((paramRequestKey != null) && (!paramRequestKey.isCancelled))
    {
      paramRequestKey = paramRequestKey.request;
      ImageRequest.Callback localCallback = paramRequestKey.getCallback();
      if (localCallback != null) {
        getHandler().post(new ImageDownloader.1(paramRequestKey, paramException, paramBoolean, paramBitmap, localCallback));
      }
    }
    AppMethodBeat.o(72380);
  }
  
  public static void prioritizeRequest(ImageRequest arg0)
  {
    AppMethodBeat.i(72375);
    Object localObject1 = new RequestKey(???.getImageUri(), ???.getCallerTag());
    synchronized (pendingRequests)
    {
      localObject1 = (ImageDownloader.DownloaderContext)pendingRequests.get(localObject1);
      if (localObject1 != null) {
        ((ImageDownloader.DownloaderContext)localObject1).workItem.moveToFront();
      }
      AppMethodBeat.o(72375);
      return;
    }
  }
  
  private static void readFromCache(RequestKey paramRequestKey, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(72381);
    Object localObject;
    if (paramBoolean)
    {
      localObject = UrlRedirectCache.getRedirectedUri(paramRequestKey.uri);
      if (localObject != null)
      {
        localObject = ImageResponseCache.getCachedImageStream((Uri)localObject, paramContext);
        paramBoolean = bool;
        if (localObject != null) {
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean) {}
      for (paramContext = ImageResponseCache.getCachedImageStream(paramRequestKey.uri, paramContext);; paramContext = (Context)localObject)
      {
        if (paramContext != null)
        {
          localObject = BitmapFactory.decodeStream(paramContext);
          Utility.closeQuietly(paramContext);
          issueResponse(paramRequestKey, null, (Bitmap)localObject, paramBoolean);
          AppMethodBeat.o(72381);
          return;
        }
        paramContext = removePendingRequest(paramRequestKey);
        if ((paramContext != null) && (!paramContext.isCancelled)) {
          enqueueDownload(paramContext.request, paramRequestKey);
        }
        AppMethodBeat.o(72381);
        return;
      }
      paramBoolean = false;
      localObject = null;
    }
  }
  
  private static ImageDownloader.DownloaderContext removePendingRequest(RequestKey paramRequestKey)
  {
    AppMethodBeat.i(72384);
    synchronized (pendingRequests)
    {
      paramRequestKey = (ImageDownloader.DownloaderContext)pendingRequests.remove(paramRequestKey);
      AppMethodBeat.o(72384);
      return paramRequestKey;
    }
  }
  
  static class RequestKey
  {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    Object tag;
    Uri uri;
    
    RequestKey(Uri paramUri, Object paramObject)
    {
      this.uri = paramUri;
      this.tag = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof RequestKey))
        {
          paramObject = (RequestKey)paramObject;
          bool1 = bool2;
          if (paramObject.uri == this.uri)
          {
            bool1 = bool2;
            if (paramObject.tag == this.tag) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(72372);
      int i = this.uri.hashCode();
      int j = this.tag.hashCode();
      AppMethodBeat.o(72372);
      return (i + 1073) * 37 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */