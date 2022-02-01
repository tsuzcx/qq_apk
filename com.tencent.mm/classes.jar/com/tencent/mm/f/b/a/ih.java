package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ih
  extends a
{
  private String gHZ = "";
  private String gIa = "";
  private String gIb = "";
  private String gIc = "";
  private String gId = "";
  private String gIf = "";
  private String gIg = "";
  private String gIh = "";
  private long gIi;
  private long gIj;
  private long gIk;
  private String gIl = "";
  private long giq;
  private String gjj = "";
  private String gpN = "";
  
  public final String agH()
  {
    AppMethodBeat.i(227669);
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
    ((StringBuffer)localObject).append(this.gIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gId);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(227669);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(227673);
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
    ((StringBuffer)localObject).append("MusicLength:").append(this.gIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMusicTime:").append(this.gIj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMvTime:").append(this.gIk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.gpN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentMessage:").append(this.gIl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.gId);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(227673);
    return localObject;
  }
  
  public final int getId()
  {
    return 22232;
  }
  
  public final ih sL(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ih sM(long paramLong)
  {
    this.gIi = paramLong;
    return this;
  }
  
  public final ih sN(long paramLong)
  {
    this.gIj = paramLong;
    return this;
  }
  
  public final ih sO(long paramLong)
  {
    this.gIk = paramLong;
    return this;
  }
  
  public final ih xX(String paramString)
  {
    AppMethodBeat.i(227645);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(227645);
    return this;
  }
  
  public final ih xY(String paramString)
  {
    AppMethodBeat.i(227647);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(227647);
    return this;
  }
  
  public final ih xZ(String paramString)
  {
    AppMethodBeat.i(227651);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(227651);
    return this;
  }
  
  public final ih ya(String paramString)
  {
    AppMethodBeat.i(227652);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(227652);
    return this;
  }
  
  public final ih yb(String paramString)
  {
    AppMethodBeat.i(227653);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(227653);
    return this;
  }
  
  public final ih yc(String paramString)
  {
    AppMethodBeat.i(227655);
    this.gIf = z("MvObjectId", paramString, true);
    AppMethodBeat.o(227655);
    return this;
  }
  
  public final ih yd(String paramString)
  {
    AppMethodBeat.i(227657);
    this.gIg = z("MvNonceId", paramString, true);
    AppMethodBeat.o(227657);
    return this;
  }
  
  public final ih ye(String paramString)
  {
    AppMethodBeat.i(227658);
    this.gIh = z("MvUserId", paramString, true);
    AppMethodBeat.o(227658);
    return this;
  }
  
  public final ih yf(String paramString)
  {
    AppMethodBeat.i(227663);
    this.gpN = z("CommentId", paramString, true);
    AppMethodBeat.o(227663);
    return this;
  }
  
  public final ih yg(String paramString)
  {
    AppMethodBeat.i(227665);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(227665);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ih
 * JD-Core Version:    0.7.0.1
 */