package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

public abstract class ky
  implements NetAdapter
{
  private static final String b = "NetImpl";
  protected Bundle a;
  private boolean c = true;
  private boolean d;
  private List<HttpProxyRule> e;
  private String f;
  
  protected static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i];
        if (!str1.contains("charset")) {
          break label69;
        }
        paramString = str1.split("=");
        str1 = str2;
        if (paramString.length > 1) {
          str1 = paramString[1].trim();
        }
      }
      return str1;
      label69:
      i += 1;
    }
  }
  
  private void a(List<HttpProxyRule> paramList)
  {
    this.e = paramList;
  }
  
  private void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  private void b(String paramString)
  {
    this.f = paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected abstract NetResponse a(NetRequest paramNetRequest);
  
  protected abstract void a();
  
  protected abstract NetResponse b(NetRequest paramNetRequest);
  
  public NetResponse doGet(NetRequest paramNetRequest)
  {
    return a(paramNetRequest);
  }
  
  public NetResponse doPost(NetRequest paramNetRequest)
  {
    return b(paramNetRequest);
  }
  
  public List<HttpProxyRule> getProxyRuleList()
  {
    return this.e;
  }
  
  public String getSecretKey()
  {
    return this.f;
  }
  
  public void initNet(Context paramContext, NetConfig paramNetConfig)
  {
    try
    {
      this.c = paramNetConfig.isForceHttps();
      this.d = paramNetConfig.isLogEnable();
      this.e = paramNetConfig.getProxyRuleList();
      this.f = paramNetConfig.getSecretKey();
      this.a = paramNetConfig.getArguments();
      a();
      return;
    }
    catch (Exception paramContext)
    {
      kh.e("NetImpl", "initNet error:" + paramContext.toString());
    }
  }
  
  public boolean isForceHttps()
  {
    return this.c;
  }
  
  public boolean isLogEnable()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ky
 * JD-Core Version:    0.7.0.1
 */