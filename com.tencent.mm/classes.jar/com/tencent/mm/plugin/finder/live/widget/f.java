package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "firstShow", "", "icon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "setVisible", "visible", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public boolean ElK;
  private final View clickArea;
  private final ImageView dpM;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public f(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361014);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    paramViewGroup = this.mJe.findViewById(p.e.BIf);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ve_camera_opt_click_area)");
    this.clickArea = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BIg);
    s.s(paramViewGroup, "root.findViewById(R.id.f…der_live_camera_opt_icon)");
    this.dpM = ((ImageView)paramViewGroup);
    this.ElK = true;
    this.clickArea.setOnClickListener(new f..ExternalSyntheticLambda0(this));
    this.dpM.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.finder_live_view_setting_icon), -1));
    AppMethodBeat.o(361014);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(361023);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramf, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.DuW;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    paramView = new Bundle();
    paramView.putInt("PARAM_FINDER_LIVE_CAMERA_OPT_SCENE", 1);
    paramf.nfT.statusChange(b.c.nef, paramView);
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.f
 * JD-Core Version:    0.7.0.1
 */