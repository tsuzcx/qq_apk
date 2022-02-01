package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.in;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentDrawerPresenter$commentErrorListener$1
  extends IListener<in>
{
  FinderCommentDrawerPresenter$commentErrorListener$1(f paramf, com.tencent.mm.app.f paramf1)
  {
    super((q)paramf1);
    AppMethodBeat.i(363859);
    AppMethodBeat.o(363859);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(f paramf, in paramin)
    {
      super();
    }
    
    private static final void a(f paramf, View paramView)
    {
      AppMethodBeat.i(364122);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramf);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1$callback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramf, "this$0");
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramf = paramf.AUk;
      if (paramf == null) {}
      for (paramf = null; paramf == null; paramf = paramf.getContext())
      {
        paramf = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(364122);
        throw paramf;
      }
      com.tencent.mm.plugin.finder.utils.a.aK((Activity)paramf);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1$callback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364122);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter.commentErrorListener.1
 * JD-Core Version:    0.7.0.1
 */