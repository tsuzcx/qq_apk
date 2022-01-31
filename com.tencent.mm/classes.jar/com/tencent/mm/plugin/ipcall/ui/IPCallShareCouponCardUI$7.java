package com.tencent.mm.plugin.ipcall.ui;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class IPCallShareCouponCardUI$7
  implements q.a
{
  IPCallShareCouponCardUI$7(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      Object localObject = new g.a();
      ((g.a)localObject).title = IPCallShareCouponCardUI.d(this.lyq);
      ((g.a)localObject).url = IPCallShareCouponCardUI.e(this.lyq);
      ((g.a)localObject).description = IPCallShareCouponCardUI.f(this.lyq);
      ((g.a)localObject).thumburl = IPCallShareCouponCardUI.g(this.lyq);
      ((g.a)localObject).type = 5;
      l.a((g.a)localObject, null, null, this.egy, "", null, null);
      if (!bk.bl(paramString))
      {
        localObject = new pe();
        ((pe)localObject).bYQ.bYR = this.egy;
        ((pe)localObject).bYQ.content = paramString;
        ((pe)localObject).bYQ.type = com.tencent.mm.model.s.hW(this.egy);
        ((pe)localObject).bYQ.flags = 0;
        a.udP.m((b)localObject);
      }
      h.bC(this.lyq.mController.uMN, this.lyq.getResources().getString(R.l.app_shared));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.7
 * JD-Core Version:    0.7.0.1
 */