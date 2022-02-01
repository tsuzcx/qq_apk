package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kg
  extends a
{
  public String iBL = "";
  public long iMe;
  public long iWk;
  public String iWl = "";
  public long iWm;
  public long ikE;
  public String ipT = "";
  public long iuW;
  
  public final String aIE()
  {
    AppMethodBeat.i(368864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368864);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.iuW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.iBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.iMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTimestamp:").append(this.iWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.iWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActualExposeTimestamp:").append(this.iWm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368869);
    return localObject;
  }
  
  public final int getId()
  {
    return 21922;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kg
 * JD-Core Version:    0.7.0.1
 */