package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "icon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "plugin-finder_release"})
public final class c
{
  private final ImageView bwJ;
  private final View clickArea;
  final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  final d xYq;
  
  public c(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(283473);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_camera_opt_click_area);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ve_camera_opt_click_area)");
    this.clickArea = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_camera_opt_icon);
    p.j(paramViewGroup, "root.findViewById(R.id.f…der_live_camera_opt_icon)");
    this.bwJ = ((ImageView)paramViewGroup);
    this.clickArea.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276495);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.k(this.zlu.xYq.getBuContext()))
        {
          paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (!com.tencent.mm.plugin.finder.live.utils.a.l(this.zlu.xYq.getBuContext())) {}
        }
        else
        {
          w.makeText(this.zlu.kiF.getContext(), b.j.finder_live_opt_invalid_tips, 0).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276495);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("PARAM_FINDER_LIVE_CAMERA_OPT_SCENE", 1);
          this.zlu.kCL.statusChange(b.c.kAI, paramAnonymousView);
        }
      }
    });
    paramViewGroup = this.bwJ;
    paramb = this.kiF.getContext();
    p.j(paramb, "root.context");
    paramViewGroup.setImageDrawable(au.e(paramb.getResources().getDrawable(b.i.finder_live_view_setting_icon), -1));
    AppMethodBeat.o(283473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.c
 * JD-Core Version:    0.7.0.1
 */