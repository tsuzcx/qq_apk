package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ba
  extends a
{
  public String iqk = "";
  private long iql;
  public long iqm;
  public String iqn = "";
  public String iqo = "";
  public String iqp = "";
  public long iqq;
  
  public final String aIE()
  {
    AppMethodBeat.i(368969);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368969);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368980);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontimestampms:").append(this.iql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("atcion:").append(this.iqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperId:").append(this.iqn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperWording:").append(this.iqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagClickable:").append(this.iqq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368980);
    return localObject;
  }
  
  public final ba ev(long paramLong)
  {
    AppMethodBeat.i(368965);
    this.iql = paramLong;
    super.by("actiontimestampms", this.iql);
    AppMethodBeat.o(368965);
    return this;
  }
  
  public final int getId()
  {
    return 21559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ba
 * JD-Core Version:    0.7.0.1
 */