package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ju
  extends a
{
  public String dQt = "";
  public long dUW = 0L;
  public String eCp = "";
  public long eCq = 0L;
  public String eCr = "";
  public long eCs = 0L;
  public String eCt = "";
  public long eCu = 0L;
  public String eif = "";
  
  public final String RD()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCu);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eCp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.eCq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.eCr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.eCs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.eCt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.eCu);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ju
 * JD-Core Version:    0.7.0.1
 */