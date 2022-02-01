package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.dx;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, com.tencent.mm.ak.f
{
  private Context mContext;
  DialogInterface.OnClickListener uEM = null;
  private com.tencent.mm.plugin.game.model.c umx = null;
  int uoy;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ae.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42412);
      return;
    }
    this.umx = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ae.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.umx.field_appId);
    g.ajj().a(1219, this);
    paramView = ad.fom();
    paramView = new au(this.umx.field_appId, paramView, this.umx.dmu, this.umx.ulO);
    g.ajj().a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.getType() == 1219))
    {
      g.ajj().b(1219, this);
      paramn = new ag(((au)paramn).gux.hQE.hQJ);
      paramString = new b();
      paramString.uEQ = Boolean.valueOf(paramn.upe.uqw);
      paramString.title = paramn.upe.Title;
      paramString.content = paramn.upe.urg;
      if (paramn.upe.uvo != null)
      {
        paramString.uER = new a();
        paramString.uER.message = paramn.upe.uvo.urg;
        paramString.uER.uEO = paramn.upe.uvo.urh;
        paramString.uER.uEP = paramn.upe.uvo.urj;
        paramString.uER.url = paramn.upe.uvo.Url;
      }
      this.umx.iEF = paramString.uEQ.booleanValue();
      if (bu.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.uER != null)
      {
        paramn = paramString.uER.url;
        d.a locala = new d.a(this.mContext);
        locala.aZh(paramString.title);
        locala.aZi(paramString.uER.message);
        locala.zf(false);
        locala.aZo(paramString.uER.uEO).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.f.c.aD(t.a(t.this), paramn);
            com.tencent.mm.game.report.f.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).dGL, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).dmu, t.b(t.this).ulT);
            AppMethodBeat.o(42411);
          }
        });
        locala.aZp(paramString.uER.uEP).d(this.uEM);
        locala.fQv().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (bu.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramn = new d.a(this.mContext);
      paramn.aZh(paramString.title);
      paramn.aZi(paramString.content);
      paramn.zf(false);
      paramn.afU(2131759989).c(this.uEM);
      paramn.fQv().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.afR(2131759990);
    paramString.afU(2131759989);
    paramString.fQv().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String message;
    public String uEO;
    public String uEP;
    public String url;
  }
  
  public static final class b
  {
    public String content;
    public String title;
    public Boolean uEQ;
    public t.a uER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */