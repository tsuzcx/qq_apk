package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  public long gdZ = 0L;
  public long geB;
  private String giM = "";
  public long giO = 0L;
  public long giR;
  public long giS = 0L;
  public String giT = "";
  public String giU = "";
  public String giV = "";
  public String giW = "";
  
  public final String agH()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.giM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.giR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.giS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.giO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.giU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.gdZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.giV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.giW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final int getId()
  {
    return 19436;
  }
  
  public final al jd(String paramString)
  {
    AppMethodBeat.i(184764);
    this.giM = z("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.al
 * JD-Core Version:    0.7.0.1
 */