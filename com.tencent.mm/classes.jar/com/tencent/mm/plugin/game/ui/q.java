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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements View.OnClickListener
{
  int gwE;
  protected Context mContext;
  private com.tencent.mm.plugin.game.model.c xEP;
  String xVz;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.xVz = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    this.xEP = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.xEP.field_appId);
    if (h.s(this.mContext, this.xEP.field_appId))
    {
      Log.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.xEP.field_appId + ", pkg = " + this.xEP.field_packageName + ", openId = " + this.xEP.field_openId);
      e.at(this.mContext, this.xEP.field_appId);
      f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 3, this.xEP.field_appId, this.gwE, this.xEP.dDJ, this.xEP.xEl);
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    Log.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.xVz });
    if (!Util.isNullOrNil(this.xVz))
    {
      com.tencent.mm.plugin.game.e.c.aQ(this.mContext, this.xVz);
      f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 11, this.xEP.field_appId, this.gwE, this.xEP.dDJ, this.xEP.xEl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */