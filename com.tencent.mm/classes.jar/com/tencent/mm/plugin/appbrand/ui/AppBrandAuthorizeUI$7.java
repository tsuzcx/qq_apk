package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$7
  implements aa.a
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, CheckBoxPreference paramCheckBoxPreference, LinkedList paramLinkedList, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(227566);
    Log.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.b(this.nRR);
      u.makeText(this.nRR, this.nRR.getString(2131756158), 1).show();
      paramString = this.nRV;
      if (!this.nRV.isChecked()) {}
      for (bool = true;; bool = false)
      {
        paramString.setChecked(bool);
        AppMethodBeat.o(227566);
        return 0;
      }
    }
    if ((dwr)paramd.iLL.iLR == null) {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
    }
    paramInt1 = 0;
    while (paramInt1 < this.gzK.size())
    {
      paramString = (fdy)this.gzK.get(paramInt1);
      if (paramString == null)
      {
        Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
        paramInt1 += 1;
      }
      else
      {
        paramd = new yj();
        paramd.eeG.appId = this.val$appId;
        paramq = paramd.eeG;
        if (paramString.status == 0) {}
        for (bool = true;; bool = false)
        {
          paramq.dCs = bool;
          EventCenter.instance.publish(paramd);
          break;
        }
      }
    }
    AppBrandAuthorizeUI.b(this.nRR);
    AppMethodBeat.o(227566);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */