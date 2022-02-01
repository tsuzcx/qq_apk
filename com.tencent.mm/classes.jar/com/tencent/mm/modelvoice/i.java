package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public long juy;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(130039);
    this.juy = MediaRecorder.SilkEncInit(paramInt1, paramInt2, paramInt3, MediaRecorder.juf);
    AppMethodBeat.o(130039);
  }
  
  public final int dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130040);
    paramInt1 = MediaRecorder.SetVoiceSilkControl(paramInt1, paramInt2, this.juy);
    AppMethodBeat.o(130040);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.i
 * JD-Core Version:    0.7.0.1
 */