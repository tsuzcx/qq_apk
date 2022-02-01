package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.cgi.cw;
import com.tencent.mm.plugin.finder.cgi.cy;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.FinderProfileAtFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.i.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.l;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "DEFAULT_APPID", "", "DEFAULT_APPURL", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "checkMusicFirstPage", "", "checkQQMusicFirstPage", "designerUin", "", "isNoSeeAtTab", "()Z", "isPrivateAccount", "isSelf", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", "isSelfScene", "isSelfScene$delegate", "line", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getLine", "()Landroid/view/View;", "line$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "selfUserName", "showShopOpGuide", "targetUsername", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "addAtFeedFragment", "", "addDraftFragment", "addEmojiFragment", "addMusicFragment", "addQQMusicFragment", "checkDraftTab", "checkEmojiTab", "checkHasAtFeed", "checkHasMusic", "checkHasQQMusic", "checkMusicTab", "checkQQMusicTab", "checkReplayLiveTab", "checkShopOpGuide", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts;", "checkShopTab", "checkTabLayoutVisibility", "enterTab", "generateProvider", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "getFragmentBy", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "T", "clazz", "Ljava/lang/Class;", "isAtFeedNotEmpty", "response", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "isEmojiEnabled", "isEnableShowAtFeedFragment", "isEnabledDraft", "isPostingMvExist", "isShouldAddDraftTab", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onShopGuideRightBtnClick", "appId", "appUrl", "removeAtFeedFragment", "clearCache", "removeDraftFragment", "removeEmojiFragment", "removeMusicFragment", "removeQQMusicFragment", "showShopOpGuideDialog", "Companion", "Provider", "Tab", "TabContainer", "TabViewAction", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileTabUIC
  extends FinderTabUIC
{
  private static int FfE;
  public static final a Ffv;
  private final String ACm;
  private final kotlin.j AIq;
  private final kotlin.j BlK;
  private FinderAtFeedLoader Ewt;
  private final kotlin.j FcC;
  private boolean FfA;
  private final String FfB;
  private final String FfC;
  private final String FfD;
  private boolean Ffw;
  private boolean Ffx;
  private final kotlin.j Ffy;
  private final kotlin.j Ffz;
  private int mhB;
  
  static
  {
    AppMethodBeat.i(348797);
    Ffv = new a((byte)0);
    AppMethodBeat.o(348797);
  }
  
  public FinderProfileTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348639);
    this.BlK = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.FcC = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.Ffy = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.Ffz = kotlin.k.cm((kotlin.g.a.a)new s(paramAppCompatActivity));
    Object localObject = new StringBuilder("[Provider] username=").append(getUsername()).append(" isSelf=").append(isSelf()).append(" isSelfFlag=").append(isSelfFlag()).append(" isNoSeeAtTab=");
    av localav = av.GiL;
    localObject = ((StringBuilder)localObject).append(av.aBM(getUsername())).append(" isPrivateAccount=").append(eKm()).append(" profileContact=");
    if (getProfileContact() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderProfileTabUIC", bool);
      localObject = paramAppCompatActivity.getIntent().getStringExtra("finder_username");
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (localObject == null) {
        paramAppCompatActivity = "";
      }
      this.ACm = paramAppCompatActivity;
      this.FfB = com.tencent.mm.model.z.bAW();
      this.FfC = "wx2bff878c51bab23b";
      this.FfD = "pages/index/index";
      AppMethodBeat.o(348639);
      return;
    }
  }
  
  private static final ah a(FinderProfileTabUIC paramFinderProfileTabUIC, b.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(348716);
    kotlin.g.b.s.u(paramFinderProfileTabUIC, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    Log.i("Finder.FinderProfileTabUIC", "checkEmojiTab: " + i + ", " + j);
    parama = (cps)parama.ott;
    if ((i == 0) && (j == 0)) {
      if (parama == null)
      {
        if (bool) {
          break label118;
        }
        paramFinderProfileTabUIC.eKr();
      }
    }
    for (;;)
    {
      paramFinderProfileTabUIC = ah.aiuX;
      AppMethodBeat.o(348716);
      return paramFinderProfileTabUIC;
      parama = parama.Zvf;
      if (parama == null) {
        break;
      }
      bool = parama.isEmpty();
      break;
      label118:
      paramFinderProfileTabUIC.eKs();
      continue;
      if ((i == 4) && (j == 2))
      {
        if (parama == null) {
          bool = false;
        }
        for (;;)
        {
          if (bool) {
            break label178;
          }
          paramFinderProfileTabUIC.eKr();
          break;
          parama = parama.Zvf;
          if (parama == null) {
            bool = false;
          } else {
            bool = parama.isEmpty();
          }
        }
        label178:
        paramFinderProfileTabUIC.eKs();
      }
      else
      {
        paramFinderProfileTabUIC.eKs();
      }
    }
  }
  
  private static final void a(FinderProfileTabUIC paramFinderProfileTabUIC, com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(348708);
    kotlin.g.b.s.u(paramFinderProfileTabUIC, "this$0");
    kotlin.g.b.s.u(paramj, "$dialog");
    Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaq, "");
    if (localObject1 == null)
    {
      paramFinderProfileTabUIC = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(348708);
      throw paramFinderProfileTabUIC;
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adar, "");
    if (localObject2 == null)
    {
      paramFinderProfileTabUIC = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(348708);
      throw paramFinderProfileTabUIC;
    }
    localObject2 = (String)localObject2;
    Log.i("Finder.FinderProfileTabUIC", "showShopOpGuideDialog right btn click, bindAppId:" + (String)localObject1 + ",bindPath:" + (String)localObject2 + '!');
    int i;
    if (((CharSequence)localObject1).length() == 0)
    {
      i = 1;
      if (i == 0)
      {
        if (((CharSequence)localObject2).length() != 0) {
          break label330;
        }
        i = 1;
        label184:
        if (i == 0) {
          break label335;
        }
      }
      localObject1 = paramFinderProfileTabUIC.FfC;
      localObject2 = paramFinderProfileTabUIC.FfD;
    }
    label330:
    label335:
    for (;;)
    {
      Log.i("Finder.FinderProfileTabUIC", "onShopGuideRightBtnClick,enter shop:" + (String)localObject1 + ',' + (String)localObject2);
      String str = "setting:0" + com.tencent.mm.model.z.bAW() + ":0:" + Util.getUuidRandom();
      com.tencent.mm.plugin.finder.report.z.FrZ.b(2L, (String)localObject1, Util.getUuidRandom().toString(), String.valueOf(SystemClock.elapsedRealtimeNanos()), "setting", "");
      com.tencent.mm.plugin.finder.utils.a.GfO.a((Context)paramFinderProfileTabUIC.getContext(), (String)localObject1, (String)localObject2, 1176, str);
      paramj.cyW();
      AppMethodBeat.o(348708);
      return;
      i = 0;
      break;
      i = 0;
      break label184;
    }
  }
  
  private boolean eKk()
  {
    AppMethodBeat.i(348644);
    boolean bool = ((Boolean)this.Ffy.getValue()).booleanValue();
    AppMethodBeat.o(348644);
    return bool;
  }
  
  private View eKl()
  {
    AppMethodBeat.i(348648);
    View localView = (View)this.Ffz.getValue();
    AppMethodBeat.o(348648);
    return localView;
  }
  
  private boolean eKm()
  {
    AppMethodBeat.i(348653);
    aw localaw = aw.Gjk;
    boolean bool = aw.n(getProfileContact());
    AppMethodBeat.o(348653);
    return bool;
  }
  
  private final boolean eKn()
  {
    AppMethodBeat.i(348660);
    if (!eKk())
    {
      if (eKk()) {
        break label80;
      }
      if (eKm())
      {
        if (!eKm()) {
          break label80;
        }
        i.a locala = com.tencent.mm.plugin.finder.upload.action.i.Gde;
        if (!com.tencent.mm.plugin.finder.upload.action.i.a(com.tencent.mm.plugin.finder.upload.action.i.fej(), this.ACm, false, false, 6)) {
          break label80;
        }
      }
    }
    if (!((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu())
    {
      AppMethodBeat.o(348660);
      return true;
    }
    label80:
    AppMethodBeat.o(348660);
    return false;
  }
  
  private final void eKp()
  {
    AppMethodBeat.i(348666);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eWz())
    {
      Log.i("Finder.FinderProfileTabUIC", "checkShopTab unSupport shop tab!");
      AppMethodBeat.o(348666);
      return;
    }
    if (((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu())
    {
      Log.i("Finder.FinderProfileTabUIC", "checkShopTab isTeenMode!");
      AppMethodBeat.o(348666);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(5244, (com.tencent.mm.am.h)new o(this));
    localObject = this.ACm;
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    localObject = new cu((String)localObject, null, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    AppMethodBeat.o(348666);
  }
  
  private final void eKq()
  {
    AppMethodBeat.i(348678);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(348678);
  }
  
  private final void eKr()
  {
    AppMethodBeat.i(348683);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(348683);
  }
  
  private final void eKs()
  {
    AppMethodBeat.i(348691);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new w(this));
    AppMethodBeat.o(348691);
  }
  
  private final boolean eKt()
  {
    AppMethodBeat.i(348696);
    if (!((Collection)com.tencent.mm.plugin.finder.storage.data.k.FNg.bE(14, this.ACm)).isEmpty())
    {
      AppMethodBeat.o(348696);
      return true;
    }
    AppMethodBeat.o(348696);
    return false;
  }
  
  private final com.tencent.mm.plugin.finder.api.m getProfileContact()
  {
    AppMethodBeat.i(348651);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(getUsername());
    AppMethodBeat.o(348651);
    return localObject;
  }
  
  private static final void i(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(348701);
    kotlin.g.b.s.u(paramj, "$dialog");
    Log.i("Finder.FinderProfileTabUIC", "showShopOpGuideDialog left btn click!");
    paramj.cyW();
    AppMethodBeat.o(348701);
  }
  
  public final <T extends FinderHomeTabFragment> FinderHomeTabFragment be(Class<T> paramClass)
  {
    AppMethodBeat.i(348885);
    kotlin.g.b.s.u(paramClass, "clazz");
    Iterator localIterator = ((Iterable)getFragments()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!kotlin.g.b.s.p(((FinderHomeTabFragment)localObject).getClass(), paramClass));
    for (paramClass = localObject;; paramClass = null)
    {
      kotlin.g.b.s.checkNotNull(paramClass);
      paramClass = (FinderHomeTabFragment)paramClass;
      AppMethodBeat.o(348885);
      return paramClass;
    }
  }
  
  public final void eKo()
  {
    AppMethodBeat.i(348853);
    super.eKo();
    Object localObject = getTabContainer().fmB();
    if ((localObject != null) && (((HardTouchableLayout)localObject).getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = eKl();
      if (localObject == null) {
        break label78;
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(348853);
      return;
    }
    localObject = eKl();
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    label78:
    AppMethodBeat.o(348853);
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(348817);
    String str = (String)this.BlK.getValue();
    AppMethodBeat.o(348817);
    return str;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(348825);
    boolean bool = ((Boolean)this.FcC.getValue()).booleanValue();
    AppMethodBeat.o(348825);
    return bool;
  }
  
  public final boolean isSelfFlag()
  {
    AppMethodBeat.i(348820);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(348820);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348842);
    super.onCreate(paramBundle);
    paramBundle = this.dyl;
    if ((paramBundle instanceof FinderViewPager)) {
      ((FinderViewPager)paramBundle).setEnableViewPagerScroll(true);
    }
    Object localObject;
    if ((eKn()) && (!eKt()))
    {
      Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have at item, remove the tab");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this));
      paramBundle = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g.Bks, this.ACm, null);
      paramBundle.BfX = ((kotlin.g.a.b)new t(this));
      localObject = ah.aiuX;
      this.Ewt = paramBundle;
      paramBundle = this.Ewt;
      if (paramBundle != null) {
        paramBundle.onAlive();
      }
      paramBundle = this.Ewt;
      if (paramBundle != null) {
        paramBundle.requestRefresh();
      }
    }
    int i;
    if (((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu())
    {
      Log.i("Finder.FinderProfileTabUIC", "checkLiveTab return for teenMode!");
      if (!((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu()) {
        break label449;
      }
      i = 0;
    }
    label520:
    label551:
    label685:
    for (;;)
    {
      if (i != 0) {
        new com.tencent.mm.emoji.c.e(this.mhB, null).bFJ().g(new FinderProfileTabUIC..ExternalSyntheticLambda2(this));
      }
      eKp();
      if (!((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu())
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eUB().bmg()).intValue() != 0) {
          break label601;
        }
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu())
        {
          com.tencent.mm.kernel.h.aZW().a(6628, (com.tencent.mm.am.h)new l(this));
          paramBundle = this.ACm;
          localObject = this.FfB;
          localk = com.tencent.mm.ui.component.k.aeZF;
          paramBundle = new cw(paramBundle, (String)localObject, null, 0, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramBundle, 0);
        }
        eKo();
        AppMethodBeat.o(348842);
        return;
        com.tencent.mm.kernel.h.aZW().a(5870, (com.tencent.mm.am.h)new n(this));
        paramBundle = this.ACm;
        localObject = this.FfB;
        kotlin.g.b.s.s(localObject, "selfUserName");
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
        paramBundle = new com.tencent.mm.plugin.finder.live.cgi.z(paramBundle, (String)localObject, null, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramBundle, 0);
        break;
        label449:
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        label471:
        int j;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXT().bmg()).intValue() == 1)
        {
          i = 1;
          if (i != 0) {
            this.mhB = -1272779573;
          }
          paramBundle = getProfileContact();
          if (paramBundle == null) {
            break label685;
          }
          paramBundle = paramBundle.field_bindInfoList;
          if (paramBundle == null) {
            break label685;
          }
          paramBundle = paramBundle.bind_info;
          if (paramBundle == null) {
            break label685;
          }
          localObject = ((Iterable)paramBundle).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label596;
          }
          paramBundle = ((Iterator)localObject).next();
          if (((auc)paramBundle).ZEC != 5) {
            break label591;
          }
          j = 1;
          if (j == 0) {
            break label594;
          }
        }
        for (;;)
        {
          paramBundle = (auc)paramBundle;
          if (paramBundle == null) {
            break label685;
          }
          paramBundle = paramBundle.ZEG;
          if (paramBundle == null) {
            break label685;
          }
          this.mhB = paramBundle.aadL;
          i = 1;
          break;
          i = 0;
          break label471;
          label591:
          j = 0;
          break label551;
          label594:
          break label520;
          label596:
          paramBundle = null;
        }
        label601:
        com.tencent.mm.kernel.h.aZW().a(5999, (com.tencent.mm.am.h)new m(this));
        paramBundle = this.ACm;
        localObject = this.FfB;
        localk = com.tencent.mm.ui.component.k.aeZF;
        paramBundle = new cy(0, paramBundle, (String)localObject, null, 0, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramBundle, 0);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348879);
    super.onDestroy();
    FinderAtFeedLoader localFinderAtFeedLoader = this.Ewt;
    if (localFinderAtFeedLoader != null) {
      localFinderAtFeedLoader.onDead();
    }
    AppMethodBeat.o(348879);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348874);
    super.onResume();
    Object localObject1 = getFragments().iterator();
    int i = 0;
    label46:
    label65:
    label77:
    label101:
    Object localObject2;
    if (((Iterator)localObject1).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject1).next() instanceof FinderProfileAtFeedFragment))
      {
        if (i < 0) {
          break label311;
        }
        if (!eKn()) {
          FinderTabUIC.c((FinderTabUIC)this, i);
        }
        localObject1 = getFragments().iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label339;
        }
        if (!((FinderHomeTabFragment)((Iterator)localObject1).next() instanceof FinderProfileDraftFragment)) {
          break label332;
        }
        if (i < 0)
        {
          if ((((com.tencent.mm.plugin.findersdk.a.bw)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bw.class)).aBu()) || (!isSelf()) || (!isSelfFlag())) {
            break label344;
          }
          i = 1;
          label138:
          if (i != 0)
          {
            com.tencent.mm.kernel.h.aZW().a(5801, (com.tencent.mm.am.h)new k(this));
            localObject1 = this.ACm;
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            localObject1 = new cf((String)localObject1, null, 1, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
            com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
          }
        }
        if ((isSelf()) && (this.FfA))
        {
          Log.i("Finder.FinderProfileTabUIC", "checkShopTab after showShopOpGuide!");
          this.FfA = false;
          eKp();
        }
        if (FfE <= 0) {
          break label349;
        }
        i = FfE;
        label255:
        FfE = 0;
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(348874);
      return;
      i += 1;
      break;
      i = -1;
      break label46;
      label311:
      if ((!eKn()) || (!eKt())) {
        break label65;
      }
      eKq();
      break label65;
      label332:
      i += 1;
      break label77;
      label339:
      i = -1;
      break label101;
      label344:
      i = 0;
      break label138;
      label349:
      i = getActivity().getIntent().getIntExtra("key_enter_profile_tab", 0);
      break label255;
      localObject1 = ((Iterable)getFragments()).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (((FinderHomeTabFragment)localObject2 instanceof FinderProfileAtFeedFragment)) {
          ((FinderTabUIC)this).aV(i, false);
        }
        i += 1;
      }
      AppMethodBeat.o(348874);
      return;
      localObject1 = ((Iterable)getFragments()).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (((FinderHomeTabFragment)localObject2 instanceof FinderProfileMusicFragment)) {
          ((FinderTabUIC)this).aV(i, false);
        }
        i += 1;
      }
      AppMethodBeat.o(348874);
      return;
      localObject1 = ((Iterable)getFragments()).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (((FinderHomeTabFragment)localObject2 instanceof FinderProfileDraftFragment)) {
          ((FinderTabUIC)this).aV(i, false);
        }
        i += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Companion;", "", "()V", "TAB_AT_PRIORITY", "", "TAB_DRAFT_PRIORITY", "TAB_EMOJI_PRIORITY", "TAB_MUSIC_PRIORITY", "TAB_QQ_MUSIC_PRIORITY", "TAB_REPLAY_PRIORITY", "TAB_SHOP_PRIORITY", "TAB_VIDEO_PRIORITY", "TAG", "", "chooseEnterTab", "getChooseEnterTab", "()I", "setChooseEnterTab", "(I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;)V", "isDynamic", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends FinderTabProvider
  {
    public b()
    {
      AppMethodBeat.i(348794);
      setTabContainer((n)new FinderProfileTabUIC.d());
      setTabViewAction((com.tencent.mm.plugin.finder.view.tabcomp.m)new FinderProfileTabUIC.e());
      this$1 = new LinkedList();
      Object localObject1 = this.FfF;
      Object localObject2 = new FinderProfileTabUIC.c(e.h.finder_self_profile_feed_media_title);
      ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject2).priority = 10;
      ah localah = ah.aiuX;
      this$1.add(localObject2);
      if (FinderProfileTabUIC.c((FinderProfileTabUIC)localObject1))
      {
        localObject2 = new FinderProfileTabUIC.c(e.h.finder_profile_music_tab_name);
        ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject2).priority = 40;
        localah = ah.aiuX;
        this$1.add(localObject2);
      }
      if (FinderProfileTabUIC.d((FinderProfileTabUIC)localObject1))
      {
        localObject2 = new FinderProfileTabUIC.c(e.h.finder_profile_qq_music_tab_name);
        ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject2).priority = 60;
        localah = ah.aiuX;
        this$1.add(localObject2);
      }
      if (FinderProfileTabUIC.e((FinderProfileTabUIC)localObject1))
      {
        localObject1 = new FinderProfileTabUIC.c(e.h.finder_self_profile_care_feed_title);
        ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject1).priority = 80;
        localObject2 = ah.aiuX;
        this$1.add(localObject1);
      }
      localObject1 = ah.aiuX;
      setTabs((List)this$1);
      this$1 = new LinkedList();
      localObject1 = this.FfF;
      this$1.add(new FinderProfileFeedFragment());
      if (FinderProfileTabUIC.c((FinderProfileTabUIC)localObject1))
      {
        this$1.add(new FinderProfileMusicFragment());
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject2 = com.tencent.mm.ui.component.k.d(((FinderProfileTabUIC)localObject1).getActivity()).q(e.class);
        kotlin.g.b.s.s(localObject2, "UICProvider.of(activity)…rofileEduUIC::class.java)");
        e.a((e)localObject2, "mvtab", 0, null, 6);
      }
      if (FinderProfileTabUIC.d((FinderProfileTabUIC)localObject1)) {
        this$1.add(new FinderProfileQQMusicFragment());
      }
      if (FinderProfileTabUIC.e((FinderProfileTabUIC)localObject1)) {
        this$1.add(new FinderProfileAtFeedFragment());
      }
      localObject1 = ah.aiuX;
      setFragments((List)this$1);
      AppMethodBeat.o(348794);
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getTitleId", "()I", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "getLayoutId", "getTabMargin", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.view.tabcomp.i
  {
    public final int EHx;
    
    public c(int paramInt)
    {
      super();
      this.EHx = paramInt;
    }
    
    public final void F(ViewGroup paramViewGroup)
    {
      com.tencent.mm.ui.component.k localk = null;
      AppMethodBeat.i(348779);
      kotlin.g.b.s.u(paramViewGroup, "tabView");
      super.F(paramViewGroup);
      int i = this.EHx;
      if (i == e.h.finder_activity_title)
      {
        Object localObject = paramViewGroup.getContext();
        if (localObject == null)
        {
          paramViewGroup = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(348779);
          throw paramViewGroup;
        }
        localObject = ((MMActivity)localObject).getIntent().getStringExtra("finder_username");
        com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
        long l;
        if (kotlin.g.b.s.p(localObject, com.tencent.mm.model.z.bAW()))
        {
          l = 1L;
          localObject = as.GSQ;
          paramViewGroup = paramViewGroup.getContext();
          kotlin.g.b.s.s(paramViewGroup, "tabView.context");
          paramViewGroup = as.a.hu(paramViewGroup);
          if (paramViewGroup != null) {
            break label143;
          }
        }
        label143:
        for (paramViewGroup = localk;; paramViewGroup = paramViewGroup.fou())
        {
          com.tencent.mm.plugin.finder.report.z.a(l, "2", 3L, "", paramViewGroup);
          AppMethodBeat.o(348779);
          return;
          l = 0L;
          break;
        }
      }
      if (i == e.h.finder_profile_music_tab_name)
      {
        localk = com.tencent.mm.ui.component.k.aeZF;
        paramViewGroup = paramViewGroup.getContext();
        kotlin.g.b.s.s(paramViewGroup, "tabView.context");
        paramViewGroup = com.tencent.mm.ui.component.k.nq(paramViewGroup).q(e.class);
        kotlin.g.b.s.s(paramViewGroup, "UICProvider.of(tabView.c…rofileEduUIC::class.java)");
        e.a((e)paramViewGroup, "mvtab", 1, null, 4);
        AppMethodBeat.o(348779);
        return;
      }
      if (i == e.h.finder_profile_draft_tab_name)
      {
        localk = com.tencent.mm.ui.component.k.aeZF;
        paramViewGroup = paramViewGroup.getContext();
        kotlin.g.b.s.s(paramViewGroup, "tabView.context");
        paramViewGroup = com.tencent.mm.ui.component.k.nq(paramViewGroup).q(e.class);
        kotlin.g.b.s.s(paramViewGroup, "UICProvider.of(tabView.c…rofileEduUIC::class.java)");
        e.a((e)paramViewGroup, "drafttab", 1, null, 4);
        AppMethodBeat.o(348779);
        return;
      }
      if (i == e.h.finder_profile_emoji_tab_name)
      {
        localk = com.tencent.mm.ui.component.k.aeZF;
        paramViewGroup = paramViewGroup.getContext();
        kotlin.g.b.s.s(paramViewGroup, "tabView.context");
        paramViewGroup = com.tencent.mm.ui.component.k.nq(paramViewGroup).q(e.class);
        kotlin.g.b.s.s(paramViewGroup, "UICProvider.of(tabView.c…rofileEduUIC::class.java)");
        e.a((e)paramViewGroup, "tab_profile_emoji", 1, null, 4);
      }
      AppMethodBeat.o(348779);
    }
    
    public final int[] dTO()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return e.f.finder_profile_normal_tab_text;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.view.tabcomp.j
  {
    public final View getBackBtn()
    {
      return null;
    }
    
    public final int getLayoutId()
    {
      return e.f.finder_profile_ui;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "()V", "onTabSelected", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabUnSelected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends l
  {
    public final void a(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.g paramg)
    {
      AppMethodBeat.i(348796);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramg, "tab");
      super.a(paramContext, paramg);
      paramg.vg(true);
      if (((FinderProfileTabUIC.c)paramg).EHx == e.h.finder_self_profile_feed_title) {
        com.tencent.mm.plugin.finder.report.z.a(com.tencent.mm.plugin.finder.report.z.FrZ, paramContext);
      }
      AppMethodBeat.o(348796);
    }
    
    public final void b(Context paramContext, com.tencent.mm.plugin.finder.view.tabcomp.g paramg)
    {
      AppMethodBeat.i(348802);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramg, "tab");
      super.b(paramContext, paramg);
      paramg.vg(false);
      AppMethodBeat.o(348802);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkDraftTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.am.h
  {
    k(FinderProfileTabUIC paramFinderProfileTabUIC) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(348749);
      com.tencent.mm.kernel.h.aZW().b(5801, (com.tencent.mm.am.h)this);
      if ((paramp instanceof cf))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (Collection)((cf)paramp).dVK();
          if ((paramString == null) || (paramString.isEmpty())) {}
          for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
          {
            FinderProfileTabUIC.l(this.FfF);
            AppMethodBeat.o(348749);
            return;
          }
        }
        FinderProfileTabUIC.k(this.FfF);
      }
      AppMethodBeat.o(348749);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkMusicTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.am.h
  {
    l(FinderProfileTabUIC paramFinderProfileTabUIC) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(348752);
      com.tencent.mm.kernel.h.aZW().b(6628, (com.tencent.mm.am.h)this);
      if ((paramp instanceof cw))
      {
        if (!kotlin.g.b.s.p(((cw)paramp).zDJ, FinderProfileTabUIC.f(this.FfF)))
        {
          AppMethodBeat.o(348752);
          return;
        }
        if (paramInt1 == 0) {
          switch (paramInt2)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(348752);
        return;
        Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab MM_ERR_DROP_CGI_BY_BUSINESS");
        FinderProfileTabUIC.g(this.FfF);
        AppMethodBeat.o(348752);
        return;
        if (!((Collection)((cw)paramp).dWn()).isEmpty()) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab items not empty");
          FinderProfileTabUIC.g(this.FfF);
          AppMethodBeat.o(348752);
          return;
        }
        if ((kotlin.g.b.s.p(FinderProfileTabUIC.f(this.FfF), FinderProfileTabUIC.h(this.FfF))) && (FinderProfileTabUIC.i(this.FfF)))
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab self mv posting");
          FinderProfileTabUIC.g(this.FfF);
          AppMethodBeat.o(348752);
          return;
        }
        if (((cw)paramp).dWn().isEmpty())
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: remove music tab items  empty");
          FinderProfileTabUIC.a(this.FfF);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkQQMusicTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.am.h
  {
    m(FinderProfileTabUIC paramFinderProfileTabUIC) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(348754);
      com.tencent.mm.kernel.h.aZW().b(5999, (com.tencent.mm.am.h)this);
      if ((paramp instanceof cy))
      {
        if (!kotlin.g.b.s.p(((cy)paramp).userName, FinderProfileTabUIC.f(this.FfF)))
        {
          AppMethodBeat.o(348754);
          return;
        }
        if (paramInt1 == 0) {
          switch (paramInt2)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(348754);
        return;
        Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add qq music tab MM_ERR_DROP_CGI_BY_BUSINESS");
        FinderProfileTabUIC.j(this.FfF);
        AppMethodBeat.o(348754);
        return;
        if (!((Collection)((cy)paramp).dWn()).isEmpty()) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add qq music tab items not empty");
          FinderProfileTabUIC.j(this.FfF);
          AppMethodBeat.o(348754);
          return;
        }
        if (((cy)paramp).dWn().isEmpty())
        {
          Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: remove qq music tab items  empty");
          FinderProfileTabUIC.b(this.FfF);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkReplayLiveTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements com.tencent.mm.am.h
  {
    n(FinderProfileTabUIC paramFinderProfileTabUIC) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(348763);
      com.tencent.mm.kernel.h.aZW().b(5870, (com.tencent.mm.am.h)this);
      if ((paramp instanceof com.tencent.mm.plugin.finder.live.cgi.z))
      {
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.live.cgi.z)paramp).ACm, FinderProfileTabUIC.f(this.FfF)))
        {
          Log.i("Finder.FinderProfileTabUIC", "checkLiveTab fail for targetUsername:" + ((com.tencent.mm.plugin.finder.live.cgi.z)paramp).ACm + " != " + FinderProfileTabUIC.f(this.FfF));
          AppMethodBeat.o(348763);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.finder.live.cgi.z)paramp).ehp();
          Log.i("Finder.FinderProfileTabUIC", kotlin.g.b.s.X("checkLiveTab feedList size:", Integer.valueOf(paramString.size())));
          if (((Collection)paramString).isEmpty()) {
            break label176;
          }
        }
      }
      label176:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.FfF, paramString, paramp));
        }
        AppMethodBeat.o(348763);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderProfileTabUIC paramFinderProfileTabUIC, List<? extends FinderObject> paramList, com.tencent.mm.am.p paramp)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkShopTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements com.tencent.mm.am.h
  {
    o(FinderProfileTabUIC paramFinderProfileTabUIC) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(348773);
      com.tencent.mm.kernel.h.aZW().b(5244, (com.tencent.mm.am.h)this);
      if ((paramp instanceof cu))
      {
        if (!kotlin.g.b.s.p(((cu)paramp).finderUsername, FinderProfileTabUIC.f(this.FfF)))
        {
          Log.i("Finder.FinderProfileTabUIC", "checkShopTab targetUsername:" + FinderProfileTabUIC.f(this.FfF) + " but cgi's:" + ((cu)paramp).finderUsername + '!');
          AppMethodBeat.o(348773);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FinderProfileTabUIC.a(this.FfF, (cu)paramp);
          Object localObject = (Iterable)((cu)paramp).dWk();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new com.tencent.mm.plugin.finder.model.bw((bzc)((Iterator)localObject).next()));
          }
          paramString = (List)paramString;
          Log.i("Finder.FinderProfileTabUIC", "checkShopTab feedList size :" + paramString.size() + '!');
          if (!((Collection)paramString).isEmpty()) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.FfF, paramString, paramp));
            AppMethodBeat.o(348773);
            return;
          }
          Log.i("Finder.FinderProfileTabUIC", "checkShopTab cgi resp feedList is empty!");
        }
      }
      AppMethodBeat.o(348773);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderProfileTabUIC paramFinderProfileTabUIC, List<com.tencent.mm.plugin.finder.model.bw> paramList, com.tencent.mm.am.p paramp)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    p(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    q(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    r(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<View>
  {
    s(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    t(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<ah>
  {
    u(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<ah>
  {
    v(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.a<ah>
  {
    w(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.a<ah>
  {
    x(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.a<ah>
  {
    y(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.a<String>
  {
    z(FinderProfileTabUIC paramFinderProfileTabUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC
 * JD-Core Version:    0.7.0.1
 */