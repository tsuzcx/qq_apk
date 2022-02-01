package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.eho;
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
    AppMethodBeat.i(188817);
    ad.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.b(this.mAb);
      t.makeText(this.mAb, this.mAb.getString(2131756043), 1).show();
      paramString = this.mAf;
      if (!this.mAf.isChecked()) {}
      for (bool = true;; bool = false)
      {
        paramString.oB = bool;
        AppMethodBeat.o(188817);
        return 0;
      }
    }
    if ((dct)paramb.hNL.hNQ == null) {
      ad.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
    }
    paramInt1 = 0;
    while (paramInt1 < this.fSx.size())
    {
      paramString = (eho)this.fSx.get(paramInt1);
      if (paramString == null)
      {
        ad.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
        paramInt1 += 1;
      }
      else
      {
        paramb = new xe();
        paramb.dLz.appId = this.val$appId;
        paramn = paramb.dLz;
        if (paramString.status == 0) {}
        for (bool = true;; bool = false)
        {
          paramn.dke = bool;
          a.IbL.l(paramb);
          break;
        }
      }
    }
    AppBrandAuthorizeUI.b(this.mAb);
    AppMethodBeat.o(188817);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */