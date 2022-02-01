package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ku
  extends a
{
  private String iWS = "";
  private String iWT = "";
  private String iWU = "";
  private String iWV = "";
  public String iWY = "";
  private String iWZ = "";
  private String iXa = "";
  private String iXb = "";
  private String iXc = "";
  private long iYb;
  public long iYc;
  public long iYd;
  private String imT = "";
  public long ioV;
  private String ipT = "";
  public long iqr;
  
  public final String aIE()
  {
    AppMethodBeat.i(368867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYd);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368867);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.iWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.iWY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.iWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.iWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.iXa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvNonceId:").append(this.iXb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.iXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.iWZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.iWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSDK:").append(this.iYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareMusicType:").append(this.iYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareButton:").append(this.iYd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368882);
    return localObject;
  }
  
  public final int getId()
  {
    return 22233;
  }
  
  public final ku tI(String paramString)
  {
    AppMethodBeat.i(368785);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(368785);
    return this;
  }
  
  public final ku tJ(String paramString)
  {
    AppMethodBeat.i(368794);
    this.iWS = F("SongName", paramString, true);
    AppMethodBeat.o(368794);
    return this;
  }
  
  public final ku tK(String paramString)
  {
    AppMethodBeat.i(368799);
    this.iWU = F("WebUrl", paramString, true);
    AppMethodBeat.o(368799);
    return this;
  }
  
  public final ku tL(String paramString)
  {
    AppMethodBeat.i(368805);
    this.iWV = F("DataUrl", paramString, true);
    AppMethodBeat.o(368805);
    return this;
  }
  
  public final ku tM(String paramString)
  {
    AppMethodBeat.i(368814);
    this.iXa = F("MvObjectId", paramString, true);
    AppMethodBeat.o(368814);
    return this;
  }
  
  public final ku tN(String paramString)
  {
    AppMethodBeat.i(368822);
    this.iXb = F("MvNonceId", paramString, true);
    AppMethodBeat.o(368822);
    return this;
  }
  
  public final ku tO(String paramString)
  {
    AppMethodBeat.i(368830);
    this.iXc = F("MvUserId", paramString, true);
    AppMethodBeat.o(368830);
    return this;
  }
  
  public final ku tP(String paramString)
  {
    AppMethodBeat.i(368838);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(368838);
    return this;
  }
  
  public final ku tQ(String paramString)
  {
    AppMethodBeat.i(368846);
    this.iWZ = F("FromSourceId", paramString, true);
    AppMethodBeat.o(368846);
    return this;
  }
  
  public final ku tR(String paramString)
  {
    AppMethodBeat.i(368854);
    this.iWT = F("Singer", paramString, true);
    AppMethodBeat.o(368854);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ku
 * JD-Core Version:    0.7.0.1
 */