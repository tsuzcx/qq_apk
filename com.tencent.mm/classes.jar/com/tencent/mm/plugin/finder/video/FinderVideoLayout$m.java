package com.tencent.mm.plugin.finder.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class FinderVideoLayout$m
  extends u
  implements kotlin.g.a.a<View>
{
  FinderVideoLayout$m(FinderVideoLayout paramFinderVideoLayout)
  {
    super(0);
  }
  
  private static final void a(FinderVideoLayout paramFinderVideoLayout, View paramView)
  {
    AppMethodBeat.i(335173);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderVideoLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderVideoLayout, "this$0");
    Log.i(FinderVideoLayout.j(paramFinderVideoLayout), s.X("retry video, position:", Integer.valueOf(paramFinderVideoLayout.getPlayAdapterPosition())));
    paramView = paramFinderVideoLayout.getPlayInfo();
    if ((paramView != null) && (paramView.GqL == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = paramFinderVideoLayout.getVideoView();
        if (paramView != null) {
          paramView.stop();
        }
        FinderVideoLayout.a(paramFinderVideoLayout, paramFinderVideoLayout.getPlayAdapterPosition(), 2);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(335173);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout.m
 * JD-Core Version:    0.7.0.1
 */