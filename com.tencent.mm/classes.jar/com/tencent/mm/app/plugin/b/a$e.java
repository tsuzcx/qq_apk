package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.h;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.sdk.event.IListener;

public final class a$e
  extends IListener<ga>
{
  h doE;
  String fileName;
  
  public a$e()
  {
    AppMethodBeat.i(161264);
    this.fileName = "";
    this.__eventId = ga.class.getName().hashCode();
    AppMethodBeat.o(161264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a.e
 * JD-Core Version:    0.7.0.1
 */