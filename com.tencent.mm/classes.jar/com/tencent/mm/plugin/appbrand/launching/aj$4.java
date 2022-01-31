package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

final class aj$4
  extends q
{
  aj$4(aj paramaj, String paramString, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramWxaVersionInfo);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131979);
    this.imK.aGL();
    AppMethodBeat.o(131979);
  }
  
  public final void aGQ()
  {
    AppMethodBeat.i(131980);
    this.imK.aGQ();
    AppMethodBeat.o(131980);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131981);
    this.imK.onDownloadProgress(paramInt);
    AppMethodBeat.o(131981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj.4
 * JD-Core Version:    0.7.0.1
 */