package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pl
  extends a
{
  public long gYL = 0L;
  public long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  public long gnP = 0L;
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  private String hdA = "";
  private long hen = 0L;
  public long heu = 0L;
  public long hew = 0L;
  public long hex = 0L;
  public pl.a hfp;
  private String hfq = "";
  private String hfr = "";
  
  public final pl Cq(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final pl Cr(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final pl Cs(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final pl Gv(String paramString)
  {
    AppMethodBeat.i(43622);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final pl Gw(String paramString)
  {
    AppMethodBeat.i(43623);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final pl Gx(String paramString)
  {
    AppMethodBeat.i(43627);
    this.hfq = z("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final pl Gy(String paramString)
  {
    AppMethodBeat.i(43628);
    this.hdA = z("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public final pl Gz(String paramString)
  {
    AppMethodBeat.i(249734);
    this.hfr = z("lazyLoadKey", paramString, true);
    AppMethodBeat.o(249734);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hfp != null) {}
    for (int i = this.hfp.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hen);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hex);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hew);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfr);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hfp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("package:").append(this.hfq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.heu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.hen);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.hex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.hew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.hdA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lazyLoadKey:").append(this.hfr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pl
 * JD-Core Version:    0.7.0.1
 */