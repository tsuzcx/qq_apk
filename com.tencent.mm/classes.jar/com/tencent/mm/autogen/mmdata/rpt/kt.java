package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kt
  extends a
{
  private String iWS = "";
  private String iWT = "";
  private String iWU = "";
  private String iWV = "";
  private String iWY = "";
  private String iXZ = "";
  private String iXa = "";
  private String iXb = "";
  private String iXc = "";
  public long iXd;
  public long iXe;
  public long iXf;
  private String iXg = "";
  public long iYa;
  public long ioV;
  private String ipT = "";
  public String izz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368802);
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
    ((StringBuffer)localObject).append(this.iXd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368802);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368809);
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
    ((StringBuffer)localObject).append("MusicLength:").append(this.iXd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMusicTime:").append(this.iXe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMvTime:").append(this.iXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.izz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentMessage:").append(this.iXg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUser:").append(this.iXZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.iWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeButton:").append(this.iYa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368809);
    return localObject;
  }
  
  public final int getId()
  {
    return 22230;
  }
  
  public final kt tA(String paramString)
  {
    AppMethodBeat.i(368763);
    this.iWS = F("SongName", paramString, true);
    AppMethodBeat.o(368763);
    return this;
  }
  
  public final kt tB(String paramString)
  {
    AppMethodBeat.i(368767);
    this.iWY = F("SongId", paramString, true);
    AppMethodBeat.o(368767);
    return this;
  }
  
  public final kt tC(String paramString)
  {
    AppMethodBeat.i(368773);
    this.iWU = F("WebUrl", paramString, true);
    AppMethodBeat.o(368773);
    return this;
  }
  
  public final kt tD(String paramString)
  {
    AppMethodBeat.i(368777);
    this.iWV = F("DataUrl", paramString, true);
    AppMethodBeat.o(368777);
    return this;
  }
  
  public final kt tE(String paramString)
  {
    AppMethodBeat.i(368784);
    this.iXa = F("MvObjectId", paramString, true);
    AppMethodBeat.o(368784);
    return this;
  }
  
  public final kt tF(String paramString)
  {
    AppMethodBeat.i(368790);
    this.iXb = F("MvNonceId", paramString, true);
    AppMethodBeat.o(368790);
    return this;
  }
  
  public final kt tG(String paramString)
  {
    AppMethodBeat.i(368795);
    this.iXc = F("MvUserId", paramString, true);
    AppMethodBeat.o(368795);
    return this;
  }
  
  public final kt tH(String paramString)
  {
    AppMethodBeat.i(368798);
    this.iWT = F("Singer", paramString, true);
    AppMethodBeat.o(368798);
    return this;
  }
  
  public final kt tz(String paramString)
  {
    AppMethodBeat.i(368757);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(368757);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kt
 * JD-Core Version:    0.7.0.1
 */