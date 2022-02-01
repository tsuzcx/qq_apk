package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
  implements View.OnClickListener
{
  int fwc;
  protected Context mContext;
  private com.tencent.mm.plugin.game.model.c tdF;
  String ttJ;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.ttJ = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42340);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ac.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      AppMethodBeat.o(42340);
      return;
    }
    this.tdF = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ac.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.tdF.field_appId);
    if (h.t(this.mContext, this.tdF.field_appId))
    {
      ac.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.tdF.field_appId + ", pkg = " + this.tdF.field_packageName + ", openId = " + this.tdF.field_openId);
      com.tencent.mm.plugin.game.model.e.aj(this.mContext, this.tdF.field_appId);
      com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 3, this.tdF.field_appId, this.fwc, this.tdF.daa, this.tdF.tdb);
      AppMethodBeat.o(42340);
      return;
    }
    ac.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.ttJ });
    if (!bs.isNullOrNil(this.ttJ))
    {
      com.tencent.mm.plugin.game.f.c.ay(this.mContext, this.ttJ);
      com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 11, this.tdF.field_appId, this.fwc, this.tdF.daa, this.tdF.tdb);
      AppMethodBeat.o(42340);
      return;
    }
    ac.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    AppMethodBeat.o(42340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */