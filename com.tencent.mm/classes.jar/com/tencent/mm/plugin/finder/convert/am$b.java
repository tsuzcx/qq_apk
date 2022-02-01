package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class am$b
  implements View.OnClickListener
{
  am$b(ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(243126);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.tEl.callOnClick();
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(243126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am.b
 * JD-Core Version:    0.7.0.1
 */