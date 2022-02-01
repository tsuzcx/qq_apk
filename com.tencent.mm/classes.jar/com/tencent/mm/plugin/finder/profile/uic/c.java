package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.b;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedExtraMerge.atFeedDataObserver.1.updateAtFeedListener.1;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.loader.a.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "descView", "Landroid/widget/TextView;", "extraMerger", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "headerView", "Landroid/view/View;", "isAddHeader", "", "isResumed", "isTabVisible", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "loaderScene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "addAtFeedTip", "", "fixStateView", "getLayoutId", "", "jumpToAtFeedManageUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshHeader", "reportMention", "eventCode", "count", "eid", "", "reportMentionExpose", "showManagerAtFeedTip", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends g
{
  public static final a FcL;
  private final kotlin.j BaO;
  private FinderAtFeedLoader BlJ;
  private final kotlin.j CNQ;
  private final kotlin.j EKZ;
  private com.tencent.mm.plugin.finder.feed.model.internal.g EwC;
  private boolean FcM;
  private boolean FcN;
  private final kotlin.j FcO;
  private final kotlin.j FcP;
  private final kotlin.j FcQ;
  private TextView FcR;
  private com.tencent.mm.plugin.finder.loader.a FcS;
  private final FinderProfileAtFeedUIC.removeFeedEventListener.1 FcT;
  private boolean cqi;
  private View pUv;
  
  static
  {
    AppMethodBeat.i(349074);
    FcL = new a((byte)0);
    AppMethodBeat.o(349074);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348937);
    this.FcO = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new j(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.FcP = kotlin.k.cm((kotlin.g.a.a)new l(paramFragment));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FcT = new FinderProfileAtFeedUIC.removeFeedEventListener.1(this, f.hfK);
    AppMethodBeat.o(348937);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(349014);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.eIS();
    localObject = paramc.BlJ;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("feedLoader");
      paramView = null;
    }
    paramc.y(1, paramView.getDataListJustForAdapter().size(), "mentioned_set");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349014);
  }
  
  private final ai eIN()
  {
    AppMethodBeat.i(348944);
    ai localai = (ai)this.FcO.getValue();
    AppMethodBeat.o(348944);
    return localai;
  }
  
  private final FrameLayout eIO()
  {
    AppMethodBeat.i(348966);
    FrameLayout localFrameLayout = (FrameLayout)this.FcP.getValue();
    AppMethodBeat.o(348966);
    return localFrameLayout;
  }
  
  private final b eIP()
  {
    AppMethodBeat.i(348974);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(348974);
    return localb;
  }
  
  private final void eIQ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348983);
    FinderAtFeedLoader localFinderAtFeedLoader = this.BlJ;
    Object localObject1 = localFinderAtFeedLoader;
    if (localFinderAtFeedLoader == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    int i = ((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size();
    if (i > 0)
    {
      y(0, i, "mentioned_set");
      AppMethodBeat.o(348983);
      return;
    }
    localFinderAtFeedLoader = this.BlJ;
    localObject1 = localFinderAtFeedLoader;
    if (localFinderAtFeedLoader == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    if (((FinderAtFeedLoader)localObject1).mentionCount > 0)
    {
      localObject1 = this.BlJ;
      if (localObject1 != null) {
        break label123;
      }
      s.bIx("feedLoader");
      localObject1 = localObject2;
    }
    label123:
    for (;;)
    {
      y(0, ((FinderAtFeedLoader)localObject1).mentionCount, "mentioned_set_ori");
      AppMethodBeat.o(348983);
      return;
    }
  }
  
  private final void eIS()
  {
    AppMethodBeat.i(348994);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_PARAMS_USERNAME", getUsername());
    localIntent.putExtra("KEY_FINDER_SELF_FLAG", isSelfFlag());
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.r((Activity)getActivity(), localIntent);
    AppMethodBeat.o(348994);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(348958);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(348958);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348951);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348951);
    return localRefreshLoadMoreLayout;
  }
  
  private final void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(349006);
    if ((isUserVisibleFocused()) && (this.cqi))
    {
      localObject2 = this.EwC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("loaderScene");
        localObject1 = null;
      }
      if (localObject1 == com.tencent.mm.plugin.finder.feed.model.internal.g.Bkr) {}
    }
    else
    {
      AppMethodBeat.o(349006);
      return;
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("count", paramInt2);
    localObject1 = ((JSONObject)localObject1).toString();
    s.s(localObject1, "JSONObject().apply {\n   …unt)\n        }.toString()");
    Object localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a(paramInt1, paramString, (String)localObject1, getContextObj());
    AppMethodBeat.o(349006);
  }
  
  public final void eIR()
  {
    Object localObject2 = null;
    AppMethodBeat.i(349137);
    Object localObject3 = this.BlJ;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    Object localObject4;
    Object localObject5;
    int i;
    if (((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size() > 0) {
      if (!this.FcM)
      {
        localObject4 = af.mU((Context)getActivity()).inflate(e.f.finder_profile_feed_at_manage_item, null);
        if (localObject4 == null)
        {
          localObject1 = null;
          this.FcR = ((TextView)localObject1);
          ((View)localObject4).setOnClickListener(new c..ExternalSyntheticLambda0(this));
          localObject5 = this.FcR;
          if (localObject5 != null)
          {
            Resources localResources = getContext().getResources();
            i = e.h.finder_mention_all_result_tip;
            localObject3 = this.BlJ;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("feedLoader");
              localObject1 = null;
            }
            ((TextView)localObject5).setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size()) }));
          }
          localObject1 = getRlLayout();
          s.s(localObject1, "rlLayout");
          localObject1 = (HeadFooterLayout)localObject1;
          s.s(localObject4, "headerView");
          HeadFooterLayout.a((HeadFooterLayout)localObject1, (View)localObject4);
          this.FcM = true;
          eIQ();
          label208:
          localObject3 = this.FcR;
          if (localObject3 != null)
          {
            i = e.e.finder_accessibility_mentioned_count_tag;
            localObject1 = this.BlJ;
            if (localObject1 != null) {
              break label405;
            }
            s.bIx("feedLoader");
            localObject1 = localObject2;
          }
        }
      }
    }
    label405:
    for (;;)
    {
      ((TextView)localObject3).setTag(i, Integer.valueOf(((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size()));
      AppMethodBeat.o(349137);
      return;
      localObject1 = (TextView)((View)localObject4).findViewById(e.e.finder_profile_feed_at_item_text);
      break;
      localObject4 = this.FcR;
      if (localObject4 == null) {
        break label208;
      }
      localObject5 = getContext().getResources();
      i = e.h.finder_mention_all_result_tip;
      localObject3 = this.BlJ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedLoader");
        localObject1 = null;
      }
      ((TextView)localObject4).setText((CharSequence)((Resources)localObject5).getString(i, new Object[] { Integer.valueOf(((FinderAtFeedLoader)localObject1).getDataListJustForAdapter().size()) }));
      break label208;
      if (!this.FcM) {
        break label208;
      }
      localObject1 = this.pUv;
      if (localObject1 == null) {
        break label208;
      }
      localObject3 = getRlLayout();
      s.s(localObject3, "rlLayout");
      HeadFooterLayout.b((HeadFooterLayout)localObject3, (View)localObject1);
      this.FcM = false;
      break label208;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(349112);
    super.onCreate(paramBundle);
    label105:
    Object localObject3;
    label248:
    Object localObject4;
    if ((isSelf()) && (isSelfFlag()))
    {
      paramBundle = com.tencent.mm.plugin.finder.feed.model.internal.g.Bkr;
      this.EwC = paramBundle;
      localObject2 = this.EwC;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("loaderScene");
        paramBundle = null;
      }
      localObject2 = getUsername();
      s.checkNotNull(localObject2);
      s.s(localObject2, "username!!");
      this.BlJ = new FinderAtFeedLoader(paramBundle, (String)localObject2, getContextObj());
      paramBundle = this.BlJ;
      if (paramBundle != null) {
        break label608;
      }
      s.bIx("feedLoader");
      paramBundle = null;
      paramBundle.register((com.tencent.mm.view.k)eIP());
      localObject3 = getFragment();
      s.checkNotNull(localObject3);
      localObject2 = this.BlJ;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        paramBundle = null;
      }
      paramBundle = new com.tencent.mm.plugin.finder.loader.a((Fragment)localObject3, paramBundle);
      paramBundle.Ewu = paramBundle.Ewt.getDataListJustForAdapter();
      localObject2 = m.Bkx;
      localObject2 = (m.c)paramBundle.Ewv;
      s.u(localObject2, "observer");
      localObject3 = ((m.c)localObject2).edY();
      if (!m.edX().keySet().contains(localObject3)) {
        break label611;
      }
      localObject3 = (m.b)m.edX().get(localObject3);
      if (localObject3 != null) {
        ((m.b)localObject3).BkA.add(localObject2);
      }
      Log.i("Finder.LoaderShareStore", "registerObserver active, register suc");
      paramBundle.Ewv.Ewy.alive();
      localObject2 = ah.aiuX;
      this.FcS = paramBundle;
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new f(this));
      paramBundle = getRlLayout();
      localObject2 = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
      s.s(localObject2, "getInflater(activity).in…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject2);
      getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)this.EKZ.getValue());
      getRecyclerView().a(eIN().getItemDecoration());
      getRecyclerView().setRecycledViewPool(eIN().j((MMActivity)getActivity()));
      localObject3 = getRecyclerView();
      localObject4 = eIN().ech();
      localObject2 = this.BlJ;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        paramBundle = null;
      }
      ((RecyclerView)localObject3).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)localObject4, (ArrayList)paramBundle.getDataListJustForAdapter()));
      paramBundle = this.BlJ;
      if (paramBundle != null) {
        break label664;
      }
      s.bIx("feedLoader");
      paramBundle = null;
      label465:
      paramBundle.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new g(this));
      localObject2 = this.EwC;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("loaderScene");
        paramBundle = null;
      }
      if (paramBundle == com.tencent.mm.plugin.finder.feed.model.internal.g.Bkr)
      {
        paramBundle = this.BlJ;
        if (paramBundle != null) {
          break label667;
        }
        s.bIx("feedLoader");
        paramBundle = null;
        label523:
        paramBundle.BfX = ((kotlin.g.a.b)new k(this));
      }
      paramBundle = this.BlJ;
      if (paramBundle != null) {
        break label670;
      }
      s.bIx("feedLoader");
      paramBundle = null;
    }
    label664:
    label667:
    label670:
    for (;;)
    {
      paramBundle.BbB = ((kotlin.g.a.a)new h(this));
      paramBundle = eIO().getLayoutParams();
      if (paramBundle != null) {
        break label673;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(349112);
      throw paramBundle;
      paramBundle = com.tencent.mm.plugin.finder.feed.model.internal.g.Bkj;
      break;
      label608:
      break label105;
      label611:
      localObject4 = (Map)m.edX();
      m.b localb = new m.b();
      localb.BkA.add(localObject2);
      ((Map)localObject4).put(localObject3, localb);
      Log.i("Finder.LoaderShareStore", "registerObserver not active, register suc");
      break label248;
      break label465;
      break label523;
    }
    label673:
    paramBundle = (FrameLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = 0;
    eIO().setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    Object localObject2 = this.BlJ;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedLoader");
      paramBundle = null;
    }
    BaseFeedLoader.requestInit$default((BaseFeedLoader)paramBundle, false, 1, null);
    paramBundle = this.BlJ;
    if (paramBundle == null)
    {
      s.bIx("feedLoader");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.requestRefresh();
      this.FcT.alive();
      AppMethodBeat.o(349112);
      return;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(349160);
    super.onDestroy();
    Object localObject1;
    Object localObject3;
    if (this.BlJ != null)
    {
      localObject1 = this.BlJ;
      if (localObject1 == null)
      {
        s.bIx("feedLoader");
        localObject1 = null;
        ((FinderAtFeedLoader)localObject1).unregister((com.tencent.mm.view.k)eIP());
        localObject3 = this.BlJ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("feedLoader");
          localObject1 = null;
        }
        ((FinderAtFeedLoader)localObject1).onDead();
      }
    }
    else
    {
      this.FcT.dead();
      localObject3 = this.FcS;
      if (localObject3 != null)
      {
        localObject1 = m.Bkx;
        localObject1 = (m.c)((com.tencent.mm.plugin.finder.loader.a)localObject3).Ewv;
        s.u(localObject1, "observer");
        String str = ((m.c)localObject1).edY();
        if (!m.edX().keySet().contains(str)) {
          break label262;
        }
        Object localObject4 = (m.b)m.edX().get(str);
        if (localObject4 != null)
        {
          localObject4 = ((m.b)localObject4).BkA;
          if (!((List)localObject4).contains(localObject1)) {
            break label250;
          }
          Log.i("Finder.LoaderShareStore", "unRegisterObserver active, register suc");
          ((List)localObject4).remove(localObject1);
          if (((List)localObject4).isEmpty())
          {
            localObject1 = (m.b)m.edX().get(str);
            if (localObject1 != null) {
              break label242;
            }
            localObject1 = localObject2;
            label209:
            if (localObject1 == null) {
              m.edX().remove(str);
            }
          }
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.loader.a)localObject3).Ewv.Ewy.dead();
      AppMethodBeat.o(349160);
      return;
      break;
      label242:
      localObject1 = ((m.b)localObject1).Bkz;
      break label209;
      label250:
      Log.i("Finder.LoaderShareStore", "unRegisterObserver active, not exit observer");
      continue;
      label262:
      Log.i("Finder.LoaderShareStore", "unRegisterObserver not active, register fail");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(349127);
    super.onPause();
    this.cqi = false;
    AppMethodBeat.o(349127);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(349118);
    super.onResume();
    Log.i("Finder.ProfileAtFeedUIC", "desc");
    this.cqi = true;
    TextView localTextView = this.FcR;
    if (localTextView != null)
    {
      Resources localResources = getContext().getResources();
      int i = e.h.finder_mention_all_result_tip;
      FinderAtFeedLoader localFinderAtFeedLoader2 = this.BlJ;
      FinderAtFeedLoader localFinderAtFeedLoader1 = localFinderAtFeedLoader2;
      if (localFinderAtFeedLoader2 == null)
      {
        s.bIx("feedLoader");
        localFinderAtFeedLoader1 = null;
      }
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(localFinderAtFeedLoader1.getDataListJustForAdapter().size()) }));
    }
    eIQ();
    AppMethodBeat.o(349118);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(349143);
    super.onUserVisibleFocused();
    h localh = h.OAn;
    if (s.p(getUsername(), com.tencent.mm.model.z.bAW())) {}
    for (int i = 1;; i = 0)
    {
      localh.b(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      this.FcN = true;
      eIQ();
      AppMethodBeat.o(349143);
      return;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(349150);
    super.onUserVisibleUnFocused();
    this.FcN = false;
    AppMethodBeat.o(349150);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(348518);
      AppMethodBeat.o(348518);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(348530);
      d.a(0L, (kotlin.g.a.a)new a(c.this, this));
      AppMethodBeat.o(348530);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(c paramc, c.b paramb)
      {
        super();
      }
      
      private static final void a(c paramc, c.b paramb, View paramView)
      {
        AppMethodBeat.i(348519);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramc);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramc, "this$0");
        s.u(paramb, "this$1");
        paramc = c.c(paramc);
        s.s(paramc, "rlLayout");
        RefreshLoadMoreLayout.a(paramc, 0, 3);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348519);
      }
      
      private static final void b(c paramc, View paramView)
      {
        AppMethodBeat.i(348529);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramc);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramc, "this$0");
        c.e(paramc);
        localObject = c.a(paramc);
        paramView = (View)localObject;
        if (localObject == null)
        {
          s.bIx("feedLoader");
          paramView = null;
        }
        c.a(paramc, paramView.mentionCount, "mentioned_set_ori");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348529);
      }
      
      private static final void b(c paramc, c.b paramb, View paramView)
      {
        AppMethodBeat.i(348536);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramc);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramc, "this$0");
        s.u(paramb, "this$1");
        paramc = c.c(paramc);
        s.s(paramc, "rlLayout");
        RefreshLoadMoreLayout.a(paramc, 0, 3);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348536);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c.b>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ai>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onRefreshBegin", "refreshType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(c paramc) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(348585);
      super.IH(paramInt);
      FinderAtFeedLoader localFinderAtFeedLoader2 = c.a(this.FcU);
      FinderAtFeedLoader localFinderAtFeedLoader1 = localFinderAtFeedLoader2;
      if (localFinderAtFeedLoader2 == null)
      {
        s.bIx("feedLoader");
        localFinderAtFeedLoader1 = null;
      }
      localFinderAtFeedLoader1.requestRefresh();
      AppMethodBeat.o(348585);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(348589);
      super.qI(paramInt);
      FinderAtFeedLoader localFinderAtFeedLoader2 = c.a(this.FcU);
      FinderAtFeedLoader localFinderAtFeedLoader1 = localFinderAtFeedLoader2;
      if (localFinderAtFeedLoader2 == null)
      {
        s.bIx("feedLoader");
        localFinderAtFeedLoader1 = null;
      }
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localFinderAtFeedLoader1, false, 1, null);
      AppMethodBeat.o(348589);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    g(c paramc) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(348584);
      c.b(this.FcU).evt();
      AppMethodBeat.o(348584);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    j(Fragment paramFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    k(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    l(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.c
 * JD-Core Version:    0.7.0.1
 */