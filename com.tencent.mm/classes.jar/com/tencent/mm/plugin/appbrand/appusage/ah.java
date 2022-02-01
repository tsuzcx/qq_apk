package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.e.g;
import java.util.List;

@e(c.class)
public abstract interface ah
  extends a, g
{
  public abstract List<LocalUsageInfo> a(int paramInt, a parama);
  
  public abstract List<LocalUsageInfo> a(int paramInt1, a parama, int paramInt2);
  
  public abstract boolean aX(String paramString, int paramInt);
  
  public abstract int aY(String paramString, int paramInt);
  
  public abstract boolean aZ(String paramString, int paramInt);
  
  public abstract void bbN();
  
  public abstract int bbO();
  
  public abstract boolean g(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(153196);
      jPV = new a("DESC", 0);
      jPW = new a("ASC", 1);
      jPX = new a("UPATE_TIME_DESC", 2);
      jPY = new a[] { jPV, jPW, jPX };
      AppMethodBeat.o(153196);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ah
 * JD-Core Version:    0.7.0.1
 */