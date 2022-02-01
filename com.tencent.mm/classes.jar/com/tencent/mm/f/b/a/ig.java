package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private String gHZ = "";
  private String gIa = "";
  private String gIb = "";
  private String gIc = "";
  private String gId = "";
  private String gIe = "";
  public long giq;
  private String gjj = "";
  private String gmF = "";
  public long gnP;
  
  public final String agH()
  {
    AppMethodBeat.i(208743);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208743);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.gHZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.gIa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.gIb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.gIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.gId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.gIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208745);
    return localObject;
  }
  
  public final long ahC()
  {
    return this.giq;
  }
  
  public final long alF()
  {
    return this.gnP;
  }
  
  public final String alP()
  {
    return this.gHZ;
  }
  
  public final String alQ()
  {
    return this.gId;
  }
  
  public final String getAppId()
  {
    return this.gmF;
  }
  
  public final int getId()
  {
    return 22243;
  }
  
  public final ig sJ(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ig sK(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ig xP(String paramString)
  {
    AppMethodBeat.i(208726);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208726);
    return this;
  }
  
  public final ig xQ(String paramString)
  {
    AppMethodBeat.i(208728);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(208728);
    return this;
  }
  
  public final ig xR(String paramString)
  {
    AppMethodBeat.i(208731);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(208731);
    return this;
  }
  
  public final ig xS(String paramString)
  {
    AppMethodBeat.i(208733);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(208733);
    return this;
  }
  
  public final ig xT(String paramString)
  {
    AppMethodBeat.i(208735);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(208735);
    return this;
  }
  
  public final ig xU(String paramString)
  {
    AppMethodBeat.i(208738);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(208738);
    return this;
  }
  
  public final ig xV(String paramString)
  {
    AppMethodBeat.i(208741);
    this.gIe = z("FromSourceId", paramString, true);
    AppMethodBeat.o(208741);
    return this;
  }
  
  public final ig xW(String paramString)
  {
    AppMethodBeat.i(208742);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(208742);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ig
 * JD-Core Version:    0.7.0.1
 */