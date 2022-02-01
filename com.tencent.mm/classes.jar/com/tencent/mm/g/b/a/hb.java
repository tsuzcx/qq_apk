package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hb
  extends a
{
  public String dYc = "";
  public long ehL = 0L;
  public long epo = 0L;
  public String erZ = "";
  public long etb = 0L;
  public long etc = 0L;
  public long etd = 0L;
  public long ete = 0L;
  public long etf = 0L;
  public long etg = 0L;
  public String eth = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ete);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eth);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.etc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.epo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.etd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.ete);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.etf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.etg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.eth);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final int getId()
  {
    return 16636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hb
 * JD-Core Version:    0.7.0.1
 */