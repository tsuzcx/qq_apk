package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  public long ila;
  public String inx = "";
  public long iuq;
  public String ixK = "";
  private String iye = "";
  private String iyf = "";
  private String iyg = "";
  public long iyh;
  public long iyi;
  
  public final String aIE()
  {
    AppMethodBeat.i(368116);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iye);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyi);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368116);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368121);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("finderUsername:").append(this.iye);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUsername:").append(this.iyf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toFinderUsername:").append(this.iyg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.iuq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.iyh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatType:").append(this.iyi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368121);
    return localObject;
  }
  
  public final int getId()
  {
    return 20671;
  }
  
  public final cy mQ(String paramString)
  {
    AppMethodBeat.i(368097);
    this.iye = F("finderUsername", paramString, true);
    AppMethodBeat.o(368097);
    return this;
  }
  
  public final cy mR(String paramString)
  {
    AppMethodBeat.i(368102);
    this.iyf = F("toUsername", paramString, true);
    AppMethodBeat.o(368102);
    return this;
  }
  
  public final cy mS(String paramString)
  {
    AppMethodBeat.i(368106);
    this.iyg = F("toFinderUsername", paramString, true);
    AppMethodBeat.o(368106);
    return this;
  }
  
  public final cy mT(String paramString)
  {
    AppMethodBeat.i(368109);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368109);
    return this;
  }
  
  public final cy mU(String paramString)
  {
    AppMethodBeat.i(368112);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(368112);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cy
 * JD-Core Version:    0.7.0.1
 */