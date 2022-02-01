package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.at;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "firstShow", "", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "initView", "isVisible", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "reportShowMusicPanel", "setVisible", "visible", "", "showMusicPanel", "showMusicPanelImpl", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a ElJ;
  public static final String ElL;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public boolean ElK;
  private final String TAG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(361034);
    ElJ = new e.a((byte)0);
    ElL = "PORTRAIT_ACTION_GOTO_CREATE_MUSIC";
    AppMethodBeat.o(361034);
  }
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361016);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchoMusicEntranceWidget";
    this.ElK = true;
    this.mJe.setOnClickListener(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361016);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(361027);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parame, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.DuS;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    if (parame.CwG.isLandscape()) {
      com.tencent.mm.plugin.finder.live.plugin.b.a(parame.CwG, ElL);
    }
    for (;;)
    {
      parame = new JSONObject();
      parame.put("type", q.at.DzI.action);
      j.Dob.a(q.c.DrC, parame.toString());
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361027);
      return;
      parame.ezU();
    }
  }
  
  public final void ezU()
  {
    AppMethodBeat.i(361047);
    b.b.a(this.nfT, b.c.ndH);
    AppMethodBeat.o(361047);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361054);
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(361054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.e
 * JD-Core Version:    0.7.0.1
 */