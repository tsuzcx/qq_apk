package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  private long cVa = 0L;
  private long cVj = 0L;
  private String cWO = "";
  private String cWP = "";
  private long cWp = 0L;
  
  public final long FH()
  {
    return this.cVj;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(108875);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWP);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108875);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108876);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.cVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.cWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.cVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.cWO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.cWP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108876);
    return localObject;
  }
  
  public final bd df(long paramLong)
  {
    this.cVa = paramLong;
    return this;
  }
  
  public final bd dg(long paramLong)
  {
    this.cWp = paramLong;
    return this;
  }
  
  public final bd dh(long paramLong)
  {
    this.cVj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final bd gs(String paramString)
  {
    AppMethodBeat.i(108873);
    this.cWO = t("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(108873);
    return this;
  }
  
  public final bd gt(String paramString)
  {
    AppMethodBeat.i(108874);
    this.cWP = t("StoryTid", paramString, true);
    AppMethodBeat.o(108874);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bd
 * JD-Core Version:    0.7.0.1
 */