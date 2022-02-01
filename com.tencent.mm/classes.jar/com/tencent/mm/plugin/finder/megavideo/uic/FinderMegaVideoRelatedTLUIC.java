package com.tencent.mm.plugin.finder.megavideo.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoRelatedLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoRelatedTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoRelatedTLUIC
  extends BaseMegaVideoTLUIC
{
  public static final a uNt;
  private h.b uLW;
  private h.a uMy;
  
  static
  {
    AppMethodBeat.i(248667);
    uNt = new a((byte)0);
    AppMethodBeat.o(248667);
  }
  
  public FinderMegaVideoRelatedTLUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248666);
    AppMethodBeat.o(248666);
  }
  
  public final h.a dkq()
  {
    AppMethodBeat.i(248665);
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(248665);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131494494;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(248663);
    super.onCreate(paramBundle);
    this.uMy = ((h.a)new f(getActivity(), (UIComponent)this));
    paramBundle = getActivity();
    Object localObject = this.uMy;
    if (localObject == null) {
      p.btv("presenter");
    }
    this.uLW = ((h.b)new g(paramBundle, (h.a)localObject, getRootView()));
    long l = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0L);
    paramBundle = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = new FinderMegaVideoRelatedLoader(l, paramBundle, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
      ((FinderMegaVideoRelatedLoader)localObject).initFromCache(getIntent());
      ((FinderMegaVideoRelatedLoader)localObject).setInitDone((h)new b((FinderMegaVideoRelatedLoader)localObject, this));
      paramBundle = this.uMy;
      if (paramBundle == null) {
        p.btv("presenter");
      }
      localObject = (BaseMegaVideoLoader)localObject;
      h.b localb = this.uLW;
      if (localb == null) {
        p.btv("viewCallback");
      }
      paramBundle.a((BaseMegaVideoLoader)localObject, localb);
      AppMethodBeat.o(248663);
      return;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248664);
    super.onDestroy();
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(248664);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoRelatedTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoRelatedTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderMegaVideoRelatedLoader paramFinderMegaVideoRelatedLoader, FinderMegaVideoRelatedTLUIC paramFinderMegaVideoRelatedTLUIC) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(248662);
      Object localObject = FinderMegaVideoRelatedTLUIC.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(248662);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248661);
            this.uMV.ah(jdField_this.uNu.getInitPos(), 0);
            final long l = jdField_this.uNv.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(248661);
          }
        });
        AppMethodBeat.o(248662);
        return;
      }
      AppMethodBeat.o(248662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoRelatedTLUIC
 * JD-Core Version:    0.7.0.1
 */