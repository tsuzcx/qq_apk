package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c
{
  private static c exq;
  public int clickCount;
  public long exk;
  public int exl;
  public int exm;
  public int exn;
  public int exr;
  public int exs;
  public int ext;
  public String extraInfo = "";
  public int scene;
  
  public static c Pb()
  {
    AppMethodBeat.i(62267);
    if (exq == null) {
      exq = new c();
    }
    c localc = exq;
    AppMethodBeat.o(62267);
    return localc;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(62268);
    long l1 = System.currentTimeMillis();
    long l2 = this.exk;
    h localh = h.qsU;
    int j = this.scene;
    int k = this.clickCount;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localh.e(16029, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(j), Long.valueOf(l1 - l2), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.exr), Integer.valueOf(this.exl), Integer.valueOf(paramInt), Integer.valueOf(this.exm), Integer.valueOf(this.exs), Integer.valueOf(this.ext), Integer.valueOf(this.exn), this.extraInfo });
      this.clickCount += 1;
      AppMethodBeat.o(62268);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */