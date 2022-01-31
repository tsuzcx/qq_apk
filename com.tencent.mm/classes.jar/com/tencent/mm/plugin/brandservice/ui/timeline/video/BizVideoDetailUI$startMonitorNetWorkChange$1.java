package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$startMonitorNetWorkChange$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-brandservice_release"})
public final class BizVideoDetailUI$startMonitorNetWorkChange$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(152840);
    j.q(paramContext, "context");
    if ((paramIntent == null) || (bo.isNullOrNil(paramIntent.getAction())) || (BizVideoDetailUI.j(this.kgi).kfz == 0))
    {
      AppMethodBeat.o(152840);
      return;
    }
    boolean bool = at.isWifi(paramContext);
    int i = BizVideoDetailUI.v(this.kgi);
    BizVideoDetailUI.b(this.kgi, BizVideoDetailUI.w(this.kgi));
    ab.d(BizVideoDetailUI.u(this.kgi), "net type change simcardTpye=" + BizVideoDetailUI.v(this.kgi) + ", lastSimcardType=" + i + " is wifi=" + bool);
    if (BizVideoDetailUI.c(this.kgi, BizVideoDetailUI.e(this.kgi).getDuration()))
    {
      paramContext = BizVideoDetailUI.h(this.kgi);
      j.p(paramContext, "videoWifiTipsView");
      if (paramContext.getVisibility() != 0)
      {
        BizVideoDetailUI.e(this.kgi).pause();
        BizVideoDetailUI.b(this.kgi, true);
        AppMethodBeat.o(152840);
      }
    }
    else
    {
      paramContext = BizVideoDetailUI.h(this.kgi);
      j.p(paramContext, "videoWifiTipsView");
      if (paramContext.getVisibility() == 0)
      {
        BizVideoDetailUI.t(this.kgi);
        paramContext = BizVideoDetailUI.e(this.kgi);
        paramIntent = paramContext.kjE;
        if (paramIntent != null) {
          paramIntent.baj();
        }
        paramContext = paramContext.kjE;
        if (paramContext != null)
        {
          paramContext.show();
          AppMethodBeat.o(152840);
          return;
        }
      }
    }
    AppMethodBeat.o(152840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.startMonitorNetWorkChange.1
 * JD-Core Version:    0.7.0.1
 */