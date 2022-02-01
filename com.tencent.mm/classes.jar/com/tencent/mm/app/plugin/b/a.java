package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class a
{
  public static final class d
    extends com.tencent.mm.sdk.b.c<fs>
  {
    com.tencent.mm.audio.a.a cLP;
    String fileName;
    
    public d()
    {
      AppMethodBeat.i(161263);
      this.__eventId = fs.class.getName().hashCode();
      AppMethodBeat.o(161263);
    }
  }
  
  public static final class f
    extends com.tencent.mm.sdk.b.c<fv>
  {
    m cLR;
    au cLS;
    boolean cLT;
    boolean cLU;
    boolean cLV;
    fv cLW;
    Runnable cLX;
    String fileName;
    
    public f()
    {
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = fv.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    final void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.cLR != null)
      {
        this.cLU = this.cLR.NX();
        if (this.cLX != null)
        {
          if (this.cLW != null)
          {
            this.cLW.dfV.dfW = this.cLR.cVe.cVW;
            this.cLW = null;
          }
          if (this.cLV) {
            this.cLX.run();
          }
          this.cLX = null;
        }
        this.cLT = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static final class i
    extends com.tencent.mm.sdk.b.c<fu>
  {
    public i()
    {
      AppMethodBeat.i(161268);
      this.__eventId = fu.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */