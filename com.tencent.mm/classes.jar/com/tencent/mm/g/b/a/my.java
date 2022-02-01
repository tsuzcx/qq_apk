package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class my
  extends a
{
  private long eJb;
  private String eJx = "";
  private long eYW;
  private String eoK = "";
  private long erW;
  private long fac;
  private long fad;
  private long fae;
  private int ffH;
  
  public final my Ag(String paramString)
  {
    AppMethodBeat.i(43724);
    this.eoK = x("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final my Ah(String paramString)
  {
    AppMethodBeat.i(43725);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fad);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ffH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.ffH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final my mK(int paramInt)
  {
    this.ffH = paramInt;
    return this;
  }
  
  public final my xo(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final my xp(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final my xq(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final my xr(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final my xs(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final my xt(long paramLong)
  {
    this.eJb = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.my
 * JD-Core Version:    0.7.0.1
 */