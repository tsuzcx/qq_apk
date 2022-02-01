package com.tencent.mm.plugin.appbrand.permission;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public abstract interface j
{
  public abstract void a(Activity paramActivity, f paramf, String paramString, a parama);
  
  public abstract boolean a(Activity paramActivity, f paramf, String paramString);
  
  public abstract boolean cGU();
  
  public static abstract interface a
  {
    public abstract void onPermissionResult(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.j
 * JD-Core Version:    0.7.0.1
 */