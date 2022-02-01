package com.tencent.mm.plugin.finder.nearby.person;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$sayHiListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LbsSayHiEvent;", "callback", "", "event", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyPersonV1UIC$sayHiListener$1
  extends IListener<np>
{
  NearbyPersonV1UIC$sayHiListener$1(b paramb, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(339843);
    AppMethodBeat.o(339843);
  }
  
  private static final void g(b paramb)
  {
    AppMethodBeat.i(339850);
    s.u(paramb, "this$0");
    b.f(paramb);
    AppMethodBeat.o(339850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.sayHiListener.1
 * JD-Core Version:    0.7.0.1
 */