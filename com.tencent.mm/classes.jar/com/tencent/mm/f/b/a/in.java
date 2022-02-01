package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  private String gHZ = "";
  private String gIa = "";
  private String gIb = "";
  private String gIc = "";
  private String gId = "";
  private String gIe = "";
  private String gIf = "";
  private String gIg = "";
  private String gIh = "";
  private long gJd;
  private long gJe;
  private long gJf;
  private long giq;
  private String gjj = "";
  private String gmF = "";
  private long gnP;
  
  public final String agH()
  {
    AppMethodBeat.i(208981);
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
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208981);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208982);
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
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.gIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvNonceId:").append(this.gIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.gIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.gIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.gId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSDK:").append(this.gJd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareMusicType:").append(this.gJe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareButton:").append(this.gJf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208982);
    return localObject;
  }
  
  public final in alU()
  {
    this.gJf = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 22233;
  }
  
  public final in tJ(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final in tK(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final in tL(long paramLong)
  {
    this.gJe = paramLong;
    return this;
  }
  
  public final in zm(String paramString)
  {
    AppMethodBeat.i(208969);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208969);
    return this;
  }
  
  public final in zn(String paramString)
  {
    AppMethodBeat.i(208970);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(208970);
    return this;
  }
  
  public final in zo(String paramString)
  {
    AppMethodBeat.i(208971);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(208971);
    return this;
  }
  
  public final in zp(String paramString)
  {
    AppMethodBeat.i(208972);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(208972);
    return this;
  }
  
  public final in zq(String paramString)
  {
    AppMethodBeat.i(208974);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(208974);
    return this;
  }
  
  public final in zr(String paramString)
  {
    AppMethodBeat.i(208975);
    this.gIf = z("MvObjectId", paramString, true);
    AppMethodBeat.o(208975);
    return this;
  }
  
  public final in zs(String paramString)
  {
    AppMethodBeat.i(208976);
    this.gIg = z("MvNonceId", paramString, true);
    AppMethodBeat.o(208976);
    return this;
  }
  
  public final in zt(String paramString)
  {
    AppMethodBeat.i(208977);
    this.gIh = z("MvUserId", paramString, true);
    AppMethodBeat.o(208977);
    return this;
  }
  
  public final in zu(String paramString)
  {
    AppMethodBeat.i(208978);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(208978);
    return this;
  }
  
  public final in zv(String paramString)
  {
    AppMethodBeat.i(208979);
    this.gIe = z("FromSourceId", paramString, true);
    AppMethodBeat.o(208979);
    return this;
  }
  
  public final in zw(String paramString)
  {
    AppMethodBeat.i(208980);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(208980);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.in
 * JD-Core Version:    0.7.0.1
 */