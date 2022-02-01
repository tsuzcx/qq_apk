package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import java.util.HashMap;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify pVx = new ILaunchWxaAppInfoNotify.1();
  
  public abstract void a(String paramString1, int paramInt, String paramString2, aj paramaj, boolean paramBoolean);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  
  public abstract void b(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */