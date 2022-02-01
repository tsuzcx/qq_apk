package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  public int ipK = 0;
  public long iuf;
  public int iug;
  public long iuh;
  
  public final String aIE()
  {
    AppMethodBeat.i(368823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iug);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368823);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Version:").append(this.iuf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.iug);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitCost:").append(this.iuh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.ipK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368829);
    return localObject;
  }
  
  public final int getId()
  {
    return 23818;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bq
 * JD-Core Version:    0.7.0.1
 */