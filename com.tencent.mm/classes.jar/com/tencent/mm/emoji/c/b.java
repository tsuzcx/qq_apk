package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long hca;
  private static boolean hcb;
  private static boolean hcc;
  public static final b hcd;
  
  static
  {
    AppMethodBeat.i(105725);
    hcd = new b();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void avZ()
  {
    hcb = true;
  }
  
  public static void awa()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    hca = System.currentTimeMillis();
    Log.i(TAG, "recordOpen: " + hca + ", " + hcc);
    if (!hcc)
    {
      Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (hcb) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(hca) });
      c.awc().zj(hca);
      h.awf().zj(hca);
      localObject = g.hcn;
      g.zj(hca);
    }
    hcc = true;
    hcb = false;
    AppMethodBeat.o(105723);
  }
  
  public static void awb()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - hca;
    Log.i(TAG, "recordClose: " + l + ", " + hca + ", " + hcc);
    com.tencent.mm.plugin.report.service.h localh;
    if (hcc)
    {
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      if (!hcb) {
        break label110;
      }
    }
    for (;;)
    {
      localh.a(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      hcc = false;
      AppMethodBeat.o(105724);
      return;
      label110:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */