package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  private String eBO = "";
  private String eBP = "";
  private String eBQ = "";
  private long eBR;
  private long eBS;
  private long eBT;
  private long eBU;
  private long eBV;
  private long eiE;
  private String ekG = "";
  private String erH = "";
  private long esb;
  
  public final String abV()
  {
    AppMethodBeat.i(209192);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBV);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209192);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209193);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionId:").append(this.eBO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestId:").append(this.eBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchScene:").append(this.eBR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.eBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchResultType:").append(this.eBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAccountEmpty:").append(this.eBU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFeedEmpty:").append(this.eBV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209193);
    return localObject;
  }
  
  public final dv afh()
  {
    this.esb = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21690;
  }
  
  public final dv kV(long paramLong)
  {
    this.eBR = paramLong;
    return this;
  }
  
  public final dv kW(long paramLong)
  {
    this.eBS = paramLong;
    return this;
  }
  
  public final dv kX(long paramLong)
  {
    this.eiE = paramLong;
    return this;
  }
  
  public final dv kY(long paramLong)
  {
    this.eBT = paramLong;
    return this;
  }
  
  public final dv kZ(long paramLong)
  {
    this.eBU = paramLong;
    return this;
  }
  
  public final dv la(long paramLong)
  {
    this.eBV = paramLong;
    return this;
  }
  
  public final dv qa(String paramString)
  {
    AppMethodBeat.i(209187);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(209187);
    return this;
  }
  
  public final dv qb(String paramString)
  {
    AppMethodBeat.i(209188);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209188);
    return this;
  }
  
  public final dv qc(String paramString)
  {
    AppMethodBeat.i(209189);
    this.eBO = x("searchSessionId", paramString, true);
    AppMethodBeat.o(209189);
    return this;
  }
  
  public final dv qd(String paramString)
  {
    AppMethodBeat.i(209190);
    this.eBP = x("requestId", paramString, true);
    AppMethodBeat.o(209190);
    return this;
  }
  
  public final dv qe(String paramString)
  {
    AppMethodBeat.i(209191);
    this.eBQ = x("query", paramString, true);
    AppMethodBeat.o(209191);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dv
 * JD-Core Version:    0.7.0.1
 */