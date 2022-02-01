package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorFansClubWidget;", "", "activity", "Landroid/app/Activity;", "container", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "getActivity", "()Landroid/app/Activity;", "getContainer", "()Landroid/view/ViewGroup;", "fansClubBuildWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansBuildWidget;", "getFansClubBuildWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansBuildWidget;", "fansClubListWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;", "getFansClubListWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;", "mount", "", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "onKeyboardHeightChanged", "height", "", "show", "", "showFansMemberClub", "showModify", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a ElM;
  private final ViewGroup CAj;
  private final aa ElN;
  public final x ElO;
  private final Activity activity;
  
  static
  {
    AppMethodBeat.i(361024);
    ElM = new g.a((byte)0);
    AppMethodBeat.o(361024);
  }
  
  public g(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361017);
    this.activity = paramActivity;
    this.CAj = paramViewGroup;
    this.ElN = new aa((Context)this.activity);
    paramActivity = new x(this.activity, this.CAj);
    paramActivity.setCreateResultCallback((m)new b(paramActivity, this));
    paramViewGroup = ah.aiuX;
    this.ElO = paramActivity;
    AppMethodBeat.o(361017);
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(361043);
    s.u(paramb, "basePlugin");
    this.ElN.c(paramb);
    this.ElO.c(paramb);
    AppMethodBeat.o(361043);
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(361032);
    this.ElN.sA(paramBoolean);
    this.ElO.onKeyboardHeightChanged(paramInt, paramBoolean);
    AppMethodBeat.o(361032);
  }
  
  public final void sw(boolean paramBoolean)
  {
    AppMethodBeat.i(361037);
    this.ElN.a(null, paramBoolean);
    AppMethodBeat.o(361037);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(361050);
    this.ElN.unMount();
    this.ElO.unMount();
    AppMethodBeat.o(361050);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "fansClubName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Boolean, String, ah>
  {
    b(x paramx, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.g
 * JD-Core Version:    0.7.0.1
 */