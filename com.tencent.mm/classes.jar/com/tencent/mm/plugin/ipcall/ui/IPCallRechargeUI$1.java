package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

final class IPCallRechargeUI$1
  implements h.a
{
  IPCallRechargeUI$1(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void A(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(22251);
    IPCallRechargeUI.a(this.nUW).nPO = bo.aoy();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      IPCallRechargeUI.a(this.nUW, new String[paramArrayList.size()]);
      IPCallRechargeUI.b(this.nUW, new String[paramArrayList.size()]);
      n localn = (n)paramArrayList.get(0);
      if (localn.vKz == 10232)
      {
        ab.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramArrayList.size());
        paramArrayList = paramArrayList.iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localn = (n)paramArrayList.next();
          BigDecimal localBigDecimal = new BigDecimal(localn.vKy).divide(new BigDecimal(1000000));
          IPCallRechargeUI.b(this.nUW)[i] = localBigDecimal.toString();
          IPCallRechargeUI.c(this.nUW)[i] = localn.vKx;
          i += 1;
        }
        if ((IPCallRechargeUI.d(this.nUW) > 0) && (IPCallRechargeUI.c(this.nUW).length > 0))
        {
          paramArrayList = IPCallRechargeUI.c(this.nUW)[0];
          if ((!bo.isNullOrNil(paramArrayList)) && (!paramArrayList.equals(IPCallRechargeUI.e(this.nUW))))
          {
            ab.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(this.nUW) + ",google wallet currency:" + paramArrayList);
            IPCallRechargeUI.a(this.nUW, paramArrayList);
            AppMethodBeat.o(22251);
            return;
          }
        }
        if ((IPCallRechargeUI.f(this.nUW) != null) && (IPCallRechargeUI.f(this.nUW).isShowing())) {
          IPCallRechargeUI.f(this.nUW).dismiss();
        }
        this.nUW.bKo();
        AppMethodBeat.o(22251);
        return;
      }
      if ((IPCallRechargeUI.f(this.nUW) != null) && (IPCallRechargeUI.f(this.nUW).isShowing())) {
        IPCallRechargeUI.f(this.nUW).dismiss();
      }
      IPCallRechargeUI.a(this.nUW, localn.vKz);
      ab.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(this.nUW));
      this.nUW.bKo();
      AppMethodBeat.o(22251);
      return;
    }
    if ((IPCallRechargeUI.f(this.nUW) != null) && (IPCallRechargeUI.f(this.nUW).isShowing())) {
      IPCallRechargeUI.f(this.nUW).dismiss();
    }
    ab.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
    IPCallRechargeUI.a(this.nUW, 10236);
    this.nUW.bKo();
    AppMethodBeat.o(22251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.1
 * JD-Core Version:    0.7.0.1
 */