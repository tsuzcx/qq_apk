package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  public long eEI = 0L;
  public long eEJ = 0L;
  public long eEK = 0L;
  public long eEL = 0L;
  public long eEM = 0L;
  private String eEN = "";
  public long eEO = 0L;
  public long enl = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.eEI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.eEJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.eEK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.eEL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.eEM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.eEN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.eEO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final ey rU(String paramString)
  {
    AppMethodBeat.i(149909);
    this.eEN = x("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ey
 * JD-Core Version:    0.7.0.1
 */