package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lr
  extends a
{
  public long iJM;
  public String iJN = "";
  public long iJP;
  public String iJR = "";
  public String ira = "";
  public long irc;
  public long jak;
  public long jal;
  public String jam = "";
  public String jan = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jak);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ira);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jal);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jam);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jan);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368095);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368101);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.iJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.iJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeState:").append(this.jak);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ira);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.iJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeType:").append(this.jal);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WhiteListReddotList:").append(this.jam);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverwriteRedDotTipsID:").append(this.jan);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotactiontimestamp:").append(this.irc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoExt:").append(this.iJR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368101);
    return localObject;
  }
  
  public final int getId()
  {
    return 20951;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lr
 * JD-Core Version:    0.7.0.1
 */