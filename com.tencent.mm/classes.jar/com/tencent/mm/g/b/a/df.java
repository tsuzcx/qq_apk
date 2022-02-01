package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class df
  extends a
{
  private long dTL = 0L;
  private long dTM = 0L;
  private long dTN = 0L;
  private long dTO = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.dTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.dTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.dTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.dTO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long QL()
  {
    return this.dTM;
  }
  
  public final long QM()
  {
    return this.dTN;
  }
  
  public final df fN(long paramLong)
  {
    this.dTL = paramLong;
    return this;
  }
  
  public final df fO(long paramLong)
  {
    this.dTM = paramLong;
    return this;
  }
  
  public final df fP(long paramLong)
  {
    this.dTN = paramLong;
    return this;
  }
  
  public final df fQ(long paramLong)
  {
    this.dTO = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16913;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.df
 * JD-Core Version:    0.7.0.1
 */