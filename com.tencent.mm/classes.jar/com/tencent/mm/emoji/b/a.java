package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long fUS;
  private static boolean fUT;
  private static boolean fUU;
  public static final a fUV;
  
  static
  {
    AppMethodBeat.i(105725);
    fUV = new a();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void adp()
  {
    fUT = true;
  }
  
  public static void adq()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    fUS = System.currentTimeMillis();
    ac.i(TAG, "recordOpen: " + fUS + ", " + fUU);
    if (!fUU)
    {
      Object localObject = h.wUl;
      if (fUT) {
        i = 1;
      }
      ((h)localObject).f(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(fUS) });
      b.ads().oT(fUS);
      f.adv().oT(fUS);
      localObject = e.fVe;
      e.oT(fUS);
    }
    fUU = true;
    fUT = false;
    AppMethodBeat.o(105723);
  }
  
  public static void adr()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - fUS;
    ac.i(TAG, "recordClose: " + l + ", " + fUS + ", " + fUU);
    h localh;
    if (fUU)
    {
      localh = h.wUl;
      if (!fUT) {
        break label110;
      }
    }
    for (;;)
    {
      localh.f(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      fUU = false;
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