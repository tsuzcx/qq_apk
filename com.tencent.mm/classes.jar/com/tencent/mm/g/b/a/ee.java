package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  public long dYh;
  public long dYi;
  public long dYj;
  public long dYk;
  public String dYl;
  public String dYm;
  public long dYn;
  private String dYo;
  private String dYp;
  private String dYq;
  private String dYr;
  public long dYs;
  
  public final String PV()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYs);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.dYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.dYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.dYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.dYl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.dYm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.dYn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.dYo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.dYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.dYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.dYs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final ee kA(String paramString)
  {
    AppMethodBeat.i(43452);
    this.dYq = t("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final ee kB(String paramString)
  {
    AppMethodBeat.i(43453);
    this.dYr = t("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
  
  public final ee ky(String paramString)
  {
    AppMethodBeat.i(43450);
    this.dYo = t("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final ee kz(String paramString)
  {
    AppMethodBeat.i(43451);
    this.dYp = t("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ee
 * JD-Core Version:    0.7.0.1
 */