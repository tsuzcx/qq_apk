package com.tencent.mm.plugin.finder.video;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.djh;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class FinderVideoLayout$e
  extends u
  implements kotlin.g.a.a<View>
{
  FinderVideoLayout$e(FinderVideoLayout paramFinderVideoLayout)
  {
    super(0);
  }
  
  private static final void a(FinderVideoLayout paramFinderVideoLayout, View paramView1, View paramView2)
  {
    AppMethodBeat.i(335254);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderVideoLayout);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderVideoLayout, "this$0");
    paramView2 = new djh();
    paramView2.mediaList.addAll((Collection)FinderVideoLayout.m(paramFinderVideoLayout));
    paramFinderVideoLayout = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramFinderVideoLayout = paramView1.getContext();
    if (paramFinderVideoLayout == null)
    {
      paramFinderVideoLayout = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(335254);
      throw paramFinderVideoLayout;
    }
    com.tencent.mm.plugin.finder.utils.a.a((Activity)paramFinderVideoLayout, null, paramView2, null, false, false, 56);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout.e
 * JD-Core Version:    0.7.0.1
 */