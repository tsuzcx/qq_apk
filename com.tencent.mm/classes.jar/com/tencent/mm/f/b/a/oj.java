package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oj
  extends a
{
  private String gcU = "";
  private int ggl;
  private String gjj = "";
  private String gmO = "";
  private long hbA;
  private long hbB;
  private int hbC = -1;
  private long hbD;
  private int hbE;
  private long hbr;
  private String hbt = "";
  private String hbu = "";
  private String hby = "";
  private int hbz;
  
  public final oj AM(long paramLong)
  {
    this.hbA = paramLong;
    return this;
  }
  
  public final oj AN(long paramLong)
  {
    this.hbB = paramLong;
    return this;
  }
  
  public final oj AO(long paramLong)
  {
    AppMethodBeat.i(257017);
    this.hbr = paramLong;
    super.bk("UpdataTimeMs", this.hbr);
    AppMethodBeat.o(257017);
    return this;
  }
  
  public final oj AP(long paramLong)
  {
    AppMethodBeat.i(257020);
    this.hbD = paramLong;
    super.bk("ItemExposureTimeMs", this.hbD);
    AppMethodBeat.o(257020);
    return this;
  }
  
  public final oj Fo(String paramString)
  {
    AppMethodBeat.i(256992);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(256992);
    return this;
  }
  
  public final oj Fp(String paramString)
  {
    AppMethodBeat.i(256995);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(256995);
    return this;
  }
  
  public final oj Fq(String paramString)
  {
    AppMethodBeat.i(257005);
    this.hbt = z("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(257005);
    return this;
  }
  
  public final oj Fr(String paramString)
  {
    AppMethodBeat.i(257008);
    this.hbu = z("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(257008);
    return this;
  }
  
  public final oj Fs(String paramString)
  {
    AppMethodBeat.i(257012);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(257012);
    return this;
  }
  
  public final oj Ft(String paramString)
  {
    AppMethodBeat.i(257025);
    this.hby = z("ItemBufffer", paramString, true);
    AppMethodBeat.o(257025);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(257028);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hby);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(257028);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(257029);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.hbA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.hbB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.hbC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.hbt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.hbu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.hbr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.hbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.hbE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.hby);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.hbz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(257029);
    return localObject;
  }
  
  public final String agX()
  {
    return this.gjj;
  }
  
  public final String ahZ()
  {
    return this.gmO;
  }
  
  public final long aoh()
  {
    return this.hbr;
  }
  
  public final String aoj()
  {
    return this.hbt;
  }
  
  public final String aok()
  {
    return this.hbu;
  }
  
  public final String aoo()
  {
    return this.hby;
  }
  
  public final int aop()
  {
    return this.hbz;
  }
  
  public final long aoq()
  {
    return this.hbA;
  }
  
  public final long aor()
  {
    return this.hbB;
  }
  
  public final int aos()
  {
    return this.hbC;
  }
  
  public final long aot()
  {
    return this.hbD;
  }
  
  public final int aou()
  {
    return this.hbE;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.ggl;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final oj oi(int paramInt)
  {
    this.hbC = paramInt;
    return this;
  }
  
  public final oj oj(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final oj ok(int paramInt)
  {
    this.hbE = paramInt;
    return this;
  }
  
  public final oj ol(int paramInt)
  {
    this.hbz = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oj
 * JD-Core Version:    0.7.0.1
 */