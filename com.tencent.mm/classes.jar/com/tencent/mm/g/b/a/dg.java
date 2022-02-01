package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  private String dHr = "";
  private int dTP = 0;
  private int dTQ = 0;
  private int dTR = 0;
  private int dTS = 0;
  private String dTT = "";
  private int dTU = 0;
  private int dTV = 0;
  private String dTW = "";
  private long dTX = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.dTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.dTQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.dTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.dTS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.dTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.dTV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.dTW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int QN()
  {
    return this.dTP;
  }
  
  public final int QO()
  {
    return this.dTS;
  }
  
  public final int QP()
  {
    return this.dTV;
  }
  
  public final dg fR(long paramLong)
  {
    this.dTX = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final dg iA(int paramInt)
  {
    this.dTS = paramInt;
    return this;
  }
  
  public final dg iB(int paramInt)
  {
    this.dTU = paramInt;
    return this;
  }
  
  public final dg iC(int paramInt)
  {
    this.dTV = paramInt;
    return this;
  }
  
  public final dg ix(int paramInt)
  {
    this.dTP = paramInt;
    return this;
  }
  
  public final dg iy(int paramInt)
  {
    this.dTQ = paramInt;
    return this;
  }
  
  public final dg iz(int paramInt)
  {
    this.dTR = paramInt;
    return this;
  }
  
  public final dg jG(String paramString)
  {
    AppMethodBeat.i(118490);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final dg jH(String paramString)
  {
    AppMethodBeat.i(118491);
    this.dTT = t("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final dg jI(String paramString)
  {
    AppMethodBeat.i(118492);
    this.dTW = t("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dg
 * JD-Core Version:    0.7.0.1
 */