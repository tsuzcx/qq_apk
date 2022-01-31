package com.tencent.mm.app;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class ab$1
  implements q.a
{
  ab$1(ab paramab, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(15559);
    if (!paramBoolean)
    {
      AppMethodBeat.o(15559);
      return;
    }
    l.a(this.cac, this.val$appId, this.cad, this.bZZ, 3, null);
    if (!bo.isNullOrNil(paramString))
    {
      qj localqj = new qj();
      localqj.cGX.cGY = this.bZZ;
      localqj.cGX.content = paramString;
      localqj.cGX.type = t.oF(this.bZZ);
      localqj.cGX.flags = 0;
      a.ymk.l(localqj);
    }
    com.tencent.mm.ui.base.h.bO(this.cae, this.cae.getResources().getString(2131297076));
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10910, "2");
    AppMethodBeat.o(15559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ab.1
 * JD-Core Version:    0.7.0.1
 */