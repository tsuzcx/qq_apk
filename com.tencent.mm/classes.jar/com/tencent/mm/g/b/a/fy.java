package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  public long dHY = 0L;
  private String eaV = "";
  public long eaW = 0L;
  private long eaX = 0L;
  public long eaY = 0L;
  private long eaZ = 0L;
  private String eba = "";
  public long ebb = 0L;
  private String ebc = "";
  
  public final String PR()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eba);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebc);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.eaV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.eaW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.eaZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.ebb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.ebc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final fy nA(String paramString)
  {
    AppMethodBeat.i(149934);
    this.ebc = t("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
  
  public final fy ny(String paramString)
  {
    AppMethodBeat.i(149932);
    this.eaV = t("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final fy nz(String paramString)
  {
    AppMethodBeat.i(149933);
    this.eba = t("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fy
 * JD-Core Version:    0.7.0.1
 */