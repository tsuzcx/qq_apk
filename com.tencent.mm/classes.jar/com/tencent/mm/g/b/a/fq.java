package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  private long eFF;
  private String eGP = "";
  private long eGQ;
  private String eGR = "";
  private long eGS;
  private long erw;
  
  public final String abV()
  {
    AppMethodBeat.i(196236);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eGP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGS);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(196236);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(196237);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("moduleName:").append(this.eGP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.eGQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventMsg:").append(this.eGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.eFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mode:").append(this.eGS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(196237);
    return localObject;
  }
  
  public final long agC()
  {
    return this.erw;
  }
  
  public final int getId()
  {
    return 21505;
  }
  
  public final fq pg(long paramLong)
  {
    this.eGQ = paramLong;
    return this;
  }
  
  public final fq ph(long paramLong)
  {
    this.eFF = paramLong;
    return this;
  }
  
  public final fq pi(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final fq pj(long paramLong)
  {
    this.eGS = paramLong;
    return this;
  }
  
  public final fq sD(String paramString)
  {
    AppMethodBeat.i(196234);
    this.eGP = x("moduleName", paramString, true);
    AppMethodBeat.o(196234);
    return this;
  }
  
  public final fq sE(String paramString)
  {
    AppMethodBeat.i(196235);
    this.eGR = x("eventMsg", paramString, true);
    AppMethodBeat.o(196235);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fq
 * JD-Core Version:    0.7.0.1
 */