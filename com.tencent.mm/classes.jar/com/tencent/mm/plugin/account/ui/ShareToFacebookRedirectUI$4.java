package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;

final class ShareToFacebookRedirectUI$4
  implements e.c
{
  ShareToFacebookRedirectUI$4(ShareToFacebookRedirectUI paramShareToFacebookRedirectUI, e.a parama) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(125574);
    this.gKl.hideVKB();
    this.gKm.gwf.dismiss();
    if (paramBoolean)
    {
      bzd localbzd = new bzd();
      String str = paramString;
      if (bo.isNullOrNil(paramString)) {
        str = " ";
      }
      localbzd.nqz = str;
      localbzd.Name = ShareToFacebookRedirectUI.b(this.gKl);
      localbzd.woO = ShareToFacebookRedirectUI.c(this.gKl);
      localbzd.ped = ShareToFacebookRedirectUI.d(this.gKl);
      localbzd.xLg = ShareToFacebookRedirectUI.e(this.gKl);
      paramString = new f(localbzd);
      g.Rc().a(paramString, 0);
      ShareToFacebookRedirectUI.a(this.gKl, h.b(this.gKl, "", false, new ShareToFacebookRedirectUI.4.1(this)));
      AppMethodBeat.o(125574);
      return;
    }
    this.gKl.finish();
    AppMethodBeat.o(125574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.4
 * JD-Core Version:    0.7.0.1
 */