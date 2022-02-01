package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(Dr=c.class)
public abstract interface af
  extends a, IStorage
{
  public abstract List<LocalUsageInfo> a(int paramInt, af.a parama);
  
  public abstract List<LocalUsageInfo> a(int paramInt1, af.a parama, int paramInt2);
  
  public abstract boolean bP(String paramString, int paramInt);
  
  public abstract boolean bQ(String paramString, int paramInt);
  
  public abstract int bR(String paramString, int paramInt);
  
  public abstract boolean bS(String paramString, int paramInt);
  
  public abstract int ciA();
  
  public abstract int getCount();
  
  public abstract boolean p(List<LocalUsageInfo> paramList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.af
 * JD-Core Version:    0.7.0.1
 */