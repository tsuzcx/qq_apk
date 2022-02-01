package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.e.g;
import java.util.List;

@e(c.class)
public abstract interface ai
  extends a, g
{
  public abstract boolean bd(String paramString, int paramInt);
  
  public abstract List<LocalUsageInfo> dE(int paramInt1, int paramInt2);
  
  public abstract List<LocalUsageInfo> sb(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ai
 * JD-Core Version:    0.7.0.1
 */