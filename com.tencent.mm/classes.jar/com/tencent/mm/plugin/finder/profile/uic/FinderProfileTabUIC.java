package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.profile.FinderProfileAtFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileMegaVideoFragment;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.i.a;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "DEFAULT_APPID", "", "DEFAULT_APPURL", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "checkMusicFirstPage", "", "isNoSeeAtTab", "()Z", "isPrivateAccount", "isSelf", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", "isSelfScene", "isSelfScene$delegate", "line", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getLine", "()Landroid/view/View;", "line$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "selfUserName", "showShopOpGuide", "targetUsername", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "addAtFeedFragment", "", "addMegaVideoFragment", "addMusicFragment", "checkHasAtFeed", "checkHasMegaVideoItem", "checkFirstPage", "checkHasMusic", "checkMusicTab", "checkShopOpGuide", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts;", "checkShopTab", "checkTabLayoutVisibility", "generateProvider", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "getFragmentBy", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "T", "clazz", "Ljava/lang/Class;", "isAtFeedNotEmpty", "response", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "isEnableShowAtFeedFragment", "isPostingMvExist", "isShouldAddDraftTab", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onShopGuideRightBtnClick", "appId", "appUrl", "removeAtFeedFragment", "clearCache", "removeMegaVideoFragment", "removeMusicFragment", "showShopOpGuideDialog", "Companion", "Provider", "Tab", "TabContainer", "TabViewAction", "plugin-finder_release"})
public final class FinderProfileTabUIC
  extends FinderTabUIC
{
  public static final a zTu;
  private final kotlin.f xLz;
  private final String xcW;
  private final kotlin.f xjx;
  private final kotlin.f zQp;
  private boolean zTn;
  private final kotlin.f zTo;
  private final kotlin.f zTp;
  private boolean zTq;
  private final String zTr;
  private final String zTs;
  private final String zTt;
  private FinderAtFeedLoader zsC;
  
  static
  {
    AppMethodBeat.i(285736);
    zTu = new a((byte)0);
    AppMethodBeat.o(285736);
  }
  
  public FinderProfileTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(285735);
    this.xLz = kotlin.g.ar((kotlin.g.a.a)new v(this));
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.zQp = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.zTo = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.zTp = kotlin.g.ar((kotlin.g.a.a)new n(paramAppCompatActivity));
    Object localObject = new StringBuilder("[Provider] username=").append(getUsername()).append(" isSelf=").append(isSelf()).append(" isSelfFlag=").append(isSelfFlag()).append(" isNoSeeAtTab=");
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.utils.aj.aFN(getUsername())).append(" isPrivateAccount=").append(dOO()).append(" profileContact=");
    if (getProfileContact() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderProfileTabUIC", bool);
      localObject = paramAppCompatActivity.getIntent().getStringExtra("finder_username");
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (localObject == null) {
        paramAppCompatActivity = "";
      }
      this.xcW = paramAppCompatActivity;
      this.zTr = z.bdh();
      this.zTs = "wx2bff878c51bab23b";
      this.zTt = "pages/index/index";
      AppMethodBeat.o(285735);
      return;
    }
  }
  
  private boolean dOM()
  {
    AppMethodBeat.i(285717);
    boolean bool = ((Boolean)this.zTo.getValue()).booleanValue();
    AppMethodBeat.o(285717);
    return bool;
  }
  
  private View dON()
  {
    AppMethodBeat.i(285718);
    View localView = (View)this.zTp.getValue();
    AppMethodBeat.o(285718);
    return localView;
  }
  
  private boolean dOO()
  {
    AppMethodBeat.i(285720);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.j(getProfileContact());
    AppMethodBeat.o(285720);
    return bool;
  }
  
  private final boolean dOP()
  {
    AppMethodBeat.i(285721);
    if (!dOM())
    {
      if (dOM()) {
        break label59;
      }
      if (dOO())
      {
        if (!dOO()) {
          break label59;
        }
        i.a locala = com.tencent.mm.plugin.finder.upload.action.i.ACa;
        if (!com.tencent.mm.plugin.finder.upload.action.i.ecE().aAN(this.xcW)) {
          break label59;
        }
      }
    }
    AppMethodBeat.o(285721);
    return true;
    label59:
    AppMethodBeat.o(285721);
    return false;
  }
  
  private final void dOR()
  {
    AppMethodBeat.i(285724);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (!com.tencent.mm.plugin.finder.storage.d.dXH())
    {
      AppMethodBeat.o(285724);
      return;
    }
    h.aGY().a(5244, (com.tencent.mm.an.i)new j(this));
    localObject = this.xcW;
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    localObject = new bw((String)localObject, null, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
    h.aGY().b((com.tencent.mm.an.q)localObject);
    AppMethodBeat.o(285724);
  }
  
  private final boolean dOT()
  {
    AppMethodBeat.i(285727);
    if ((isSelfFlag()) && (((PluginFinder)h.ag(PluginFinder.class)).getDraftStorage().getCount() > 0))
    {
      AppMethodBeat.o(285727);
      return true;
    }
    AppMethodBeat.o(285727);
    return false;
  }
  
  private final void dOU()
  {
    AppMethodBeat.i(285728);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(285728);
  }
  
  private final boolean dOV()
  {
    AppMethodBeat.i(285733);
    if (!((Collection)k.Anu.bc(14, this.xcW)).isEmpty())
    {
      AppMethodBeat.o(285733);
      return true;
    }
    AppMethodBeat.o(285733);
    return false;
  }
  
  private final com.tencent.mm.plugin.finder.api.i getProfileContact()
  {
    AppMethodBeat.i(285719);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = d.a.aAK(getUsername());
    AppMethodBeat.o(285719);
    return localObject;
  }
  
  private final boolean qc(boolean paramBoolean)
  {
    AppMethodBeat.i(285731);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() != 1)
    {
      AppMethodBeat.o(285731);
      return false;
    }
    int i;
    if (paramBoolean)
    {
      if (!((Collection)k.Anu.bc(13, this.xcW)).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has mega video first page data");
        AppMethodBeat.o(285731);
        return true;
      }
    }
    if (!dOM())
    {
      AppMethodBeat.o(285731);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    localObject = c.a.ai(this.xcW, 0, 2147483647);
    if (!((Collection)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label198;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label203;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((FinderItem)((Iterator)localObject).next()).isLongVideo());
      Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has posting mega video");
      AppMethodBeat.o(285731);
      return true;
      i = 0;
      break;
      label198:
      localObject = null;
    }
    label203:
    AppMethodBeat.o(285731);
    return false;
  }
  
  public final <T extends FinderHomeTabFragment> FinderHomeTabFragment aK(Class<T> paramClass)
  {
    AppMethodBeat.i(285734);
    p.k(paramClass, "clazz");
    Iterator localIterator = ((Iterable)getFragments()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((FinderHomeTabFragment)localObject).getClass(), paramClass));
    for (paramClass = localObject;; paramClass = null)
    {
      if (paramClass == null) {
        p.iCn();
      }
      paramClass = (FinderHomeTabFragment)paramClass;
      AppMethodBeat.o(285734);
      return paramClass;
    }
  }
  
  public final void dOQ()
  {
    AppMethodBeat.i(285723);
    super.dOQ();
    Object localObject = getTabContainer().ejV();
    if ((localObject != null) && (((HardTouchableLayout)localObject).getVisibility() == 0))
    {
      localObject = dON();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(285723);
        return;
      }
      AppMethodBeat.o(285723);
      return;
    }
    localObject = dON();
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(285723);
      return;
    }
    AppMethodBeat.o(285723);
  }
  
  public final void dOS()
  {
    AppMethodBeat.i(285725);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() != 1)
    {
      AppMethodBeat.o(285725);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(285725);
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(285714);
    String str = (String)this.xLz.getValue();
    AppMethodBeat.o(285714);
    return str;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(285716);
    boolean bool = ((Boolean)this.zQp.getValue()).booleanValue();
    AppMethodBeat.o(285716);
    return bool;
  }
  
  public final boolean isSelfFlag()
  {
    AppMethodBeat.i(285715);
    boolean bool = ((Boolean)this.xjx.getValue()).booleanValue();
    AppMethodBeat.o(285715);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(285722);
    super.onCreate(paramBundle);
    paramBundle = ejW();
    if ((paramBundle instanceof FinderViewPager)) {
      ((FinderViewPager)paramBundle).setEnableViewPagerScroll(true);
    }
    switch (getActivity().getIntent().getIntExtra("key_enter_profile_tab", 0))
    {
    }
    for (;;)
    {
      if (!qc(true))
      {
        Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have mega video item, remove the tab");
        qb(false);
      }
      if ((dOP()) && (!dOV()))
      {
        Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have at item, remove the tab");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(this));
        paramBundle = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g.xKD, this.xcW, null);
        paramBundle.xGJ = ((kotlin.g.a.b)new o(this));
        this.zsC = paramBundle;
        paramBundle = this.zsC;
        if (paramBundle != null) {
          paramBundle.onAlive();
        }
        paramBundle = this.zsC;
        if (paramBundle != null) {
          paramBundle.requestRefresh();
        }
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) && (!Sd(105)))
      {
        h.aGY().a(3736, (com.tencent.mm.an.i)new p(this));
        paramBundle = h.aGY();
        localObject = this.xcW;
        localg = com.tencent.mm.ui.component.g.Xox;
        paramBundle.b((com.tencent.mm.an.q)new cr((String)localObject, 0L, null, 0, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), 1, 0L, 64));
      }
      h.aGY().a(6628, (com.tencent.mm.an.i)new i(this));
      paramBundle = this.xcW;
      Object localObject = this.zTr;
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      paramBundle = new by(paramBundle, (String)localObject, null, 0, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
      h.aGY().b((com.tencent.mm.an.q)paramBundle);
      dOR();
      dOQ();
      AppMethodBeat.o(285722);
      return;
      paramBundle = ((Iterable)getFragments()).iterator();
      int i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.iBO();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileAtFeedFragment)) {
          aA(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.iBO();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileMegaVideoFragment)) {
          aA(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.iBO();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileMusicFragment)) {
          aA(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.iBO();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileDraftFragment)) {
          aA(i, false);
        }
        i += 1;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285732);
    super.onDestroy();
    FinderAtFeedLoader localFinderAtFeedLoader = this.zsC;
    if (localFinderAtFeedLoader != null)
    {
      localFinderAtFeedLoader.onDead();
      AppMethodBeat.o(285732);
      return;
    }
    AppMethodBeat.o(285732);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285730);
    super.onResume();
    Iterator localIterator = getFragments().iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next() instanceof FinderProfileAtFeedFragment))
      {
        label46:
        if (i < 0) {
          break label217;
        }
        if (!dOP()) {
          FinderTabUIC.c(this, i);
        }
        label62:
        if ((!Sd(105)) && (qc(false)))
        {
          Log.i("Finder.FinderProfileTabUIC", "onResume: add long video tab back because of local item");
          dOS();
        }
        localIterator = getFragments().iterator();
        i = 0;
        label104:
        if (!localIterator.hasNext()) {
          break label245;
        }
        if (!((FinderHomeTabFragment)localIterator.next() instanceof FinderProfileDraftFragment)) {
          break label238;
        }
      }
    }
    for (;;)
    {
      if ((i < 0) && (dOT())) {
        FinderTabUIC.a(this, (com.tencent.mm.plugin.finder.view.tabcomp.a)new c(b.j.finder_profile_draft_tab_name), (FinderHomeTabFragment)new FinderProfileDraftFragment());
      }
      if ((isSelf()) && (this.zTq))
      {
        Log.i("Finder.FinderProfileTabUIC", "checkShopTab after showShopOpGuide!");
        this.zTq = false;
        dOR();
      }
      AppMethodBeat.o(285730);
      return;
      i += 1;
      break;
      i = -1;
      break label46;
      label217:
      if ((!dOP()) || (!dOV())) {
        break label62;
      }
      dOU();
      break label62;
      label238:
      i += 1;
      break label104;
      label245:
      i = -1;
    }
  }
  
  public final void qb(final boolean paramBoolean)
  {
    AppMethodBeat.i(285729);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new r(this, paramBoolean));
    AppMethodBeat.o(285729);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;)V", "isDynamic", "", "plugin-finder_release"})
  public final class b
    extends FinderTabProvider
  {
    public b()
    {
      AppMethodBeat.i(292003);
      setTabContainer((com.tencent.mm.plugin.finder.view.tabcomp.g)new FinderProfileTabUIC.d());
      setTabViewAction((com.tencent.mm.plugin.finder.view.tabcomp.f)new FinderProfileTabUIC.e());
      boolean bool = FinderProfileTabUIC.b(this$1);
      this$1 = new LinkedList();
      this$1.add(new FinderProfileTabUIC.c(b.j.finder_self_profile_feed_title));
      Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        this$1.add(new FinderProfileTabUIC.c(b.j.finder_tab_title_long_video));
      }
      if (FinderProfileTabUIC.c(this.zTv)) {
        this$1.add(new FinderProfileTabUIC.c(b.j.finder_self_profile_care_feed_title));
      }
      if (FinderProfileTabUIC.d(this.zTv)) {
        this$1.add(new FinderProfileTabUIC.c(b.j.finder_profile_music_tab_name));
      }
      if ((this.zTv.isSelf()) && (bool)) {
        this$1.add(new FinderProfileTabUIC.c(b.j.finder_profile_draft_tab_name));
      }
      setTabs((List)this$1);
      this$1 = new LinkedList();
      this$1.add(new FinderProfileFeedFragment());
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        this$1.add(new FinderProfileMegaVideoFragment());
      }
      if (FinderProfileTabUIC.c(this.zTv)) {
        this$1.add(new FinderProfileAtFeedFragment());
      }
      if (FinderProfileTabUIC.d(this.zTv))
      {
        this$1.add(new FinderProfileMusicFragment());
        localObject = com.tencent.mm.ui.component.g.Xox;
        f.a((f)com.tencent.mm.ui.component.g.b(this.zTv.getActivity()).i(f.class), "mvtab", 0, null, 6);
      }
      if ((this.zTv.isSelf()) && (bool))
      {
        this$1.add(new FinderProfileDraftFragment());
        localObject = com.tencent.mm.ui.component.g.Xox;
        f.a((f)com.tencent.mm.ui.component.g.b(this.zTv.getActivity()).i(f.class), "drafttab", 0, null, 6);
      }
      setFragments((List)this$1);
      AppMethodBeat.o(292003);
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getTitleId", "()I", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.view.tabcomp.c
  {
    private final int zDq;
    
    public c(int paramInt)
    {
      super();
      this.zDq = paramInt;
    }
    
    public final int[] dmU()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return b.g.finder_profile_normal_tab_text;
    }
    
    public final void y(ViewGroup paramViewGroup)
    {
      com.tencent.mm.ui.component.g localg = null;
      AppMethodBeat.i(263847);
      p.k(paramViewGroup, "tabView");
      super.y(paramViewGroup);
      int i = this.zDq;
      if (i == b.j.finder_activity_title)
      {
        Object localObject = paramViewGroup.getContext();
        if (localObject == null)
        {
          paramViewGroup = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(263847);
          throw paramViewGroup;
        }
        localObject = ((MMActivity)localObject).getIntent().getStringExtra("finder_username");
        n localn = n.zWF;
        if (p.h(localObject, z.bdh())) {}
        for (long l = 1L;; l = 0L)
        {
          localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramViewGroup = paramViewGroup.getContext();
          p.j(paramViewGroup, "tabView.context");
          localObject = aj.a.fZ(paramViewGroup);
          paramViewGroup = localg;
          if (localObject != null) {
            paramViewGroup = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();
          }
          n.a(l, "2", 3L, "", paramViewGroup);
          AppMethodBeat.o(263847);
          return;
        }
      }
      if (i == b.j.finder_profile_music_tab_name)
      {
        localg = com.tencent.mm.ui.component.g.Xox;
        paramViewGroup = paramViewGroup.getContext();
        p.j(paramViewGroup, "tabView.context");
        f.a((f)com.tencent.mm.ui.component.g.lm(paramViewGroup).i(f.class), "mvtab", 1, null, 4);
        AppMethodBeat.o(263847);
        return;
      }
      if (i == b.j.finder_profile_draft_tab_name)
      {
        localg = com.tencent.mm.ui.component.g.Xox;
        paramViewGroup = paramViewGroup.getContext();
        p.j(paramViewGroup, "tabView.context");
        f.a((f)com.tencent.mm.ui.component.g.lm(paramViewGroup).i(f.class), "drafttab", 1, null, 4);
      }
      AppMethodBeat.o(263847);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.view.tabcomp.d
  {
    public final View getBackBtn()
    {
      return null;
    }
    
    public final int getLayoutId()
    {
      return b.g.finder_profile_ui;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "()V", "onTabSelected", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabUnSelected", "plugin-finder_release"})
  public static final class e
    extends e
  {
    public final void a(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.a parama)
    {
      AppMethodBeat.i(266034);
      p.k(paramContext, "context");
      p.k(parama, "tab");
      super.a(paramContext, parama);
      parama.rx(true);
      AppMethodBeat.o(266034);
    }
    
    public final void b(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.a parama)
    {
      AppMethodBeat.i(266035);
      p.k(paramContext, "context");
      p.k(parama, "tab");
      super.b(paramContext, parama);
      parama.rx(false);
      AppMethodBeat.o(266035);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkMusicTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.an.i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(227502);
      h.aGY().b(6628, (com.tencent.mm.an.i)this);
      if ((paramq instanceof by))
      {
        if ((p.h(((by)paramq).whH, FinderProfileTabUIC.e(this.zTv)) ^ true))
        {
          AppMethodBeat.o(227502);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramInt2 == -1234)
          {
            Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab MM_ERR_DROP_CGI_BY_BUSINESS");
            FinderProfileTabUIC.i(this.zTv);
            AppMethodBeat.o(227502);
            return;
          }
          if (paramInt2 == 0)
          {
            if (!((Collection)((by)paramq).doA()).isEmpty()) {}
            for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab items not empty");
              FinderProfileTabUIC.i(this.zTv);
              AppMethodBeat.o(227502);
              return;
            }
            if ((p.h(FinderProfileTabUIC.e(this.zTv), FinderProfileTabUIC.j(this.zTv))) && (FinderProfileTabUIC.k(this.zTv)))
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab self mv posting");
              FinderProfileTabUIC.i(this.zTv);
              AppMethodBeat.o(227502);
              return;
            }
            if (((by)paramq).doA().isEmpty())
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: remove music tab items  empty");
              FinderProfileTabUIC.a(this.zTv);
            }
          }
        }
      }
      AppMethodBeat.o(227502);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkShopTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.an.i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(268717);
      h.aGY().b(5244, (com.tencent.mm.an.i)this);
      if ((paramq instanceof bw))
      {
        if ((p.h(((bw)paramq).finderUsername, FinderProfileTabUIC.e(this.zTv)) ^ true))
        {
          AppMethodBeat.o(268717);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FinderProfileTabUIC.a(this.zTv, (bw)paramq);
          Object localObject = (Iterable)((bw)paramq).doz();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new bp((blm)((Iterator)localObject).next()));
          }
          paramString = (List)paramString;
          if (((Collection)paramString).isEmpty()) {
            break label198;
          }
        }
      }
      label198:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString, paramq));
        }
        AppMethodBeat.o(268717);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileTabUIC.j paramj, List paramList, com.tencent.mm.an.q paramq)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    k(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    l(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    m(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$5$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    o(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$6", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.an.i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(287206);
      h.aGY().b(3736, (com.tencent.mm.an.i)this);
      if ((paramq instanceof cr))
      {
        if ((p.h(((cr)paramq).xcq, FinderProfileTabUIC.e(this.zTv)) ^ true))
        {
          AppMethodBeat.o(287206);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (!Util.isNullOrNil(((cr)paramq).xcV)))
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add long video tab back");
          this.zTv.dOS();
        }
      }
      AppMethodBeat.o(287206);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    q(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(FinderProfileTabUIC paramFinderProfileTabUIC, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    s(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class u
    implements com.tencent.mm.ui.widget.a.g.a
  {
    u(FinderProfileTabUIC paramFinderProfileTabUIC, com.tencent.mm.ui.widget.a.g paramg) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(288976);
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.Vyv, "");
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(288976);
        throw ((Throwable)localObject1);
      }
      localObject1 = (String)localObject1;
      Object localObject2 = h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.Vyw, "");
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(288976);
        throw ((Throwable)localObject1);
      }
      localObject2 = (String)localObject2;
      Log.i("Finder.FinderProfileTabUIC", "showShopOpGuideDialog right btn click, bindAppId:" + (String)localObject1 + ",bindPath:" + (String)localObject2 + '!');
      CharSequence localCharSequence = (CharSequence)localObject1;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          localCharSequence = (CharSequence)localObject2;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label235;
          }
        }
      }
      label235:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject1 = FinderProfileTabUIC.g(this.zTv);
          localObject2 = FinderProfileTabUIC.h(this.zTv);
        }
        FinderProfileTabUIC.a(this.zTv, (String)localObject1, (String)localObject2);
        this.kvu.bYF();
        AppMethodBeat.o(288976);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    v(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC
 * JD-Core Version:    0.7.0.1
 */