package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static c jNo;
  public boolean jKk;
  public long jNp;
  public int jNq;
  public int jNr;
  public int scene;
  
  public static c aDb()
  {
    AppMethodBeat.i(104481);
    if (jNo == null) {
      jNo = new c();
    }
    c localc = jNo;
    AppMethodBeat.o(104481);
    return localc;
  }
  
  public final void Fn(long paramLong)
  {
    AppMethodBeat.i(104482);
    Log.i("EmojiClickReport", "panelShow");
    this.jNp = paramLong;
    this.jNq = 1;
    AppMethodBeat.o(104482);
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(104483);
    long l1 = System.currentTimeMillis();
    long l2 = this.jNp;
    h localh = h.IzE;
    int k = this.scene;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.jKk) {
        break label183;
      }
    }
    for (;;)
    {
      localh.a(13470, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(this.jNr), Integer.valueOf(this.jNq), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(this.jNp) });
      this.jNq += 1;
      AppMethodBeat.o(104483);
      return;
      i = 0;
      break;
      label183:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */