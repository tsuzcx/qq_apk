package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.game.model.c CIQ;
  String CZK;
  int jaR;
  protected Context mContext;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.CZK = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    this.CIQ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.CIQ.field_appId);
    if (h.u(this.mContext, this.CIQ.field_appId))
    {
      Log.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.CIQ.field_appId + ", pkg = " + this.CIQ.field_packageName + ", openId = " + this.CIQ.field_openId);
      e.at(this.mContext, this.CIQ.field_appId);
      g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 3, this.CIQ.field_appId, this.jaR, this.CIQ.fwt, this.CIQ.CIm);
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    Log.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.CZK });
    if (!Util.isNullOrNil(this.CZK))
    {
      com.tencent.mm.plugin.game.d.c.aY(this.mContext, this.CZK);
      g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 11, this.CIQ.field_appId, this.jaR, this.CIQ.fwt, this.CIQ.CIm);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
      Log.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */