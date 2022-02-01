package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
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
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderFollowListTopicUIC
  extends UIComponent
{
  public static final a wwo;
  private final FinderFollowTopicListContract.FollowTopicPresenter uWW;
  
  static
  {
    AppMethodBeat.i(255526);
    wwo = new a((byte)0);
    AppMethodBeat.o(255526);
  }
  
  public FinderFollowListTopicUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255525);
    this.uWW = new FinderFollowTopicListContract.FollowTopicPresenter();
    AppMethodBeat.o(255525);
  }
  
  public final int getLayoutId()
  {
    return 2131494319;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255523);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255523);
      throw paramBundle;
    }
    paramBundle = new FinderFollowTopicListContract.FollowTopicViewCallback((MMActivity)paramBundle, getRootView(), this.uWW);
    this.uWW.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(2131307118);
    p.g(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.tLS = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    paramBundle.hak = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.tFp = new WxRecyclerAdapter((f)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.1(), paramBundle.uWW.kgc, true);
    localObject = paramBundle.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    WxRecyclerAdapter localWxRecyclerAdapter = paramBundle.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localObject = paramBundle.tFp;
    if (localObject == null) {
      p.btv("adapter");
    }
    ((com.tencent.mm.view.recyclerview.g)localObject).RqP = ((g.c)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.2(paramBundle));
    localObject = paramBundle.tFp;
    if (localObject == null) {
      p.btv("adapter");
    }
    ((com.tencent.mm.view.recyclerview.g)localObject).RqO = ((g.d)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.3(paramBundle));
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowTopicListContract.FollowTopicViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(2131300101);
    p.g(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.hRM = ((TextView)localObject);
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    paramBundle.JT(((e)localObject).azQ().getInt(ar.a.OlB, 0));
    paramBundle.pqr = new a((Context)paramBundle.activity);
    paramBundle = paramBundle.uWW;
    d.b(d.a(d.aBx(), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.1(paramBundle)), (b)new FinderFollowTopicListContract.FollowTopicPresenter.loadStart.2(paramBundle));
    paramBundle.nO(false);
    AppMethodBeat.o(255523);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255524);
    super.onDestroy();
    this.uWW.onDetach();
    AppMethodBeat.o(255524);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListTopicUIC
 * JD-Core Version:    0.7.0.1
 */