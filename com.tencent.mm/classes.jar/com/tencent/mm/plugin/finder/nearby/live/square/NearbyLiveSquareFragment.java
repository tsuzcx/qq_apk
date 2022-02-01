package com.tencent.mm.plugin.finder.nearby.live.square;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.af;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onMenuClick", "", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public class NearbyLiveSquareFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyLiveSquareFragment()
  {
    super(2131763491, 1001);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249154);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249154);
  }
  
  public String ack()
  {
    return "";
  }
  
  public final String afB()
  {
    return "";
  }
  
  public int ddN()
  {
    return 3;
  }
  
  public final void dlk()
  {
    AppMethodBeat.i(249149);
    super.dlk();
    Object localObject = ((NearbyLiveSquareUIC)component(NearbyLiveSquareUIC.class)).uRi;
    if (localObject == null) {
      p.btv("livePostHelper");
    }
    ((f)localObject).prepare();
    localObject = k.vkd;
    k.a(s.af.vqn);
    AppMethodBeat.o(249149);
  }
  
  public int getCommentScene()
  {
    return 94;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249148);
    Set localSet = ak.setOf(new Class[] { FinderReporterUIC.class, NearbyLiveSquareGuideUIC.class, NearbyLiveSquareTabLayoutUIC.class, NearbyLiveSquareUIC.class });
    AppMethodBeat.o(249148);
    return localSet;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(249152);
    super.onPause();
    Log.i("NearbyLiveSquareUIC", "onPause()");
    Object localObject = getActivity();
    if (localObject != null)
    {
      a locala = a.PRN;
      p.g(localObject, "it");
      if (((((NearbyHomeUIC)a.ko((Context)localObject).get(NearbyHomeUIC.class)).dlj() instanceof NearbyLiveSquareFragment)) || ((this instanceof NearbyLiveSquareMoreFragment)))
      {
        localObject = d.uTq;
        d.c(((NearbyLiveSquareUIC)component(NearbyLiveSquareUIC.class)).dlj());
      }
      AppMethodBeat.o(249152);
      return;
    }
    AppMethodBeat.o(249152);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249153);
    super.onResume();
    Log.i("NearbyLiveSquareUIC", "onResume()");
    d locald = d.uTq;
    d.dlB();
    AppMethodBeat.o(249153);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249150);
    super.onUserVisibleFocused();
    if (getActivity() != null)
    {
      d locald = d.uTq;
      d.b(((NearbyLiveSquareUIC)component(NearbyLiveSquareUIC.class)).dlj());
    }
    AppMethodBeat.o(249150);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249151);
    super.onUserVisibleUnFocused();
    d locald = d.uTq;
    d.c(((NearbyLiveSquareUIC)component(NearbyLiveSquareUIC.class)).dlj());
    AppMethodBeat.o(249151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
 * JD-Core Version:    0.7.0.1
 */