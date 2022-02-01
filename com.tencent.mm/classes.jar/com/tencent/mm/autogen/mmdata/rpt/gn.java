package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gn
  extends a
{
  private String iFn = "";
  public int iLq;
  private String iLr = "";
  private String iLs = "";
  public int iLt = -1;
  private String iLu = "";
  public long iLv = -1L;
  public long iLw = -1L;
  public long ijn;
  public long isX = -1L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369137);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iLq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369137);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369143);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("innerversion:").append(this.iLq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.isX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionName:").append(this.iLr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionExt:").append(this.iLs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.iLt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultExt:").append(this.iLu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.ijn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("snn:").append(this.iFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cost:").append(this.iLv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTime:").append(this.iLw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369143);
    return localObject;
  }
  
  public final int getId()
  {
    return 22138;
  }
  
  public final gn rk(String paramString)
  {
    AppMethodBeat.i(369113);
    this.iLr = F("actionName", paramString, true);
    AppMethodBeat.o(369113);
    return this;
  }
  
  public final gn rl(String paramString)
  {
    AppMethodBeat.i(369120);
    this.iLs = F("actionExt", paramString, true);
    AppMethodBeat.o(369120);
    return this;
  }
  
  public final gn rm(String paramString)
  {
    AppMethodBeat.i(369123);
    this.iLu = F("resultExt", paramString, true);
    AppMethodBeat.o(369123);
    return this;
  }
  
  public final gn rn(String paramString)
  {
    AppMethodBeat.i(369128);
    this.iFn = F("snn", paramString, true);
    AppMethodBeat.o(369128);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gn
 * JD-Core Version:    0.7.0.1
 */