package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends b
{
  private volatile long mre = 0L;
  private volatile boolean mrf = false;
  public volatile String mrg;
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  public final void Ug(String paramString)
  {
    AppMethodBeat.i(188711);
    super.onForeground();
    this.mre = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.mrf = false;
      this.mrg = null;
    }
    AppMethodBeat.o(188711);
  }
  
  public final void Uh(String paramString)
  {
    AppMethodBeat.i(188712);
    this.mre = (bt.flT() - this.msp.mrO.getStartTime());
    this.mrg = paramString;
    this.mrf = true;
    AppMethodBeat.o(188712);
  }
  
  public final long bxi()
  {
    if (this.mrf) {
      return this.msp.mrS - this.mre;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g
 * JD-Core Version:    0.7.0.1
 */