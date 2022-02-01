package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jp
  extends a
{
  public long iUt;
  public String iUu = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368494);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResType:").append(this.iUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubTypeList:").append(this.iUu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368501);
    return localObject;
  }
  
  public final int getId()
  {
    return 25161;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jp
 * JD-Core Version:    0.7.0.1
 */