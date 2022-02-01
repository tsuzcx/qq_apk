package com.tencent.mm.plugin.finder.nearby.live.square.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.f;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "subTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "commentScene", "", "isForceNightMode", "", "getSubTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setSubTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getTabInfo", "getClickSubTabId", "", "getCommentScene", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLiveSquareTabFragment
  extends AbsNearByFragment
{
  private int AJo;
  private boolean ALp;
  public final bnn EIq;
  public bnn ELV;
  
  private NearbyLiveSquareTabFragment(bnn parambnn)
  {
    super(e.h.nearby_tab_live, 1005);
    AppMethodBeat.i(341312);
    this.EIq = parambnn;
    this.ELV = null;
    AppMethodBeat.o(341312);
  }
  
  public final void eEq()
  {
    AppMethodBeat.i(341349);
    super.eEq();
    c localc2 = ((d)component(d.class)).ELY;
    c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("liveFriendsPresenter");
      localc1 = null;
    }
    localc1.onActionbarClick(false);
    AppMethodBeat.o(341349);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(341357);
    super.eEr();
    c localc2 = ((d)component(d.class)).ELY;
    c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("liveFriendsPresenter");
      localc1 = null;
    }
    localc1.onActionbarClick(true);
    AppMethodBeat.o(341357);
  }
  
  public final String eEu()
  {
    AppMethodBeat.i(341381);
    int i = this.EIq.ZVZ;
    AppMethodBeat.o(341381);
    return String.valueOf(i);
  }
  
  public final String eEw()
  {
    AppMethodBeat.i(341376);
    StringBuilder localStringBuilder = new StringBuilder().append(getCommentScene()).append('-');
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = "";; localObject = Integer.valueOf(((bnn)localObject).ZVZ))
    {
      localObject = localObject;
      AppMethodBeat.o(341376);
      return localObject;
    }
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(341389);
    if (getActivity() == null) {}
    for (Integer localInteger = null; localInteger == null; localInteger = Integer.valueOf(((as)component(as.class)).AJo))
    {
      i = this.AJo;
      AppMethodBeat.o(341389);
      return i;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(341389);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(341323);
    Set localSet = ar.setOf(new Class[] { as.class, d.class });
    AppMethodBeat.o(341323);
    return localSet;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(341331);
    s.u(paramLayoutInflater, "inflater");
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    int i;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.getInt("key_use_dark_style", 1) == 1))
    {
      this.ALp = bool;
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null)
      {
        i = paramLayoutInflater.getInt("key_from_comment_scene");
        paramLayoutInflater = b.ELW;
        if (!b.QN(i)) {
          break label180;
        }
        label77:
        this.AJo = i;
        ((as)component(as.class)).AJo = this.AJo;
        paramLayoutInflater = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
        com.tencent.mm.plugin.finder.nearby.preload.a.hX(this.EIq.ZVZ, this.AJo);
      }
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater = paramLayoutInflater.getString("key_click_tab_context_id");
        if (paramLayoutInflater != null) {
          ((as)component(as.class)).zIB = paramLayoutInflater;
        }
      }
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null) {
        break label201;
      }
      paramLayoutInflater = "";
    }
    for (;;)
    {
      ayW(paramLayoutInflater);
      AppMethodBeat.o(341331);
      return paramBundle;
      bool = false;
      break;
      label180:
      paramLayoutInflater = b.ELW;
      i = b.parseTabCommentScene(i, this.EIq.ZVZ);
      break label77;
      label201:
      paramViewGroup = paramLayoutInflater.getString("key_click_tab_id");
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341366);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    ((d)component(d.class)).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(341366);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(341393);
    super.onStop();
    k localk = k.aeZF;
    ((as)k.y((Fragment)this).q(as.class)).onDestroy();
    AppMethodBeat.o(341393);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(341337);
    super.onUserVisibleFocused();
    Object localObject = g.ERj;
    g.d((AbsNearByFragment)this);
    com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.b((AbsNearByFragment)this);
    localObject = getActivity();
    if (localObject != null)
    {
      k localk = k.aeZF;
      localObject = (f)k.nq((Context)localObject).q(f.class);
      ((f)localObject).ELv = "";
      ((f)localObject).ELw = 0L;
      ((f)localObject).ELx = true;
    }
    AppMethodBeat.o(341337);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(341341);
    super.onUserVisibleUnFocused();
    g localg = g.ERj;
    g.e((AbsNearByFragment)this);
    com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)this);
    AppMethodBeat.o(341341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment
 * JD-Core Version:    0.7.0.1
 */