package com.tencent.mm.app;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

final class v$1
  implements q.a
{
  v$1(v paramv, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean) {
      return;
    }
    l.a(this.bya, this.val$appId, this.byb, this.bxX, 3, null);
    if (!bk.bl(paramString))
    {
      pe localpe = new pe();
      localpe.bYQ.bYR = this.bxX;
      localpe.bYQ.content = paramString;
      localpe.bYQ.type = s.hW(this.bxX);
      localpe.bYQ.flags = 0;
      a.udP.m(localpe);
    }
    com.tencent.mm.ui.base.h.bC(this.byc, this.byc.getResources().getString(R.l.app_shared));
    com.tencent.mm.plugin.report.service.h.nFQ.aC(10910, "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.v.1
 * JD-Core Version:    0.7.0.1
 */