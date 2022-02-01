package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hb
  extends a
{
  private long gDT;
  private String gDY = "";
  private long gDZ;
  private String gEa = "";
  private long gEb;
  private long gEc;
  private long gEd;
  private int gEe;
  
  public final String agH()
  {
    AppMethodBeat.i(202104);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEe);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(202104);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(202108);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.gDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.gDZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.gEa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.gDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.gEb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.gEc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.gEd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.gEe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202108);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final hb nd(int paramInt)
  {
    this.gEe = paramInt;
    return this;
  }
  
  public final hb pZ(long paramLong)
  {
    this.gDZ = paramLong;
    return this;
  }
  
  public final hb qa(long paramLong)
  {
    this.gDT = paramLong;
    return this;
  }
  
  public final hb qb(long paramLong)
  {
    this.gEb = paramLong;
    return this;
  }
  
  public final hb qc(long paramLong)
  {
    this.gEc = paramLong;
    return this;
  }
  
  public final hb qd(long paramLong)
  {
    this.gEd = paramLong;
    return this;
  }
  
  public final hb vY(String paramString)
  {
    AppMethodBeat.i(202096);
    this.gEa = z("micId", paramString, true);
    AppMethodBeat.o(202096);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hb
 * JD-Core Version:    0.7.0.1
 */