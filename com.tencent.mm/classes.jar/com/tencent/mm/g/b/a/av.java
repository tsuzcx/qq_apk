package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  private long cVK = 0L;
  private long cVL = 0L;
  private long cVM = 0L;
  private long cVN = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(108852);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cVK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVN);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108852);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108853);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.cVK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.cVL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.cVM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.cVN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108853);
    return localObject;
  }
  
  public final long Fx()
  {
    return this.cVL;
  }
  
  public final long Fy()
  {
    return this.cVM;
  }
  
  public final av ck(long paramLong)
  {
    this.cVK = paramLong;
    return this;
  }
  
  public final av cl(long paramLong)
  {
    this.cVL = paramLong;
    return this;
  }
  
  public final av cm(long paramLong)
  {
    this.cVM = paramLong;
    return this;
  }
  
  public final av cn(long paramLong)
  {
    this.cVN = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16913;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */