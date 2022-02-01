package com.tencent.mm.plugin.fav.model.listener;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.di;
import com.tencent.mm.sdk.event.IListener;

public class DelFavoriteItemListener
  extends IListener<di>
{
  public DelFavoriteItemListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161112);
    this.__eventId = di.class.getName().hashCode();
    AppMethodBeat.o(161112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.listener.DelFavoriteItemListener
 * JD-Core Version:    0.7.0.1
 */