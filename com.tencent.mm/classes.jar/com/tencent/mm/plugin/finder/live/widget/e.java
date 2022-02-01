package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.g;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "initView", "isVisible", "", "jumpToCreateLotteryImpl", "jumpToCreateLotttery", "lotteryEntranceLogic", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "setVisible", "visible", "showCard", "Companion", "plugin-finder_release"})
public final class e
{
  public static final String zlA = "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY";
  public static final a zlB;
  public final String TAG;
  public final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  
  static
  {
    AppMethodBeat.i(278241);
    zlB = new a((byte)0);
    zlA = "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY";
    AppMethodBeat.o(278241);
  }
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(278240);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchorLotteryEntranceWidget";
    this.kiF.setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(278240);
  }
  
  private final void dHK()
  {
    AppMethodBeat.i(278236);
    an localan = d.getFinderLiveAssistant();
    Object localObject;
    if (localan != null)
    {
      localObject = ((g)this.xYq.business(g.class)).zic;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
        if (localObject != null)
        {
          localObject = ((bal)localObject).id;
          if (localObject != null) {
            break label85;
          }
        }
      }
      localObject = "";
    }
    label85:
    for (;;)
    {
      localan.a((String)localObject, null, (x.a)new c(this));
      AppMethodBeat.o(278236);
      return;
      AppMethodBeat.o(278236);
      return;
    }
  }
  
  private final void dHL()
  {
    AppMethodBeat.i(278237);
    if (this.xYq.isLandscape())
    {
      d.a(this.xYq, zlA);
      AppMethodBeat.o(278237);
      return;
    }
    dHM();
    AppMethodBeat.o(278237);
  }
  
  public final void dHJ()
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(278234);
    if (this.kCL.getLiveRole() == 1)
    {
      localObject = k.yBj;
      k.a(s.f.yES, "");
    }
    Object localObject = ((g)this.xYq.business(g.class)).zic;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).ycO);
      com.tencent.mm.plugin.finder.live.viewmodel.data.l locall = ((g)this.xYq.business(g.class)).zic;
      if (locall != null) {
        localBoolean = Boolean.valueOf(locall.zeS);
      }
      Log.i(this.TAG, "lotteryEntranceLogic lotteryStatus:" + localObject + ",bubbleFinish:" + localBoolean);
      if (p.h(localBoolean, Boolean.FALSE)) {
        if (localObject != null) {
          break label153;
        }
      }
    }
    label153:
    while (((Integer)localObject).intValue() != 1)
    {
      if (localObject != null) {
        break label171;
      }
      dHL();
      AppMethodBeat.o(278234);
      return;
      localObject = null;
      break;
    }
    for (;;)
    {
      dHK();
      AppMethodBeat.o(278234);
      return;
      label171:
      if (((Integer)localObject).intValue() != 2) {
        break;
      }
    }
  }
  
  public final void dHM()
  {
    Object localObject2 = null;
    AppMethodBeat.i(278238);
    String str = ((c)this.xYq.business(c.class)).nonceId;
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("jumpToCreateLotteryImpl root.context is activity:").append(this.kiF.getContext() instanceof Activity).append(",liveId:");
    Object localObject1 = ((c)this.xYq.business(c.class)).liveInfo;
    label182:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((bac)localObject1).liveId);
      Log.i((String)localObject3, ((Long)localObject1).longValue() + ",objectId:" + ((c)this.xYq.business(c.class)).xbk + ",nonceId:" + str);
      if (!(this.kiF.getContext() instanceof Activity)) {
        break label412;
      }
      localObject1 = ((c)this.xYq.business(c.class)).liveInfo;
      if (localObject1 == null) {
        break label295;
      }
      localObject1 = Long.valueOf(((bac)localObject1).liveId);
      if (localObject1 == null) {
        break label412;
      }
      localObject1 = ((c)this.xYq.business(c.class)).liveInfo;
      if (((localObject1 != null) && (((bac)localObject1).liveId == 0L)) || (((c)this.xYq.business(c.class)).xbk == 0L)) {
        break label412;
      }
      localObject1 = (CharSequence)str;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label300;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = this.kiF.getContext();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(278238);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          label295:
          localObject1 = null;
          break label182;
          label300:
          i = 0;
          continue;
        }
        localObject3 = (Activity)localObject1;
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject4 = new Intent();
        bac localbac = ((c)this.xYq.business(c.class)).liveInfo;
        localObject1 = localObject2;
        if (localbac != null) {
          localObject1 = Long.valueOf(localbac.liveId);
        }
        ((Intent)localObject4).putExtra("KEY_PARAMS_LIVE_ID", ((Long)localObject1).longValue());
        ((Intent)localObject4).putExtra("KEY_PARAMS_OBJECT_ID", ((c)this.xYq.business(c.class)).xbk);
        ((Intent)localObject4).putExtra("KEY_PARAMS_NONCE_ID", str);
        com.tencent.mm.plugin.finder.utils.a.d((Activity)localObject3, (Intent)localObject4);
      }
    }
    label412:
    AppMethodBeat.o(278238);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(278239);
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(278239);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$Companion;", "", "()V", "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY", "", "getPORTRAIT_ACTION_GOTO_CREATE_LOTTERY", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(268976);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zlC.dHJ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268976);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$showCard$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class c
    implements x.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(289014);
      p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.zlC.xYq.business(g.class)).a(paramazs.xHW);
        ((g)this.zlC.xYq.business(g.class)).d(paramazs);
      }
      b.b.a(this.zlC.kCL, b.c.kAR);
      paramString = this.zlC.kCL;
      paramazs = b.c.kAP;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
      paramString.statusChange(paramazs, localBundle);
      AppMethodBeat.o(289014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.e
 * JD-Core Version:    0.7.0.1
 */