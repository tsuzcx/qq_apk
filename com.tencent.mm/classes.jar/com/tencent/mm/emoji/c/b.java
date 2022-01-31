package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class b
{
  private static b exj;
  public int clickCount;
  public long exk;
  public int exl;
  public int exm;
  public int exn;
  public boolean exo;
  public int exp;
  public int scene;
  
  public static b Pa()
  {
    AppMethodBeat.i(151736);
    if (exj == null) {
      exj = new b();
    }
    b localb = exj;
    AppMethodBeat.o(151736);
    return localb;
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(151737);
    long l1 = System.currentTimeMillis();
    long l2 = this.exk;
    h localh = h.qsU;
    int m = this.scene;
    int i;
    int n;
    int j;
    if (paramBoolean)
    {
      i = 1;
      n = this.exl;
      if (!paramBoolean) {
        break label181;
      }
      j = this.exp;
      label53:
      if (!this.exo) {
        break label190;
      }
    }
    for (;;)
    {
      localh.e(13470, new Object[] { paramString, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.exn), Integer.valueOf(this.clickCount), Long.valueOf(l1 - l2) });
      this.clickCount += 1;
      AppMethodBeat.o(151737);
      return;
      i = 0;
      break;
      label181:
      j = this.exm;
      break label53;
      label190:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */