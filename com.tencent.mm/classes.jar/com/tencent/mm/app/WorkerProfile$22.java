package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMAppMgr;

final class WorkerProfile$22
  implements e.a
{
  WorkerProfile$22(WorkerProfile paramWorkerProfile) {}
  
  public final void aK(Context paramContext)
  {
    MMAppMgr.i(paramContext, true);
  }
  
  public final void aL(Context paramContext)
  {
    aa.Un().edit().putBoolean("is_in_notify_mode", true).commit();
    ag.Zn("welcome_page_show");
    ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().k(-1, null);
    com.tencent.mm.h.a.y localy = new com.tencent.mm.h.a.y();
    localy.bFX.bFY = false;
    com.tencent.mm.sdk.b.a.udP.m(localy);
    b.eUS.tn();
    ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().wp();
    MMAppMgr.i(paramContext, false);
  }
  
  public final void i(Context paramContext, boolean paramBoolean)
  {
    MMAppMgr.i(paramContext, paramBoolean);
  }
  
  public final boolean tw()
  {
    if ((!com.tencent.mm.protocal.d.spd) && (!com.tencent.mm.br.d.Xm("whatsnew"))) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAppMgr", "plugin cannot load");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.22
 * JD-Core Version:    0.7.0.1
 */