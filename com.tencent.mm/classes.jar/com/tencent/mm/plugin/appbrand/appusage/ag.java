package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(gf=c.class)
public abstract interface ag
  extends a, IStorage
{
  public abstract List<LocalUsageInfo> a(int paramInt, ag.a parama);
  
  public abstract List<LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2);
  
  public abstract boolean bA(String paramString, int paramInt);
  
  public abstract int bIW();
  
  public abstract boolean by(String paramString, int paramInt);
  
  public abstract int bz(String paramString, int paramInt);
  
  public abstract boolean g(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */