package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cl
  extends a
{
  private String elt = "";
  private String eoo = "";
  private String erU = "";
  private String euI = "";
  private String evX = "";
  private long evY;
  private long evZ;
  private long evt;
  private long ewa;
  private String ewb = "";
  private long ewc;
  private String ewd = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209029);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209029);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209030);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.evX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.evY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.evZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTime:").append(this.ewa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.ewb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.ewc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.ewd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.eoo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209030);
    return localObject;
  }
  
  public final int getId()
  {
    return 21564;
  }
  
  public final cl gv(long paramLong)
  {
    this.evY = paramLong;
    return this;
  }
  
  public final cl gw(long paramLong)
  {
    this.evZ = paramLong;
    return this;
  }
  
  public final cl gx(long paramLong)
  {
    this.ewa = paramLong;
    return this;
  }
  
  public final cl gy(long paramLong)
  {
    this.ewc = paramLong;
    return this;
  }
  
  public final cl gz(long paramLong)
  {
    this.evt = paramLong;
    return this;
  }
  
  public final cl mf(String paramString)
  {
    AppMethodBeat.i(209022);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(209022);
    return this;
  }
  
  public final cl mg(String paramString)
  {
    AppMethodBeat.i(209023);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209023);
    return this;
  }
  
  public final cl mh(String paramString)
  {
    AppMethodBeat.i(209024);
    this.evX = x("clickTabContextId", paramString, true);
    AppMethodBeat.o(209024);
    return this;
  }
  
  public final cl mi(String paramString)
  {
    AppMethodBeat.i(209025);
    this.ewb = x("cardid", paramString, true);
    AppMethodBeat.o(209025);
    return this;
  }
  
  public final cl mj(String paramString)
  {
    AppMethodBeat.i(209026);
    this.ewd = x("cardTag", paramString, true);
    AppMethodBeat.o(209026);
    return this;
  }
  
  public final cl mk(String paramString)
  {
    AppMethodBeat.i(209027);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(209027);
    return this;
  }
  
  public final cl ml(String paramString)
  {
    AppMethodBeat.i(209028);
    this.eoo = x("SessionBuffer", paramString, true);
    AppMethodBeat.o(209028);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */