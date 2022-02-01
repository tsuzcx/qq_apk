package com.tencent.mm.plugin.finder.presenter.contract;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.an;
import com.tencent.mm.plugin.finder.convert.ao;
import com.tencent.mm.plugin.finder.convert.ap;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.convert.ar;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.ae;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.i;
import d.a.j;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "msgView", "Landroid/view/View;", "presenter", "uiCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "footerView", "isPlayingAnimation", "", "loadingBar", "newSysMsgCount", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshTip", "Landroid/widget/TextView;", "finishLoadMore", "", "msgList", "", "getActivity", "getCommentDetail", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getPresenter", "hideLoadingBar", "playAnimation", "initView", "playLoadingAnimation", "showLoadingBar", "showRefreshTip", "tip", "textColor", "clickable", "UICallbackListener", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.b<FinderMsgContract.MsgPresenter>
{
  private final String TAG;
  private final View contentView;
  private RecyclerView fPw;
  final MMActivity imP;
  private View mXu;
  final FinderMsgContract.MsgPresenter qFb;
  private final UICallbackListener qFc;
  private boolean qFd;
  private com.tencent.mm.plugin.finder.cgi.h qqr;
  public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> qul;
  private View qwk;
  private TextView qxI;
  
  public FinderMsgContract$MsgViewCallback(MMActivity paramMMActivity, View paramView, FinderMsgContract.MsgPresenter paramMsgPresenter, UICallbackListener paramUICallbackListener)
  {
    AppMethodBeat.i(166560);
    this.TAG = ("Finder.FinderMsgContract.MsgViewCallback." + hashCode());
    this.qFb = paramMsgPresenter;
    this.imP = paramMMActivity;
    this.contentView = paramView;
    this.qFc = paramUICallbackListener;
    AppMethodBeat.o(166560);
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166557);
    Object localObject1 = this.contentView.findViewById(2131302540);
    k.g(localObject1, "contentView.findViewById(R.id.msg_recycler_view)");
    this.fPw = ((RecyclerView)localObject1);
    localObject1 = this.contentView.findViewById(2131301509);
    k.g(localObject1, "contentView.findViewById….id.loading_progress_bar)");
    this.qwk = ((View)localObject1);
    localObject1 = this.contentView.findViewById(2131302542);
    k.g(localObject1, "contentView.findViewById(R.id.msg_refresh_tip)");
    this.qxI = ((TextView)localObject1);
    localObject1 = this.fPw;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = this.qxI;
    if (localObject1 == null) {
      k.aPZ("refreshTip");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(166545);
        FinderMsgContract.MsgViewCallback.b(this.qFe).requestRefresh();
        AppMethodBeat.o(166545);
      }
    });
    Object localObject2 = (com.tencent.mm.view.recyclerview.c)new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> zm(int paramAnonymousInt)
      {
        AppMethodBeat.i(198761);
        com.tencent.mm.view.recyclerview.b localb;
        if (paramAnonymousInt == u.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new w();
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == com.tencent.mm.plugin.finder.model.t.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.v(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == s.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.t(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == ae.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new ar();
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == aa.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new an(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == com.tencent.mm.plugin.finder.model.ad.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new aq(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == ac.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new ap(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        if (paramAnonymousInt == com.tencent.mm.plugin.finder.model.ab.class.getName().hashCode())
        {
          localb = (com.tencent.mm.view.recyclerview.b)new ao(FinderMsgContract.MsgViewCallback.b(this.qFe).scene);
          AppMethodBeat.o(198761);
          return localb;
        }
        k.fvU();
        AppMethodBeat.o(198761);
        return null;
      }
    };
    localObject1 = this.qFb.dataList;
    if (localObject1 != null) {
      if ((this.qFb.scene == 1) && (this.qFb.KJH == 1))
      {
        com.tencent.mm.plugin.finder.storage.l locall = new com.tencent.mm.plugin.finder.storage.l();
        locall.field_id = 9223372036854775807L;
        ((ArrayList)localObject1).add(0, new ae(locall));
      }
    }
    for (;;)
    {
      this.qul = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)localObject2, (ArrayList)localObject1, true);
      localObject1 = this.qul;
      if (localObject1 != null) {
        ((WxRecyclerAdapter)localObject1).LEe = ((i)new i()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, com.tencent.mm.view.recyclerview.g paramAnonymousg)
          {
            AppMethodBeat.i(198762);
            k.h(paramAnonymousRecyclerView, "recyclerView");
            k.h(paramAnonymousg, "data");
            paramAnonymousg = ((Iterable)paramAnonymousg.LDT).iterator();
            while (paramAnonymousg.hasNext()) {
              if (((com.tencent.mm.view.recyclerview.h)paramAnonymousg.next()).LDU.bMt() == ae.class.getName().hashCode())
              {
                paramAnonymousRecyclerView = com.tencent.mm.kernel.g.afB();
                k.g(paramAnonymousRecyclerView, "MMKernel.storage()");
                int i = paramAnonymousRecyclerView.afk().getInt(ae.a.LBo, 0);
                if (i > 0)
                {
                  paramAnonymousRecyclerView = com.tencent.mm.plugin.finder.report.b.qFq;
                  paramAnonymousRecyclerView = FinderReporterUIC.Ljl;
                  paramAnonymousRecyclerView = FinderReporterUIC.a.lB((Context)FinderMsgContract.MsgViewCallback.g(this.qFe));
                  if (paramAnonymousRecyclerView != null) {}
                  for (paramAnonymousRecyclerView = paramAnonymousRecyclerView.fXs();; paramAnonymousRecyclerView = null)
                  {
                    com.tencent.mm.plugin.finder.report.b.a("5", 4, 1, 5, 0, i, null, null, 0L, paramAnonymousRecyclerView, 0, 1472);
                    break;
                  }
                }
              }
            }
            AppMethodBeat.o(198762);
          }
        });
      }
      localObject1 = FinderReporterUIC.Ljl;
      localObject1 = FinderReporterUIC.a.lB((Context)this.imP);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
        if (localObject1 != null)
        {
          localObject2 = this.fPw;
          if (localObject2 == null) {
            k.aPZ("recyclerView");
          }
          ((com.tencent.mm.plugin.finder.event.base.e)localObject1).v((RecyclerView)localObject2);
        }
      }
      localObject1 = this.fPw;
      if (localObject1 == null) {
        k.aPZ("recyclerView");
      }
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.qul);
      localObject1 = this.fPw;
      if (localObject1 == null) {
        k.aPZ("recyclerView");
      }
      ((RecyclerView)localObject1).a((RecyclerView.m)new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(198764);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(198764);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(198763);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
          k.h(paramAnonymousRecyclerView, "recyclerView");
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          int i;
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousRecyclerView = paramAnonymousRecyclerView.getLayoutManager();
            if (paramAnonymousRecyclerView == null)
            {
              paramAnonymousRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
              AppMethodBeat.o(198763);
              throw paramAnonymousRecyclerView;
            }
            i = ((LinearLayoutManager)paramAnonymousRecyclerView).jR();
            if (((Collection)FinderMsgContract.MsgViewCallback.b(this.qFe).dataList).isEmpty()) {
              break label327;
            }
            paramAnonymousInt = 1;
            if (paramAnonymousInt != 0)
            {
              paramAnonymousRecyclerView = this.qFe.qul;
              if (paramAnonymousRecyclerView == null) {
                break label332;
              }
            }
          }
          label327:
          label332:
          for (paramAnonymousInt = paramAnonymousRecyclerView.getItemCount();; paramAnonymousInt = 0)
          {
            if (i == paramAnonymousInt - 1)
            {
              com.tencent.mm.sdk.platformtools.ad.i(FinderMsgContract.MsgViewCallback.c(this.qFe), "scroll to the end, load more data");
              if ((FinderMsgContract.MsgViewCallback.b(this.qFe).al(((com.tencent.mm.plugin.finder.model.a)j.iA((List)FinderMsgContract.MsgViewCallback.b(this.qFe).dataList)).qDo.field_id, 10) == 0) && (FinderMsgContract.MsgViewCallback.d(this.qFe) == null))
              {
                FinderMsgContract.MsgViewCallback.a(this.qFe, View.inflate((Context)this.qFe.imP, 2131494060, null));
                paramAnonymousRecyclerView = new RecyclerView.LayoutParams(-1, -2);
                localObject = FinderMsgContract.MsgViewCallback.d(this.qFe);
                if (localObject == null) {
                  k.fvU();
                }
                ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramAnonymousRecyclerView);
                paramAnonymousRecyclerView = this.qFe.qul;
                if (paramAnonymousRecyclerView != null)
                {
                  localObject = FinderMsgContract.MsgViewCallback.d(this.qFe);
                  if (localObject == null) {
                    k.fvU();
                  }
                  paramAnonymousRecyclerView.g((View)localObject, 0, false);
                }
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(198763);
            return;
            paramAnonymousInt = 0;
            break;
          }
        }
      });
      localObject1 = this.qul;
      if (localObject1 != null) {
        ((d)localObject1).Ibo = ((d.c)new FinderMsgContract.MsgViewCallback.initView.6(this));
      }
      com.tencent.mm.ad.c.a(com.tencent.mm.ad.c.agM(), (d.g.a.b)new FinderMsgContract.MsgViewCallback.initView.7(this));
      com.tencent.mm.ad.c.a(300L, (d.g.a.a)new FinderMsgContract.MsgViewCallback.initView.8(this));
      AppMethodBeat.o(166557);
      return;
      localObject1 = null;
    }
  }
  
  public final void kY(final boolean paramBoolean)
  {
    AppMethodBeat.i(166558);
    com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(paramBoolean) {});
    AppMethodBeat.o(166558);
  }
  
  public final void n(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(166559);
    com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(paramString) {});
    AppMethodBeat.o(166559);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "", "onItemClick", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
  public static abstract interface UICallbackListener
  {
    public abstract void a(com.tencent.mm.plugin.finder.storage.l paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback
 * JD-Core Version:    0.7.0.1
 */