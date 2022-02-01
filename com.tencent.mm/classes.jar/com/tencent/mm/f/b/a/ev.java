package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ev
  extends a
{
  private String gjw = "";
  public String gks = "";
  public long goQ;
  public long grk;
  public String gyE = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.grk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208297);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208299);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ForwardType:").append(this.grk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.gks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.goQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.gyE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208299);
    return localObject;
  }
  
  public final int getId()
  {
    return 21181;
  }
  
  public final ev tg(String paramString)
  {
    AppMethodBeat.i(208292);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(208292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ev
 * JD-Core Version:    0.7.0.1
 */