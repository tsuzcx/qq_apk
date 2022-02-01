package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.upload.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ce$c
  implements View.OnClickListener
{
  ce$c(bi parambi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(259188);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = g.AAk;
    g.ecj().v(this.xoy.zBk);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(259188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ce.c
 * JD-Core Version:    0.7.0.1
 */