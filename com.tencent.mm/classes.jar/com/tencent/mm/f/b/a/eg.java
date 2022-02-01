package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eg
  extends a
{
  private String gcU = "";
  private String gjm = "";
  private long gmP;
  private long gmT;
  private String goZ = "";
  private String gpa = "";
  private long gpb;
  private long gpc;
  
  public final String agH()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.goZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.gpa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.gpb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.gpc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final eg lm(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final eg ln(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final eg rS(String paramString)
  {
    AppMethodBeat.i(168908);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final eg rT(String paramString)
  {
    AppMethodBeat.i(168909);
    this.goZ = z("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final eg rU(String paramString)
  {
    AppMethodBeat.i(168910);
    this.gpa = z("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final eg rV(String paramString)
  {
    AppMethodBeat.i(168911);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eg
 * JD-Core Version:    0.7.0.1
 */