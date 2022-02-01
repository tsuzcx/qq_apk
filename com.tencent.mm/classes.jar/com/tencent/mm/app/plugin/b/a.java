package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.f.a.gg;
import com.tencent.mm.f.a.gi;
import com.tencent.mm.f.a.gj;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class a
{
  public static final class d
    extends IListener<gg>
  {
    com.tencent.mm.audio.a.a fhh;
    String fileName;
    
    public d()
    {
      AppMethodBeat.i(161263);
      this.__eventId = gg.class.getName().hashCode();
      AppMethodBeat.o(161263);
    }
  }
  
  public static final class f
    extends IListener<gj>
  {
    m fhj;
    boolean fhk;
    boolean fhl;
    gj fhm;
    Runnable fhn;
    String fileName;
    boolean isTimeout;
    MTimerHandler timer;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = gj.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    private void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.fhj != null)
      {
        this.fhl = this.fhj.aeJ();
        if (this.fhn != null)
        {
          if (this.fhm != null)
          {
            this.fhm.fCx.fCy = this.fhj.frx.fsp;
            this.fhm = null;
          }
          if (this.isTimeout) {
            this.fhn.run();
          }
          this.fhn = null;
        }
        this.fhk = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static final class i
    extends IListener<gi>
  {
    public i()
    {
      AppMethodBeat.i(161268);
      this.__eventId = gi.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */