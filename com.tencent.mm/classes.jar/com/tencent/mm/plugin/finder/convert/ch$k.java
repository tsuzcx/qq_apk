package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ch$k
  implements View.OnClickListener
{
  ch$k(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(243301);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = this.qhp.aus;
    p.g(paramView, "holder.itemView");
    ((LinearLayout)paramView.findViewById(2131298012)).callOnClick();
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(243301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ch.k
 * JD-Core Version:    0.7.0.1
 */