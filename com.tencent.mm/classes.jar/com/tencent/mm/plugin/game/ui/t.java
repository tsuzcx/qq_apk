package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.plugin.game.protobuf.ec;
import com.tencent.mm.plugin.game.protobuf.q;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public final class t
  implements View.OnClickListener, com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.game.model.c IDb = null;
  int IFc;
  DialogInterface.OnClickListener IVh = null;
  private Context mContext;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42412);
      return;
    }
    this.IDb = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.IDb.field_appId);
    com.tencent.mm.kernel.h.aZW().a(1219, this);
    paramView = LocaleUtil.getApplicationLanguage();
    paramView = new au(this.IDb.field_appId, paramView, this.IDb.hAR, this.IDb.ICr);
    com.tencent.mm.kernel.h.aZW().a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp.getType() == 1219))
    {
      com.tencent.mm.kernel.h.aZW().b(1219, this);
      paramp = new ag(c.c.b(((au)paramp).mtC.otC));
      paramString = new b();
      paramString.IVl = Boolean.valueOf(paramp.IFH.IGZ);
      paramString.title = paramp.IFH.hAP;
      paramString.content = paramp.IFH.IHO;
      if (paramp.IFH.ILP != null)
      {
        paramString.IVm = new a();
        paramString.IVm.message = paramp.IFH.ILP.IHO;
        paramString.IVm.IVj = paramp.IFH.ILP.IHP;
        paramString.IVm.IVk = paramp.IFH.ILP.IHQ;
        paramString.IVm.url = paramp.IFH.ILP.Url;
      }
      this.IDb.piu = paramString.IVl.booleanValue();
      if (Util.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.IVm != null)
      {
        paramp = paramString.IVm.url;
        e.a locala = new e.a(this.mContext);
        locala.bDv(paramString.title);
        locala.bDw(paramString.IVm.message);
        locala.NC(false);
        locala.bDC(paramString.IVm.IVj).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.d.c.ba(t.a(t.this), paramp);
            g.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).hYi, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).hAR, t.b(t.this).ICw);
            AppMethodBeat.o(42411);
          }
        });
        locala.bDD(paramString.IVm.IVk).d(this.IVh);
        locala.jHH().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (Util.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramp = new e.a(this.mContext);
      paramp.bDv(paramString.title);
      paramp.bDw(paramString.content);
      paramp.NC(false);
      paramp.aER(h.i.IbZ).c(this.IVh);
      paramp.jHH().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new e.a(this.mContext);
    paramString.aEO(h.i.Ica);
    paramString.aER(h.i.IbZ);
    paramString.jHH().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String IVj;
    public String IVk;
    public String message;
    public String url;
  }
  
  public static final class b
  {
    public Boolean IVl;
    public t.a IVm;
    public String content;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */