package com.tencent.mm.plugin.finder.biz;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.br.a;
import com.tencent.mm.plugin.findersdk.a.r;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileFragment;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShowInBizService$IFinderFragment;", "Lcom/tencent/mm/plugin/findersdk/api/IBizProfileFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileContract$Presenter;", "bizUsername", "", "readFeedId", "", "(Ljava/lang/String;J)V", "enterTimestamp", "feedLoader", "Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;)V", "isClicking", "", "()Z", "setClicking", "(Z)V", "isFragmentVisible", "justWatchedBtn", "Landroid/view/View;", "getJustWatchedBtn", "()Landroid/view/View;", "justWatchedBtn$delegate", "Lkotlin/Lazy;", "justWatchedHasClick", "justWatchedIcon", "getJustWatchedIcon", "justWatchedIcon$delegate", "justWatchedLoading", "getJustWatchedLoading", "justWatchedLoading$delegate", "postToSetVisible", "presenter", "scrollToPositionAfterJustWatched", "Lkotlin/Function1;", "", "", "viewCallback", "btnGone", "goneWithoutStatusChange", "btnShow", "getFragment", "Landroidx/fragment/app/Fragment;", "getLayoutId", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "isVideoTab", "jumpToJustWatched", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppBarLayoutExpand", "onStop", "report21874", "report21875ForJustWatched", "eid", "action", "source", "setInvisible", "setVisible", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBizProfileFragment
  extends FinderBaseGridFeedFragment<a.b, a.a>
  implements br.a, r
{
  public static final a AxE;
  private final long AxF;
  private a.a AxG;
  private a.b AxH;
  public FinderBizProfileLoader AxI;
  private boolean AxJ;
  private long AxK;
  private boolean AxL;
  private final kotlin.j AxM;
  private final kotlin.j AxN;
  private final kotlin.j AxO;
  private boolean AxP;
  private final kotlin.g.a.b<Integer, ah> AxQ;
  boolean AxR;
  private final String hUQ;
  
  static
  {
    AppMethodBeat.i(330621);
    AxE = new a((byte)0);
    AppMethodBeat.o(330621);
  }
  
  public FinderBizProfileFragment(String paramString, long paramLong)
  {
    AppMethodBeat.i(330519);
    this.hUQ = paramString;
    this.AxF = paramLong;
    this.AxM = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.AxN = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.AxO = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.AxQ = ((kotlin.g.a.b)new k(this));
    AppMethodBeat.o(330519);
  }
  
  private static final void a(FinderBizProfileFragment paramFinderBizProfileFragment, View paramView)
  {
    AppMethodBeat.i(330571);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderBizProfileFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderBizProfileFragment, "this$0");
    paramFinderBizProfileFragment.eu("channel_profile_recentviewed", 1);
    paramFinderBizProfileFragment.dUS().setVisibility(8);
    paramFinderBizProfileFragment.dUT().setVisibility(0);
    paramFinderBizProfileFragment.AxR = true;
    paramFinderBizProfileFragment.dUZ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330571);
  }
  
  private final View dUR()
  {
    AppMethodBeat.i(330522);
    Object localObject = this.AxM.getValue();
    s.s(localObject, "<get-justWatchedBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(330522);
    return localObject;
  }
  
  private final View dUS()
  {
    AppMethodBeat.i(330530);
    Object localObject = this.AxN.getValue();
    s.s(localObject, "<get-justWatchedIcon>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(330530);
    return localObject;
  }
  
  private final View dUT()
  {
    AppMethodBeat.i(330538);
    Object localObject = this.AxO.getValue();
    s.s(localObject, "<get-justWatchedLoading>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(330538);
    return localObject;
  }
  
  private final void dUY()
  {
    AppMethodBeat.i(330548);
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getActivity());
    Object localObject2;
    label41:
    String str1;
    label51:
    int i;
    label58:
    long l2;
    Object localObject3;
    int j;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label234;
      }
      localObject1 = "";
      if (localObject2 != null) {
        break label257;
      }
      str1 = "";
      if (localObject2 != null) {
        break label280;
      }
      i = 0;
      l2 = System.currentTimeMillis();
      localObject3 = new JSONObject();
      if (!this.AxJ) {
        break label289;
      }
      j = 0;
      label81:
      if (!this.AxJ) {
        break label294;
      }
    }
    label257:
    label280:
    label289:
    label294:
    for (long l1 = 0L;; l1 = com.tencent.mm.model.cn.bDw() - this.AxK)
    {
      ((JSONObject)localObject3).put("biz_username", this.hUQ);
      localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
      String str2 = z.bAW();
      localObject3 = ((JSONObject)localObject3).toString();
      s.s(localObject3, "udf_kv.toString()");
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(21874, new Object[] { localObject1, str1, Integer.valueOf(119), Integer.valueOf(j), String.valueOf(l2), str2, n.bV((String)localObject3, ",", ";"), "", Integer.valueOf(i), Long.valueOf(l1) });
      AppMethodBeat.o(330548);
      return;
      localObject2 = ((as)localObject1).fou();
      break;
      label234:
      localObject1 = ((bui)localObject2).sessionId;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label41;
      }
      break label41;
      str1 = ((bui)localObject2).zIO;
      if (str1 == null)
      {
        str1 = "";
        break label51;
      }
      break label51;
      i = ((bui)localObject2).hLK;
      break label58;
      j = 1;
      break label81;
    }
  }
  
  private final void dUZ()
  {
    AppMethodBeat.i(330550);
    FinderBizProfileLoader localFinderBizProfileLoader = dUQ();
    kotlin.g.a.b localb = (kotlin.g.a.b)new g(this);
    s.u(localb, "justWatchedCallback");
    if (localFinderBizProfileLoader.AxX != 0L)
    {
      localFinderBizProfileLoader.AxZ = localb;
      Object localObject1 = (Iterable)localFinderBizProfileLoader.getDataList();
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (cc)localObject2;
        if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == localFinderBizProfileLoader.AxX))
        {
          localb.invoke(Integer.valueOf(i));
          AppMethodBeat.o(330550);
          return;
        }
        i += 1;
      }
      localFinderBizProfileLoader.dVc();
    }
    AppMethodBeat.o(330550);
  }
  
  private final void eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(330565);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("source", 2);
    String str2 = ((JSONObject)localObject).toString();
    s.s(str2, "JSONObject().apply {\n   …rce)\n        }.toString()");
    String str3 = ((d)com.tencent.mm.kernel.h.ax(d.class)).dHN();
    String str1 = getActivity().getIntent().getStringExtra("key_context_id");
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str3, localObject, Integer.valueOf(119), Integer.valueOf(paramInt), String.valueOf(l), str2, paramString });
    AppMethodBeat.o(330565);
  }
  
  private final void pI(boolean paramBoolean)
  {
    AppMethodBeat.i(330555);
    if (dUR().getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, dUR().getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      dUR().startAnimation((Animation)localTranslateAnimation);
      dUR().setVisibility(4);
      if (!paramBoolean)
      {
        dUS().setVisibility(0);
        dUT().setVisibility(8);
      }
      this.AxR = false;
      dUQ().AxY = false;
    }
    AppMethodBeat.o(330555);
  }
  
  public final FinderBizProfileLoader dUQ()
  {
    AppMethodBeat.i(330634);
    FinderBizProfileLoader localFinderBizProfileLoader = this.AxI;
    if (localFinderBizProfileLoader != null)
    {
      AppMethodBeat.o(330634);
      return localFinderBizProfileLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(330634);
    return null;
  }
  
  public final void dUU()
  {
    AppMethodBeat.i(330669);
    Object localObject2 = this.AxH;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((c.b)localObject1).ATx.getRecyclerView();
    localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(330669);
  }
  
  public final boolean dUV()
  {
    return true;
  }
  
  public final void dUW()
  {
    Object localObject2 = null;
    AppMethodBeat.i(330679);
    Object localObject3 = this.AxH;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject3 = ((c.b)localObject1).ATx;
    localObject1 = this.AxH;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject3).onStopNestedScroll((View)((c.b)localObject1).ATx.getRecyclerView());
      if (this.AxJ)
      {
        this.AxJ = false;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)getActivity());
        if (localObject1 != null) {
          ((as)localObject1).onUserVisibleUnFocused();
        }
        dUY();
      }
      AppMethodBeat.o(330679);
      return;
    }
  }
  
  public final void dUX()
  {
    AppMethodBeat.i(330692);
    if (!this.AxJ)
    {
      if (this.AxG == null)
      {
        this.AxL = true;
        AppMethodBeat.o(330692);
        return;
      }
      this.AxJ = true;
      Object localObject = as.GSQ;
      localObject = as.a.hu((Context)getActivity());
      if (localObject != null) {
        ((as)localObject).onUserVisibleFocused();
      }
      this.AxK = com.tencent.mm.model.cn.bDw();
      dUY();
    }
    AppMethodBeat.o(330692);
  }
  
  public final Fragment getFragment()
  {
    return (Fragment)this;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_biz_profile_feed_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(330652);
    if (Util.isNullOrNil(getActivity().getIntent().getStringExtra("key_context_id"))) {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(5, 18, 119, getActivity().getIntent());
    }
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getActivity());
    if (localObject1 != null) {
      ((as)localObject1).iI(119, 3);
    }
    localObject1 = this.hUQ;
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderBizProfileLoader((String)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)getActivity()).q(as.class)).fou());
    ((FinderBizProfileLoader)localObject1).AxX = this.AxF;
    ((FinderBizProfileLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new b(this));
    ((FinderBizProfileLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.AxI = ((FinderBizProfileLoader)localObject1);
    this.AxG = new a.a(getActivity(), (BaseFinderFeedLoader)dUQ());
    localObject1 = new a.b(this.hUQ, getActivity(), (byte)0);
    localObject2 = (m)new f(this);
    Object localObject3 = (kotlin.g.a.a)new e(this);
    ((c.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)new d((a.b)localObject1, (m)localObject2, (kotlin.g.a.a)localObject3));
    localObject2 = ah.aiuX;
    this.AxH = ((a.b)localObject1);
    localObject1 = this.AxH;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = this.AxG;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((a.b)localObject1).a((c.a)localObject2);
      dUR().setOnClickListener(new FinderBizProfileFragment..ExternalSyntheticLambda0(this));
      if (this.AxL) {
        dUX();
      }
      AppMethodBeat.o(330652);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(330659);
    if ((paramInt1 == 10010) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject2 = this.AxG;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      s.u(paramIntent, "data");
      localObject2 = localObject1.ATE;
      if (localObject2 != null)
      {
        localObject2 = ((c.b)localObject2).ATx.getRecyclerView();
        if (localObject2 != null)
        {
          av localav = av.GiL;
          av.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)localObject1.ALH);
        }
      }
    }
    AppMethodBeat.o(330659);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(330687);
    super.onStop();
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)getActivity());
    if (localObject != null) {
      ((as)localObject).onPreDestroyed();
    }
    AppMethodBeat.o(330687);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    b(FinderBizProfileFragment paramFinderBizProfileFragment) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(330494);
      Object localObject3 = FinderBizProfileFragment.c(this.AxS);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((a.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject3 = this.AxS;
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderBizProfileFragment.c((FinderBizProfileFragment)localObject3);
        if (localObject1 != null) {
          break label92;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      label92:
      for (;;)
      {
        localObject1 = ((c.b)localObject1).ATx.getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setVisibility(0);
        }
        AppMethodBeat.o(330494);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(a.b paramb, m<? super Integer, ? super Integer, ah> paramm, kotlin.g.a.a<ah> parama) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330499);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(330499);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330491);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
        AppMethodBeat.o(330491);
        throw paramRecyclerView;
      }
      paramRecyclerView = ((StaggeredGridLayoutManager)paramRecyclerView).Lc();
      paramInt1 = Math.min(paramRecyclerView[0], paramRecyclerView[1]);
      if (paramInt1 >= this.AxT.AxC) {
        this.AxU.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + 1));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/biz/FinderBizProfileFragment$initOnCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(330491);
        return;
        this.AxV.invoke();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "position1", "", "position2"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Integer, Integer, ah>
  {
    f(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    g(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<View>
  {
    h(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<View>
  {
    j(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    k(FinderBizProfileFragment paramFinderBizProfileFragment)
    {
      super();
    }
    
    private static final void e(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330477);
      s.u(paramRecyclerView, "$it");
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if (localLayoutManager == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
        AppMethodBeat.o(330477);
        throw paramRecyclerView;
      }
      ((FinderStaggeredGridLayoutManager)localLayoutManager).u(paramRecyclerView, paramInt);
      AppMethodBeat.o(330477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.biz.FinderBizProfileFragment
 * JD-Core Version:    0.7.0.1
 */