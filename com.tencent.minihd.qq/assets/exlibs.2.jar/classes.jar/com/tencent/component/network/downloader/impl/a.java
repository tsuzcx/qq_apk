package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import cug;
import cuh;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public abstract class a
  implements NetworkManager.NetStatusListener, ThreadPool.Job
{
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 8192);
  private static final Object jdField_a_of_type_JavaLangObject;
  protected static final ThreadLocal a;
  protected static ConcurrentHashMap a;
  private static volatile int jdField_c_of_type_Int = 0;
  private static volatile long d;
  protected int a;
  protected long a;
  protected final Context a;
  private Downloader.NetworkFlowStatistics jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics;
  private ReportHandler jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler;
  protected a.a a;
  protected DownloadGlobalStrategy.StrategyInfo a;
  protected DownloadGlobalStrategy.StrategyLib a;
  protected IPStrategy a;
  protected PortConfigStrategy a;
  protected ResumeTransfer a;
  private com.tencent.component.network.module.cache.a.b jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB;
  private PriorityThreadPool.Priority jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority;
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap;
  protected HttpClient a;
  protected HttpGet a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  protected long b;
  private ReportHandler jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler;
  protected DownloadGlobalStrategy.StrategyInfo b;
  protected IPStrategy b;
  private final String jdField_b_of_type_JavaLangString;
  protected long c;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangThreadLocal = new cuh();
    jdField_a_of_type_JavaLangObject = new Object();
    d = System.currentTimeMillis();
  }
  
  public a(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib = null;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = null;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = null;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = null;
    this.jdField_c_of_type_Long = 0L;
    AssertUtil.a(com.tencent.component.network.downloader.common.a.a(paramString1));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = paramHttpClient;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (paramContext = PriorityThreadPool.Priority.c;; paramContext = PriorityThreadPool.Priority.b)
    {
      a(paramContext);
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString, paramBoolean);
  }
  
  private void a(PriorityThreadPool.Priority paramPriority)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority = paramPriority;
  }
  
  private void a(ThreadPool.JobContext paramJobContext)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ReportHandler.DownloadReportObject localDownloadReportObject = (ReportHandler.DownloadReportObject)localIterator.next();
        if ((localDownloadReportObject != null) && (((this.jdField_a_of_type_Boolean) && (!paramJobContext.a())) || ((localDownloadReportObject.p == 0) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler != null)))) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.a(localDownloadReportObject);
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.a(paramString, paramLong, paramFloat);
  }
  
  private boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a == null) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.a(paramDownloadResult, paramHttpResponse);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (!cug.a(paramString, true)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString.getName());
        if (paramLong <= 0L) {
          return true;
        }
        while (!paramString.exists()) {
          paramString = paramString.getParentFile();
        }
        paramString = new StatFs(paramString.getAbsolutePath());
        long l = paramString.getAvailableBlocks();
        int i = paramString.getBlockSize();
        if (i * l > paramLong) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        return false;
      }
      catch (IOException paramString) {}
    }
  }
  
  private String b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString);
  }
  
  private void b(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult.a().b()) {
      if (paramDownloadResult.a().a() != null)
      {
        paramDownloadResult = Log.getStackTraceString(paramDownloadResult.a().a());
        if ((paramDownloadResult == null) || (!paramDownloadResult.contains("refused"))) {}
      }
      else
      {
        do
        {
          return;
          if ((paramDownloadResult.a().a() == null) || (!(paramDownloadResult.a().a() instanceof SocketException))) {
            break;
          }
          paramDownloadResult = Log.getStackTraceString(paramDownloadResult.a().a());
        } while ((paramDownloadResult != null) && (paramDownloadResult.contains("Permission denied")) && (b()));
      }
    }
    for (;;)
    {
      a(paramJobContext);
      return;
      if (404 == paramDownloadResult.a().o)
      {
        paramDownloadResult = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
        if (paramDownloadResult != null) {
          break;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
        com.tencent.component.network.module.base.b.b("downloader", "save 404 url at first time.");
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadResult.intValue() + 1));
    com.tencent.component.network.module.base.b.b("downloader", "save 404 url " + (paramDownloadResult.intValue() + 1));
  }
  
  private boolean b()
  {
    String str1 = Build.BRAND;
    String str2 = Build.MODEL;
    com.tencent.component.network.module.base.b.b("downloader", "brand:" + str1 + " model:" + str2);
    return (str2 != null) && (str2.startsWith("MI"));
  }
  
  private String d()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a != null) {}
    for (String str1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.b(this.jdField_a_of_type_JavaLangString);; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        str2 = UUID.randomUUID().toString();
      }
      return str2;
    }
    return String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode());
  }
  
  protected long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final DownloadResult a(ThreadPool.JobContext paramJobContext)
  {
    String str = null;
    DownloadResult localDownloadResult = new DownloadResult(this.jdField_a_of_type_JavaLangString);
    if (paramJobContext.a())
    {
      a(paramJobContext, localDownloadResult, null);
      return localDownloadResult;
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a != null) {
      str = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.a(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (com.tencent.component.network.module.base.b.b()) {
        com.tencent.component.network.module.base.b.b("downloader", "find cache entry:" + str + " url:" + this.jdField_a_of_type_JavaLangString);
      }
      localDownloadResult.a(str);
      localDownloadResult.a().b();
      return localDownloadResult;
    }
    paramJobContext.a(2);
    for (;;)
    {
      try
      {
        a();
        NetworkManager.a(this);
        a(paramJobContext, localDownloadResult);
        if (!NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_Boolean = false;
          localDownloadResult.a().a(6);
        }
        b(paramJobContext, localDownloadResult);
        c();
        if (!localDownloadResult.a().a()) {
          continue;
        }
        DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo, localDownloadResult.a().a());
        if (localDownloadResult.a().a()) {
          com.tencent.component.network.module.a.b.a().a(localDownloadResult.a().jdField_b_of_type_Long, localDownloadResult.a().jdField_a_of_type_Long, localDownloadResult.a().jdField_b_of_type_Long);
        }
      }
      catch (Throwable paramJobContext)
      {
        com.tencent.component.network.module.base.b.d("downloader", "exception when execute DownloadTask. ", paramJobContext);
        NetworkManager.b(this);
        continue;
      }
      finally
      {
        NetworkManager.b(this);
      }
      return localDownloadResult;
      if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib != null) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a() != null)) {
        DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(), localDownloadResult.a().a());
      }
    }
  }
  
  public PriorityThreadPool.Priority a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a == null) {}
    String str;
    do
    {
      return paramString;
      str = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.c(paramString);
    } while (TextUtils.isEmpty(str));
    return str;
  }
  
  protected void a()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = com.tencent.component.network.downloader.common.a.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public void a(a.a parama, IPStrategy paramIPStrategy1, IPStrategy paramIPStrategy2, PortConfigStrategy paramPortConfigStrategy, ResumeTransfer paramResumeTransfer, ReportHandler paramReportHandler1, ReportHandler paramReportHandler2, Downloader.NetworkFlowStatistics paramNetworkFlowStatistics, com.tencent.component.network.module.cache.a.b paramb)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a = parama;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer = paramResumeTransfer;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler1;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler2;
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB = paramb;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics = paramNetworkFlowStatistics;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy1;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy2;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = paramPortConfigStrategy;
  }
  
  public abstract void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler != null)
    {
      if (paramJobContext.a()) {
        paramDownloadResult.a().l = 4;
      }
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.a(paramDownloadResult, paramDownloadReport);
    }
    if (paramJobContext.a()) {}
    while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler == null) {
      return;
    }
    paramJobContext = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.a(paramDownloadResult, paramDownloadReport);
    this.jdField_a_of_type_JavaUtilList.add(paramJobContext);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (paramHttpRequest != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramHttpRequest.addHeader(str, (String)localObject);
        }
      }
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.a(paramString1, paramString2, paramHttpRequest);
  }
  
  public void a(Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  protected boolean a()
  {
    int i = this.jdField_b_of_type_Int + 1;
    this.jdField_b_of_type_Int = i;
    return i < this.jdField_a_of_type_Int;
  }
  
  protected boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    Object localObject = paramHttpResponse.getEntity();
    this.jdField_a_of_type_Long = ((HttpEntity)localObject).getContentLength();
    paramDownloadResult.a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    Header localHeader = ((HttpEntity)localObject).getContentType();
    if (localHeader != null) {
      paramDownloadResult.a().jdField_a_of_type_JavaLangString = localHeader.getValue();
    }
    localObject = ((HttpEntity)localObject).getContentEncoding();
    if (localObject != null) {
      paramDownloadResult.a().jdField_b_of_type_JavaLangString = ((Header)localObject).getValue();
    }
    localObject = paramHttpResponse.getAllHeaders();
    int j;
    int i;
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ("Client-Ip".equalsIgnoreCase(localObject[i].getName())) {
          paramDownloadResult.a().jdField_c_of_type_JavaLangString = localObject[i].getValue();
        }
      }
      else
      {
        localObject = paramHttpResponse.getFirstHeader("Size");
        if (localObject == null) {
          break label242;
        }
      }
      try
      {
        this.jdField_b_of_type_Long = Integer.parseInt(((Header)localObject).getValue());
        paramDownloadResult.a().jdField_c_of_type_Long = this.jdField_b_of_type_Long;
        label192:
        localObject = paramHttpResponse.getFirstHeader("Last-Modified");
        if (localObject != null) {}
        try
        {
          paramDownloadResult.a().d = ((Header)localObject).getValue();
          if (paramJobContext.a())
          {
            return false;
            i += 1;
            continue;
            label242:
            this.jdField_b_of_type_Long = -1L;
            paramDownloadResult.a().jdField_c_of_type_Long = -1L;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            HeaderIterator localHeaderIterator = paramHttpResponse.headerIterator("Cache-Control");
            while ((localHeaderIterator != null) && (localHeaderIterator.hasNext()))
            {
              localHeader = localHeaderIterator.nextHeader();
              if ((localHeader != null) && ("no-cache".equalsIgnoreCase(localHeader.getValue()))) {
                paramDownloadResult.a().jdField_a_of_type_Boolean = true;
              }
            }
          } while (paramJobContext.a());
          if (!a(paramDownloadResult, paramHttpResponse))
          {
            paramDownloadResult.a().a(5);
            return false;
          }
          if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) && (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramHttpResponse)))
          {
            com.tencent.component.network.module.base.b.c("downloader", "download 断线续传 response not valid.");
            this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString, true);
            return false;
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        break label192;
      }
    }
  }
  
  protected boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
  {
    if (!a(paramHttpResponse, paramDownloadResult, paramJobContext)) {
      return false;
    }
    long l5 = System.currentTimeMillis();
    boolean bool1;
    long l6;
    if (paramInt == 206) {
      if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString))))
      {
        paramDownloadResult.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString));
        bool1 = true;
        localObject1 = null;
        localObject2 = jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a();
        l3 = 0L;
        l6 = this.jdField_a_of_type_Long;
      }
    }
    for (l4 = System.currentTimeMillis();; l4 = System.currentTimeMillis())
    {
      try
      {
        localFile = new File(paramDownloadResult.b());
        cug.a(localFile, false);
        boolean bool2 = paramJobContext.a();
        if (bool2)
        {
          if (0 != 0) {
            throw new NullPointerException();
          }
          if (0 != 0) {
            throw new NullPointerException();
          }
          jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a((BytesBufferPool.BytesBuffer)localObject2);
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics != null) {
            this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics.a(NetworkManager.a(), 0L, System.currentTimeMillis() - l4);
          }
          return false;
          com.tencent.component.network.module.base.b.c("downloader", "download response 206 but tmp file not exist.");
          return false;
          if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString))) && (paramInt == 200)) {
            this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_JavaLangString, true);
          }
          localObject2 = d();
          localObject1 = b((String)localObject2);
          localObject2 = a((String)localObject2, false);
          if (a((String)localObject1, this.jdField_a_of_type_Long)) {
            paramDownloadResult.a((String)localObject1);
          }
          for (;;)
          {
            bool1 = false;
            break;
            if ((TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) || (!a((String)localObject2, this.jdField_a_of_type_Long))) {
              break label328;
            }
            paramDownloadResult.a((String)localObject2);
          }
          label328:
          paramDownloadResult.a().a(2);
          return false;
        }
        paramHttpResponse = paramHttpResponse.getEntity().getContent();
      }
      finally
      {
        File localFile;
        long l7;
        label451:
        paramHttpResponse = null;
        l2 = l4;
        l1 = l3;
        paramDownloadResult = (DownloadResult)localObject1;
        if (paramDownloadResult != null) {
          paramDownloadResult.close();
        }
        if (paramHttpResponse != null) {
          paramHttpResponse.close();
        }
        jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a((BytesBufferPool.BytesBuffer)localObject2);
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics.a(NetworkManager.a(), l1, System.currentTimeMillis() - l2);
        }
      }
      try
      {
        localObject1 = new FileOutputStream(localFile, bool1);
        l1 = l3;
        l2 = l4;
      }
      finally
      {
        paramDownloadResult = paramHttpResponse;
        paramHttpResponse = null;
        l1 = l3;
        l2 = l4;
      }
      try
      {
        l7 = localFile.length();
        paramInt = 0;
        l1 = l3;
        l2 = l4;
        i = paramHttpResponse.read(((BytesBufferPool.BytesBuffer)localObject2).a, paramInt, 8192 - paramInt);
        if (i <= 0) {
          break label533;
        }
        if (i + paramInt != 8192) {
          break label781;
        }
        l1 = l3;
        l2 = l4;
        ((OutputStream)localObject1).write(((BytesBufferPool.BytesBuffer)localObject2).a, 0, paramInt + i);
        paramInt = 0;
      }
      finally
      {
        paramDownloadResult = (DownloadResult)localObject1;
        localObject1 = paramHttpResponse;
        paramHttpResponse = paramDownloadResult;
        paramDownloadResult = (DownloadResult)localObject1;
        break label697;
        paramInt += i;
        break label451;
      }
      l3 += i;
      l1 = l3;
      l2 = l4;
      paramDownloadResult.a().jdField_b_of_type_Long = l3;
      if (l6 > 0L)
      {
        l1 = l3;
        l2 = l4;
        a(this.jdField_b_of_type_JavaLangString, l6 + l7, (float)(l3 + l7) / (float)(l6 + l7));
      }
      l1 = l3;
      l2 = l4;
    }
    label533:
    if ((i <= 0) && (paramInt > 0))
    {
      l1 = l3;
      l2 = l4;
      ((OutputStream)localObject1).write(((BytesBufferPool.BytesBuffer)localObject2).a, 0, paramInt);
    }
    l1 = l3;
    l2 = l4;
    this.jdField_c_of_type_Long = (System.currentTimeMillis() - l5);
    if (l6 <= 0L)
    {
      l1 = l3;
      l2 = l4;
      a(this.jdField_b_of_type_JavaLangString, l6 + l7, 1.0F);
    }
    l1 = l3;
    l2 = l4;
    paramDownloadResult.a().jdField_b_of_type_Long = l3;
    if (paramHttpResponse != null) {
      paramHttpResponse.close();
    }
    if (localObject1 != null) {
      ((OutputStream)localObject1).close();
    }
    jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a((BytesBufferPool.BytesBuffer)localObject2);
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics.a(NetworkManager.a(), l3, System.currentTimeMillis() - l4);
    }
    return true;
  }
  
  protected int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = com.tencent.component.network.downloader.common.a.a(this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    jdField_c_of_type_Int += 1;
  }
  
  protected void b(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.b(paramString1, paramString2, paramHttpRequest);
  }
  
  protected int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    jdField_c_of_type_Int -= 1;
  }
  
  protected int d()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a != null) {
      return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a.a();
    }
    return 1;
  }
  
  public void d()
  {
    if (com.tencent.component.network.module.base.b.b()) {
      com.tencent.component.network.module.base.b.b("downloader", "downloader abort:" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet != null) {}
    try
    {
      this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet.abort();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.component.network.module.base.b.c("downloader", "downloader abort Exception", localException);
    }
  }
  
  /* Error */
  protected void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/component/network/downloader/impl/a:jdField_a_of_type_OrgApacheHttpClientHttpClient	Lorg/apache/http/client/HttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 67	com/tencent/component/network/downloader/impl/a:d	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 649
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 59	com/tencent/component/network/downloader/impl/a:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 67	com/tencent/component/network/downloader/impl/a:d	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 649
    //   54: lcmp
    //   55: ifge +13 -> 68
    //   58: aload_3
    //   59: monitorexit
    //   60: return
    //   61: astore 4
    //   63: aload_3
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: aload_0
    //   69: getfield 120	com/tencent/component/network/downloader/impl/a:jdField_a_of_type_OrgApacheHttpClientHttpClient	Lorg/apache/http/client/HttpClient;
    //   72: invokeinterface 656 1 0
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull +49 -> 130
    //   84: aload 4
    //   86: instanceof 658
    //   89: ifeq +41 -> 130
    //   92: aload 4
    //   94: checkcast 658	com/tencent/component/network/utils/a/g
    //   97: astore 4
    //   99: aload 4
    //   101: ifnull +8 -> 109
    //   104: aload 4
    //   106: invokevirtual 661	com/tencent/component/network/utils/a/g:closeExpiredConnections	()V
    //   109: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   112: putstatic 67	com/tencent/component/network/downloader/impl/a:d	J
    //   115: invokestatic 662	com/tencent/component/network/module/base/b:a	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc_w 274
    //   124: ldc_w 664
    //   127: invokestatic 666	com/tencent/component/network/module/base/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_3
    //   131: monitorexit
    //   132: return
    //   133: astore 4
    //   135: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   138: putstatic 67	com/tencent/component/network/downloader/impl/a:d	J
    //   141: invokestatic 662	com/tencent/component/network/module/base/b:a	()Z
    //   144: ifeq -14 -> 130
    //   147: ldc_w 274
    //   150: ldc_w 664
    //   153: invokestatic 666	com/tencent/component/network/module/base/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -26 -> 130
    //   159: astore 4
    //   161: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   164: putstatic 67	com/tencent/component/network/downloader/impl/a:d	J
    //   167: invokestatic 662	com/tencent/component/network/module/base/b:a	()Z
    //   170: ifeq +12 -> 182
    //   173: ldc_w 274
    //   176: ldc_w 664
    //   179: invokestatic 666	com/tencent/component/network/module/base/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 4
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	a
    //   15	36	1	l	long
    //   33	98	3	localObject1	Object
    //   61	5	4	localObject2	Object
    //   77	28	4	localObject3	Object
    //   133	1	4	localException	Exception
    //   159	24	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	61	finally
    //   58	60	61	finally
    //   63	65	61	finally
    //   68	79	61	finally
    //   84	99	61	finally
    //   109	130	61	finally
    //   130	132	61	finally
    //   135	156	61	finally
    //   161	182	61	finally
    //   182	185	61	finally
    //   104	109	133	java/lang/Exception
    //   104	109	159	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.a
 * JD-Core Version:    0.7.0.1
 */