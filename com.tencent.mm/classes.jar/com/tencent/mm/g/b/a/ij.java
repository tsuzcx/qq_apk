package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ij
  extends a
{
  private long dFf;
  private String dQr;
  private long mas;
  private long mat;
  private long mbj;
  private long oOQ = 0L;
  private long oOR;
  private long oOS;
  private String oOT;
  
  public final ij AA(long paramLong)
  {
    this.oOR = paramLong;
    return this;
  }
  
  public final ij AB(long paramLong)
  {
    this.oOS = paramLong;
    return this;
  }
  
  public final ij Aw(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ij Ax(long paramLong)
  {
    this.mbj = paramLong;
    return this;
  }
  
  public final ij Ay(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final ij Az(long paramLong)
  {
    this.dFf = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202467);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOT);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202467);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202468);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.oOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.mbj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.oOR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.oOS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.oOT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202468);
    return localObject;
  }
  
  public final ij aTj(String paramString)
  {
    AppMethodBeat.i(202465);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202465);
    return this;
  }
  
  public final ij aTk(String paramString)
  {
    AppMethodBeat.i(202466);
    this.oOT = t("audienceUserName", paramString, true);
    AppMethodBeat.o(202466);
    return this;
  }
  
  public final int getId()
  {
    return 19893;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ij
 * JD-Core Version:    0.7.0.1
 */