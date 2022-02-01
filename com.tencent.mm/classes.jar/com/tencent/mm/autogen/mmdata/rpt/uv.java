package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uv
  extends a
{
  public long iSo;
  public long iuA;
  private String iuI = "";
  public long iwe;
  public long jIb;
  private long jIc;
  private long jId;
  private String jIe = "";
  public long jIf;
  public long jbj;
  public long jbk;
  private String jbv = "";
  private String jcm = "";
  private long jiX;
  public long jxf;
  
  public final uv Av(String paramString)
  {
    AppMethodBeat.i(368482);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(368482);
    return this;
  }
  
  public final uv Aw(String paramString)
  {
    AppMethodBeat.i(368484);
    this.jcm = F("searchKeyword", paramString, true);
    AppMethodBeat.o(368484);
    return this;
  }
  
  public final uv Ax(String paramString)
  {
    AppMethodBeat.i(368502);
    this.jbv = F("toUserName", paramString, true);
    AppMethodBeat.o(368502);
    return this;
  }
  
  public final uv Ay(String paramString)
  {
    AppMethodBeat.i(368507);
    this.jIe = F("session_ID", paramString, true);
    AppMethodBeat.o(368507);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368511);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368516);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.jiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.iwe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exposure_pos:").append(this.jIb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.iSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchKeyword:").append(this.jcm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewTimeMs:").append(this.jIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chooseTimeMs:").append(this.jId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_individual:").append(this.jbk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUserName:").append(this.jbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session_ID:").append(this.jIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("setType:").append(this.jIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("channel:").append(this.jxf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_vibrate:").append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368516);
    return localObject;
  }
  
  public final uv gK(long paramLong)
  {
    AppMethodBeat.i(368490);
    this.jIc = paramLong;
    super.bw("previewTimeMs", this.jIc);
    AppMethodBeat.o(368490);
    return this;
  }
  
  public final uv gL(long paramLong)
  {
    AppMethodBeat.i(368495);
    this.jId = paramLong;
    super.bw("chooseTimeMs", this.jId);
    AppMethodBeat.o(368495);
    return this;
  }
  
  public final int getId()
  {
    return 23604;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uv
 * JD-Core Version:    0.7.0.1
 */