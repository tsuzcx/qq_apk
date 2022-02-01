package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bw
  extends a
{
  public long dFd = 0L;
  public long dNA = 0L;
  public long dNB = 0L;
  public long dNC = 0L;
  private String dND = "";
  public long dNE = 0L;
  public long dNy = 0L;
  public long dNz = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dND);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNE);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.dNy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.dNz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.dNA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.dNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.dNC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.dND);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.dNE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final bw jQ(String paramString)
  {
    AppMethodBeat.i(149909);
    this.dND = t("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bw
 * JD-Core Version:    0.7.0.1
 */