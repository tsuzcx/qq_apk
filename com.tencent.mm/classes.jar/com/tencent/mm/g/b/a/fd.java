package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fd
  extends a
{
  private String eEZ = "";
  public long eFa;
  public long eFb;
  public long enE;
  public long enl = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(231483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231483);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionName:").append(this.eEZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.enE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionType:").append(this.eFa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEduWindow:").append(this.eFb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231484);
    return localObject;
  }
  
  public final int getId()
  {
    return 11090;
  }
  
  public final fd sa(String paramString)
  {
    AppMethodBeat.i(231482);
    this.eEZ = x("SessionName", paramString, true);
    AppMethodBeat.o(231482);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fd
 * JD-Core Version:    0.7.0.1
 */