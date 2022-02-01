package com.tencent.mm.plugin.finder.preload;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acc;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/MediaPreloadCore$videoDownloadProgressChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VideoFeedProgressChangeEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaPreloadCore$videoDownloadProgressChangeListener$1
  extends IListener<acc>
{
  MediaPreloadCore$videoDownloadProgressChangeListener$1(f paramf, com.tencent.mm.app.f paramf1)
  {
    super((q)paramf1);
    AppMethodBeat.i(346141);
    AppMethodBeat.o(346141);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(f paramf, acc paramacc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore.videoDownloadProgressChangeListener.1
 * JD-Core Version:    0.7.0.1
 */