package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyLiveSquareTabFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  public axj uQK;
  
  public NearbyLiveSquareTabFragment()
  {
    super(2131763491, 1005);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249233);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249233);
  }
  
  public final String ack()
  {
    return "1001";
  }
  
  public final String afB()
  {
    AppMethodBeat.i(249232);
    StringBuilder localStringBuilder = new StringBuilder().append(getCommentScene()).append('-');
    Object localObject = this.uQK;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((axj)localObject).LHQ);; localObject = "")
    {
      localObject = localObject;
      AppMethodBeat.o(249232);
      return localObject;
    }
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final void dll()
  {
    AppMethodBeat.i(249229);
    super.dll();
    b localb = ((NearbyLiveSquareTabUIC)component(NearbyLiveSquareTabUIC.class)).uRR;
    if (localb == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localb != null)
    {
      localb.onActionbarClick(false);
      AppMethodBeat.o(249229);
      return;
    }
    AppMethodBeat.o(249229);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(249230);
    super.dlm();
    b localb = ((NearbyLiveSquareTabUIC)component(NearbyLiveSquareTabUIC.class)).uRR;
    if (localb == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localb != null)
    {
      localb.onActionbarClick(true);
      AppMethodBeat.o(249230);
      return;
    }
    AppMethodBeat.o(249230);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(249231);
    int i = ((FinderReporterUIC)component(FinderReporterUIC.class)).tCE;
    AppMethodBeat.o(249231);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249225);
    Set localSet = ak.setOf(new Class[] { FinderReporterUIC.class, NearbyLiveSquareTabUIC.class });
    AppMethodBeat.o(249225);
    return localSet;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(249226);
    p.h(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getArguments();
    if (paramViewGroup != null)
    {
      int i = paramViewGroup.getInt("key_comment_scene");
      ((FinderReporterUIC)component(FinderReporterUIC.class)).tCE = i;
    }
    AppMethodBeat.o(249226);
    return paramLayoutInflater;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249227);
    super.onUserVisibleFocused();
    d locald = d.uTq;
    d.b((AbsNearByFragment)this);
    AppMethodBeat.o(249227);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249228);
    super.onUserVisibleUnFocused();
    d locald = d.uTq;
    d.c((AbsNearByFragment)this);
    AppMethodBeat.o(249228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabFragment
 * JD-Core Version:    0.7.0.1
 */