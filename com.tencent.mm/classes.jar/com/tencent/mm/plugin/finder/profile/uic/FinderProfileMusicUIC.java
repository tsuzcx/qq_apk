package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.convert.ca;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "musicAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "musicLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "getMusicLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "musicLoader$delegate", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicThumbUrl", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initLayout", "", "initLoading", "initPlayParam", "musicObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileMusicUIC
  extends FinderProfileFragmentUIC
{
  public static final a vcy;
  private final kotlin.f tSX;
  private FrameLayout vaG;
  private FrameLayout vaH;
  private final kotlin.f vas;
  private final kotlin.f vau;
  private final kotlin.f vaw;
  private WxRecyclerAdapter<bo> vcu;
  private final kotlin.f vcv;
  private String vcw;
  private axy vcx;
  
  static
  {
    AppMethodBeat.i(250449);
    vcy = new a((byte)0);
    AppMethodBeat.o(250449);
  }
  
  public FinderProfileMusicUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250448);
    this.vas = g.ah((kotlin.g.a.a)new h(this));
    this.tSX = g.ah((kotlin.g.a.a)new k(paramFragment));
    this.vau = g.ah((kotlin.g.a.a)new j(this));
    this.vcv = g.ah((kotlin.g.a.a)new i(this));
    this.vaw = g.ah((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(250448);
  }
  
  private final FinderProfileMusicLoader dnq()
  {
    AppMethodBeat.i(250444);
    FinderProfileMusicLoader localFinderProfileMusicLoader = (FinderProfileMusicLoader)this.vcv.getValue();
    AppMethodBeat.o(250444);
    return localFinderProfileMusicLoader;
  }
  
  private final b dnr()
  {
    AppMethodBeat.i(250445);
    b localb = (b)this.vaw.getValue();
    AppMethodBeat.o(250445);
    return localb;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(250443);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(250443);
    return localRefreshLoadMoreLayout;
  }
  
  public final int getLayoutId()
  {
    return 2131494592;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250446);
    super.onCreate(paramBundle);
    paramBundle = ac.vER;
    ac.dxV();
    dnq().register((j)dnr());
    this.vaG = ((FrameLayout)findViewById(2131304322));
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    paramBundle = getRlLayout();
    View localView = aa.jQ((Context)getActivity()).inflate(2131495297, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    paramBundle = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(this), (ArrayList)dnq().getDataListJustForAdapter(), true);
    paramBundle.RqP = ((g.c)new d(paramBundle, this));
    this.vcu = paramBundle;
    paramBundle = (RecyclerView)this.vau.getValue();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.vcu);
    dnq().tTS = ((kotlin.g.a.a)new g(this));
    this.vaH = ((FrameLayout)findViewById(2131306216));
    paramBundle = this.vaH;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131232704);
    }
    paramBundle = this.vaH;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    BaseFeedLoader.requestInit$default(dnq(), false, 1, null);
    dnq().requestRefresh();
    AppMethodBeat.o(250446);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250447);
    super.onDestroy();
    dnq().unregister((j)dnr());
    AppMethodBeat.o(250447);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(250430);
      AppMethodBeat.o(250430);
    }
    
    public final void dmp()
    {
      AppMethodBeat.i(250429);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(250429);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileMusicUIC.b paramb)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$4$1"})
      static final class a
        implements View.OnClickListener
      {
        a(FinderProfileMusicUIC.b.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(250427);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RefreshLoadMoreLayout.d(FinderProfileMusicUIC.c(this.vcB.vcA.vcz));
          this.vcB.vcA.dmp();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250427);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderProfileMusicUIC.b>
  {
    c(FinderProfileMusicUIC paramFinderProfileMusicUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class d
    implements g.c<h>
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter, FinderProfileMusicUIC paramFinderProfileMusicUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(250433);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(250433);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(250436);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250436);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(250435);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      FinderProfileMusicUIC.a(this.vcz).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(250435);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(250434);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250434);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(250437);
      if (paramInt == bf.class.getName().hashCode())
      {
        Object localObject = new ca();
        ((ca)localObject).tFI = Boolean.valueOf(this.vcz.isSelf());
        localObject = (e)localObject;
        AppMethodBeat.o(250437);
        return localObject;
      }
      p.hyc();
      AppMethodBeat.o(250437);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(FinderProfileMusicUIC paramFinderProfileMusicUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    h(FinderProfileMusicUIC paramFinderProfileMusicUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<FinderProfileMusicLoader>
  {
    i(FinderProfileMusicUIC paramFinderProfileMusicUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    j(FinderProfileMusicUIC paramFinderProfileMusicUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    k(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileMusicUIC
 * JD-Core Version:    0.7.0.1
 */