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
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.e;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"})
public final class b
  extends a
{
  public static final a zyR;
  private h.b zxJ;
  private h.a zyr;
  
  static
  {
    AppMethodBeat.i(234402);
    zyR = new a((byte)0);
    AppMethodBeat.o(234402);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(234400);
    AppMethodBeat.o(234400);
  }
  
  public final h.a dKn()
  {
    AppMethodBeat.i(234399);
    h.a locala = this.zyr;
    if (locala == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(234399);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234396);
    super.onCreate(paramBundle);
    this.zyr = ((h.a)new f(getActivity(), (UIComponent)this));
    paramBundle = getActivity();
    Object localObject = this.zyr;
    if (localObject == null) {
      p.bGy("presenter");
    }
    this.zxJ = ((h.b)new e(paramBundle, (h.a)localObject, getRootView()));
    paramBundle = z.bdh();
    p.j(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = g.Xox;
    localObject = new FinderFavMegaVideoLoader(paramBundle, ((aj)g.b(getActivity()).i(aj.class)).ekY());
    ((FinderFavMegaVideoLoader)localObject).initFromCache(getIntent());
    ((FinderFavMegaVideoLoader)localObject).setInitDone((j)new b((FinderFavMegaVideoLoader)localObject, this));
    paramBundle = this.zyr;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    localObject = (BaseMegaVideoLoader)localObject;
    h.b localb = this.zxJ;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    paramBundle.a((BaseMegaVideoLoader)localObject, localb);
    AppMethodBeat.o(234396);
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234397);
    super.onDestroy();
    h.a locala = this.zyr;
    if (locala == null) {
      p.bGy("presenter");
    }
    locala.onDetach();
    AppMethodBeat.o(234397);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader, b paramb) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(281468);
      Object localObject = b.a(jdField_this).getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(281468);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(287210);
            this.xMB.au(jdField_this.zyS.getInitPos(), 0);
            final long l = jdField_this.zyT.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(287210);
          }
        });
        AppMethodBeat.o(281468);
        return;
      }
      AppMethodBeat.o(281468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.b
 * JD-Core Version:    0.7.0.1
 */