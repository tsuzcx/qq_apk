package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.sdk.event.IListener;

public class FavAddItemListener
  extends IListener<dn>
{
  public FavAddItemListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160915);
    this.__eventId = dn.class.getName().hashCode();
    AppMethodBeat.o(160915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavAddItemListener
 * JD-Core Version:    0.7.0.1
 */