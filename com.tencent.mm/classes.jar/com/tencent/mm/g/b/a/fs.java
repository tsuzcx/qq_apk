package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fs
  extends a
{
  private long eiJ = 0L;
  private long elP = 0L;
  private long elQ = 0L;
  private long elR = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elR);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.elP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.eiJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.elQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.elR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long Tu()
  {
    return this.eiJ;
  }
  
  public final long Tv()
  {
    return this.elQ;
  }
  
  public final int getId()
  {
    return 16913;
  }
  
  public final fs kM(long paramLong)
  {
    this.elP = paramLong;
    return this;
  }
  
  public final fs kN(long paramLong)
  {
    this.eiJ = paramLong;
    return this;
  }
  
  public final fs kO(long paramLong)
  {
    this.elQ = paramLong;
    return this;
  }
  
  public final fs kP(long paramLong)
  {
    this.elR = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fs
 * JD-Core Version:    0.7.0.1
 */