package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.file.Md5FileNameGenerator;
import com.danikula.videocache.file.TotalCountLruDiskUsage;
import com.danikula.videocache.file.TotalSizeLruDiskUsage;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpProxyCacheServer
{
  private static final String PROXY_HOST = "127.0.0.1";
  private final Object clientsLock;
  private final Map<String, HttpProxyCacheServerClients> clientsMap;
  private final Config config;
  private final int port;
  private final ServerSocket serverSocket;
  private final ExecutorService socketProcessor;
  private final Thread waitConnectionThread;
  
  public HttpProxyCacheServer(Context paramContext)
  {
    this(Builder.access$000(new Builder(paramContext)));
    AppMethodBeat.i(215833);
    AppMethodBeat.o(215833);
  }
  
  private HttpProxyCacheServer(Config paramConfig)
  {
    AppMethodBeat.i(183572);
    this.clientsLock = new Object();
    this.socketProcessor = Executors.newFixedThreadPool(8);
    this.clientsMap = new ConcurrentHashMap();
    this.config = ((Config)Preconditions.checkNotNull(paramConfig));
    try
    {
      this.serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
      this.port = this.serverSocket.getLocalPort();
      IgnoreHostProxySelector.install("127.0.0.1", this.port);
      paramConfig = new CountDownLatch(1);
      this.waitConnectionThread = new Thread(new WaitRequestsRunnable(paramConfig));
      this.waitConnectionThread.start();
      paramConfig.await();
      AppMethodBeat.o(183572);
      return;
    }
    catch (InterruptedException paramConfig)
    {
      this.socketProcessor.shutdown();
      paramConfig = new IllegalStateException("Error starting local proxy server", paramConfig);
      AppMethodBeat.o(183572);
      throw paramConfig;
    }
    catch (IOException paramConfig)
    {
      label137:
      break label137;
    }
  }
  
  private String appendToProxyUrl(String paramString)
  {
    AppMethodBeat.i(215841);
    paramString = String.format(Locale.US, "http://%s:%d/%s", new Object[] { "127.0.0.1", Integer.valueOf(this.port), ProxyCacheUtils.encode(paramString) });
    AppMethodBeat.o(215841);
    return paramString;
  }
  
  private void closeSocket(Socket paramSocket)
  {
    AppMethodBeat.i(215849);
    try
    {
      if (!paramSocket.isClosed()) {
        paramSocket.close();
      }
      AppMethodBeat.o(215849);
      return;
    }
    catch (IOException paramSocket)
    {
      onError(new ProxyCacheException("Error closing socket", paramSocket));
      AppMethodBeat.o(215849);
    }
  }
  
  private void closeSocketInput(Socket paramSocket)
  {
    AppMethodBeat.i(215847);
    try
    {
      if (!paramSocket.isInputShutdown()) {
        paramSocket.shutdownInput();
      }
      AppMethodBeat.o(215847);
      return;
    }
    catch (SocketException paramSocket)
    {
      Logger.debug("Releasing input stream… Socket is closed by client.");
      AppMethodBeat.o(215847);
      return;
    }
    catch (IOException paramSocket)
    {
      onError(new ProxyCacheException("Error closing socket input stream", paramSocket));
      AppMethodBeat.o(215847);
    }
  }
  
  private void closeSocketOutput(Socket paramSocket)
  {
    AppMethodBeat.i(215848);
    try
    {
      if (!paramSocket.isOutputShutdown()) {
        paramSocket.shutdownOutput();
      }
      AppMethodBeat.o(215848);
      return;
    }
    catch (IOException paramSocket)
    {
      Logger.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.");
      AppMethodBeat.o(215848);
    }
  }
  
  private HttpProxyCacheServerClients getClients(String paramString)
  {
    AppMethodBeat.i(183574);
    synchronized (this.clientsLock)
    {
      HttpProxyCacheServerClients localHttpProxyCacheServerClients2 = (HttpProxyCacheServerClients)this.clientsMap.get(paramString);
      HttpProxyCacheServerClients localHttpProxyCacheServerClients1 = localHttpProxyCacheServerClients2;
      if (localHttpProxyCacheServerClients2 == null)
      {
        localHttpProxyCacheServerClients1 = new HttpProxyCacheServerClients(paramString, this.config);
        this.clientsMap.put(paramString, localHttpProxyCacheServerClients1);
      }
      AppMethodBeat.o(183574);
      return localHttpProxyCacheServerClients1;
    }
  }
  
  private int getClientsCount()
  {
    AppMethodBeat.i(183575);
    synchronized (this.clientsLock)
    {
      Iterator localIterator = this.clientsMap.values().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((HttpProxyCacheServerClients)localIterator.next()).getClientsCount() + i) {}
      AppMethodBeat.o(183575);
      return i;
    }
  }
  
  private void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(215850);
    Logger.error("HttpProxyCacheServer error");
    AppMethodBeat.o(215850);
  }
  
  /* Error */
  private void processSocket(Socket paramSocket)
  {
    // Byte code:
    //   0: ldc_w 288
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 292	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   10: invokestatic 298	com/danikula/videocache/GetRequest:read	(Ljava/io/InputStream;)Lcom/danikula/videocache/GetRequest;
    //   13: astore_2
    //   14: ldc_w 300
    //   17: aload_2
    //   18: invokestatic 303	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: aload_2
    //   29: getfield 309	com/danikula/videocache/GetRequest:uri	Ljava/lang/String;
    //   32: invokestatic 312	com/danikula/videocache/ProxyCacheUtils:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokespecial 314	com/danikula/videocache/HttpProxyCacheServer:getClients	(Ljava/lang/String;)Lcom/danikula/videocache/HttpProxyCacheServerClients;
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 318	com/danikula/videocache/HttpProxyCacheServerClients:processRequest	(Lcom/danikula/videocache/GetRequest;Ljava/net/Socket;)V
    //   43: aload_0
    //   44: aload_1
    //   45: invokespecial 321	com/danikula/videocache/HttpProxyCacheServer:releaseSocket	(Ljava/net/Socket;)V
    //   48: new 323	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 325
    //   55: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: invokespecial 328	com/danikula/videocache/HttpProxyCacheServer:getClientsCount	()I
    //   62: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   71: ldc_w 288
    //   74: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore_2
    //   79: ldc_w 338
    //   82: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 321	com/danikula/videocache/HttpProxyCacheServer:releaseSocket	(Ljava/net/Socket;)V
    //   90: new 323	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 325
    //   97: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: invokespecial 328	com/danikula/videocache/HttpProxyCacheServer:getClientsCount	()I
    //   104: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   113: ldc_w 288
    //   116: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_2
    //   121: aload_0
    //   122: new 201	com/danikula/videocache/ProxyCacheException
    //   125: dup
    //   126: ldc_w 340
    //   129: aload_2
    //   130: invokespecial 204	com/danikula/videocache/ProxyCacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: invokespecial 208	com/danikula/videocache/HttpProxyCacheServer:onError	(Ljava/lang/Throwable;)V
    //   136: aload_0
    //   137: aload_1
    //   138: invokespecial 321	com/danikula/videocache/HttpProxyCacheServer:releaseSocket	(Ljava/net/Socket;)V
    //   141: new 323	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 325
    //   148: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokespecial 328	com/danikula/videocache/HttpProxyCacheServer:getClientsCount	()I
    //   155: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   164: ldc_w 288
    //   167: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_2
    //   172: aload_0
    //   173: aload_1
    //   174: invokespecial 321	com/danikula/videocache/HttpProxyCacheServer:releaseSocket	(Ljava/net/Socket;)V
    //   177: new 323	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 325
    //   184: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: invokespecial 328	com/danikula/videocache/HttpProxyCacheServer:getClientsCount	()I
    //   191: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 226	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   200: ldc_w 288
    //   203: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: athrow
    //   208: astore_2
    //   209: goto -88 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	HttpProxyCacheServer
    //   0	212	1	paramSocket	Socket
    //   13	26	2	localGetRequest	GetRequest
    //   78	1	2	localSocketException	SocketException
    //   120	10	2	localProxyCacheException	ProxyCacheException
    //   171	36	2	localObject	Object
    //   208	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   6	43	78	java/net/SocketException
    //   6	43	120	com/danikula/videocache/ProxyCacheException
    //   6	43	171	finally
    //   79	85	171	finally
    //   121	136	171	finally
    //   6	43	208	java/io/IOException
  }
  
  private void releaseSocket(Socket paramSocket)
  {
    AppMethodBeat.i(183576);
    closeSocketInput(paramSocket);
    closeSocketOutput(paramSocket);
    closeSocket(paramSocket);
    AppMethodBeat.o(183576);
  }
  
  private void shutdownClients()
  {
    AppMethodBeat.i(215844);
    synchronized (this.clientsLock)
    {
      Iterator localIterator = this.clientsMap.values().iterator();
      if (localIterator.hasNext()) {
        ((HttpProxyCacheServerClients)localIterator.next()).shutdown();
      }
    }
    this.clientsMap.clear();
    AppMethodBeat.o(215844);
  }
  
  private void touchFileSafely(File paramFile)
  {
    AppMethodBeat.i(215843);
    try
    {
      this.config.diskUsage.touch(paramFile);
      AppMethodBeat.o(215843);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.error("Error touching file ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(215843);
    }
  }
  
  private void waitForRequest()
  {
    AppMethodBeat.i(215845);
    try
    {
      while (!Thread.currentThread().isInterrupted())
      {
        Socket localSocket = this.serverSocket.accept();
        Logger.debug("Accept new socket ".concat(String.valueOf(localSocket)));
        this.socketProcessor.submit(new SocketProcessorRunnable(localSocket));
      }
      AppMethodBeat.o(215845);
    }
    catch (IOException localIOException)
    {
      onError(new ProxyCacheException("Error during waiting connection", localIOException));
      AppMethodBeat.o(215845);
      return;
    }
  }
  
  public File getCacheFile(String paramString)
  {
    AppMethodBeat.i(183573);
    paramString = new File(this.config.cacheRoot, this.config.fileNameGenerator.generate(paramString));
    AppMethodBeat.o(183573);
    return paramString;
  }
  
  public File getCacheRoot()
  {
    return this.config.cacheRoot;
  }
  
  public String getProxyUrl(String paramString)
  {
    AppMethodBeat.i(215834);
    paramString = getProxyUrl(paramString, true);
    AppMethodBeat.o(215834);
    return paramString;
  }
  
  public String getProxyUrl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215835);
    if ((paramBoolean) && (getCacheFile(paramString).exists()))
    {
      paramString = getCacheFile(paramString);
      touchFileSafely(paramString);
      paramString = Uri.fromFile(paramString).toString();
      AppMethodBeat.o(215835);
      return paramString;
    }
    paramString = appendToProxyUrl(paramString);
    AppMethodBeat.o(215835);
    return paramString;
  }
  
  public File getTempCacheFile(String paramString)
  {
    AppMethodBeat.i(215842);
    paramString = new File(this.config.cacheRoot, this.config.fileNameGenerator.generate(paramString) + ".download");
    AppMethodBeat.o(215842);
    return paramString;
  }
  
  public boolean isCached(String paramString)
  {
    AppMethodBeat.i(215839);
    Preconditions.checkNotNull(paramString, "Url can't be null!");
    boolean bool = getCacheFile(paramString).exists();
    AppMethodBeat.o(215839);
    return bool;
  }
  
  public void registerCacheListener(CacheListener paramCacheListener, String paramString)
  {
    AppMethodBeat.i(215836);
    Preconditions.checkAllNotNull(new Object[] { paramCacheListener, paramString });
    synchronized (this.clientsLock)
    {
      try
      {
        getClients(paramString).registerCacheListener(paramCacheListener);
        AppMethodBeat.o(215836);
        return;
      }
      catch (ProxyCacheException paramCacheListener)
      {
        for (;;)
        {
          Logger.warn("Error registering cache listener");
        }
      }
    }
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(215840);
    Logger.info("Shutdown proxy server");
    shutdownClients();
    this.config.sourceInfoStorage.release();
    this.waitConnectionThread.interrupt();
    try
    {
      if (!this.serverSocket.isClosed()) {
        this.serverSocket.close();
      }
      AppMethodBeat.o(215840);
      return;
    }
    catch (IOException localIOException)
    {
      onError(new ProxyCacheException("Error shutting down proxy server", localIOException));
      AppMethodBeat.o(215840);
    }
  }
  
  public void unregisterCacheListener(CacheListener paramCacheListener)
  {
    AppMethodBeat.i(215838);
    Preconditions.checkNotNull(paramCacheListener);
    synchronized (this.clientsLock)
    {
      Iterator localIterator = this.clientsMap.values().iterator();
      if (localIterator.hasNext()) {
        ((HttpProxyCacheServerClients)localIterator.next()).unregisterCacheListener(paramCacheListener);
      }
    }
    AppMethodBeat.o(215838);
  }
  
  public void unregisterCacheListener(CacheListener paramCacheListener, String paramString)
  {
    AppMethodBeat.i(215837);
    Preconditions.checkAllNotNull(new Object[] { paramCacheListener, paramString });
    synchronized (this.clientsLock)
    {
      try
      {
        getClients(paramString).unregisterCacheListener(paramCacheListener);
        AppMethodBeat.o(215837);
        return;
      }
      catch (ProxyCacheException paramCacheListener)
      {
        for (;;)
        {
          Logger.warn("Error registering cache listener");
        }
      }
    }
  }
  
  public static final class Builder
  {
    private static final long DEFAULT_MAX_SIZE = 536870912L;
    private File cacheRoot;
    private DiskUsage diskUsage;
    private FileNameGenerator fileNameGenerator;
    private HeaderInjector headerInjector;
    private SourceInfoStorage sourceInfoStorage;
    
    public Builder(Context paramContext)
    {
      AppMethodBeat.i(183569);
      this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(paramContext);
      this.cacheRoot = StorageUtils.getIndividualCacheDirectory(paramContext);
      this.diskUsage = new TotalSizeLruDiskUsage(536870912L);
      this.fileNameGenerator = new Md5FileNameGenerator();
      this.headerInjector = new EmptyHeadersInjector();
      AppMethodBeat.o(183569);
    }
    
    private Config buildConfig()
    {
      AppMethodBeat.i(215831);
      Config localConfig = new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
      AppMethodBeat.o(215831);
      return localConfig;
    }
    
    public final HttpProxyCacheServer build()
    {
      AppMethodBeat.i(215830);
      HttpProxyCacheServer localHttpProxyCacheServer = new HttpProxyCacheServer(buildConfig(), null);
      AppMethodBeat.o(215830);
      return localHttpProxyCacheServer;
    }
    
    public final Builder cacheDirectory(File paramFile)
    {
      AppMethodBeat.i(215824);
      this.cacheRoot = ((File)Preconditions.checkNotNull(paramFile));
      AppMethodBeat.o(215824);
      return this;
    }
    
    public final Builder diskUsage(DiskUsage paramDiskUsage)
    {
      AppMethodBeat.i(215828);
      this.diskUsage = ((DiskUsage)Preconditions.checkNotNull(paramDiskUsage));
      AppMethodBeat.o(215828);
      return this;
    }
    
    public final Builder fileNameGenerator(FileNameGenerator paramFileNameGenerator)
    {
      AppMethodBeat.i(215825);
      this.fileNameGenerator = ((FileNameGenerator)Preconditions.checkNotNull(paramFileNameGenerator));
      AppMethodBeat.o(215825);
      return this;
    }
    
    public final Builder headerInjector(HeaderInjector paramHeaderInjector)
    {
      AppMethodBeat.i(215829);
      this.headerInjector = ((HeaderInjector)Preconditions.checkNotNull(paramHeaderInjector));
      AppMethodBeat.o(215829);
      return this;
    }
    
    public final Builder maxCacheFilesCount(int paramInt)
    {
      AppMethodBeat.i(215827);
      this.diskUsage = new TotalCountLruDiskUsage(paramInt);
      AppMethodBeat.o(215827);
      return this;
    }
    
    public final Builder maxCacheSize(long paramLong)
    {
      AppMethodBeat.i(215826);
      this.diskUsage = new TotalSizeLruDiskUsage(paramLong);
      AppMethodBeat.o(215826);
      return this;
    }
  }
  
  final class SocketProcessorRunnable
    implements Runnable
  {
    private final Socket socket;
    
    public SocketProcessorRunnable(Socket paramSocket)
    {
      this.socket = paramSocket;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183570);
      HttpProxyCacheServer.access$200(HttpProxyCacheServer.this, this.socket);
      AppMethodBeat.o(183570);
    }
  }
  
  final class WaitRequestsRunnable
    implements Runnable
  {
    private final CountDownLatch startSignal;
    
    public WaitRequestsRunnable(CountDownLatch paramCountDownLatch)
    {
      this.startSignal = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183571);
      this.startSignal.countDown();
      HttpProxyCacheServer.access$100(HttpProxyCacheServer.this);
      AppMethodBeat.o(183571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.HttpProxyCacheServer
 * JD-Core Version:    0.7.0.1
 */