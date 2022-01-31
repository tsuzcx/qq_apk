package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  public long cRJ = 0L;
  public long cRK = 0L;
  public long cRL = 0L;
  public long cRM = 0L;
  public long cRN = 0L;
  public long cRO = 0L;
  private String cRP = "";
  public long cRQ = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77585);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRQ);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77585);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77586);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.cRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.cRK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.cRL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.cRM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.cRN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.cRO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.cRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.cRQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77586);
    return localObject;
  }
  
  public final o fg(String paramString)
  {
    AppMethodBeat.i(77584);
    this.cRP = t("EmoticonMd5", paramString, true);
    AppMethodBeat.o(77584);
    return this;
  }
  
  public final int getId()
  {
    return 16724;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.o
 * JD-Core Version:    0.7.0.1
 */