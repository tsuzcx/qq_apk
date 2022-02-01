package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  private String ijk = "";
  private String iny = "";
  private String ivZ = "";
  private String iyA = "";
  private String iyB = "";
  private long iyC;
  private long iyD;
  private String iyt = "";
  public long izg;
  public long izh;
  private String izi = "";
  public long izj;
  public long izk;
  public long izl;
  private String izm = "";
  public long izn;
  public String izo = "";
  private String izp = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368493);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.izg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.izh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.izi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.iyt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.iyA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.iyB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.iyC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.iyD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.izj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.izk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIType:").append(this.izl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupID:").append(this.izm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TrackType:").append(this.izn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ColumnId:").append(this.izo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityID:").append(this.izp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368505);
    return localObject;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final dh ni(String paramString)
  {
    AppMethodBeat.i(368454);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368454);
    return this;
  }
  
  public final dh nj(String paramString)
  {
    AppMethodBeat.i(368462);
    this.izi = F("SourceUsr", paramString, true);
    AppMethodBeat.o(368462);
    return this;
  }
  
  public final dh nk(String paramString)
  {
    AppMethodBeat.i(368469);
    this.ivZ = F("FeedId", paramString, true);
    AppMethodBeat.o(368469);
    return this;
  }
  
  public final dh nl(String paramString)
  {
    AppMethodBeat.i(368474);
    this.iyt = F("FeedUsr", paramString, true);
    AppMethodBeat.o(368474);
    return this;
  }
  
  public final dh nm(String paramString)
  {
    AppMethodBeat.i(368479);
    this.iyA = F("Tag", paramString, true);
    AppMethodBeat.o(368479);
    return this;
  }
  
  public final dh nn(String paramString)
  {
    AppMethodBeat.i(368481);
    this.izm = F("GroupID", paramString, true);
    AppMethodBeat.o(368481);
    return this;
  }
  
  public final dh no(String paramString)
  {
    AppMethodBeat.i(368483);
    this.izp = F("ActivityID", paramString, true);
    AppMethodBeat.o(368483);
    return this;
  }
  
  public final dh np(String paramString)
  {
    AppMethodBeat.i(368486);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(368486);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dh
 * JD-Core Version:    0.7.0.1
 */