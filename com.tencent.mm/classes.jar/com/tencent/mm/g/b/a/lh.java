package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lh
  extends a
{
  public long eYp = 0L;
  public String eYq = "";
  public long eYr = 0L;
  public String eYs = "";
  public long eYt;
  public long eYu;
  public String eYv = "";
  public long enl = 0L;
  public long eua = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187802);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187802);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187803);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultType:").append(this.eYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultQuery:").append(this.eYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareScene:").append(this.eYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSceneId:").append(this.eYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateTime:").append(this.eYt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineEnterSource:").append(this.eYu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchSessionId:").append(this.eYv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187803);
    return localObject;
  }
  
  public final int getId()
  {
    return 20998;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lh
 * JD-Core Version:    0.7.0.1
 */