package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class aj$1
  extends t
{
  aj$1(aj paramaj, String paramString, int paramInt1, int paramInt2, List paramList)
  {
    super(paramString, paramInt1, paramInt2, paramList);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131970);
    super.aGL();
    this.imK.aGL();
    AppMethodBeat.o(131970);
  }
  
  public final void aGQ()
  {
    AppMethodBeat.i(131971);
    super.aGQ();
    this.imK.aGQ();
    AppMethodBeat.o(131971);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131972);
    this.imK.onDownloadProgress(paramInt);
    AppMethodBeat.o(131972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj.1
 * JD-Core Version:    0.7.0.1
 */