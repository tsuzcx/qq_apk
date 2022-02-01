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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  int tfA = 0;
  private c tfH;
  String tmo = null;
  private int tva;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    if (!(paramView.getTag() instanceof c))
    {
      ac.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      AppMethodBeat.o(42414);
      return;
    }
    this.tfH = ((c)paramView.getTag());
    ac.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.tfH.field_appId);
    if (h.t(this.mContext, this.tfH.field_appId))
    {
      ac.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.tfH.field_appId + ", pkg = " + this.tfH.field_packageName + ", openId = " + this.tfH.field_openId);
      com.tencent.mm.game.report.e.a(this.mContext, this.tfH.scene, this.tfH.dtF, this.tfH.position, 3, this.tfH.field_appId, this.tfA, this.tmo);
      com.tencent.mm.plugin.game.model.e.aj(this.mContext, this.tfH.field_appId);
      AppMethodBeat.o(42414);
      return;
    }
    aw.cRa();
    paramView = this.tfH.eqv;
    int i;
    if (bs.isNullOrNil(paramView))
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.tva = i;
      String str = this.tfH.eqv;
      paramView = str;
      if (!bs.isNullOrNil(str)) {
        paramView = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.tfH.status != 3) {
        break label389;
      }
      aw.cRa();
      aw.startToAuthorized(this.mContext, paramView);
      label286:
      i = 5;
      if (this.tfH.status == 3) {
        i = 10;
      }
      if (this.tva != 4) {
        break label404;
      }
      i = 8;
    }
    label389:
    label404:
    for (;;)
    {
      com.tencent.mm.game.report.e.a(this.mContext, this.tfH.scene, this.tfH.dtF, this.tfH.position, i, this.tfH.field_appId, this.tfA, this.tfH.daa, this.tmo);
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).ahw(paramView));
      break;
      aw.cRa();
      aw.ax(this.mContext, paramView);
      break label286;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */