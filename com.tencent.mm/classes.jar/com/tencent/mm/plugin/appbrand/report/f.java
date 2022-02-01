package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
  extends b
{
  private volatile long lRo = 0L;
  private volatile boolean lRp = false;
  public volatile String lRq;
  
  public f(int paramInt)
  {
    super(paramInt);
  }
  
  public final void QA(String paramString)
  {
    AppMethodBeat.i(186913);
    super.onForeground();
    this.lRo = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.lRp = false;
      this.lRq = null;
    }
    AppMethodBeat.o(186913);
  }
  
  public final void QB(String paramString)
  {
    AppMethodBeat.i(186914);
    this.lRo = (bs.eWj() - this.lSy.lRY.getStartTime());
    this.lRq = paramString;
    this.lRp = true;
    AppMethodBeat.o(186914);
  }
  
  public final long btd()
  {
    if (this.lRp) {
      return this.lSy.lSc - this.lRo;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */