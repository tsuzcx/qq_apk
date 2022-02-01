package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class im
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
  private String gJb = "";
  private long gJc;
  private long giq;
  private String gjj = "";
  private String gpN = "";
  
  public final String agH()
  {
    AppMethodBeat.i(235381);
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
    ((StringBuffer)localObject).append(this.gJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(235381);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(235384);
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
    ((StringBuffer)localObject).append("CommentUser:").append(this.gJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.gId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeButton:").append(this.gJc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(235384);
    return localObject;
  }
  
  public final int getId()
  {
    return 22230;
  }
  
  public final im tE(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final im tF(long paramLong)
  {
    this.gIi = paramLong;
    return this;
  }
  
  public final im tG(long paramLong)
  {
    this.gIj = paramLong;
    return this;
  }
  
  public final im tH(long paramLong)
  {
    this.gIk = paramLong;
    return this;
  }
  
  public final im tI(long paramLong)
  {
    this.gJc = paramLong;
    return this;
  }
  
  public final im zc(String paramString)
  {
    AppMethodBeat.i(235348);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(235348);
    return this;
  }
  
  public final im zd(String paramString)
  {
    AppMethodBeat.i(235351);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(235351);
    return this;
  }
  
  public final im ze(String paramString)
  {
    AppMethodBeat.i(235354);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(235354);
    return this;
  }
  
  public final im zf(String paramString)
  {
    AppMethodBeat.i(235356);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(235356);
    return this;
  }
  
  public final im zg(String paramString)
  {
    AppMethodBeat.i(235359);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(235359);
    return this;
  }
  
  public final im zh(String paramString)
  {
    AppMethodBeat.i(235363);
    this.gIf = z("MvObjectId", paramString, true);
    AppMethodBeat.o(235363);
    return this;
  }
  
  public final im zi(String paramString)
  {
    AppMethodBeat.i(235366);
    this.gIg = z("MvNonceId", paramString, true);
    AppMethodBeat.o(235366);
    return this;
  }
  
  public final im zj(String paramString)
  {
    AppMethodBeat.i(235369);
    this.gIh = z("MvUserId", paramString, true);
    AppMethodBeat.o(235369);
    return this;
  }
  
  public final im zk(String paramString)
  {
    AppMethodBeat.i(235373);
    this.gpN = z("CommentId", paramString, true);
    AppMethodBeat.o(235373);
    return this;
  }
  
  public final im zl(String paramString)
  {
    AppMethodBeat.i(235377);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(235377);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.im
 * JD-Core Version:    0.7.0.1
 */