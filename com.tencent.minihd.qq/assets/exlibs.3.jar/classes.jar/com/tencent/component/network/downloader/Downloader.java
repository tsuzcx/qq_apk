package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.http.HttpHost;

public abstract class Downloader
{
  protected int a;
  protected Context a;
  protected Downloader.DownloadMode a;
  protected Downloader.NetworkFlowStatistics a;
  protected a a;
  protected ReportHandler a;
  protected com.tencent.component.network.downloader.handler.a a;
  protected com.tencent.component.network.downloader.handler.b a;
  protected DownloadPreprocessStrategy a;
  protected IPStrategy a;
  protected KeepAliveStrategy a;
  protected PortConfigStrategy a;
  protected ResumeTransfer a;
  protected com.tencent.component.network.module.cache.a.b a;
  protected PriorityThreadPool a;
  protected String a;
  protected HttpHost a;
  protected int b;
  protected ReportHandler b;
  protected IPStrategy b;
  
  public Downloader(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = Downloader.DownloadMode.FastMode;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB = com.tencent.component.network.module.cache.a.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public DownloadPreprocessStrategy a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy;
  }
  
  public KeepAliveStrategy a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy;
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Downloader.DownloadMode paramDownloadMode)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = paramDownloadMode;
  }
  
  public void a(Downloader.NetworkFlowStatistics paramNetworkFlowStatistics)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics = paramNetworkFlowStatistics;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA = parama;
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA);
    }
  }
  
  @Deprecated
  public void a(ReportHandler paramReportHandler)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler;
  }
  
  public void a(com.tencent.component.network.downloader.handler.a parama)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerA = parama;
  }
  
  public void a(com.tencent.component.network.downloader.handler.b paramb)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerB = paramb;
  }
  
  public void a(DownloadPreprocessStrategy paramDownloadPreprocessStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy = paramDownloadPreprocessStrategy;
  }
  
  public void a(IPStrategy paramIPStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy;
    DownloaderFactory.a(this.jdField_a_of_type_AndroidContentContext).a(paramIPStrategy);
  }
  
  public void a(KeepAliveStrategy paramKeepAliveStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy = paramKeepAliveStrategy;
  }
  
  public void a(PortConfigStrategy paramPortConfigStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = paramPortConfigStrategy;
    DownloaderFactory.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy);
  }
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, Downloader.DownloadListener paramDownloadListener);
  
  public void a(Executor paramExecutor)
  {
    if (paramExecutor == null)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool = null;
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool = new PriorityThreadPool(paramExecutor);
  }
  
  public void a(HttpHost paramHttpHost)
  {
    this.jdField_a_of_type_OrgApacheHttpHttpHost = paramHttpHost;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null, false);
  }
  
  public void a(boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    QzoneResumeTransfer localQzoneResumeTransfer = new QzoneResumeTransfer(this.jdField_a_of_type_AndroidContentContext, "tmp_" + com.tencent.component.network.downloader.common.a.a(this.jdField_a_of_type_AndroidContentContext) + "_" + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB, true);
    localQzoneResumeTransfer.a = paramBoolean1;
    localQzoneResumeTransfer.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      localQzoneResumeTransfer.a(paramArrayOfString, paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer = localQzoneResumeTransfer;
  }
  
  public abstract boolean a(DownloadRequest paramDownloadRequest, boolean paramBoolean);
  
  public final boolean a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, true, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return a(paramString1, paramString2, paramBoolean, paramDownloadListener, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return a(paramString1, new String[] { paramString2 }, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean a(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode);
  }
  
  public final boolean a(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    return a(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean a(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    if ((!com.tencent.component.network.downloader.common.a.a(paramString)) || (paramArrayOfString == null)) {
      return false;
    }
    paramString = new DownloadRequest(paramString, paramArrayOfString, paramBoolean1, paramDownloadListener);
    paramString.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = paramDownloadMode;
    return a(paramString, paramBoolean2);
  }
  
  public String a_(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA;
    if (localObject == null) {}
    for (localObject = paramString; TextUtils.isEmpty((CharSequence)localObject); localObject = ((a)localObject).a(paramString)) {
      return paramString;
    }
    return localObject;
  }
  
  public HttpHost a_()
  {
    return this.jdField_a_of_type_OrgApacheHttpHttpHost;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(ReportHandler paramReportHandler)
  {
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler;
  }
  
  public void b(IPStrategy paramIPStrategy)
  {
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy;
    DownloaderFactory.a(this.jdField_a_of_type_AndroidContentContext).b(paramIPStrategy);
  }
  
  public abstract void b(String paramString, Downloader.DownloadListener paramDownloadListener);
  
  protected String b_(String paramString)
  {
    paramString = a_(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return UUID.randomUUID().toString();
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader
 * JD-Core Version:    0.7.0.1
 */