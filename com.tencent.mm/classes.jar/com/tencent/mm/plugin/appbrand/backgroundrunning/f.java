package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.mm.kernel.c.a;

public abstract interface f
  extends a
{
  public abstract void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel);
  
  public abstract void a(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void b(a parama);
  
  public abstract void b(b paramb);
  
  public static abstract interface a
  {
    public abstract void onBackgroundRunningOperationReceived(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel);
  }
  
  public static abstract interface b
  {
    public abstract void b(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.f
 * JD-Core Version:    0.7.0.1
 */