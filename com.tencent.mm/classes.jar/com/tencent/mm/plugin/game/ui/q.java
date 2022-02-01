package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  implements View.OnClickListener
{
  int fPp;
  protected Context mContext;
  private com.tencent.mm.plugin.game.model.c ubv;
  String usi;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.usi = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ad.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    this.ubv = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ad.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.ubv.field_appId);
    if (h.s(this.mContext, this.ubv.field_appId))
    {
      ad.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.ubv.field_appId + ", pkg = " + this.ubv.field_packageName + ", openId = " + this.ubv.field_openId);
      e.ai(this.mContext, this.ubv.field_appId);
      f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 3, this.ubv.field_appId, this.fPp, this.ubv.dls, this.ubv.uaR);
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    ad.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.usi });
    if (!bt.isNullOrNil(this.usi))
    {
      com.tencent.mm.plugin.game.f.c.aB(this.mContext, this.usi);
      f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 11, this.ubv.field_appId, this.fPp, this.ubv.dls, this.ubv.uaR);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
      ad.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */