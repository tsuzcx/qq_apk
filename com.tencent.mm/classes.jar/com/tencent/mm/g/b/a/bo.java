package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  public long cRG = 0L;
  public long cYA = 0L;
  private long cYB = 0L;
  public long cYC = 0L;
  private long cYD = 0L;
  private String cYE = "";
  public long cYF = 0L;
  private String cYG = "";
  private String cYz = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(77612);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYG);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77612);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77613);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.cYz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.cYA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.cYB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.cYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.cYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.cYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.cYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.cYG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77613);
    return localObject;
  }
  
  public final bo gI(String paramString)
  {
    AppMethodBeat.i(77609);
    this.cYz = t("BiilNo", paramString, true);
    AppMethodBeat.o(77609);
    return this;
  }
  
  public final bo gJ(String paramString)
  {
    AppMethodBeat.i(77610);
    this.cYE = t("content", paramString, true);
    AppMethodBeat.o(77610);
    return this;
  }
  
  public final bo gK(String paramString)
  {
    AppMethodBeat.i(77611);
    this.cYG = t("packId", paramString, true);
    AppMethodBeat.o(77611);
    return this;
  }
  
  public final int getId()
  {
    return 14404;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */