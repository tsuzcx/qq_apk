package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String ioS = "";
  public int ipB = 0;
  public int ipC = 0;
  public String ipD = "";
  public String ipE = "";
  public int ipF = 0;
  public int ipG = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368514);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ipB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomUsername:").append(this.ioS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ListCount:").append(this.ipC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addList:").append(this.ipD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delList:").append(this.ipE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.ipF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delCount:").append(this.ipG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368522);
    return localObject;
  }
  
  public final int getId()
  {
    return 23492;
  }
  
  public final au kI(String paramString)
  {
    AppMethodBeat.i(368487);
    this.ioS = F("roomUsername", paramString, true);
    AppMethodBeat.o(368487);
    return this;
  }
  
  public final au kJ(String paramString)
  {
    AppMethodBeat.i(368500);
    this.ipD = F("addList", paramString, true);
    AppMethodBeat.o(368500);
    return this;
  }
  
  public final au kK(String paramString)
  {
    AppMethodBeat.i(368508);
    this.ipE = F("delList", paramString, true);
    AppMethodBeat.o(368508);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.au
 * JD-Core Version:    0.7.0.1
 */