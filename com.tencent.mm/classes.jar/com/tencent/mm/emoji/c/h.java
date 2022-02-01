package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static h jNy;
  public String extraInfo = "";
  public int jNA;
  public int jNB;
  public long jNp;
  public int jNq;
  public int jNr;
  public int jNz;
  public int scene;
  
  public static h aDe()
  {
    AppMethodBeat.i(104484);
    if (jNy == null) {
      jNy = new h();
    }
    h localh = jNy;
    AppMethodBeat.o(104484);
    return localh;
  }
  
  public final void Fn(long paramLong)
  {
    this.jNp = paramLong;
    this.jNq = 1;
  }
  
  public final void c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.jNp;
    com.tencent.mm.plugin.report.service.h.IzE.a(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.jNq), Integer.valueOf(this.jNz), Integer.valueOf(this.jNA), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.jNB), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jNr), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.jNp) });
    this.jNq += 1;
    AppMethodBeat.o(104485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.h
 * JD-Core Version:    0.7.0.1
 */