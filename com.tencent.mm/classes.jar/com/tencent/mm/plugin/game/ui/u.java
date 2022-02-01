package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.game.report.g;
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
  int IFc = 0;
  private c IFj;
  String IML = null;
  private int IVn;
  private Context mContext;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (!(paramView.getTag() instanceof c))
    {
      Log.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    this.IFj = ((c)paramView.getTag());
    Log.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.IFj.field_appId);
    if (h.y(this.mContext, this.IFj.field_appId))
    {
      Log.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.IFj.field_appId + ", pkg = " + this.IFj.field_packageName + ", openId = " + this.IFj.field_openId);
      g.a(this.mContext, this.IFj.scene, this.IFj.hYi, this.IFj.position, 3, this.IFj.field_appId, this.IFc, this.IML);
      e.au(this.mContext, this.IFj.field_appId);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    aw.fHc();
    paramView = this.IFj.jOB;
    int i;
    if (Util.isNullOrNil(paramView))
    {
      Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.IVn = i;
      localObject = this.IFj.jOB;
      paramView = (View)localObject;
      if (!Util.isNullOrNil((String)localObject)) {
        paramView = ((String)localObject).replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.IFj.status != 3) {
        break label454;
      }
      aw.fHc();
      aw.startToAuthorized(this.mContext, paramView);
      label339:
      i = 5;
      if (this.IFj.status == 3) {
        i = 10;
      }
      if (this.IVn != 4) {
        break label469;
      }
      i = 8;
    }
    label454:
    label469:
    for (;;)
    {
      g.a(this.mContext, this.IFj.scene, this.IFj.hYi, this.IFj.position, i, this.IFj.field_appId, this.IFc, this.IFj.hAR, this.IML);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
      i = aw.a(new aw.a((byte)0).aGR(paramView));
      break;
      aw.fHc();
      aw.aZ(this.mContext, paramView);
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */