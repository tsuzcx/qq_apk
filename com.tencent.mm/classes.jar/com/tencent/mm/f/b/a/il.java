package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  private String gHZ = "";
  private long gIC;
  private String gIW = "";
  private String gIX = "";
  private String gIY = "";
  private long gIZ;
  private String gIa = "";
  private String gIb = "";
  private String gIc = "";
  private String gId = "";
  private long gJa;
  private long giq;
  private String gjj = "";
  private String gmF = "";
  
  public final String agH()
  {
    AppMethodBeat.i(227467);
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
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(227467);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(227478);
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
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLyric:").append(this.gIC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sect:").append(this.gIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CoverURL:").append(this.gIX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Language:").append(this.gIY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSuccess:").append(this.gIZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpScene:").append(this.gJa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(227478);
    return localObject;
  }
  
  public final int getId()
  {
    return 22234;
  }
  
  public final il tA(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final il tB(long paramLong)
  {
    this.gIC = paramLong;
    return this;
  }
  
  public final il tC(long paramLong)
  {
    this.gIZ = paramLong;
    return this;
  }
  
  public final il tD(long paramLong)
  {
    this.gJa = paramLong;
    return this;
  }
  
  public final il yT(String paramString)
  {
    AppMethodBeat.i(227443);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(227443);
    return this;
  }
  
  public final il yU(String paramString)
  {
    AppMethodBeat.i(227445);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(227445);
    return this;
  }
  
  public final il yV(String paramString)
  {
    AppMethodBeat.i(227446);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(227446);
    return this;
  }
  
  public final il yW(String paramString)
  {
    AppMethodBeat.i(227448);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(227448);
    return this;
  }
  
  public final il yX(String paramString)
  {
    AppMethodBeat.i(227450);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(227450);
    return this;
  }
  
  public final il yY(String paramString)
  {
    AppMethodBeat.i(227453);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(227453);
    return this;
  }
  
  public final il yZ(String paramString)
  {
    AppMethodBeat.i(227455);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(227455);
    return this;
  }
  
  public final il za(String paramString)
  {
    AppMethodBeat.i(227457);
    this.gIW = z("Sect", paramString, true);
    AppMethodBeat.o(227457);
    return this;
  }
  
  public final il zb(String paramString)
  {
    AppMethodBeat.i(227458);
    this.gIX = z("CoverURL", paramString, true);
    AppMethodBeat.o(227458);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.il
 * JD-Core Version:    0.7.0.1
 */