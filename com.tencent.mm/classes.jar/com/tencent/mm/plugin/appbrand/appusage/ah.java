package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(c.class)
public abstract interface ah
  extends a, IStorage
{
  public abstract boolean bi(String paramString, int paramInt);
  
  public abstract List<LocalUsageInfo> dP(int paramInt1, int paramInt2);
  
  public abstract List<LocalUsageInfo> vW(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ah
 * JD-Core Version:    0.7.0.1
 */