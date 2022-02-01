package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  public long dSa = 0L;
  public long ecN = 0L;
  public long ecO = 0L;
  public long ecP = 0L;
  public long ecQ = 0L;
  public long ecR = 0L;
  private String ecS = "";
  public long ecT = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.ecN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.ecO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.ecP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.ecR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.ecS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.ecT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final cn lM(String paramString)
  {
    AppMethodBeat.i(149909);
    this.ecS = t("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn
 * JD-Core Version:    0.7.0.1
 */