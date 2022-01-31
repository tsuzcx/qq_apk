package com.tencent.mm.console;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.cl.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac;

final class b$12
  implements DialogInterface.OnClickListener
{
  b$12(String paramString, Context paramContext, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new com.tencent.mm.storage.y(ac.dOP + "SdcardInfo.cfg");
    paramDialogInterface.set(1, this.dAH);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + paramDialogInterface.get(1));
    ag.Zn("welcome_page_show");
    com.tencent.mm.kernel.l.k(this.dAE, true);
    paramDialogInterface = new com.tencent.mm.h.a.y();
    paramDialogInterface.bFX.bFY = false;
    a.udP.m(paramDialogInterface);
    WorkerProfile.ts().bxM.tn();
    au.getNotification().wp();
    b.afs("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    if (e.rVK != null) {
      e.rVK.aK(this.val$activity);
    }
    this.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.b.12
 * JD-Core Version:    0.7.0.1
 */