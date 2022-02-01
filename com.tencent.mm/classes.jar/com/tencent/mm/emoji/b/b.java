package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  private static b gqU;
  public boolean goq;
  public long gqV;
  public int gqW;
  public int gqX;
  public int scene;
  
  public static b agm()
  {
    AppMethodBeat.i(104481);
    if (gqU == null) {
      gqU = new b();
    }
    b localb = gqU;
    AppMethodBeat.o(104481);
    return localb;
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(104483);
    long l1 = System.currentTimeMillis();
    long l2 = this.gqV;
    g localg = g.yxI;
    int k = this.scene;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.goq) {
        break label183;
      }
    }
    for (;;)
    {
      localg.f(13470, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(this.gqX), Integer.valueOf(this.gqW), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(this.gqV) });
      this.gqW += 1;
      AppMethodBeat.o(104483);
      return;
      i = 0;
      break;
      label183:
      j = 0;
    }
  }
  
  public final void rg(long paramLong)
  {
    AppMethodBeat.i(104482);
    ae.i("EmojiClickReport", "panelShow");
    this.gqV = paramLong;
    this.gqW = 1;
    AppMethodBeat.o(104482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */