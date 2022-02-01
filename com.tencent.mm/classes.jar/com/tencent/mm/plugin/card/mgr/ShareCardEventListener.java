package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.xi;
import com.tencent.mm.sdk.event.IListener;

public class ShareCardEventListener
  extends IListener<xi>
{
  public ShareCardEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161194);
    this.__eventId = xi.class.getName().hashCode();
    AppMethodBeat.o(161194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.ShareCardEventListener
 * JD-Core Version:    0.7.0.1
 */