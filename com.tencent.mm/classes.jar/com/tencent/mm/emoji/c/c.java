package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static c hce;
  public boolean gZj;
  public long hcf;
  public int hcg;
  public int hch;
  public int scene;
  
  public static c awc()
  {
    AppMethodBeat.i(104481);
    if (hce == null) {
      hce = new c();
    }
    c localc = hce;
    AppMethodBeat.o(104481);
    return localc;
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(104483);
    long l1 = System.currentTimeMillis();
    long l2 = this.hcf;
    h localh = h.CyF;
    int k = this.scene;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.gZj) {
        break label183;
      }
    }
    for (;;)
    {
      localh.a(13470, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(this.hch), Integer.valueOf(this.hcg), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(this.hcf) });
      this.hcg += 1;
      AppMethodBeat.o(104483);
      return;
      i = 0;
      break;
      label183:
      j = 0;
    }
  }
  
  public final void zj(long paramLong)
  {
    AppMethodBeat.i(104482);
    Log.i("EmojiClickReport", "panelShow");
    this.hcf = paramLong;
    this.hcg = 1;
    AppMethodBeat.o(104482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */