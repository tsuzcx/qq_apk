package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mw
  extends a
{
  private String gOX = "";
  public long gWs;
  public long gWt;
  private String gWu = "";
  public long gWv;
  public long gWw;
  public String gWx = "";
  public long giq;
  public String gnO = "";
  
  public final mw Dx(String paramString)
  {
    AppMethodBeat.i(220729);
    this.gOX = z("PublishId", paramString, true);
    AppMethodBeat.o(220729);
    return this;
  }
  
  public final mw Dy(String paramString)
  {
    AppMethodBeat.i(220731);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(220731);
    return this;
  }
  
  public final mw Dz(String paramString)
  {
    AppMethodBeat.i(220733);
    this.gWu = z("ActionTimeStamp", paramString, true);
    AppMethodBeat.o(220733);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(220743);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(220743);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(220753);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.gOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCnt:").append(this.gWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommCnt:").append(this.gWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextAction:").append(this.gWv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCnt:").append(this.gWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextPublishId:").append(this.gWx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220753);
    return localObject;
  }
  
  public final int getId()
  {
    return 19750;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mw
 * JD-Core Version:    0.7.0.1
 */