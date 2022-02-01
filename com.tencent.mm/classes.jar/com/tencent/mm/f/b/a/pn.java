package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pn
  extends a
{
  private long gYL = 0L;
  private long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  private long gnP = 0L;
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  private pn.a hfA;
  private long hfB = 0L;
  private long hfC = 0L;
  private String hfD = "";
  private long hfE = 0L;
  
  public final pn Ct(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pn Cu(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pn Cv(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pn Cw(long paramLong)
  {
    this.hfB = paramLong;
    return this;
  }
  
  public final pn Cx(long paramLong)
  {
    this.hfC = paramLong;
    return this;
  }
  
  public final pn Cy(long paramLong)
  {
    this.hfE = paramLong;
    return this;
  }
  
  public final pn GA(String paramString)
  {
    AppMethodBeat.i(43636);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final pn GB(String paramString)
  {
    AppMethodBeat.i(43637);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final pn GC(String paramString)
  {
    AppMethodBeat.i(43638);
    this.hfD = z("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
  
  public final pn a(pn.a parama)
  {
    this.hfA = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hfA != null) {}
    for (int i = this.hfA.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.hfB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfE);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hfA);
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
    ((StringBuffer)localObject).append("processNum:").append(this.hfB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.hfC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.hfD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.hfE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final int getId()
  {
    return 18032;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pn
 * JD-Core Version:    0.7.0.1
 */