package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  public int dHg = 0;
  public int dHh = 0;
  public int dHi = 0;
  public int dHj = 0;
  private String dHk;
  public int dHl;
  public long dHm = 0L;
  public long dHn = 0L;
  private String dHo;
  public long dHp = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHp);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.dHg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.dHh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dHi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.dHj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.dHk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.dHl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.dHm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.dHn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.dHo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.dHp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final i fT(String paramString)
  {
    AppMethodBeat.i(149903);
    this.dHk = t("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
  
  public final i fU(String paramString)
  {
    AppMethodBeat.i(149904);
    this.dHo = t("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(149904);
    return this;
  }
  
  public final int getId()
  {
    return 17473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.i
 * JD-Core Version:    0.7.0.1
 */