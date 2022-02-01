package com.pay.http;

import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class APBaseHttpParam
{
  public static final int CONNECT_TIMEOUT = 15000;
  public static final int READ_TIMEOUT = 15000;
  public static final int TRY_TIMES = 2;
  public long begTime;
  public int connectTimeout;
  public String defaultDomain;
  public String domain;
  public long endTime;
  public String port;
  public int reTryTimes;
  public int readTimeout;
  public HashMap<String, String> reqParam;
  public String reqType;
  public int requestTimes;
  public String sendType;
  public String url;
  public String urlName;
  public String urlParams;
  
  public APBaseHttpParam()
  {
    AppMethodBeat.i(207513);
    this.reqType = "http://";
    this.sendType = "GET";
    this.defaultDomain = "";
    this.domain = "";
    this.port = "";
    this.urlName = "";
    this.urlParams = "";
    this.connectTimeout = 15000;
    this.readTimeout = 15000;
    this.requestTimes = 0;
    this.reTryTimes = 2;
    this.begTime = 0L;
    this.endTime = 0L;
    this.reqParam = new HashMap();
    this.domain = APMidasTools.getSysServerDomain();
    AppMethodBeat.o(207513);
  }
  
  public void constructParams()
  {
    AppMethodBeat.i(207571);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (this.reqParam != null)
    {
      Iterator localIterator = this.reqParam.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("&");
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        this.urlParams = localStringBuilder.toString();
      }
    }
    APLog.i("APBaseHttpReq", "urlParams=" + this.urlParams);
    AppMethodBeat.o(207571);
  }
  
  public void constructReTryUrl()
  {
    AppMethodBeat.i(207578);
    if (this.requestTimes < this.reTryTimes)
    {
      this.domain = this.defaultDomain;
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName);
      this.requestTimes += 1;
    }
    AppMethodBeat.o(207578);
  }
  
  public void constructUrl()
  {
    AppMethodBeat.i(207565);
    constructParams();
    if (this.sendType.equals("GET"))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.url);
      if (!this.url.endsWith("?")) {
        localStringBuffer.append("?");
      }
      localStringBuffer.append(this.urlParams.toString());
      this.url = localStringBuffer.toString();
    }
    AppMethodBeat.o(207565);
  }
  
  public void setReportUrl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207553);
    String str = APMidasPayAPI.env;
    if (str.equals("dev"))
    {
      this.domain = "dev.api.unipay.qq.com";
      this.urlName = paramString1;
    }
    for (;;)
    {
      this.reTryTimes = 1;
      this.defaultDomain = this.domain;
      if (!str.equals("dev")) {
        break;
      }
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName);
      AppMethodBeat.o(207553);
      return;
      if (str.equals("test"))
      {
        this.domain = "sandbox.api.unipay.qq.com";
        this.urlName = paramString2;
      }
      else if (str.equals("release"))
      {
        this.domain = "szmg.qq.com";
        this.urlName = paramString3;
      }
      else if (str.equals("testing"))
      {
        this.domain = "szmg.qq.com";
        this.urlName = paramString3;
      }
    }
    if (str.equals("test"))
    {
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName);
      AppMethodBeat.o(207553);
      return;
    }
    if (str.equals("release"))
    {
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName);
      AppMethodBeat.o(207553);
      return;
    }
    if (str.equals("testing")) {
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName);
    }
    AppMethodBeat.o(207553);
  }
  
  public void setReqWithHttp()
  {
    this.reqType = "http://";
  }
  
  public void setReqWithHttps()
  {
    this.reqType = "https://";
  }
  
  public void setSendWithGet()
  {
    this.sendType = "GET";
  }
  
  public void setSendWithPost()
  {
    this.sendType = "POST";
  }
  
  public void setUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207560);
    paramString1 = APMidasPayAPI.env;
    if (paramString1.equals("dev"))
    {
      this.urlName = paramString2;
      this.defaultDomain = "dev.api.unipay.qq.com";
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + paramString2);
      AppMethodBeat.o(207560);
      return;
    }
    if (paramString1.equals("test"))
    {
      this.urlName = paramString3;
      this.defaultDomain = "sandbox.api.unipay.qq.com";
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + paramString3);
      AppMethodBeat.o(207560);
      return;
    }
    if (paramString1.equals("testing"))
    {
      this.urlName = paramString3;
      this.defaultDomain = "sandbox.api.unipay.qq.com";
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + paramString3);
      AppMethodBeat.o(207560);
      return;
    }
    if (paramString1.equals("release"))
    {
      this.urlName = paramString4;
      this.defaultDomain = "api.unipay.qq.com";
      this.url = (this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + paramString4);
    }
    AppMethodBeat.o(207560);
  }
  
  public void setUrlNotMidas(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207546);
    paramString1 = APMidasPayAPI.env;
    this.defaultDomain = "";
    if (paramString1.equals("testing"))
    {
      this.urlName = paramString2;
      this.url = paramString2;
      AppMethodBeat.o(207546);
      return;
    }
    if (paramString1.equals("test"))
    {
      this.urlName = paramString3;
      this.url = paramString3;
      AppMethodBeat.o(207546);
      return;
    }
    if (paramString1.equals("release"))
    {
      this.urlName = paramString4;
      this.url = paramString4;
    }
    AppMethodBeat.o(207546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.http.APBaseHttpParam
 * JD-Core Version:    0.7.0.1
 */