package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rd
  extends a
{
  public String giT = "";
  public long gty = 0L;
  public String hka = "";
  public String hmd = "";
  public long hme = 0L;
  public long hmf = 0L;
  public long hmg = 0L;
  public long hmh = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gty);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hmd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hka);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hme);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hmf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hmg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hmh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.gty);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.hmd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.hka);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.hme);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.hmf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.hmg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.hmh);
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
 * Qualified Name:     com.tencent.mm.f.b.a.rd
 * JD-Core Version:    0.7.0.1
 */