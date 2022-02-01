package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class a
{
  public static final class f
    extends IListener<gc>
  {
    m doF;
    boolean doG;
    boolean doH;
    gc doI;
    Runnable doJ;
    String fileName;
    boolean isTimeout;
    MTimerHandler timer;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = gc.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    private void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.doF != null)
      {
        this.doH = this.doF.ZZ();
        if (this.doJ != null)
        {
          if (this.doI != null)
          {
            this.doI.dJI.dJJ = this.doF.dyI.dzA;
            this.doI = null;
          }
          if (this.isTimeout) {
            this.doJ.run();
          }
          this.doJ = null;
        }
        this.doG = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static final class i
    extends IListener<gb>
  {
    public i()
    {
      AppMethodBeat.i(161268);
      this.__eventId = gb.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */