package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class MallIndexBaseUI$2
  implements b.d
{
  MallIndexBaseUI$2(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void a(int paramInt, MallFunction paramMallFunction)
  {
    String str;
    int i;
    if (paramMallFunction != null)
    {
      str = paramMallFunction.npy;
      if (bk.bl(str)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i == 0) && (!bk.bl(paramMallFunction.qzy)))
      {
        y.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramMallFunction.npy });
        com.tencent.mm.ui.base.h.a(this.lZE.mController.uMN, paramMallFunction.qzy, this.lZE.getString(a.i.mall_third_party_disclaimer_title), this.lZE.getString(a.i.remittance_i_known), new MallIndexBaseUI.2.1(this, paramMallFunction, paramInt));
      }
      for (;;)
      {
        y.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramMallFunction.type) });
        com.tencent.mm.plugin.report.service.h.nFQ.f(14419, new Object[] { this.lZE.dCX, Integer.valueOf(4), Integer.valueOf(paramMallFunction.type) });
        return;
        g.DQ();
        Object localObject = (String)g.DP().Dz().get(ac.a.urq, null);
        if (bk.bl((String)localObject))
        {
          i = 0;
          break;
        }
        localObject = ((String)localObject).split(",");
        if ((localObject == null) || (localObject.length == 0))
        {
          i = 0;
          break;
        }
        i = 0;
        for (;;)
        {
          if (i >= localObject.length) {
            break label286;
          }
          if (localObject[i].equals(str))
          {
            i = 1;
            break;
          }
          i += 1;
        }
        this.lZE.a(paramMallFunction, paramInt);
      }
      y.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramInt) });
      return;
      label286:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.2
 * JD-Core Version:    0.7.0.1
 */