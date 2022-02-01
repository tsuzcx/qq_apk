package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class a
{
  public static final class f
    extends com.tencent.mm.sdk.b.c<fy>
  {
    m cXf;
    av cXg;
    boolean cXh;
    boolean cXi;
    boolean cXj;
    fy cXk;
    Runnable cXl;
    String fileName;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = fy.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    final void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.cXf != null)
      {
        this.cXi = this.cXf.PG();
        if (this.cXl != null)
        {
          if (this.cXk != null)
          {
            this.cXk.drr.drs = this.cXf.dgu.dhm;
            this.cXk = null;
          }
          if (this.cXj) {
            this.cXl.run();
          }
          this.cXl = null;
        }
        this.cXh = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static final class i
    extends com.tencent.mm.sdk.b.c<fx>
  {
    public i()
    {
      AppMethodBeat.i(161268);
      this.__eventId = fx.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */