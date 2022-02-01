package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatEmojiBtnClickReport";
  private static long fQX;
  private static boolean fQY;
  private static boolean fQZ;
  public static final a fRa;
  
  static
  {
    AppMethodBeat.i(105725);
    fRa = new a();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void acj()
  {
    fQY = true;
  }
  
  public static void ack()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    fQX = System.currentTimeMillis();
    ad.i(TAG, "recordOpen: " + fQX + ", " + fQZ);
    if (!fQZ)
    {
      Object localObject = h.vKh;
      if (fQY) {
        i = 1;
      }
      ((h)localObject).f(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(fQX) });
      b.acm().lq(fQX);
      f.acp().lq(fQX);
      localObject = e.fRj;
      e.lq(fQX);
    }
    fQZ = true;
    fQY = false;
    AppMethodBeat.o(105723);
  }
  
  public static void acl()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - fQX;
    ad.i(TAG, "recordClose: " + l + ", " + fQX + ", " + fQZ);
    h localh;
    if (fQZ)
    {
      localh = h.vKh;
      if (!fQY) {
        break label110;
      }
    }
    for (;;)
    {
      localh.f(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      fQZ = false;
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