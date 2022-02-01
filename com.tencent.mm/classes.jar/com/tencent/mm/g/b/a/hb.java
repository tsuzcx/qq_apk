package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hb
  extends a
{
  public long dVd = 0L;
  public long eaw = 0L;
  private String erD = "";
  public long erE = 0L;
  private long erF = 0L;
  private long erG = 0L;
  private String erH = "";
  public long erI = 0L;
  private String erJ = "";
  
  public final String RD()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erJ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.erD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.erE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.erF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.erG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.erI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.erJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final hb pX(String paramString)
  {
    AppMethodBeat.i(149932);
    this.erD = t("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final hb pY(String paramString)
  {
    AppMethodBeat.i(149933);
    this.erH = t("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final hb pZ(String paramString)
  {
    AppMethodBeat.i(149934);
    this.erJ = t("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hb
 * JD-Core Version:    0.7.0.1
 */