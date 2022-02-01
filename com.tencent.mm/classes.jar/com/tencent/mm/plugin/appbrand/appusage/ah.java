package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.e.g;
import java.util.List;

@e(c.class)
public abstract interface ah
  extends a, g
{
  public abstract List<LocalUsageInfo> a(int paramInt, ah.a parama);
  
  public abstract List<LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2);
  
  public abstract boolean aR(String paramString, int paramInt);
  
  public abstract void aRu();
  
  public abstract int aRv();
  
  public abstract int aS(String paramString, int paramInt);
  
  public abstract boolean aT(String paramString, int paramInt);
  
  public abstract boolean g(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ah
 * JD-Core Version:    0.7.0.1
 */