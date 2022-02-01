package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$7
  implements x.a
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, CheckBoxPreference paramCheckBoxPreference, LinkedList paramLinkedList, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(196143);
    ad.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.b(this.lym);
      t.makeText(this.lym, this.lym.getString(2131756043), 1).show();
      paramString = this.lyp;
      if (!this.lyp.isChecked()) {}
      for (bool = true;; bool = false)
      {
        paramString.lG = bool;
        AppMethodBeat.o(196143);
        return 0;
      }
    }
    if ((crx)paramb.gUT.gUX == null) {
      ad.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
    }
    paramInt1 = 0;
    while (paramInt1 < this.fvD.size())
    {
      paramString = (dvt)this.fvD.get(paramInt1);
      if (paramString == null)
      {
        ad.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
        paramInt1 += 1;
      }
      else
      {
        paramb = new wa();
        paramb.dBz.appId = this.val$appId;
        paramn = paramb.dBz;
        if (paramString.status == 0) {}
        for (bool = true;; bool = false)
        {
          paramn.dbq = bool;
          a.ESL.l(paramb);
          break;
        }
      }
    }
    AppBrandAuthorizeUI.b(this.lym);
    AppMethodBeat.o(196143);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */