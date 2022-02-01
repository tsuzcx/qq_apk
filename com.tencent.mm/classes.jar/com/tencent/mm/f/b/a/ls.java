package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ls
  extends a
{
  private int gRC = 0;
  private int gRD = 0;
  private int gRE = 0;
  private int gRF = 0;
  private String gRG = "";
  private int gRH = 0;
  private int gRI = 0;
  private String gRJ = "";
  private long gRK = 0L;
  private String gcU = "";
  
  public final ls Co(String paramString)
  {
    AppMethodBeat.i(118490);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final ls Cp(String paramString)
  {
    AppMethodBeat.i(118491);
    this.gRG = z("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final ls Cq(String paramString)
  {
    AppMethodBeat.i(118492);
    this.gRJ = z("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRK);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.gRC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.gRD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.gRE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.gRF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.gRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.gRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.gRI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.gRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.gRK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int amN()
  {
    return this.gRC;
  }
  
  public final int amO()
  {
    return this.gRF;
  }
  
  public final int amP()
  {
    return this.gRI;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final ls nG(int paramInt)
  {
    this.gRC = paramInt;
    return this;
  }
  
  public final ls nH(int paramInt)
  {
    this.gRD = paramInt;
    return this;
  }
  
  public final ls nI(int paramInt)
  {
    this.gRE = paramInt;
    return this;
  }
  
  public final ls nJ(int paramInt)
  {
    this.gRF = paramInt;
    return this;
  }
  
  public final ls nK(int paramInt)
  {
    this.gRH = paramInt;
    return this;
  }
  
  public final ls nL(int paramInt)
  {
    this.gRI = paramInt;
    return this;
  }
  
  public final ls wf(long paramLong)
  {
    this.gRK = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ls
 * JD-Core Version:    0.7.0.1
 */