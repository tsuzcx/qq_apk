package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends b
{
  private volatile long qJm = 0L;
  private volatile boolean qJn = false;
  public volatile String qJo;
  
  public i(int paramInt)
  {
    super(paramInt);
  }
  
  public final void amA(String paramString)
  {
    AppMethodBeat.i(277968);
    this.qJm = (Util.nowMilliSecond() - this.qKC.qKb.getStartTime());
    this.qJo = paramString;
    this.qJn = true;
    AppMethodBeat.o(277968);
  }
  
  public final void amz(String paramString)
  {
    AppMethodBeat.i(277967);
    super.onForeground();
    this.qJm = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.qJn = false;
      this.qJo = null;
    }
    AppMethodBeat.o(277967);
  }
  
  public final long chC()
  {
    if (this.qJn) {
      return this.qKC.qKf - this.qJm;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */