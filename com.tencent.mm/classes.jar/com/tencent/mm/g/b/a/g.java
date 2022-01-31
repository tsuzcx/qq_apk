package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public int cPS = 0;
  public int cPT = 0;
  public int cPU = 0;
  public int cPV = 0;
  private String cPW;
  public int cPX;
  public long cPY = 0L;
  public long cPZ = 0L;
  private String cQa;
  public long cQb = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(151537);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cPS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQb);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(151537);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(151538);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.cPS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.cPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.cPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.cPV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.cPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.cPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.cPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.cPZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.cQa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.cQb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(151538);
    return localObject;
  }
  
  public final g eR(String paramString)
  {
    AppMethodBeat.i(151536);
    this.cPW = t("filekey", paramString, true);
    AppMethodBeat.o(151536);
    return this;
  }
  
  public final g eS(String paramString)
  {
    AppMethodBeat.i(155155);
    this.cQa = t("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(155155);
    return this;
  }
  
  public final int getId()
  {
    return 17473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.g
 * JD-Core Version:    0.7.0.1
 */