package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long gov;
  private static boolean gow;
  private static boolean gox;
  public static final a goy;
  
  static
  {
    AppMethodBeat.i(105725);
    goy = new a();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void afV()
  {
    gow = true;
  }
  
  public static void afW()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    gov = System.currentTimeMillis();
    ad.i(TAG, "recordOpen: " + gov + ", " + gox);
    if (!gox)
    {
      Object localObject = g.yhR;
      if (gow) {
        i = 1;
      }
      ((g)localObject).f(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(gov) });
      b.afY().qT(gov);
      f.agb().qT(gov);
      localObject = e.goH;
      e.qT(gov);
    }
    gox = true;
    gow = false;
    AppMethodBeat.o(105723);
  }
  
  public static void afX()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - gov;
    ad.i(TAG, "recordClose: " + l + ", " + gov + ", " + gox);
    g localg;
    if (gox)
    {
      localg = g.yhR;
      if (!gow) {
        break label110;
      }
    }
    for (;;)
    {
      localg.f(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      gox = false;
      AppMethodBeat.o(105724);
      return;
      label110:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a
 * JD-Core Version:    0.7.0.1
 */