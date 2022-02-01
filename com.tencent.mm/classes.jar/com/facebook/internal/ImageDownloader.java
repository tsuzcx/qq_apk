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
  private static final Map<RequestKey, DownloaderContext> pendingRequests;
  
  static
  {
    AppMethodBeat.i(17823);
    downloadQueue = new WorkQueue(8);
    cacheReadQueue = new WorkQueue(2);
    pendingRequests = new HashMap();
    AppMethodBeat.o(17823);
  }
  
  public static boolean cancelRequest(ImageRequest arg0)
  {
    AppMethodBeat.i(17810);
    RequestKey localRequestKey = new RequestKey(???.getImageUri(), ???.getCallerTag());
    for (;;)
    {
      synchronized (pendingRequests)
      {
        DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
        if (localDownloaderContext != null)
        {
          if (localDownloaderContext.workItem.cancel())
          {
            pendingRequests.remove(localRequestKey);
            bool = true;
            AppMethodBeat.o(17810);
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
    AppMethodBeat.i(17812);
    ImageResponseCache.clearCache(paramContext);
    UrlRedirectCache.clearCache();
    AppMethodBeat.o(17812);
  }
  
  /* Error */
  private static void download(RequestKey paramRequestKey, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: sipush 17818
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_1
    //   10: istore_2
    //   11: new 121	java/net/URL
    //   14: dup
    //   15: aload_0
    //   16: getfield 125	com/facebook/internal/ImageDownloader$RequestKey:uri	Landroid/net/Uri;
    //   19: invokevirtual 131	android/net/Uri:toString	()Ljava/lang/String;
    //   22: invokespecial 134	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 140	java/net/HttpURLConnection
    //   31: astore 4
    //   33: aload 4
    //   35: iconst_0
    //   36: invokevirtual 144	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   39: aload 4
    //   41: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   44: lookupswitch	default:+478->522, 200:+288->332, 301:+190->234, 302:+190->234
    //   81: iconst_1
    //   82: invokevirtual 152	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   85: astore 6
    //   87: aload 6
    //   89: astore_1
    //   90: aload 6
    //   92: astore 5
    //   94: new 154	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   101: astore 8
    //   103: aload 6
    //   105: ifnull +300 -> 405
    //   108: aload 6
    //   110: astore_1
    //   111: aload 6
    //   113: astore 5
    //   115: new 157	java/io/InputStreamReader
    //   118: dup
    //   119: aload 6
    //   121: invokespecial 160	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   124: astore 9
    //   126: aload 6
    //   128: astore_1
    //   129: aload 6
    //   131: astore 5
    //   133: sipush 128
    //   136: newarray char
    //   138: astore 10
    //   140: aload 6
    //   142: astore_1
    //   143: aload 6
    //   145: astore 5
    //   147: aload 9
    //   149: aload 10
    //   151: iconst_0
    //   152: sipush 128
    //   155: invokevirtual 164	java/io/InputStreamReader:read	([CII)I
    //   158: istore_3
    //   159: iload_3
    //   160: ifle +203 -> 363
    //   163: aload 6
    //   165: astore_1
    //   166: aload 6
    //   168: astore 5
    //   170: aload 8
    //   172: aload 10
    //   174: iconst_0
    //   175: iload_3
    //   176: invokevirtual 168	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: goto -40 -> 140
    //   183: astore 6
    //   185: iconst_1
    //   186: istore_2
    //   187: aload 4
    //   189: astore 5
    //   191: aload_1
    //   192: astore 4
    //   194: aload 6
    //   196: astore_1
    //   197: aload 4
    //   199: invokestatic 174	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   202: aload 5
    //   204: invokestatic 178	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   207: aload 7
    //   209: astore 5
    //   211: aload_1
    //   212: astore 4
    //   214: iload_2
    //   215: ifeq +12 -> 227
    //   218: aload_0
    //   219: aload 4
    //   221: aload 5
    //   223: iconst_0
    //   224: invokestatic 182	com/facebook/internal/ImageDownloader:issueResponse	(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
    //   227: sipush 17818
    //   230: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: return
    //   234: aload 4
    //   236: ldc 184
    //   238: invokevirtual 188	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore_1
    //   242: aload_1
    //   243: invokestatic 192	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   246: ifne +263 -> 509
    //   249: aload_1
    //   250: invokestatic 196	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   253: astore_1
    //   254: aload_0
    //   255: getfield 125	com/facebook/internal/ImageDownloader$RequestKey:uri	Landroid/net/Uri;
    //   258: aload_1
    //   259: invokestatic 200	com/facebook/internal/UrlRedirectCache:cacheUriRedirect	(Landroid/net/Uri;Landroid/net/Uri;)V
    //   262: aload_0
    //   263: invokestatic 204	com/facebook/internal/ImageDownloader:removePendingRequest	(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
    //   266: astore 5
    //   268: aload 5
    //   270: ifnull +32 -> 302
    //   273: aload 5
    //   275: getfield 107	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
    //   278: ifne +24 -> 302
    //   281: aload 5
    //   283: getfield 208	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
    //   286: new 17	com/facebook/internal/ImageDownloader$RequestKey
    //   289: dup
    //   290: aload_1
    //   291: aload_0
    //   292: getfield 212	com/facebook/internal/ImageDownloader$RequestKey:tag	Ljava/lang/Object;
    //   295: invokespecial 84	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Landroid/net/Uri;Ljava/lang/Object;)V
    //   298: iconst_0
    //   299: invokestatic 216	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
    //   302: iconst_0
    //   303: istore_2
    //   304: aconst_null
    //   305: astore_1
    //   306: aconst_null
    //   307: astore 5
    //   309: aconst_null
    //   310: astore 6
    //   312: aload 6
    //   314: invokestatic 174	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   317: aload 4
    //   319: invokestatic 178	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   322: aload 5
    //   324: astore 4
    //   326: aload_1
    //   327: astore 5
    //   329: goto -115 -> 214
    //   332: aload_1
    //   333: aload 4
    //   335: invokestatic 220	com/facebook/internal/ImageResponseCache:interceptAndCacheImageStream	(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   338: astore 6
    //   340: aload 6
    //   342: astore_1
    //   343: aload 6
    //   345: astore 5
    //   347: aload 6
    //   349: invokestatic 226	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   352: astore 8
    //   354: aconst_null
    //   355: astore 5
    //   357: aload 8
    //   359: astore_1
    //   360: goto -48 -> 312
    //   363: aload 6
    //   365: astore_1
    //   366: aload 6
    //   368: astore 5
    //   370: aload 9
    //   372: invokestatic 174	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   375: aload 6
    //   377: astore_1
    //   378: aload 6
    //   380: astore 5
    //   382: new 228	com/facebook/FacebookException
    //   385: dup
    //   386: aload 8
    //   388: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokespecial 230	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   394: astore 8
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 8
    //   400: astore 5
    //   402: goto -90 -> 312
    //   405: aload 6
    //   407: astore_1
    //   408: aload 6
    //   410: astore 5
    //   412: aload 8
    //   414: ldc 232
    //   416: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: goto -45 -> 375
    //   423: astore_0
    //   424: aload 4
    //   426: astore_1
    //   427: aload 5
    //   429: invokestatic 174	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   432: aload_1
    //   433: invokestatic 178	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   436: sipush 17818
    //   439: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: aload_0
    //   443: athrow
    //   444: astore_0
    //   445: aconst_null
    //   446: astore 5
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -23 -> 427
    //   453: astore_0
    //   454: aconst_null
    //   455: astore 5
    //   457: aload 4
    //   459: astore_1
    //   460: goto -33 -> 427
    //   463: astore_1
    //   464: iconst_1
    //   465: istore_2
    //   466: aconst_null
    //   467: astore 4
    //   469: aconst_null
    //   470: astore 5
    //   472: goto -275 -> 197
    //   475: astore_1
    //   476: iconst_1
    //   477: istore_2
    //   478: aconst_null
    //   479: astore 6
    //   481: aload 4
    //   483: astore 5
    //   485: aload 6
    //   487: astore 4
    //   489: goto -292 -> 197
    //   492: astore_1
    //   493: iconst_0
    //   494: istore_2
    //   495: aconst_null
    //   496: astore 6
    //   498: aload 4
    //   500: astore 5
    //   502: aload 6
    //   504: astore 4
    //   506: goto -309 -> 197
    //   509: iconst_0
    //   510: istore_2
    //   511: aconst_null
    //   512: astore_1
    //   513: aconst_null
    //   514: astore 5
    //   516: aconst_null
    //   517: astore 6
    //   519: goto -207 -> 312
    //   522: goto -442 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	paramRequestKey	RequestKey
    //   0	525	1	paramContext	Context
    //   10	501	2	i	int
    //   158	18	3	j	int
    //   31	474	4	localObject1	Object
    //   92	423	5	localObject2	Object
    //   85	82	6	localInputStream	java.io.InputStream
    //   183	12	6	localIOException	java.io.IOException
    //   310	208	6	localObject3	Object
    //   1	207	7	localObject4	Object
    //   101	312	8	localObject5	Object
    //   124	247	9	localInputStreamReader	java.io.InputStreamReader
    //   138	35	10	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   94	103	183	java/io/IOException
    //   115	126	183	java/io/IOException
    //   133	140	183	java/io/IOException
    //   147	159	183	java/io/IOException
    //   170	180	183	java/io/IOException
    //   347	354	183	java/io/IOException
    //   370	375	183	java/io/IOException
    //   382	396	183	java/io/IOException
    //   412	420	183	java/io/IOException
    //   94	103	423	finally
    //   115	126	423	finally
    //   133	140	423	finally
    //   147	159	423	finally
    //   170	180	423	finally
    //   347	354	423	finally
    //   370	375	423	finally
    //   382	396	423	finally
    //   412	420	423	finally
    //   11	33	444	finally
    //   33	80	453	finally
    //   80	87	453	finally
    //   234	268	453	finally
    //   273	302	453	finally
    //   332	340	453	finally
    //   11	33	463	java/io/IOException
    //   33	80	475	java/io/IOException
    //   80	87	475	java/io/IOException
    //   332	340	475	java/io/IOException
    //   234	268	492	java/io/IOException
    //   273	302	492	java/io/IOException
  }
  
  public static void downloadAsync(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(17809);
    if (paramImageRequest == null)
    {
      AppMethodBeat.o(17809);
      return;
    }
    RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    synchronized (pendingRequests)
    {
      DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
      if (localDownloaderContext != null)
      {
        localDownloaderContext.request = paramImageRequest;
        localDownloaderContext.isCancelled = false;
        localDownloaderContext.workItem.moveToFront();
        AppMethodBeat.o(17809);
        return;
      }
      enqueueCacheRead(paramImageRequest, localRequestKey, paramImageRequest.isCachedRedirectAllowed());
    }
  }
  
  private static void enqueueCacheRead(ImageRequest paramImageRequest, RequestKey paramRequestKey, boolean paramBoolean)
  {
    AppMethodBeat.i(17813);
    enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
    AppMethodBeat.o(17813);
  }
  
  private static void enqueueDownload(ImageRequest paramImageRequest, RequestKey paramRequestKey)
  {
    AppMethodBeat.i(17814);
    enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
    AppMethodBeat.o(17814);
  }
  
  private static void enqueueRequest(ImageRequest paramImageRequest, RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable)
  {
    AppMethodBeat.i(17815);
    synchronized (pendingRequests)
    {
      DownloaderContext localDownloaderContext = new DownloaderContext(null);
      localDownloaderContext.request = paramImageRequest;
      pendingRequests.put(paramRequestKey, localDownloaderContext);
      localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
      AppMethodBeat.o(17815);
      return;
    }
  }
  
  private static Handler getHandler()
  {
    try
    {
      AppMethodBeat.i(17819);
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      AppMethodBeat.o(17819);
      return localHandler;
    }
    finally {}
  }
  
  private static void issueResponse(RequestKey paramRequestKey, final Exception paramException, final Bitmap paramBitmap, final boolean paramBoolean)
  {
    AppMethodBeat.i(17816);
    paramRequestKey = removePendingRequest(paramRequestKey);
    if ((paramRequestKey != null) && (!paramRequestKey.isCancelled))
    {
      paramRequestKey = paramRequestKey.request;
      final ImageRequest.Callback localCallback = paramRequestKey.getCallback();
      if (localCallback != null) {
        getHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(17805);
            ImageResponse localImageResponse = new ImageResponse(this.val$request, paramException, paramBoolean, paramBitmap);
            localCallback.onCompleted(localImageResponse);
            AppMethodBeat.o(17805);
          }
        });
      }
    }
    AppMethodBeat.o(17816);
  }
  
  public static void prioritizeRequest(ImageRequest arg0)
  {
    AppMethodBeat.i(17811);
    Object localObject1 = new RequestKey(???.getImageUri(), ???.getCallerTag());
    synchronized (pendingRequests)
    {
      localObject1 = (DownloaderContext)pendingRequests.get(localObject1);
      if (localObject1 != null) {
        ((DownloaderContext)localObject1).workItem.moveToFront();
      }
      AppMethodBeat.o(17811);
      return;
    }
  }
  
  private static void readFromCache(RequestKey paramRequestKey, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(17817);
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
          AppMethodBeat.o(17817);
          return;
        }
        paramContext = removePendingRequest(paramRequestKey);
        if ((paramContext != null) && (!paramContext.isCancelled)) {
          enqueueDownload(paramContext.request, paramRequestKey);
        }
        AppMethodBeat.o(17817);
        return;
      }
      paramBoolean = false;
      localObject = null;
    }
  }
  
  private static DownloaderContext removePendingRequest(RequestKey paramRequestKey)
  {
    AppMethodBeat.i(17820);
    synchronized (pendingRequests)
    {
      paramRequestKey = (DownloaderContext)pendingRequests.remove(paramRequestKey);
      AppMethodBeat.o(17820);
      return paramRequestKey;
    }
  }
  
  static class CacheReadWorkItem
    implements Runnable
  {
    private boolean allowCachedRedirects;
    private Context context;
    private ImageDownloader.RequestKey key;
    
    CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
    {
      this.context = paramContext;
      this.key = paramRequestKey;
      this.allowCachedRedirects = paramBoolean;
    }
    
    public void run()
    {
      AppMethodBeat.i(17806);
      ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
      AppMethodBeat.o(17806);
    }
  }
  
  static class DownloadImageWorkItem
    implements Runnable
  {
    private Context context;
    private ImageDownloader.RequestKey key;
    
    DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey)
    {
      this.context = paramContext;
      this.key = paramRequestKey;
    }
    
    public void run()
    {
      AppMethodBeat.i(17807);
      ImageDownloader.access$200(this.key, this.context);
      AppMethodBeat.o(17807);
    }
  }
  
  static class DownloaderContext
  {
    boolean isCancelled;
    ImageRequest request;
    WorkQueue.WorkItem workItem;
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
      AppMethodBeat.i(17808);
      int i = this.uri.hashCode();
      int j = this.tag.hashCode();
      AppMethodBeat.o(17808);
      return (i + 1073) * 37 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */