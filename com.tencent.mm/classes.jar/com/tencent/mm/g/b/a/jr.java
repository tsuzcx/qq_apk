package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jr
  extends a
{
  private long eQv = 0L;
  private long eRK = 0L;
  private String eSj = "";
  private String eSk = "";
  private long eqk = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSk);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.eQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.eRK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.eSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.eSk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long ahy()
  {
    return this.eqk;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final jr sM(long paramLong)
  {
    this.eQv = paramLong;
    return this;
  }
  
  public final jr sN(long paramLong)
  {
    this.eRK = paramLong;
    return this;
  }
  
  public final jr sO(long paramLong)
  {
    this.eqk = paramLong;
    return this;
  }
  
  public final jr wX(String paramString)
  {
    AppMethodBeat.i(118512);
    this.eSj = x("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final jr wY(String paramString)
  {
    AppMethodBeat.i(118513);
    this.eSk = x("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jr
 * JD-Core Version:    0.7.0.1
 */