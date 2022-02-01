package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ua;
import com.tencent.mm.sdk.event.IListener;

public class ReleaseFingerPrintAuthEventListener
  extends IListener<ua>
{
  public ReleaseFingerPrintAuthEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160797);
    this.__eventId = ua.class.getName().hashCode();
    AppMethodBeat.o(160797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.ReleaseFingerPrintAuthEventListener
 * JD-Core Version:    0.7.0.1
 */