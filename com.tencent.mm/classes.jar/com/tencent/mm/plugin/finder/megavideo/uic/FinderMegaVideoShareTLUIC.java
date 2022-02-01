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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoShareLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showProgress", "ifShow", "", "showRetryTips", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoShareTLUIC
  extends BaseMegaVideoTLUIC
{
  public static final a uNy;
  private h.b uLW;
  private h.a uMy;
  private View uNf;
  
  static
  {
    AppMethodBeat.i(248680);
    uNy = new a((byte)0);
    AppMethodBeat.o(248680);
  }
  
  public FinderMegaVideoShareTLUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248679);
    AppMethodBeat.o(248679);
  }
  
  private final void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(248676);
    if (getRootView().findViewById(2131307806) != null)
    {
      if (paramBoolean)
      {
        localView = getRootView().findViewById(2131307806);
        p.g(localView, "rootView.findViewById<Vi…R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(248676);
        return;
      }
      View localView = getRootView().findViewById(2131307806);
      p.g(localView, "rootView.findViewById<Vi…R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(248676);
  }
  
  public final h.a dkq()
  {
    AppMethodBeat.i(248678);
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(248678);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131494511;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(248675);
    super.onCreate(paramBundle);
    long l = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject1 = getIntent().getStringExtra("feed_object_nonceId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    localObject1 = getIntent().getStringExtra("finder_user_name");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.uMy = ((h.a)new f(getActivity(), (UIComponent)this));
      Object localObject2 = getActivity();
      Object localObject3 = this.uMy;
      if (localObject3 == null) {
        p.btv("presenter");
      }
      this.uLW = ((h.b)new g((AppCompatActivity)localObject2, (h.a)localObject3, getRootView()));
      localObject3 = getIntent().getStringExtra("key_from_user_name");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      Object localObject4 = getIntent().getStringExtra("key_to_user_name");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      localObject4 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = new FinderMegaVideoShareLoader(l, paramBundle, (String)localObject2, (String)localObject3, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
      p.h(localObject1, "<set-?>");
      ((FinderMegaVideoShareLoader)localObject2).uKW = ((String)localObject1);
      ((FinderMegaVideoShareLoader)localObject2).tNM = ((m)new b(this, (String)localObject1));
      ((FinderMegaVideoShareLoader)localObject2).uLa = ((kotlin.g.a.a)new c(this, (String)localObject1));
      ((FinderMegaVideoShareLoader)localObject2).initFromCache(getIntent());
      ((FinderMegaVideoShareLoader)localObject2).setInitDone((h)new d((FinderMegaVideoShareLoader)localObject2, this, (String)localObject1));
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
      paramBundle = getRootView().findViewById(2131307805);
      p.g(paramBundle, "rootView.findViewById(R.…_feed_detail_tips_layout)");
      this.uNf = paramBundle;
      if (l != 0L) {
        nK(true);
      }
      AppMethodBeat.o(248675);
      return;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248677);
    super.onDestroy();
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(248677);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$1"})
  static final class b
    extends q
    implements m<Integer, String, x>
  {
    b(FinderMegaVideoShareTLUIC paramFinderMegaVideoShareTLUIC, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$2"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(FinderMegaVideoShareTLUIC paramFinderMegaVideoShareTLUIC, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements h
  {
    d(FinderMegaVideoShareLoader paramFinderMegaVideoShareLoader, FinderMegaVideoShareTLUIC paramFinderMegaVideoShareTLUIC, String paramString) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(248673);
      Object localObject = FinderMegaVideoShareTLUIC.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(248673);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248672);
            this.uMV.ah(jdField_this.uNA.getInitPos(), 0);
            final long l = jdField_this.uNz.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(248672);
          }
        });
        AppMethodBeat.o(248673);
        return;
      }
      AppMethodBeat.o(248673);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderMegaVideoShareTLUIC paramFinderMegaVideoShareTLUIC, boolean paramBoolean, z.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248674);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderMegaVideoShareTLUIC.a(this.uNz, true);
      ((View)this.uNn.SYG).setVisibility(8);
      FinderMegaVideoShareTLUIC.c(this.uNz).dcp();
      FinderMegaVideoShareTLUIC.c(this.uNz).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoShareTLUIC
 * JD-Core Version:    0.7.0.1
 */