package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jw
  extends a
{
  public String dRJ = "";
  public long dWm = 0L;
  public String eDY = "";
  public long eDZ = 0L;
  public String eEa = "";
  public long eEb = 0L;
  public String eEc = "";
  public long eEd = 0L;
  public String ejP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEd);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.eDZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.eEa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.eEb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.eEc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.eEd);
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
 * Qualified Name:     com.tencent.mm.g.b.a.jw
 * JD-Core Version:    0.7.0.1
 */