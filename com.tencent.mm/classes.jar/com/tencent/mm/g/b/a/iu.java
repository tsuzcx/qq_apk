package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iu
  extends a
{
  public String dFy = "";
  public String ejG = "";
  public long elC = 0L;
  public String elD = "";
  public long elE = 0L;
  public long elF = 0L;
  public long elG = 0L;
  public long elH = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elH);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.elC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.elD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.ejG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.elE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.elF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.elG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.elH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116509);
    return localObject;
  }
  
  public final int getId()
  {
    return 15778;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iu
 * JD-Core Version:    0.7.0.1
 */