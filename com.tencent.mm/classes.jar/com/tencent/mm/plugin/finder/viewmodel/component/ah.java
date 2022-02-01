package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.feed.logic.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "canShowGuide", "", "listener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1;", "shownSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkShow", "", "feedId", "isGuideShow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "report21875", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends UIComponent
{
  public static final a GRY;
  boolean GRZ;
  private final HashSet<Long> GSa;
  private final FinderLikeGuideUIC.listener.1 GSb;
  
  static
  {
    AppMethodBeat.i(338797);
    GRY = new a((byte)0);
    AppMethodBeat.o(338797);
  }
  
  public ah(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338759);
    this.GRZ = true;
    this.GSa = new HashSet();
    this.GSb = new FinderLikeGuideUIC.listener.1(this, f.hfK);
    AppMethodBeat.o(338759);
  }
  
  private static final boolean a(ah.f paramf, LinearLayout paramLinearLayout, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(338764);
    s.u(paramf, "$itemView");
    s.u(paramLinearLayout, "$container");
    if (paramMotionEvent.getAction() == 0) {
      ((ViewGroup)paramf.aqH).removeView((View)paramLinearLayout);
    }
    AppMethodBeat.o(338764);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338810);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("report_scene", 0);
    paramBundle = d.Beq;
    if (d.Oa(i))
    {
      Log.i("Finder.LikeGuideUIC", "FinderScanPreviewLogic hide likeGuide");
      AppMethodBeat.o(338810);
      return;
    }
    this.GSb.alive();
    AppMethodBeat.o(338810);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338818);
    super.onDestroy();
    this.GSb.dead();
    AppMethodBeat.o(338818);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ah
 * JD-Core Version:    0.7.0.1
 */