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
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.f;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "initView", "isVisible", "", "jumpToCreateLotteryImpl", "jumpToCreateLotttery", "lotteryEntranceLogic", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "setVisible", "visible", "showCard", "Companion", "plugin-finder_release"})
public final class a
{
  public static final String uFx = "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY";
  public static final a uFy;
  public final String TAG;
  public final com.tencent.mm.live.c.b hOp;
  public final ViewGroup hwr;
  public final d uFw;
  
  static
  {
    AppMethodBeat.i(248020);
    uFy = new a((byte)0);
    uFx = "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY";
    AppMethodBeat.o(248020);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248019);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveAnchorLotteryEntranceWidget";
    this.hwr.setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(248019);
  }
  
  public final void djt()
  {
    Object localObject2 = null;
    AppMethodBeat.i(248017);
    String str = this.uFw.getLiveData().hwg;
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("jumpToCreateLotteryImpl root.context is activity:").append(this.hwr.getContext() instanceof Activity).append(",liveId:");
    Object localObject1 = this.uFw.getLiveData().liveInfo;
    label160:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      Log.i((String)localObject3, ((Long)localObject1).longValue() + ",objectId:" + this.uFw.getLiveData().hFK + ",nonceId:" + str);
      if (!(this.hwr.getContext() instanceof Activity)) {
        break label370;
      }
      localObject1 = this.uFw.getLiveData().liveInfo;
      if (localObject1 == null) {
        break label263;
      }
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      if (localObject1 == null) {
        break label370;
      }
      localObject1 = this.uFw.getLiveData().liveInfo;
      if (((localObject1 != null) && (((awe)localObject1).liveId == 0L)) || (this.uFw.getLiveData().hFK == 0L)) {
        break label370;
      }
      localObject1 = (CharSequence)str;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label268;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = this.hwr.getContext();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(248017);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          label263:
          localObject1 = null;
          break label160;
          label268:
          i = 0;
          continue;
        }
        localObject3 = (Activity)localObject1;
        localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject4 = new Intent();
        awe localawe = this.uFw.getLiveData().liveInfo;
        localObject1 = localObject2;
        if (localawe != null) {
          localObject1 = Long.valueOf(localawe.liveId);
        }
        ((Intent)localObject4).putExtra("KEY_PARAMS_LIVE_ID", ((Long)localObject1).longValue());
        ((Intent)localObject4).putExtra("KEY_PARAMS_OBJECT_ID", this.uFw.getLiveData().hFK);
        ((Intent)localObject4).putExtra("KEY_PARAMS_NONCE_ID", str);
        com.tencent.mm.plugin.finder.utils.a.d((Activity)localObject3, (Intent)localObject4);
      }
    }
    label370:
    AppMethodBeat.o(248017);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(248018);
    this.hwr.setVisibility(paramInt);
    AppMethodBeat.o(248018);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$Companion;", "", "()V", "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY", "", "getPORTRAIT_ACTION_GOTO_CREATE_LOTTERY", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248015);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.uFz.hOp.getLiveRole() == 1)
      {
        paramView = k.vkd;
        k.a(s.f.vnp, "");
      }
      a.a(this.uFz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248015);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$showCard$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class c
    implements o.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(248016);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uFz.uFw.getLiveData().a(paramavy.tWe);
        this.uFz.uFw.getLiveData().d(paramavy);
      }
      b.b.a(this.uFz.hOp, b.c.hNG);
      paramString = this.uFz.hOp;
      paramavy = b.c.hNE;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
      paramString.statusChange(paramavy, localBundle);
      AppMethodBeat.o(248016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.a
 * JD-Core Version:    0.7.0.1
 */