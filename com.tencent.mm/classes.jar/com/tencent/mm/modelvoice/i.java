package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public long fZI;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155558);
    this.fZI = MediaRecorder.SilkEncInit(paramInt1, paramInt2, paramInt3, MediaRecorder.fZo);
    AppMethodBeat.o(155558);
  }
  
  public final int cK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155559);
    paramInt1 = MediaRecorder.SetVoiceSilkControl(paramInt1, paramInt2, this.fZI);
    AppMethodBeat.o(155559);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.i
 * JD-Core Version:    0.7.0.1
 */