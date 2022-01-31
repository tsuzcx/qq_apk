package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

final class g$5
  extends aj
{
  g$5(g paramg, String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    super(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo, paramBoolean);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131779);
    g.e(this.ikV);
    AppMethodBeat.o(131779);
  }
  
  public final void aGQ()
  {
    AppMethodBeat.i(131780);
    g.f(this.ikV);
    AppMethodBeat.o(131780);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131781);
    if (this.ikV.ikG != null) {
      this.ikV.ikG.onDownloadProgress(paramInt);
    }
    AppMethodBeat.o(131781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.5
 * JD-Core Version:    0.7.0.1
 */