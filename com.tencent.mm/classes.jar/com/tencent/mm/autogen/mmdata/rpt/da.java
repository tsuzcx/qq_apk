package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  public long ijn;
  public long ixC;
  public long iyp;
  public long iyq;
  public long iyr;
  
  public final String aIE()
  {
    AppMethodBeat.i(368463);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iyp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368463);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368472);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimestamps:").append(this.iyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.iyq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.iyr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.ijn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.ixC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368472);
    return localObject;
  }
  
  public final int getId()
  {
    return 21077;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.da
 * JD-Core Version:    0.7.0.1
 */