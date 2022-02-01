package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.aw.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  int rXI = 0;
  private c rXP;
  String sev = null;
  private int snh;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    if (!(paramView.getTag() instanceof c))
    {
      ad.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      AppMethodBeat.o(42414);
      return;
    }
    this.rXP = ((c)paramView.getTag());
    ad.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.rXP.field_appId);
    if (h.t(this.mContext, this.rXP.field_appId))
    {
      ad.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.rXP.field_appId + ", pkg = " + this.rXP.field_packageName + ", openId = " + this.rXP.field_openId);
      com.tencent.mm.game.report.e.a(this.mContext, this.rXP.scene, this.rXP.dvS, this.rXP.position, 3, this.rXP.field_appId, this.rXI, this.sev);
      com.tencent.mm.plugin.game.model.e.ai(this.mContext, this.rXP.field_appId);
      AppMethodBeat.o(42414);
      return;
    }
    aw.cDQ();
    paramView = this.rXP.eor;
    int i;
    if (bt.isNullOrNil(paramView))
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.snh = i;
      String str = this.rXP.eor;
      paramView = str;
      if (!bt.isNullOrNil(str)) {
        paramView = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.rXP.status != 3) {
        break label389;
      }
      aw.cDQ();
      aw.startToAuthorized(this.mContext, paramView);
      label286:
      i = 5;
      if (this.rXP.status == 3) {
        i = 10;
      }
      if (this.snh != 4) {
        break label404;
      }
      i = 8;
    }
    label389:
    label404:
    for (;;)
    {
      com.tencent.mm.game.report.e.a(this.mContext, this.rXP.scene, this.rXP.dvS, this.rXP.position, i, this.rXP.field_appId, this.rXI, this.rXP.dcC, this.sev);
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).acE(paramView));
      break;
      aw.cDQ();
      aw.aw(this.mContext, paramView);
      break label286;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */