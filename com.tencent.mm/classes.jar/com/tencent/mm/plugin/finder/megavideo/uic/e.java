package com.tencent.mm.plugin.finder.megavideo.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  public static final a zzK;
  private h.b zxJ;
  private h.a zyr;
  
  static
  {
    AppMethodBeat.i(272185);
    zzK = new a((byte)0);
    AppMethodBeat.o(272185);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(272184);
    AppMethodBeat.o(272184);
  }
  
  public final h.a dKn()
  {
    AppMethodBeat.i(272183);
    h.a locala = this.zyr;
    if (locala == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(272183);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(272181);
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
        this.zyr = ((h.a)localObject1);
        localObject1 = getActivity();
        Object localObject2 = this.zyr;
        if (localObject2 == null) {
          p.bGy("presenter");
        }
        this.zxJ = ((h.b)new com.tencent.mm.plugin.finder.megavideo.ui.e((AppCompatActivity)localObject1, (h.a)localObject2, getRootView()));
        localObject1 = g.Xox;
        localObject1 = new FinderMegaVideoProfileLoader(paramBundle, ((aj)g.b(getActivity()).i(aj.class)).ekY());
        ((FinderMegaVideoProfileLoader)localObject1).initFromCache(getIntent());
        ((FinderMegaVideoProfileLoader)localObject1).setInitDone((j)new b((FinderMegaVideoProfileLoader)localObject1, this));
        paramBundle = this.zyr;
        if (paramBundle == null) {
          p.bGy("presenter");
        }
        localObject1 = (BaseMegaVideoLoader)localObject1;
        localObject2 = this.zxJ;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        paramBundle.a((BaseMegaVideoLoader)localObject1, (h.b)localObject2);
        AppMethodBeat.o(272181);
        return;
      }
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(272182);
    super.onDestroy();
    h.a locala = this.zyr;
    if (locala == null) {
      p.bGy("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(272182);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, e parame) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(285053);
      Object localObject = e.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(285053);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(285919);
            this.xMB.au(jdField_this.zzL.getInitPos() - jdField_this.zzL.zwI, 0);
            final long l = jdField_this.zzM.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(285919);
          }
        });
        AppMethodBeat.o(285053);
        return;
      }
      AppMethodBeat.o(285053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.e
 * JD-Core Version:    0.7.0.1
 */