package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  private long dZQ;
  private String dZR;
  private long dZS;
  private long dZT;
  private String dZU;
  private long dZV;
  
  public final String RD()
  {
    AppMethodBeat.i(209211);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZV);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209211);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209212);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.dZQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.dZR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.dZS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.dZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.dZV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209212);
    return localObject;
  }
  
  public final bo ga(long paramLong)
  {
    this.dZQ = paramLong;
    return this;
  }
  
  public final bo gb(long paramLong)
  {
    this.dZS = paramLong;
    return this;
  }
  
  public final bo gc(long paramLong)
  {
    this.dZT = paramLong;
    return this;
  }
  
  public final bo gd(long paramLong)
  {
    this.dZV = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20223;
  }
  
  public final bo ko(String paramString)
  {
    AppMethodBeat.i(209209);
    this.dZR = t("TipsId", paramString, true);
    AppMethodBeat.o(209209);
    return this;
  }
  
  public final bo kp(String paramString)
  {
    AppMethodBeat.i(209210);
    this.dZU = t("RevokeId", paramString, true);
    AppMethodBeat.o(209210);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */