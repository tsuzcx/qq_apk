package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.ax.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements View.OnClickListener
{
  int CKU = 0;
  private c CLb;
  String CSv = null;
  private int DaZ;
  private Context mContext;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42414);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (!(paramView.getTag() instanceof c))
    {
      Log.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    this.CLb = ((c)paramView.getTag());
    Log.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.CLb.field_appId);
    if (h.u(this.mContext, this.CLb.field_appId))
    {
      Log.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.CLb.field_appId + ", pkg = " + this.CLb.field_packageName + ", openId = " + this.CLb.field_openId);
      g.a(this.mContext, this.CLb.scene, this.CLb.fSl, this.CLb.position, 3, this.CLb.field_appId, this.CKU, this.CSv);
      e.at(this.mContext, this.CLb.field_appId);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
    }
    ax.ezg();
    paramView = this.CLb.hrO;
    int i;
    if (Util.isNullOrNil(paramView))
    {
      Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      i = -1;
      this.DaZ = i;
      localObject = this.CLb.hrO;
      paramView = (View)localObject;
      if (!Util.isNullOrNil((String)localObject)) {
        paramView = ((String)localObject).replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
      }
      if (this.CLb.status != 3) {
        break label454;
      }
      ax.ezg();
      ax.startToAuthorized(this.mContext, paramView);
      label339:
      i = 5;
      if (this.CLb.status == 3) {
        i = 10;
      }
      if (this.DaZ != 4) {
        break label469;
      }
      i = 8;
    }
    label454:
    label469:
    for (;;)
    {
      g.a(this.mContext, this.CLb.scene, this.CLb.fSl, this.CLb.position, i, this.CLb.field_appId, this.CKU, this.CLb.fwt, this.CSv);
      a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42414);
      return;
      i = ax.a(new ax.a((byte)0).aKb(paramView));
      break;
      ax.ezg();
      ax.aX(this.mContext, paramView);
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.u
 * JD-Core Version:    0.7.0.1
 */