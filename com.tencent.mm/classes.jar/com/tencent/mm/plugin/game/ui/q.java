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
  private com.tencent.mm.plugin.game.model.c IDb;
  String IUa;
  int lCR;
  protected Context mContext;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.IUa = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      Log.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    this.IDb = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    Log.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.IDb.field_appId);
    if (h.y(this.mContext, this.IDb.field_appId))
    {
      Log.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.IDb.field_appId + ", pkg = " + this.IDb.field_packageName + ", openId = " + this.IDb.field_openId);
      e.au(this.mContext, this.IDb.field_appId);
      g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 3, this.IDb.field_appId, this.lCR, this.IDb.hAR, this.IDb.ICw);
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    Log.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.IUa });
    if (!Util.isNullOrNil(this.IUa))
    {
      com.tencent.mm.plugin.game.d.c.ba(this.mContext, this.IUa);
      g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 11, this.IDb.field_appId, this.lCR, this.IDb.hAR, this.IDb.ICw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */