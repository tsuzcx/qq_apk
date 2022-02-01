package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
{
  private static f fVf;
  public String extraInfo = "";
  public long fUX;
  public int fUY;
  public int fUZ;
  public int fVg;
  public int fVh;
  public int fVi;
  public int scene;
  
  public static f adv()
  {
    AppMethodBeat.i(104484);
    if (fVf == null) {
      fVf = new f();
    }
    f localf = fVf;
    AppMethodBeat.o(104484);
    return localf;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.fUX;
    h.wUl.f(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.fUY), Integer.valueOf(this.fVg), Integer.valueOf(this.fVh), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.fVi), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fUZ), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.fUX) });
    this.fUY += 1;
    AppMethodBeat.o(104485);
  }
  
  public final void oT(long paramLong)
  {
    this.fUX = paramLong;
    this.fUY = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */