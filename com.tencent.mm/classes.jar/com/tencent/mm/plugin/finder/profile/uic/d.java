package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "draftAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getDraftAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setDraftAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "draftLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "getDraftLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "draftLoader$delegate", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "fillRefObjectList", "", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "succCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getLayoutId", "", "initStatusView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onUserVisibleFocused", "showFooter", "showPopupMenu", "draftInfoData", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "anchor", "Landroid/view/View;", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends g
{
  public static final a FcX;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcQ;
  private FrameLayout FcY;
  private WxRecyclerAdapter<cc> FcZ;
  private final kotlin.j Fda;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(349043);
    FcX = new a((byte)0);
    AppMethodBeat.o(349043);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348931);
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new l(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Fda = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(348931);
  }
  
  private static final void a(q paramq, d paramd, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(348980);
    s.u(paramq, "$draftInfoData");
    s.u(paramd, "this$0");
    if (paramMenuItem.getItemId() == 1001)
    {
      long l = paramq.ABX.field_localId;
      com.tencent.mm.plugin.finder.storage.j.FKc.pY(l);
      paramq = com.tencent.mm.ae.d.hF(l);
      paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
      ((e)com.tencent.mm.ui.component.k.d(paramd.getActivity()).q(e.class)).O("draftdelete", 1, paramq);
    }
    AppMethodBeat.o(348980);
  }
  
  private static final void a(d paramd, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(348969);
    s.u(paramd, "this$0");
    paramContextMenu.add(0, 1001, 0, (CharSequence)paramd.getString(e.h.finder_del_fans));
    AppMethodBeat.o(348969);
  }
  
  private final b eIT()
  {
    AppMethodBeat.i(348949);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(348949);
    return localb;
  }
  
  private final void eIV()
  {
    AppMethodBeat.i(348960);
    View localView = getRlLayout().getLoadMoreFooter();
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setBackgroundColor(localView.getResources().getColor(e.b.white));
      Object localObject = localView.findViewById(e.e.load_more_footer_tip_tv);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(e.e.draft_center_text);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)localView.getResources().getString(e.h.finder_draft_footer));
      }
      localView = localView.findViewById(e.e.load_more_footer_end_layout);
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    AppMethodBeat.o(348960);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(348941);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(348941);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348936);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348936);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderProfileDraftLoader eIU()
  {
    AppMethodBeat.i(349065);
    FinderProfileDraftLoader localFinderProfileDraftLoader = (FinderProfileDraftLoader)this.Fda.getValue();
    AppMethodBeat.o(349065);
    return localFinderProfileDraftLoader;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_music_draft_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349095);
    super.onCreate(paramBundle);
    eIU().register((com.tencent.mm.view.k)eIT());
    this.FcY = ((FrameLayout)findViewById(e.e.profile_loading_state_container));
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(e.d.finder_profile_gradient_bg);
    }
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    this.vEV = new com.tencent.mm.ui.widget.b.a((Context)getActivity());
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setEnableLoadMore(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new f(this));
    paramBundle = getRlLayout();
    View localView = af.mU((Context)getActivity()).inflate(e.f.finder_draft_footer, null);
    s.s(localView, "getInflater(activity).in…inder_draft_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    paramBundle = getRecyclerView();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.FcZ = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new g(), (ArrayList)eIU().getDataListJustForAdapter(), true);
    getRecyclerView().setAdapter((RecyclerView.a)this.FcZ);
    paramBundle = this.FcZ;
    if (paramBundle != null) {
      paramBundle.agOe = ((i.c)new h(this));
    }
    paramBundle = this.FcZ;
    if (paramBundle != null) {
      paramBundle.agOd = ((i.d)new i(this));
    }
    eIU().BbB = ((kotlin.g.a.a)new j(this));
    eIU().requestInit(false);
    eIU().requestRefresh();
    AppMethodBeat.o(349095);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349107);
    super.onDestroy();
    eIU().unregister((com.tencent.mm.view.k)eIT());
    AppMethodBeat.o(349107);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(349101);
    super.onUserVisibleFocused();
    AppMethodBeat.o(349101);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$Companion;", "", "()V", "MENU_ID_REMOVE_LIST", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(348836);
      AppMethodBeat.o(348836);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(348847);
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(d.this));
      AppMethodBeat.o(348847);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<d.b>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FinderProfileDraftLoader>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(dtf paramdtf, i parami, d paramd, kotlin.g.a.b<? super dtf, ah> paramb)
    {
      super();
    }
    
    private static final ah a(ah.a parama, LinkedList paramLinkedList, final d paramd, final kotlin.g.a.b paramb, final dtf paramdtf, b.a parama1)
    {
      Object localObject2 = null;
      AppMethodBeat.i(348858);
      s.u(parama, "$succ");
      s.u(paramd, "this$0");
      s.u(paramb, "$succCallback");
      s.u(paramdtf, "$mvTrackData");
      StringBuilder localStringBuilder = new StringBuilder("cgi ");
      Object localObject1;
      if (parama1 == null)
      {
        localObject1 = null;
        Log.i("Finder.FinderProfileDraftUIC", localObject1 + ", " + parama1.errCode);
        if ((parama1 == null) || (parama1.errType != 0) || (parama1.errCode != 0)) {
          break label214;
        }
        localObject1 = (ayl)parama1.ott;
        if (localObject1 != null) {
          break label204;
        }
        localObject1 = localObject2;
        label120:
        if (localObject1 == null) {
          break label214;
        }
        parama1 = (ayl)parama1.ott;
        if (parama1 != null)
        {
          parama1 = parama1.ZJp;
          if (parama1 != null) {
            paramLinkedList.addAll((Collection)parama1);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(parama, paramd, paramb, paramdtf));
        parama = ah.aiuX;
        AppMethodBeat.o(348858);
        return parama;
        localObject1 = Integer.valueOf(parama1.errType);
        break;
        label204:
        localObject1 = ((ayl)localObject1).feedObject;
        break label120;
        label214:
        parama.aiwY = false;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ah.a parama, d paramd, kotlin.g.a.b<? super dtf, ah> paramb, dtf paramdtf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(d paramd) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(348838);
      super.IH(paramInt);
      this.Fdb.eIU().requestRefresh();
      AppMethodBeat.o(348838);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(348850);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      paramd = d.a(this.Fdb).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramd, locala.aYi(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramd.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(348850);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(348860);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.Fdb.eIU(), false, 1, null);
      AppMethodBeat.o(348860);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(348835);
      if (paramInt == q.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.e();
        AppMethodBeat.o(348835);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(348835);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    h(d paramd) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "mvTrackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<dtf, ah>
    {
      a(d paramd, ah.d paramd1)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements i.d<com.tencent.mm.view.recyclerview.j>
  {
    i(d paramd) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    l(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.d
 * JD-Core Version:    0.7.0.1
 */