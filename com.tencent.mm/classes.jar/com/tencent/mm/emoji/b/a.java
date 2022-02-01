package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long gqQ;
  private static boolean gqR;
  private static boolean gqS;
  public static final a gqT;
  
  static
  {
    AppMethodBeat.i(105725);
    gqT = new a();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void agj()
  {
    gqR = true;
  }
  
  public static void agk()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    gqQ = System.currentTimeMillis();
    ae.i(TAG, "recordOpen: " + gqQ + ", " + gqS);
    if (!gqS)
    {
      Object localObject = g.yxI;
      if (gqR) {
        i = 1;
      }
      ((g)localObject).f(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(gqQ) });
      b.agm().rg(gqQ);
      f.agp().rg(gqQ);
      localObject = e.grc;
      e.rg(gqQ);
    }
    gqS = true;
    gqR = false;
    AppMethodBeat.o(105723);
  }
  
  public static void agl()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - gqQ;
    ae.i(TAG, "recordClose: " + l + ", " + gqQ + ", " + gqS);
    g localg;
    if (gqS)
    {
      localg = g.yxI;
      if (!gqR) {
        break label110;
      }
    }
    for (;;)
    {
      localg.f(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      gqS = false;
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