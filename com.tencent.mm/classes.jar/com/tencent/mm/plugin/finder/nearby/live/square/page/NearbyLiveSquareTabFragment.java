package com.tencent.mm.plugin.finder.nearby.live.square.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "commentScene", "", "isForceNightMode", "", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getClickSubTabId", "", "getCommentScene", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"})
public final class NearbyLiveSquareTabFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  private int xkX;
  private boolean xnL;
  public final bcz zDU;
  
  public NearbyLiveSquareTabFragment(bcz parambcz)
  {
    super(b.j.nearby_tab_live, 1005);
    AppMethodBeat.i(200738);
    this.zDU = parambcz;
    AppMethodBeat.o(200738);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(200739);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(200739);
  }
  
  public final String akA()
  {
    AppMethodBeat.i(200733);
    StringBuilder localStringBuilder = new StringBuilder().append(getCommentScene()).append('-');
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bcz)localObject).SOa);; localObject = null)
    {
      localObject = Integer.valueOf(((Integer)localObject).intValue());
      AppMethodBeat.o(200733);
      return localObject;
    }
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(200726);
    super.dLt();
    b localb = ((c)component(c.class)).zGD;
    if (localb == null) {
      p.bGy("liveFriendsPresenter");
    }
    if (localb != null)
    {
      localb.onActionbarClick(false);
      AppMethodBeat.o(200726);
      return;
    }
    AppMethodBeat.o(200726);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(200728);
    super.dLu();
    b localb = ((c)component(c.class)).zGD;
    if (localb == null) {
      p.bGy("liveFriendsPresenter");
    }
    if (localb != null)
    {
      localb.onActionbarClick(true);
      AppMethodBeat.o(200728);
      return;
    }
    AppMethodBeat.o(200728);
  }
  
  public final String dLw()
  {
    AppMethodBeat.i(200735);
    int i = this.zDU.SOa;
    AppMethodBeat.o(200735);
    return String.valueOf(i);
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(200736);
    if (getActivity() != null)
    {
      i = ((aj)component(aj.class)).xkX;
      AppMethodBeat.o(200736);
      return i;
    }
    int i = this.xkX;
    AppMethodBeat.o(200736);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(200719);
    Set localSet = ak.setOf(new Class[] { aj.class, c.class });
    AppMethodBeat.o(200719);
    return localSet;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(200722);
    p.k(paramLayoutInflater, "inflater");
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    int i;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.getInt("key_use_dark_style", 1) == 1))
    {
      this.xnL = bool;
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null)
      {
        i = paramLayoutInflater.getInt("key_comment_scene");
        paramLayoutInflater = a.zGC;
        if (!a.Ov(i)) {
          break label175;
        }
      }
    }
    for (;;)
    {
      this.xkX = i;
      ((aj)component(aj.class)).xkX = this.xkX;
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater = paramLayoutInflater.getString("key_click_tab_context_id");
        if (paramLayoutInflater != null) {
          ((aj)component(aj.class)).wmz = paramLayoutInflater;
        }
      }
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null)
      {
        paramViewGroup = paramLayoutInflater.getString("key_click_tab_id");
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup != null) {}
      }
      else
      {
        paramLayoutInflater = "";
      }
      aDy(paramLayoutInflater);
      AppMethodBeat.o(200722);
      return paramBundle;
      bool = false;
      break;
      label175:
      paramLayoutInflater = a.zGC;
      i = a.parseTabCommentScene(i, this.zDU.SOa);
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200730);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    ((c)component(c.class)).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200730);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(200723);
    super.onUserVisibleFocused();
    Object localObject = e.zJs;
    e.d((AbsNearByFragment)this);
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.b((AbsNearByFragment)this);
    AppMethodBeat.o(200723);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(200725);
    super.onUserVisibleUnFocused();
    Object localObject = e.zJs;
    e.e((AbsNearByFragment)this);
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)this);
    AppMethodBeat.o(200725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment
 * JD-Core Version:    0.7.0.1
 */