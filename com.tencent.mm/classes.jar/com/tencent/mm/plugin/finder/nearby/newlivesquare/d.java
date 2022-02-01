package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.live.play.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b.a;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isForceNightMode", "", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onTabListResponse", "tabs", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public static final a EMD;
  private boolean ALp;
  private bnn EIq;
  f EME;
  
  static
  {
    AppMethodBeat.i(340271);
    EMD = new a((byte)0);
    AppMethodBeat.o(340271);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(340262);
    AppMethodBeat.o(340262);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.finder.nearby.f.e.EGP;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(340319);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    boolean bool1;
    label64:
    label91:
    Object localObject1;
    Object localObject2;
    label147:
    label509:
    boolean bool2;
    label569:
    label592:
    boolean bool3;
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool1 = true;
      this.ALp = bool1;
      paramBundle = getArguments();
      if (paramBundle != null) {
        paramBundle.getString("key_by_pass");
      }
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label1109;
      }
      paramBundle = null;
      if (paramBundle != null) {
        break label1133;
      }
      paramBundle = k.aeZF;
      paramBundle = ((as)k.d(getActivity()).q(as.class)).fou();
      localObject1 = (MMActivity)getActivity();
      localObject2 = getFragment();
      s.checkNotNull(localObject2);
      this.EME = new f((MMActivity)localObject1, (Fragment)localObject2, getRootView(), paramBundle);
      paramBundle = this.EME;
      if (paramBundle != null) {
        break label1136;
      }
      s.bIx("liveFriendsCallback");
      paramBundle = null;
      localObject1 = k.aeZF;
      ((com.tencent.mm.plugin.finder.nearby.live.play.g)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.nearby.live.play.g.class)).a((AppCompatActivity)paramBundle.lzt);
      paramBundle.EMQ = f.kLs();
      Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("#onCreate red dot=", com.tencent.mm.ae.d.hF(paramBundle.EMQ)));
      paramBundle.mkw = ((RecyclerView)paramBundle.uJh.findViewById(com.tencent.mm.plugin.finder.nearby.f.d.EGp));
      localObject1 = paramBundle.uJh.findViewById(com.tencent.mm.plugin.finder.nearby.f.d.EGq);
      s.s(localObject1, "parentView.findViewById(…_entrance_refresh_layout)");
      paramBundle.EMN = ((WxRefreshLayout)localObject1);
      localObject1 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.i(paramBundle.lzt, (b)new f.c(paramBundle), paramBundle.EMO), paramBundle.EML);
      ((com.tencent.mm.view.recyclerview.i)localObject1).agOe = ((i.c)new f.d(paramBundle));
      localObject2 = ah.aiuX;
      paramBundle.EMM = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h)localObject1);
      paramBundle.EMK = new FinderStaggeredGridLayoutManager(2, 1);
      Object localObject3 = paramBundle.mkw;
      if (localObject3 != null)
      {
        localObject2 = paramBundle.EMK;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("recyclerViewLayoutManager");
          localObject1 = null;
        }
        ((RecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)localObject1);
      }
      localObject1 = paramBundle.mkw;
      if (localObject1 != null) {
        ((RecyclerView)localObject1).a((RecyclerView.h)new f.b(paramBundle));
      }
      localObject1 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.j(paramBundle.EML, (kotlin.g.a.a)new f.e(paramBundle), paramBundle.EMO, (kotlin.g.a.a)new f.f(paramBundle));
      localObject2 = paramBundle.mkw;
      if (localObject2 != null) {
        ((RecyclerView)localObject2).a((RecyclerView.l)localObject1);
      }
      localObject2 = ah.aiuX;
      paramBundle.EMP = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.j)localObject1);
      localObject1 = paramBundle.mkw;
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle.EMM);
      }
      localObject1 = paramBundle.EMN;
      if (localObject1 != null) {
        break label1139;
      }
      s.bIx("refreshLayout");
      localObject1 = null;
      ((WxRefreshLayout)localObject1).setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new f.g(paramBundle));
      localObject1 = paramBundle.mkw;
      if (localObject1 != null) {
        c.a((RecyclerView)localObject1, (com.tencent.mm.view.recyclerview.d)new f.k(paramBundle), (kotlin.g.a.b)f.l.akhF);
      }
      if (paramBundle.EMQ == 0L) {
        break label1142;
      }
      bool2 = true;
      localObject1 = com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b.EOI;
      localObject1 = b.a.eFY();
      if (localObject1 == null) {
        break label1158;
      }
      if (!((com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b)localObject1).dtm()) {
        break label1147;
      }
      if (localObject1 == null) {
        break label1158;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b)localObject1).eFW();
      if ((localObject2 == null) || (((bqr)localObject2).ZKX <= 0)) {
        break label1158;
      }
      Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("#loadPrefetchData: prefech_min_interval=", Integer.valueOf(((bqr)localObject2).ZKX)));
      localObject3 = a.EMv;
      if (a.eFG() + ((bqr)localObject2).ZKX * 60 * 1000 <= System.currentTimeMillis()) {
        break label1158;
      }
      Log.i("Finder.LiveEntranceFragmentViewCallback", "#loadPrefetchData: success");
      paramBundle.EMR = ((bqr)localObject2);
      f.a(paramBundle, (bqr)localObject2);
      ((com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b)localObject1).nx(false);
      if (((Collection)paramBundle.EML).isEmpty()) {
        break label1153;
      }
      bool1 = true;
      label709:
      Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("#onCreate isLoadPrefetchSuccess=", Boolean.valueOf(bool1)));
      bool3 = bool2;
      if (bool1)
      {
        if ((!bool2) || (!paramBundle.kLq().contains(Long.valueOf(paramBundle.EMQ)))) {
          break label1163;
        }
        Log.i("Finder.LiveEntranceFragmentViewCallback", "#onCreate in -isLoadPrefetchSuccess- condition, ready to scroll! good");
        paramBundle.kLr();
        bool3 = false;
      }
      label769:
      bool2 = false;
      if (!bool1)
      {
        localObject1 = a.EMv;
        paramBundle.EMR = a.kLp();
        localObject1 = paramBundle.EML;
        localObject2 = a.EMv;
        ((ArrayList)localObject1).addAll((Collection)a.eFH());
        if (((Collection)paramBundle.EML).isEmpty()) {
          break label1177;
        }
        bool2 = true;
        label827:
        Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("#onCreate isLoadLastExitSuccess=", Boolean.valueOf(bool2)));
      }
      if (bool2)
      {
        if (bool3) {
          break label1182;
        }
        localObject1 = a.EMv;
        Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("#onCreate in -isLoadLastExitSuccess- condition, scroll to ", Integer.valueOf(a.eFJ())));
        localObject1 = paramBundle.mkw;
        if (localObject1 != null)
        {
          localObject2 = a.EMv;
          ((RecyclerView)localObject1).scrollBy(0, a.eFJ());
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        kotlinx.coroutines.j.a(paramBundle.mainScope, null, null, (m)new f.i(paramBundle, null), 3);
      }
      localObject1 = new StringBuilder("#onCreate need auto refresh? isLoadPrefetchSuccess=").append(bool1).append(", CacheUtils.isLastExitEntranceTimeOut=");
      localObject2 = a.EMv;
      Log.i("Finder.LiveEntranceFragmentViewCallback", a.eFI() + ", hasRedDotAndNotScroll=" + bool3);
      if (!bool1)
      {
        localObject1 = a.EMv;
        if (a.eFI()) {}
      }
      else
      {
        if (!bool3) {
          break label1033;
        }
      }
      localObject2 = paramBundle.EMN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("refreshLayout");
        localObject1 = null;
      }
      ((WxRefreshLayout)localObject1).autoRefresh();
      label1033:
      localObject1 = paramBundle.mkw;
      if (localObject1 != null) {
        paramBundle.EIX = new e((Context)paramBundle.lzt, (RecyclerView)localObject1, paramBundle.EML, false, 0, true, false, 128);
      }
      localObject1 = paramBundle.EIX;
      if (localObject1 != null) {
        e.a((e)localObject1);
      }
      paramBundle.EMV.alive();
      AppMethodBeat.o(340319);
      return;
      bool1 = false;
      break;
      label1109:
      localObject1 = k.aeZF;
      paramBundle = ((as)k.y(paramBundle).q(as.class)).fou();
      break label64;
      label1133:
      break label91;
      label1136:
      break label147;
      label1139:
      break label509;
      label1142:
      bool2 = false;
      break label569;
      label1147:
      localObject1 = null;
      break label592;
      label1153:
      bool1 = false;
      break label709;
      label1158:
      bool1 = false;
      break label709;
      label1163:
      Log.i("Finder.LiveEntranceFragmentViewCallback", "#onCreate in -isLoadPrefetchSuccess- condition, not found feedId, sad.");
      bool3 = bool2;
      break label769;
      label1177:
      bool2 = false;
      break label827;
      label1182:
      Log.i("Finder.LiveEntranceFragmentViewCallback", "#onCreate in -isLoadLastExitSuccess- condition, do nothing.");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(340373);
    super.onDestroy();
    Object localObject1 = this.EIq;
    label50:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onDestroy() tab:", localObject1));
      localObject1 = this.EME;
      if (localObject1 != null) {
        break label178;
      }
      s.bIx("liveFriendsCallback");
      localObject1 = null;
      ((f)localObject1).EMV.dead();
      ar.a(((f)localObject1).mainScope, null);
      ar.a(((f)localObject1).CSl, null);
      localObject2 = a.EMv;
      a.a(((f)localObject1).EMR);
      localObject2 = a.EMv;
      a.pm(System.currentTimeMillis());
      localObject2 = a.EMv;
      a.eFH().clear();
      localObject2 = a.EMv;
      a.eFH().addAll((Collection)((f)localObject1).EML);
      localObject2 = a.EMv;
      localObject2 = ((f)localObject1).mkw;
      if (localObject2 != null) {
        break label181;
      }
    }
    label178:
    label181:
    for (int i = 0;; i = ((RecyclerView)localObject2).computeVerticalScrollOffset())
    {
      a.QP(i);
      localObject2 = ((f)localObject1).EIX;
      if (localObject2 != null) {
        ((e)localObject2).detach();
      }
      ((f)localObject1).akhD = null;
      AppMethodBeat.o(340373);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
      break label50;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(340349);
    super.onPause();
    f localf = this.EME;
    if (localf == null)
    {
      s.bIx("liveFriendsCallback");
      localf = null;
    }
    for (;;)
    {
      e locale = localf.EIX;
      if (locale != null) {
        locale.EKF.clear();
      }
      locale = localf.EIX;
      if (locale != null) {
        locale.eET();
      }
      localf.akhD = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).chX();
      Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("recordCurNoticeStatus lastNoticeSnapshot:", localf.akhD));
      AppMethodBeat.o(340349);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(340338);
    super.onResume();
    Object localObject1 = this.EME;
    if (localObject1 == null)
    {
      s.bIx("liveFriendsCallback");
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = ((f)localObject1).EIX;
      if (localObject2 != null) {
        ((e)localObject2).eES();
      }
      localObject2 = ((f)localObject1).akhD;
      if (localObject2 != null)
      {
        String str = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).chX();
        if (!Util.isEqual((String)localObject2, str))
        {
          localObject1 = ((f)localObject1).EMM;
          if (localObject1 != null) {
            ((RecyclerView.a)localObject1).bZE.notifyChanged();
          }
        }
        Log.i("Finder.LiveEntranceFragmentViewCallback", "checkNoticeStatus lastNoticeSnapshot:" + (String)localObject2 + " newSnapshot:" + str);
      }
      AppMethodBeat.o(340338);
      return;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(340328);
    super.onStart();
    if (this.EME == null) {
      s.bIx("liveFriendsCallback");
    }
    AppMethodBeat.o(340328);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(340358);
    super.onStop();
    if (this.EME == null) {
      s.bIx("liveFriendsCallback");
    }
    AppMethodBeat.o(340358);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.d
 * JD-Core Version:    0.7.0.1
 */