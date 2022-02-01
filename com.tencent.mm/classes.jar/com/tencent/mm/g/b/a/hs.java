package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private long eMo = 0L;
  private long eMp = 0L;
  private long eMq = 0L;
  private long ejW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(210796);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(210796);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(210797);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("biz:").append(this.eMo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eMp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUseSysWebview:").append(this.eMq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210797);
    return localObject;
  }
  
  public final int getId()
  {
    return 15005;
  }
  
  public final hs qS(long paramLong)
  {
    this.eMo = paramLong;
    return this;
  }
  
  public final hs qT(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final hs qU(long paramLong)
  {
    this.eMp = paramLong;
    return this;
  }
  
  public final hs qV(long paramLong)
  {
    this.eMq = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hs
 * JD-Core Version:    0.7.0.1
 */