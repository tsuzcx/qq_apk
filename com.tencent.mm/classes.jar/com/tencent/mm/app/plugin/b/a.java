package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class a
{
  public static final class d
    extends com.tencent.mm.sdk.b.c<fr>
  {
    com.tencent.mm.audio.a.a cOu;
    String fileName;
    
    public d()
    {
      AppMethodBeat.i(161263);
      this.__eventId = fr.class.getName().hashCode();
      AppMethodBeat.o(161263);
    }
  }
  
  public static final class f
    extends com.tencent.mm.sdk.b.c<fu>
  {
    boolean cOA;
    fu cOB;
    Runnable cOC;
    m cOw;
    av cOx;
    boolean cOy;
    boolean cOz;
    String fileName;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = fu.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    final void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.cOw != null)
      {
        this.cOz = this.cOw.Ob();
        if (this.cOC != null)
        {
          if (this.cOB != null)
          {
            this.cOB.diA.diB = this.cOw.cXI.cYA;
            this.cOB = null;
          }
          if (this.cOA) {
            this.cOC.run();
          }
          this.cOC = null;
        }
        this.cOy = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static final class i
    extends com.tencent.mm.sdk.b.c<ft>
  {
    public i()
    {
      AppMethodBeat.i(161268);
      this.__eventId = ft.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */