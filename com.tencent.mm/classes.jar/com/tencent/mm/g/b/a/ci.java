package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  private String eiC = "";
  private long ejW;
  private String erU = "";
  private String erV = "";
  private long erW;
  private long evr;
  private long evs;
  private long evt;
  private long evu;
  private long evv;
  
  public final String abV()
  {
    AppMethodBeat.i(209006);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209006);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209007);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.evr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("messageType:").append(this.evs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isfloat:").append(this.evu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerVersion:").append(this.evv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209007);
    return localObject;
  }
  
  public final ci adf()
  {
    this.evv = 1L;
    return this;
  }
  
  public final ci fT(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ci fU(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final ci fV(long paramLong)
  {
    this.evr = paramLong;
    return this;
  }
  
  public final ci fW(long paramLong)
  {
    this.evs = paramLong;
    return this;
  }
  
  public final ci fX(long paramLong)
  {
    this.evt = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final ci lL(String paramString)
  {
    AppMethodBeat.i(209003);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(209003);
    return this;
  }
  
  public final ci lM(String paramString)
  {
    AppMethodBeat.i(209004);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(209004);
    return this;
  }
  
  public final ci lN(String paramString)
  {
    AppMethodBeat.i(209005);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209005);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci
 * JD-Core Version:    0.7.0.1
 */