package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ka
  extends a
{
  public String dSD = "";
  public String eAH = "";
  public long eCJ = 0L;
  public String eCK = "";
  public long eCL = 0L;
  public long eCM = 0L;
  public long eCN = 0L;
  public long eCO = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCO);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.eCJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.eCK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.eAH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.eCL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.eCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.eCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.eCO);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ka
 * JD-Core Version:    0.7.0.1
 */