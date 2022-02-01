package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class og
  extends a
{
  public long gDb = 0L;
  private String gZU = "";
  private String gcU = "";
  public long giq = 0L;
  public long gpu = 0L;
  public long hbm = 0L;
  public long hbn = 0L;
  private String hbo = "";
  
  public final og AG(long paramLong)
  {
    this.hbm = paramLong;
    return this;
  }
  
  public final og AH(long paramLong)
  {
    this.hbn = paramLong;
    return this;
  }
  
  public final og AI(long paramLong)
  {
    this.gDb = paramLong;
    return this;
  }
  
  public final og AJ(long paramLong)
  {
    this.gpu = paramLong;
    return this;
  }
  
  public final og Fe(String paramString)
  {
    AppMethodBeat.i(211802);
    this.hbo = z("EnterSceneId", paramString, true);
    AppMethodBeat.o(211802);
    return this;
  }
  
  public final og Ff(String paramString)
  {
    AppMethodBeat.i(211804);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(211804);
    return this;
  }
  
  public final og Fg(String paramString)
  {
    AppMethodBeat.i(211806);
    this.gZU = z("QueryKey", paramString, true);
    AppMethodBeat.o(211806);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(211808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211808);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DismissType:").append(this.hbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionSourceType:").append(this.hbn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.gDb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.hbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.gZU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211809);
    return localObject;
  }
  
  public final og aof()
  {
    this.giq = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 20996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.og
 * JD-Core Version:    0.7.0.1
 */