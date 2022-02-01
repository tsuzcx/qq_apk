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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class u
  implements View.OnClickListener
{
  private Context mContext;
  private int uES;
  private c uoF;
  int uoy = 0;
  String uwk = null;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (!(paramView.getTag() instanceof c))
    {
      ae.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    this.uoF = ((c)paramView.getTag());
    ae.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.uoF.field_appId);
    if (h.s(this.mContext, this.uoF.field_appId))
    {
      ae.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.uoF.field_appId + ", pkg = " + this.uoF.field_packageName + ", openId = " + this.uoF.field_openId);
      f.a(this.mContext, this.uoF.scene, this.uoF.dGL, this.uoF.position, 3, this.uoF.field_appId, this.uoy, this.uwk);
      e.ak(this.mContext, this.uoF.field_appId);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    aw.dcr();
    paramView = this.uoF.eJn;
    int i;
    if (bu.isNullOrNil(paramView))
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.uES = i;
      localObject = this.uoF.eJn;
      paramView = (View)localObject;
      if (!bu.isNullOrNil((String)localObject)) {
        paramView = ((String)localObject).replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.uoF.status != 3) {
        break label454;
      }
      aw.dcr();
      aw.startToAuthorized(this.mContext, paramView);
      label339:
      i = 5;
      if (this.uoF.status == 3) {
        i = 10;
      }
      if (this.uES != 4) {
        break label469;
      }
      i = 8;
    }
    label454:
    label469:
    for (;;)
    {
      f.a(this.mContext, this.uoF.scene, this.uoF.dGL, this.uoF.position, i, this.uoF.field_appId, this.uoy, this.uoF.dmu, this.uwk);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).amY(paramView));
      break;
      aw.dcr();
      aw.aC(this.mContext, paramView);
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */