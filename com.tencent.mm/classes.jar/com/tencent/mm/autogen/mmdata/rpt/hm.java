package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  public long iOF = 0L;
  public long iOG = 0L;
  public long iqr = 0L;
  public String iuQ = "";
  public long iyq = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.iuQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.iOF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.iyq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.iOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184551);
    return localObject;
  }
  
  public final int getId()
  {
    return 12639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hm
 * JD-Core Version:    0.7.0.1
 */