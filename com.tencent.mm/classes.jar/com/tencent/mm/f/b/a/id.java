package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class id
  extends a
{
  private String gHT = "";
  private long gHV;
  private String gjj = "";
  private long glS;
  private long gpj;
  private String gru = "";
  
  public final String agH()
  {
    AppMethodBeat.i(248634);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(248634);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(248636);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ItemId:").append(this.gru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.glS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddType:").append(this.gHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.gpj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.gHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(248636);
    return localObject;
  }
  
  public final int getId()
  {
    return 21935;
  }
  
  public final id sx(long paramLong)
  {
    this.glS = paramLong;
    return this;
  }
  
  public final id sy(long paramLong)
  {
    this.gHV = paramLong;
    return this;
  }
  
  public final id sz(long paramLong)
  {
    this.gpj = paramLong;
    return this;
  }
  
  public final id xI(String paramString)
  {
    AppMethodBeat.i(248626);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(248626);
    return this;
  }
  
  public final id xJ(String paramString)
  {
    AppMethodBeat.i(248630);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(248630);
    return this;
  }
  
  public final id xK(String paramString)
  {
    AppMethodBeat.i(248632);
    this.gHT = z("ItemSubId", paramString, true);
    AppMethodBeat.o(248632);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.id
 * JD-Core Version:    0.7.0.1
 */