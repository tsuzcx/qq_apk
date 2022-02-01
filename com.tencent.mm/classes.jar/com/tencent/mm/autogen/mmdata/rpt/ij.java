package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ij
  extends a
{
  public long iPW = 0L;
  public long iPX = 0L;
  public long iPY = 0L;
  public long iPZ = 0L;
  public long iQa = 0L;
  private String iQb = "";
  public long iQc = 0L;
  public long ioV = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.iPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.iPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.iPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.iPZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.iQa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.iQb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.iQc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final ij rN(String paramString)
  {
    AppMethodBeat.i(149909);
    this.iQb = F("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ij
 * JD-Core Version:    0.7.0.1
 */