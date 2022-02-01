package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter.loadStart.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter.loadStart.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.4;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends UIComponent
{
  public static final a GQl;
  private final FinderFollowTopicListContract.FollowTopicPresenter EXT;
  
  static
  {
    AppMethodBeat.i(337945);
    GQl = new a((byte)0);
    AppMethodBeat.o(337945);
  }
  
  public z(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337940);
    this.EXT = new FinderFollowTopicListContract.FollowTopicPresenter();
    AppMethodBeat.o(337940);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_follow_list_topic_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(337968);
    super.onCreate(paramBundle);
    FinderFollowTopicListContract.FollowTopicViewCallback localFollowTopicViewCallback = new FinderFollowTopicListContract.FollowTopicViewCallback((MMActivity)getActivity(), getRootView(), this.EXT);
    this.EXT.a(localFollowTopicViewCallback);
    paramBundle = localFollowTopicViewCallback.contentView.findViewById(e.e.rl_layout);
    s.s(paramBundle, "contentView.findViewById(R.id.rl_layout)");
    localFollowTopicViewCallback.ATx = ((RefreshLoadMoreLayout)paramBundle);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = localFollowTopicViewCallback.ATx;
    paramBundle = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      s.bIx("rlLayout");
      paramBundle = null;
    }
    localFollowTopicViewCallback.mkw = paramBundle.getRecyclerView();
    paramBundle = localFollowTopicViewCallback.mkw;
    if (paramBundle == null)
    {
      s.bIx("recyclerView");
      paramBundle = null;
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramBundle = new WxRecyclerAdapter((g)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.1(), localFollowTopicViewCallback.EXT.pUj, true);
      s.u(paramBundle, "<set-?>");
      localFollowTopicViewCallback.ALE = paramBundle;
      paramBundle = localFollowTopicViewCallback.mkw;
      if (paramBundle != null) {
        break label415;
      }
      s.bIx("recyclerView");
      paramBundle = null;
      label187:
      paramBundle.setAdapter((RecyclerView.a)localFollowTopicViewCallback.getAdapter());
      localFollowTopicViewCallback.getAdapter().agOe = ((i.c)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.2(localFollowTopicViewCallback));
      localFollowTopicViewCallback.getAdapter().agOd = ((i.d)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.3(localFollowTopicViewCallback));
      paramBundle = localFollowTopicViewCallback.ATx;
      if (paramBundle != null) {
        break label418;
      }
      s.bIx("rlLayout");
      paramBundle = null;
      label256:
      paramBundle.setOverCallback((HeadFooterLayout.b)localFollowTopicViewCallback);
      paramBundle = localFollowTopicViewCallback.ATx;
      if (paramBundle != null) {
        break label421;
      }
      s.bIx("rlLayout");
      paramBundle = localObject;
    }
    label415:
    label418:
    label421:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.4(localFollowTopicViewCallback));
      paramBundle = localFollowTopicViewCallback.contentView.findViewById(e.e.empty_tip);
      s.s(paramBundle, "contentView.findViewById<TextView>(R.id.empty_tip)");
      localFollowTopicViewCallback.njh = ((TextView)paramBundle);
      localFollowTopicViewCallback.Rw(h.baE().ban().getInt(at.a.adcO, 0));
      localFollowTopicViewCallback.vEV = new a((Context)localFollowTopicViewCallback.activity);
      paramBundle = localFollowTopicViewCallback.EXT;
      d.b(d.a(d.bbX(), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.1(paramBundle)), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.2(paramBundle));
      paramBundle.tc(false);
      AppMethodBeat.o(337968);
      return;
      break;
      break label187;
      break label256;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(337976);
    super.onDestroy();
    this.EXT.onDetach();
    AppMethodBeat.o(337976);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.z
 * JD-Core Version:    0.7.0.1
 */