package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
  extends a
{
  public int JJl = 0;
  public int JJm = 0;
  public int JJn = 0;
  public int JJo = 0;
  public int JJp = -9999;
  public String JJq = "";
  public int JJr = 0;
  public int JJs = 0;
  
  protected final void cIX()
  {
    AppMethodBeat.i(25504);
    h.OAn.b(14182, new Object[] { Integer.valueOf(this.JJl), Integer.valueOf(this.JJm), Integer.valueOf(this.JJn), Integer.valueOf(this.JJo), Integer.valueOf(this.JJp), this.JJq, Integer.valueOf(this.JJr), Integer.valueOf(this.JJs) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.JJl = 0;
    this.JJm = 0;
    this.JJn = 0;
    this.JJo = 0;
    this.JJp = -9999;
    this.JJq = "";
    this.JJr = 0;
    this.JJs = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25503);
    super.start();
    AppMethodBeat.o(25503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.f
 * JD-Core Version:    0.7.0.1
 */