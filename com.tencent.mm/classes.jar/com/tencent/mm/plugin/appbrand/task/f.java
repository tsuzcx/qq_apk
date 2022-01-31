package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public enum f
{
  public int code;
  public int hbX;
  
  private f(int paramInt1, int paramInt2)
  {
    this.code = paramInt1;
    this.hbX = paramInt2;
  }
  
  public static f dA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return hbV;
    }
    return hbU;
  }
  
  public static f e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    if (paramAppBrandInitConfig.ZH()) {
      return hbV;
    }
    return hbU;
  }
  
  public static f q(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("AppBrandServiceType", hbW.code);
    paramIntent = values();
    int k = paramIntent.length;
    int i = 0;
    while (i < k)
    {
      f localf = paramIntent[i];
      if (localf.code == j) {
        return localf;
      }
      i += 1;
    }
    throw new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */