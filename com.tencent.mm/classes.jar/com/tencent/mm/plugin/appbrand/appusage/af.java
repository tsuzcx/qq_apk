package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.sdk.e.f;
import java.util.List;

@e(b.class)
public abstract interface af
  extends a, f
{
  public abstract List<LocalUsageInfo> a(int paramInt, af.a parama);
  
  public abstract void acK();
  
  public abstract int acL();
  
  public abstract boolean ap(String paramString, int paramInt);
  
  public abstract int aq(String paramString, int paramInt);
  
  public abstract boolean ar(String paramString, int paramInt);
  
  public abstract boolean d(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.af
 * JD-Core Version:    0.7.0.1
 */