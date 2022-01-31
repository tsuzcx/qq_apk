package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.h.a.tk.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.j;

final class MallIndexUI$2
  implements Runnable
{
  boolean edU = false;
  
  MallIndexUI$2(MallIndexUI paramMallIndexUI, tk paramtk) {}
  
  public final void run()
  {
    y.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.e(this.mau).cde + " hasNewTips : " + MallIndexUI.e(this.mau).cdf + " swipeOn : " + MallIndexUI.e(this.mau).cdg);
    if ((MallIndexUI.i(this.mau)) || (this.mau.mController.uMN.isFinishing()))
    {
      y.e("MicorMsg.MallIndexUI", "error for callback ac finish");
      return;
    }
    y.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(this.mav.cda.cdE), Boolean.valueOf(this.edU) });
    MallIndexUI.b(this.mau, this.mav.cda);
    int i;
    Object localObject1;
    boolean bool2;
    Object localObject2;
    if (MallIndexUI.e(this.mau).cdF != null)
    {
      i = 1;
      if ((i & MallIndexUI.e(this.mau).cdF instanceof j) != 0)
      {
        localObject1 = (j)MallIndexUI.e(this.mau).cdF;
        if (((j)localObject1).cMv()) {
          ((com.tencent.mm.wallet_core.c.o)localObject1).lQQ.a(this.mau, new MallIndexUI.2.1(this));
        }
      }
      if (MallIndexUI.e(this.mau).errCode == 0)
      {
        this.mau.bgQ();
        this.mau.bgN();
        localObject1 = this.mau;
        y.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
        if ((((MallIndexUI)localObject1).maf == null) || ((!((MallIndexUI)localObject1).maf.cdd) && (!((MallIndexUI)localObject1).maf.cdj))) {
          break label669;
        }
        bool2 = com.tencent.mm.plugin.wallet_core.model.o.bVs().bVR().bVI();
        g.DQ();
        localObject2 = g.DP().Dz().get(ac.a.urA, Boolean.valueOf(false));
        if (localObject2 == null) {
          break label700;
        }
      }
    }
    label420:
    label685:
    label700:
    for (boolean bool1 = ((Boolean)localObject2).booleanValue();; bool1 = false)
    {
      y.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.urA, Boolean.valueOf(true));
        h.a((Context)localObject1, ((MallIndexUI)localObject1).getString(a.i.mall_multi_wallet_tip), null, true, null);
      }
      MallIndexUI.c(this.mau, MallIndexUI.e(this.mau));
      this.mau.bgP();
      y.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.e(this.mau).cdB), Boolean.valueOf(MallIndexUI.e(this.mau).cdC), MallIndexUI.e(this.mau).cdD });
      localObject1 = this.mau;
      if (MallIndexUI.e(this.mau).cdB == 1)
      {
        bool1 = true;
        MallIndexUI.a((MallIndexUI)localObject1, bool1);
        MallIndexUI.b(this.mau, MallIndexUI.e(this.mau).cdC);
        MallIndexUI.a(this.mau, MallIndexUI.e(this.mau).cdD);
        if (MallIndexUI.j(this.mau) != null)
        {
          if (!MallIndexUI.k(this.mau)) {
            break label685;
          }
          MallIndexUI.j(this.mau).setVisibility(0);
        }
      }
      for (;;)
      {
        localObject1 = this.mau;
        localObject2 = new ae();
        ((MallIndexUI)localObject1).man.a(new MallIndexUI.3((MallIndexUI)localObject1), ((ae)localObject2).bVJ());
        if ((this.mav.cda.cdE) && (this.edU)) {
          this.mau.aZ();
        }
        this.edU = true;
        return;
        i = 0;
        break;
        y.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
        break label420;
        bool1 = false;
        break label520;
        MallIndexUI.j(this.mau).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.2
 * JD-Core Version:    0.7.0.1
 */