package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class i
  extends a
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List jdField_a_of_type_JavaUtilList;
  private String jdField_a_of_type_JavaLangString;
  HttpResponse jdField_a_of_type_OrgApacheHttpHttpResponse = null;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[this.jdField_d_of_type_Int];
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int jdField_d_of_type_Int = 4;
  private final long jdField_d_of_type_Long = SystemClock.uptimeMillis();
  
  public i(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean);
    this.jdField_c_of_type_Int = 0;
  }
  
  private int a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return 0;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-ErrNo").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return 0;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "{" + "1.1" + "," + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + NetworkManager.a() + "," + NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext) + "}";
  }
  
  private void a(HttpGet paramHttpGet, HttpResponse paramHttpResponse)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n/****************************************************/\n");
    int i;
    if (paramHttpGet != null)
    {
      localStringBuffer.append("<---------Request Content--------->\n").append(paramHttpGet.getRequestLine()).append("\n");
      paramHttpGet = paramHttpGet.getAllHeaders();
      if (paramHttpGet != null)
      {
        i = 0;
        while (i < paramHttpGet.length)
        {
          localStringBuffer.append(paramHttpGet[i].getName()).append(": ").append(paramHttpGet[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    if (paramHttpResponse != null)
    {
      localStringBuffer.append("<---------Response Headers--------->\n").append(paramHttpResponse.getStatusLine()).append("\n");
      paramHttpGet = paramHttpResponse.getAllHeaders();
      if (paramHttpGet != null)
      {
        i = j;
        while (i < paramHttpGet.length)
        {
          localStringBuffer.append(paramHttpGet[i].getName()).append(": ").append(paramHttpGet[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("/****************************************************/");
    b.c("downloader", "Http Details:" + localStringBuffer.toString());
  }
  
  private boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib == null)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib = DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(a(), b());
      f();
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(false);
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(paramInt);
    if (b.b()) {
      b.b("downloader", "downloader strategy: " + this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c() + " url:" + a() + " Apn:" + NetworkManager.a() + " ISP:" + NetworkManager.a() + " threadid:" + Thread.currentThread().getId());
    }
    this.jdField_a_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_b_of_type_Boolean;
    String str = b();
    int i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b();
    paramInt = i;
    if (!com.tencent.component.network.downloader.common.a.a(i))
    {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(80);
      paramInt = 80;
    }
    if (DownloadGlobalStrategy.d.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.d.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
            break label543;
          }
          i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
          if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i))) {
            if (b.b()) {
              b.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            }
          }
        }
      }
      label543:
      do
      {
        do
        {
          do
          {
            return false;
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c();
            localObject1 = localObject2;
            if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
            {
              localObject1 = localObject2;
              if (!this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, (String)localObject2))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c(null);
                localObject1 = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c((String)localObject1);
              }
            }
            if ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
              break label619;
            }
          } while (!b.b());
          b.b("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
        } while (!b.b());
        b.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
      } while (!b.b());
      b.b("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return false;
      label619:
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
    }
    for (;;)
    {
      b(NetworkManager.a());
      return true;
      if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
          {
            if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
              break label890;
            }
            i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
            {
              if (!b.b()) {
                break;
              }
              b.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
        localObject1 = com.tencent.component.network.module.common.a.a().a(str);
        if ((localObject1 == null) || (((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) || (((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())))
        {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b(null);
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          label890:
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b((String)localObject1);
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
        continue;
      }
      if (6 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = com.tencent.component.network.module.common.a.a().a(str);
          }
        }
        if (localObject1 == null)
        {
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, 80));
        continue;
      }
      if (7 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
        {
          localObject2 = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = com.tencent.component.network.module.common.a.a().a(str);
          }
        }
        if (localObject1 == null)
        {
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, 80));
        continue;
      }
      if (8 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
      {
        localObject1 = null;
        label1245:
        paramInt = e();
        if (paramInt == 0) {}
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = com.tencent.component.network.module.common.a.a().a(str);
          }
          if (localObject2 != null) {
            break label1360;
          }
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
          return false;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null) {
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, paramInt);
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1245;
          }
          localObject1 = localObject2;
        }
        label1360:
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject2, 80));
      }
      else if (9 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
      {
        localObject1 = null;
        label1407:
        paramInt = e();
        if (paramInt == 0) {}
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = com.tencent.component.network.module.common.a.a().a(str);
          }
          if (localObject2 != null) {
            break label1522;
          }
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
          return false;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null) {
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, paramInt);
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1407;
          }
          localObject1 = localObject2;
        }
        label1522:
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject2, 80));
      }
      else
      {
        if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
            {
              if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                break label1848;
              }
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (!b.b()) {
                  break;
                }
                b.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1848:
        do
        {
          localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
          {
            localObject1 = localObject2;
            if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a((String)localObject2, str))
            {
              this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(null);
              localObject1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1998;
              }
              this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a((String)localObject1);
            }
          }
          if ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
            break label2036;
          }
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
          if (DownloadGlobalStrategy.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
            break label1920;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.c.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int);
        label1920:
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        if (DownloadGlobalStrategy.c.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {}
        for (boolean bool = true;; bool = false)
        {
          if (NetworkUtils.a((Context)localObject1, bool) != null) {
            break label1996;
          }
          if (!b.b()) {
            break;
          }
          b.b("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        label1996:
        return true;
        label1998:
        if (!b.b()) {
          break;
        }
        b.b("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label2036:
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
      }
    }
  }
  
  private int b(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return -1;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-RtFlag").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return -1;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.jdField_d_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfInt[(paramInt - 1)] = 1;
  }
  
  private int e()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_d_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == 0)
        {
          this.jdField_a_of_type_ArrayOfInt[i] = 1;
          j = i + 1;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private void f()
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilList == null)
        {
          jdField_a_of_type_JavaUtilList = new ArrayList();
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
          localStrategyInfo1.jdField_a_of_type_Int = 6;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
          localStrategyInfo2.jdField_a_of_type_Int = 7;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
          localStrategyInfo3.jdField_a_of_type_Int = 8;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo4 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
          localStrategyInfo4.jdField_a_of_type_Int = 9;
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo1);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo2);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo3);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo4);
        }
        return;
      }
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_b_of_type_JavaLangString = com.tencent.component.network.downloader.common.a.b(a());
    this.jdField_c_of_type_Int = com.tencent.component.network.downloader.common.a.a(a());
  }
  
  /* Error */
  public void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 386
    //   6: astore 18
    //   8: iconst_2
    //   9: anewarray 20	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_0
    //   15: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: invokestatic 391	cug:a	([Ljava/lang/Object;)I
    //   26: istore 11
    //   28: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   31: lstore 12
    //   33: aload_1
    //   34: invokeinterface 395 1 0
    //   39: ifeq +11 -> 50
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: aconst_null
    //   46: invokevirtual 398	com/tencent/component/network/downloader/impl/i:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   49: return
    //   50: aload_0
    //   51: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   54: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   57: ifne +30 -> 87
    //   60: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   63: lload 12
    //   65: lsub
    //   66: ldc2_w 399
    //   69: lcmp
    //   70: ifgt +17 -> 87
    //   73: ldc2_w 401
    //   76: invokestatic 406	java/lang/Thread:sleep	(J)V
    //   79: goto -29 -> 50
    //   82: astore 17
    //   84: goto -34 -> 50
    //   87: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   90: lload 12
    //   92: lsub
    //   93: ldc2_w 399
    //   96: lcmp
    //   97: ifle +77 -> 174
    //   100: aload 18
    //   102: astore_1
    //   103: iload 4
    //   105: istore_3
    //   106: aload_0
    //   107: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   110: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   113: ifne +12 -> 125
    //   116: aload_2
    //   117: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   120: bipush 6
    //   122: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   125: aload_2
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   131: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:a	()I
    //   134: aload_2
    //   135: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   138: getfield 418	com/tencent/component/network/downloader/DownloadResult$Status:o	I
    //   141: iload_3
    //   142: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   145: ldc_w 386
    //   148: aload_2
    //   149: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   152: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: aload_1
    //   156: invokespecial 427	com/tencent/component/network/downloader/impl/i:a	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 428	com/tencent/component/network/downloader/DownloadResult:b	(Ljava/lang/String;)V
    //   162: return
    //   163: astore_1
    //   164: ldc 148
    //   166: ldc_w 386
    //   169: aload_1
    //   170: invokestatic 431	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: return
    //   174: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   177: lstore 14
    //   179: new 433	com/tencent/component/network/downloader/DownloadReport
    //   182: dup
    //   183: invokespecial 434	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   186: astore 20
    //   188: aload 20
    //   190: iload 11
    //   192: putfield 435	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_Int	I
    //   195: aload 20
    //   197: aload_0
    //   198: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   201: putfield 436	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   204: aload 20
    //   206: aload_0
    //   207: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   210: putfield 438	com/tencent/component/network/downloader/DownloadReport:e	Ljava/lang/String;
    //   213: aload 20
    //   215: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   218: putfield 445	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_Long	J
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   231: iconst_0
    //   232: istore 9
    //   234: iconst_0
    //   235: istore 10
    //   237: iconst_0
    //   238: istore 8
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   245: invokespecial 451	com/tencent/component/network/downloader/impl/i:a	(I)Z
    //   248: istore 16
    //   250: iload 16
    //   252: ifne +30 -> 282
    //   255: iload 4
    //   257: istore_3
    //   258: aload 18
    //   260: astore 17
    //   262: aload 17
    //   264: astore 18
    //   266: iload_3
    //   267: istore 4
    //   269: aload_0
    //   270: invokevirtual 452	com/tencent/component/network/downloader/impl/i:a	()Z
    //   273: ifne -240 -> 33
    //   276: aload 17
    //   278: astore_1
    //   279: goto -173 -> 106
    //   282: aconst_null
    //   283: astore 17
    //   285: aload 17
    //   287: ifnull +906 -> 1193
    //   290: iload 8
    //   292: istore 5
    //   294: iload 10
    //   296: istore 6
    //   298: aload 17
    //   300: athrow
    //   301: astore 19
    //   303: aload_2
    //   304: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   307: aload 19
    //   309: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult$Status:a	(Ljava/lang/Throwable;)V
    //   312: iload 4
    //   314: iconst_1
    //   315: iadd
    //   316: istore 4
    //   318: aload_2
    //   319: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   322: lload 14
    //   324: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   327: invokevirtual 463	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   330: aload_0
    //   331: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   334: invokestatic 468	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   337: invokevirtual 471	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   340: astore 21
    //   342: aload_0
    //   343: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   346: ifnull +5028 -> 5374
    //   349: aload_0
    //   350: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   353: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   356: ifnull +5018 -> 5374
    //   359: aload_0
    //   360: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   363: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   366: invokevirtual 475	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   369: astore 17
    //   371: aload 17
    //   373: ifnull +5009 -> 5382
    //   376: aload 17
    //   378: astore 18
    //   380: aload_2
    //   381: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   384: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   387: ifne +60 -> 447
    //   390: aload_0
    //   391: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   394: ifnull +24 -> 418
    //   397: aload_0
    //   398: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   401: aload_0
    //   402: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   405: aload_2
    //   406: invokevirtual 480	com/tencent/component/network/downloader/DownloadResult:b	()Ljava/lang/String;
    //   409: aload_0
    //   410: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   413: invokeinterface 485 4 0
    //   418: aload_0
    //   419: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   422: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   425: ifne +22 -> 447
    //   428: aload_0
    //   429: aload_0
    //   430: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   433: iconst_1
    //   434: isub
    //   435: putfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   438: aload_2
    //   439: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   442: bipush 6
    //   444: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   447: aload_1
    //   448: invokeinterface 395 1 0
    //   453: ifne +705 -> 1158
    //   456: aload_2
    //   457: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   460: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   463: ifne +4927 -> 5390
    //   466: new 71	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 487
    //   476: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   483: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 489
    //   489: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 21
    //   494: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   497: ldc_w 494
    //   500: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 17
    //   505: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 496
    //   511: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 498
    //   517: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 500
    //   523: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   529: invokevirtual 227	java/lang/Thread:getId	()J
    //   532: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: ldc_w 502
    //   538: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   544: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 504
    //   550: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload_0
    //   554: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   557: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   560: ldc_w 506
    //   563: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   570: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   573: ldc_w 508
    //   576: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: astore 22
    //   581: aload_0
    //   582: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   585: ifeq +5235 -> 5820
    //   588: aload_0
    //   589: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   592: aload_0
    //   593: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   596: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   599: astore 17
    //   601: aload 22
    //   603: aload 17
    //   605: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   608: ldc_w 510
    //   611: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_0
    //   615: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   618: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   621: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: ldc_w 512
    //   627: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_2
    //   631: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   634: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: ldc_w 514
    //   643: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload_2
    //   647: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   650: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   653: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   656: ldc_w 518
    //   659: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   665: aload_0
    //   666: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   669: lsub
    //   670: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   673: ldc_w 520
    //   676: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_2
    //   680: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   683: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   686: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   689: ldc 82
    //   691: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_2
    //   695: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   698: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   701: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   704: ldc_w 525
    //   707: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 527
    //   713: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload_2
    //   717: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   720: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   723: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   726: ldc_w 530
    //   729: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_0
    //   733: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   736: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   739: ldc 82
    //   741: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_0
    //   745: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   748: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: ldc_w 525
    //   754: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: ldc_w 533
    //   760: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: iload 4
    //   765: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   768: ldc_w 525
    //   771: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc_w 535
    //   777: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_2
    //   781: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   784: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:a	()I
    //   787: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: ldc_w 537
    //   793: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: iload 5
    //   798: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: ldc_w 539
    //   804: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload_0
    //   808: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   811: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 542
    //   817: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: astore 17
    //   822: aload_0
    //   823: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   826: ifnull +5000 -> 5826
    //   829: aload_0
    //   830: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   833: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   836: istore_3
    //   837: aload 17
    //   839: iload_3
    //   840: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 544
    //   846: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_2
    //   850: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   853: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   856: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc_w 548
    //   862: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: aload_0
    //   866: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   869: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: ldc_w 525
    //   875: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: ldc_w 552
    //   881: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: astore 22
    //   886: aload_0
    //   887: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   890: ifnull +4941 -> 5831
    //   893: aload_0
    //   894: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   897: invokeinterface 560 1 0
    //   902: astore 17
    //   904: ldc 148
    //   906: aload 22
    //   908: aload 17
    //   910: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   913: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: aload 19
    //   918: invokestatic 431	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   921: getstatic 249	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   924: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   927: aload_0
    //   928: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   931: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   934: if_icmpne +37 -> 971
    //   937: aload_0
    //   938: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   941: ifnull +30 -> 971
    //   944: aload_0
    //   945: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   948: aload_0
    //   949: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   952: aload_0
    //   953: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   956: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   959: aload_2
    //   960: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   963: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   966: invokeinterface 564 4 0
    //   971: getstatic 346	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   974: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   977: aload_0
    //   978: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   981: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   984: if_icmpne +37 -> 1021
    //   987: aload_0
    //   988: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   991: ifnull +30 -> 1021
    //   994: aload_0
    //   995: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   998: aload_0
    //   999: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1002: aload_0
    //   1003: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1006: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1009: aload_2
    //   1010: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1013: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   1016: invokeinterface 564 4 0
    //   1021: aload 20
    //   1023: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   1026: putfield 565	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Long	J
    //   1029: aload 20
    //   1031: aload_0
    //   1032: getfield 566	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Long	J
    //   1035: putfield 567	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_Long	J
    //   1038: aload 20
    //   1040: aload_0
    //   1041: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1044: putfield 568	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1047: aload 20
    //   1049: iload 5
    //   1051: putfield 569	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Int	I
    //   1054: aload 20
    //   1056: aload 19
    //   1058: putfield 572	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   1061: aload 21
    //   1063: ifnonnull +4821 -> 5884
    //   1066: aconst_null
    //   1067: astore 17
    //   1069: aload 20
    //   1071: aload 17
    //   1073: putfield 573	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1076: aload_0
    //   1077: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1080: ifnull +4814 -> 5894
    //   1083: aload_0
    //   1084: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1087: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1090: ifnull +4804 -> 5894
    //   1093: aload_0
    //   1094: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1097: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1100: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1103: astore 17
    //   1105: aload 20
    //   1107: aload 17
    //   1109: putfield 575	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1112: aload 20
    //   1114: ldc_w 498
    //   1117: putfield 577	com/tencent/component/network/downloader/DownloadReport:d	Ljava/lang/String;
    //   1120: aload 20
    //   1122: aload_2
    //   1123: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1126: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1129: putfield 580	com/tencent/component/network/downloader/DownloadReport:g	Ljava/lang/String;
    //   1132: aload 20
    //   1134: aload_2
    //   1135: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1138: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1141: putfield 583	com/tencent/component/network/downloader/DownloadReport:h	Ljava/lang/String;
    //   1144: aload_2
    //   1145: aload 20
    //   1147: invokevirtual 586	com/tencent/component/network/downloader/DownloadResult:a	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1150: aload_0
    //   1151: aload_1
    //   1152: aload_2
    //   1153: aload 20
    //   1155: invokevirtual 398	com/tencent/component/network/downloader/impl/i:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1158: aload 18
    //   1160: astore 17
    //   1162: iload 4
    //   1164: istore_3
    //   1165: aload_0
    //   1166: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1169: ifnull -907 -> 262
    //   1172: aload_0
    //   1173: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1176: astore 19
    //   1178: iload 4
    //   1180: istore_3
    //   1181: aload 18
    //   1183: astore 17
    //   1185: aload 19
    //   1187: invokevirtual 589	org/apache/http/client/methods/HttpGet:abort	()V
    //   1190: goto -928 -> 262
    //   1193: iload 8
    //   1195: istore 5
    //   1197: iload 10
    //   1199: istore 6
    //   1201: getstatic 592	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangThreadLocal	Ljava/lang/ThreadLocal;
    //   1204: invokevirtual 598	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1207: checkcast 600	com/tencent/component/network/utils/a/e$b
    //   1210: astore 19
    //   1212: iload 8
    //   1214: istore 5
    //   1216: iload 10
    //   1218: istore 6
    //   1220: aload 19
    //   1222: aload_0
    //   1223: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   1226: putfield 601	com/tencent/component/network/utils/a/e$b:jdField_a_of_type_Boolean	Z
    //   1229: iload 8
    //   1231: istore 5
    //   1233: iload 10
    //   1235: istore 6
    //   1237: aload 19
    //   1239: aload_0
    //   1240: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   1243: putfield 602	com/tencent/component/network/utils/a/e$b:jdField_b_of_type_Boolean	Z
    //   1246: iload 8
    //   1248: istore 5
    //   1250: iload 10
    //   1252: istore 6
    //   1254: aload_0
    //   1255: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1258: ifnull +1651 -> 2909
    //   1261: iload 8
    //   1263: istore 5
    //   1265: iload 10
    //   1267: istore 6
    //   1269: aload_0
    //   1270: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1273: invokeinterface 560 1 0
    //   1278: astore 17
    //   1280: iload 8
    //   1282: istore 5
    //   1284: iload 10
    //   1286: istore 6
    //   1288: aload 19
    //   1290: aload 17
    //   1292: putfield 605	com/tencent/component/network/utils/a/e$b:jdField_a_of_type_OrgApacheHttpHttpHost	Lorg/apache/http/HttpHost;
    //   1295: iload 8
    //   1297: istore 5
    //   1299: iload 10
    //   1301: istore 6
    //   1303: aload 20
    //   1305: iload 4
    //   1307: putfield 606	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_Int	I
    //   1310: iload 8
    //   1312: istore 5
    //   1314: iload 10
    //   1316: istore 6
    //   1318: aload_2
    //   1319: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult:a	()V
    //   1322: iload 8
    //   1324: istore 5
    //   1326: iload 10
    //   1328: istore 6
    //   1330: aload_0
    //   1331: aload_0
    //   1332: aload_0
    //   1333: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1336: invokevirtual 608	com/tencent/component/network/downloader/impl/i:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1339: putfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1342: iload 8
    //   1344: istore 5
    //   1346: iload 10
    //   1348: istore 6
    //   1350: aload 19
    //   1352: getfield 605	com/tencent/component/network/utils/a/e$b:jdField_a_of_type_OrgApacheHttpHttpHost	Lorg/apache/http/HttpHost;
    //   1355: ifnonnull +385 -> 1740
    //   1358: iload 8
    //   1360: istore 5
    //   1362: iload 10
    //   1364: istore 6
    //   1366: aload_0
    //   1367: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1370: ldc_w 610
    //   1373: invokevirtual 613	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1376: ifne +364 -> 1740
    //   1379: iload 8
    //   1381: istore 5
    //   1383: iload 10
    //   1385: istore 6
    //   1387: aload_0
    //   1388: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1391: ifnull +349 -> 1740
    //   1394: iload 8
    //   1396: istore 5
    //   1398: iload 10
    //   1400: istore 6
    //   1402: aload_0
    //   1403: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1406: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1409: ifnull +331 -> 1740
    //   1412: iload 8
    //   1414: istore 5
    //   1416: iload 10
    //   1418: istore 6
    //   1420: aload_0
    //   1421: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1424: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1427: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1430: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1433: ifne +307 -> 1740
    //   1436: iload 8
    //   1438: istore 5
    //   1440: iload 10
    //   1442: istore 6
    //   1444: aload_0
    //   1445: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1448: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1451: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1454: astore 18
    //   1456: iload 8
    //   1458: istore 5
    //   1460: iload 10
    //   1462: istore 6
    //   1464: aload_0
    //   1465: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1468: astore 17
    //   1470: iload 8
    //   1472: istore 5
    //   1474: iload 10
    //   1476: istore 6
    //   1478: aload 18
    //   1480: bipush 58
    //   1482: invokestatic 616	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;C)I
    //   1485: iconst_2
    //   1486: if_icmpge +145 -> 1631
    //   1489: iload 8
    //   1491: istore 5
    //   1493: iload 10
    //   1495: istore 6
    //   1497: aload_0
    //   1498: getfield 31	com/tencent/component/network/downloader/impl/i:jdField_c_of_type_Int	I
    //   1501: istore_3
    //   1502: iload_3
    //   1503: ifle +1412 -> 2915
    //   1506: iload 8
    //   1508: istore 5
    //   1510: iload 10
    //   1512: istore 6
    //   1514: aload_0
    //   1515: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1518: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1521: iload_3
    //   1522: putfield 617	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   1525: iload 8
    //   1527: istore 5
    //   1529: iload_3
    //   1530: istore 7
    //   1532: iload 10
    //   1534: istore 6
    //   1536: iload_3
    //   1537: invokestatic 244	com/tencent/component/network/downloader/common/a:a	(I)Z
    //   1540: ifne +7 -> 1547
    //   1543: bipush 80
    //   1545: istore 7
    //   1547: iload 8
    //   1549: istore 5
    //   1551: iload 10
    //   1553: istore 6
    //   1555: new 71	java/lang/StringBuilder
    //   1558: dup
    //   1559: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1562: aload 18
    //   1564: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: ldc_w 619
    //   1570: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: iload 7
    //   1575: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1578: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: astore 18
    //   1583: iload 8
    //   1585: istore 5
    //   1587: aload 18
    //   1589: astore 17
    //   1591: iload 10
    //   1593: istore 6
    //   1595: aload_0
    //   1596: getfield 378	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1599: ifnull +32 -> 1631
    //   1602: iload 8
    //   1604: istore 5
    //   1606: iload 10
    //   1608: istore 6
    //   1610: aload_0
    //   1611: aload_0
    //   1612: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1615: aload_0
    //   1616: getfield 378	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1619: aload 18
    //   1621: invokevirtual 623	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1624: putfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1627: aload 18
    //   1629: astore 17
    //   1631: iload 8
    //   1633: istore 5
    //   1635: iload 10
    //   1637: istore 6
    //   1639: aload 20
    //   1641: aload_0
    //   1642: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1645: invokevirtual 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1648: putfield 625	com/tencent/component/network/downloader/DownloadReport:f	Ljava/lang/String;
    //   1651: iload 8
    //   1653: istore 5
    //   1655: iload 10
    //   1657: istore 6
    //   1659: invokestatic 198	com/tencent/component/network/module/base/b:b	()Z
    //   1662: ifeq +78 -> 1740
    //   1665: iload 8
    //   1667: istore 5
    //   1669: iload 10
    //   1671: istore 6
    //   1673: ldc 148
    //   1675: new 71	java/lang/StringBuilder
    //   1678: dup
    //   1679: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1682: ldc_w 627
    //   1685: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: aload 20
    //   1690: getfield 625	com/tencent/component/network/downloader/DownloadReport:f	Ljava/lang/String;
    //   1693: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: ldc_w 629
    //   1699: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: aload 17
    //   1704: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc 211
    //   1709: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: aload_0
    //   1713: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1716: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: ldc_w 268
    //   1722: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1728: invokevirtual 227	java/lang/Thread:getId	()J
    //   1731: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1734: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1737: invokestatic 232	com/tencent/component/network/module/base/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1740: iload 8
    //   1742: istore 5
    //   1744: iload 10
    //   1746: istore 6
    //   1748: aload_0
    //   1749: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1752: ifnull +23 -> 1775
    //   1755: iload 8
    //   1757: istore 5
    //   1759: iload 10
    //   1761: istore 6
    //   1763: aload 20
    //   1765: aload_0
    //   1766: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1769: invokevirtual 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1772: putfield 625	com/tencent/component/network/downloader/DownloadReport:f	Ljava/lang/String;
    //   1775: iload 8
    //   1777: istore 5
    //   1779: iload 10
    //   1781: istore 6
    //   1783: aload_0
    //   1784: aload_0
    //   1785: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1788: aload_0
    //   1789: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1792: aload_0
    //   1793: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1796: aload_0
    //   1797: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1800: aload 19
    //   1802: invokestatic 634	com/tencent/component/network/utils/a/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   1805: putfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1808: iload 8
    //   1810: istore 5
    //   1812: iload 10
    //   1814: istore 6
    //   1816: aload_0
    //   1817: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1820: ifnull +32 -> 1852
    //   1823: iload 8
    //   1825: istore 5
    //   1827: iload 10
    //   1829: istore 6
    //   1831: aload_0
    //   1832: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1835: aload_0
    //   1836: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1839: aload_0
    //   1840: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1843: aload_0
    //   1844: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1847: invokeinterface 637 4 0
    //   1852: iload 8
    //   1854: istore 5
    //   1856: iload 10
    //   1858: istore 6
    //   1860: aload_0
    //   1861: aload_0
    //   1862: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1865: aload_0
    //   1866: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1869: aload_0
    //   1870: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1873: invokevirtual 640	com/tencent/component/network/downloader/impl/i:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1876: iload 8
    //   1878: istore 5
    //   1880: iload 10
    //   1882: istore 6
    //   1884: aload_0
    //   1885: aload_0
    //   1886: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   1889: aload_0
    //   1890: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   1893: aload_0
    //   1894: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1897: invokevirtual 642	com/tencent/component/network/downloader/impl/i:b	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1900: iload 8
    //   1902: istore 5
    //   1904: iload 10
    //   1906: istore 6
    //   1908: invokestatic 645	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   1911: astore 17
    //   1913: iload 8
    //   1915: istore 5
    //   1917: iload 10
    //   1919: istore 6
    //   1921: aload_0
    //   1922: aload_0
    //   1923: getfield 648	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientHttpClient	Lorg/apache/http/client/HttpClient;
    //   1926: aload_0
    //   1927: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1930: aload 17
    //   1932: invokeinterface 654 3 0
    //   1937: putfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1940: iload 8
    //   1942: istore 5
    //   1944: iload 10
    //   1946: istore 6
    //   1948: aload_0
    //   1949: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1952: ifnull +2010 -> 3962
    //   1955: iload 8
    //   1957: istore 5
    //   1959: iload 10
    //   1961: istore 6
    //   1963: aload_0
    //   1964: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1967: invokeinterface 143 1 0
    //   1972: invokeinterface 659 1 0
    //   1977: istore_3
    //   1978: iload_3
    //   1979: istore 5
    //   1981: iload_3
    //   1982: istore 6
    //   1984: aload_2
    //   1985: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1988: iload_3
    //   1989: putfield 418	com/tencent/component/network/downloader/DownloadResult$Status:o	I
    //   1992: sipush 200
    //   1995: iload_3
    //   1996: if_icmpeq +10 -> 2006
    //   1999: sipush 206
    //   2002: iload_3
    //   2003: if_icmpne +934 -> 2937
    //   2006: iload_3
    //   2007: istore 5
    //   2009: iload_3
    //   2010: istore 7
    //   2012: iload_3
    //   2013: istore 6
    //   2015: aload_0
    //   2016: aload_0
    //   2017: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2020: aload_2
    //   2021: aload_1
    //   2022: iload_3
    //   2023: invokevirtual 662	com/tencent/component/network/downloader/impl/i:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2026: ifeq +1956 -> 3982
    //   2029: iload_3
    //   2030: istore 5
    //   2032: iload_3
    //   2033: istore 6
    //   2035: aload_2
    //   2036: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2039: invokevirtual 664	com/tencent/component/network/downloader/DownloadResult$Status:b	()V
    //   2042: iload 4
    //   2044: iconst_1
    //   2045: iadd
    //   2046: istore 5
    //   2048: aload_2
    //   2049: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2052: lload 14
    //   2054: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   2057: invokevirtual 463	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   2060: aload_0
    //   2061: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2064: invokestatic 468	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   2067: invokevirtual 471	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2070: astore 19
    //   2072: aload_0
    //   2073: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2076: ifnull +3824 -> 5900
    //   2079: aload_0
    //   2080: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2083: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2086: ifnull +3814 -> 5900
    //   2089: aload_0
    //   2090: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2093: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2096: invokevirtual 475	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   2099: astore 18
    //   2101: aload 18
    //   2103: ifnull +3805 -> 5908
    //   2106: aload 18
    //   2108: astore 17
    //   2110: aload_2
    //   2111: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2114: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   2117: ifne +60 -> 2177
    //   2120: aload_0
    //   2121: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2124: ifnull +24 -> 2148
    //   2127: aload_0
    //   2128: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2131: aload_0
    //   2132: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   2135: aload_2
    //   2136: invokevirtual 480	com/tencent/component/network/downloader/DownloadResult:b	()Ljava/lang/String;
    //   2139: aload_0
    //   2140: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2143: invokeinterface 485 4 0
    //   2148: aload_0
    //   2149: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2152: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   2155: ifne +22 -> 2177
    //   2158: aload_0
    //   2159: aload_0
    //   2160: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   2163: iconst_1
    //   2164: isub
    //   2165: putfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   2168: aload_2
    //   2169: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2172: bipush 6
    //   2174: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   2177: aload_1
    //   2178: invokeinterface 395 1 0
    //   2183: ifne +703 -> 2886
    //   2186: aload_2
    //   2187: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2190: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   2193: ifne +3723 -> 5916
    //   2196: new 71	java/lang/StringBuilder
    //   2199: dup
    //   2200: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2203: ldc_w 487
    //   2206: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2209: aload_0
    //   2210: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   2213: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: ldc_w 489
    //   2219: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2222: aload 19
    //   2224: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2227: ldc_w 494
    //   2230: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: aload 18
    //   2235: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: ldc_w 496
    //   2241: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2244: ldc_w 498
    //   2247: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: ldc_w 500
    //   2253: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2259: invokevirtual 227	java/lang/Thread:getId	()J
    //   2262: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2265: ldc_w 502
    //   2268: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   2274: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: ldc_w 504
    //   2280: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: aload_0
    //   2284: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   2287: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2290: ldc_w 506
    //   2293: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: aload_0
    //   2297: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   2300: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2303: ldc_w 508
    //   2306: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: astore 21
    //   2311: aload_0
    //   2312: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   2315: ifeq +4032 -> 6347
    //   2318: aload_0
    //   2319: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2322: aload_0
    //   2323: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   2326: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2329: astore 18
    //   2331: aload 21
    //   2333: aload 18
    //   2335: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2338: ldc_w 510
    //   2341: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: aload_0
    //   2345: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2348: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   2351: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2354: ldc_w 512
    //   2357: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload_2
    //   2361: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2364: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2367: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2370: ldc_w 514
    //   2373: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2376: aload_2
    //   2377: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2380: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   2383: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2386: ldc_w 518
    //   2389: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   2395: aload_0
    //   2396: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   2399: lsub
    //   2400: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2403: ldc_w 520
    //   2406: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: aload_2
    //   2410: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2413: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   2416: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2419: ldc 82
    //   2421: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2424: aload_2
    //   2425: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2428: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   2431: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2434: ldc_w 525
    //   2437: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: ldc_w 527
    //   2443: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: aload_2
    //   2447: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2450: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   2453: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2456: ldc_w 530
    //   2459: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: aload_0
    //   2463: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   2466: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2469: ldc 82
    //   2471: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: aload_0
    //   2475: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   2478: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2481: ldc_w 525
    //   2484: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: ldc_w 533
    //   2490: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: iload 5
    //   2495: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2498: ldc_w 525
    //   2501: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2504: ldc_w 535
    //   2507: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2510: aload_2
    //   2511: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2514: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:a	()I
    //   2517: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2520: ldc_w 537
    //   2523: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: iload_3
    //   2527: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2530: ldc_w 539
    //   2533: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2536: aload_0
    //   2537: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2540: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: ldc_w 542
    //   2546: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: astore 18
    //   2551: aload_0
    //   2552: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2555: ifnull +3798 -> 6353
    //   2558: aload_0
    //   2559: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2562: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2565: istore 4
    //   2567: aload 18
    //   2569: iload 4
    //   2571: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2574: ldc_w 544
    //   2577: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: aload_2
    //   2581: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2584: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2587: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: ldc_w 548
    //   2593: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: aload_0
    //   2597: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   2600: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2603: ldc_w 525
    //   2606: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: ldc_w 552
    //   2612: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: astore 21
    //   2617: aload_0
    //   2618: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2621: ifnull +3738 -> 6359
    //   2624: aload_0
    //   2625: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2628: invokeinterface 560 1 0
    //   2633: astore 18
    //   2635: ldc 148
    //   2637: aload 21
    //   2639: aload 18
    //   2641: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2644: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2647: aconst_null
    //   2648: invokestatic 431	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2651: getstatic 249	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2654: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2657: aload_0
    //   2658: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2661: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2664: if_icmpne +37 -> 2701
    //   2667: aload_0
    //   2668: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2671: ifnull +30 -> 2701
    //   2674: aload_0
    //   2675: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2678: aload_0
    //   2679: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   2682: aload_0
    //   2683: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2686: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2689: aload_2
    //   2690: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2693: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   2696: invokeinterface 564 4 0
    //   2701: getstatic 346	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2704: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2707: aload_0
    //   2708: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2711: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2714: if_icmpne +37 -> 2751
    //   2717: aload_0
    //   2718: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2721: ifnull +30 -> 2751
    //   2724: aload_0
    //   2725: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2728: aload_0
    //   2729: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   2732: aload_0
    //   2733: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2736: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2739: aload_2
    //   2740: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2743: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   2746: invokeinterface 564 4 0
    //   2751: aload 20
    //   2753: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   2756: putfield 565	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Long	J
    //   2759: aload 20
    //   2761: aload_0
    //   2762: getfield 566	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Long	J
    //   2765: putfield 567	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_Long	J
    //   2768: aload 20
    //   2770: aload_0
    //   2771: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2774: putfield 568	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2777: aload 20
    //   2779: iload_3
    //   2780: putfield 569	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Int	I
    //   2783: aload 20
    //   2785: aconst_null
    //   2786: putfield 572	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   2789: aload 19
    //   2791: ifnonnull +3622 -> 6413
    //   2794: aconst_null
    //   2795: astore 18
    //   2797: aload 20
    //   2799: aload 18
    //   2801: putfield 573	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2804: aload_0
    //   2805: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2808: ifnull +3615 -> 6423
    //   2811: aload_0
    //   2812: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2815: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2818: ifnull +3605 -> 6423
    //   2821: aload_0
    //   2822: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2825: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2828: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2831: astore 18
    //   2833: aload 20
    //   2835: aload 18
    //   2837: putfield 575	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2840: aload 20
    //   2842: ldc_w 498
    //   2845: putfield 577	com/tencent/component/network/downloader/DownloadReport:d	Ljava/lang/String;
    //   2848: aload 20
    //   2850: aload_2
    //   2851: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2854: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2857: putfield 580	com/tencent/component/network/downloader/DownloadReport:g	Ljava/lang/String;
    //   2860: aload 20
    //   2862: aload_2
    //   2863: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2866: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2869: putfield 583	com/tencent/component/network/downloader/DownloadReport:h	Ljava/lang/String;
    //   2872: aload_2
    //   2873: aload 20
    //   2875: invokevirtual 586	com/tencent/component/network/downloader/DownloadResult:a	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2878: aload_0
    //   2879: aload_1
    //   2880: aload_2
    //   2881: aload 20
    //   2883: invokevirtual 398	com/tencent/component/network/downloader/impl/i:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2886: aload_0
    //   2887: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2890: ifnull +10 -> 2900
    //   2893: aload_0
    //   2894: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2897: invokevirtual 589	org/apache/http/client/methods/HttpGet:abort	()V
    //   2900: aload 17
    //   2902: astore_1
    //   2903: iload 5
    //   2905: istore_3
    //   2906: goto -2800 -> 106
    //   2909: aconst_null
    //   2910: astore 17
    //   2912: goto -1632 -> 1280
    //   2915: iload 8
    //   2917: istore 5
    //   2919: iload 10
    //   2921: istore 6
    //   2923: aload_0
    //   2924: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2927: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2930: getfield 617	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   2933: istore_3
    //   2934: goto -1409 -> 1525
    //   2937: iload_3
    //   2938: istore 5
    //   2940: iload_3
    //   2941: istore 6
    //   2943: aload_0
    //   2944: aload_0
    //   2945: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2948: aload_0
    //   2949: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2952: invokespecial 666	com/tencent/component/network/downloader/impl/i:a	(Lorg/apache/http/client/methods/HttpGet;Lorg/apache/http/HttpResponse;)V
    //   2955: iload_3
    //   2956: istore 5
    //   2958: iload_3
    //   2959: istore 6
    //   2961: aload_0
    //   2962: aload_0
    //   2963: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2966: invokespecial 668	com/tencent/component/network/downloader/impl/i:b	(Lorg/apache/http/HttpResponse;)I
    //   2969: ifne +14 -> 2983
    //   2972: iload_3
    //   2973: istore 5
    //   2975: iload_3
    //   2976: istore 6
    //   2978: aload_0
    //   2979: iconst_0
    //   2980: invokevirtual 669	com/tencent/component/network/downloader/impl/i:a	(I)V
    //   2983: sipush 404
    //   2986: iload_3
    //   2987: if_icmpne +54 -> 3041
    //   2990: iload_3
    //   2991: istore 5
    //   2993: iload_3
    //   2994: istore 6
    //   2996: aload_0
    //   2997: aload_0
    //   2998: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   3001: invokespecial 671	com/tencent/component/network/downloader/impl/i:a	(Lorg/apache/http/HttpResponse;)I
    //   3004: istore 7
    //   3006: iload 7
    //   3008: sipush -6101
    //   3011: if_icmpeq +19 -> 3030
    //   3014: iload 7
    //   3016: sipush -5062
    //   3019: if_icmpeq +11 -> 3030
    //   3022: iload 7
    //   3024: sipush -5023
    //   3027: if_icmpne +14 -> 3041
    //   3030: iload_3
    //   3031: istore 5
    //   3033: iload_3
    //   3034: istore 6
    //   3036: aload_0
    //   3037: iconst_0
    //   3038: invokevirtual 669	com/tencent/component/network/downloader/impl/i:a	(I)V
    //   3041: iload_3
    //   3042: istore 5
    //   3044: iload_3
    //   3045: istore 6
    //   3047: aload_2
    //   3048: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3051: iconst_3
    //   3052: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   3055: iload_3
    //   3056: istore 5
    //   3058: iload_3
    //   3059: istore 6
    //   3061: aload_0
    //   3062: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3065: ifnull +23 -> 3088
    //   3068: iload_3
    //   3069: istore 5
    //   3071: iload_3
    //   3072: istore 6
    //   3074: aload_0
    //   3075: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3078: aload_0
    //   3079: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   3082: iconst_1
    //   3083: invokeinterface 674 3 0
    //   3088: iload 4
    //   3090: iconst_1
    //   3091: iadd
    //   3092: istore 4
    //   3094: aload_2
    //   3095: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3098: lload 14
    //   3100: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   3103: invokevirtual 463	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   3106: aload_0
    //   3107: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3110: invokestatic 468	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   3113: invokevirtual 471	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3116: astore 19
    //   3118: aload_0
    //   3119: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3122: ifnull +3307 -> 6429
    //   3125: aload_0
    //   3126: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3129: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3132: ifnull +3297 -> 6429
    //   3135: aload_0
    //   3136: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3139: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3142: invokevirtual 475	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3145: astore 17
    //   3147: aload 17
    //   3149: ifnull +3288 -> 6437
    //   3152: aload 17
    //   3154: astore 18
    //   3156: aload_2
    //   3157: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3160: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   3163: ifne +60 -> 3223
    //   3166: aload_0
    //   3167: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3170: ifnull +24 -> 3194
    //   3173: aload_0
    //   3174: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3177: aload_0
    //   3178: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   3181: aload_2
    //   3182: invokevirtual 480	com/tencent/component/network/downloader/DownloadResult:b	()Ljava/lang/String;
    //   3185: aload_0
    //   3186: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   3189: invokeinterface 485 4 0
    //   3194: aload_0
    //   3195: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3198: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   3201: ifne +22 -> 3223
    //   3204: aload_0
    //   3205: aload_0
    //   3206: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   3209: iconst_1
    //   3210: isub
    //   3211: putfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   3214: aload_2
    //   3215: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3218: bipush 6
    //   3220: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   3223: aload_1
    //   3224: invokeinterface 395 1 0
    //   3229: ifne +703 -> 3932
    //   3232: aload_2
    //   3233: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3236: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   3239: ifne +3206 -> 6445
    //   3242: new 71	java/lang/StringBuilder
    //   3245: dup
    //   3246: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   3249: ldc_w 487
    //   3252: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3255: aload_0
    //   3256: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   3259: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3262: ldc_w 489
    //   3265: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: aload 19
    //   3270: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3273: ldc_w 494
    //   3276: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3279: aload 17
    //   3281: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: ldc_w 496
    //   3287: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: ldc_w 498
    //   3293: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3296: ldc_w 500
    //   3299: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3302: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3305: invokevirtual 227	java/lang/Thread:getId	()J
    //   3308: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3311: ldc_w 502
    //   3314: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   3320: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3323: ldc_w 504
    //   3326: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: aload_0
    //   3330: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   3333: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3336: ldc_w 506
    //   3339: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: aload_0
    //   3343: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   3346: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3349: ldc_w 508
    //   3352: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3355: astore 21
    //   3357: aload_0
    //   3358: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   3361: ifeq +3515 -> 6876
    //   3364: aload_0
    //   3365: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3368: aload_0
    //   3369: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   3372: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3375: astore 17
    //   3377: aload 21
    //   3379: aload 17
    //   3381: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3384: ldc_w 510
    //   3387: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3390: aload_0
    //   3391: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3394: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   3397: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3400: ldc_w 512
    //   3403: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3406: aload_2
    //   3407: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3410: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3413: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3416: ldc_w 514
    //   3419: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3422: aload_2
    //   3423: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3426: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3429: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3432: ldc_w 518
    //   3435: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3438: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   3441: aload_0
    //   3442: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   3445: lsub
    //   3446: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3449: ldc_w 520
    //   3452: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3455: aload_2
    //   3456: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3459: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   3462: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3465: ldc 82
    //   3467: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: aload_2
    //   3471: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3474: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   3477: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3480: ldc_w 525
    //   3483: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3486: ldc_w 527
    //   3489: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: aload_2
    //   3493: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3496: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   3499: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3502: ldc_w 530
    //   3505: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3508: aload_0
    //   3509: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   3512: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3515: ldc 82
    //   3517: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3520: aload_0
    //   3521: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   3524: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3527: ldc_w 525
    //   3530: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3533: ldc_w 533
    //   3536: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: iload 4
    //   3541: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3544: ldc_w 525
    //   3547: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: ldc_w 535
    //   3553: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload_2
    //   3557: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3560: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:a	()I
    //   3563: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3566: ldc_w 537
    //   3569: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3572: iload_3
    //   3573: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3576: ldc_w 539
    //   3579: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3582: aload_0
    //   3583: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3586: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3589: ldc_w 542
    //   3592: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: astore 17
    //   3597: aload_0
    //   3598: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3601: ifnull +3281 -> 6882
    //   3604: aload_0
    //   3605: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3608: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3611: istore 5
    //   3613: aload 17
    //   3615: iload 5
    //   3617: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3620: ldc_w 544
    //   3623: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: aload_2
    //   3627: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3630: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3633: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3636: ldc_w 548
    //   3639: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3642: aload_0
    //   3643: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   3646: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3649: ldc_w 525
    //   3652: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3655: ldc_w 552
    //   3658: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3661: astore 21
    //   3663: aload_0
    //   3664: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3667: ifnull +3221 -> 6888
    //   3670: aload_0
    //   3671: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3674: invokeinterface 560 1 0
    //   3679: astore 17
    //   3681: ldc 148
    //   3683: aload 21
    //   3685: aload 17
    //   3687: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3690: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3693: aconst_null
    //   3694: invokestatic 431	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3697: getstatic 249	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3700: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3703: aload_0
    //   3704: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3707: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3710: if_icmpne +37 -> 3747
    //   3713: aload_0
    //   3714: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3717: ifnull +30 -> 3747
    //   3720: aload_0
    //   3721: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3724: aload_0
    //   3725: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   3728: aload_0
    //   3729: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3732: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3735: aload_2
    //   3736: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3739: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   3742: invokeinterface 564 4 0
    //   3747: getstatic 346	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3750: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3753: aload_0
    //   3754: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3757: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3760: if_icmpne +37 -> 3797
    //   3763: aload_0
    //   3764: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3767: ifnull +30 -> 3797
    //   3770: aload_0
    //   3771: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3774: aload_0
    //   3775: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   3778: aload_0
    //   3779: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3782: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3785: aload_2
    //   3786: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3789: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   3792: invokeinterface 564 4 0
    //   3797: aload 20
    //   3799: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   3802: putfield 565	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Long	J
    //   3805: aload 20
    //   3807: aload_0
    //   3808: getfield 566	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Long	J
    //   3811: putfield 567	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_Long	J
    //   3814: aload 20
    //   3816: aload_0
    //   3817: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   3820: putfield 568	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   3823: aload 20
    //   3825: iload_3
    //   3826: putfield 569	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Int	I
    //   3829: aload 20
    //   3831: aconst_null
    //   3832: putfield 572	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   3835: aload 19
    //   3837: ifnonnull +3105 -> 6942
    //   3840: aconst_null
    //   3841: astore 17
    //   3843: aload 20
    //   3845: aload 17
    //   3847: putfield 573	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3850: aload_0
    //   3851: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3854: ifnull +3098 -> 6952
    //   3857: aload_0
    //   3858: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3861: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3864: ifnull +3088 -> 6952
    //   3867: aload_0
    //   3868: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3871: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3874: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3877: astore 17
    //   3879: aload 20
    //   3881: aload 17
    //   3883: putfield 575	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3886: aload 20
    //   3888: ldc_w 498
    //   3891: putfield 577	com/tencent/component/network/downloader/DownloadReport:d	Ljava/lang/String;
    //   3894: aload 20
    //   3896: aload_2
    //   3897: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3900: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3903: putfield 580	com/tencent/component/network/downloader/DownloadReport:g	Ljava/lang/String;
    //   3906: aload 20
    //   3908: aload_2
    //   3909: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3912: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3915: putfield 583	com/tencent/component/network/downloader/DownloadReport:h	Ljava/lang/String;
    //   3918: aload_2
    //   3919: aload 20
    //   3921: invokevirtual 586	com/tencent/component/network/downloader/DownloadResult:a	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3924: aload_0
    //   3925: aload_1
    //   3926: aload_2
    //   3927: aload 20
    //   3929: invokevirtual 398	com/tencent/component/network/downloader/impl/i:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3932: aload 18
    //   3934: astore 17
    //   3936: iload 4
    //   3938: istore_3
    //   3939: aload_0
    //   3940: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   3943: ifnull -3681 -> 262
    //   3946: aload_0
    //   3947: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   3950: astore 19
    //   3952: aload 18
    //   3954: astore 17
    //   3956: iload 4
    //   3958: istore_3
    //   3959: goto -2774 -> 1185
    //   3962: iload 8
    //   3964: istore 5
    //   3966: iload 10
    //   3968: istore 6
    //   3970: aload_2
    //   3971: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3974: iconst_3
    //   3975: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   3978: iload 9
    //   3980: istore 7
    //   3982: iload 7
    //   3984: istore_3
    //   3985: goto -897 -> 3088
    //   3988: aconst_null
    //   3989: astore 18
    //   3991: aload 20
    //   3993: aload 18
    //   3995: putfield 575	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3998: aload 20
    //   4000: ldc_w 498
    //   4003: putfield 577	com/tencent/component/network/downloader/DownloadReport:d	Ljava/lang/String;
    //   4006: aload 20
    //   4008: aload_2
    //   4009: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4012: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4015: putfield 580	com/tencent/component/network/downloader/DownloadReport:g	Ljava/lang/String;
    //   4018: aload 20
    //   4020: aload_2
    //   4021: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4024: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4027: putfield 583	com/tencent/component/network/downloader/DownloadReport:h	Ljava/lang/String;
    //   4030: aload_2
    //   4031: aload 20
    //   4033: invokevirtual 586	com/tencent/component/network/downloader/DownloadResult:a	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4036: aload_0
    //   4037: aload_1
    //   4038: aload_2
    //   4039: aload 20
    //   4041: invokevirtual 398	com/tencent/component/network/downloader/impl/i:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4044: aload_0
    //   4045: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4048: ifnull +10 -> 4058
    //   4051: aload_0
    //   4052: getfield 448	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4055: invokevirtual 589	org/apache/http/client/methods/HttpGet:abort	()V
    //   4058: aload 17
    //   4060: athrow
    //   4061: astore 17
    //   4063: iload 6
    //   4065: istore 5
    //   4067: aconst_null
    //   4068: astore 19
    //   4070: iload 4
    //   4072: iconst_1
    //   4073: iadd
    //   4074: istore_3
    //   4075: aload_2
    //   4076: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4079: lload 14
    //   4081: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   4084: invokevirtual 463	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   4087: aload_0
    //   4088: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4091: invokestatic 468	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   4094: invokevirtual 471	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4097: astore 21
    //   4099: aload_0
    //   4100: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4103: ifnull +757 -> 4860
    //   4106: aload_0
    //   4107: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4110: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4113: ifnull +747 -> 4860
    //   4116: aload_0
    //   4117: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4120: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4123: invokevirtual 475	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4126: astore 18
    //   4128: aload 18
    //   4130: ifnull +738 -> 4868
    //   4133: aload_2
    //   4134: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4137: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   4140: ifne +60 -> 4200
    //   4143: aload_0
    //   4144: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4147: ifnull +24 -> 4171
    //   4150: aload_0
    //   4151: getfield 479	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4154: aload_0
    //   4155: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   4158: aload_2
    //   4159: invokevirtual 480	com/tencent/component/network/downloader/DownloadResult:b	()Ljava/lang/String;
    //   4162: aload_0
    //   4163: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4166: invokeinterface 485 4 0
    //   4171: aload_0
    //   4172: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4175: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   4178: ifne +22 -> 4200
    //   4181: aload_0
    //   4182: aload_0
    //   4183: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   4186: iconst_1
    //   4187: isub
    //   4188: putfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   4191: aload_2
    //   4192: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4195: bipush 6
    //   4197: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult$Status:a	(I)V
    //   4200: aload_1
    //   4201: invokeinterface 395 1 0
    //   4206: ifne -162 -> 4044
    //   4209: aload_2
    //   4210: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4213: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   4216: ifne +655 -> 4871
    //   4219: new 71	java/lang/StringBuilder
    //   4222: dup
    //   4223: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   4226: ldc_w 487
    //   4229: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4232: aload_0
    //   4233: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   4236: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4239: ldc_w 489
    //   4242: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4245: aload 21
    //   4247: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4250: ldc_w 494
    //   4253: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4256: aload 18
    //   4258: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4261: ldc_w 496
    //   4264: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: ldc_w 498
    //   4270: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4273: ldc_w 500
    //   4276: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4279: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4282: invokevirtual 227	java/lang/Thread:getId	()J
    //   4285: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4288: ldc_w 502
    //   4291: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   4297: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: ldc_w 504
    //   4303: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: aload_0
    //   4307: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   4310: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4313: ldc_w 506
    //   4316: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4319: aload_0
    //   4320: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   4323: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4326: ldc_w 508
    //   4329: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4332: astore 22
    //   4334: aload_0
    //   4335: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   4338: ifeq +962 -> 5300
    //   4341: aload_0
    //   4342: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4345: aload_0
    //   4346: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   4349: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4352: astore 18
    //   4354: aload 22
    //   4356: aload 18
    //   4358: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4361: ldc_w 510
    //   4364: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4367: aload_0
    //   4368: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4371: invokestatic 98	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;)Z
    //   4374: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4377: ldc_w 512
    //   4380: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4383: aload_2
    //   4384: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4387: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4390: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4393: ldc_w 514
    //   4396: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4399: aload_2
    //   4400: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4403: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   4406: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4409: ldc_w 518
    //   4412: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4415: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   4418: aload_0
    //   4419: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   4422: lsub
    //   4423: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4426: ldc_w 520
    //   4429: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4432: aload_2
    //   4433: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4436: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   4439: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4442: ldc 82
    //   4444: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4447: aload_2
    //   4448: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4451: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   4454: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4457: ldc_w 525
    //   4460: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4463: ldc_w 527
    //   4466: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4469: aload_2
    //   4470: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4473: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   4476: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4479: ldc_w 530
    //   4482: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4485: aload_0
    //   4486: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   4489: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4492: ldc 82
    //   4494: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4497: aload_0
    //   4498: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   4501: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4504: ldc_w 525
    //   4507: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4510: ldc_w 533
    //   4513: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4516: iload_3
    //   4517: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4520: ldc_w 525
    //   4523: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4526: ldc_w 535
    //   4529: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4532: aload_2
    //   4533: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4536: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:a	()I
    //   4539: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4542: ldc_w 537
    //   4545: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4548: iload 5
    //   4550: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4553: ldc_w 539
    //   4556: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4559: aload_0
    //   4560: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4563: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4566: ldc_w 542
    //   4569: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4572: astore 18
    //   4574: aload_0
    //   4575: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4578: ifnull +728 -> 5306
    //   4581: aload_0
    //   4582: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4585: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4588: istore_3
    //   4589: aload 18
    //   4591: iload_3
    //   4592: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4595: ldc_w 544
    //   4598: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4601: aload_2
    //   4602: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4605: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4608: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4611: ldc_w 548
    //   4614: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4617: aload_0
    //   4618: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   4621: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4624: ldc_w 525
    //   4627: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4630: ldc_w 552
    //   4633: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4636: astore 22
    //   4638: aload_0
    //   4639: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4642: ifnull +669 -> 5311
    //   4645: aload_0
    //   4646: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4649: invokeinterface 560 1 0
    //   4654: astore 18
    //   4656: ldc 148
    //   4658: aload 22
    //   4660: aload 18
    //   4662: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4665: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4668: aload 19
    //   4670: invokestatic 431	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4673: getstatic 249	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4676: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4679: aload_0
    //   4680: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4683: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4686: if_icmpne +37 -> 4723
    //   4689: aload_0
    //   4690: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4693: ifnull +30 -> 4723
    //   4696: aload_0
    //   4697: getfield 273	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4700: aload_0
    //   4701: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   4704: aload_0
    //   4705: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4708: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4711: aload_2
    //   4712: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4715: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   4718: invokeinterface 564 4 0
    //   4723: getstatic 346	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4726: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4729: aload_0
    //   4730: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4733: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4736: if_icmpne +37 -> 4773
    //   4739: aload_0
    //   4740: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4743: ifnull +30 -> 4773
    //   4746: aload_0
    //   4747: getfield 332	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4750: aload_0
    //   4751: invokevirtual 169	com/tencent/component/network/downloader/impl/i:b	()Ljava/lang/String;
    //   4754: aload_0
    //   4755: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4758: invokestatic 561	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4761: aload_2
    //   4762: invokevirtual 411	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4765: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult$Status:a	()Z
    //   4768: invokeinterface 564 4 0
    //   4773: aload 20
    //   4775: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   4778: putfield 565	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Long	J
    //   4781: aload 20
    //   4783: aload_0
    //   4784: getfield 566	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Long	J
    //   4787: putfield 567	com/tencent/component/network/downloader/DownloadReport:jdField_c_of_type_Long	J
    //   4790: aload 20
    //   4792: aload_0
    //   4793: getfield 45	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4796: putfield 568	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4799: aload 20
    //   4801: iload 5
    //   4803: putfield 569	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_Int	I
    //   4806: aload 20
    //   4808: aload 19
    //   4810: putfield 572	com/tencent/component/network/downloader/DownloadReport:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   4813: aload 21
    //   4815: ifnonnull +549 -> 5364
    //   4818: aconst_null
    //   4819: astore 18
    //   4821: aload 20
    //   4823: aload 18
    //   4825: putfield 573	com/tencent/component/network/downloader/DownloadReport:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4828: aload_0
    //   4829: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4832: ifnull -844 -> 3988
    //   4835: aload_0
    //   4836: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4839: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4842: ifnull -854 -> 3988
    //   4845: aload_0
    //   4846: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4849: invokevirtual 474	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4852: getfield 574	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4855: astore 18
    //   4857: goto -866 -> 3991
    //   4860: ldc_w 498
    //   4863: astore 18
    //   4865: goto -737 -> 4128
    //   4868: goto -735 -> 4133
    //   4871: invokestatic 198	com/tencent/component/network/module/base/b:b	()Z
    //   4874: ifeq -201 -> 4673
    //   4877: new 71	java/lang/StringBuilder
    //   4880: dup
    //   4881: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   4884: ldc_w 676
    //   4887: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4890: aload_0
    //   4891: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   4894: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4897: ldc_w 489
    //   4900: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4903: aload 21
    //   4905: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4908: ldc_w 494
    //   4911: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4914: aload 18
    //   4916: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4919: ldc_w 496
    //   4922: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4925: ldc_w 498
    //   4928: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4931: ldc_w 500
    //   4934: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4937: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4940: invokevirtual 227	java/lang/Thread:getId	()J
    //   4943: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4946: ldc_w 502
    //   4949: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4952: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   4955: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4958: ldc_w 504
    //   4961: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4964: aload_0
    //   4965: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   4968: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4971: ldc_w 506
    //   4974: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4977: aload_0
    //   4978: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   4981: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4984: ldc_w 508
    //   4987: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4990: astore 22
    //   4992: aload_0
    //   4993: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   4996: ifeq +321 -> 5317
    //   4999: aload_0
    //   5000: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5003: aload_0
    //   5004: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   5007: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5010: astore 18
    //   5012: aload 22
    //   5014: aload 18
    //   5016: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5019: ldc_w 514
    //   5022: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5025: aload_2
    //   5026: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5029: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5032: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5035: ldc_w 518
    //   5038: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5041: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   5044: aload_0
    //   5045: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   5048: lsub
    //   5049: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5052: ldc_w 520
    //   5055: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5058: aload_2
    //   5059: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5062: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   5065: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5068: ldc 82
    //   5070: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5073: aload_2
    //   5074: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5077: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   5080: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5083: ldc_w 525
    //   5086: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5089: ldc_w 527
    //   5092: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5095: aload_2
    //   5096: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5099: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   5102: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5105: ldc_w 530
    //   5108: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5111: aload_0
    //   5112: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   5115: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5118: ldc 82
    //   5120: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5123: aload_0
    //   5124: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   5127: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5130: ldc_w 525
    //   5133: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5136: ldc_w 533
    //   5139: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5142: iload_3
    //   5143: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5146: ldc_w 525
    //   5149: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5152: ldc_w 537
    //   5155: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5158: iload 5
    //   5160: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5163: ldc_w 512
    //   5166: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5169: aload_2
    //   5170: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5173: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5176: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5179: ldc_w 539
    //   5182: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5185: aload_0
    //   5186: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5189: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5192: ldc_w 542
    //   5195: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5198: astore 18
    //   5200: aload_0
    //   5201: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5204: ifnull +119 -> 5323
    //   5207: aload_0
    //   5208: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5211: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5214: istore_3
    //   5215: aload 18
    //   5217: iload_3
    //   5218: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5221: ldc_w 544
    //   5224: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5227: aload_2
    //   5228: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5231: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5234: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5237: ldc_w 548
    //   5240: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5243: aload_0
    //   5244: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   5247: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5250: ldc_w 525
    //   5253: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5256: ldc_w 552
    //   5259: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: astore 22
    //   5264: aload_0
    //   5265: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5268: ifnull +60 -> 5328
    //   5271: aload_0
    //   5272: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5275: invokeinterface 560 1 0
    //   5280: astore 18
    //   5282: ldc 148
    //   5284: aload 22
    //   5286: aload 18
    //   5288: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5291: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5294: invokestatic 232	com/tencent/component/network/module/base/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5297: goto -624 -> 4673
    //   5300: aconst_null
    //   5301: astore 18
    //   5303: goto -949 -> 4354
    //   5306: iconst_0
    //   5307: istore_3
    //   5308: goto -719 -> 4589
    //   5311: aconst_null
    //   5312: astore 18
    //   5314: goto -658 -> 4656
    //   5317: aconst_null
    //   5318: astore 18
    //   5320: goto -308 -> 5012
    //   5323: iconst_0
    //   5324: istore_3
    //   5325: goto -110 -> 5215
    //   5328: aconst_null
    //   5329: astore 18
    //   5331: goto -49 -> 5282
    //   5334: astore 18
    //   5336: ldc 148
    //   5338: ldc_w 678
    //   5341: aload 18
    //   5343: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5346: goto -623 -> 4723
    //   5349: astore 18
    //   5351: ldc 148
    //   5353: ldc_w 682
    //   5356: aload 18
    //   5358: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5361: goto -588 -> 4773
    //   5364: aload 21
    //   5366: invokevirtual 685	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5369: astore 18
    //   5371: goto -550 -> 4821
    //   5374: ldc_w 498
    //   5377: astore 17
    //   5379: goto -5008 -> 371
    //   5382: ldc_w 687
    //   5385: astore 18
    //   5387: goto -5007 -> 380
    //   5390: invokestatic 198	com/tencent/component/network/module/base/b:b	()Z
    //   5393: ifeq -4472 -> 921
    //   5396: new 71	java/lang/StringBuilder
    //   5399: dup
    //   5400: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   5403: ldc_w 676
    //   5406: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5409: aload_0
    //   5410: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   5413: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5416: ldc_w 489
    //   5419: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5422: aload 21
    //   5424: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5427: ldc_w 494
    //   5430: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5433: aload 17
    //   5435: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5438: ldc_w 496
    //   5441: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5444: ldc_w 498
    //   5447: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5450: ldc_w 500
    //   5453: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5456: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5459: invokevirtual 227	java/lang/Thread:getId	()J
    //   5462: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5465: ldc_w 502
    //   5468: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5471: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   5474: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5477: ldc_w 504
    //   5480: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5483: aload_0
    //   5484: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   5487: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5490: ldc_w 506
    //   5493: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5496: aload_0
    //   5497: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   5500: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5503: ldc_w 508
    //   5506: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5509: astore 22
    //   5511: aload_0
    //   5512: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   5515: ifeq +322 -> 5837
    //   5518: aload_0
    //   5519: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5522: aload_0
    //   5523: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   5526: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5529: astore 17
    //   5531: aload 22
    //   5533: aload 17
    //   5535: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5538: ldc_w 514
    //   5541: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5544: aload_2
    //   5545: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5548: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5551: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5554: ldc_w 518
    //   5557: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5560: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   5563: aload_0
    //   5564: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   5567: lsub
    //   5568: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5571: ldc_w 520
    //   5574: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5577: aload_2
    //   5578: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5581: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   5584: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5587: ldc 82
    //   5589: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5592: aload_2
    //   5593: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5596: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   5599: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5602: ldc_w 525
    //   5605: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: ldc_w 527
    //   5611: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5614: aload_2
    //   5615: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5618: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   5621: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5624: ldc_w 530
    //   5627: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5630: aload_0
    //   5631: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   5634: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5637: ldc 82
    //   5639: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5642: aload_0
    //   5643: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   5646: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5649: ldc_w 525
    //   5652: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5655: ldc_w 533
    //   5658: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5661: iload 4
    //   5663: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5666: ldc_w 525
    //   5669: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5672: ldc_w 537
    //   5675: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5678: iload 5
    //   5680: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5683: ldc_w 512
    //   5686: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5689: aload_2
    //   5690: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5693: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5696: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5699: ldc_w 539
    //   5702: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5705: aload_0
    //   5706: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5709: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5712: ldc_w 542
    //   5715: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5718: astore 17
    //   5720: aload_0
    //   5721: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5724: ifnull +119 -> 5843
    //   5727: aload_0
    //   5728: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5731: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5734: istore_3
    //   5735: aload 17
    //   5737: iload_3
    //   5738: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5741: ldc_w 544
    //   5744: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5747: aload_2
    //   5748: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5751: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5754: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5757: ldc_w 548
    //   5760: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: aload_0
    //   5764: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   5767: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5770: ldc_w 525
    //   5773: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5776: ldc_w 552
    //   5779: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5782: astore 22
    //   5784: aload_0
    //   5785: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5788: ifnull +60 -> 5848
    //   5791: aload_0
    //   5792: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5795: invokeinterface 560 1 0
    //   5800: astore 17
    //   5802: ldc 148
    //   5804: aload 22
    //   5806: aload 17
    //   5808: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5811: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5814: invokestatic 232	com/tencent/component/network/module/base/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5817: goto -4896 -> 921
    //   5820: aconst_null
    //   5821: astore 17
    //   5823: goto -5222 -> 601
    //   5826: iconst_0
    //   5827: istore_3
    //   5828: goto -4991 -> 837
    //   5831: aconst_null
    //   5832: astore 17
    //   5834: goto -4930 -> 904
    //   5837: aconst_null
    //   5838: astore 17
    //   5840: goto -309 -> 5531
    //   5843: iconst_0
    //   5844: istore_3
    //   5845: goto -110 -> 5735
    //   5848: aconst_null
    //   5849: astore 17
    //   5851: goto -49 -> 5802
    //   5854: astore 17
    //   5856: ldc 148
    //   5858: ldc_w 678
    //   5861: aload 17
    //   5863: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5866: goto -4895 -> 971
    //   5869: astore 17
    //   5871: ldc 148
    //   5873: ldc_w 682
    //   5876: aload 17
    //   5878: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5881: goto -4860 -> 1021
    //   5884: aload 21
    //   5886: invokevirtual 685	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5889: astore 17
    //   5891: goto -4822 -> 1069
    //   5894: aconst_null
    //   5895: astore 17
    //   5897: goto -4792 -> 1105
    //   5900: ldc_w 498
    //   5903: astore 18
    //   5905: goto -3804 -> 2101
    //   5908: ldc_w 687
    //   5911: astore 17
    //   5913: goto -3803 -> 2110
    //   5916: invokestatic 198	com/tencent/component/network/module/base/b:b	()Z
    //   5919: ifeq -3268 -> 2651
    //   5922: new 71	java/lang/StringBuilder
    //   5925: dup
    //   5926: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   5929: ldc_w 676
    //   5932: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5935: aload_0
    //   5936: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   5939: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5942: ldc_w 489
    //   5945: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5948: aload 19
    //   5950: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5953: ldc_w 494
    //   5956: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5959: aload 18
    //   5961: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5964: ldc_w 496
    //   5967: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5970: ldc_w 498
    //   5973: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5976: ldc_w 500
    //   5979: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5982: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5985: invokevirtual 227	java/lang/Thread:getId	()J
    //   5988: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5991: ldc_w 502
    //   5994: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5997: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   6000: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6003: ldc_w 504
    //   6006: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6009: aload_0
    //   6010: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   6013: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6016: ldc_w 506
    //   6019: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6022: aload_0
    //   6023: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   6026: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6029: ldc_w 508
    //   6032: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6035: astore 21
    //   6037: aload_0
    //   6038: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   6041: ifeq +324 -> 6365
    //   6044: aload_0
    //   6045: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6048: aload_0
    //   6049: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   6052: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   6055: astore 18
    //   6057: aload 21
    //   6059: aload 18
    //   6061: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6064: ldc_w 514
    //   6067: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6070: aload_2
    //   6071: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6074: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6077: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6080: ldc_w 518
    //   6083: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6086: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   6089: aload_0
    //   6090: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   6093: lsub
    //   6094: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6097: ldc_w 520
    //   6100: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6103: aload_2
    //   6104: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6107: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   6110: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6113: ldc 82
    //   6115: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6118: aload_2
    //   6119: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6122: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   6125: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6128: ldc_w 525
    //   6131: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6134: ldc_w 527
    //   6137: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6140: aload_2
    //   6141: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6144: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   6147: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6150: ldc_w 530
    //   6153: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6156: aload_0
    //   6157: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   6160: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6163: ldc 82
    //   6165: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: aload_0
    //   6169: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   6172: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6175: ldc_w 525
    //   6178: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6181: ldc_w 533
    //   6184: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6187: iload 5
    //   6189: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6192: ldc_w 525
    //   6195: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6198: ldc_w 537
    //   6201: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6204: iload_3
    //   6205: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6208: ldc_w 512
    //   6211: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6214: aload_2
    //   6215: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6218: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6221: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6224: ldc_w 539
    //   6227: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6230: aload_0
    //   6231: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6234: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6237: ldc_w 542
    //   6240: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6243: astore 18
    //   6245: aload_0
    //   6246: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6249: ifnull +122 -> 6371
    //   6252: aload_0
    //   6253: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6256: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6259: istore 4
    //   6261: aload 18
    //   6263: iload 4
    //   6265: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6268: ldc_w 544
    //   6271: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6274: aload_2
    //   6275: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6278: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   6281: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6284: ldc_w 548
    //   6287: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6290: aload_0
    //   6291: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   6294: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6297: ldc_w 525
    //   6300: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6303: ldc_w 552
    //   6306: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6309: astore 21
    //   6311: aload_0
    //   6312: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6315: ifnull +62 -> 6377
    //   6318: aload_0
    //   6319: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6322: invokeinterface 560 1 0
    //   6327: astore 18
    //   6329: ldc 148
    //   6331: aload 21
    //   6333: aload 18
    //   6335: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6338: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6341: invokestatic 232	com/tencent/component/network/module/base/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6344: goto -3693 -> 2651
    //   6347: aconst_null
    //   6348: astore 18
    //   6350: goto -4019 -> 2331
    //   6353: iconst_0
    //   6354: istore 4
    //   6356: goto -3789 -> 2567
    //   6359: aconst_null
    //   6360: astore 18
    //   6362: goto -3727 -> 2635
    //   6365: aconst_null
    //   6366: astore 18
    //   6368: goto -311 -> 6057
    //   6371: iconst_0
    //   6372: istore 4
    //   6374: goto -113 -> 6261
    //   6377: aconst_null
    //   6378: astore 18
    //   6380: goto -51 -> 6329
    //   6383: astore 18
    //   6385: ldc 148
    //   6387: ldc_w 678
    //   6390: aload 18
    //   6392: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6395: goto -3694 -> 2701
    //   6398: astore 18
    //   6400: ldc 148
    //   6402: ldc_w 682
    //   6405: aload 18
    //   6407: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6410: goto -3659 -> 2751
    //   6413: aload 19
    //   6415: invokevirtual 685	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6418: astore 18
    //   6420: goto -3623 -> 2797
    //   6423: aconst_null
    //   6424: astore 18
    //   6426: goto -3593 -> 2833
    //   6429: ldc_w 498
    //   6432: astore 17
    //   6434: goto -3287 -> 3147
    //   6437: ldc_w 687
    //   6440: astore 18
    //   6442: goto -3286 -> 3156
    //   6445: invokestatic 198	com/tencent/component/network/module/base/b:b	()Z
    //   6448: ifeq -2751 -> 3697
    //   6451: new 71	java/lang/StringBuilder
    //   6454: dup
    //   6455: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   6458: ldc_w 676
    //   6461: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6464: aload_0
    //   6465: invokevirtual 167	com/tencent/component/network/downloader/impl/i:a	()Ljava/lang/String;
    //   6468: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6471: ldc_w 489
    //   6474: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6477: aload 19
    //   6479: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6482: ldc_w 494
    //   6485: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6488: aload 17
    //   6490: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6493: ldc_w 496
    //   6496: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6499: ldc_w 498
    //   6502: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6505: ldc_w 500
    //   6508: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6511: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6514: invokevirtual 227	java/lang/Thread:getId	()J
    //   6517: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6520: ldc_w 502
    //   6523: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6526: invokestatic 214	com/tencent/component/network/NetworkManager:a	()Ljava/lang/String;
    //   6529: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6532: ldc_w 504
    //   6535: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6538: aload_0
    //   6539: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   6542: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6545: ldc_w 506
    //   6548: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6551: aload_0
    //   6552: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   6555: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6558: ldc_w 508
    //   6561: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6564: astore 21
    //   6566: aload_0
    //   6567: getfield 235	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Boolean	Z
    //   6570: ifeq +324 -> 6894
    //   6573: aload_0
    //   6574: getfield 93	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6577: aload_0
    //   6578: getfield 238	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Boolean	Z
    //   6581: invokestatic 356	com/tencent/component/network/utils/NetworkUtils:a	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   6584: astore 17
    //   6586: aload 21
    //   6588: aload 17
    //   6590: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6593: ldc_w 514
    //   6596: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6599: aload_2
    //   6600: invokevirtual 458	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6603: getfield 516	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6606: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6609: ldc_w 518
    //   6612: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6615: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   6618: aload_0
    //   6619: getfield 39	com/tencent/component/network/downloader/impl/i:jdField_d_of_type_Long	J
    //   6622: lsub
    //   6623: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6626: ldc_w 520
    //   6629: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6632: aload_2
    //   6633: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6636: getfield 521	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_Long	J
    //   6639: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6642: ldc 82
    //   6644: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6647: aload_2
    //   6648: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6651: getfield 523	com/tencent/component/network/downloader/DownloadResult$Content:jdField_b_of_type_Long	J
    //   6654: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6657: ldc_w 525
    //   6660: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6663: ldc_w 527
    //   6666: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6669: aload_2
    //   6670: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6673: getfield 528	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_Long	J
    //   6676: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6679: ldc_w 530
    //   6682: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6685: aload_0
    //   6686: getfield 450	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_Int	I
    //   6689: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6692: ldc 82
    //   6694: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6697: aload_0
    //   6698: getfield 531	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_Int	I
    //   6701: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6704: ldc_w 525
    //   6707: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6710: ldc_w 533
    //   6713: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6716: iload 4
    //   6718: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6721: ldc_w 525
    //   6724: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6727: ldc_w 537
    //   6730: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6733: iload_3
    //   6734: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6737: ldc_w 512
    //   6740: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6743: aload_2
    //   6744: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6747: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6750: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6753: ldc_w 539
    //   6756: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6759: aload_0
    //   6760: getfield 540	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6763: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6766: ldc_w 542
    //   6769: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6772: astore 17
    //   6774: aload_0
    //   6775: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6778: ifnull +122 -> 6900
    //   6781: aload_0
    //   6782: getfield 190	com/tencent/component/network/downloader/impl/i:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6785: getfield 251	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6788: istore 5
    //   6790: aload 17
    //   6792: iload 5
    //   6794: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6797: ldc_w 544
    //   6800: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6803: aload_2
    //   6804: invokevirtual 421	com/tencent/component/network/downloader/DownloadResult:a	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6807: getfield 546	com/tencent/component/network/downloader/DownloadResult$Content:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   6810: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6813: ldc_w 548
    //   6816: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6819: aload_0
    //   6820: invokevirtual 550	com/tencent/component/network/downloader/impl/i:d	()I
    //   6823: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6826: ldc_w 525
    //   6829: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6832: ldc_w 552
    //   6835: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6838: astore 21
    //   6840: aload_0
    //   6841: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6844: ifnull +62 -> 6906
    //   6847: aload_0
    //   6848: getfield 555	com/tencent/component/network/downloader/impl/i:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA$a	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6851: invokeinterface 560 1 0
    //   6856: astore 17
    //   6858: ldc 148
    //   6860: aload 21
    //   6862: aload 17
    //   6864: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6867: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6870: invokestatic 232	com/tencent/component/network/module/base/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6873: goto -3176 -> 3697
    //   6876: aconst_null
    //   6877: astore 17
    //   6879: goto -3502 -> 3377
    //   6882: iconst_0
    //   6883: istore 5
    //   6885: goto -3272 -> 3613
    //   6888: aconst_null
    //   6889: astore 17
    //   6891: goto -3210 -> 3681
    //   6894: aconst_null
    //   6895: astore 17
    //   6897: goto -311 -> 6586
    //   6900: iconst_0
    //   6901: istore 5
    //   6903: goto -113 -> 6790
    //   6906: aconst_null
    //   6907: astore 17
    //   6909: goto -51 -> 6858
    //   6912: astore 17
    //   6914: ldc 148
    //   6916: ldc_w 678
    //   6919: aload 17
    //   6921: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6924: goto -3177 -> 3747
    //   6927: astore 17
    //   6929: ldc 148
    //   6931: ldc_w 682
    //   6934: aload 17
    //   6936: invokestatic 680	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6939: goto -3142 -> 3797
    //   6942: aload 19
    //   6944: invokevirtual 685	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6947: astore 17
    //   6949: goto -3106 -> 3843
    //   6952: aconst_null
    //   6953: astore 17
    //   6955: goto -3076 -> 3879
    //   6958: astore 17
    //   6960: goto -2890 -> 4070
    //   6963: astore 17
    //   6965: goto -6680 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6968	0	this	i
    //   0	6968	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	6968	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   105	6629	3	i	int
    //   1	6716	4	j	int
    //   292	6610	5	k	int
    //   296	3768	6	m	int
    //   1530	2453	7	n	int
    //   238	3725	8	i1	int
    //   232	3747	9	i2	int
    //   235	3732	10	i3	int
    //   26	165	11	i4	int
    //   31	60	12	l1	long
    //   177	3903	14	l2	long
    //   248	3	16	bool	boolean
    //   82	1	17	localException1	Exception
    //   260	3799	17	localObject1	Object
    //   4061	1	17	localObject2	Object
    //   5377	473	17	localObject3	Object
    //   5854	8	17	localException2	Exception
    //   5869	8	17	localException3	Exception
    //   5889	1019	17	localObject4	Object
    //   6912	8	17	localException4	Exception
    //   6927	8	17	localException5	Exception
    //   6947	7	17	str1	String
    //   6958	1	17	localObject5	Object
    //   6963	1	17	localThrowable1	java.lang.Throwable
    //   6	5324	18	localObject6	Object
    //   5334	8	18	localException6	Exception
    //   5349	8	18	localException7	Exception
    //   5369	1010	18	localObject7	Object
    //   6383	8	18	localException8	Exception
    //   6398	8	18	localException9	Exception
    //   6418	23	18	str2	String
    //   301	756	19	localThrowable2	java.lang.Throwable
    //   1176	5767	19	localObject8	Object
    //   186	4636	20	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   340	6521	21	localObject9	Object
    //   579	5226	22	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	79	82	java/lang/Exception
    //   106	125	163	java/lang/Throwable
    //   125	162	163	java/lang/Throwable
    //   298	301	301	java/lang/Throwable
    //   1201	1212	301	java/lang/Throwable
    //   1220	1229	301	java/lang/Throwable
    //   1237	1246	301	java/lang/Throwable
    //   1254	1261	301	java/lang/Throwable
    //   1269	1280	301	java/lang/Throwable
    //   1288	1295	301	java/lang/Throwable
    //   1303	1310	301	java/lang/Throwable
    //   1318	1322	301	java/lang/Throwable
    //   1330	1342	301	java/lang/Throwable
    //   1350	1358	301	java/lang/Throwable
    //   1366	1379	301	java/lang/Throwable
    //   1387	1394	301	java/lang/Throwable
    //   1402	1412	301	java/lang/Throwable
    //   1420	1436	301	java/lang/Throwable
    //   1444	1456	301	java/lang/Throwable
    //   1464	1470	301	java/lang/Throwable
    //   1478	1489	301	java/lang/Throwable
    //   1497	1502	301	java/lang/Throwable
    //   1514	1525	301	java/lang/Throwable
    //   1536	1543	301	java/lang/Throwable
    //   1555	1583	301	java/lang/Throwable
    //   1595	1602	301	java/lang/Throwable
    //   1610	1627	301	java/lang/Throwable
    //   1639	1651	301	java/lang/Throwable
    //   1659	1665	301	java/lang/Throwable
    //   1673	1740	301	java/lang/Throwable
    //   1748	1755	301	java/lang/Throwable
    //   1763	1775	301	java/lang/Throwable
    //   1783	1808	301	java/lang/Throwable
    //   1816	1823	301	java/lang/Throwable
    //   1831	1852	301	java/lang/Throwable
    //   1860	1876	301	java/lang/Throwable
    //   1884	1900	301	java/lang/Throwable
    //   1908	1913	301	java/lang/Throwable
    //   1921	1940	301	java/lang/Throwable
    //   1948	1955	301	java/lang/Throwable
    //   1963	1978	301	java/lang/Throwable
    //   1984	1992	301	java/lang/Throwable
    //   2015	2029	301	java/lang/Throwable
    //   2035	2042	301	java/lang/Throwable
    //   2923	2934	301	java/lang/Throwable
    //   2943	2955	301	java/lang/Throwable
    //   2961	2972	301	java/lang/Throwable
    //   2978	2983	301	java/lang/Throwable
    //   2996	3006	301	java/lang/Throwable
    //   3036	3041	301	java/lang/Throwable
    //   3047	3055	301	java/lang/Throwable
    //   3061	3068	301	java/lang/Throwable
    //   3074	3088	301	java/lang/Throwable
    //   3970	3978	301	java/lang/Throwable
    //   298	301	4061	finally
    //   1201	1212	4061	finally
    //   1220	1229	4061	finally
    //   1237	1246	4061	finally
    //   1254	1261	4061	finally
    //   1269	1280	4061	finally
    //   1288	1295	4061	finally
    //   1303	1310	4061	finally
    //   1318	1322	4061	finally
    //   1330	1342	4061	finally
    //   1350	1358	4061	finally
    //   1366	1379	4061	finally
    //   1387	1394	4061	finally
    //   1402	1412	4061	finally
    //   1420	1436	4061	finally
    //   1444	1456	4061	finally
    //   1464	1470	4061	finally
    //   1478	1489	4061	finally
    //   1497	1502	4061	finally
    //   1514	1525	4061	finally
    //   1536	1543	4061	finally
    //   1555	1583	4061	finally
    //   1595	1602	4061	finally
    //   1610	1627	4061	finally
    //   1639	1651	4061	finally
    //   1659	1665	4061	finally
    //   1673	1740	4061	finally
    //   1748	1755	4061	finally
    //   1763	1775	4061	finally
    //   1783	1808	4061	finally
    //   1816	1823	4061	finally
    //   1831	1852	4061	finally
    //   1860	1876	4061	finally
    //   1884	1900	4061	finally
    //   1908	1913	4061	finally
    //   1921	1940	4061	finally
    //   1948	1955	4061	finally
    //   1963	1978	4061	finally
    //   1984	1992	4061	finally
    //   2015	2029	4061	finally
    //   2035	2042	4061	finally
    //   2923	2934	4061	finally
    //   2943	2955	4061	finally
    //   2961	2972	4061	finally
    //   2978	2983	4061	finally
    //   2996	3006	4061	finally
    //   3036	3041	4061	finally
    //   3047	3055	4061	finally
    //   3061	3068	4061	finally
    //   3074	3088	4061	finally
    //   3970	3978	4061	finally
    //   4696	4723	5334	java/lang/Exception
    //   4746	4773	5349	java/lang/Exception
    //   944	971	5854	java/lang/Exception
    //   994	1021	5869	java/lang/Exception
    //   2674	2701	6383	java/lang/Exception
    //   2724	2751	6398	java/lang/Exception
    //   3720	3747	6912	java/lang/Exception
    //   3770	3797	6927	java/lang/Exception
    //   303	312	6958	finally
    //   240	250	6963	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.i
 * JD-Core Version:    0.7.0.1
 */