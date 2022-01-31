package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public boolean isStart = false;
  
  protected void bJP() {}
  
  public final void finish()
  {
    AppMethodBeat.i(21882);
    if (this.isStart)
    {
      bJP();
      this.isStart = false;
    }
    AppMethodBeat.o(21882);
  }
  
  public void reset() {}
  
  public void start()
  {
    AppMethodBeat.i(21881);
    reset();
    this.isStart = true;
    AppMethodBeat.o(21881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.a
 * JD-Core Version:    0.7.0.1
 */