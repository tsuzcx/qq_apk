package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(c.class)
public abstract interface ag
  extends a, IStorage
{
  public abstract List<LocalUsageInfo> a(int paramInt, a parama);
  
  public abstract List<LocalUsageInfo> a(int paramInt1, a parama, int paramInt2);
  
  public abstract boolean bf(String paramString, int paramInt);
  
  public abstract int bg(String paramString, int paramInt);
  
  public abstract boolean bh(String paramString, int paramInt);
  
  public abstract void bxG();
  
  public abstract int bxH();
  
  public abstract boolean g(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(153196);
      kVV = new a("DESC", 0);
      kVW = new a("ASC", 1);
      kVX = new a("UPATE_TIME_DESC", 2);
      kVY = new a[] { kVV, kVW, kVX };
      AppMethodBeat.o(153196);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */