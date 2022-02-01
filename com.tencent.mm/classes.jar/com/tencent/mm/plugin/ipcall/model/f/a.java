package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public boolean isStart = false;
  
  protected void bmJ() {}
  
  public final void finish()
  {
    AppMethodBeat.i(25497);
    if (this.isStart)
    {
      bmJ();
      this.isStart = false;
    }
    AppMethodBeat.o(25497);
  }
  
  public void reset() {}
  
  public void start()
  {
    AppMethodBeat.i(25496);
    reset();
    this.isStart = true;
    AppMethodBeat.o(25496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.a
 * JD-Core Version:    0.7.0.1
 */