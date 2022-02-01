package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  public String dFJ = "";
  public long dKc = 0L;
  public String dQK = "";
  public String ejj = "";
  public long ejk = 0L;
  public String ejl = "";
  public long ejm = 0L;
  public String ejn = "";
  public long ejo = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.ejl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.ejn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.ejo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116497);
    return localObject;
  }
  
  public final int getId()
  {
    return 16033;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gx
 * JD-Core Version:    0.7.0.1
 */