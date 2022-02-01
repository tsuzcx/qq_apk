package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class j$b
  implements View.OnLongClickListener
{
  public static final b tzH;
  
  static
  {
    AppMethodBeat.i(242793);
    tzH = new b();
    AppMethodBeat.o(242793);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(242792);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(false, this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(242792);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j.b
 * JD-Core Version:    0.7.0.1
 */