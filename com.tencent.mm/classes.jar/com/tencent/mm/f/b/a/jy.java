package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jy
  extends a
{
  public long gMg;
  public long gMh = -1L;
  public long gMi = -1L;
  public String gks = "";
  public long goQ;
  public long goe;
  private String gyE = "";
  
  public final jy AV(String paramString)
  {
    AppMethodBeat.i(262813);
    this.gyE = z("MonmentSessionId", paramString, true);
    AppMethodBeat.o(262813);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(262815);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMi);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(262815);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(262817);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.gks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.goQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.gyE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("templateType:").append(this.gMg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbExit:").append(this.gMh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbBlack:").append(this.gMi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(262817);
    return localObject;
  }
  
  public final int getId()
  {
    return 21746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jy
 * JD-Core Version:    0.7.0.1
 */