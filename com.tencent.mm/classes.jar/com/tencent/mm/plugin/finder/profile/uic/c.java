package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.hs;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.b;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.loader.a.b;
import com.tencent.mm.plugin.finder.loader.a.b.a;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "descView", "Landroid/widget/TextView;", "extraMerger", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "headerView", "Landroid/view/View;", "isAddHeader", "", "isResumed", "isTabVisible", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "loaderScene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "addAtFeedTip", "", "fixStateView", "getLayoutId", "", "jumpToAtFeedManageUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshHeader", "reportMention", "eventCode", "count", "eid", "", "reportMentionExpose", "showManagerAtFeedTip", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class c
  extends i
{
  public static final a zQJ;
  private View mXN;
  private final kotlin.f xDO;
  private FinderAtFeedLoader xLy;
  private boolean zQA;
  private final kotlin.f zQB;
  private final kotlin.f zQC;
  private final kotlin.f zQD;
  private final kotlin.f zQE;
  private final kotlin.f zQF;
  private TextView zQG;
  private com.tencent.mm.plugin.finder.loader.a zQH;
  private final k zQI;
  private boolean zQy;
  private boolean zQz;
  private com.tencent.mm.plugin.finder.feed.model.internal.g zsN;
  
  static
  {
    AppMethodBeat.i(289069);
    zQJ = new a((byte)0);
    AppMethodBeat.o(289069);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(289068);
    this.zQB = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.xDO = kotlin.g.ar((kotlin.g.a.a)new l(paramFragment));
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.zQE = kotlin.g.ar((kotlin.g.a.a)new n(paramFragment));
    this.zQF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.zQI = new k(this);
    AppMethodBeat.o(289068);
  }
  
  private final ae dNm()
  {
    AppMethodBeat.i(289054);
    ae localae = (ae)this.zQB.getValue();
    AppMethodBeat.o(289054);
    return localae;
  }
  
  private final FrameLayout dNn()
  {
    AppMethodBeat.i(289057);
    FrameLayout localFrameLayout = (FrameLayout)this.zQE.getValue();
    AppMethodBeat.o(289057);
    return localFrameLayout;
  }
  
  private final b dNo()
  {
    AppMethodBeat.i(289058);
    b localb = (b)this.zQF.getValue();
    AppMethodBeat.o(289058);
    return localb;
  }
  
  private final void dNp()
  {
    AppMethodBeat.i(289062);
    FinderAtFeedLoader localFinderAtFeedLoader = this.xLy;
    if (localFinderAtFeedLoader == null) {
      p.bGy("feedLoader");
    }
    int i = localFinderAtFeedLoader.getDataListJustForAdapter().size();
    if (i > 0)
    {
      u(0, i, "mentioned_set");
      AppMethodBeat.o(289062);
      return;
    }
    localFinderAtFeedLoader = this.xLy;
    if (localFinderAtFeedLoader == null) {
      p.bGy("feedLoader");
    }
    if (localFinderAtFeedLoader.mentionCount > 0)
    {
      localFinderAtFeedLoader = this.xLy;
      if (localFinderAtFeedLoader == null) {
        p.bGy("feedLoader");
      }
      u(0, localFinderAtFeedLoader.mentionCount, "mentioned_set_ori");
    }
    AppMethodBeat.o(289062);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(289056);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(289056);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(289055);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(289055);
    return localRefreshLoadMoreLayout;
  }
  
  private final void u(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(289067);
    if ((isUserVisibleFocused()) && (this.zQA))
    {
      localObject = this.zsN;
      if (localObject == null) {
        p.bGy("loaderScene");
      }
      if (localObject == com.tencent.mm.plugin.finder.feed.model.internal.g.xKC) {}
    }
    else
    {
      AppMethodBeat.o(289067);
      return;
    }
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("count", paramInt2);
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "JSONObject().apply {\n   …unt)\n        }.toString()");
    n localn = n.zWF;
    n.a(paramInt1, paramString, (String)localObject, getContextObj());
    AppMethodBeat.o(289067);
  }
  
  public final void dNq()
  {
    AppMethodBeat.i(289063);
    Object localObject1 = this.xLy;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    if (((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size() > 0)
    {
      Object localObject2;
      Object localObject3;
      int i;
      if (!this.zQy)
      {
        localObject2 = ad.kS((Context)getActivity()).inflate(b.g.finder_profile_feed_at_manage_item, null);
        if (localObject2 != null) {}
        for (localObject1 = (TextView)((View)localObject2).findViewById(b.f.finder_profile_feed_at_item_text);; localObject1 = null)
        {
          this.zQG = ((TextView)localObject1);
          ((View)localObject2).setOnClickListener((View.OnClickListener)new d(this));
          localObject1 = this.zQG;
          if (localObject1 != null)
          {
            localObject3 = getContext().getResources();
            i = b.j.finder_mention_all_result_tip;
            FinderAtFeedLoader localFinderAtFeedLoader = this.xLy;
            if (localFinderAtFeedLoader == null) {
              p.bGy("feedLoader");
            }
            ((TextView)localObject1).setText((CharSequence)((Resources)localObject3).getString(i, new Object[] { Integer.valueOf(localFinderAtFeedLoader.getDataListJustForAdapter().size()) }));
          }
          localObject1 = getRlLayout();
          p.j(localObject2, "headerView");
          HeadFooterLayout.a((HeadFooterLayout)localObject1, (View)localObject2);
          this.zQy = true;
          dNp();
          AppMethodBeat.o(289063);
          return;
        }
      }
      localObject1 = this.zQG;
      if (localObject1 != null)
      {
        localObject2 = getContext().getResources();
        i = b.j.finder_mention_all_result_tip;
        localObject3 = this.xLy;
        if (localObject3 == null) {
          p.bGy("feedLoader");
        }
        ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { Integer.valueOf(((FinderAtFeedLoader)localObject3).getDataListJustForAdapter().size()) }));
        AppMethodBeat.o(289063);
        return;
      }
      AppMethodBeat.o(289063);
      return;
    }
    if (this.zQy)
    {
      localObject1 = this.mXN;
      if (localObject1 != null)
      {
        HeadFooterLayout.b(getRlLayout(), (View)localObject1);
        this.zQy = false;
        AppMethodBeat.o(289063);
        return;
      }
    }
    AppMethodBeat.o(289063);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289059);
    super.onCreate(paramBundle);
    if ((isSelf()) && (isSelfFlag()))
    {
      paramBundle = com.tencent.mm.plugin.finder.feed.model.internal.g.xKC;
      this.zsN = paramBundle;
      paramBundle = this.zsN;
      if (paramBundle == null) {
        p.bGy("loaderScene");
      }
      localObject1 = getUsername();
      p.j(localObject1, "username");
      this.xLy = new FinderAtFeedLoader(paramBundle, (String)localObject1, getContextObj());
      paramBundle = this.xLy;
      if (paramBundle == null) {
        p.bGy("feedLoader");
      }
      paramBundle.register((com.tencent.mm.view.j)dNo());
      paramBundle = getFragment();
      if (paramBundle == null) {
        p.iCn();
      }
      localObject1 = this.xLy;
      if (localObject1 == null) {
        p.bGy("feedLoader");
      }
      paramBundle = new com.tencent.mm.plugin.finder.loader.a(paramBundle, (FinderAtFeedLoader)localObject1);
      paramBundle.zsA = paramBundle.zsC.getDataListJustForAdapter();
      localObject1 = m.xKK;
      localObject1 = (m.c)paramBundle.zsB;
      p.k(localObject1, "observer");
      localObject2 = ((m.c)localObject1).duz();
      if (!m.duy().keySet().contains(localObject2)) {
        break label393;
      }
      localObject2 = (m.b)m.duy().get(localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((m.b)localObject2).xKM;
        if (localObject2 != null) {
          ((List)localObject2).add(localObject1);
        }
      }
      Log.i("Finder.LoaderShareStore", "registerObserver active, register suc");
    }
    for (;;)
    {
      paramBundle.zsB.zsG.alive();
      this.zQH = paramBundle;
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new g(this));
      paramBundle = getRlLayout();
      localObject1 = ad.kS((Context)getActivity()).inflate(b.g.load_more_footer, null);
      p.j(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)this.zQC.getValue());
      getRecyclerView().b(dNm().getItemDecoration());
      paramBundle = getRecyclerView();
      localObject1 = dNm();
      localObject2 = getActivity();
      if (localObject2 != null) {
        break label445;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(289059);
      throw paramBundle;
      paramBundle = com.tencent.mm.plugin.finder.feed.model.internal.g.xKu;
      break;
      label393:
      Map localMap = (Map)m.duy();
      m.b localb = new m.b();
      localb.xKM.add(localObject1);
      localMap.put(localObject2, localb);
      Log.i("Finder.LoaderShareStore", "registerObserver not active, register suc");
    }
    label445:
    paramBundle.setRecycledViewPool(((ae)localObject1).g((MMActivity)localObject2));
    paramBundle = getRecyclerView();
    Object localObject1 = dNm().dtg();
    Object localObject2 = this.xLy;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)localObject1, (ArrayList)((FinderAtFeedLoader)localObject2).getDataListJustForAdapter()));
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new h(this));
    paramBundle = this.zsN;
    if (paramBundle == null) {
      p.bGy("loaderScene");
    }
    if (paramBundle == com.tencent.mm.plugin.finder.feed.model.internal.g.xKC)
    {
      paramBundle = this.xLy;
      if (paramBundle == null) {
        p.bGy("feedLoader");
      }
      paramBundle.xGJ = ((kotlin.g.a.b)new m(this));
    }
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.xEI = ((kotlin.g.a.a)new i(this));
    paramBundle = dNn();
    p.j(paramBundle, "stateLayout");
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(289059);
      throw paramBundle;
    }
    paramBundle = (FrameLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = 0;
    localObject1 = dNn();
    p.j(localObject1, "stateLayout");
    ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    BaseFeedLoader.requestInit$default(paramBundle, false, 1, null);
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.requestRefresh();
    this.zQI.alive();
    AppMethodBeat.o(289059);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289066);
    super.onDestroy();
    Object localObject1;
    if (((c)this).xLy != null)
    {
      localObject1 = this.xLy;
      if (localObject1 == null) {
        p.bGy("feedLoader");
      }
      ((FinderAtFeedLoader)localObject1).unregister((com.tencent.mm.view.j)dNo());
      localObject1 = this.xLy;
      if (localObject1 == null) {
        p.bGy("feedLoader");
      }
      ((FinderAtFeedLoader)localObject1).onDead();
    }
    this.zQI.dead();
    com.tencent.mm.plugin.finder.loader.a locala = this.zQH;
    if (locala != null)
    {
      localObject1 = m.xKK;
      localObject1 = (m.c)locala.zsB;
      p.k(localObject1, "observer");
      String str = ((m.c)localObject1).duz();
      if (m.duy().keySet().contains(str))
      {
        Object localObject2 = (m.b)m.duy().get(str);
        if (localObject2 != null)
        {
          localObject2 = ((m.b)localObject2).xKM;
          if (localObject2 != null)
          {
            if (!((List)localObject2).contains(localObject1)) {
              break label240;
            }
            Log.i("Finder.LoaderShareStore", "unRegisterObserver active, register suc");
            ((List)localObject2).remove(localObject1);
            if (((List)localObject2).isEmpty())
            {
              localObject1 = (m.b)m.duy().get(str);
              if (localObject1 == null) {
                break label235;
              }
              localObject1 = ((m.b)localObject1).xKL;
              if (localObject1 == null) {
                m.duy().remove(str);
              }
            }
          }
        }
      }
      for (;;)
      {
        locala.zsB.zsG.dead();
        AppMethodBeat.o(289066);
        return;
        label235:
        localObject1 = null;
        break;
        label240:
        Log.i("Finder.LoaderShareStore", "unRegisterObserver active, not exit observer");
        continue;
        Log.i("Finder.LoaderShareStore", "unRegisterObserver not active, register fail");
      }
    }
    AppMethodBeat.o(289066);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(289061);
    super.onPause();
    this.zQA = false;
    AppMethodBeat.o(289061);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(289060);
    super.onResume();
    Log.i("Finder.ProfileAtFeedUIC", "desc");
    this.zQA = true;
    TextView localTextView = this.zQG;
    if (localTextView != null)
    {
      Resources localResources = getContext().getResources();
      int i = b.j.finder_mention_all_result_tip;
      FinderAtFeedLoader localFinderAtFeedLoader = this.xLy;
      if (localFinderAtFeedLoader == null) {
        p.bGy("feedLoader");
      }
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(localFinderAtFeedLoader.getDataListJustForAdapter().size()) }));
    }
    dNp();
    AppMethodBeat.o(289060);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(289064);
    super.onUserVisibleFocused();
    h localh = h.IzE;
    if (p.h(getUsername(), z.bdh())) {}
    for (int i = 1;; i = 0)
    {
      localh.a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      this.zQz = true;
      dNp();
      AppMethodBeat.o(289064);
      return;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(289065);
    super.onUserVisibleUnFocused();
    this.zQz = false;
    AppMethodBeat.o(289065);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(271189);
      AppMethodBeat.o(271189);
    }
    
    public final void dFf()
    {
      AppMethodBeat.i(271188);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(271188);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(c.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<c.b>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269582);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$addAtFeedTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.d(this.zQK);
      c.a(this.zQK, c.b(this.zQK).getDataListJustForAdapter().size(), "mentioned_set");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$addAtFeedTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269582);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ae>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(270936);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      c.b(this.zQK).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(270936);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(270939);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(270939);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(270937);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      c.b(this.zQK).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(270937);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(270938);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(270938);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(264427);
      c.e(this.zQK).dFf();
      AppMethodBeat.o(264427);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends IListener<hs>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    l(Fragment paramFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    m(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    n(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.c
 * JD-Core Version:    0.7.0.1
 */