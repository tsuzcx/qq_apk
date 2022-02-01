package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "drawer$delegate", "Lkotlin/Lazy;", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends UIComponent
{
  public static final a GPf;
  private final j GPg;
  
  static
  {
    AppMethodBeat.i(337688);
    GPf = new a((byte)0);
    AppMethodBeat.o(337688);
  }
  
  public r(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337680);
    this.GPg = k.cm((a)new b(paramAppCompatActivity));
    AppMethodBeat.o(337680);
  }
  
  public final FinderLikeDrawer fny()
  {
    AppMethodBeat.i(337698);
    FinderLikeDrawer localFinderLikeDrawer = (FinderLikeDrawer)this.GPg.getValue();
    AppMethodBeat.o(337698);
    return localFinderLikeDrawer;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(337711);
    if (fny() == null)
    {
      AppMethodBeat.o(337711);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = fny();
    s.checkNotNull(localFinderLikeDrawer);
    if (localFinderLikeDrawer.fkp())
    {
      localFinderLikeDrawer = fny();
      s.checkNotNull(localFinderLikeDrawer);
      localFinderLikeDrawer.fdh();
      AppMethodBeat.o(337711);
      return true;
    }
    AppMethodBeat.o(337711);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(337725);
    super.onPause();
    AppMethodBeat.o(337725);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337718);
    super.onResume();
    AppMethodBeat.o(337718);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<FinderLikeDrawer>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.r
 * JD-Core Version:    0.7.0.1
 */