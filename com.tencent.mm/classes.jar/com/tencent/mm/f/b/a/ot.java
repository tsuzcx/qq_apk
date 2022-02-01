package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ot
  extends a
{
  public long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  public long gnP = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  public ot.a hdb;
  public long hdc = 0L;
  
  public final ot Bj(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final ot Bk(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final ot FM(String paramString)
  {
    AppMethodBeat.i(43504);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final ot FN(String paramString)
  {
    AppMethodBeat.i(43505);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    if (this.hdb != null) {}
    for (int i = this.hdb.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.hdc);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hdb);
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
    ((StringBuffer)localObject).append("IsPreload:").append(this.hdc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final ot aoD()
  {
    AppMethodBeat.i(43508);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ot
 * JD-Core Version:    0.7.0.1
 */