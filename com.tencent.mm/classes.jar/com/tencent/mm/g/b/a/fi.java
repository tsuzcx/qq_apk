package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fi
  extends a
{
  public String dRB;
  public long dVP = 0L;
  public long ekQ = 0L;
  public String ekU;
  public long elc = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(110284);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110284);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.elc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110285);
    return localObject;
  }
  
  public final int getId()
  {
    return 18258;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fi
 * JD-Core Version:    0.7.0.1
 */