package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.aw.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  int udq = 0;
  private c udx;
  String ukN = null;
  private int utz;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if (!(paramView.getTag() instanceof c))
    {
      ad.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    this.udx = ((c)paramView.getTag());
    ad.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.udx.field_appId);
    if (h.s(this.mContext, this.udx.field_appId))
    {
      ad.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.udx.field_appId + ", pkg = " + this.udx.field_packageName + ", openId = " + this.udx.field_openId);
      f.a(this.mContext, this.udx.scene, this.udx.dFG, this.udx.position, 3, this.udx.field_appId, this.udq, this.ukN);
      e.ai(this.mContext, this.udx.field_appId);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    aw.cZG();
    paramView = this.udx.eHE;
    int i;
    if (bt.isNullOrNil(paramView))
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.utz = i;
      localObject = this.udx.eHE;
      paramView = (View)localObject;
      if (!bt.isNullOrNil((String)localObject)) {
        paramView = ((String)localObject).replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.udx.status != 3) {
        break label454;
      }
      aw.cZG();
      aw.startToAuthorized(this.mContext, paramView);
      label339:
      i = 5;
      if (this.udx.status == 3) {
        i = 10;
      }
      if (this.utz != 4) {
        break label469;
      }
      i = 8;
    }
    label454:
    label469:
    for (;;)
    {
      f.a(this.mContext, this.udx.scene, this.udx.dFG, this.udx.position, i, this.udx.field_appId, this.udq, this.udx.dls, this.ukN);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).alY(paramView));
      break;
      aw.cZG();
      aw.aA(this.mContext, paramView);
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */