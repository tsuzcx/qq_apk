package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  public int gmH = -1;
  public long gmi;
  public long gmj;
  public long gmk;
  public int gml;
  public int gmm;
  public int gmn;
  public int gmo;
  public long gmp;
  public long gmq;
  public long gmr;
  private String gms = "";
  private String gmt = "";
  public int gmu;
  
  public final String agH()
  {
    AppMethodBeat.i(198261);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gml);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gms);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmH);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(198261);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(198276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResultCode:").append(this.gmi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AliveType:").append(this.gmj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalState:").append(this.gmk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PrepareCgiErrorCode:").append(this.gml);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigCgiErrorCode:").append(this.gmm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnErrorCode:").append(this.gmn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VerifyCgiErrorCode:").append(this.gmo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnCost:").append(this.gmp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivenessCost:").append(this.gmq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetCount:").append(this.gmr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StateRecord:").append(this.gms);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AndroidStateRecord:").append(this.gmt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceReset:").append(this.gmu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorType:").append(this.gmH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(198276);
    return localObject;
  }
  
  public final int getId()
  {
    return 21131;
  }
  
  public final bj jP(String paramString)
  {
    AppMethodBeat.i(198245);
    this.gms = z("StateRecord", paramString, true);
    AppMethodBeat.o(198245);
    return this;
  }
  
  public final bj jQ(String paramString)
  {
    AppMethodBeat.i(198248);
    this.gmt = z("AndroidStateRecord", paramString, true);
    AppMethodBeat.o(198248);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bj
 * JD-Core Version:    0.7.0.1
 */