package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class k
  extends a
{
  public int dTg = 0;
  public int dTh = 0;
  public int dTi = 0;
  public int dTj = 0;
  private String dTk = "";
  public int dTl;
  public long dTm = 0L;
  public long dTn = 0L;
  private String dTo = "";
  public long dTp = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.dTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.dTh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.dTj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.dTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.dTl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.dTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.dTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.dTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.dTp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final k gM(String paramString)
  {
    AppMethodBeat.i(149903);
    this.dTk = t("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
  
  public final k gN(String paramString)
  {
    AppMethodBeat.i(149904);
    this.dTo = t("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(149904);
    return this;
  }
  
  public final int getId()
  {
    return 17473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.k
 * JD-Core Version:    0.7.0.1
 */