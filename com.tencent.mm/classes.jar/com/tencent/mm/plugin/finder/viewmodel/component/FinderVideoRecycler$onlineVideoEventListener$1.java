package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.View;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ra;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoRecycler$onlineVideoEventListener$1
  extends IListener<ra>
{
  FinderVideoRecycler$onlineVideoEventListener$1(be parambe, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(337468);
    AppMethodBeat.o(337468);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<t, Boolean>
  {
    a(String paramString, be parambe)
    {
      super();
    }
    
    private static final void c(t paramt)
    {
      AppMethodBeat.i(338621);
      s.u(paramt, "$it");
      paramt = paramt.getParentView();
      if (paramt == null)
      {
        paramt = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
        AppMethodBeat.o(338621);
        throw paramt;
      }
      ((FinderVideoLayout)paramt).getRetryBtn().performClick();
      AppMethodBeat.o(338621);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.onlineVideoEventListener.1
 * JD-Core Version:    0.7.0.1
 */