package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class a
{
  public static final class f
    extends com.tencent.mm.sdk.b.c<fz>
  {
    m cYc;
    aw cYd;
    boolean cYe;
    boolean cYf;
    boolean cYg;
    fz cYh;
    Runnable cYi;
    String fileName;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = fz.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    final void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.cYc != null)
      {
        this.cYf = this.cYc.PF();
        if (this.cYi != null)
        {
          if (this.cYh != null)
          {
            this.cYh.dsx.dsy = this.cYc.dhw.dio;
            this.cYh = null;
          }
          if (this.cYg) {
            this.cYi.run();
          }
          this.cYi = null;
        }
        this.cYe = true;
      }
      AppMethodBeat.o(19781);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */