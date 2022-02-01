package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  public long gCU = 0L;
  public long gCV = 0L;
  public long gCW = 0L;
  public long gCX = 0L;
  public long gCY = 0L;
  private String gCZ = "";
  public long gDa = 0L;
  public long giq = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.gCU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.gCV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.gCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.gCX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.gCY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.gCZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.gDa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final go vB(String paramString)
  {
    AppMethodBeat.i(149909);
    this.gCZ = z("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.go
 * JD-Core Version:    0.7.0.1
 */