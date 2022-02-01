package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd
  extends a
{
  public long dWt = 0L;
  public long ebQ = 0L;
  private String etk = "";
  public long etl = 0L;
  private long etm = 0L;
  private long etn = 0L;
  private String eto = "";
  public long etp = 0L;
  private String etq = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etq);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.etk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.etl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.etm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.etn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.etq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final hd qs(String paramString)
  {
    AppMethodBeat.i(149932);
    this.etk = t("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final hd qt(String paramString)
  {
    AppMethodBeat.i(149933);
    this.eto = t("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final hd qu(String paramString)
  {
    AppMethodBeat.i(149934);
    this.etq = t("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hd
 * JD-Core Version:    0.7.0.1
 */