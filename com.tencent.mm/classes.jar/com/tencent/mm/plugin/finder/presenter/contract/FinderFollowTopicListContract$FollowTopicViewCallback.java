package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.dp;
import com.tencent.mm.plugin.finder.convert.cv;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bx;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;)V", "MENU_ID_UNFOLLOW", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "footerView", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "topicFollowCount", "addFooterView", "", "getActivity", "getPresenter", "initView", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "setFooterViewText", "showPopupMenu", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "anchor", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowTopicListContract$FollowTopicViewCallback
  implements c<FinderFollowTopicListContract.FollowTopicPresenter>, HeadFooterLayout.b
{
  public static final Companion EXS;
  public WxRecyclerAdapter<bx> ALE;
  private final int ASU;
  public RefreshLoadMoreLayout ATx;
  public final FinderFollowTopicListContract.FollowTopicPresenter EXT;
  private int EXU;
  public final MMActivity activity;
  public final View contentView;
  public RecyclerView mkw;
  public TextView njh;
  private View uiE;
  public a vEV;
  
  static
  {
    AppMethodBeat.i(343813);
    EXS = new Companion((byte)0);
    AppMethodBeat.o(343813);
  }
  
  public FinderFollowTopicListContract$FollowTopicViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowTopicListContract.FollowTopicPresenter paramFollowTopicPresenter)
  {
    AppMethodBeat.i(343766);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.EXT = paramFollowTopicPresenter;
    this.ASU = 1002;
    AppMethodBeat.o(343766);
  }
  
  private static final void a(FollowTopicViewCallback paramFollowTopicViewCallback, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(343784);
    kotlin.g.b.s.u(paramFollowTopicViewCallback, "this$0");
    paramContextMenu.add(0, paramFollowTopicViewCallback.ASU, 0, (CharSequence)paramFollowTopicViewCallback.activity.getString(e.h.finder_unfollow));
    AppMethodBeat.o(343784);
  }
  
  private static final void a(FollowTopicViewCallback paramFollowTopicViewCallback, bxv parambxv, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(343787);
    kotlin.g.b.s.u(paramFollowTopicViewCallback, "this$0");
    kotlin.g.b.s.u(parambxv, "$topicInfo");
    if (paramMenuItem.getItemId() == paramFollowTopicViewCallback.ASU)
    {
      paramMenuItem = k.aeZF;
      paramMenuItem = ((as)k.d((AppCompatActivity)paramFollowTopicViewCallback.activity).q(as.class)).fou();
      paramMenuItem.hLK = 12;
      long l = parambxv.ADo;
      parambxv = parambxv.ADp;
      paramFollowTopicViewCallback = parambxv;
      if (parambxv == null) {
        paramFollowTopicViewCallback = "";
      }
      parambxv = dp.ADn;
      paramFollowTopicViewCallback = new dp(l, paramFollowTopicViewCallback, dp.dVe(), paramMenuItem);
      h.aZW().a((p)paramFollowTopicViewCallback, 0);
    }
    AppMethodBeat.o(343787);
  }
  
  private void eIa()
  {
    AppMethodBeat.i(343780);
    Log.i("Finder.FollowTopicViewCallback", "addFooterView");
    if (this.uiE == null)
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.contentView.getContext());
      int i = e.f.finder_follow_list_follow_layout;
      Object localObject2 = this.mkw;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = null;
      }
      this.uiE = localLayoutInflater.inflate(i, (ViewGroup)localObject1, false);
      eIb();
      localObject1 = getAdapter();
      localObject2 = this.uiE;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((WxRecyclerAdapter)localObject1).j((View)localObject2, 0, false);
    }
    AppMethodBeat.o(343780);
  }
  
  public final boolean NK(int paramInt)
  {
    return false;
  }
  
  public final void Rw(int paramInt)
  {
    Object localObject = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(343877);
    this.EXU = paramInt;
    paramInt += h.baE().ban().getInt(at.a.adcN, 0);
    if (paramInt == 0)
    {
      TextView localTextView2 = this.njh;
      localObject = localTextView2;
      if (localTextView2 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = null;
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.njh;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = localTextView1;
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)this.activity.getString(e.h.finder_follow_empty_tip));
        this.activity.setMMTitle(c.a.a(this).getString(e.h.finder_my_follow_number, new Object[] { Integer.valueOf(paramInt) }));
        AppMethodBeat.o(343877);
        return;
      }
    }
    localTextView1 = this.njh;
    if (localTextView1 == null) {
      kotlin.g.b.s.bIx("emptyTip");
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(8);
      break;
      localObject = localTextView1;
    }
  }
  
  public final void eIb()
  {
    AppMethodBeat.i(343869);
    View localView = this.uiE;
    if (localView != null)
    {
      int i = h.baE().ban().getInt(at.a.adcO, 0);
      TextView localTextView;
      if (i == 0)
      {
        localTextView = (TextView)localView.findViewById(e.e.follow_list_follow_text);
        if (localTextView != null)
        {
          localTextView.setText((CharSequence)localView.getResources().getString(e.h.finder_follow_list_empty_tip));
          AppMethodBeat.o(343869);
        }
      }
      else
      {
        localTextView = (TextView)localView.findViewById(e.e.follow_list_follow_text);
        if (localTextView != null) {
          localTextView.setText((CharSequence)localView.getResources().getString(e.h.finder_my_follow_topic_number, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    AppMethodBeat.o(343869);
  }
  
  public final void ecZ() {}
  
  public final WxRecyclerAdapter<bx> getAdapter()
  {
    AppMethodBeat.i(343836);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null)
    {
      AppMethodBeat.o(343836);
      return localWxRecyclerAdapter;
    }
    kotlin.g.b.s.bIx("adapter");
    AppMethodBeat.o(343836);
    return null;
  }
  
  public final void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject1 = null;
    AppMethodBeat.i(343861);
    if (paramInt2 > 0) {
      eIa();
    }
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      getAdapter().bA(paramInt1, paramInt2);
      if (!paramBoolean) {
        break label134;
      }
      localObject2 = new RefreshLoadMoreLayout.d(0);
      ((RefreshLoadMoreLayout.d)localObject2).agJu = this.EXT.hasMore;
      ((RefreshLoadMoreLayout.d)localObject2).agJv = paramInt2;
      if (((RefreshLoadMoreLayout.d)localObject2).agJv > 0) {
        ((RefreshLoadMoreLayout.d)localObject2).pzq = false;
      }
      localRefreshLoadMoreLayout = this.ATx;
      if (localRefreshLoadMoreLayout != null) {
        break label127;
      }
      kotlin.g.b.s.bIx("rlLayout");
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject2);
      AppMethodBeat.o(343861);
      return;
      getAdapter().bZE.notifyChanged();
      break;
      label127:
      localObject1 = localRefreshLoadMoreLayout;
    }
    label134:
    Object localObject2 = this.ATx;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).aFV(0);
    if (!this.EXT.hasMore)
    {
      localObject1 = this.ATx;
      if (localObject1 != null) {
        break label207;
      }
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = localRefreshLoadMoreLayout;
    }
    label207:
    for (;;)
    {
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
      AppMethodBeat.o(343861);
      return;
    }
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback
 * JD-Core Version:    0.7.0.1
 */