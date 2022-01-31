package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.d.k;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class t
  implements View.OnClickListener, f
{
  private d kOM = null;
  int kQh;
  DialogInterface.OnClickListener lfH = null;
  private Context mContext;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof d))
    {
      y.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      return;
    }
    this.kOM = ((d)paramView.getTag());
    y.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.kOM.field_appId);
    g.Dk().a(1219, this);
    paramView = x.cqJ();
    paramView = new aw(this.kOM.field_appId, paramView, this.kOM.bGy, this.kOM.kOj);
    g.Dk().a(paramView, 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm.getType() == 1219))
    {
      g.Dk().b(1219, this);
      paramm = new ah(((aw)paramm).jvQ.ecF.ecN);
      paramString = new t.b();
      paramString.lfL = Boolean.valueOf(paramm.kQP.kSf);
      paramString.title = paramm.kQP.bGw;
      paramString.content = paramm.kQP.kSz;
      if (paramm.kQP.kWk != null)
      {
        paramString.lfM = new t.a();
        paramString.lfM.message = paramm.kQP.kWk.kSz;
        paramString.lfM.lfJ = paramm.kQP.kWk.kSA;
        paramString.lfM.lfK = paramm.kQP.kWk.kSB;
        paramString.lfM.url = paramm.kQP.kWk.kSC;
      }
      this.kOM.kOb = paramString.lfL.booleanValue();
      if (bk.bl(paramString.title)) {}
      do
      {
        return;
        if (paramString.lfM != null)
        {
          paramm = paramString.lfM.url;
          c.a locala = new c.a(this.mContext);
          locala.aez(paramString.title);
          locala.aeA(paramString.lfM.message);
          locala.nW(false);
          locala.aeD(paramString.lfM.lfJ).a(true, new t.1(this, paramm));
          locala.aeE(paramString.lfM.lfK).b(this.lfH);
          locala.aoP().show();
          return;
        }
      } while (bk.bl(paramString.content));
      paramm = new c.a(this.mContext);
      paramm.aez(paramString.title);
      paramm.aeA(paramString.content);
      paramm.nW(false);
      paramm.Is(g.i.game_subscription_dialog_positive).a(this.lfH);
      paramm.aoP().show();
      return;
    }
    paramString = new c.a(this.mContext);
    paramString.Iq(g.i.game_subsription_failed);
    paramString.Is(g.i.game_subscription_dialog_positive);
    paramString.aoP().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */