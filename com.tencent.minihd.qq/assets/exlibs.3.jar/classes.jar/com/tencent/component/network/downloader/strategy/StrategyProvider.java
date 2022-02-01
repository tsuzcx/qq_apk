package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.a.e;
import com.tencent.component.network.utils.a.e.a;
import com.tencent.component.network.utils.a.e.b;
import cur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;

public class StrategyProvider
{
  public static IPConfigStrategy a;
  public static PortConfigStrategy a;
  private static e.a jdField_a_of_type_ComTencentComponentNetworkUtilsAE$a = new e.a(true);
  private static final ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new cur();
  private static HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
  public static IPConfigStrategy b;
  
  public static DownloadGlobalStrategy.StrategyInfo a(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    int i = 80;
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyLib == null) || (paramInt < 0)) {
      return null;
    }
    Object localObject = paramStrategyLib.b();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = paramStrategyLib.a(paramInt);
    paramStrategyLib.a(localStrategyInfo);
    if (b.b()) {
      b.b("StrategyProvider", "downloader strategy: " + localStrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + paramStrategyLib.c() + " url:" + paramString + " Apn:" + NetworkManager.a() + " ISP:" + NetworkManager.a() + " threadid:" + Thread.currentThread().getId());
    }
    String str = com.tencent.component.network.downloader.common.a.a(paramString);
    paramInt = paramStrategyLib.b();
    if (!com.tencent.component.network.downloader.common.a.a(paramInt))
    {
      paramStrategyLib.a(80);
      paramInt = i;
    }
    label1164:
    for (;;)
    {
      if (DownloadGlobalStrategy.d.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int)
      {
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.d.jdField_a_of_type_Int == ((DownloadGlobalStrategy.StrategyInfo)localObject).jdField_a_of_type_Int)
          {
            if ((jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
              break label408;
            }
            i = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
            {
              if (b.b()) {
                b.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
          }
        }
        paramString = paramStrategyLib.c();
        if ((b == null) || (b.a(paramString, str))) {
          break label1259;
        }
        paramStrategyLib.c(null);
        paramString = b.a(str);
        if (!TextUtils.isEmpty(paramString)) {
          paramStrategyLib.c(paramString);
        }
      }
      label408:
      label706:
      label1256:
      label1259:
      for (;;)
      {
        if ((paramString == null) || (paramString.equals(paramStrategyLib.a())) || (paramString.equals(paramStrategyLib.b())))
        {
          if (b.b()) {
            b.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (b.b()) {
            b.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (b.b()) {
            b.b("StrategyProvider", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
          }
          return null;
        }
        paramStrategyLib = localStrategyInfo.a();
        paramStrategyLib.a(new IPInfo(paramString, i));
        return paramStrategyLib;
        if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == ((DownloadGlobalStrategy.StrategyInfo)localObject).jdField_a_of_type_Int)
            {
              if ((jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                break label706;
              }
              i = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (b.b()) {
                  b.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          paramString = com.tencent.component.network.module.common.a.a().a(str);
          if ((paramString == null) || (paramString.equals(paramStrategyLib.c())) || (paramString.equals(paramStrategyLib.a())))
          {
            if (b.b()) {
              b.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (b.b()) {
              b.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
          }
          paramStrategyLib.b(paramString);
          paramStrategyLib = localStrategyInfo.a();
          paramStrategyLib.a(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == ((DownloadGlobalStrategy.StrategyInfo)localObject).jdField_a_of_type_Int)
            {
              if ((jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                break label1021;
              }
              i = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (b.b()) {
                  b.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          localObject = paramStrategyLib.a();
          paramString = (String)localObject;
          if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPConfigStrategy == null) {
            break label1256;
          }
          paramString = (String)localObject;
          if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPConfigStrategy.a((String)localObject, str)) {
            break label1256;
          }
          localObject = jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPConfigStrategy.a(str);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1164;
          }
          paramStrategyLib.a((String)localObject);
          paramString = (String)localObject;
        }
        for (;;)
        {
          if ((paramString == null) || (paramString.equals(paramStrategyLib.c())) || (paramString.equals(paramStrategyLib.b())))
          {
            if (b.b()) {
              b.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            label1021:
            if (b.b()) {
              b.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (DownloadGlobalStrategy.b.jdField_a_of_type_Int != localStrategyInfo.jdField_a_of_type_Int)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.c.jdField_a_of_type_Int != localStrategyInfo.jdField_a_of_type_Int) {
                break;
              }
            }
            paramString = Global.a();
            if (DownloadGlobalStrategy.c.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int) {}
            for (boolean bool = true; NetworkUtils.a(paramString, bool) == null; bool = false)
            {
              if (b.b()) {
                b.b("StrategyProvider", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
            return localStrategyInfo;
            if (b.b()) {
              b.b("StrategyProvider", "downloader strategy: resolve ip failed! threadId:" + Thread.currentThread().getId());
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.b.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int) {
              break label1256;
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.c.jdField_a_of_type_Int == localStrategyInfo.jdField_a_of_type_Int) {
              break label1256;
            }
            return null;
          }
          paramStrategyLib = localStrategyInfo.a();
          paramStrategyLib.a(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
      }
    }
  }
  
  public static DownloadGlobalStrategy.StrategyLib a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = com.tencent.component.network.downloader.common.a.a(paramString);
    return DownloadGlobalStrategy.a(Global.a()).a(paramString, str);
  }
  
  public static StrategyProvider.ExecuteResult a(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, StrategyProvider.RequestProcessor paramRequestProcessor, HttpRequest paramHttpRequest, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport, HttpHost paramHttpHost, e.a parama)
  {
    StrategyProvider.ExecuteResult localExecuteResult = new StrategyProvider.ExecuteResult();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    paramHttpRequest = null;
    Object localObject1 = localObject5;
    Object localObject3 = localObject6;
    for (;;)
    {
      try
      {
        paramStrategyLib = a(paramString, paramStrategyLib, paramInt);
        if (paramStrategyLib == null)
        {
          localExecuteResult.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = null;
          localExecuteResult.jdField_a_of_type_OrgApacheHttpHttpResponse = null;
          localExecuteResult.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = paramStrategyLib;
          return null;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        e.b localb = (e.b)jdField_a_of_type_JavaLangThreadLocal.get();
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.jdField_a_of_type_Boolean = paramStrategyLib.jdField_a_of_type_Boolean;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.b = paramStrategyLib.b;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.jdField_a_of_type_OrgApacheHttpHttpHost = paramHttpHost;
        if (paramStrategyLib == null) {
          break label789;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (paramStrategyLib.a() == null) {
          break label789;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (TextUtils.isEmpty(paramStrategyLib.a().jdField_a_of_type_JavaLangString)) {
          break label789;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramHttpHost = paramStrategyLib.a().jdField_a_of_type_JavaLangString;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (com.tencent.component.network.downloader.common.a.a(paramHttpHost, ':') >= 2) {
          break label783;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramInt = com.tencent.component.network.downloader.common.a.a(paramString);
        if (paramInt <= 0) {
          continue;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramStrategyLib.a().jdField_a_of_type_Int = paramInt;
        int i = paramInt;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (!com.tencent.component.network.downloader.common.a.a(paramInt)) {
          i = 80;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        String str = paramHttpHost + ":" + i;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localObject4 = paramString.replaceFirst(com.tencent.component.network.downloader.common.a.b(paramString), str);
        paramHttpHost = (HttpHost)localObject4;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (b.b())
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          b.b("StrategyProvider", "downloader strategy run: " + paramStrategyLib.toString() + " domain:" + str + " url:" + paramString + " threadId:" + Thread.currentThread().getId());
          paramHttpHost = (HttpHost)localObject4;
        }
        localObject4 = paramHttpHost;
        if (paramDownloadReport != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          paramDownloadReport.f = paramStrategyLib.toString();
          localObject4 = paramHttpHost;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramDownloadReport = e.a(Global.a(), paramString, com.tencent.component.network.downloader.common.a.a(paramString), (String)localObject4, localb);
        if (paramRequestProcessor != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = paramDownloadReport;
          localObject2 = paramStrategyLib;
          localObject3 = paramDownloadReport;
          paramRequestProcessor.a(paramString, paramDownloadReport);
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = e.a();
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        localExecuteResult.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = paramString;
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = a(parama).execute(paramDownloadReport, paramString);
        localExecuteResult.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = paramDownloadReport;
        localExecuteResult.jdField_a_of_type_OrgApacheHttpHttpResponse = paramString;
      }
      catch (Throwable paramString)
      {
        if (paramDownloadResult == null) {
          continue;
        }
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        paramDownloadResult.a().a(paramString);
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        localExecuteResult.jdField_a_of_type_JavaLangThrowable = paramString;
        localExecuteResult.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = ((HttpGet)localObject1);
        localExecuteResult.jdField_a_of_type_OrgApacheHttpHttpResponse = null;
        paramStrategyLib = paramHttpRequest;
        continue;
      }
      finally
      {
        localExecuteResult.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = ((HttpGet)localObject3);
        localExecuteResult.jdField_a_of_type_OrgApacheHttpHttpResponse = null;
        localExecuteResult.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = ((DownloadGlobalStrategy.StrategyInfo)localObject2);
      }
      localExecuteResult.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = paramStrategyLib;
      return localExecuteResult;
      paramHttpRequest = paramStrategyLib;
      localObject1 = localObject5;
      localObject2 = paramStrategyLib;
      localObject3 = localObject6;
      paramInt = paramStrategyLib.a().jdField_a_of_type_Int;
      continue;
      label783:
      paramHttpHost = paramString;
      continue;
      label789:
      Object localObject4 = paramString;
    }
  }
  
  public static List a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = com.tencent.component.network.downloader.common.a.a(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = DownloadGlobalStrategy.a(Global.a()).a(paramString, (String)localObject2);
    int i;
    if ((localObject3 != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).a() != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).a()))
    {
      paramString = ((DownloadGlobalStrategy.StrategyInfo)localObject3).a().jdField_a_of_type_JavaLangString;
      ((List)localObject1).add(paramString);
      if (((DownloadGlobalStrategy.StrategyInfo)localObject3).a().jdField_a_of_type_Int != 0)
      {
        i = ((DownloadGlobalStrategy.StrategyInfo)localObject3).a().jdField_a_of_type_Int;
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (DownloaderFactory.a(Global.a()).a() != null)
      {
        if (localArrayList2.size() <= 0) {
          break label407;
        }
        i = DownloaderFactory.a(Global.a()).a().a((String)localObject2, ((Integer)localArrayList2.get(0)).intValue());
        if (i != ((Integer)localArrayList2.get(0)).intValue()) {
          localArrayList2.add(Integer.valueOf(i));
        }
      }
      for (;;)
      {
        if (DownloaderFactory.a(Global.a()).a() != null)
        {
          localObject3 = DownloaderFactory.a(Global.a()).a().a((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equalsIgnoreCase(paramString))) {
            ((List)localObject1).add(localObject3);
          }
        }
        if (DownloaderFactory.a(Global.a()).b() != null)
        {
          localObject2 = DownloaderFactory.a(Global.a()).b().a((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase(paramString))) {
            ((List)localObject1).add(localObject2);
          }
        }
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          localObject2 = localArrayList2.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList1.add(new IPInfo((String)localObject1, ((Integer)((Iterator)localObject2).next()).intValue()));
          }
        }
        i = 80;
        break;
        label407:
        localArrayList2.add(Integer.valueOf(80));
      }
      return localArrayList1;
      paramString = null;
    }
  }
  
  private static HttpClient a(e.a parama)
  {
    if (jdField_a_of_type_OrgApacheHttpClientHttpClient != null) {
      return jdField_a_of_type_OrgApacheHttpClientHttpClient;
    }
    if (parama != null) {}
    for (;;)
    {
      try
      {
        jdField_a_of_type_OrgApacheHttpClientHttpClient = e.a(parama);
        a(jdField_a_of_type_OrgApacheHttpClientHttpClient);
        return jdField_a_of_type_OrgApacheHttpClientHttpClient;
      }
      finally {}
      parama = jdField_a_of_type_ComTencentComponentNetworkUtilsAE$a;
    }
  }
  
  public static void a(String paramString, IPInfo paramIPInfo, boolean paramBoolean)
  {
    String str = com.tencent.component.network.downloader.common.a.a(paramString);
    if ((TextUtils.isEmpty(str)) || (paramIPInfo == null)) {
      return;
    }
    if (DownloaderFactory.a(Global.a()).a() != null) {
      DownloaderFactory.a(Global.a()).a().a(str, paramIPInfo.jdField_a_of_type_JavaLangString, paramBoolean);
    }
    if (DownloaderFactory.a(Global.a()).b() != null) {
      DownloaderFactory.a(Global.a()).b().a(str, paramIPInfo.jdField_a_of_type_JavaLangString, paramBoolean);
    }
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = new DownloadGlobalStrategy.StrategyInfo(false, false, false);
    localStrategyInfo.jdField_a_of_type_Int = 0;
    localStrategyInfo.a(paramIPInfo);
    DownloadGlobalStrategy.a(Global.a()).a(Global.a(), paramString, str, localStrategyInfo, paramBoolean);
  }
  
  private static void a(HttpClient paramHttpClient)
  {
    if (paramHttpClient == null) {}
    while (!(paramHttpClient instanceof AbstractHttpClient)) {
      return;
    }
    ((AbstractHttpClient)paramHttpClient).setReuseStrategy(new DownloadConnectionReuseStrategy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */