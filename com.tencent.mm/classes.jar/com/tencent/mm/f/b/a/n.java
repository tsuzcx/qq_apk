package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  private int geN;
  private long geO;
  private long geP;
  private long geQ;
  private long geR;
  private String geS = "";
  private String geT = "";
  private long geU;
  
  public final String agH()
  {
    AppMethodBeat.i(194179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(194179);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(194180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqNum:").append(this.geO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespNum:").append(this.geP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataStartTime:").append(this.geQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataEndTime:").append(this.geR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqContent:").append(this.geS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespContent:").append(this.geT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataNum:").append(this.geU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194180);
    return localObject;
  }
  
  public final n cb(long paramLong)
  {
    this.geO = paramLong;
    return this;
  }
  
  public final n cc(long paramLong)
  {
    this.geP = paramLong;
    return this;
  }
  
  public final n cd(long paramLong)
  {
    this.geQ = paramLong;
    return this;
  }
  
  public final n ce(long paramLong)
  {
    this.geR = paramLong;
    return this;
  }
  
  public final n cf(long paramLong)
  {
    this.geU = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20808;
  }
  
  public final n iF(String paramString)
  {
    AppMethodBeat.i(194168);
    this.geS = z("ReqContent", paramString, true);
    AppMethodBeat.o(194168);
    return this;
  }
  
  public final n iG(String paramString)
  {
    AppMethodBeat.i(194171);
    this.geT = z("RespContent", paramString, true);
    AppMethodBeat.o(194171);
    return this;
  }
  
  public final n kV(int paramInt)
  {
    this.geN = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.n
 * JD-Core Version:    0.7.0.1
 */