package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
  extends a
{
  public int tKZ = 0;
  public int tLa = 0;
  public int tLb = 0;
  public int tLc = 0;
  public int tLd = -9999;
  public String tLe = "";
  public int tLf = 0;
  public int tLg = 0;
  
  protected final void btF()
  {
    AppMethodBeat.i(25504);
    h.wUl.f(14182, new Object[] { Integer.valueOf(this.tKZ), Integer.valueOf(this.tLa), Integer.valueOf(this.tLb), Integer.valueOf(this.tLc), Integer.valueOf(this.tLd), this.tLe, Integer.valueOf(this.tLf), Integer.valueOf(this.tLg) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.tKZ = 0;
    this.tLa = 0;
    this.tLb = 0;
    this.tLc = 0;
    this.tLd = -9999;
    this.tLe = "";
    this.tLf = 0;
    this.tLg = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25503);
    super.start();
    AppMethodBeat.o(25503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.f
 * JD-Core Version:    0.7.0.1
 */