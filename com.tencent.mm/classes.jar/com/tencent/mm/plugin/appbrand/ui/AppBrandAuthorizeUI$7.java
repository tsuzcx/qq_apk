package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.zq;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.foz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$7
  implements aa.a
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, CheckBoxPreference paramCheckBoxPreference, LinkedList paramLinkedList, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(281526);
    Log.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.b(this.qTu);
      w.makeText(this.qTu, this.qTu.getString(au.i.appbrand_setting_network_fail), 1).show();
      paramString = this.qTy;
      if (!this.qTy.isChecked()) {}
      for (bool = true;; bool = false)
      {
        paramString.setChecked(bool);
        AppMethodBeat.o(281526);
        return 0;
      }
    }
    if ((egr)d.c.b(paramd.lBS) == null) {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
    }
    paramInt1 = 0;
    while (paramInt1 < this.jjN.size())
    {
      paramString = (foz)this.jjN.get(paramInt1);
      if (paramString == null)
      {
        Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
        paramInt1 += 1;
      }
      else
      {
        paramd = new zq();
        paramd.fYV.appId = this.val$appId;
        paramq = paramd.fYV;
        if (paramString.status == 0) {}
        for (bool = true;; bool = false)
        {
          paramq.fuZ = bool;
          EventCenter.instance.publish(paramd);
          break;
        }
      }
    }
    AppBrandAuthorizeUI.b(this.qTu);
    AppMethodBeat.o(281526);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */