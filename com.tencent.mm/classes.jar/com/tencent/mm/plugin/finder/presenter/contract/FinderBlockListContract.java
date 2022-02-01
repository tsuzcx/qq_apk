package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.ak.a;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.FinderContact;>;
import kotlin.a.j;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract;", "", "()V", "TAG", "", "startNetSceneTime", "", "BlockListPresenter", "BlockListViewCallback", "plugin-finder_release"})
public final class FinderBlockListContract
{
  private static final String TAG = "Finder.FinderBlockListContract";
  private static long uWm;
  public static final FinderBlockListContract uWn;
  
  static
  {
    AppMethodBeat.i(249712);
    uWn = new FinderBlockListContract();
    TAG = "Finder.FinderBlockListContract";
    uWm = SystemClock.uptimeMillis();
    AppMethodBeat.o(249712);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "viewCallback", "addContactList", "", "contacts", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "doScene", "getData", "initByCache", "initData", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class BlockListPresenter
    implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.presenter.base.a<FinderBlockListContract.BlockListViewCallback>
  {
    public final ArrayList<com.tencent.mm.plugin.finder.model.p> kgc;
    private com.tencent.mm.bw.b tVM;
    public FinderBlockListContract.BlockListViewCallback uWo;
    public ak uWp;
    
    public BlockListPresenter(ak paramak)
    {
      AppMethodBeat.i(249688);
      this.uWp = paramak;
      this.kgc = new ArrayList();
      AppMethodBeat.o(249688);
    }
    
    public final void a(FinderBlockListContract.BlockListViewCallback paramBlockListViewCallback)
    {
      AppMethodBeat.i(249682);
      kotlin.g.b.p.h(paramBlockListViewCallback, "callback");
      this.uWo = paramBlockListViewCallback;
      paramBlockListViewCallback = this.uWp.c(null);
      if (paramBlockListViewCallback != null)
      {
        com.tencent.mm.kernel.g.azz().a(paramBlockListViewCallback.getType(), (com.tencent.mm.ak.i)this);
        AppMethodBeat.o(249682);
        return;
      }
      AppMethodBeat.o(249682);
    }
    
    public final void dlQ()
    {
      AppMethodBeat.i(249684);
      if (this.uWp.c(null) != null) {
        com.tencent.mm.kernel.g.azz().b(this.uWp.c(this.tVM));
      }
      AppMethodBeat.o(249684);
    }
    
    public final void eo(List<? extends FinderContact> paramList)
    {
      AppMethodBeat.i(249687);
      kotlin.g.b.p.h(paramList, "contacts");
      Object localObject2 = (Iterable)paramList;
      Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(new com.tencent.mm.plugin.finder.model.p((FinderContact)((Iterator)localObject2).next()));
      }
      localObject1 = (List)localObject1;
      localObject2 = this.uWo;
      Object localObject3;
      Object localObject4;
      if (localObject2 != null)
      {
        kotlin.g.b.p.h(localObject1, "newList");
        ((FinderBlockListContract.BlockListViewCallback)localObject2).uWr.kgc.addAll(0, (Collection)localObject1);
        localObject3 = ((FinderBlockListContract.BlockListViewCallback)localObject2).hak;
        if (localObject3 == null) {
          kotlin.g.b.p.btv("recyclerView");
        }
        localObject3 = ((RecyclerView)localObject3).getAdapter();
        if (localObject3 != null)
        {
          localObject4 = ((FinderBlockListContract.BlockListViewCallback)localObject2).tFp;
          if (localObject4 == null) {
            break label269;
          }
        }
      }
      label269:
      for (int i = ((com.tencent.mm.view.recyclerview.g)localObject4).RqM.size();; i = 0)
      {
        ((RecyclerView.a)localObject3).as(i, ((List)localObject1).size());
        ((FinderBlockListContract.BlockListViewCallback)localObject2).bIo();
        localObject2 = this.uWp;
        paramList = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(j.a(paramList, 10));
        localObject4 = paramList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((FinderContact)((Iterator)localObject4).next()).username;
          paramList = (List<? extends FinderContact>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          ((Collection)localObject3).add(paramList);
        }
      }
      ((ak)localObject2).es((List)localObject3);
      AppMethodBeat.o(249687);
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(249685);
      this.uWo = null;
      Object localObject1 = this.uWp.c(null);
      if (localObject1 != null) {
        com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.ak.q)localObject1).getType(), (com.tencent.mm.ak.i)this);
      }
      localObject1 = this.uWp.dqo();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.storage.data.g)localObject1).blr();
      }
      Object localObject2 = (Iterable)this.kgc;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact);
      }
      localObject1 = new LinkedList((Collection)localObject1);
      localObject2 = this.uWp.dqo();
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.finder.storage.data.g)localObject2).r((LinkedList)localObject1);
        AppMethodBeat.o(249685);
        return;
      }
      AppMethodBeat.o(249685);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(249686);
      Object localObject = FinderBlockListContract.uWn;
      Log.i(FinderBlockListContract.dlO(), "errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString + " requestScene " + this.uWp.c(null));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new ArrayList();
        localObject = this.uWp.j(paramq);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new com.tencent.mm.plugin.finder.model.p((FinderContact)((Iterator)localObject).next()));
          }
        }
        localObject = this.uWo;
        if (localObject != null)
        {
          paramString = (List)paramString;
          if (this.tVM != null) {
            break label210;
          }
        }
      }
      label210:
      for (boolean bool = true;; bool = false)
      {
        ((FinderBlockListContract.BlockListViewCallback)localObject).e(paramString, bool);
        this.tVM = this.uWp.i(paramq);
        AppMethodBeat.o(249686);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;)V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchBarData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "finishLoadMore", "", "newList", "", "isRefresh", "", "getActivity", "getPresenter", "hideSearchBar", "delay", "", "isSmooth", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "onUserAddList", "showEmptyView", "plugin-finder_release"})
  public static final class BlockListViewCallback
    implements com.tencent.mm.plugin.finder.presenter.base.c<FinderBlockListContract.BlockListPresenter>, HeadFooterLayout.b
  {
    public final View contentView;
    public final MMActivity gte;
    public RecyclerView hak;
    public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> tFp;
    public RefreshLoadMoreLayout tLS;
    public final FinderBlockListContract.BlockListPresenter uWr;
    public com.tencent.mm.plugin.finder.model.i uWs;
    final int uWt;
    
    public BlockListViewCallback(MMActivity paramMMActivity, View paramView, FinderBlockListContract.BlockListPresenter paramBlockListPresenter)
    {
      AppMethodBeat.i(249708);
      this.uWr = paramBlockListPresenter;
      this.gte = paramMMActivity;
      this.contentView = paramView;
      AppMethodBeat.o(249708);
    }
    
    public final boolean IJ(int paramInt)
    {
      AppMethodBeat.i(249707);
      FinderBlockListContract localFinderBlockListContract = FinderBlockListContract.uWn;
      Log.i(FinderBlockListContract.dlO(), "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(249707);
      return false;
    }
    
    public final void bIo()
    {
      AppMethodBeat.i(249703);
      if (this.uWr.kgc.size() == 0)
      {
        localView = this.contentView.findViewById(2131307118);
        kotlin.g.b.p.g(localView, "contentView.findViewById<View>(R.id.rl_layout)");
        localView.setVisibility(8);
        localView = this.contentView.findViewById(2131306782);
        kotlin.g.b.p.g(localView, "contentView.findViewById<View>(R.id.refresh_tip)");
        localView.setVisibility(0);
        localView = this.contentView.findViewById(2131306782);
        kotlin.g.b.p.g(localView, "contentView.findViewById…xtView>(R.id.refresh_tip)");
        ((TextView)localView).setText((CharSequence)this.gte.getResources().getString(this.uWr.uWp.dqr()));
        AppMethodBeat.o(249703);
        return;
      }
      View localView = this.contentView.findViewById(2131307118);
      kotlin.g.b.p.g(localView, "contentView.findViewById<View>(R.id.rl_layout)");
      localView.setVisibility(0);
      localView = this.contentView.findViewById(2131306782);
      kotlin.g.b.p.g(localView, "contentView.findViewById<View>(R.id.refresh_tip)");
      localView.setVisibility(8);
      AppMethodBeat.o(249703);
    }
    
    public final void ddr()
    {
      AppMethodBeat.i(249705);
      FinderBlockListContract localFinderBlockListContract = FinderBlockListContract.uWn;
      Log.i(FinderBlockListContract.dlO(), "[onOverStop]");
      AppMethodBeat.o(249705);
    }
    
    public final void e(final List<com.tencent.mm.plugin.finder.model.p> paramList, final boolean paramBoolean)
    {
      AppMethodBeat.i(249704);
      kotlin.g.b.p.h(paramList, "newList");
      final z.d locald = new z.d();
      locald.SYE = this.uWr.kgc.size();
      long l = SystemClock.uptimeMillis();
      Object localObject = FinderBlockListContract.uWn;
      l -= FinderBlockListContract.dlP();
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (l >= ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue()) {}
      for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() - l)
      {
        d.a(l, (kotlin.g.a.a)new kotlin.g.b.q(paramBoolean) {});
        AppMethodBeat.o(249704);
        return;
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      }
    }
    
    public final boolean u(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(249706);
      FinderBlockListContract localFinderBlockListContract = FinderBlockListContract.uWn;
      Log.i(FinderBlockListContract.dlO(), "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(249706);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract
 * JD-Core Version:    0.7.0.1
 */