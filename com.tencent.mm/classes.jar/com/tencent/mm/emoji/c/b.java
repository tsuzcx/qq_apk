package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long jNk;
  private static boolean jNl;
  private static boolean jNm;
  public static final b jNn;
  
  static
  {
    AppMethodBeat.i(105725);
    jNn = new b();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void aCY()
  {
    jNl = true;
  }
  
  public static void aCZ()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    jNk = System.currentTimeMillis();
    Log.i(TAG, "recordOpen: " + jNk + ", " + jNm);
    if (!jNm)
    {
      Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (jNl) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(jNk) });
      c.aDb().Fn(jNk);
      h.aDe().Fn(jNk);
      localObject = g.jNx;
      g.Fn(jNk);
    }
    jNm = true;
    jNl = false;
    AppMethodBeat.o(105723);
  }
  
  public static void aDa()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - jNk;
    Log.i(TAG, "recordClose: " + l + ", " + jNk + ", " + jNm);
    com.tencent.mm.plugin.report.service.h localh;
    if (jNm)
    {
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      if (!jNl) {
        break label110;
      }
    }
    for (;;)
    {
      localh.a(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      jNm = false;
      AppMethodBeat.o(105724);
      return;
      label110:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */