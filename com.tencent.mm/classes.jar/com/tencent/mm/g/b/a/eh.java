package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  public String dSD = "";
  public String dSE = "";
  public long dSy;
  public String ecZ = "";
  public long ehJ;
  public long ehM;
  public long ehN;
  
  public final String RD()
  {
    AppMethodBeat.i(184778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehJ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184778);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todo:").append(this.ehN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.ehM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ehJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184779);
    return localObject;
  }
  
  public final int getId()
  {
    return 19440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eh
 * JD-Core Version:    0.7.0.1
 */