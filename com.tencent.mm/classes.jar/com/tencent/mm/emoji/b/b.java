package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private static b fUW;
  public boolean fSq;
  public long fUX;
  public int fUY;
  public int fUZ;
  public int scene;
  
  public static b ads()
  {
    AppMethodBeat.i(104481);
    if (fUW == null) {
      fUW = new b();
    }
    b localb = fUW;
    AppMethodBeat.o(104481);
    return localb;
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(104483);
    long l1 = System.currentTimeMillis();
    long l2 = this.fUX;
    h localh = h.wUl;
    int k = this.scene;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.fSq) {
        break label183;
      }
    }
    for (;;)
    {
      localh.f(13470, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(this.fUZ), Integer.valueOf(this.fUY), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(this.fUX) });
      this.fUY += 1;
      AppMethodBeat.o(104483);
      return;
      i = 0;
      break;
      label183:
      j = 0;
    }
  }
  
  public final void oT(long paramLong)
  {
    AppMethodBeat.i(104482);
    ac.i("EmojiClickReport", "panelShow");
    this.fUX = paramLong;
    this.fUY = 1;
    AppMethodBeat.o(104482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */