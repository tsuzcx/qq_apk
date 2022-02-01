package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private String ggB = "";
  private String gsb = "";
  private String gsc = "";
  private String gsd = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210029);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsd);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210029);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210030);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportExtraInfo:").append(this.gsb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceFeedid:").append(this.gsc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceUsername:").append(this.gsd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210030);
    return localObject;
  }
  
  public final int getId()
  {
    return 21140;
  }
  
  public final db ou(String paramString)
  {
    AppMethodBeat.i(210025);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(210025);
    return this;
  }
  
  public final db ov(String paramString)
  {
    AppMethodBeat.i(210026);
    this.gsb = z("ReportExtraInfo", paramString, true);
    AppMethodBeat.o(210026);
    return this;
  }
  
  public final db ow(String paramString)
  {
    AppMethodBeat.i(210027);
    this.gsc = z("EnterSourceFeedid", paramString, true);
    AppMethodBeat.o(210027);
    return this;
  }
  
  public final db ox(String paramString)
  {
    AppMethodBeat.i(210028);
    this.gsd = z("EnterSourceUsername", paramString, true);
    AppMethodBeat.o(210028);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.db
 * JD-Core Version:    0.7.0.1
 */