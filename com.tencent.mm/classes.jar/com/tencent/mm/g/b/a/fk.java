package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  private String eFE = "";
  private long eFF;
  private String eFG = "";
  private long eFH;
  private long eFI;
  private long eFJ;
  private int eFK;
  private long eFz;
  
  public final String abV()
  {
    AppMethodBeat.i(207435);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207435);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207436);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.eFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.eFG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.eFH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.eFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.eFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.eFK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207436);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final fk ll(int paramInt)
  {
    this.eFK = paramInt;
    return this;
  }
  
  public final fk nO(long paramLong)
  {
    this.eFF = paramLong;
    return this;
  }
  
  public final fk nP(long paramLong)
  {
    this.eFz = paramLong;
    return this;
  }
  
  public final fk nQ(long paramLong)
  {
    this.eFH = paramLong;
    return this;
  }
  
  public final fk nR(long paramLong)
  {
    this.eFI = paramLong;
    return this;
  }
  
  public final fk nS(long paramLong)
  {
    this.eFJ = paramLong;
    return this;
  }
  
  public final fk sn(String paramString)
  {
    AppMethodBeat.i(207434);
    this.eFG = x("micId", paramString, true);
    AppMethodBeat.o(207434);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fk
 * JD-Core Version:    0.7.0.1
 */