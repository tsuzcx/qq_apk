package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$h
  implements View.OnClickListener
{
  e$h(e parame, String paramString, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(178102);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = p.sXz;
    p.a(this.oTF, this.rUA, this.rUw);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(178102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.h
 * JD-Core Version:    0.7.0.1
 */