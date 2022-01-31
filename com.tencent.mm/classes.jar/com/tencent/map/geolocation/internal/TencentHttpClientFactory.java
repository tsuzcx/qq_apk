package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import c.t.m.g.du;

public abstract class TencentHttpClientFactory
{
  private static TencentHttpClientFactory sCustFact;
  
  public static TencentHttpClientFactory getInstance()
  {
    return new TencentHttpClientFactory.1();
  }
  
  public static void setTencentHttpClientFactory(TencentHttpClientFactory paramTencentHttpClientFactory)
  {
    sCustFact = paramTencentHttpClientFactory;
  }
  
  public abstract Bundle getParams();
  
  public TencentHttpClient getTencentHttpClient(Context paramContext, Bundle paramBundle)
  {
    if (sCustFact != null)
    {
      paramContext = sCustFact.getTencentHttpClient(paramContext, sCustFact.getParams());
      if (paramContext == null) {
        throw new NullPointerException(String.valueOf("http client should NOT be null"));
      }
      return (TencentHttpClient)paramContext;
    }
    return new du(paramContext, paramBundle.getString("channelId"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */