package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import c.t.m.g.bt;

public abstract class TencentHttpClientFactory
{
  private static TencentHttpClientFactory sCustFact;
  
  public static TencentHttpClientFactory getInstance()
  {
    new TencentHttpClientFactory()
    {
      public final Bundle getParams()
      {
        return null;
      }
    };
  }
  
  public static void setTencentHttpClientFactory(TencentHttpClientFactory paramTencentHttpClientFactory)
  {
    sCustFact = paramTencentHttpClientFactory;
  }
  
  public abstract Bundle getParams();
  
  public TencentHttpClient getTencentHttpClient(Context paramContext, Bundle paramBundle)
  {
    if (sCustFact != null) {
      return sCustFact.getTencentHttpClient(paramContext, sCustFact.getParams());
    }
    return new bt(paramContext, paramBundle.getString("channelId"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */