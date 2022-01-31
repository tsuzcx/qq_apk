package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.d;

final class ShareToFacebookRedirectUI$4
  implements e.d
{
  ShareToFacebookRedirectUI$4(ShareToFacebookRedirectUI paramShareToFacebookRedirectUI, e.a parama) {}
  
  public final void b(boolean paramBoolean, String paramString)
  {
    this.fsJ.XM();
    this.fsK.few.dismiss();
    if (paramBoolean)
    {
      bpg localbpg = new bpg();
      String str = paramString;
      if (bk.bl(paramString)) {
        str = " ";
      }
      localbpg.kSz = str;
      localbpg.kRZ = ShareToFacebookRedirectUI.b(this.fsJ);
      localbpg.sxZ = ShareToFacebookRedirectUI.c(this.fsJ);
      localbpg.mEb = ShareToFacebookRedirectUI.d(this.fsJ);
      localbpg.tHj = ShareToFacebookRedirectUI.e(this.fsJ);
      paramString = new f(localbpg);
      g.Dk().a(paramString, 0);
      ShareToFacebookRedirectUI.a(this.fsJ, h.b(this.fsJ, "", false, new ShareToFacebookRedirectUI.4.1(this)));
      return;
    }
    this.fsJ.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.4
 * JD-Core Version:    0.7.0.1
 */