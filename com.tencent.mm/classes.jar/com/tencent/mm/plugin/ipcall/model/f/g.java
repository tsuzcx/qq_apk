package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private long JJe;
  public long JJf;
  public long JJt = 0L;
  public String JJu = "";
  public String JJv = "";
  public long JJw = 0L;
  public long JJx = 0L;
  public long JJy = 0L;
  public String JJz = "";
  
  protected final void cIX()
  {
    AppMethodBeat.i(25506);
    h.OAn.b(12933, new Object[] { Long.valueOf(this.JJe), Long.valueOf(this.JJf), Long.valueOf(this.JJt), this.JJu, this.JJv, Long.valueOf(this.JJw), Long.valueOf(this.JJx), Long.valueOf(this.JJy), this.JJz });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.JJe = 0L;
    this.JJf = 0L;
    this.JJt = 0L;
    this.JJu = "";
    this.JJv = "";
    this.JJw = 0L;
    this.JJx = 0L;
    this.JJy = 0L;
    this.JJz = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.JJe = Util.nowMilliSecond();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */