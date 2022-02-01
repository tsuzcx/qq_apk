package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  private long dOj;
  private String dOn;
  private long dOo;
  private String dOp;
  private long dOq;
  private long dOr;
  private long dOs;
  private int dOt;
  
  public final String PR()
  {
    AppMethodBeat.i(190824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dOn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOt);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190824);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dOn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.dOo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.dOp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.dOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.dOq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.dOr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.dOs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.dOt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190825);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final cf he(long paramLong)
  {
    this.dOo = paramLong;
    return this;
  }
  
  public final cf hf(long paramLong)
  {
    this.dOj = paramLong;
    return this;
  }
  
  public final cf hg(long paramLong)
  {
    this.dOq = paramLong;
    return this;
  }
  
  public final cf hh(long paramLong)
  {
    this.dOr = paramLong;
    return this;
  }
  
  public final cf hi(long paramLong)
  {
    this.dOs = paramLong;
    return this;
  }
  
  public final cf il(int paramInt)
  {
    this.dOt = paramInt;
    return this;
  }
  
  public final cf kg(String paramString)
  {
    AppMethodBeat.i(190823);
    this.dOp = t("micId", paramString, true);
    AppMethodBeat.o(190823);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cf
 * JD-Core Version:    0.7.0.1
 */