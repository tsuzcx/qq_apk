package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.sdk.event.IListener;

public final class ExpansionsDownloader
{
  private static int yFk = 0;
  
  static final class ResUpdateListener
    extends IListener<cd>
  {
    ExpansionsDownloader.a yFl;
    
    public ResUpdateListener()
    {
      super();
      AppMethodBeat.i(273659);
      this.__eventId = cd.class.getName().hashCode();
      AppMethodBeat.o(273659);
    }
  }
  
  static abstract interface a
  {
    public abstract boolean dHu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsDownloader
 * JD-Core Version:    0.7.0.1
 */