package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class aj$3
  extends r
{
  aj$3(aj paramaj, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3, List paramList)
  {
    super(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramString3, paramList);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131976);
    super.aGL();
    this.imK.aGL();
    AppMethodBeat.o(131976);
  }
  
  public final void aGQ()
  {
    AppMethodBeat.i(131977);
    super.aGQ();
    this.imK.aGQ();
    AppMethodBeat.o(131977);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131978);
    this.imK.onDownloadProgress(paramInt);
    AppMethodBeat.o(131978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj.3
 * JD-Core Version:    0.7.0.1
 */