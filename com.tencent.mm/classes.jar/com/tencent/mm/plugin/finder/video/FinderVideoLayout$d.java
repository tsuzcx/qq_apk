package com.tencent.mm.plugin.finder.video;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.e;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class FinderVideoLayout$d
  extends u
  implements kotlin.g.a.a<TextView>
{
  FinderVideoLayout$d(FinderVideoLayout paramFinderVideoLayout)
  {
    super(0);
  }
  
  private static final void a(FinderVideoLayout paramFinderVideoLayout, View paramView)
  {
    AppMethodBeat.i(335239);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderVideoLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderVideoLayout, "this$0");
    paramView = FinderVideoLayout.g(paramFinderVideoLayout);
    s.checkNotNull(paramView);
    if (!paramView.getFunctionSwitch()) {}
    for (boolean bool = true;; bool = false)
    {
      FinderVideoLayout.l(paramFinderVideoLayout).setSelected(bool);
      h.baE().ban().set(at.a.adee, Boolean.valueOf(bool));
      paramFinderVideoLayout = FinderVideoLayout.g(paramFinderVideoLayout);
      s.checkNotNull(paramFinderVideoLayout);
      paramFinderVideoLayout.V(bool, true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(335239);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout.d
 * JD-Core Version:    0.7.0.1
 */