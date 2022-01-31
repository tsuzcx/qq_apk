package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vf.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a.a;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.tenpay.model.m;

final class MallIndexUI$3
  implements a.a
{
  boolean ftW = false;
  
  MallIndexUI$3(MallIndexUI paramMallIndexUI) {}
  
  public final void r(Object... paramVarArgs)
  {
    AppMethodBeat.i(142111);
    if ((this.oAt.isFinishing()) || (this.oAt.hasFinish()) || (this.oAt.isDestroyed()))
    {
      AppMethodBeat.o(142111);
      return;
    }
    int i;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramVarArgs[0] instanceof vf))
    {
      paramVarArgs = (vf)paramVarArgs[0];
      ab.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.e(this.oAt).cLO + " hasNewTips : " + MallIndexUI.e(this.oAt).cLP + " swipeOn : " + MallIndexUI.e(this.oAt).cLQ);
      if ((MallIndexUI.f(this.oAt)) || (this.oAt.getContext().isFinishing()))
      {
        ab.e("MicorMsg.MallIndexUI", "error for callback ac finish");
        AppMethodBeat.o(142111);
        return;
      }
      ab.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(paramVarArgs.cLK.cMo), Boolean.valueOf(this.ftW) });
      MallIndexUI.a(this.oAt, paramVarArgs.cLK);
      if (MallIndexUI.e(this.oAt).cMp == null) {
        break label820;
      }
      i = 1;
      if ((i & MallIndexUI.e(this.oAt).cMp instanceof m) != 0)
      {
        localObject1 = (m)MallIndexUI.e(this.oAt).cMp;
        if (((m)localObject1).isJumpRemind()) {
          ((m)localObject1).getJumpRemind().a(this.oAt, new f()
          {
            public final void bOi() {}
          });
        }
      }
      if (MallIndexUI.e(this.oAt).errCode == 0)
      {
        this.oAt.bOK();
        this.oAt.bOG();
        localObject2 = this.oAt;
        ab.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
        if ((((MallIndexUI)localObject2).oAd == null) || ((!((MallIndexUI)localObject2).oAd.cLN) && (!((MallIndexUI)localObject2).oAd.cLT))) {
          break label825;
        }
        bool2 = t.cTN().cUt().cUf();
        localObject1 = g.RL().Ru().get(ac.a.yBz, Boolean.FALSE);
        if (localObject1 == null) {
          break label856;
        }
      }
    }
    label563:
    label820:
    label825:
    label841:
    label856:
    for (boolean bool1 = ((Boolean)localObject1).booleanValue();; bool1 = false)
    {
      ab.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        g.RL().Ru().set(ac.a.yBz, Boolean.TRUE);
        localObject1 = new c.a((Context)localObject2);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(2130971258, null, false);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131829409);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131829410);
        localImageView.setImageResource(2130840888);
        localTextView.setText(2131301448);
        ((c.a)localObject1).rH(true);
        ((c.a)localObject1).rG(false);
        ((c.a)localObject1).fu((View)localObject2);
        ((c.a)localObject1).Rb(2131305672);
        ((c.a)localObject1).Ri(2131305958);
        ((c.a)localObject1).aLZ().show();
      }
      if (!this.ftW) {
        MallIndexUI.bOL();
      }
      MallIndexUI.b(this.oAt, MallIndexUI.e(this.oAt));
      this.oAt.bOI();
      ab.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.e(this.oAt).cMk), Boolean.valueOf(MallIndexUI.e(this.oAt).cMl), MallIndexUI.e(this.oAt).cMm });
      localObject1 = this.oAt;
      if (MallIndexUI.e(this.oAt).cMk == 1)
      {
        bool1 = true;
        MallIndexUI.a((MallIndexUI)localObject1, bool1);
        MallIndexUI.b(this.oAt, MallIndexUI.e(this.oAt).cMl);
        MallIndexUI.a(this.oAt, MallIndexUI.e(this.oAt).cMm);
        if (MallIndexUI.g(this.oAt) != null)
        {
          if (!MallIndexUI.h(this.oAt)) {
            break label841;
          }
          MallIndexUI.g(this.oAt).setVisibility(0);
        }
      }
      for (;;)
      {
        localObject1 = this.oAt;
        localObject2 = new ak();
        ((MallIndexUI)localObject1).oAh.a(new MallIndexUI.4((MallIndexUI)localObject1), ((ak)localObject2).cUj());
        if ((paramVarArgs.cLK.cMo) && (this.ftW)) {
          this.oAt.bJ();
        }
        this.ftW = true;
        AppMethodBeat.o(142111);
        return;
        i = 0;
        break;
        ab.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
        break label563;
        bool1 = false;
        break label674;
        MallIndexUI.g(this.oAt).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.3
 * JD-Core Version:    0.7.0.1
 */