package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "musicAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "getMusicLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "musicLoader$delegate", "musicPlayEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicPlayEventListener$1;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicThumbUrl", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initLayout", "", "initLoading", "initPlayParam", "musicObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onPause", "onResume", "processPlayError", "errMsg", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends g
{
  public static final a FeX;
  private final IListener<?> Akp;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcQ;
  private FrameLayout FcY;
  private WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.cc> FeY;
  private final kotlin.j FeZ;
  private String Ffa;
  private boo Ffb;
  private final FinderProfileMusicUIC.musicPlayEventListener.1 Ffc;
  
  static
  {
    AppMethodBeat.i(349018);
    FeX = new a((byte)0);
    AppMethodBeat.o(349018);
  }
  
  public i(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348870);
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new j(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.FeZ = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Ffc = new FinderProfileMusicUIC.musicPlayEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.Akp = ((IListener)new FinderProfileMusicUIC.musicCheckErrorListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(348870);
  }
  
  private final FinderProfileMusicLoader eJZ()
  {
    AppMethodBeat.i(348891);
    FinderProfileMusicLoader localFinderProfileMusicLoader = (FinderProfileMusicLoader)this.FeZ.getValue();
    AppMethodBeat.o(348891);
    return localFinderProfileMusicLoader;
  }
  
  private final b eKa()
  {
    AppMethodBeat.i(348896);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(348896);
    return localb;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348880);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348880);
    return localRefreshLoadMoreLayout;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_music_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349044);
    super.onCreate(paramBundle);
    paramBundle = ac.FLX;
    ac.eZz();
    eJZ().register((com.tencent.mm.view.k)eKa());
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new d(this));
    paramBundle = getRlLayout();
    Object localObject = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
    s.s(localObject, "getInflater(activity).in…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new e(this), (ArrayList)eJZ().getDataListJustForAdapter(), true);
    paramBundle.agOe = ((com.tencent.mm.view.recyclerview.i.c)new f(paramBundle, this));
    localObject = ah.aiuX;
    this.FeY = paramBundle;
    paramBundle = (RecyclerView)this.CNQ.getValue();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.FeY);
    eJZ().BbB = ((kotlin.g.a.a)new g(this));
    this.FcY = ((FrameLayout)findViewById(e.e.profile_loading_state_container));
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(e.d.finder_profile_gradient_bg);
    }
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    BaseFeedLoader.requestInit$default((BaseFeedLoader)eJZ(), false, 1, null);
    eJZ().requestRefresh();
    AppMethodBeat.o(349044);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349061);
    super.onDestroy();
    eJZ().unregister((com.tencent.mm.view.k)eKa());
    AppMethodBeat.o(349061);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(349087);
    super.onPause();
    this.Ffc.dead();
    this.Akp.dead();
    AppMethodBeat.o(349087);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(349073);
    super.onResume();
    this.Ffc.alive();
    this.Akp.alive();
    AppMethodBeat.o(349073);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(348981);
      AppMethodBeat.o(348981);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(348997);
      d.a(0L, (kotlin.g.a.a)new a(i.this, this));
      AppMethodBeat.o(348997);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(i parami, i.b paramb)
      {
        super();
      }
      
      private static final void a(i parami, i.b paramb, View paramView)
      {
        AppMethodBeat.i(349026);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(parami);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(parami, "this$0");
        s.u(paramb, "this$1");
        parami = i.b(parami);
        s.s(parami, "rlLayout");
        RefreshLoadMoreLayout.a(parami, 0, 3);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(349026);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<i.b>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(i parami) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(348967);
      super.IH(paramInt);
      AppMethodBeat.o(348967);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(348977);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      AppMethodBeat.o(348977);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(348985);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)i.a(this.Ffd), false, 1, null);
      AppMethodBeat.o(348985);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.view.recyclerview.g
  {
    e(i parami) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(348965);
      if (paramInt == bm.class.getName().hashCode())
      {
        localObject = new com.tencent.mm.plugin.finder.convert.cc();
        ((com.tencent.mm.plugin.finder.convert.cc)localObject).ALZ = Boolean.valueOf(this.Ffd.isSelfFlag());
        localObject = (com.tencent.mm.view.recyclerview.f)localObject;
        AppMethodBeat.o(348965);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(348965);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.view.recyclerview.i.c<com.tencent.mm.view.recyclerview.j>
  {
    f(WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.cc> paramWxRecyclerAdapter, i parami) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<FinderProfileMusicLoader>
  {
    h(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    i(i parami)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.i
 * JD-Core Version:    0.7.0.1
 */