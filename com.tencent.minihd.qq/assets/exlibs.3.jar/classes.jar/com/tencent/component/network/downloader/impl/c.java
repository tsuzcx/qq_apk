package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.strategy.DownloadConnectionReuseStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy.KeepAlive;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.a.e.a;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import cuj;
import cuk;
import cul;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.AbstractHttpClient;

public class c
  extends Downloader
  implements a.a
{
  private static final DownloadPreprocessStrategy.DownloadPool jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy$DownloadPool = DownloadPreprocessStrategy.DownloadPool.COMMON;
  private static final KeepAliveStrategy.KeepAlive jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive;
  private static final cuk jdField_a_of_type_Cuk = new cuk("download", 2);
  public static final TimeUnit a;
  private static final KeepAliveStrategy.KeepAlive jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive;
  public static int c;
  public static int d;
  private static volatile int e = 0;
  private final com.tencent.component.network.utils.c jdField_a_of_type_ComTencentComponentNetworkUtilsC = new com.tencent.component.network.utils.c();
  private cuj jdField_a_of_type_Cuj = new cuj(this, null);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  private boolean jdField_a_of_type_Boolean = false;
  private final com.tencent.component.network.module.cache.a.b jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB = com.tencent.component.network.module.cache.a.a(this.jdField_a_of_type_AndroidContentContext, "download_cache", 100, 50, false);
  private final cuk jdField_b_of_type_Cuk = jdField_a_of_type_Cuk;
  
  static
  {
    c = DownloadPreprocessStrategy.DownloadPool.size() * 3 * 5;
    d = 2;
    jdField_a_of_type_JavaUtilConcurrentTimeUnit = TimeUnit.SECONDS;
    jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive = KeepAliveStrategy.KeepAlive.DISABLE;
    jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive = KeepAliveStrategy.KeepAlive.DISABLE;
  }
  
  public c(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString);
  }
  
  private com.tencent.component.network.utils.c a(boolean paramBoolean, com.tencent.component.network.utils.c paramc)
  {
    com.tencent.component.network.utils.c localc2 = this.jdField_a_of_type_ComTencentComponentNetworkUtilsC;
    if (paramc != null) {}
    try
    {
      paramc.clear();
      if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.isEmpty()) {
        return paramc;
      }
      com.tencent.component.network.utils.c localc1 = paramc;
      if (paramc == null) {
        localc1 = new com.tencent.component.network.utils.c();
      }
      localc1.putAll(this.jdField_a_of_type_ComTencentComponentNetworkUtilsC);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.clear();
      }
      return localc1;
    }
    finally {}
  }
  
  private PriorityThreadPool a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool == null) {
        break;
      }
      return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool;
    }
    DownloadPreprocessStrategy localDownloadPreprocessStrategy = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy;
    if (localDownloadPreprocessStrategy != null) {}
    for (paramString1 = localDownloadPreprocessStrategy.a(paramString1, paramString2);; paramString1 = null)
    {
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy$DownloadPool;
      }
      return this.jdField_b_of_type_Cuk.a(paramString2.getName());
    }
  }
  
  private Collection a(String paramString, boolean paramBoolean, Collection paramCollection)
  {
    com.tencent.component.network.utils.c localc = this.jdField_a_of_type_ComTencentComponentNetworkUtilsC;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.remove(paramString); paramCollection != null; paramString = (HashSet)this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  private HttpClient a()
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null) {
      return this.jdField_a_of_type_OrgApacheHttpClientHttpClient;
    }
    try
    {
      if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null)
      {
        HttpClient localHttpClient = this.jdField_a_of_type_OrgApacheHttpClientHttpClient;
        return localHttpClient;
      }
    }
    finally {}
    Object localObject2 = new e.a();
    ((e.a)localObject2).jdField_a_of_type_Boolean = true;
    ((e.a)localObject2).jdField_a_of_type_Int = c;
    ((e.a)localObject2).jdField_b_of_type_Int = d;
    ((e.a)localObject2).jdField_a_of_type_Long = 120L;
    ((e.a)localObject2).jdField_a_of_type_JavaUtilConcurrentTimeUnit = jdField_a_of_type_JavaUtilConcurrentTimeUnit;
    this.jdField_a_of_type_OrgApacheHttpClientHttpClient = com.tencent.component.network.utils.a.e.a((e.a)localObject2);
    a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
    localObject2 = this.jdField_a_of_type_OrgApacheHttpClientHttpClient;
    return localObject2;
  }
  
  private void a(a parama)
  {
    if (parama == null) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    ??? = a(parama.a(), parama.b());
    parama.b();
    Future localFuture = ((PriorityThreadPool)???).a(parama, new cul(this, parama), parama.a());
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(parama.c(), localFuture);
      return;
    }
  }
  
  private void a(Collection paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.b()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.a();
          if (localDownloadListener != null) {
            localDownloadListener.a(localDownloadRequest.a());
          }
        }
      }
    }
  }
  
  private void a(Collection paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.b()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.a();
          if (localDownloadListener != null) {
            localDownloadListener.a(localDownloadRequest.a(), paramLong, paramFloat);
          }
        }
      }
    }
  }
  
  private void a(Collection paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (localDownloadRequest.a() != null)) {
          localDownloadRequest.a().a(localDownloadRequest.a(), paramDownloadResult);
        }
      }
    }
  }
  
  private static void a(HttpClient paramHttpClient)
  {
    if (paramHttpClient == null) {}
    while (!(paramHttpClient instanceof AbstractHttpClient)) {
      return;
    }
    ((AbstractHttpClient)paramHttpClient).setReuseStrategy(new DownloadConnectionReuseStrategy());
  }
  
  private boolean a(DownloadResult paramDownloadResult, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {}
    com.tencent.component.network.downloader.handler.b localb;
    do
    {
      return false;
      localb = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerB;
    } while (localb == null);
    return localb.a(paramDownloadResult.b(), paramDownloadRequest.b());
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private boolean a(String paramString, DownloadRequest paramDownloadRequest, Collection paramCollection)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      int k;
      int j;
      synchronized (this.jdField_a_of_type_ComTencentComponentNetworkUtilsC)
      {
        k = this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.a(paramString);
        if (paramCollection != null) {
          paramCollection.clear();
        }
        paramString = (Collection)this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.get(paramString);
        if (paramString != null)
        {
          paramString = paramString.iterator();
          int i = 0;
          j = i;
          if (!paramString.hasNext()) {
            break label157;
          }
          DownloadRequest localDownloadRequest = (DownloadRequest)paramString.next();
          if (paramDownloadRequest.equals(localDownloadRequest))
          {
            localDownloadRequest.a();
            if (paramCollection != null) {
              paramCollection.add(paramDownloadRequest);
            }
          }
          if ((localDownloadRequest != null) && (!localDownloadRequest.b()))
          {
            i += 1;
            break label151;
            label133:
            return bool;
          }
        }
      }
      label151:
      label157:
      do
      {
        bool = false;
        break label133;
        break;
        j = 0;
      } while ((k <= 0) || (j != 0));
      boolean bool = true;
    }
  }
  
  private boolean a(String arg1, String paramString2, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentComponentNetworkUtilsC)
      {
        this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.a(paramString2);
        Object localObject = (Collection)this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.get(paramString2);
        if (localObject == null) {
          break label137;
        }
        localObject = ((Collection)localObject).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject).hasNext())
        {
          DownloadRequest localDownloadRequest = (DownloadRequest)((Iterator)localObject).next();
          if ((localDownloadRequest == null) || (localDownloadRequest.b())) {
            break label134;
          }
          i += 1;
          break label134;
        }
        this.jdField_a_of_type_ComTencentComponentNetworkUtilsC.a(paramString2, paramDownloadRequest);
        if (j == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label134:
      continue;
      label137:
      int j = 0;
    }
  }
  
  private void b(Collection paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (localDownloadRequest.a() != null)) {
          localDownloadRequest.a().b(localDownloadRequest.a(), paramDownloadResult);
        }
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if (!com.tencent.component.network.downloader.common.a.a(paramString)) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        Object localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            a locala = (a)((WeakReference)((Iterator)localObject2).next()).get();
            if ((locala != null) && (paramString.equals(locala.a()))) {
              locala.d();
            }
          }
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    return e;
  }
  
  public String a(String paramString)
  {
    paramString = b_(paramString);
    paramString = this.jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString);
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  public HttpHost a()
  {
    return a_();
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Int > 0) {
      d = this.jdField_a_of_type_Int;
    }
    if (this.jdField_b_of_type_Int > 0) {
      c = this.jdField_b_of_type_Int;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB.a(b(paramString));
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    a(a(paramString, false, new ArrayList()), paramLong, paramFloat);
  }
  
  public void a(String paramString, DownloadResult paramDownloadResult)
  {
    String str2 = b_(paramString);
    String str1 = this.jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB.a(str2);
    try
    {
      File localFile = new File(paramDownloadResult.b());
      boolean bool2 = FileUtils.a(localFile, new File(str1));
      boolean bool1 = bool2;
      paramDownloadResult = str1;
      if (!bool2)
      {
        paramDownloadResult = this.jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB.a(str2, false);
        bool1 = FileUtils.a(localFile, new File(paramDownloadResult));
      }
      if (com.tencent.component.network.module.base.b.b()) {
        com.tencent.component.network.module.base.b.b("Downloader", "download cache entry to: " + paramDownloadResult + " " + paramString + " result:" + bool1);
      }
      return;
    }
    catch (Throwable paramDownloadResult)
    {
      com.tencent.component.network.module.base.b.c("Downloader", "download ------- copy exception!!! " + paramString, paramDownloadResult);
    }
  }
  
  public void a(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!com.tencent.component.network.downloader.common.a.a(paramString)) {
      return;
    }
    if (com.tencent.component.network.module.base.b.b()) {
      com.tencent.component.network.module.base.b.b("Downloader", "download cancel url:" + paramString + " listener:" + paramDownloadListener);
    }
    Object localObject1 = a_(paramString);
    ??? = new DownloadRequest(paramString, new String[0], false, paramDownloadListener);
    paramDownloadListener = new ArrayList();
    if (a((String)localObject1, (DownloadRequest)???, paramDownloadListener)) {}
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localObject1 = (Future)this.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
      if ((localObject1 != null) && (!a(paramString))) {
        ((Future)localObject1).a();
      }
      a(paramDownloadListener);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy.a(paramString1, paramString2, paramHttpRequest);
    }
  }
  
  public boolean a(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    Object localObject = paramDownloadRequest.a();
    if ((!com.tencent.component.network.downloader.common.a.a((String)localObject)) || (paramDownloadRequest.a() == null)) {
      return false;
    }
    String str = a_((String)localObject);
    if (com.tencent.component.network.module.base.b.b()) {
      com.tencent.component.network.module.base.b.b("downloader", "download :" + (String)localObject + " urlKey:" + str + " listener:" + paramDownloadRequest.a());
    }
    if ((a((String)localObject, str, paramDownloadRequest)) && (!a((String)localObject)))
    {
      if (paramDownloadRequest.jdField_a_of_type_Long > 0L) {
        paramDownloadRequest.a("Range", "bytes=" + paramDownloadRequest.jdField_a_of_type_Long);
      }
      if (paramDownloadRequest.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode != Downloader.DownloadMode.StrictMode) {
        break label230;
      }
      localObject = new i(this.jdField_a_of_type_AndroidContentContext, a(), (String)localObject, str, paramBoolean);
      ((a)localObject).a(12);
    }
    for (;;)
    {
      ((a)localObject).a(paramDownloadRequest.a());
      ((a)localObject).a(this, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy, this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler, this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics, this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB);
      a((a)localObject);
      return true;
      label230:
      localObject = new e(this.jdField_a_of_type_AndroidContentContext, a(), (String)localObject, str, paramBoolean);
      ((a)localObject).a(8);
    }
  }
  
  public boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    com.tencent.component.network.downloader.handler.a locala = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerA;
    if (locala != null) {
      return locala.a(paramDownloadResult, paramHttpResponse);
    }
    return true;
  }
  
  public String b(String paramString)
  {
    return super.b_(paramString);
  }
  
  public void b(String arg1, Downloader.DownloadListener paramDownloadListener)
  {
    b(???);
    Object localObject = a_(???);
    paramDownloadListener = new ArrayList();
    a((String)localObject, true, paramDownloadListener);
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localObject = (Future)this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
      if (localObject != null) {
        ((Future)localObject).a();
      }
      a(paramDownloadListener);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    boolean bool;
    if ((paramString1 != null) && (paramString2 != null) && (paramHttpRequest != null))
    {
      bool = true;
      label15:
      AssertUtil.a(bool);
      paramString1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy;
      if (paramString1 == null) {
        break label91;
      }
      paramString1 = paramString1.a(paramString2, paramHttpRequest);
      label38:
      paramString2 = paramString1;
      if (paramString1 == null) {
        if (!com.tencent.component.network.utils.a.e.a(paramHttpRequest)) {
          break label96;
        }
      }
    }
    label91:
    label96:
    for (paramString2 = jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive;; paramString2 = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyKeepAliveStrategy$KeepAlive) {
      switch (cui.a[paramString2.ordinal()])
      {
      default: 
        return;
        bool = false;
        break label15;
        paramString1 = null;
        break label38;
      }
    }
    com.tencent.component.network.utils.a.e.a(paramHttpRequest, true);
    return;
    com.tencent.component.network.utils.a.e.a(paramHttpRequest, false);
  }
  
  public String c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadPreprocessStrategy.a(paramString);
  }
  
  public void c()
  {
    this.jdField_b_of_type_ComTencentComponentNetworkModuleCacheAB.a();
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer.a();
    }
  }
  
  public void d()
  {
    Object localObject1 = null;
    com.tencent.component.network.utils.c localc = a(true, null);
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (Future)((Iterator)localObject1).next();
          if (??? != null) {
            ((Future)???).a();
          }
        }
      }
    }
    e();
    if (localc != null)
    {
      Iterator localIterator = localc.keySet().iterator();
      while (localIterator.hasNext())
      {
        ??? = (String)localIterator.next();
        if (??? != null) {
          a((Collection)localc.get(???));
        }
      }
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.c
 * JD-Core Version:    0.7.0.1
 */