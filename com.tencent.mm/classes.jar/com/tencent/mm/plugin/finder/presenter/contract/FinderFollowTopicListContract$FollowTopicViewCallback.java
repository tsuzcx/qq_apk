package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.convert.cs;
import com.tencent.mm.plugin.finder.model.bq;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;)V", "MENU_ID_UNFOLLOW", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "footerView", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "topicFollowCount", "addFooterView", "", "getActivity", "getPresenter", "initView", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "setFooterViewText", "showPopupMenu", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "anchor", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback
  implements c<FinderFollowTopicListContract.FollowTopicPresenter>, HeadFooterLayout.b
{
  public static final Companion zNm;
  public final MMActivity activity;
  public final View contentView;
  public RecyclerView jLl;
  public TextView kGj;
  private View sBm;
  public com.tencent.mm.ui.widget.b.a szq;
  private final int xhI;
  public WxRecyclerAdapter<bq> xnR;
  public RefreshLoadMoreLayout xvJ;
  private int zNk;
  public final FinderFollowTopicListContract.FollowTopicPresenter zNl;
  
  static
  {
    AppMethodBeat.i(275614);
    zNm = new Companion((byte)0);
    AppMethodBeat.o(275614);
  }
  
  public FinderFollowTopicListContract$FollowTopicViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowTopicListContract.FollowTopicPresenter paramFollowTopicPresenter)
  {
    AppMethodBeat.i(275612);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.zNl = paramFollowTopicPresenter;
    this.xhI = 1002;
    AppMethodBeat.o(275612);
  }
  
  private void dMW()
  {
    AppMethodBeat.i(275609);
    Log.i("Finder.FollowTopicViewCallback", "addFooterView");
    if (this.sBm == null)
    {
      Object localObject1 = LayoutInflater.from(this.contentView.getContext());
      int i = b.g.finder_follow_list_follow_layout;
      Object localObject2 = this.jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      this.sBm = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)localObject2, false);
      dMX();
      localObject1 = this.xnR;
      if (localObject1 == null) {
        p.bGy("adapter");
      }
      localObject2 = this.sBm;
      if (localObject2 == null) {
        p.iCn();
      }
      ((WxRecyclerAdapter)localObject1).h((View)localObject2, 0, false);
    }
    AppMethodBeat.o(275609);
  }
  
  public final boolean MB(int paramInt)
  {
    return false;
  }
  
  public final void OU(int paramInt)
  {
    AppMethodBeat.i(275611);
    this.zNk = paramInt;
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    paramInt += ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAv, 0);
    if (paramInt == 0)
    {
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(b.j.finder_follow_empty_tip));
    }
    for (;;)
    {
      this.activity.setMMTitle(c.a.a(this).getString(b.j.finder_my_follow_number, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(275611);
      return;
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void dMX()
  {
    AppMethodBeat.i(275610);
    View localView = this.sBm;
    if (localView != null)
    {
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAw, 0);
      if (i == 0)
      {
        localObject = (TextView)localView.findViewById(b.f.follow_list_follow_text);
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)localView.getResources().getString(b.j.finder_follow_list_empty_tip));
          AppMethodBeat.o(275610);
          return;
        }
        AppMethodBeat.o(275610);
        return;
      }
      localObject = (TextView)localView.findViewById(b.f.follow_list_follow_text);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)localView.getResources().getString(b.j.finder_my_follow_topic_number, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(275610);
        return;
      }
      AppMethodBeat.o(275610);
      return;
    }
    AppMethodBeat.o(275610);
  }
  
  public final void dtZ() {}
  
  public final void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275607);
    if (paramInt2 > 0) {
      dMW();
    }
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.xnR;
      if (localObject == null) {
        p.bGy("adapter");
      }
      ((WxRecyclerAdapter)localObject).aG(paramInt1, paramInt2);
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).YNF = this.zNl.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).YNG = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).YNG > 0) {
        ((RefreshLoadMoreLayout.c)localObject).mCI = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(275607);
      return;
      localObject = this.xnR;
      if (localObject == null) {
        p.bGy("adapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
    }
    Object localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).azr(0);
    if (!this.zNl.hasMore)
    {
      localObject = this.xvJ;
      if (localObject == null) {
        p.bGy("rlLayout");
      }
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(275607);
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback
 * JD-Core Version:    0.7.0.1
 */