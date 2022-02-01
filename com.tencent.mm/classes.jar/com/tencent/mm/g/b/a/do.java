package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  private long dJw = 0L;
  private long dTd = 0L;
  private String dUU = "";
  private String dUV = "";
  private long dUv = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.dUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.dUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.dUV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long QU()
  {
    return this.dJw;
  }
  
  public final do gA(long paramLong)
  {
    this.dTd = paramLong;
    return this;
  }
  
  public final do gB(long paramLong)
  {
    this.dUv = paramLong;
    return this;
  }
  
  public final do gC(long paramLong)
  {
    this.dJw = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final do jQ(String paramString)
  {
    AppMethodBeat.i(118512);
    this.dUU = t("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final do jR(String paramString)
  {
    AppMethodBeat.i(118513);
    this.dUV = t("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.do
 * JD-Core Version:    0.7.0.1
 */