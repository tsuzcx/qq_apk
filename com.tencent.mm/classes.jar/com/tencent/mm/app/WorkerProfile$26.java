package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMAppMgr;

final class WorkerProfile$26
  implements e.a
{
  WorkerProfile$26(WorkerProfile paramWorkerProfile) {}
  
  public final void bi(Context paramContext)
  {
    AppMethodBeat.i(138593);
    MMAppMgr.l(paramContext, true);
    AppMethodBeat.o(138593);
  }
  
  public final void bj(Context paramContext)
  {
    AppMethodBeat.i(138596);
    ab.any().edit().putBoolean("is_in_notify_mode", true).commit();
    aj.apl("welcome_page_show");
    ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().n(-1, null);
    y localy = new y();
    localy.cne.cnf = false;
    com.tencent.mm.sdk.b.a.ymk.l(localy);
    b.gmP.BR();
    ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IG();
    MMAppMgr.l(paramContext, false);
    AppMethodBeat.o(138596);
  }
  
  public final void l(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(138595);
    MMAppMgr.l(paramContext, paramBoolean);
    AppMethodBeat.o(138595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.26
 * JD-Core Version:    0.7.0.1
 */