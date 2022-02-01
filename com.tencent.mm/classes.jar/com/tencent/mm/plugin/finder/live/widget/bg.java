package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "giftIcon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
{
  public static final bg.a Ewb;
  private static final String TAG;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final ImageView Ewc;
  private final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(361337);
    Ewb = new bg.a((byte)0);
    TAG = "Finder.FinderLiveVisitorGiftWidget";
    AppMethodBeat.o(361337);
  }
  
  public bg(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361320);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    paramViewGroup = this.mJe.findViewById(p.e.BLz);
    s.s(paramViewGroup, "root.findViewById(R.id.finder_live_gift_icon)");
    this.Ewc = ((ImageView)paramViewGroup);
    this.Ewc.setImageDrawable(bb.m(this.mJe.getContext(), p.g.icons_filled_gift, -1));
    this.mJe.setOnClickListener(new bg..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361320);
  }
  
  private static final void a(bg parambg, View paramView)
  {
    AppMethodBeat.i(361327);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambg);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambg, "this$0");
    ce.a.a((ce)j.Dob, q.s.Duv);
    b.b.a(parambg.nfT, b.c.ndq);
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361327);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361359);
    if ((!((e)this.CwG.business(e.class)).DUe) && (((e)this.CwG.business(e.class)).eyr()) && (((e)this.CwG.business(e.class)).isLiveStarted()))
    {
      if (this.mJe.getVisibility() != 0) {
        ce.a.a((ce)j.Dob, q.t.DvJ);
      }
      if (!((f)this.CwG.business(f.class)).akhc)
      {
        ((f)this.CwG.business(f.class)).akhc = true;
        ap localap = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
        if (localap != null)
        {
          Context localContext = this.mJe.getContext();
          s.s(localContext, "root.context");
          localap.gu(localContext);
        }
      }
      this.mJe.setVisibility(0);
    }
    for (;;)
    {
      k.Doi.a(q.cc.DEx, "", this.mJe.getVisibility());
      AppMethodBeat.o(361359);
      return;
      this.mJe.setVisibility(8);
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(361367);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(361367);
      return true;
    }
    AppMethodBeat.o(361367);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bg
 * JD-Core Version:    0.7.0.1
 */