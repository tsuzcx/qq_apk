package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dz
  extends a
{
  private String gcU = "";
  private String gmO = "";
  private String gvL = "";
  private String gvM = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210402);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210402);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210404);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.gvL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.gvM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210404);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
  
  public final dz rj(String paramString)
  {
    AppMethodBeat.i(210395);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(210395);
    return this;
  }
  
  public final dz rk(String paramString)
  {
    AppMethodBeat.i(210397);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(210397);
    return this;
  }
  
  public final dz rl(String paramString)
  {
    AppMethodBeat.i(210398);
    this.gvL = z("PostUsername", paramString, true);
    AppMethodBeat.o(210398);
    return this;
  }
  
  public final dz rm(String paramString)
  {
    AppMethodBeat.i(210399);
    this.gvM = z("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(210399);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dz
 * JD-Core Version:    0.7.0.1
 */