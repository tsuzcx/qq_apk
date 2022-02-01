package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ei
  extends a
{
  public long dKe = 0L;
  private String dZd = "";
  public long dZe = 0L;
  private long dZf = 0L;
  public long dZg = 0L;
  private long dZh = 0L;
  private String dZi = "";
  public long dZj = 0L;
  private String dZk = "";
  
  public final String PV()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZk);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.dZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.dZe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.dZf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.dZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.dZh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.dZi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.dZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.dZk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final ei kG(String paramString)
  {
    AppMethodBeat.i(149932);
    this.dZd = t("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final ei kH(String paramString)
  {
    AppMethodBeat.i(149933);
    this.dZi = t("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final ei kI(String paramString)
  {
    AppMethodBeat.i(149934);
    this.dZk = t("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ei
 * JD-Core Version:    0.7.0.1
 */