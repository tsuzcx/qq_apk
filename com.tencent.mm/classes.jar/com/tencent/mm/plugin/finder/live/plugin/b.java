package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.af;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.sidebar.d;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "Landroidx/lifecycle/LifecycleOwner;", "vg", "Landroid/view/ViewGroup;", "liveStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getBasePluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "basePluginLayout$delegate", "Lkotlin/Lazy;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "cacheVisibility", "", "getCacheVisibility", "()I", "setCacheVisibility", "(I)V", "clearStatus", "getClearStatus", "setClearStatus", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "lifeCycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifeCycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setLifeCycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "getLiveStatus", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "overlapOptimize", "getOverlapOptimize", "setOverlapOptimize", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getVg", "()Landroid/view/ViewGroup;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "canClearScreen", "", "canClearScreenWhenSideBarShow", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getPlugin", "modelClass", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getPluginLayout", "isFinished", "mount", "", "name", "", "onClearForSideBar", "clear", "onClearScreenEnd", "onClearScreenStart", "onClearScreenUpdate", "value", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onFollowChanged", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFollow", "onLandscapeAction", "extraMsg", "Landroid/os/Bundle;", "onLandscapeDelayAction", "delayMs", "", "onNetworkChange", "status", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitAction", "extraData", "", "onPortraitDelayAction", "postLandscapeAction", "action", "postPortraitAction", "postPortraitActionDelay", "reset", "setVisible", "visible", "unMount", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.live.b.a
  implements q
{
  public final ViewGroup CTi;
  public final com.tencent.mm.live.b.b CTj;
  private final kotlin.j CTk;
  public int CTl;
  public int CTm;
  public int CTn;
  private androidx.lifecycle.s HnN;
  public final bui reportObj;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, bui parambui)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354415);
    this.CTi = paramViewGroup;
    this.CTj = paramb;
    this.reportObj = parambui;
    this.CTk = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.CTl = this.mJe.getVisibility();
    this.CTm = 65535;
    paramViewGroup = com.tencent.d.a.a.a.a.a.ahiX;
    this.CTn = ((Number)com.tencent.d.a.a.a.a.a.jTP().bmg()).intValue();
    this.HnN = new androidx.lifecycle.s((q)this);
    AppMethodBeat.o(354415);
  }
  
  private void b(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(354453);
    kotlin.g.b.s.u(paramString, "action");
    Bundle localBundle = new Bundle();
    localBundle.putString("ACTION_POST_PORTRAIT", paramString);
    if (paramInt > 0) {
      localBundle.putInt("ACTION_POST_PORTRAIT_DELAY", paramInt);
    }
    ((e)business(e.class)).a(new c("EVENT_POST_PORTRAIT_ACTION", localBundle, paramObject));
    eoH().onPortraitAction(((e)business(e.class)).EcT, ((e)business(e.class)).EcS, localBundle, paramObject);
    AppMethodBeat.o(354453);
  }
  
  public static ap getFinderLiveAssistant()
  {
    AppMethodBeat.i(354434);
    Object localObject = aj.CGT;
    localObject = aj.getFinderLiveAssistant();
    AppMethodBeat.o(354434);
    return localObject;
  }
  
  public final void D(String paramString, Object paramObject)
  {
    AppMethodBeat.i(354584);
    kotlin.g.b.s.u(paramString, "action");
    b(paramString, paramObject, 0);
    AppMethodBeat.o(354584);
  }
  
  public void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public void aq(Bundle paramBundle) {}
  
  public final <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(354496);
    kotlin.g.b.s.u(paramClass, "bu");
    paramClass = getBuContext().business(paramClass);
    AppMethodBeat.o(354496);
    return paramClass;
  }
  
  public void c(Bundle paramBundle, Object paramObject) {}
  
  public final com.tencent.mm.plugin.finder.live.view.a ehM()
  {
    if ((this.CTj instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      return (com.tencent.mm.plugin.finder.live.view.a)this.CTj;
    }
    return null;
  }
  
  public boolean enH()
  {
    return true;
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a eoH()
  {
    AppMethodBeat.i(354486);
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.CTk.getValue();
    AppMethodBeat.o(354486);
    return locala;
  }
  
  public boolean eoI()
  {
    return false;
  }
  
  public boolean eoJ()
  {
    AppMethodBeat.i(354551);
    if (((e)business(e.class)).EcR != 1)
    {
      AppMethodBeat.o(354551);
      return true;
    }
    AppMethodBeat.o(354551);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getBuContext()
  {
    AppMethodBeat.i(354480);
    com.tencent.mm.plugin.finder.live.model.context.a locala = ((com.tencent.mm.plugin.finder.live.view.a)this.CTj).getBuContext();
    AppMethodBeat.o(354480);
    return locala;
  }
  
  public final f getData()
  {
    AppMethodBeat.i(354473);
    f localf = ((com.tencent.mm.plugin.finder.live.view.a)this.CTj).getData();
    AppMethodBeat.o(354473);
    return localf;
  }
  
  public androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)this.HnN;
  }
  
  public final <T extends b> T getPlugin(Class<T> paramClass)
  {
    AppMethodBeat.i(354637);
    kotlin.g.b.s.u(paramClass, "modelClass");
    Object localObject = this.CTj;
    if ((localObject instanceof com.tencent.mm.plugin.finder.live.view.a)) {}
    for (localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(354637);
      return null;
    }
    paramClass = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(paramClass);
    AppMethodBeat.o(354637);
    return paramClass;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(354618);
    Context localContext = this.CTi.getContext();
    if ((localContext != null) && ((localContext instanceof Activity)))
    {
      boolean bool1 = ((Activity)localContext).isFinishing();
      boolean bool2 = ((Activity)localContext).isDestroyed();
      AppMethodBeat.o(354618);
      return bool1 | bool2;
    }
    AppMethodBeat.o(354618);
    return false;
  }
  
  public void mount()
  {
    AppMethodBeat.i(371424);
    super.mount();
    this.HnN.f(j.b.bHk);
    AppMethodBeat.o(371424);
  }
  
  public final String name()
  {
    AppMethodBeat.i(354509);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(354509);
    return str;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onNetworkChange(int paramInt) {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void qU(boolean paramBoolean) {}
  
  public final void qV(boolean paramBoolean)
  {
    AppMethodBeat.i(354568);
    if ((this.CTn == 1) && (Build.VERSION.SDK_INT >= 24)) {
      this.mJe.forceHasOverlappingRendering(false);
    }
    if (!paramBoolean) {
      tO(this.CTl);
    }
    AppMethodBeat.o(354568);
  }
  
  public final void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(354575);
    if ((this.CTn == 1) && (Build.VERSION.SDK_INT >= 24)) {
      this.mJe.forceHasOverlappingRendering(this.mJe.hasOverlappingRendering());
    }
    if (paramBoolean) {
      tO(this.CTl);
    }
    AppMethodBeat.o(354575);
  }
  
  public void qX(boolean paramBoolean) {}
  
  public void reset() {}
  
  public void tO(int paramInt)
  {
    AppMethodBeat.i(354657);
    this.CTl = paramInt;
    Object localObject;
    int i;
    if (!eoJ())
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("plugin visible", getClass().getSimpleName() + " invisible in liveMode:" + ((e)business(e.class)).EcR);
      i = 8;
    }
    for (;;)
    {
      super.tO(i);
      if (i == 0) {
        this.mJe.setAlpha(1.0F);
      }
      AppMethodBeat.o(354657);
      return;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.mJe.getContext();
      kotlin.g.b.s.s(localObject, "root.context");
      if ((((d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(d.class)).DGD) && (enH()))
      {
        i = 8;
      }
      else
      {
        i = paramInt;
        if (eoI())
        {
          i = paramInt;
          if (this.CTm == 8) {
            i = 8;
          }
        }
      }
    }
  }
  
  public void unMount()
  {
    AppMethodBeat.i(371425);
    super.unMount();
    this.HnN.f(j.b.bHg);
    this.HnN = new androidx.lifecycle.s((q)this);
    AppMethodBeat.o(371425);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.view.a>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.b
 * JD-Core Version:    0.7.0.1
 */