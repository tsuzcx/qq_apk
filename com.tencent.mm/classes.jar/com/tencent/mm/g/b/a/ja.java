package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ja
  extends a
{
  public long eQf = 0L;
  public String eQj = "";
  public long eQs = 0L;
  public long eQt = 0L;
  public String emL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(194416);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQt);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(194416);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(194417);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.eQs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.eQt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194417);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ja
 * JD-Core Version:    0.7.0.1
 */