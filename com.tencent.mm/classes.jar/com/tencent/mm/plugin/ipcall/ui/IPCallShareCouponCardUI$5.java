package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelmulti.g;
import com.tencent.mm.pluginsdk.ui.applet.q.b;
import com.tencent.mm.ui.base.h;

final class IPCallShareCouponCardUI$5
  implements q.b
{
  IPCallShareCouponCardUI$5(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, EditText paramEditText, String paramString, int paramInt) {}
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(22286);
    if (paramBoolean)
    {
      if (this.nVD == null) {}
      for (Object localObject = this.gWF;; localObject = this.nVD.getText().toString())
      {
        localObject = new g(this.nVE, (String)localObject);
        IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = this.nVC;
        IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = this.nVC;
        this.nVC.getString(2131297087);
        IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, h.b(localIPCallShareCouponCardUI2, this.nVC.getString(2131297069), true, new IPCallShareCouponCardUI.5.1(this, (g)localObject)));
        aw.Rc().a((m)localObject, 0);
        AppMethodBeat.o(22286);
        return;
      }
    }
    AppMethodBeat.o(22286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.5
 * JD-Core Version:    0.7.0.1
 */