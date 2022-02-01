package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  implements View.OnClickListener
{
  int fsv;
  protected Context mContext;
  private com.tencent.mm.plugin.game.model.c rVN;
  String slQ;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.slQ = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ad.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      AppMethodBeat.o(42340);
      return;
    }
    this.rVN = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ad.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.rVN.field_appId);
    if (h.t(this.mContext, this.rVN.field_appId))
    {
      ad.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.rVN.field_appId + ", pkg = " + this.rVN.field_packageName + ", openId = " + this.rVN.field_openId);
      com.tencent.mm.plugin.game.model.e.ai(this.mContext, this.rVN.field_appId);
      com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 3, this.rVN.field_appId, this.fsv, this.rVN.dcC, this.rVN.rVj);
      AppMethodBeat.o(42340);
      return;
    }
    ad.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.slQ });
    if (!bt.isNullOrNil(this.slQ))
    {
      com.tencent.mm.plugin.game.f.c.ax(this.mContext, this.slQ);
      com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 11, this.rVN.field_appId, this.fsv, this.rVN.dcC, this.rVN.rVj);
      AppMethodBeat.o(42340);
      return;
    }
    ad.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    AppMethodBeat.o(42340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */