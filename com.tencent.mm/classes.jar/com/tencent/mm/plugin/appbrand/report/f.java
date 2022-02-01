package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends b
{
  private volatile long lpo = 0L;
  private volatile boolean lpp = false;
  public volatile String lpq;
  
  public f(int paramInt)
  {
    super(paramInt);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(196073);
    super.onForeground();
    this.lpo = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.lpp = false;
      this.lpq = null;
    }
    AppMethodBeat.o(196073);
  }
  
  public final void Ms(String paramString)
  {
    AppMethodBeat.i(196074);
    this.lpo = (bt.eGO() - this.lqD.lqd.getStartTime());
    this.lpq = paramString;
    this.lpp = true;
    AppMethodBeat.o(196074);
  }
  
  public final long bmh()
  {
    if (this.lpp) {
      return this.lqD.lqh - this.lpo;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */