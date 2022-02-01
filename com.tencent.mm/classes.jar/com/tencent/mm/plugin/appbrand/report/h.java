package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends b
{
  private volatile long nHa = 0L;
  private volatile boolean nHb = false;
  public volatile String nHc;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public final void aeF(String paramString)
  {
    AppMethodBeat.i(227370);
    super.onForeground();
    this.nHa = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.nHb = false;
      this.nHc = null;
    }
    AppMethodBeat.o(227370);
  }
  
  public final void aeG(String paramString)
  {
    AppMethodBeat.i(227371);
    this.nHa = (Util.nowMilliSecond() - this.nIq.nHP.getStartTime());
    this.nHc = paramString;
    this.nHb = true;
    AppMethodBeat.o(227371);
  }
  
  public final long bUs()
  {
    if (this.nHb) {
      return this.nIq.nHT - this.nHa;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */