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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter.loadStart.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter.loadStart.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicViewCallback.initView.4;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class v
  extends UIComponent
{
  public static final a Bks;
  private final FinderFollowTopicListContract.FollowTopicPresenter zNl;
  
  static
  {
    AppMethodBeat.i(288819);
    Bks = new a((byte)0);
    AppMethodBeat.o(288819);
  }
  
  public v(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(288818);
    this.zNl = new FinderFollowTopicListContract.FollowTopicPresenter();
    AppMethodBeat.o(288818);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_follow_list_topic_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288816);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(288816);
      throw paramBundle;
    }
    paramBundle = new FinderFollowTopicListContract.FollowTopicViewCallback((MMActivity)paramBundle, getRootView(), this.zNl);
    this.zNl.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(b.f.rl_layout);
    p.j(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.xvJ = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    paramBundle.jLl = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.1(), paramBundle.zNl.mXB, true);
    localObject = paramBundle.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    WxRecyclerAdapter localWxRecyclerAdapter = paramBundle.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localObject = paramBundle.xnR;
    if (localObject == null) {
      p.bGy("adapter");
    }
    ((com.tencent.mm.view.recyclerview.h)localObject).YSn = ((h.c)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.2(paramBundle));
    localObject = paramBundle.xnR;
    if (localObject == null) {
      p.bGy("adapter");
    }
    ((com.tencent.mm.view.recyclerview.h)localObject).YSm = ((h.d)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.3(paramBundle));
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(b.f.empty_tip);
    p.j(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.kGj = ((TextView)localObject);
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    paramBundle.OU(((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAw, 0));
    paramBundle.szq = new a((Context)paramBundle.activity);
    paramBundle = paramBundle.zNl;
    d.b(d.a(d.aJa(), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.1(paramBundle)), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.2(paramBundle));
    paramBundle.pY(false);
    AppMethodBeat.o(288816);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288817);
    super.onDestroy();
    this.zNl.onDetach();
    AppMethodBeat.o(288817);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.v
 * JD-Core Version:    0.7.0.1
 */