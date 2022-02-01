package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.plugin.game.protobuf.dy;
import com.tencent.mm.plugin.game.protobuf.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, i
{
  private com.tencent.mm.plugin.game.model.c CIQ = null;
  int CKU;
  DialogInterface.OnClickListener DaT = null;
  private Context mContext;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42412);
      return;
    }
    this.CIQ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.CIQ.field_appId);
    h.aGY().a(1219, this);
    paramView = LocaleUtil.getApplicationLanguage();
    paramView = new au(this.CIQ.field_appId, paramView, this.CIQ.fwt, this.CIQ.CIh);
    h.aGY().a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq.getType() == 1219))
    {
      h.aGY().b(1219, this);
      paramq = new ag(d.c.b(((au)paramq).jTk.lBS));
      paramString = new b();
      paramString.DaX = Boolean.valueOf(paramq.CLA.CMU);
      paramString.title = paramq.CLA.fwr;
      paramString.content = paramq.CLA.CNG;
      if (paramq.CLA.CRz != null)
      {
        paramString.DaY = new a();
        paramString.DaY.message = paramq.CLA.CRz.CNG;
        paramString.DaY.DaV = paramq.CLA.CRz.CNH;
        paramString.DaY.DaW = paramq.CLA.CRz.CNI;
        paramString.DaY.url = paramq.CLA.CRz.Url;
      }
      this.CIQ.moD = paramString.DaX.booleanValue();
      if (Util.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.DaY != null)
      {
        paramq = paramString.DaY.url;
        d.a locala = new d.a(this.mContext);
        locala.bBc(paramString.title);
        locala.bBd(paramString.DaY.message);
        locala.HG(false);
        locala.bBj(paramString.DaY.DaV).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.d.c.aY(t.a(t.this), paramq);
            g.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).fSl, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).fwt, t.b(t.this).CIm);
            AppMethodBeat.o(42411);
          }
        });
        locala.bBk(paramString.DaY.DaW).d(this.DaT);
        locala.icu().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (Util.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramq = new d.a(this.mContext);
      paramq.bBc(paramString.title);
      paramq.bBd(paramString.content);
      paramq.HG(false);
      paramq.ayj(g.i.CpR).c(this.DaT);
      paramq.icu().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.ayg(g.i.CpS);
    paramString.ayj(g.i.CpR);
    paramString.icu().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String DaV;
    public String DaW;
    public String message;
    public String url;
  }
  
  public static final class b
  {
    public Boolean DaX;
    public t.a DaY;
    public String content;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */