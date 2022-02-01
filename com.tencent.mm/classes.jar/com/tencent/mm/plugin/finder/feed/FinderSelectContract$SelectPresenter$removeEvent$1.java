package com.tencent.mm.plugin.finder.feed;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.g;
import com.tencent.mm.autogen.a.g.a;
import com.tencent.mm.plugin.finder.model.l;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.event.IListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelectContract$SelectPresenter$removeEvent$1
  extends IListener<g>
{
  FinderSelectContract$SelectPresenter$removeEvent$1(ar.a parama, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(362439);
    AppMethodBeat.o(362439);
  }
  
  private boolean a(g paramg)
  {
    AppMethodBeat.i(362448);
    s.u(paramg, "event");
    final ar.a locala = this.AYH;
    final ah.d locald = new ah.d();
    Iterator localIterator = ((Iterable)ar.a.c(locala)).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if ((locall.AtP.ocD == paramg.hyM.hyN) && (locall.AtP.EOg > 0))
      {
        awt localawt = locall.AtP;
        localawt.EOg -= 1;
        ar.a.a(locala).bTu();
        d.uiThread((a)new a(locall, locala, locald));
      }
      else
      {
        locald.aixb += 1;
      }
    }
    AppMethodBeat.o(362448);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(l paraml, ar.a parama, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderSelectContract.SelectPresenter.removeEvent.1
 * JD-Core Version:    0.7.0.1
 */