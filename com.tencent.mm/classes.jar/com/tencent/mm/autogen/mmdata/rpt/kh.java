package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kh
  extends a
{
  public String iBL = "";
  public String iWl = "";
  public long iWn;
  public String ipT = "";
  public long iuW;
  public long iyK;
  
  public final String aIE()
  {
    AppMethodBeat.i(368865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368865);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368870);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ItemId:").append(this.iBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.iuW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddType:").append(this.iWn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.iyK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.iWl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368870);
    return localObject;
  }
  
  public final int getId()
  {
    return 21935;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kh
 * JD-Core Version:    0.7.0.1
 */