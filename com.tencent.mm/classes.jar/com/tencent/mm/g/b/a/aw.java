package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  public long dHq = 0L;
  public long dMX = 0L;
  public long dMY = 0L;
  public long dMZ = 0L;
  public long dNa = 0L;
  public long dNb = 0L;
  private String dNc = "";
  public long dNd = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.dMX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.dMY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.dMZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.dNa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.dNb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.dNc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.dNd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final aw hM(String paramString)
  {
    AppMethodBeat.i(149909);
    this.dNc = t("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aw
 * JD-Core Version:    0.7.0.1
 */