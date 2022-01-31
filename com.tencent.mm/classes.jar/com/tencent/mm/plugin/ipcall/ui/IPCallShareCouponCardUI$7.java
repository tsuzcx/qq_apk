package com.tencent.mm.plugin.ipcall.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class IPCallShareCouponCardUI$7
  implements q.a
{
  IPCallShareCouponCardUI$7(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(22289);
    if (paramBoolean)
    {
      Object localObject = new j.b();
      ((j.b)localObject).title = IPCallShareCouponCardUI.d(this.nVC);
      ((j.b)localObject).url = IPCallShareCouponCardUI.e(this.nVC);
      ((j.b)localObject).description = IPCallShareCouponCardUI.f(this.nVC);
      ((j.b)localObject).thumburl = IPCallShareCouponCardUI.g(this.nVC);
      ((j.b)localObject).type = 5;
      l.a((j.b)localObject, null, null, this.fwC, "", null, null);
      if (!bo.isNullOrNil(paramString))
      {
        localObject = new qj();
        ((qj)localObject).cGX.cGY = this.fwC;
        ((qj)localObject).cGX.content = paramString;
        ((qj)localObject).cGX.type = t.oF(this.fwC);
        ((qj)localObject).cGX.flags = 0;
        a.ymk.l((b)localObject);
      }
      h.bO(this.nVC.getContext(), this.nVC.getResources().getString(2131297076));
      AppMethodBeat.o(22289);
      return;
    }
    AppMethodBeat.o(22289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.7
 * JD-Core Version:    0.7.0.1
 */