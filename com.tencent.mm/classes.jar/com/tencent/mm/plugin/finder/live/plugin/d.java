package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.viewmodel.data.c;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "vg", "Landroid/view/ViewGroup;", "liveStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getBasePluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "basePluginLayout$delegate", "Lkotlin/Lazy;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "cacheVisibility", "", "getCacheVisibility", "()I", "setCacheVisibility", "(I)V", "clearStatus", "getClearStatus", "setClearStatus", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getLiveStatus", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "overlapOptimize", "getOverlapOptimize", "setOverlapOptimize", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getVg", "()Landroid/view/ViewGroup;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "canClearScreen", "", "getPlugin", "modelClass", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getPluginLayout", "isFinished", "name", "", "onClearScreenEnd", "", "clear", "onClearScreenStart", "onClearScreenUpdate", "value", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLandscapeAction", "extraMsg", "Landroid/os/Bundle;", "onLandscapeDelayAction", "delayMs", "", "onNetworkChange", "status", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitAction", "extraData", "", "onPortraitDelayAction", "postLandscapeAction", "action", "postPortraitAction", "postPortraitActionDelay", "reset", "setVisible", "visible", "plugin-finder_release"})
public class d
  extends com.tencent.mm.live.c.a
{
  public final bid reportObj;
  private final kotlin.f ykY;
  public int ykZ;
  public int yla;
  public int ylb;
  public final ViewGroup ylc;
  public final com.tencent.mm.live.c.b yld;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bid parambid)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(273568);
    this.ylc = paramViewGroup;
    this.yld = paramb;
    this.reportObj = parambid;
    this.ykY = g.ar((kotlin.g.a.a)new a(this));
    this.ykZ = this.kiF.getVisibility();
    this.yla = 65535;
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    this.ylb = ((Number)com.tencent.c.a.a.a.a.a.inh().aSr()).intValue();
    AppMethodBeat.o(273568);
  }
  
  private void b(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(273561);
    p.k(paramString, "action");
    Bundle localBundle = new Bundle();
    localBundle.putString("ACTION_POST_PORTRAIT", paramString);
    if (paramInt > 0) {
      localBundle.putInt("ACTION_POST_PORTRAIT_DELAY", paramInt);
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).a(new c("EVENT_POST_PORTRAIT_ACTION", localBundle, paramObject));
    dAn().onPortraitAction(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, localBundle, paramObject);
    AppMethodBeat.o(273561);
  }
  
  public static an getFinderLiveAssistant()
  {
    AppMethodBeat.i(273554);
    Object localObject = ah.yhC;
    localObject = ah.getFinderLiveAssistant();
    AppMethodBeat.o(273554);
    return localObject;
  }
  
  public void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public void ab(Bundle paramBundle) {}
  
  public final <T extends x> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(273556);
    p.k(paramClass, "bu");
    paramClass = getBuContext().business(paramClass);
    AppMethodBeat.o(273556);
    return paramClass;
  }
  
  public void cN() {}
  
  public final com.tencent.mm.plugin.finder.live.view.a dAn()
  {
    AppMethodBeat.i(273555);
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.ykY.getValue();
    AppMethodBeat.o(273555);
    return locala;
  }
  
  public boolean dAo()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a dxf()
  {
    if ((this.yld instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      return (com.tencent.mm.plugin.finder.live.view.a)this.yld;
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getBuContext()
  {
    AppMethodBeat.i(273552);
    Object localObject = this.yld;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
      AppMethodBeat.o(273552);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getBuContext();
    AppMethodBeat.o(273552);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.f getData()
  {
    AppMethodBeat.i(273551);
    Object localObject = this.yld;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
      AppMethodBeat.o(273551);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getData();
    AppMethodBeat.o(273551);
    return localObject;
  }
  
  public final <T extends d> T getPlugin(Class<T> paramClass)
  {
    AppMethodBeat.i(273565);
    p.k(paramClass, "modelClass");
    com.tencent.mm.live.c.b localb = this.yld;
    Object localObject = localb;
    if (!(localb instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject;
    if (localObject != null)
    {
      paramClass = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(paramClass);
      AppMethodBeat.o(273565);
      return paramClass;
    }
    AppMethodBeat.o(273565);
    return null;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(273564);
    Context localContext = this.ylc.getContext();
    if ((localContext != null) && ((localContext instanceof Activity)))
    {
      boolean bool1 = ((Activity)localContext).isFinishing();
      boolean bool2 = ((Activity)localContext).isDestroyed();
      AppMethodBeat.o(273564);
      return bool1 | bool2;
    }
    AppMethodBeat.o(273564);
    return false;
  }
  
  public final String name()
  {
    AppMethodBeat.i(273557);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(273557);
    return str;
  }
  
  public final void oT(boolean paramBoolean)
  {
    AppMethodBeat.i(273558);
    if ((this.ylb == 1) && (Build.VERSION.SDK_INT >= 24)) {
      this.kiF.forceHasOverlappingRendering(false);
    }
    if (!paramBoolean) {
      tU(this.ykZ);
    }
    AppMethodBeat.o(273558);
  }
  
  public final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(273559);
    if ((this.ylb == 1) && (Build.VERSION.SDK_INT >= 24)) {
      this.kiF.forceHasOverlappingRendering(this.kiF.hasOverlappingRendering());
    }
    if (paramBoolean) {
      tU(this.ykZ);
    }
    AppMethodBeat.o(273559);
  }
  
  public void onNetworkChange(int paramInt) {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void reset() {}
  
  public void tU(int paramInt)
  {
    AppMethodBeat.i(273567);
    this.ykZ = paramInt;
    int i = paramInt;
    if (dAo())
    {
      i = paramInt;
      if (this.yla == 8) {
        i = 8;
      }
    }
    super.tU(i);
    if (i == 0) {
      this.kiF.setAlpha(1.0F);
    }
    AppMethodBeat.o(273567);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.view.a>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.d
 * JD-Core Version:    0.7.0.1
 */