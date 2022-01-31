package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.ay.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  implements View.OnClickListener
{
  int kQh = 0;
  private d kQq;
  String kWO = null;
  private int lfN;
  private Context mContext;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof d))
    {
      y.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      return;
    }
    this.kQq = ((d)paramView.getTag());
    y.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.kQq.field_appId);
    if (g.o(this.mContext, this.kQq.field_appId))
    {
      y.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.kQq.field_appId + ", pkg = " + this.kQq.field_packageName + ", openId = " + this.kQq.field_openId);
      b.a(this.mContext, this.kQq.scene, this.kQq.bXn, this.kQq.position, 3, this.kQq.field_appId, this.kQh, this.kWO);
      f.ai(this.mContext, this.kQq.field_appId);
      return;
    }
    ay.aZP();
    paramView = this.kQq.cvJ;
    int i;
    if (bk.bl(paramView))
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.lfN = i;
      String str = this.kQq.cvJ;
      paramView = str;
      if (!bk.bl(str)) {
        paramView = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.kQq.status != 3) {
        break label369;
      }
      ay.aZP();
      ay.startToAuthorized(this.mContext, paramView);
      label271:
      i = 5;
      if (this.kQq.status == 3) {
        i = 10;
      }
      if (this.lfN != 4) {
        break label384;
      }
      i = 8;
    }
    label384:
    for (;;)
    {
      b.a(this.mContext, this.kQq.scene, this.kQq.bXn, this.kQq.position, i, this.kQq.field_appId, this.kQh, this.kQq.bGy, this.kWO);
      return;
      i = ay.a(new ay.a((byte)0).EN(paramView));
      break;
      label369:
      ay.aZP();
      ay.am(this.mContext, paramView);
      break label271;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */