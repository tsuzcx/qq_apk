package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nu
  extends a
{
  public String eBQ = "";
  public String els = "";
  public long erw = 0L;
  public long fiA = 0L;
  public String fiB = "";
  public long fiC = 0L;
  public String fix = "";
  public long fiy = 0L;
  public String fiz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiC);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.fix);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.fiy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.fiz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.fiA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.fiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.fiC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116497);
    return localObject;
  }
  
  public final int getId()
  {
    return 16033;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nu
 * JD-Core Version:    0.7.0.1
 */