package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
{
  private static f fRk;
  public String extraInfo = "";
  public long fRc;
  public int fRd;
  public int fRe;
  public int fRl;
  public int fRm;
  public int fRn;
  public int scene;
  
  public static f acp()
  {
    AppMethodBeat.i(104484);
    if (fRk == null) {
      fRk = new f();
    }
    f localf = fRk;
    AppMethodBeat.o(104484);
    return localf;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.fRc;
    h.vKh.f(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.fRd), Integer.valueOf(this.fRl), Integer.valueOf(this.fRm), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.fRn), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fRe), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.fRc) });
    this.fRd += 1;
    AppMethodBeat.o(104485);
  }
  
  public final void lq(long paramLong)
  {
    this.fRc = paramLong;
    this.fRd = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */