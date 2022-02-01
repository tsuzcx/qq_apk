package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.plugin.game.protobuf.dx;
import com.tencent.mm.plugin.game.protobuf.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, i
{
  private Context mContext;
  private com.tencent.mm.plugin.game.model.c xEP = null;
  int xGR;
  DialogInterface.OnClickListener xWJ = null;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42412);
      return;
    }
    this.xEP = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.xEP.field_appId);
    g.azz().a(1219, this);
    paramView = LocaleUtil.getApplicationLanguage();
    paramView = new au(this.xEP.field_appId, paramView, this.xEP.dDJ, this.xEP.xEg);
    g.azz().a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq.getType() == 1219))
    {
      g.azz().b(1219, this);
      paramq = new ag(((au)paramq).hhm.iLL.iLR);
      paramString = new b();
      paramString.xWN = Boolean.valueOf(paramq.xHx.xIO);
      paramString.title = paramq.xHx.Title;
      paramString.content = paramq.xHx.xJz;
      if (paramq.xHx.xNp != null)
      {
        paramString.xWO = new a();
        paramString.xWO.message = paramq.xHx.xNp.xJz;
        paramString.xWO.xWL = paramq.xHx.xNp.xJA;
        paramString.xWO.xWM = paramq.xHx.xNp.xJB;
        paramString.xWO.url = paramq.xHx.xNp.Url;
      }
      this.xEP.jyX = paramString.xWN.booleanValue();
      if (Util.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.xWO != null)
      {
        paramq = paramString.xWO.url;
        d.a locala = new d.a(this.mContext);
        locala.bon(paramString.title);
        locala.boo(paramString.xWO.message);
        locala.Dk(false);
        locala.bou(paramString.xWO.xWL).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.e.c.aQ(t.a(t.this), paramq);
            f.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).dYu, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).dDJ, t.b(t.this).xEl);
            AppMethodBeat.o(42411);
          }
        });
        locala.bov(paramString.xWO.xWM).d(this.xWJ);
        locala.hbn().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (Util.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramq = new d.a(this.mContext);
      paramq.bon(paramString.title);
      paramq.boo(paramString.content);
      paramq.Dk(false);
      paramq.aoV(2131761353).c(this.xWJ);
      paramq.hbn().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.aoS(2131761354);
    paramString.aoV(2131761353);
    paramString.hbn().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String message;
    public String url;
    public String xWL;
    public String xWM;
  }
  
  public static final class b
  {
    public String content;
    public String title;
    public Boolean xWN;
    public t.a xWO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */