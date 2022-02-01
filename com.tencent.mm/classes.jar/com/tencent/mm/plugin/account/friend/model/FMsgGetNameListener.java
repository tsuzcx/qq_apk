package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hi;
import com.tencent.mm.sdk.event.IListener;

public class FMsgGetNameListener
  extends IListener<hi>
{
  public FMsgGetNameListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161618);
    this.__eventId = hi.class.getName().hashCode();
    AppMethodBeat.o(161618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.FMsgGetNameListener
 * JD-Core Version:    0.7.0.1
 */