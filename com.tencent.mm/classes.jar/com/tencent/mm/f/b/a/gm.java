package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  private String gCE = "";
  private int gCP = 0;
  private long gCQ = 0L;
  private long gCR = 0L;
  private long gCS = 0L;
  private int gCT = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(217960);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217960);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217963);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartType:").append(this.gCP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessTime:").append(this.gCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BusinessTime:").append(this.gCR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllTime:").append(this.gCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendStr:").append(this.gCE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartReason:").append(this.gCT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217963);
    return localObject;
  }
  
  public final int akS()
  {
    return this.gCP;
  }
  
  public final long akT()
  {
    return this.gCQ;
  }
  
  public final long akU()
  {
    return this.gCR;
  }
  
  public final long akV()
  {
    return this.gCS;
  }
  
  public final int getId()
  {
    return 22023;
  }
  
  public final gm mT(int paramInt)
  {
    this.gCP = paramInt;
    return this;
  }
  
  public final gm mU(int paramInt)
  {
    this.gCT = paramInt;
    return this;
  }
  
  public final gm ph(long paramLong)
  {
    this.gCQ = paramLong;
    return this;
  }
  
  public final gm pi(long paramLong)
  {
    this.gCR = paramLong;
    return this;
  }
  
  public final gm pj(long paramLong)
  {
    this.gCS = paramLong;
    return this;
  }
  
  public final gm vy(String paramString)
  {
    AppMethodBeat.i(217954);
    this.gCE = z("ExtendStr", paramString, true);
    AppMethodBeat.o(217954);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gm
 * JD-Core Version:    0.7.0.1
 */