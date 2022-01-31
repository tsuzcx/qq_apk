package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class aj$2
  extends s
{
  aj$2(aj paramaj, String paramString, int paramInt1, int paramInt2, List paramList)
  {
    super(paramString, paramInt1, paramInt2, paramList);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131973);
    super.aGL();
    this.imK.aGL();
    AppMethodBeat.o(131973);
  }
  
  public final void aGQ()
  {
    AppMethodBeat.i(131974);
    super.aGQ();
    this.imK.aGQ();
    AppMethodBeat.o(131974);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131975);
    this.imK.onDownloadProgress(paramInt);
    AppMethodBeat.o(131975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj.2
 * JD-Core Version:    0.7.0.1
 */