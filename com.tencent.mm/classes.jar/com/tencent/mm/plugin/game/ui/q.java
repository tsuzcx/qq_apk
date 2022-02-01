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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
  implements View.OnClickListener
{
  int fRv;
  protected Context mContext;
  String uDB;
  private com.tencent.mm.plugin.game.model.c umx;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.uDB = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ae.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    this.umx = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ae.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.umx.field_appId);
    if (h.s(this.mContext, this.umx.field_appId))
    {
      ae.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.umx.field_appId + ", pkg = " + this.umx.field_packageName + ", openId = " + this.umx.field_openId);
      e.ak(this.mContext, this.umx.field_appId);
      f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 3, this.umx.field_appId, this.fRv, this.umx.dmu, this.umx.ulT);
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
    }
    ae.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.uDB });
    if (!bu.isNullOrNil(this.uDB))
    {
      com.tencent.mm.plugin.game.f.c.aD(this.mContext, this.uDB);
      f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 11, this.umx.field_appId, this.fRv, this.umx.dmu, this.umx.ulT);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42340);
      return;
      ae.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */