package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(gf=c.class)
public abstract interface ah
  extends a, IStorage
{
  public abstract boolean bB(String paramString, int paramInt);
  
  public abstract List<LocalUsageInfo> en(int paramInt1, int paramInt2);
  
  public abstract List<LocalUsageInfo> i(long paramLong, int paramInt);
  
  public abstract List<LocalUsageInfo> zh(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ah
 * JD-Core Version:    0.7.0.1
 */