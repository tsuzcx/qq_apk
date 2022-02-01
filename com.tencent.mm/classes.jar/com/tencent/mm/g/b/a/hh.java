package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  private String dHr;
  private long dKV;
  private long dWC;
  private long gtD;
  private long gvJ;
  private long gvK;
  private String gvk;
  private long gwn;
  private long gzd;
  private long gze;
  
  public final hh Ie()
  {
    this.gvK = 1L;
    return this;
  }
  
  public final hh If()
  {
    this.gwn = 1L;
    return this;
  }
  
  public final hh NJ(String paramString)
  {
    AppMethodBeat.i(203683);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203683);
    return this;
  }
  
  public final hh NS()
  {
    this.gzd = 1L;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(203685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gze);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203685);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.gtD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.gvk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.gvJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.gvK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.gwn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.gzd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dKV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.gze);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203686);
    return localObject;
  }
  
  public final hh Qb()
  {
    this.dKV = 1L;
    return this;
  }
  
  public final hh Qg(String paramString)
  {
    AppMethodBeat.i(203684);
    this.gvk = t("FailReasonWording", paramString, true);
    AppMethodBeat.o(203684);
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final hh uD()
  {
    this.gvJ = 1L;
    return this;
  }
  
  public final hh xX(long paramLong)
  {
    this.dWC = paramLong;
    return this;
  }
  
  public final hh xY(long paramLong)
  {
    this.gtD = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hh
 * JD-Core Version:    0.7.0.1
 */