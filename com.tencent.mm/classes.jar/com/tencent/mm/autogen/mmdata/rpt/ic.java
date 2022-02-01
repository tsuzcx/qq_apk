package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ic
  extends a
{
  public String iPt = "";
  public int iPu;
  public String ijk = "";
  public int imW;
  public int ipH;
  
  public final String aIE()
  {
    AppMethodBeat.i(369223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369223);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369234);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PackageName:").append(this.iPt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KbType:").append(this.iPu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369234);
    return localObject;
  }
  
  public final int getId()
  {
    return 21766;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ic
 * JD-Core Version:    0.7.0.1
 */