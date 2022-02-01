package com.tencent.mm.app;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;

final class an$1
  implements y.a
{
  an$1(an paraman, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, Activity paramActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(19604);
    if (!paramBoolean)
    {
      AppMethodBeat.o(19604);
      return;
    }
    m.a(this.fga, this.val$appId, this.fgb, this.ffX, 3, null);
    if (!Util.isNullOrNil(paramString))
    {
      uz localuz = new uz();
      localuz.fUn.fcD = this.ffX;
      localuz.fUn.content = paramString;
      localuz.fUn.type = ab.QZ(this.ffX);
      localuz.fUn.flags = 0;
      EventCenter.instance.publish(localuz);
    }
    com.tencent.mm.ui.base.h.cO(this.fgc, this.fgc.getResources().getString(R.l.app_shared));
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "2");
    AppMethodBeat.o(19604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.an.1
 * JD-Core Version:    0.7.0.1
 */