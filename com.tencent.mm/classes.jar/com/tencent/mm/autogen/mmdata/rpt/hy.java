package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hy
  extends a
{
  private String iPn = "";
  public int iPo = 0;
  public int ipH = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(369265);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369265);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369270);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubType:").append(this.iPn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiType:").append(this.iPo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369270);
    return localObject;
  }
  
  public final int getId()
  {
    return 21770;
  }
  
  public final hy rI(String paramString)
  {
    AppMethodBeat.i(369262);
    this.iPn = F("SubType", paramString, true);
    AppMethodBeat.o(369262);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hy
 * JD-Core Version:    0.7.0.1
 */