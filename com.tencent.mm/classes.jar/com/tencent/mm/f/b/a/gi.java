package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  private long gCA;
  private int gCB;
  private long gCu;
  private long gCv;
  private long gCw;
  private long gCx;
  private long gCy;
  private long gCz;
  
  public final String agH()
  {
    AppMethodBeat.i(214895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214895);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214899);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PressTime:").append(this.gCu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EngineProcessTime:").append(this.gCv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NotifyToUIThreadTime:").append(this.gCw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetCandidateTime:").append(this.gCx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIUpdataTime:").append(this.gCy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyboardType:").append(this.gCz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationType:").append(this.gCA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyType:").append(this.gCB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214899);
    return localObject;
  }
  
  public final int getId()
  {
    return 22355;
  }
  
  public final gi mM(int paramInt)
  {
    this.gCB = paramInt;
    return this;
  }
  
  public final gi oS(long paramLong)
  {
    this.gCu = paramLong;
    return this;
  }
  
  public final gi oT(long paramLong)
  {
    this.gCv = paramLong;
    return this;
  }
  
  public final gi oU(long paramLong)
  {
    this.gCw = paramLong;
    return this;
  }
  
  public final gi oV(long paramLong)
  {
    this.gCx = paramLong;
    return this;
  }
  
  public final gi oW(long paramLong)
  {
    this.gCy = paramLong;
    return this;
  }
  
  public final gi oX(long paramLong)
  {
    this.gCz = paramLong;
    return this;
  }
  
  public final gi oY(long paramLong)
  {
    this.gCA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gi
 * JD-Core Version:    0.7.0.1
 */