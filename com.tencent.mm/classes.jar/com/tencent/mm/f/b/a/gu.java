package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  public long gCI;
  private String gDu = "";
  public long gDv;
  public long giH;
  public long giq = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(282525);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(282525);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(282526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionName:").append(this.gDu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.giH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionType:").append(this.gCI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEduWindow:").append(this.gDv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(282526);
    return localObject;
  }
  
  public final int getId()
  {
    return 11090;
  }
  
  public final gu vL(String paramString)
  {
    AppMethodBeat.i(282524);
    this.gDu = z("SessionName", paramString, true);
    AppMethodBeat.o(282524);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gu
 * JD-Core Version:    0.7.0.1
 */