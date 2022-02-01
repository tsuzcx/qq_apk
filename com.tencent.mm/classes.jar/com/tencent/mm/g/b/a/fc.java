package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  private long dHy = 0L;
  private long dUP = 0L;
  private String dWG = "";
  private String dWH = "";
  private long dWh = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWH);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.dWG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.dWH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long Rw()
  {
    return this.dHy;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final fc jN(long paramLong)
  {
    this.dUP = paramLong;
    return this;
  }
  
  public final fc jO(long paramLong)
  {
    this.dWh = paramLong;
    return this;
  }
  
  public final fc jP(long paramLong)
  {
    this.dHy = paramLong;
    return this;
  }
  
  public final fc mG(String paramString)
  {
    AppMethodBeat.i(118512);
    this.dWG = t("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final fc mH(String paramString)
  {
    AppMethodBeat.i(118513);
    this.dWH = t("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fc
 * JD-Core Version:    0.7.0.1
 */