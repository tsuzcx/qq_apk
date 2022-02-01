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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  int xGR = 0;
  private c xGY;
  String xOl = null;
  private int xWP;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (!(paramView.getTag() instanceof c))
    {
      Log.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    this.xGY = ((c)paramView.getTag());
    Log.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.xGY.field_appId);
    if (h.s(this.mContext, this.xGY.field_appId))
    {
      Log.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.xGY.field_appId + ", pkg = " + this.xGY.field_packageName + ", openId = " + this.xGY.field_openId);
      f.a(this.mContext, this.xGY.scene, this.xGY.dYu, this.xGY.position, 3, this.xGY.field_appId, this.xGR, this.xOl);
      e.at(this.mContext, this.xGY.field_appId);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    aw.dVY();
    paramView = this.xGY.fmP;
    int i;
    if (Util.isNullOrNil(paramView))
    {
      Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.xWP = i;
      localObject = this.xGY.fmP;
      paramView = (View)localObject;
      if (!Util.isNullOrNil((String)localObject)) {
        paramView = ((String)localObject).replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.xGY.status != 3) {
        break label454;
      }
      aw.dVY();
      aw.startToAuthorized(this.mContext, paramView);
      label339:
      i = 5;
      if (this.xGY.status == 3) {
        i = 10;
      }
      if (this.xWP != 4) {
        break label469;
      }
      i = 8;
    }
    label454:
    label469:
    for (;;)
    {
      f.a(this.mContext, this.xGY.scene, this.xGY.dYu, this.xGY.position, i, this.xGY.field_appId, this.xGR, this.xGY.dDJ, this.xOl);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).aAp(paramView));
      break;
      aw.dVY();
      aw.aP(this.mContext, paramView);
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */