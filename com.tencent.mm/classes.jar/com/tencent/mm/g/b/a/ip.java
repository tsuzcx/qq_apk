package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ip
  extends a
{
  public String dDw = "";
  public long dHR = 0L;
  public String dSz = "";
  public String eln = "";
  public long elo = 0L;
  public String elp = "";
  public long elq = 0L;
  public String elr = "";
  public long els = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.elo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.elp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.elq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.elr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.els);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ip
 * JD-Core Version:    0.7.0.1
 */