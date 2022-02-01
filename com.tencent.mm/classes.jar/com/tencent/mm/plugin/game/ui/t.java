package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, com.tencent.mm.al.f
{
  private Context mContext;
  private com.tencent.mm.plugin.game.model.c ubv = null;
  int udq;
  DialogInterface.OnClickListener utt = null;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ad.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42412);
      return;
    }
    this.ubv = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ad.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.ubv.field_appId);
    g.aiU().a(1219, this);
    paramView = ac.fks();
    paramView = new au(this.ubv.field_appId, paramView, this.ubv.dls, this.ubv.uaM);
    g.aiU().a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.getType() == 1219))
    {
      g.aiU().b(1219, this);
      paramn = new ag(((au)paramn).grW.hNL.hNQ);
      paramString = new b();
      paramString.utx = Boolean.valueOf(paramn.udW.ufm);
      paramString.title = paramn.udW.Title;
      paramString.content = paramn.udW.ufM;
      if (paramn.udW.ujQ != null)
      {
        paramString.uty = new a();
        paramString.uty.message = paramn.udW.ujQ.ufM;
        paramString.uty.utv = paramn.udW.ujQ.ufN;
        paramString.uty.utw = paramn.udW.ujQ.ufO;
        paramString.uty.url = paramn.udW.ujQ.Url;
      }
      this.ubv.iBM = paramString.utx.booleanValue();
      if (bt.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.uty != null)
      {
        paramn = paramString.uty.url;
        d.a locala = new d.a(this.mContext);
        locala.aXF(paramString.title);
        locala.aXG(paramString.uty.message);
        locala.yR(false);
        locala.aXM(paramString.uty.utv).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.f.c.aB(t.a(t.this), paramn);
            com.tencent.mm.game.report.f.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).dFG, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).dls, t.b(t.this).uaR);
            AppMethodBeat.o(42411);
          }
        });
        locala.aXN(paramString.uty.utw).d(this.utt);
        locala.fMb().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (bt.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramn = new d.a(this.mContext);
      paramn.aXF(paramString.title);
      paramn.aXG(paramString.content);
      paramn.yR(false);
      paramn.afl(2131759989).c(this.utt);
      paramn.fMb().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.afi(2131759990);
    paramString.afl(2131759989);
    paramString.fMb().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String message;
    public String url;
    public String utv;
    public String utw;
  }
  
  public static final class b
  {
    public String content;
    public String title;
    public Boolean utx;
    public t.a uty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */