package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  public long dSy;
  public long dUW;
  private String edC = "";
  private long ehJ;
  private String ehK = "";
  private String ehL = "";
  public long ehm;
  
  public final String RD()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.edC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.ehm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ehJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.ehK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final ee Tj()
  {
    this.ehJ = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final ee nv(String paramString)
  {
    AppMethodBeat.i(184767);
    this.edC = t("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final ee nw(String paramString)
  {
    AppMethodBeat.i(184768);
    this.ehK = t("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final ee nx(String paramString)
  {
    AppMethodBeat.i(213375);
    this.ehL = t("appusername", paramString, true);
    AppMethodBeat.o(213375);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ee
 * JD-Core Version:    0.7.0.1
 */