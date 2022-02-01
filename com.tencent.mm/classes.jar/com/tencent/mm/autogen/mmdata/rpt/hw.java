package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  public int iPf;
  public int iPg;
  public String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369250);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369250);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369258);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionScene:").append(this.iPf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordIndex:").append(this.iPg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369258);
    return localObject;
  }
  
  public final int getId()
  {
    return 21768;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hw
 * JD-Core Version:    0.7.0.1
 */