package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(Dr=c.class)
public abstract interface ag
  extends a, IStorage
{
  public abstract boolean bT(String paramString, int paramInt);
  
  public abstract List<LocalUsageInfo> fg(int paramInt1, int paramInt2);
  
  public abstract List<LocalUsageInfo> r(long paramLong, int paramInt);
  
  public abstract List<LocalUsageInfo> zu(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */