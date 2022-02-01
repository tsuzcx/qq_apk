package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  public String dHL = "";
  public String ehB = "";
  public long ejA = 0L;
  public long ejB = 0L;
  public long ejC = 0L;
  public long ejD = 0L;
  public long ejy = 0L;
  public String ejz = "";
  
  public final String PV()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.ejy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.ehB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.ejB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.ejC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.ejD);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hc
 * JD-Core Version:    0.7.0.1
 */