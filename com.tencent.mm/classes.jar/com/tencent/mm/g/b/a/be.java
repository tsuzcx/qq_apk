package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  private String cSd = "";
  public long cVW = 0L;
  private String cWQ = "";
  public long cWR = 0L;
  private String cWS = "";
  public long cWT = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(35571);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVW);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(35571);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(35572);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.cWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.cWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.cWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.cWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.cVW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(35572);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final be gu(String paramString)
  {
    AppMethodBeat.i(35568);
    this.cWQ = t("EnterObjectId", paramString, true);
    AppMethodBeat.o(35568);
    return this;
  }
  
  public final be gv(String paramString)
  {
    AppMethodBeat.i(35569);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(35569);
    return this;
  }
  
  public final be gw(String paramString)
  {
    AppMethodBeat.i(35570);
    this.cWS = t("ExposeUinList", paramString, true);
    AppMethodBeat.o(35570);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */