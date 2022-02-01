package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  public int dET = 0;
  public int dEU = 0;
  public int dEV = 0;
  public int dEW = 0;
  private String dEX;
  public int dEY;
  public long dEZ = 0L;
  public long dFa = 0L;
  private String dFb;
  public long dFc = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dET);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFc);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.dET);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.dEU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dEV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.dEW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.dEX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.dEY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.dEZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.dFa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.dFb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.dFc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final i fJ(String paramString)
  {
    AppMethodBeat.i(149903);
    this.dEX = t("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
  
  public final i fK(String paramString)
  {
    AppMethodBeat.i(149904);
    this.dFb = t("SystemErrorDescribe", paramString, true);
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