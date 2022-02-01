package com.tencent.mm.chatting;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "convAdapter", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "getConvAdapter", "()Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "convAdapter$delegate", "Lkotlin/Lazy;", "convEmptyView", "Landroid/view/View;", "getConvEmptyView", "()Landroid/view/View;", "convEmptyView$delegate", "convLoadingView", "getConvLoadingView", "convLoadingView$delegate", "convRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getConvRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "convRecyclerView$delegate", "convRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getConvRefreshLoadMoreLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "convRefreshLoadMoreLayout$delegate", "dataSource", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;)V", "readyChattingUIC", "Lcom/tencent/mm/chatting/ReadyChattingUIC;", "getReadyChattingUIC", "()Lcom/tencent/mm/chatting/ReadyChattingUIC;", "setReadyChattingUIC", "(Lcom/tencent/mm/chatting/ReadyChattingUIC;)V", "timeStampOnEnter", "", "afterPageEnter", "", "checkEmpty", "getAdapter", "getContactStorageList", "", "Lcom/tencent/mm/sdk/storage/MStorage;", "getConversationDataSource", "getEmptyView", "getFirstPageCount", "", "getLoadingView", "getRecyclerView", "getRefreshLoadMoreLayout", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewCreated", "view", "reportEnterDuration", "duration", "BasePrivateMsgConvAdapter", "ConversationHolder", "IConversationDataSource", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BasePrivateMsgConvListFragment<CONVERSATION extends IAutoDBItem>
  extends UIComponentFragment
{
  private final j lPA = kotlin.k.cm((a)new h(this));
  private final j lPB = kotlin.k.cm((a)new d(this));
  private long lPC;
  public b lPD;
  public c<CONVERSATION> lPw;
  private final j lPx = kotlin.k.cm((a)new g(this));
  private final j lPy = kotlin.k.cm((a)new f(this));
  private final j lPz = kotlin.k.cm((a)new e(this));
  
  private static final void a(BasePrivateMsgConvListFragment paramBasePrivateMsgConvListFragment)
  {
    s.u(paramBasePrivateMsgConvListFragment, "this$0");
    paramBasePrivateMsgConvListFragment.aND().setVisibility(0);
    List localList = paramBasePrivateMsgConvListFragment.aNC().aNQ();
    paramBasePrivateMsgConvListFragment.aNG().bw(localList);
    paramBasePrivateMsgConvListFragment.aNJ();
    if (paramBasePrivateMsgConvListFragment.aNI() > localList.size()) {
      paramBasePrivateMsgConvListFragment.aNF().setEnableLoadMore(false);
    }
    paramBasePrivateMsgConvListFragment.hn(SystemClock.uptimeMillis() - paramBasePrivateMsgConvListFragment.lPC);
    paramBasePrivateMsgConvListFragment.aND().setVisibility(8);
    paramBasePrivateMsgConvListFragment.aNK();
  }
  
  private View aND()
  {
    return (View)this.lPy.getValue();
  }
  
  private View aNE()
  {
    return (View)this.lPz.getValue();
  }
  
  private final void aNK()
  {
    if (aNG().getItemCount() == 0)
    {
      aNE().setVisibility(0);
      aNF().setVisibility(8);
      return;
    }
    aNE().setVisibility(8);
    aNF().setVisibility(0);
  }
  
  public final c<CONVERSATION> aNC()
  {
    c localc = this.lPw;
    if (localc != null) {
      return localc;
    }
    s.bIx("dataSource");
    return null;
  }
  
  protected final RefreshLoadMoreLayout aNF()
  {
    return (RefreshLoadMoreLayout)this.lPA.getValue();
  }
  
  public final BasePrivateMsgConvListFragment.a<CONVERSATION> aNG()
  {
    return (BasePrivateMsgConvListFragment.a)this.lPB.getValue();
  }
  
  public final b aNH()
  {
    b localb = this.lPD;
    if (localb != null) {
      return localb;
    }
    s.bIx("readyChattingUIC");
    return null;
  }
  
  public int aNI()
  {
    return 0;
  }
  
  public void aNJ() {}
  
  public abstract RefreshLoadMoreLayout aNL();
  
  public abstract c<CONVERSATION> aNM();
  
  public abstract List<MStorage> aNN();
  
  public abstract BasePrivateMsgConvListFragment.a<CONVERSATION> aNO();
  
  public abstract View getEmptyView();
  
  public abstract View getLoadingView();
  
  public abstract RecyclerView getRecyclerView();
  
  public void hn(long paramLong) {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return (Set)ad.aivA;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aNC().aNP().remove((MStorage.IOnStorageChange)aNG());
    Iterator localIterator = ((Iterable)aNN()).iterator();
    while (localIterator.hasNext()) {
      ((MStorage)localIterator.next()).remove((MStorage.IOnStorageChange)aNG());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    aNK();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    this.lPC = SystemClock.uptimeMillis();
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = getActivity();
    s.checkNotNull(paramView);
    s.s(paramView, "this.activity!!");
    paramView = com.tencent.mm.ui.component.k.nq((Context)paramView).q(b.class);
    s.s(paramView, "UICProvider.of(this.acti…yChattingUIC::class.java)");
    paramView = (b)paramView;
    s.u(paramView, "<set-?>");
    this.lPD = paramView;
    paramView = (RecyclerView)this.lPx.getValue();
    paramView.getContext();
    paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramView.setAdapter((RecyclerView.a)aNG());
    paramView.setItemAnimator(null);
    paramView = aNM();
    s.u(paramView, "<set-?>");
    this.lPw = paramView;
    aNC().aNP().add((MStorage.IOnStorageChange)aNG());
    paramView = ((Iterable)aNN()).iterator();
    while (paramView.hasNext()) {
      ((MStorage)paramView.next()).add((MStorage.IOnStorageChange)aNG());
    }
    aNF().setActionCallback((RefreshLoadMoreLayout.b)new i(this));
    paramView = this.rootView;
    if (paramView != null) {
      paramView.post(new BasePrivateMsgConvListFragment..ExternalSyntheticLambda0(this));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "", "getConversationStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "loadOnLoadMore", "", "offset", "", "loadOnPageEnter", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c<T extends IAutoDBItem>
  {
    public abstract MAutoStorage<T> aNP();
    
    public abstract List<T> aNQ();
    
    public abstract List<T> qH(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<BasePrivateMsgConvListFragment.a<CONVERSATION>>
  {
    d(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<View>
  {
    e(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<View>
  {
    f(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<RecyclerView>
  {
    g(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "CONVERSATION", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<RefreshLoadMoreLayout>
  {
    h(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/chatting/BasePrivateMsgConvListFragment$onViewCreated$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends RefreshLoadMoreLayout.b
  {
    i(BasePrivateMsgConvListFragment<CONVERSATION> paramBasePrivateMsgConvListFragment) {}
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(231983);
      List localList = this.lPF.aNC().qH(this.lPF.aNG().getItemCount());
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
      ((RefreshLoadMoreLayout.d)localObject).pzq = false;
      if (!((Collection)localList).isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        ((RefreshLoadMoreLayout.d)localObject).agJu = bool;
        ((RefreshLoadMoreLayout.d)localObject).agJv = localList.size();
        this.lPF.aNG().bw(localList);
        this.lPF.aNF().onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
        BasePrivateMsgConvListFragment.b(this.lPF);
        AppMethodBeat.o(231983);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatting.BasePrivateMsgConvListFragment
 * JD-Core Version:    0.7.0.1
 */