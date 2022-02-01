package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static h hco;
  public String extraInfo = "";
  public long hcf;
  public int hcg;
  public int hch;
  public int hcp;
  public int hcq;
  public int hcr;
  public int scene;
  
  public static h awf()
  {
    AppMethodBeat.i(104484);
    if (hco == null) {
      hco = new h();
    }
    h localh = hco;
    AppMethodBeat.o(104484);
    return localh;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(104485);
    long l1 = System.currentTimeMillis();
    long l2 = this.hcf;
    com.tencent.mm.plugin.report.service.h.CyF.a(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(this.scene), Long.valueOf(l1 - l2), Integer.valueOf(this.hcg), Integer.valueOf(this.hcp), Integer.valueOf(this.hcq), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.hcr), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hch), this.extraInfo, Long.valueOf(l1), Long.valueOf(this.hcf) });
    this.hcg += 1;
    AppMethodBeat.o(104485);
  }
  
  public final void zj(long paramLong)
  {
    this.hcf = paramLong;
    this.hcg = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.h
 * JD-Core Version:    0.7.0.1
 */