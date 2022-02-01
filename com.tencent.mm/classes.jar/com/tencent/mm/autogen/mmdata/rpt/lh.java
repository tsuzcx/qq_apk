package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lh
  extends a
{
  private String iZH = "";
  public long iZI = 0L;
  public long iZJ = 0L;
  public long iZK = 0L;
  public long iZL = 0L;
  public long iZM = 0L;
  public long iZN = 0L;
  private String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.iZH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.iZI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.iZJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.iZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.iZL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.iZM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.iZN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final lh ue(String paramString)
  {
    AppMethodBeat.i(149918);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final lh uf(String paramString)
  {
    AppMethodBeat.i(149919);
    this.iZH = F("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lh
 * JD-Core Version:    0.7.0.1
 */