package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

final class IPCallRechargeUI$1
  implements h.a
{
  IPCallRechargeUI$1(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void x(ArrayList<n> paramArrayList)
  {
    IPCallRechargeUI.a(this.lxJ).lst = bk.UY();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      IPCallRechargeUI.a(this.lxJ, new String[paramArrayList.size()]);
      IPCallRechargeUI.b(this.lxJ, new String[paramArrayList.size()]);
      n localn = (n)paramArrayList.get(0);
      if (localn.rTC == 10232)
      {
        y.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramArrayList.size());
        paramArrayList = paramArrayList.iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localn = (n)paramArrayList.next();
          BigDecimal localBigDecimal = new BigDecimal(localn.rTB).divide(new BigDecimal(1000000));
          IPCallRechargeUI.b(this.lxJ)[i] = localBigDecimal.toString();
          IPCallRechargeUI.c(this.lxJ)[i] = localn.rTA;
          i += 1;
        }
        if ((IPCallRechargeUI.d(this.lxJ) > 0) && (IPCallRechargeUI.c(this.lxJ).length > 0))
        {
          paramArrayList = IPCallRechargeUI.c(this.lxJ)[0];
          if ((!bk.bl(paramArrayList)) && (!paramArrayList.equals(IPCallRechargeUI.e(this.lxJ))))
          {
            y.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(this.lxJ) + ",google wallet currency:" + paramArrayList);
            IPCallRechargeUI.a(this.lxJ, paramArrayList);
            return;
          }
        }
        if ((IPCallRechargeUI.f(this.lxJ) != null) && (IPCallRechargeUI.f(this.lxJ).isShowing())) {
          IPCallRechargeUI.f(this.lxJ).dismiss();
        }
        this.lxJ.bde();
        return;
      }
      if ((IPCallRechargeUI.f(this.lxJ) != null) && (IPCallRechargeUI.f(this.lxJ).isShowing())) {
        IPCallRechargeUI.f(this.lxJ).dismiss();
      }
      IPCallRechargeUI.a(this.lxJ, localn.rTC);
      y.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(this.lxJ));
      this.lxJ.bde();
      return;
    }
    if ((IPCallRechargeUI.f(this.lxJ) != null) && (IPCallRechargeUI.f(this.lxJ).isShowing())) {
      IPCallRechargeUI.f(this.lxJ).dismiss();
    }
    y.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
    IPCallRechargeUI.a(this.lxJ, 10236);
    this.lxJ.bde();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.1
 * JD-Core Version:    0.7.0.1
 */