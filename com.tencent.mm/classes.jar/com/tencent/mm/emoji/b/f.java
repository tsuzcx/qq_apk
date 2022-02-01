package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class f
{
  private static f goI;
  public String extraInfo = "";
  public long goA;
  public int goB;
  public int goC;
  public int goJ;
  public int goK;
  public int goL;
  public int scene;
  
  public static f agb()
  {
    AppMethodBeat.i(104484);
    if (goI == null) {
      goI = new f();
    }
    f localf = goI;
    AppMethodBeat.o(104484);
    return localf;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.goA;
    g.yhR.f(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.goB), Integer.valueOf(this.goJ), Integer.valueOf(this.goK), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.goL), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.goC), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.goA) });
    this.goB += 1;
    AppMethodBeat.o(104485);
  }
  
  public final void qT(long paramLong)
  {
    this.goA = paramLong;
    this.goB = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */