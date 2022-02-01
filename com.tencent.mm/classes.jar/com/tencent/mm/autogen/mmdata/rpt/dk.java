package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  private String ijk = "";
  private String imE = "";
  public long ioV;
  private String iqk = "";
  public long iwD;
  private String iwI = "";
  private String ixK = "";
  public long izD;
  private String izE = "";
  private String izF = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368468);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368468);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Url:").append(this.imE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UrlType:").append(this.izD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniAppId:").append(this.izE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.iwD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.izF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368477);
    return localObject;
  }
  
  public final int getId()
  {
    return 21464;
  }
  
  public final dk nr(String paramString)
  {
    AppMethodBeat.i(368433);
    this.iqk = F("Feedid", paramString, true);
    AppMethodBeat.o(368433);
    return this;
  }
  
  public final dk ns(String paramString)
  {
    AppMethodBeat.i(368438);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368438);
    return this;
  }
  
  public final dk nt(String paramString)
  {
    AppMethodBeat.i(368442);
    this.iwI = F("Contextid", paramString, true);
    AppMethodBeat.o(368442);
    return this;
  }
  
  public final dk nu(String paramString)
  {
    AppMethodBeat.i(368447);
    this.imE = F("Url", paramString, true);
    AppMethodBeat.o(368447);
    return this;
  }
  
  public final dk nv(String paramString)
  {
    AppMethodBeat.i(368452);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(368452);
    return this;
  }
  
  public final dk nw(String paramString)
  {
    AppMethodBeat.i(368459);
    this.izF = F("sessionBuffer", paramString, true);
    AppMethodBeat.o(368459);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dk
 * JD-Core Version:    0.7.0.1
 */