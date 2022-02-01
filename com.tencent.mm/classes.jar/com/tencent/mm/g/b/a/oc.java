package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oc
  extends a
{
  public String enR = "";
  public long exo = 0L;
  public String fgP = "";
  public String fiT = "";
  public long fiU = 0L;
  public long fiV = 0L;
  public long fiW = 0L;
  public long fiX = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.exo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.fiT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.fgP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.fiU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.fiV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.fiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.fiX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116509);
    return localObject;
  }
  
  public final int getId()
  {
    return 15778;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oc
 * JD-Core Version:    0.7.0.1
 */