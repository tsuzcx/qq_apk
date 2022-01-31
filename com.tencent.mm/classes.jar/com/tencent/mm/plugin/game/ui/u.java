package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.ax.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  private int nDI;
  int nok = 0;
  private com.tencent.mm.plugin.game.model.c nou;
  String nuQ = null;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112216);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ab.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      AppMethodBeat.o(112216);
      return;
    }
    this.nou = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ab.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.nou.field_appId);
    if (g.u(this.mContext, this.nou.field_appId))
    {
      ab.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.nou.field_appId + ", pkg = " + this.nou.field_packageName + ", openId = " + this.nou.field_openId);
      com.tencent.mm.game.report.c.a(this.mContext, this.nou.scene, this.nou.cFj, this.nou.position, 3, this.nou.field_appId, this.nok, this.nuQ);
      e.aj(this.mContext, this.nou.field_appId);
      AppMethodBeat.o(112216);
      return;
    }
    ax.bGV();
    paramView = this.nou.djU;
    int i;
    if (bo.isNullOrNil(paramView))
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.nDI = i;
      String str = this.nou.djU;
      paramView = str;
      if (!bo.isNullOrNil(str)) {
        paramView = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.nou.status != 3) {
        break label389;
      }
      ax.bGV();
      ax.startToAuthorized(this.mContext, paramView);
      label286:
      i = 5;
      if (this.nou.status == 3) {
        i = 10;
      }
      if (this.nDI != 4) {
        break label404;
      }
      i = 8;
    }
    label389:
    label404:
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.mContext, this.nou.scene, this.nou.cFj, this.nou.position, i, this.nou.field_appId, this.nok, this.nou.cnG, this.nuQ);
      AppMethodBeat.o(112216);
      return;
      i = ax.a(new ax.a((byte)0).Qf(paramView));
      break;
      ax.bGV();
      ax.aw(this.mContext, paramView);
      break label286;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */