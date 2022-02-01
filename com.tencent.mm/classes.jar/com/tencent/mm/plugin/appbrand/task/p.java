package com.tencent.mm.plugin.appbrand.task;

import android.content.Context;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;

public abstract interface p
{
  public abstract void Ue(String paramString);
  
  public abstract void a(g paramg, z paramz);
  
  public abstract void a(String paramString, AppBrandRemoteTaskController paramAppBrandRemoteTaskController);
  
  public abstract void a(String paramString, g paramg);
  
  public abstract void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController);
  
  public abstract void afe(String paramString);
  
  public abstract Class aff(String paramString);
  
  public abstract Class afg(String paramString);
  
  public abstract boolean afi(String paramString);
  
  public abstract Pair<String, Integer> afj(String paramString);
  
  public abstract void bVX();
  
  public abstract int[] bVY();
  
  public abstract void cl(String paramString, int paramInt);
  
  public abstract boolean cn(String paramString, int paramInt);
  
  public abstract String co(String paramString, int paramInt);
  
  public abstract int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void e(z paramz);
  
  public abstract int g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void onNetworkChange();
  
  public abstract void zn(int paramInt);
  
  public static abstract interface a
  {
    public abstract n a(String paramString1, String paramString2, g paramg);
    
    public abstract void a(g paramg, z paramz, boolean paramBoolean);
    
    public abstract void afk(String paramString);
    
    public abstract n b(String paramString, g paramg);
    
    public abstract void b(n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.p
 * JD-Core Version:    0.7.0.1
 */