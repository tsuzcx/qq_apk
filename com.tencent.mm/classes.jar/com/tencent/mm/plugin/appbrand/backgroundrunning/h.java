package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.mm.kernel.c.a;
import java.util.List;

public abstract interface h
  extends a
{
  public abstract void a(a parama);
  
  public abstract List<AppBrandBackgroundRunningApp> aSH();
  
  public abstract void aSI();
  
  public abstract void aSJ();
  
  public abstract void b(a parama);
  
  public abstract void c(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel);
  
  public static abstract interface a
  {
    public abstract void a(List<AppBrandBackgroundRunningApp> paramList, AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.h
 * JD-Core Version:    0.7.0.1
 */