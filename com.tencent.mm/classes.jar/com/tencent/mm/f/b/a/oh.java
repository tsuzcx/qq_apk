package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oh
  extends a
{
  public String gZU = "";
  public String gcU = "";
  public long giq;
  public String git = "";
  public long gpu;
  public String hbo = "";
  public long hbp;
  public long hbq;
  
  public final String agH()
  {
    AppMethodBeat.i(212164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212164);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212167);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.hbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.gZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentType:").append(this.hbp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeStamp:").append(this.hbq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212167);
    return localObject;
  }
  
  public final int getId()
  {
    return 21174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oh
 * JD-Core Version:    0.7.0.1
 */