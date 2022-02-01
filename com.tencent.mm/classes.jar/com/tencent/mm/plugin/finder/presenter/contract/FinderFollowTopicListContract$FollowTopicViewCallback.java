package com.tencent.mm.plugin.finder.presenter.contract;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.convert.cl;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;)V", "MENU_ID_UNFOLLOW", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "footerView", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "topicFollowCount", "addFooterView", "", "getActivity", "getPresenter", "initView", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "setFooterViewText", "showPopupMenu", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "anchor", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback
  implements c<FinderFollowTopicListContract.FollowTopicPresenter>, HeadFooterLayout.b
{
  public static final Companion uWX;
  public final MMActivity activity;
  public final View contentView;
  public TextView hRM;
  public RecyclerView hak;
  public com.tencent.mm.ui.widget.b.a pqr;
  private View psf;
  public WxRecyclerAdapter<bk> tFp;
  public RefreshLoadMoreLayout tLS;
  private final int tzW;
  private int uWV;
  public final FinderFollowTopicListContract.FollowTopicPresenter uWW;
  
  static
  {
    AppMethodBeat.i(249780);
    uWX = new Companion((byte)0);
    AppMethodBeat.o(249780);
  }
  
  public FinderFollowTopicListContract$FollowTopicViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowTopicListContract.FollowTopicPresenter paramFollowTopicPresenter)
  {
    AppMethodBeat.i(249779);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.uWW = paramFollowTopicPresenter;
    this.tzW = 1002;
    AppMethodBeat.o(249779);
  }
  
  private void dlS()
  {
    AppMethodBeat.i(249776);
    Log.i("Finder.FollowTopicViewCallback", "addFooterView");
    if (this.psf == null)
    {
      Object localObject1 = LayoutInflater.from(this.contentView.getContext());
      Object localObject2 = this.hak;
      if (localObject2 == null) {
        p.btv("recyclerView");
      }
      this.psf = ((LayoutInflater)localObject1).inflate(2131494316, (ViewGroup)localObject2, false);
      dlT();
      localObject1 = this.tFp;
      if (localObject1 == null) {
        p.btv("adapter");
      }
      localObject2 = this.psf;
      if (localObject2 == null) {
        p.hyc();
      }
      ((WxRecyclerAdapter)localObject1).g((View)localObject2, 0, false);
    }
    AppMethodBeat.o(249776);
  }
  
  public final boolean IJ(int paramInt)
  {
    return false;
  }
  
  public final void JT(int paramInt)
  {
    AppMethodBeat.i(249778);
    this.uWV = paramInt;
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    paramInt += ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlA, 0);
    if (paramInt == 0)
    {
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(2131759779));
    }
    for (;;)
    {
      this.activity.setMMTitle(c.a.a(this).getString(2131760319, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(249778);
      return;
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void ddr() {}
  
  public final void dlT()
  {
    AppMethodBeat.i(249777);
    View localView = this.psf;
    if (localView != null)
    {
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlB, 0);
      if (i == 0)
      {
        localObject = (TextView)localView.findViewById(2131301653);
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)localView.getResources().getString(2131759789));
          AppMethodBeat.o(249777);
          return;
        }
        AppMethodBeat.o(249777);
        return;
      }
      localObject = (TextView)localView.findViewById(2131301653);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)localView.getResources().getString(2131760320, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(249777);
        return;
      }
      AppMethodBeat.o(249777);
      return;
    }
    AppMethodBeat.o(249777);
  }
  
  public final void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249774);
    if (paramInt2 > 0) {
      dlS();
    }
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.tFp;
      if (localObject == null) {
        p.btv("adapter");
      }
      ((WxRecyclerAdapter)localObject).as(paramInt1, paramInt2);
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).Rmj = this.uWW.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).Rmk = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).Rmk > 0) {
        ((RefreshLoadMoreLayout.c)localObject).jLE = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(249774);
      return;
      localObject = this.tFp;
      if (localObject == null) {
        p.btv("adapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
    }
    Object localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).apS(0);
    if (!this.uWW.hasMore)
    {
      localObject = this.tLS;
      if (localObject == null) {
        p.btv("rlLayout");
      }
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(249774);
  }
  
  public final boolean u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback
 * JD-Core Version:    0.7.0.1
 */