package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b mmj;
  private static long mmk;
  private static boolean mml;
  private static boolean mmm;
  
  static
  {
    AppMethodBeat.i(105725);
    mmj = new b();
    TAG = "MicroMsg.ChatEmojiBtnClickReport";
    AppMethodBeat.o(105725);
  }
  
  public static void aVY()
  {
    mml = true;
  }
  
  public static void aVZ()
  {
    int i = 3;
    AppMethodBeat.i(105723);
    mmk = System.currentTimeMillis();
    Log.i(TAG, "recordOpen: " + mmk + ", " + mmm);
    if (!mmm)
    {
      Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (mml) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).b(17302, new Object[] { Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(mmk) });
      localObject = c.aWb();
      long l = mmk;
      Log.i("EmojiClickReport", "panelShow");
      ((c)localObject).mmo = l;
      ((c)localObject).mmp = 1;
      localObject = h.aWe();
      ((h)localObject).mmo = mmk;
      ((h)localObject).mmp = 1;
      localObject = g.mmw;
      g.hv(mmk);
    }
    mmm = true;
    mml = false;
    AppMethodBeat.o(105723);
  }
  
  public static void aWa()
  {
    int i = 2;
    AppMethodBeat.i(105724);
    long l = System.currentTimeMillis() - mmk;
    Log.i(TAG, "recordClose: " + l + ", " + mmk + ", " + mmm);
    com.tencent.mm.plugin.report.service.h localh;
    if (mmm)
    {
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (!mml) {
        break label110;
      }
    }
    for (;;)
    {
      localh.b(17302, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      mmm = false;
      AppMethodBeat.o(105724);
      return;
      label110:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.d.b
 * JD-Core Version:    0.7.0.1
 */