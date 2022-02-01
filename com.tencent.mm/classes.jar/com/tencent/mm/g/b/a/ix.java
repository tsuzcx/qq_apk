package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ix
  extends a
{
  public long eIW = 0L;
  public long eQf = 0L;
  public String eQj = "";
  public String emL = "";
  public long esI = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(110284);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110284);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.esI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.eIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110285);
    return localObject;
  }
  
  public final int getId()
  {
    return 18258;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ix
 * JD-Core Version:    0.7.0.1
 */