package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.plugin.finder.feed.logic.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "listener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1;", "shownSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkShow", "", "feedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "report21875", "", "Companion", "plugin-finder_release"})
public final class ac
  extends UIComponent
{
  public static final a Bmr;
  private final HashSet<Long> Bmp;
  private final c Bmq;
  
  static
  {
    AppMethodBeat.i(281806);
    Bmr = new a((byte)0);
    AppMethodBeat.o(281806);
  }
  
  public ac(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(281805);
    this.Bmp = new HashSet();
    this.Bmq = new c(this);
    AppMethodBeat.o(281805);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281803);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("report_scene", 0);
    paramBundle = d.xFu;
    if (d.MD(i))
    {
      Log.i("Finder.LikeGuideUIC", "FinderScanPreviewLogic hide likeGuide");
      AppMethodBeat.o(281803);
      return;
    }
    this.Bmq.alive();
    AppMethodBeat.o(281803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281804);
    super.onDestroy();
    this.Bmq.dead();
    AppMethodBeat.o(281804);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hq>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(ac.c paramc, hq paramhq)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ac
 * JD-Core Version:    0.7.0.1
 */