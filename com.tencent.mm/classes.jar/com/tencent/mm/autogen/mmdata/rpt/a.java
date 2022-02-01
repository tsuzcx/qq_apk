package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long ijg;
  public long ijh;
  private String iji = "";
  private String ijj = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368720);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368720);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368727);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("errType:").append(this.ijg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errCode:").append(this.ijh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errMsg:").append(this.iji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastKickReason:").append(this.ijj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368727);
    return localObject;
  }
  
  public final int getId()
  {
    return 22500;
  }
  
  public final a jP(String paramString)
  {
    AppMethodBeat.i(368710);
    this.iji = F("errMsg", paramString, true);
    AppMethodBeat.o(368710);
    return this;
  }
  
  public final a jQ(String paramString)
  {
    AppMethodBeat.i(368715);
    this.ijj = F("lastKickReason", paramString, true);
    AppMethodBeat.o(368715);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.a
 * JD-Core Version:    0.7.0.1
 */