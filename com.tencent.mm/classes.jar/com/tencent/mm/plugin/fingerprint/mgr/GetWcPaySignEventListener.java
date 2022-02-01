package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.mc;
import com.tencent.mm.sdk.event.IListener;

public class GetWcPaySignEventListener
  extends IListener<mc>
{
  public GetWcPaySignEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160795);
    this.__eventId = mc.class.getName().hashCode();
    AppMethodBeat.o(160795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.GetWcPaySignEventListener
 * JD-Core Version:    0.7.0.1
 */