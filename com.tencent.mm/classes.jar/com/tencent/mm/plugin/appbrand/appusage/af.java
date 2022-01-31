package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.e.g;
import java.util.List;

@e(c.class)
public abstract interface af
  extends a, g
{
  public abstract List<LocalUsageInfo> a(int paramInt, a parama);
  
  public abstract boolean aC(String paramString, int paramInt);
  
  public abstract int aD(String paramString, int paramInt);
  
  public abstract boolean aE(String paramString, int paramInt);
  
  public abstract void awQ();
  
  public abstract int awR();
  
  public abstract boolean g(List<LocalUsageInfo> paramList, int paramInt);
  
  public abstract int getCount();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(114907);
      hcJ = new a("DESC", 0);
      hcK = new a("ASC", 1);
      hcL = new a("UPATE_TIME_DESC", 2);
      hcM = new a[] { hcJ, hcK, hcL };
      AppMethodBeat.o(114907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.af
 * JD-Core Version:    0.7.0.1
 */