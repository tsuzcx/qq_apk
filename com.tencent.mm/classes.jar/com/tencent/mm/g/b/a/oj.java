package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oj
  extends a
{
  private long eDm;
  private long erw;
  private String oll = "";
  private String olm = "";
  private String opY = "";
  private int opZ;
  private int oqa;
  private int oqb;
  private long oqc;
  private long oqd;
  private long oqf;
  
  public final oj Qm(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final oj Qn(long paramLong)
  {
    this.eDm = paramLong;
    return this;
  }
  
  public final oj Qo(long paramLong)
  {
    this.oqc = paramLong;
    return this;
  }
  
  public final oj Qp(long paramLong)
  {
    this.oqd = paramLong;
    return this;
  }
  
  public final oj Qq(long paramLong)
  {
    this.oqf = paramLong;
    return this;
  }
  
  public final oj SM(int paramInt)
  {
    this.oqa = paramInt;
    return this;
  }
  
  public final oj SR(int paramInt)
  {
    this.oqb = paramInt;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oll);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258824);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.opY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.oll);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.olm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvIndex:").append(this.opZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChanged:").append(this.oqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLocal:").append(this.oqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.eDm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitCount:").append(this.oqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrType:").append(this.oqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrCode:").append(this.oqf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258825);
    return localObject;
  }
  
  public final oj bwq(String paramString)
  {
    AppMethodBeat.i(258821);
    this.opY = x("contextId", paramString, true);
    AppMethodBeat.o(258821);
    return this;
  }
  
  public final oj bwr(String paramString)
  {
    AppMethodBeat.i(258822);
    this.oll = x("mvObjectId", paramString, true);
    AppMethodBeat.o(258822);
    return this;
  }
  
  public final oj bws(String paramString)
  {
    AppMethodBeat.i(258823);
    this.olm = x("mvNonceId", paramString, true);
    AppMethodBeat.o(258823);
    return this;
  }
  
  public final int getId()
  {
    return 22278;
  }
  
  public final oj zY(int paramInt)
  {
    this.opZ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oj
 * JD-Core Version:    0.7.0.1
 */