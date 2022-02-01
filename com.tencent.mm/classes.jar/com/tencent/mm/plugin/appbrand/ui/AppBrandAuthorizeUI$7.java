package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.abl;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.protocal.protobuf.glz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$7
  implements z.a
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, CheckBoxPreference paramCheckBoxPreference, LinkedList paramLinkedList, String paramString) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(321957);
    Log.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.c(this.tYl);
      aa.makeText(this.tYl, this.tYl.getString(ba.i.appbrand_setting_network_fail), 1).show();
      paramString = this.tYp;
      if (!this.tYp.isChecked()) {}
      for (bool = true;; bool = false)
      {
        paramString.setChecked(bool);
        AppMethodBeat.o(321957);
        return 0;
      }
    }
    if ((far)c.c.b(paramc.otC) == null) {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
    }
    paramInt1 = 0;
    while (paramInt1 < this.lMr.size())
    {
      paramString = (glz)this.lMr.get(paramInt1);
      if (paramString == null)
      {
        Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
        paramInt1 += 1;
      }
      else
      {
        paramc = new abl();
        paramc.ieZ.appId = this.etl;
        paramp = paramc.ieZ;
        if (paramString.status == 0) {}
        for (bool = true;; bool = false)
        {
          paramp.hzt = bool;
          paramc.publish();
          break;
        }
      }
    }
    AppBrandAuthorizeUI.c(this.tYl);
    AppMethodBeat.o(321957);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */