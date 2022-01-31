package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.g;
import com.tencent.mm.pluginsdk.ui.applet.q.b;
import com.tencent.mm.ui.base.h;

final class IPCallShareCouponCardUI$5
  implements q.b
{
  IPCallShareCouponCardUI$5(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, EditText paramEditText, String paramString, int paramInt) {}
  
  public final void hc(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.lyr != null) {
        break label91;
      }
    }
    label91:
    for (Object localObject = this.fEp;; localObject = this.lyr.getText().toString())
    {
      localObject = new g(this.lys, (String)localObject);
      IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = this.lyq;
      IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = this.lyq;
      this.lyq.getString(R.l.app_tip);
      IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, h.b(localIPCallShareCouponCardUI2, this.lyq.getString(R.l.app_sending), true, new IPCallShareCouponCardUI.5.1(this, (g)localObject)));
      au.Dk().a((m)localObject, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.5
 * JD-Core Version:    0.7.0.1
 */