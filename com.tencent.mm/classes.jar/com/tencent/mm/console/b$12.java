package com.tencent.mm.console;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.cn.d;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ac;

final class b$12
  implements DialogInterface.OnClickListener
{
  b$12(String paramString, Context paramContext, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16093);
    paramDialogInterface = new com.tencent.mm.storage.y(ac.eQv + "SdcardInfo.cfg");
    paramDialogInterface.set(1, this.eui);
    ab.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + paramDialogInterface.get(1));
    aj.apl("welcome_page_show");
    l.n(this.eug, true);
    paramDialogInterface = new com.tencent.mm.g.a.y();
    paramDialogInterface.cne.cnf = false;
    a.ymk.l(paramDialogInterface);
    WorkerProfile.BW().bZN.BR();
    aw.getNotification().IG();
    d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    if (e.vMF != null) {
      e.vMF.bi(this.val$activity);
    }
    this.val$activity.finish();
    AppMethodBeat.o(16093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.b.12
 * JD-Core Version:    0.7.0.1
 */