package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.sdk.event.IListener;

public final class b
  extends IListener<wq>
{
  public b()
  {
    AppMethodBeat.i(160600);
    this.__eventId = wq.class.getName().hashCode();
    AppMethodBeat.o(160600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b
 * JD-Core Version:    0.7.0.1
 */