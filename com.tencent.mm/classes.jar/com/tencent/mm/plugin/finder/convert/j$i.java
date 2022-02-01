package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class j$i
  implements View.OnClickListener
{
  j$i(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242801);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = this.qhp.Mn(2131297134);
    if (paramView != null) {
      paramView.callOnClick();
    }
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j.i
 * JD-Core Version:    0.7.0.1
 */