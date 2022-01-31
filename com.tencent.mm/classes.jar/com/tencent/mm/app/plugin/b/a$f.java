package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ap;

public final class a$f
  extends com.tencent.mm.sdk.b.c<fo>
{
  m caR;
  ap caS;
  boolean caT;
  boolean caU;
  boolean caV;
  fo caW;
  Runnable caX;
  String fileName;
  
  public a$f()
  {
    AppMethodBeat.i(15742);
    this.fileName = "";
    this.__eventId = fo.class.getName().hashCode();
    AppMethodBeat.o(15742);
  }
  
  final void stopRecord()
  {
    AppMethodBeat.i(15743);
    if (this.caR != null)
    {
      this.caU = this.caR.Et();
      if (this.caX != null)
      {
        if (this.caW != null)
        {
          this.caW.ctF.ctG = this.caR.ciR.cjI;
          this.caW = null;
        }
        if (this.caV) {
          this.caX.run();
        }
        this.caX = null;
      }
      this.caT = true;
    }
    AppMethodBeat.o(15743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a.f
 * JD-Core Version:    0.7.0.1
 */