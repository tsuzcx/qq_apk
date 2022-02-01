package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fr
  extends a
{
  public String iIg = "";
  private long iJj;
  private String iJk = "";
  private long iJl;
  public String iJm = "";
  public String iJn = "";
  public String iJo = "";
  public long ioV;
  public String iwI = "";
  public String iwJ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368035);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368035);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368038);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ProfileUin:").append(this.iJj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AtText:").append(this.iJk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfClickSucess:").append(this.iJl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileUsername:").append(this.iJm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileBizUin:").append(this.iJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.iIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceInfo:").append(this.iJo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368038);
    return localObject;
  }
  
  public final int getId()
  {
    return 21172;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fr
 * JD-Core Version:    0.7.0.1
 */