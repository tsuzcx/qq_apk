package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  public long iAj = 0L;
  public long iAk;
  public String iAl = "";
  public long iAm;
  public long iAn;
  public String iqP = "";
  public String ixm = "";
  public long izR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368410);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iAj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368410);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368417);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.iAj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.iAk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.izR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.iAl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.iAm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.iAn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iqP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368417);
    return localObject;
  }
  
  public final int getId()
  {
    return 19949;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dq
 * JD-Core Version:    0.7.0.1
 */