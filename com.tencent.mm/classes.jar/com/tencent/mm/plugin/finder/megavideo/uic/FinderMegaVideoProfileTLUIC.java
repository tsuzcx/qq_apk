package com.tencent.mm.plugin.finder.megavideo.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.e;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoProfileTLUIC
  extends BaseMegaVideoTLUIC
{
  public static final a uNo;
  private h.b uLW;
  private h.a uMy;
  
  static
  {
    AppMethodBeat.i(248658);
    uNo = new a((byte)0);
    AppMethodBeat.o(248658);
  }
  
  public FinderMegaVideoProfileTLUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248657);
    AppMethodBeat.o(248657);
  }
  
  public final h.a dkq()
  {
    AppMethodBeat.i(248656);
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(248656);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131494494;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(248654);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("finder_username");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      Object localObject1 = new f(getActivity(), (UIComponent)this);
      ((f)localObject1).uLZ = z.In(paramBundle);
      this.uMy = ((h.a)localObject1);
      localObject1 = getActivity();
      Object localObject2 = this.uMy;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      this.uLW = ((h.b)new e((AppCompatActivity)localObject1, (h.a)localObject2, getRootView()));
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = new FinderMegaVideoProfileLoader(paramBundle, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
      ((FinderMegaVideoProfileLoader)localObject1).initFromCache(getIntent());
      ((FinderMegaVideoProfileLoader)localObject1).setInitDone((h)new b((FinderMegaVideoProfileLoader)localObject1, this));
      paramBundle = this.uMy;
      if (paramBundle == null) {
        p.btv("presenter");
      }
      localObject1 = (BaseMegaVideoLoader)localObject1;
      localObject2 = this.uLW;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      paramBundle.a((BaseMegaVideoLoader)localObject1, (h.b)localObject2);
      AppMethodBeat.o(248654);
      return;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248655);
    super.onDestroy();
    h.a locala = this.uMy;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(248655);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, FinderMegaVideoProfileTLUIC paramFinderMegaVideoProfileTLUIC) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(248653);
      Object localObject = FinderMegaVideoProfileTLUIC.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(248653);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248652);
            this.uMV.ah(jdField_this.uNp.getInitPos() - jdField_this.uNp.uKR, 0);
            final long l = jdField_this.uNq.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(248652);
          }
        });
        AppMethodBeat.o(248653);
        return;
      }
      AppMethodBeat.o(248653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoProfileTLUIC
 * JD-Core Version:    0.7.0.1
 */