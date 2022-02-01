package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fu
  extends a
{
  private long gBI;
  private long gBK;
  private String gBL = "";
  private int gBM;
  private long gef;
  private String ggg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(288740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(288740);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(288741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivesCnt:").append(this.gBK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionToLiveId:").append(this.gBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.gBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsReddotShining:").append(this.gBM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(288741);
    return localObject;
  }
  
  public final int getId()
  {
    return 21876;
  }
  
  public final fu mz(int paramInt)
  {
    this.gBM = paramInt;
    return this;
  }
  
  public final fu oM(long paramLong)
  {
    this.gBK = paramLong;
    return this;
  }
  
  public final fu oN(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final fu oO(long paramLong)
  {
    this.gBI = paramLong;
    return this;
  }
  
  public final fu vj(String paramString)
  {
    AppMethodBeat.i(288734);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(288734);
    return this;
  }
  
  public final fu vk(String paramString)
  {
    AppMethodBeat.i(288737);
    this.gBL = z("ActionToLiveId", paramString, true);
    AppMethodBeat.o(288737);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fu
 * JD-Core Version:    0.7.0.1
 */