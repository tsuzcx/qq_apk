package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  private String dFe;
  private String dIp;
  private String dIq;
  private long dIr;
  private long dIs;
  private long dKd;
  private long dKe;
  private String dKg;
  
  public final String PR()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.dKd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.dKg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final bi fx(long paramLong)
  {
    this.dKd = paramLong;
    return this;
  }
  
  public final bi fy(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final bi fz(long paramLong)
  {
    this.dIs = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final bi jh(String paramString)
  {
    AppMethodBeat.i(168921);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final bi ji(String paramString)
  {
    AppMethodBeat.i(168922);
    this.dIp = t("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final bi jj(String paramString)
  {
    AppMethodBeat.i(168923);
    this.dIq = t("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final bi jk(String paramString)
  {
    AppMethodBeat.i(168924);
    this.dKg = t("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */