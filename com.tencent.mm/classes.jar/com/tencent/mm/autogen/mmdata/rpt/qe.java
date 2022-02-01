package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qe
  extends a
{
  public String iWS = "";
  public String iWT = "";
  public String iWU = "";
  public String iWV = "";
  public String iWY = "";
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
  public String ipT = "";
  private String izz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369020);
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
    AppMethodBeat.o(369020);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369028);
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
    AppMethodBeat.o(369028);
    return localObject;
  }
  
  public final int getId()
  {
    return 22230;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qe
 * JD-Core Version:    0.7.0.1
 */