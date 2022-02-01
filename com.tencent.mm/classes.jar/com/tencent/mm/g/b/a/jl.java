package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jl
  extends a
{
  private long eIT = 0L;
  private long eRA = 0L;
  private long eRB = 0L;
  private long eRC = 0L;
  private long eRD = 0L;
  private long eRt = 0L;
  private int eRu = 0;
  private long eRv = 0L;
  private long eRw = 0L;
  private long eRx = 0L;
  private long eRy = 0L;
  private long eRz = 0L;
  private long eoU = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118498);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eIT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118498);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118499);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ImageCount:").append(this.eIT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxCostTime:").append(this.eRt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxSucc:").append(this.eRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.eoU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BitRateMode:").append(this.eRv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Fps:").append(this.eRw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BitRate:").append(this.eRx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IFrameInterval:").append(this.eRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContainMusic:").append(this.eRz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputWidth:").append(this.eRA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputHeight:").append(this.eRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SupportCQ:").append(this.eRC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useX264:").append(this.eRD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118499);
    return localObject;
  }
  
  public final int getId()
  {
    return 17653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jl
 * JD-Core Version:    0.7.0.1
 */