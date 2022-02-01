package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class k$b
  implements View.OnLongClickListener
{
  public static final b xhr;
  
  static
  {
    AppMethodBeat.i(292070);
    xhr = new b();
    AppMethodBeat.o(292070);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(292069);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    a.a(false, this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(292069);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k.b
 * JD-Core Version:    0.7.0.1
 */