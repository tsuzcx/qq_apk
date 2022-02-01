package com.tencent.component.network;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.impl.c;
import com.tencent.component.network.downloader.impl.f;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.component.network.module.base.inter.Log;
import ctw;
import ctx;
import java.util.concurrent.Executor;

public class DownloaderFactory
{
  private static volatile DownloaderFactory jdField_a_of_type_ComTencentComponentNetworkDownloaderFactory = null;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private com.tencent.component.network.downloader.handler.b jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerB = new ctw(this);
  protected IPStrategy a;
  private PortConfigStrategy jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy;
  private Downloader b;
  protected IPStrategy b;
  
  private DownloaderFactory(Context paramContext)
  {
    Global.a(paramContext.getApplicationContext());
  }
  
  public static DownloaderFactory a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkDownloaderFactory == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentComponentNetworkDownloaderFactory == null) {
        jdField_a_of_type_ComTencentComponentNetworkDownloaderFactory = new DownloaderFactory(paramContext);
      }
      return jdField_a_of_type_ComTencentComponentNetworkDownloaderFactory;
    }
  }
  
  public static Downloader a(String paramString)
  {
    return a(paramString, null, null);
  }
  
  public static Downloader a(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    com.tencent.component.network.module.common.a.a().a(paramExecutor2);
    paramString = new c(Global.a(), paramString, 2);
    paramString.a(paramExecutor1);
    return paramString;
  }
  
  public static void a(IDownloadConfig paramIDownloadConfig, Log paramLog)
  {
    com.tencent.component.network.module.base.a.a(paramIDownloadConfig);
    com.tencent.component.network.module.base.b.a(paramLog);
  }
  
  public static Downloader b(String paramString)
  {
    return b(paramString, null, null);
  }
  
  public static Downloader b(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    com.tencent.component.network.module.common.a.a().a(paramExecutor2);
    paramString = new c(Global.a(), paramString, 1);
    paramString.a(paramExecutor1);
    f.a(paramString);
    return paramString;
  }
  
  public Downloader a()
  {
    if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader != null) {
      return this.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader;
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader != null)
      {
        Downloader localDownloader = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader;
        return localDownloader;
      }
    }
    finally {}
    c localc = new c(Global.a(), "image", 1);
    localc.a(com.tencent.component.network.downloader.a.b);
    localc.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerB);
    localc.b();
    localc.a(new ctx(this));
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader = localc;
    return localc;
  }
  
  public IPStrategy a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy;
  }
  
  public PortConfigStrategy a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy;
  }
  
  public void a(IPStrategy paramIPStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy;
  }
  
  public void a(PortConfigStrategy paramPortConfigStrategy)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = paramPortConfigStrategy;
  }
  
  public Downloader b()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null) {
      return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null)
      {
        Downloader localDownloader = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
        return localDownloader;
      }
    }
    finally {}
    c localc = new c(Global.a(), "common", 2);
    localc.a(com.tencent.component.network.downloader.a.b);
    localc.b();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = localc;
    return localc;
  }
  
  public IPStrategy b()
  {
    return this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy;
  }
  
  public void b(IPStrategy paramIPStrategy)
  {
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */