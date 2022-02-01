package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderEmojiListLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmojiListLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.FinderEmojiSelectUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "emojiAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "emojiLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader;", "getEmojiLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader;", "emojiLoader$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "stateLayout", "Landroid/widget/FrameLayout;", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "getDesignerUin", "", "getLayoutId", "handleOnItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "initData", "initLoading", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
{
  public static final a GNX;
  private RefreshLoadMoreLayout ATx;
  private final bui Auc;
  private final kotlin.j BlK;
  private final kotlin.j CNQ;
  private final kotlin.j FcQ;
  private FrameLayout FcY;
  private WxRecyclerAdapter<cc> GNY;
  private final kotlin.j GNZ;
  
  static
  {
    AppMethodBeat.i(337828);
    GNX = new a((byte)0);
    AppMethodBeat.o(337828);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337756);
    this.CNQ = kotlin.k.cm((a)new i(this));
    this.FcQ = kotlin.k.cm((a)new c(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.k.aeZF;
    this.Auc = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou();
    this.GNZ = kotlin.k.cm((a)new d(this));
    this.BlK = kotlin.k.cm((a)new j(this));
    AppMethodBeat.o(337756);
  }
  
  public m(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337761);
    this.CNQ = kotlin.k.cm((a)new i(this));
    this.FcQ = kotlin.k.cm((a)new c(this));
    paramFragment = com.tencent.mm.ui.component.k.aeZF;
    this.Auc = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou();
    this.GNZ = kotlin.k.cm((a)new d(this));
    this.BlK = kotlin.k.cm((a)new j(this));
    AppMethodBeat.o(337761);
  }
  
  private final b fnr()
  {
    AppMethodBeat.i(337743);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(337743);
    return localb;
  }
  
  private final FinderEmojiListLoader fns()
  {
    AppMethodBeat.i(337748);
    FinderEmojiListLoader localFinderEmojiListLoader = (FinderEmojiListLoader)this.GNZ.getValue();
    AppMethodBeat.o(337748);
    return localFinderEmojiListLoader;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_emoji_list_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(337849);
    super.onCreate(paramBundle);
    paramBundle = findViewById(e.e.rl_layout);
    s.s(paramBundle, "findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = findViewById(e.e.emoji_loading_state_container);
    s.s(paramBundle, "findViewById(R.id.emoji_loading_state_container)");
    this.FcY = ((FrameLayout)paramBundle);
    Object localObject = this.ATx;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setEnableRefresh(false);
    localObject = this.ATx;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setSuperNestedScroll(true);
    paramBundle = this.ATx;
    if (paramBundle == null)
    {
      s.bIx("rlLayout");
      paramBundle = null;
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new e(this));
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label419;
      }
      s.bIx("rlLayout");
      paramBundle = null;
      label154:
      localObject = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
      s.s(localObject, "getInflater(activity).in…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject);
      this.GNY = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new f(), (ArrayList)fns().getDataListJustForAdapter(), true);
      paramBundle = this.GNY;
      if (paramBundle != null) {
        break label422;
      }
      s.bIx("emojiAdapter");
      paramBundle = null;
    }
    label419:
    label422:
    for (;;)
    {
      paramBundle.agOe = ((i.c)new g(this));
      RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
      getActivity();
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject = this.GNY;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("emojiAdapter");
        paramBundle = null;
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramBundle);
      fns().BbB = ((a)new h(this));
      localObject = this.FcY;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("stateLayout");
        paramBundle = null;
      }
      paramBundle.setBackgroundResource(e.d.finder_profile_gradient_bg);
      localObject = this.FcY;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("stateLayout");
        paramBundle = null;
      }
      paramBundle.setVisibility(0);
      BaseFeedLoader.requestInit$default((BaseFeedLoader)fns(), false, 1, null);
      fns().requestRefresh();
      fns().register((com.tencent.mm.view.k)fnr());
      AppMethodBeat.o(337849);
      return;
      break;
      break label154;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(337855);
    super.onDestroy();
    fns().unregister((com.tencent.mm.view.k)fnr());
    AppMethodBeat.o(337855);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends b
  {
    public b()
    {
      super();
      AppMethodBeat.i(337467);
      AppMethodBeat.o(337467);
    }
    
    private static final void a(m paramm, b paramb)
    {
      Object localObject3 = null;
      Object localObject4 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
      Object localObject5 = null;
      Object localObject2 = null;
      AppMethodBeat.i(337487);
      s.u(paramm, "this$0");
      s.u(paramb, "this$1");
      Object localObject1 = paramm.getFragment();
      if ((localObject1 != null) && (((Fragment)localObject1).isDetached() == true)) {}
      for (int i = 1; (i != 0) || (paramm.getActivity().isDestroyed()) || (paramm.getActivity().isFinishing()); i = 0)
      {
        AppMethodBeat.o(337487);
        return;
      }
      Log.i("FinderEmojiListUIC", "[updateState] state=" + m.a(paramm).Bfm + " cachedState=" + m.a(paramm).Bfn);
      FrameLayout localFrameLayout = m.d(paramm);
      localObject1 = localFrameLayout;
      if (localFrameLayout == null)
      {
        s.bIx("stateLayout");
        localObject1 = null;
      }
      ((FrameLayout)localObject1).setOnClickListener(null);
      ((FrameLayout)localObject1).setVisibility(8);
      if (m.a(paramm).Bfn == FinderEmojiListLoader.a.Bfp)
      {
        localRefreshLoadMoreLayout = m.b(paramm);
        localObject1 = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          s.bIx("rlLayout");
          localObject1 = null;
        }
        ((RefreshLoadMoreLayout)localObject1).setSuperNestedScroll(false);
        localObject1 = m.a(paramm).Bfm;
        switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          AppMethodBeat.o(337487);
          return;
        case 1: 
          paramm = m.d(paramm);
          if (paramm == null)
          {
            s.bIx("stateLayout");
            paramm = localObject2;
          }
          for (;;)
          {
            paramm.setVisibility(0);
            ((TextView)paramm.findViewById(e.e.tips_no_content)).setVisibility(8);
            ((TextView)paramm.findViewById(e.e.tips_retry)).setVisibility(8);
            ((ProgressBar)paramm.findViewById(e.e.tips_loading)).setVisibility(0);
            AppMethodBeat.o(337487);
            return;
          }
        case 2: 
          paramm = m.d(paramm);
          if (paramm == null)
          {
            s.bIx("stateLayout");
            paramm = localObject3;
          }
          for (;;)
          {
            paramm.setVisibility(0);
            ((TextView)paramm.findViewById(e.e.tips_no_content)).setVisibility(0);
            ((TextView)paramm.findViewById(e.e.tips_retry)).setVisibility(8);
            ((ProgressBar)paramm.findViewById(e.e.tips_loading)).setVisibility(8);
            AppMethodBeat.o(337487);
            return;
          }
        }
        localObject1 = m.d(paramm);
        if (localObject1 == null)
        {
          s.bIx("stateLayout");
          localObject1 = localObject4;
        }
        for (;;)
        {
          ((FrameLayout)localObject1).setVisibility(0);
          ((TextView)((FrameLayout)localObject1).findViewById(e.e.tips_no_content)).setVisibility(8);
          ((TextView)((FrameLayout)localObject1).findViewById(e.e.tips_retry)).setVisibility(0);
          ((ProgressBar)((FrameLayout)localObject1).findViewById(e.e.tips_loading)).setVisibility(8);
          ((FrameLayout)localObject1).setOnClickListener(new m.b..ExternalSyntheticLambda0(paramm, paramb));
          break;
        }
      }
      if ((paramm.getActivity() instanceof FinderProfileUI))
      {
        paramm = m.b(paramm);
        if (paramm == null)
        {
          s.bIx("rlLayout");
          paramm = localRefreshLoadMoreLayout;
        }
        for (;;)
        {
          paramm.setSuperNestedScroll(true);
          AppMethodBeat.o(337487);
          return;
        }
      }
      if ((paramm.getActivity() instanceof FinderEmojiSelectUI))
      {
        paramm = m.b(paramm);
        if (paramm != null) {
          break label560;
        }
        s.bIx("rlLayout");
        paramm = localObject5;
      }
      label560:
      for (;;)
      {
        paramm.setSuperNestedScroll(false);
        AppMethodBeat.o(337487);
        return;
      }
    }
    
    private static final void a(m paramm, b paramb, View paramView)
    {
      AppMethodBeat.i(337471);
      s.u(paramm, "this$0");
      s.u(paramb, "this$1");
      paramView = m.b(paramm);
      paramm = paramView;
      if (paramView == null)
      {
        s.bIx("rlLayout");
        paramm = null;
      }
      RefreshLoadMoreLayout.a(paramm, 0, 3);
      paramb.evt();
      AppMethodBeat.o(337471);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(337502);
      h.ahAA.bk(new m.b..ExternalSyntheticLambda1(m.this, this));
      AppMethodBeat.o(337502);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<m.b>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<FinderEmojiListLoader>
  {
    d(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RefreshLoadMoreLayout.b
  {
    e(m paramm) {}
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(337476);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)m.a(this.GOa), false, 1, null);
      AppMethodBeat.o(337476);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(337457);
      if (paramInt == r.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(337457);
        return localObject;
      }
      Object localObject = av.GiL;
      av.eY("FinderEmojiListUIC", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(337457);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderEmojiListUIC$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    g(m paramm) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<ah>
  {
    h(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements a<RecyclerView>
  {
    i(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements a<String>
  {
    j(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.m
 * JD-Core Version:    0.7.0.1
 */