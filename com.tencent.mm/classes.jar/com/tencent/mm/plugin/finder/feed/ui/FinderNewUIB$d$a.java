package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderNewUIB$d$a
  implements View.OnClickListener
{
  FinderNewUIB$d$a(FinderNewUIB.d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203251);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1$getLoadMoreFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
    ((t)g.ad(t.class)).enterFinderTimelineUI((Context)this.soj.soi.getContext(), paramView);
    this.soj.soi.finish();
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1$getLoadMoreFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB.d.a
 * JD-Core Version:    0.7.0.1
 */