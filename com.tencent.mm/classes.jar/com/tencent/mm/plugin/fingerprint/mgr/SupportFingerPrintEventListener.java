package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aag;
import com.tencent.mm.sdk.event.IListener;

public class SupportFingerPrintEventListener
  extends IListener<aag>
{
  public SupportFingerPrintEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160798);
    this.__eventId = aag.class.getName().hashCode();
    AppMethodBeat.o(160798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.SupportFingerPrintEventListener
 * JD-Core Version:    0.7.0.1
 */