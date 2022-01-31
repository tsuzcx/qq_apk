package com.tencent.mm.app.plugin;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;

final class URISpanHandlerSet$DeeplinkUriSpanHandler$4
  implements d.a
{
  URISpanHandlerSet$DeeplinkUriSpanHandler$4(URISpanHandlerSet.DeeplinkUriSpanHandler paramDeeplinkUriSpanHandler, p paramp) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((this.byu != null) && (this.byu.isShowing())) {
      this.byu.dismiss();
    }
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof aa)))
    {
      paramString = ((aa)paramm).QR();
      if ((paramString != null) && (URISpanHandlerSet.a(this.bys.byk) != null)) {
        s.makeText(URISpanHandlerSet.a(this.bys.byk), URISpanHandlerSet.a(this.bys.byk).getString(R.l.app_tip) + " : " + bk.pm(paramString.tOY), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.4
 * JD-Core Version:    0.7.0.1
 */