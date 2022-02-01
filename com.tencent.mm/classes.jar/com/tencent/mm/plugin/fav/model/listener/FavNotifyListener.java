package com.tencent.mm.plugin.fav.model.listener;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hr;
import com.tencent.mm.sdk.event.IListener;

public class FavNotifyListener
  extends IListener<hr>
{
  public FavNotifyListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161113);
    this.__eventId = hr.class.getName().hashCode();
    AppMethodBeat.o(161113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.listener.FavNotifyListener
 * JD-Core Version:    0.7.0.1
 */