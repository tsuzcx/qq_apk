package com.tencent.mm.plugin.finder.megavideo.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.NormalMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showRetryTips", "ifShow", "", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  public static final a zzC;
  private f zvV;
  private h.b zxJ;
  private View zzB;
  
  static
  {
    AppMethodBeat.i(229665);
    zzC = new a((byte)0);
    AppMethodBeat.o(229665);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(229663);
    AppMethodBeat.o(229663);
  }
  
  public final h.a dKn()
  {
    AppMethodBeat.i(229660);
    Object localObject = this.zvV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    localObject = (h.a)localObject;
    AppMethodBeat.o(229660);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229655);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("finder_username");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      Object localObject1 = new f(getActivity(), (UIComponent)this);
      if ((z.PE(paramBundle)) && (getActivity().getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false))) {}
      for (boolean bool = true;; bool = false)
      {
        ((f)localObject1).zxL = bool;
        this.zvV = ((f)localObject1);
        paramBundle = getActivity();
        localObject1 = this.zvV;
        if (localObject1 == null) {
          p.bGy("presenter");
        }
        this.zxJ = ((h.b)new com.tencent.mm.plugin.finder.megavideo.ui.g(paramBundle, (h.a)localObject1, getRootView()));
        paramBundle = com.tencent.mm.ui.component.g.Xox;
        paramBundle = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).ekY();
        localObject1 = getActivity();
        if (localObject1 != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(229655);
        throw paramBundle;
      }
      Object localObject2 = new NormalMegaVideoLoader(paramBundle, (MMFragmentActivity)localObject1);
      ((NormalMegaVideoLoader)localObject2).xHm = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0L);
      localObject1 = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      p.k(paramBundle, "<set-?>");
      ((NormalMegaVideoLoader)localObject2).xHn = paramBundle;
      ((NormalMegaVideoLoader)localObject2).zwR = dKl();
      paramBundle = dKk();
      if (paramBundle != null) {
        ((NormalMegaVideoLoader)localObject2).initFromCache(paramBundle);
      }
      for (;;)
      {
        ((NormalMegaVideoLoader)localObject2).setInitDone((j)new b((NormalMegaVideoLoader)localObject2, this));
        ((NormalMegaVideoLoader)localObject2).xxM = ((m)new c(this));
        ((NormalMegaVideoLoader)localObject2).xxN = ((kotlin.g.a.b)new d(this));
        paramBundle = getRootView().findViewById(b.f.feed_detail_tips_layout);
        p.j(paramBundle, "rootView.findViewById<Vi….feed_detail_tips_layout)");
        this.zzB = paramBundle;
        paramBundle = this.zvV;
        if (paramBundle == null) {
          p.bGy("presenter");
        }
        localObject1 = (BaseMegaVideoLoader)localObject2;
        localObject2 = this.zxJ;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        paramBundle.a((BaseMegaVideoLoader)localObject1, (h.b)localObject2);
        AppMethodBeat.o(229655);
        return;
        ((NormalMegaVideoLoader)localObject2).initFromCache(getIntent());
      }
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229657);
    super.onDestroy();
    f localf = this.zvV;
    if (localf == null) {
      p.bGy("presenter");
    }
    localf.onDetach();
    AppMethodBeat.o(229657);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(NormalMegaVideoLoader paramNormalMegaVideoLoader, d paramd) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(225369);
      Object localObject = d.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(225369);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(279032);
            this.xMB.au(jdField_this.zzD.getInitPos(), 0);
            final long l = jdField_this.zzE.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(279032);
          }
        });
        AppMethodBeat.o(225369);
        return;
      }
      AppMethodBeat.o(225369);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$4"})
  static final class c
    extends q
    implements m<Integer, String, x>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$5"})
  static final class d
    extends q
    implements kotlin.g.a.b<bs, x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(d paramd, boolean paramBoolean, aa.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285049);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ((View)this.zzJ.aaBC).setVisibility(8);
      d.b(this.zzE).dsF();
      d.b(this.zzE).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.d
 * JD-Core Version:    0.7.0.1
 */