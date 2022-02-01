package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class f
{
  private static f grd;
  public String extraInfo = "";
  public long gqV;
  public int gqW;
  public int gqX;
  public int gre;
  public int grf;
  public int grg;
  public int scene;
  
  public static f agp()
  {
    AppMethodBeat.i(104484);
    if (grd == null) {
      grd = new f();
    }
    f localf = grd;
    AppMethodBeat.o(104484);
    return localf;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.gqV;
    g.yxI.f(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.gqW), Integer.valueOf(this.gre), Integer.valueOf(this.grf), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.grg), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.gqX), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.gqV) });
    this.gqW += 1;
    AppMethodBeat.o(104485);
  }
  
  public final void rg(long paramLong)
  {
    this.gqV = paramLong;
    this.gqW = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */