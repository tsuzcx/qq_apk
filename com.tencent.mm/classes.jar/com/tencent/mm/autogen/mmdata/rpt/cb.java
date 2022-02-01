package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  public String ijk = "";
  public long ioV = 0L;
  public String ipd = "";
  public String iuU = "";
  public String iuV = "";
  public long iuW;
  
  public final String aIE()
  {
    AppMethodBeat.i(368259);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368259);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368262);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.iuU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DocId:").append(this.iuV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.ipd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.iuW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368262);
    return localObject;
  }
  
  public final int getId()
  {
    return 22411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cb
 * JD-Core Version:    0.7.0.1
 */