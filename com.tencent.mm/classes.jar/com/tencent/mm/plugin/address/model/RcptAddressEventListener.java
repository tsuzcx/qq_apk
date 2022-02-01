package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sx;
import com.tencent.mm.sdk.event.IListener;

public class RcptAddressEventListener
  extends IListener<sx>
{
  public RcptAddressEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161285);
    this.__eventId = sx.class.getName().hashCode();
    AppMethodBeat.o(161285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptAddressEventListener
 * JD-Core Version:    0.7.0.1
 */