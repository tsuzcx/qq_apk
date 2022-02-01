package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends b
{
  private volatile long mwc = 0L;
  private volatile boolean mwd = false;
  public volatile String mwe;
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  public final void UQ(String paramString)
  {
    AppMethodBeat.i(222927);
    super.onForeground();
    this.mwc = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.mwd = false;
      this.mwe = null;
    }
    AppMethodBeat.o(222927);
  }
  
  public final void UR(String paramString)
  {
    AppMethodBeat.i(222928);
    this.mwc = (bu.fpO() - this.mxm.mwM.getStartTime());
    this.mwe = paramString;
    this.mwd = true;
    AppMethodBeat.o(222928);
  }
  
  public final long byb()
  {
    if (this.mwd) {
      return this.mxm.mwQ - this.mwc;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g
 * JD-Core Version:    0.7.0.1
 */