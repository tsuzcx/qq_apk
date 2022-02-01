package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qv
  extends a
{
  public String ggA = "";
  public long gmT = 0L;
  public String gym = "";
  public String hlH = "";
  public long hlI = 0L;
  public String hlJ = "";
  public long hlK = 0L;
  public String hlL = "";
  public long hlM = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gym);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.hlH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.hlI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.hlJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.hlK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.hlL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.gym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.hlM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116497);
    return localObject;
  }
  
  public final int getId()
  {
    return 16033;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qv
 * JD-Core Version:    0.7.0.1
 */