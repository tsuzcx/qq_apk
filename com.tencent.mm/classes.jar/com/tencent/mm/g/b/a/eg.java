package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eg
  extends a
{
  private long eCD;
  private String eiB = "";
  private long ers;
  private long ert;
  private long eru;
  private String erv = "";
  private long erw;
  private String esS = "";
  private String esT = "";
  private long esU;
  private long esV;
  private String euI = "";
  
  public final String abV()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ert);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.erv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.eCD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.esS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.esU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.esV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.ert);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.eru);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final eg lK(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final eg lL(long paramLong)
  {
    this.eCD = paramLong;
    return this;
  }
  
  public final eg lM(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final eg lN(long paramLong)
  {
    this.ert = paramLong;
    return this;
  }
  
  public final eg lO(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final eg qM(String paramString)
  {
    AppMethodBeat.i(168914);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final eg qN(String paramString)
  {
    AppMethodBeat.i(168915);
    this.erv = x("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final eg qO(String paramString)
  {
    AppMethodBeat.i(168916);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final eg qP(String paramString)
  {
    AppMethodBeat.i(168917);
    this.esS = x("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final eg qQ(String paramString)
  {
    AppMethodBeat.i(168918);
    this.esT = x("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eg
 * JD-Core Version:    0.7.0.1
 */