package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  private String eiB = "";
  private long ers;
  private long erw;
  private String esS = "";
  private String esT = "";
  private long esU;
  private long esV;
  private String euI = "";
  
  public final String abV()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.esS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.esU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.esV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final dn kk(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final dn kl(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final dn pg(String paramString)
  {
    AppMethodBeat.i(168908);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final dn ph(String paramString)
  {
    AppMethodBeat.i(168909);
    this.esS = x("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final dn pi(String paramString)
  {
    AppMethodBeat.i(168910);
    this.esT = x("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final dn pj(String paramString)
  {
    AppMethodBeat.i(168911);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dn
 * JD-Core Version:    0.7.0.1
 */