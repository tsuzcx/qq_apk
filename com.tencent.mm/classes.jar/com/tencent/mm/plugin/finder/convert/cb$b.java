package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class cb$b
  implements View.OnClickListener
{
  public cb$b(kotlin.g.a.b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(243263);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.tGb.invoke(Integer.valueOf(this.tGc));
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(243263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cb.b
 * JD-Core Version:    0.7.0.1
 */