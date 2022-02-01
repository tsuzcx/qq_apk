package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  private long dFd = 0L;
  private String dJt;
  private String dJv;
  private long dNI = 0L;
  private long dNO = 0L;
  private String dQa;
  private String dQb;
  private long dQc = 0L;
  private long dQd = 0L;
  private long dQe = 0L;
  private long dQf = 0L;
  private String dQg;
  private String dQh;
  private String dQi;
  
  public final String JS()
  {
    return this.dJv;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dNO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.dQa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.dQb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dJt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.dQd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.dQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.dQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.dQg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.dQh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.dQi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final String Qu()
  {
    return this.dJt;
  }
  
  public final bu Qv()
  {
    this.dQd = 4L;
    return this;
  }
  
  public final String Qw()
  {
    return this.dQg;
  }
  
  public final String Qx()
  {
    return this.dQh;
  }
  
  public final String Qy()
  {
    return this.dQi;
  }
  
  public final bu eV(long paramLong)
  {
    this.dNO = paramLong;
    return this;
  }
  
  public final bu eW(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final bu eX(long paramLong)
  {
    this.dQc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final bu iq(String paramString)
  {
    AppMethodBeat.i(104424);
    this.dQa = t("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final bu ir(String paramString)
  {
    AppMethodBeat.i(104425);
    this.dQb = t("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final bu is(String paramString)
  {
    AppMethodBeat.i(104426);
    this.dJt = t("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final bu it(String paramString)
  {
    AppMethodBeat.i(104427);
    this.dJv = t("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final bu iu(String paramString)
  {
    AppMethodBeat.i(104428);
    this.dQg = t("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final bu iv(String paramString)
  {
    AppMethodBeat.i(104429);
    this.dQh = t("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final bu iw(String paramString)
  {
    AppMethodBeat.i(104430);
    this.dQi = t("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */