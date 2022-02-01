package com.tencent.mm.plugin.finder.profile.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.FinderProfileAtFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileMegaVideoFragment;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.g.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "checkMusicFirstPage", "", "isNoSeeAtTab", "()Z", "isPrivateAccount", "isSelf", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", "isSelfScene", "isSelfScene$delegate", "line", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getLine", "()Landroid/view/View;", "line$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "selfUserName", "", "targetUsername", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "addAtFeedFragment", "", "addMegaVideoFragment", "addMusicFragment", "checkHasAtFeed", "checkHasMegaVideoItem", "checkFirstPage", "checkHasMusic", "checkMusicTab", "checkTabLayoutVisibility", "generateProvider", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "getFragmentBy", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "T", "clazz", "Ljava/lang/Class;", "isEnableShowAtFeedFragment", "isPostingMvExist", "isShouldAddDraftTab", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeAtFeedFragment", "clearCache", "removeMegaVideoFragment", "removeMusicFragment", "Companion", "Provider", "Tab", "TabContainer", "TabViewAction", "plugin-finder_release"})
public final class FinderProfileTabUIC
  extends FinderTabUIC
{
  public static final a vcI;
  private final kotlin.f tZk;
  private final kotlin.f tZl;
  private final String tvp;
  private final kotlin.f vag;
  private boolean vcD;
  private final kotlin.f vcE;
  private final kotlin.f vcF;
  private FinderAtFeedLoader vcG;
  private final String vcH;
  
  static
  {
    AppMethodBeat.i(250494);
    vcI = new a((byte)0);
    AppMethodBeat.o(250494);
  }
  
  public FinderProfileTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250493);
    this.tZk = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new k(this));
    this.vag = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.vcE = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.vcF = kotlin.g.ah((kotlin.g.a.a)new m(paramAppCompatActivity));
    Object localObject = new StringBuilder("[Provider] username=").append(getUsername()).append(" isSelf=").append(isSelf()).append(" isSelfFlag=").append(isSelfFlag()).append(" isNoSeeAtTab=").append(dnu()).append(" isPrivateAccount=").append(dnv()).append(" profileContact=");
    if (getProfileContact() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderProfileTabUIC", bool);
      localObject = paramAppCompatActivity.getIntent().getStringExtra("finder_username");
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (localObject == null) {
        paramAppCompatActivity = "";
      }
      this.tvp = paramAppCompatActivity;
      this.vcH = z.aUg();
      AppMethodBeat.o(250493);
      return;
    }
  }
  
  private final boolean dnA()
  {
    AppMethodBeat.i(250491);
    if (!((Collection)com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(14, this.tvp)).isEmpty())
    {
      AppMethodBeat.o(250491);
      return true;
    }
    AppMethodBeat.o(250491);
    return false;
  }
  
  private boolean dns()
  {
    AppMethodBeat.i(250476);
    boolean bool = ((Boolean)this.vcE.getValue()).booleanValue();
    AppMethodBeat.o(250476);
    return bool;
  }
  
  private View dnt()
  {
    AppMethodBeat.i(250477);
    View localView = (View)this.vcF.getValue();
    AppMethodBeat.o(250477);
    return localView;
  }
  
  private boolean dnu()
  {
    AppMethodBeat.i(250479);
    y localy = y.vXH;
    boolean bool = y.awr(getUsername());
    AppMethodBeat.o(250479);
    return bool;
  }
  
  private boolean dnv()
  {
    AppMethodBeat.i(250480);
    y localy = y.vXH;
    boolean bool = y.i(getProfileContact());
    AppMethodBeat.o(250480);
    return bool;
  }
  
  private final boolean dnw()
  {
    AppMethodBeat.i(250481);
    if ((!dns()) || (dnu()))
    {
      if (!dns()) {
        if (dnv())
        {
          if (dnv())
          {
            g.a locala = com.tencent.mm.plugin.finder.upload.action.g.vUn;
            if (!com.tencent.mm.plugin.finder.upload.action.g.dBr().asJ(this.tvp)) {}
          }
        }
        else if (dnu()) {}
      }
    }
    else
    {
      AppMethodBeat.o(250481);
      return true;
    }
    AppMethodBeat.o(250481);
    return false;
  }
  
  private final void dnz()
  {
    AppMethodBeat.i(250486);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(250486);
  }
  
  private final com.tencent.mm.plugin.finder.api.g getProfileContact()
  {
    AppMethodBeat.i(250478);
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject = com.tencent.mm.plugin.finder.api.c.a.asG(getUsername());
    AppMethodBeat.o(250478);
    return localObject;
  }
  
  private final boolean nS(boolean paramBoolean)
  {
    AppMethodBeat.i(250489);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() != 1)
    {
      AppMethodBeat.o(250489);
      return false;
    }
    int i;
    if (paramBoolean)
    {
      if (!((Collection)com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(13, this.tvp)).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has mega video first page data");
        AppMethodBeat.o(250489);
        return true;
      }
    }
    if (!dns())
    {
      AppMethodBeat.o(250489);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.a.af(this.tvp, 0, 2147483647);
    if (!((Collection)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label196;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label201;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((FinderItem)((Iterator)localObject).next()).isLongVideo());
      Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has posting mega video");
      AppMethodBeat.o(250489);
      return true;
      i = 0;
      break;
      label196:
      localObject = null;
    }
    label201:
    AppMethodBeat.o(250489);
    return false;
  }
  
  public final <T extends FinderHomeTabFragment> FinderHomeTabFragment aN(Class<T> paramClass)
  {
    AppMethodBeat.i(250492);
    p.h(paramClass, "clazz");
    Iterator localIterator = ((Iterable)getFragments()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j(((FinderHomeTabFragment)localObject).getClass(), paramClass));
    for (paramClass = localObject;; paramClass = null)
    {
      if (paramClass == null) {
        p.hyc();
      }
      paramClass = (FinderHomeTabFragment)paramClass;
      AppMethodBeat.o(250492);
      return paramClass;
    }
  }
  
  public final void dnx()
  {
    AppMethodBeat.i(250483);
    super.dnx();
    Object localObject = getTabContainer().dHK();
    if ((localObject != null) && (((HardTouchableLayout)localObject).getVisibility() == 0))
    {
      localObject = dnt();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(250483);
        return;
      }
      AppMethodBeat.o(250483);
      return;
    }
    localObject = dnt();
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(250483);
      return;
    }
    AppMethodBeat.o(250483);
  }
  
  public final void dny()
  {
    AppMethodBeat.i(250484);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() != 1)
    {
      AppMethodBeat.o(250484);
      return;
    }
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(250484);
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(250473);
    String str = (String)this.tZk.getValue();
    AppMethodBeat.o(250473);
    return str;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(250475);
    boolean bool = ((Boolean)this.vag.getValue()).booleanValue();
    AppMethodBeat.o(250475);
    return bool;
  }
  
  public final boolean isSelfFlag()
  {
    AppMethodBeat.i(250474);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(250474);
    return bool;
  }
  
  public final void nR(final boolean paramBoolean)
  {
    AppMethodBeat.i(250487);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(this, paramBoolean));
    AppMethodBeat.o(250487);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250482);
    super.onCreate(paramBundle);
    paramBundle = this.uO;
    if ((paramBundle instanceof FinderViewPager)) {
      ((FinderViewPager)paramBundle).setEnableViewPagerScroll(true);
    }
    switch (getActivity().getIntent().getIntExtra("key_enter_profile_tab", 0))
    {
    }
    for (;;)
    {
      if (!nS(true))
      {
        Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have mega video item, remove the tab");
        nR(false);
      }
      if ((dnw()) && (!dnA()))
      {
        Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have at item, remove the tab");
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new p(this));
        paramBundle = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e.tYz, this.tvp, null);
        paramBundle.tVa = ((kotlin.g.a.b)new n(this));
        this.vcG = paramBundle;
        paramBundle = this.vcG;
        if (paramBundle != null) {
          paramBundle.onAlive();
        }
        paramBundle = this.vcG;
        if (paramBundle != null) {
          paramBundle.requestRefresh();
        }
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() == 1) && (!MJ(105)))
      {
        com.tencent.mm.kernel.g.azz().a(3736, (i)new o(this));
        paramBundle = com.tencent.mm.kernel.g.azz();
        localObject = this.tvp;
        locala = com.tencent.mm.ui.component.a.PRN;
        paramBundle.b((com.tencent.mm.ak.q)new cn((String)localObject, 0L, null, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx(), 1, 0L, 64));
      }
      com.tencent.mm.kernel.g.azz().a(6628, (i)new i(this));
      paramBundle = this.tvp;
      Object localObject = this.vcH;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      paramBundle = new bv(paramBundle, (String)localObject, null, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramBundle);
      dnx();
      AppMethodBeat.o(250482);
      return;
      paramBundle = ((Iterable)getFragments()).iterator();
      int i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.hxH();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileAtFeedFragment)) {
          aw(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.hxH();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileMegaVideoFragment)) {
          aw(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.hxH();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileMusicFragment)) {
          aw(i, false);
        }
        i += 1;
      }
      paramBundle = ((Iterable)getFragments()).iterator();
      i = 0;
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if (i < 0) {
          j.hxH();
        }
        if (((FinderHomeTabFragment)localObject instanceof FinderProfileDraftFragment)) {
          aw(i, false);
        }
        i += 1;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250490);
    super.onDestroy();
    FinderAtFeedLoader localFinderAtFeedLoader = this.vcG;
    if (localFinderAtFeedLoader != null)
    {
      localFinderAtFeedLoader.onDead();
      AppMethodBeat.o(250490);
      return;
    }
    AppMethodBeat.o(250490);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250488);
    super.onResume();
    Iterator localIterator = getFragments().iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next() instanceof FinderProfileAtFeedFragment))
      {
        label46:
        if (i < 0) {
          break label111;
        }
        if (!dnw()) {
          gx(i, -1);
        }
      }
    }
    for (;;)
    {
      if ((!MJ(105)) && (nS(false)))
      {
        Log.i("Finder.FinderProfileTabUIC", "onResume: add long video tab back because of local item");
        dny();
      }
      AppMethodBeat.o(250488);
      return;
      i += 1;
      break;
      i = -1;
      break label46;
      label111:
      if ((dnw()) && (dnA())) {
        dnz();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;)V", "isDynamic", "", "plugin-finder_release"})
  public final class b
    extends FinderTabProvider
  {
    public b()
    {
      AppMethodBeat.i(250454);
      setTabContainer((com.tencent.mm.plugin.finder.view.tabcomp.g)new FinderProfileTabUIC.d());
      setTabViewAction((com.tencent.mm.plugin.finder.view.tabcomp.f)new FinderProfileTabUIC.e());
      boolean bool = FinderProfileTabUIC.dnB();
      this$1 = new LinkedList();
      this$1.add(new FinderProfileTabUIC.c(2131760537));
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() == 1) {
        this$1.add(new FinderProfileTabUIC.c(2131760617));
      }
      if (FinderProfileTabUIC.b(this.vcJ)) {
        this$1.add(new FinderProfileTabUIC.c(2131760535));
      }
      if (FinderProfileTabUIC.c(this.vcJ)) {
        this$1.add(new FinderProfileTabUIC.c(2131760472));
      }
      if ((this.vcJ.isSelf()) && (bool)) {
        this$1.add(new FinderProfileTabUIC.c(2131760460));
      }
      setTabs((List)this$1);
      this$1 = new LinkedList();
      this$1.add(new FinderProfileFeedFragment());
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() == 1) {
        this$1.add(new FinderProfileMegaVideoFragment());
      }
      if (FinderProfileTabUIC.b(this.vcJ)) {
        this$1.add(new FinderProfileAtFeedFragment());
      }
      if (FinderProfileTabUIC.c(this.vcJ)) {
        this$1.add(new FinderProfileMusicFragment());
      }
      if ((this.vcJ.isSelf()) && (bool)) {
        this$1.add(new FinderProfileDraftFragment());
      }
      setFragments((List)this$1);
      AppMethodBeat.o(250454);
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getTitleId", "()I", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.view.tabcomp.c
  {
    private final int uQk;
    
    public c(int paramInt)
    {
      super();
      this.uQk = paramInt;
    }
    
    public final int[] cXC()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return 2131494595;
    }
    
    public final void t(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(250455);
      p.h(paramViewGroup, "tabView");
      super.t(paramViewGroup);
      long l;
      if (this.uQk == 2131759526)
      {
        Object localObject = paramViewGroup.getContext();
        if (localObject == null)
        {
          paramViewGroup = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(250455);
          throw paramViewGroup;
        }
        localObject = ((MMActivity)localObject).getIntent().getStringExtra("finder_username");
        k localk = k.vfA;
        if (!p.j(localObject, z.aUg())) {
          break label134;
        }
        l = 1L;
        localObject = FinderReporterUIC.wzC;
        paramViewGroup = paramViewGroup.getContext();
        p.g(paramViewGroup, "tabView.context");
        paramViewGroup = FinderReporterUIC.a.fH(paramViewGroup);
        if (paramViewGroup == null) {
          break label139;
        }
      }
      label134:
      label139:
      for (paramViewGroup = paramViewGroup.dIx();; paramViewGroup = null)
      {
        k.a(l, "2", 3L, "", paramViewGroup);
        AppMethodBeat.o(250455);
        return;
        l = 0L;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.view.tabcomp.d
  {
    public final View getBackBtn()
    {
      return null;
    }
    
    public final int getLayoutId()
    {
      return 2131494600;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "()V", "onTabSelected", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabUnSelected", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.plugin.finder.view.tabcomp.e
  {
    public final void a(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.a parama)
    {
      AppMethodBeat.i(250456);
      p.h(paramContext, "context");
      p.h(parama, "tab");
      super.a(paramContext, parama);
      parama.pd(true);
      AppMethodBeat.o(250456);
    }
    
    public final void b(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.a parama)
    {
      AppMethodBeat.i(250457);
      p.h(paramContext, "context");
      p.h(parama, "tab");
      super.b(paramContext, parama);
      parama.pd(false);
      AppMethodBeat.o(250457);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkMusicTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class i
    implements i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(250461);
      com.tencent.mm.kernel.g.azz().b(6628, (i)this);
      if ((paramq instanceof bv))
      {
        if ((p.j(((bv)paramq).sBN, FinderProfileTabUIC.d(this.vcJ)) ^ true))
        {
          AppMethodBeat.o(250461);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramInt2 == -1234)
          {
            Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab MM_ERR_DROP_CGI_BY_BUSINESS");
            FinderProfileTabUIC.f(this.vcJ);
            AppMethodBeat.o(250461);
            return;
          }
          if (paramInt2 == 0)
          {
            if (!((Collection)((bv)paramq).cYL()).isEmpty()) {}
            for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab items not empty");
              FinderProfileTabUIC.f(this.vcJ);
              AppMethodBeat.o(250461);
              return;
            }
            if ((p.j(FinderProfileTabUIC.d(this.vcJ), FinderProfileTabUIC.g(this.vcJ))) && (FinderProfileTabUIC.h(this.vcJ)))
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab self mv posting");
              FinderProfileTabUIC.f(this.vcJ);
              AppMethodBeat.o(250461);
              return;
            }
            if (((bv)paramq).cYL().isEmpty())
            {
              Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: remove music tab items  empty");
              FinderProfileTabUIC.a(this.vcJ);
            }
          }
        }
      }
      AppMethodBeat.o(250461);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    j(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    k(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    l(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$5$1"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    n(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$6", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class o
    implements i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(250467);
      com.tencent.mm.kernel.g.azz().b(3736, (i)this);
      if ((paramq instanceof cn))
      {
        if ((p.j(((cn)paramq).tuH, FinderProfileTabUIC.d(this.vcJ)) ^ true))
        {
          AppMethodBeat.o(250467);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (!Util.isNullOrNil(((cn)paramq).tvo)))
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add long video tab back");
          this.vcJ.dny();
        }
      }
      AppMethodBeat.o(250467);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    p(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    q(FinderProfileTabUIC paramFinderProfileTabUIC, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    s(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC
 * JD-Core Version:    0.7.0.1
 */