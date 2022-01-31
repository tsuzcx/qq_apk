package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
  implements View.OnClickListener
{
  int ejF;
  protected Context mContext;
  String nCq;
  private com.tencent.mm.plugin.game.model.c nmJ;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.nCq = null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112143);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ab.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      AppMethodBeat.o(112143);
      return;
    }
    this.nmJ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ab.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.nmJ.field_appId);
    if (g.u(this.mContext, this.nmJ.field_appId))
    {
      ab.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.nmJ.field_appId + ", pkg = " + this.nmJ.field_packageName + ", openId = " + this.nmJ.field_openId);
      e.aj(this.mContext, this.nmJ.field_appId);
      com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 3, this.nmJ.field_appId, this.ejF, this.nmJ.cnG, this.nmJ.nml);
      AppMethodBeat.o(112143);
      return;
    }
    ab.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.nCq });
    if (!bo.isNullOrNil(this.nCq))
    {
      com.tencent.mm.plugin.game.f.c.ax(this.mContext, this.nCq);
      com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 11, this.nmJ.field_appId, this.ejF, this.nmJ.cnG, this.nmJ.nml);
      AppMethodBeat.o(112143);
      return;
    }
    ab.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
    AppMethodBeat.o(112143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */