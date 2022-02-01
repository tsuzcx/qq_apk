package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class u$e
  implements View.OnClickListener
{
  public u$e(u paramu, kotlin.g.a.a parama, TextView paramTextView, View paramView1, View paramView2, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(288528);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC$showFollowAnim$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    this.Bkp.invoke();
    this.Bkq.setText(b.j.has_follow_tip);
    this.Bkq.setTextColor(this.Bko.getContext().getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
    paramView = this.Bkr;
    p.j(paramView, "followIcon");
    paramView.setVisibility(8);
    paramView = this.Bkm;
    p.j(paramView, "followBtn");
    paramView.setBackground(this.tDl.getContext().getDrawable(b.e.finder_feed_has_followed_btn_bg));
    paramView = this.tDl.getContext();
    p.j(paramView, "holder.context");
    int i = paramView.getResources().getDimensionPixelOffset(b.d.Edge_A);
    paramView = this.Bkm;
    p.j(paramView, "followBtn");
    int j = paramView.getPaddingTop();
    localObject = this.Bkm;
    p.j(localObject, "followBtn");
    paramView.setPadding(i, j, i, ((View)localObject).getPaddingBottom());
    this.Bkm.setOnClickListener(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC$showFollowAnim$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.u.e
 * JD-Core Version:    0.7.0.1
 */