package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  private long ejA;
  private String erH = "";
  private String erU = "";
  private String erV = "";
  private long erW;
  private long erX;
  
  public final String abV()
  {
    AppMethodBeat.i(208857);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208857);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.erX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208858);
    return localObject;
  }
  
  public final be dr(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final be ds(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final be dt(long paramLong)
  {
    this.erX = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19995;
  }
  
  public final be jc(String paramString)
  {
    AppMethodBeat.i(208854);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208854);
    return this;
  }
  
  public final be jd(String paramString)
  {
    AppMethodBeat.i(208855);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(208855);
    return this;
  }
  
  public final be je(String paramString)
  {
    AppMethodBeat.i(208856);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208856);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */