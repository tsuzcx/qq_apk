package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static b goz;
  public boolean glU;
  public long goA;
  public int goB;
  public int goC;
  public int scene;
  
  public static b afY()
  {
    AppMethodBeat.i(104481);
    if (goz == null) {
      goz = new b();
    }
    b localb = goz;
    AppMethodBeat.o(104481);
    return localb;
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(104483);
    long l1 = System.currentTimeMillis();
    long l2 = this.goA;
    g localg = g.yhR;
    int k = this.scene;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.glU) {
        break label183;
      }
    }
    for (;;)
    {
      localg.f(13470, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(this.goC), Integer.valueOf(this.goB), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(this.goA) });
      this.goB += 1;
      AppMethodBeat.o(104483);
      return;
      i = 0;
      break;
      label183:
      j = 0;
    }
  }
  
  public final void qT(long paramLong)
  {
    AppMethodBeat.i(104482);
    ad.i("EmojiClickReport", "panelShow");
    this.goA = paramLong;
    this.goB = 1;
    AppMethodBeat.o(104482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */