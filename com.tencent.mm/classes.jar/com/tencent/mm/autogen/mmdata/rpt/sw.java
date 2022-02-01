package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sw
  extends a
{
  public String ilJ = "";
  public String jzx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jzx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368931);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.jzx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.ilJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368941);
    return localObject;
  }
  
  public final int getId()
  {
    return 21750;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sw
 * JD-Core Version:    0.7.0.1
 */