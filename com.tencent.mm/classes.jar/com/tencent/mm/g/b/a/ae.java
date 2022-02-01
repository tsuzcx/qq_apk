package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  private long dFQ;
  private String dFe;
  private String dIA;
  private long dIB;
  private long dIC;
  private long dID;
  private long dIE;
  private long dIF;
  private long dIy;
  private long dIz;
  
  public final String PR()
  {
    AppMethodBeat.i(194901);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIF);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194901);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194902);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dIy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.dIz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.dIA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.dIB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.dIC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.dID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.dIE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dFQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.dIF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194902);
    return localObject;
  }
  
  public final ae PX()
  {
    this.dIB = 1L;
    return this;
  }
  
  public final ae PY()
  {
    this.dIC = 1L;
    return this;
  }
  
  public final ae PZ()
  {
    this.dID = 1L;
    return this;
  }
  
  public final ae Qa()
  {
    this.dIE = 1L;
    return this;
  }
  
  public final ae Qb()
  {
    this.dFQ = 1L;
    return this;
  }
  
  public final ae cJ(long paramLong)
  {
    this.dIy = paramLong;
    return this;
  }
  
  public final ae cK(long paramLong)
  {
    this.dIz = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final ae gw(String paramString)
  {
    AppMethodBeat.i(194899);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194899);
    return this;
  }
  
  public final ae gx(String paramString)
  {
    AppMethodBeat.i(194900);
    this.dIA = t("FailReasonWording", paramString, true);
    AppMethodBeat.o(194900);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */