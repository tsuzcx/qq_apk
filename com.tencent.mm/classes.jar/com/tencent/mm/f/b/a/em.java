package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  private String gdM = "";
  private long guE;
  private long gxA;
  private String gxB = "";
  private long gxC;
  private long gxz;
  
  public final String agH()
  {
    AppMethodBeat.i(208654);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gxz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208654);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208655);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.gxz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.gdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.gxA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.guE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.gxB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.gxC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208655);
    return localObject;
  }
  
  public final int getId()
  {
    return 20223;
  }
  
  public final em lH(long paramLong)
  {
    this.gxz = paramLong;
    return this;
  }
  
  public final em lI(long paramLong)
  {
    this.gxA = paramLong;
    return this;
  }
  
  public final em lJ(long paramLong)
  {
    this.guE = paramLong;
    return this;
  }
  
  public final em lK(long paramLong)
  {
    this.gxC = paramLong;
    return this;
  }
  
  public final em sr(String paramString)
  {
    AppMethodBeat.i(208651);
    this.gdM = z("TipsId", paramString, true);
    AppMethodBeat.o(208651);
    return this;
  }
  
  public final em ss(String paramString)
  {
    AppMethodBeat.i(208653);
    this.gxB = z("RevokeId", paramString, true);
    AppMethodBeat.o(208653);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.em
 * JD-Core Version:    0.7.0.1
 */