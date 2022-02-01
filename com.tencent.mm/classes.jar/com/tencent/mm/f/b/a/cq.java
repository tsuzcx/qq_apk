package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
  extends a
{
  private String gjP = "";
  private String gnO = "";
  private long gqA;
  private long gqh;
  private long gqw = 0L;
  private long gqx;
  private String gqy = "";
  private long gqz;
  
  public final String agH()
  {
    AppMethodBeat.i(208921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208921);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208922);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.gqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.gqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.gqy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.gqz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.gqA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.gjP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208922);
    return localObject;
  }
  
  public final String ahO()
  {
    return this.gqy;
  }
  
  public final cq ahP()
  {
    this.gqz = 1L;
    return this;
  }
  
  public final cq fY(long paramLong)
  {
    this.gqw = paramLong;
    return this;
  }
  
  public final cq fZ(long paramLong)
  {
    this.gqx = paramLong;
    return this;
  }
  
  public final cq ga(long paramLong)
  {
    this.gqh = paramLong;
    return this;
  }
  
  public final cq gb(long paramLong)
  {
    this.gqA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
  
  public final cq mV(String paramString)
  {
    AppMethodBeat.i(208914);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(208914);
    return this;
  }
  
  public final cq mW(String paramString)
  {
    AppMethodBeat.i(208915);
    this.gqy = z("ClickContextid", paramString, true);
    AppMethodBeat.o(208915);
    return this;
  }
  
  public final cq mX(String paramString)
  {
    AppMethodBeat.i(208920);
    this.gjP = z("ContextID", paramString, true);
    AppMethodBeat.o(208920);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cq
 * JD-Core Version:    0.7.0.1
 */