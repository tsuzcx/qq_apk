package com.tencent.mm.emoji.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class a
{
  private static long exf;
  private static boolean exg;
  private static boolean exh;
  public static final a exi;
  
  static
  {
    AppMethodBeat.i(151777);
    exi = new a();
    AppMethodBeat.o(151777);
  }
  
  public static void OX()
  {
    exg = true;
  }
  
  public static void OY()
  {
    AppMethodBeat.i(151775);
    h localh;
    if (!exh)
    {
      localh = h.qsU;
      if (!exg) {
        break label68;
      }
    }
    label68:
    for (int i = 1;; i = 3)
    {
      localh.e(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      exf = System.currentTimeMillis();
      exh = true;
      exg = false;
      AppMethodBeat.o(151775);
      return;
    }
  }
  
  public static void OZ()
  {
    int i = 2;
    AppMethodBeat.i(151776);
    long l1 = System.currentTimeMillis();
    long l2 = exf;
    h localh;
    if (exh)
    {
      localh = h.qsU;
      if (!exg) {
        break label70;
      }
    }
    for (;;)
    {
      localh.e(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l1 - l2) });
      exh = false;
      AppMethodBeat.o(151776);
      return;
      label70:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */