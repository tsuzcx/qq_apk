package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class et
  extends a
{
  private long dVA = 0L;
  private long dVx = 0L;
  private long dVy = 0L;
  private long dVz = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVA);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.dVx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.dVy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.dVz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.dVA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long Rn()
  {
    return this.dVy;
  }
  
  public final long Ro()
  {
    return this.dVz;
  }
  
  public final int getId()
  {
    return 16913;
  }
  
  public final et ja(long paramLong)
  {
    this.dVx = paramLong;
    return this;
  }
  
  public final et jb(long paramLong)
  {
    this.dVy = paramLong;
    return this;
  }
  
  public final et jc(long paramLong)
  {
    this.dVz = paramLong;
    return this;
  }
  
  public final et jd(long paramLong)
  {
    this.dVA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.et
 * JD-Core Version:    0.7.0.1
 */