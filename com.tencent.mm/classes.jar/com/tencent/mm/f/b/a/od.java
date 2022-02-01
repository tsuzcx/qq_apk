package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class od
  extends a
{
  public long giq = 0L;
  public long gqh = 0L;
  public long haV = 0L;
  private String haW = "";
  public long haX = 0L;
  private String haY = "";
  public long haZ;
  public long hba;
  private String hbb = "";
  
  public final od ES(String paramString)
  {
    AppMethodBeat.i(212147);
    this.haW = z("ResultQuery", paramString, true);
    AppMethodBeat.o(212147);
    return this;
  }
  
  public final od ET(String paramString)
  {
    AppMethodBeat.i(212150);
    this.haY = z("ShareSceneId", paramString, true);
    AppMethodBeat.o(212150);
    return this;
  }
  
  public final od EU(String paramString)
  {
    AppMethodBeat.i(212152);
    this.hbb = z("SearchSessionId", paramString, true);
    AppMethodBeat.o(212152);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(212154);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hba);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212154);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultType:").append(this.haV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultQuery:").append(this.haW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareScene:").append(this.haX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSceneId:").append(this.haY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateTime:").append(this.haZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineEnterSource:").append(this.hba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchSessionId:").append(this.hbb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212158);
    return localObject;
  }
  
  public final int getId()
  {
    return 20998;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.od
 * JD-Core Version:    0.7.0.1
 */