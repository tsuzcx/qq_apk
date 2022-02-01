package com.tencent.mm.plugin.finder.megavideo.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.NormalMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showRetryTips", "ifShow", "", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoNormalTLUIC
  extends BaseMegaVideoTLUIC
{
  public static final a uNg;
  private h.b uLW;
  private h.a uMy;
  private View uNf;
  
  static
  {
    AppMethodBeat.i(248646);
    uNg = new a((byte)0);
    AppMethodBeat.o(248646);
  }
  
  public FinderMegaVideoNormalTLUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248645);
    AppMethodBeat.o(248645);
  }
  
  public final h.a dkq()
  {
    AppMethodBeat.i(248644);
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(248644);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131494494;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(248642);
    super.onCreate(paramBundle);
    this.uMy = ((h.a)new f(getActivity(), (UIComponent)this));
    paramBundle = getActivity();
    Object localObject1 = this.uMy;
    if (localObject1 == null) {
      p.btv("presenter");
    }
    this.uLW = ((h.b)new g(paramBundle, (h.a)localObject1, getRootView()));
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
    localObject1 = getActivity();
    if (localObject1 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(248642);
      throw paramBundle;
    }
    Object localObject2 = new NormalMegaVideoLoader(paramBundle, (MMFragmentActivity)localObject1);
    ((NormalMegaVideoLoader)localObject2).uLp = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    p.h(paramBundle, "<set-?>");
    ((NormalMegaVideoLoader)localObject2).uLq = paramBundle;
    ((NormalMegaVideoLoader)localObject2).uKX = this.uMQ;
    paramBundle = this.uMO;
    if (paramBundle != null) {
      ((NormalMegaVideoLoader)localObject2).initFromCache(paramBundle);
    }
    for (;;)
    {
      ((NormalMegaVideoLoader)localObject2).setInitDone((h)new b((NormalMegaVideoLoader)localObject2, this));
      ((NormalMegaVideoLoader)localObject2).tNM = ((m)new c(this));
      ((NormalMegaVideoLoader)localObject2).tNN = ((kotlin.g.a.b)new d(this));
      paramBundle = getRootView().findViewById(2131300566);
      p.g(paramBundle, "rootView.findViewById<Vi….feed_detail_tips_layout)");
      this.uNf = paramBundle;
      paramBundle = this.uMy;
      if (paramBundle == null) {
        p.btv("presenter");
      }
      localObject1 = (BaseMegaVideoLoader)localObject2;
      localObject2 = this.uLW;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      paramBundle.a((BaseMegaVideoLoader)localObject1, (h.b)localObject2);
      AppMethodBeat.o(248642);
      return;
      ((NormalMegaVideoLoader)localObject2).initFromCache(getIntent());
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248643);
    super.onDestroy();
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(248643);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(NormalMegaVideoLoader paramNormalMegaVideoLoader, FinderMegaVideoNormalTLUIC paramFinderMegaVideoNormalTLUIC) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(248636);
      Object localObject = FinderMegaVideoNormalTLUIC.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(248636);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248635);
            this.uMV.ah(jdField_this.uNh.getInitPos(), 0);
            final long l = jdField_this.uNi.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(248635);
          }
        });
        AppMethodBeat.o(248636);
        return;
      }
      AppMethodBeat.o(248636);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$4"})
  static final class c
    extends q
    implements m<Integer, String, x>
  {
    c(FinderMegaVideoNormalTLUIC paramFinderMegaVideoNormalTLUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$5"})
  static final class d
    extends q
    implements kotlin.g.a.b<bm, x>
  {
    d(FinderMegaVideoNormalTLUIC paramFinderMegaVideoNormalTLUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderMegaVideoNormalTLUIC paramFinderMegaVideoNormalTLUIC, boolean paramBoolean, z.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248641);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((View)this.uNn.SYG).setVisibility(8);
      FinderMegaVideoNormalTLUIC.c(this.uNi).dcp();
      FinderMegaVideoNormalTLUIC.c(this.uNi).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC
 * JD-Core Version:    0.7.0.1
 */