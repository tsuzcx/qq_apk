package com.tencent.mm.plugin.finder.megavideo.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1
  extends IListener<ic>
{
  FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(342023);
    AppMethodBeat.o(342023);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoProfileUIContract.Presenter.feedProgressListener.1
 * JD-Core Version:    0.7.0.1
 */