package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ar;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "moreLiveEntrance", "Landroid/view/View;", "canClearScreen", "", "checkMoreLiveEntranceVisible", "", "gotoMoreLive", "gotoMoreLiveImpl", "onPortraitAction", "actionInfo", "Landroid/os/Bundle;", "extraData", "", "setVisible", "visible", "", "Companion", "plugin-finder_release"})
public final class bv
  extends d
{
  private static final String yvU = "PORTRAIT_ACTION_MORE_LIVE";
  public static final a yvV;
  private final String TAG;
  private final com.tencent.mm.live.c.b kCU;
  private View yvT;
  
  static
  {
    AppMethodBeat.i(267263);
    yvV = new a((byte)0);
    yvU = "PORTRAIT_ACTION_MORE_LIVE";
    AppMethodBeat.o(267263);
  }
  
  public bv(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bid parambid)
  {
    super(paramViewGroup, paramb, parambid);
    AppMethodBeat.i(267262);
    this.kCU = paramb;
    this.TAG = "FinderLiveMoreLiveEntrancePlugin";
    this.yvT = paramViewGroup.findViewById(b.f.finder_live_more_live_entrance_group);
    AppMethodBeat.o(267262);
  }
  
  private final void dCk()
  {
    Context localContext = null;
    AppMethodBeat.i(267260);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 != null)
      {
        localObject1 = ((bac)localObject1).SLP;
        localObject2 = this.reportObj;
        if (localObject2 != null)
        {
          localObject2 = ((bid)localObject2).wmL;
          if (localObject2 != null) {
            break label237;
          }
        }
        localObject2 = "";
      }
    }
    label237:
    for (;;)
    {
      p.j(localObject2, "reportObj?.contextId ?: \"\"");
      Object localObject4 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("moreLiveEntrance click,tabId:");
      if (localObject1 != null) {}
      for (Object localObject3 = Integer.valueOf(((bcz)localObject1).SOa);; localObject3 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject3).append(",tabName:");
        localObject3 = localContext;
        if (localObject1 != null) {
          localObject3 = ((bcz)localObject1).SOb;
        }
        Log.i((String)localObject4, (String)localObject3 + " contextId:" + (String)localObject2);
        m.yCt.a(s.ar.yJH);
        localObject3 = (e)h.ag(e.class);
        localContext = this.kiF.getContext();
        p.j(localContext, "root.context");
        localObject4 = new Intent();
        if (localObject1 != null) {
          ((Intent)localObject4).putExtra("nearby_live_target_square_page_params_key", ((bcz)localObject1).toByteArray());
        }
        ((Intent)localObject4).putExtra("key_context_id", (String)localObject2);
        ((e)localObject3).enterNearbyLiveMoreUI(localContext, (Intent)localObject4);
        AppMethodBeat.o(267260);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  public final void ab(Bundle paramBundle)
  {
    AppMethodBeat.i(267261);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.h(paramBundle, yvU)) {
      dCk();
    }
    AppMethodBeat.o(267261);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dCj()
  {
    AppMethodBeat.i(267258);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      tU(8);
      AppMethodBeat.o(267258);
      return;
    }
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).liveInfo;
      if (localObject != null)
      {
        localObject = ((bac)localObject).SLP;
        if (localObject == null) {}
      }
    }
    for (localObject = Integer.valueOf(((bcz)localObject).SOa); (localObject == null) || (((Integer)localObject).intValue() == 0); localObject = null)
    {
      Log.i(this.TAG, "checkMoreLiveEntranceState tabId:".concat(String.valueOf(localObject)));
      tU(8);
      AppMethodBeat.o(267258);
      return;
    }
    localObject = ah.yhC;
    localObject = ah.dwh();
    if (localObject != null)
    {
      localObject = ((g)localObject).xVT;
      if (localObject == null) {}
    }
    for (localObject = Integer.valueOf(((j)localObject).xkX);; localObject = null)
    {
      Log.i(this.TAG, "checkMoreLiveEntranceState commentScene:".concat(String.valueOf(localObject)));
      if ((localObject != null) && (((com.tencent.c.a.b.a.d)h.ag(com.tencent.c.a.b.a.d.class)).isEnableMoreEntrencePlugin(((Integer)localObject).intValue()))) {
        break;
      }
      tU(8);
      AppMethodBeat.o(267258);
      return;
    }
    tU(0);
    m.yCt.a(s.ar.yJG);
    localObject = this.yvT;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    }
    if (isLandscape())
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      boolean bool;
      int i;
      if (!com.tencent.mm.plugin.finder.live.utils.a.k(getBuContext()))
      {
        locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.l(getBuContext())) {}
      }
      else
      {
        bool = true;
        i = com.tencent.mm.plugin.finder.live.utils.a.E((Context)localObject, bool);
        localObject = this.yvT;
        if (localObject == null) {
          break label350;
        }
      }
      label350:
      for (localObject = ((View)localObject).getLayoutParams();; localObject = null)
      {
        if (localObject != null) {
          break label355;
        }
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(267258);
        throw ((Throwable)localObject);
        bool = false;
        break;
      }
      label355:
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(i);
    }
    AppMethodBeat.o(267258);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(267259);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(267259);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(267259);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_MORE_LIVE", "", "getPORTRAIT_ACTION_MORE_LIVE", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bv parambv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(249449);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      bv.a(this.yvW);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(249449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bv
 * JD-Core Version:    0.7.0.1
 */