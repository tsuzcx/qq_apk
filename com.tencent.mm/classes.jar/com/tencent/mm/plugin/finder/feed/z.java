package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract;", "", "()V", "PoiFeedPresenter", "PoiFeedViewCallback", "plugin-finder_release"})
public final class z
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b$e
    implements View.OnClickListener
  {
    b$e(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244020);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tPl.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z
 * JD-Core Version:    0.7.0.1
 */