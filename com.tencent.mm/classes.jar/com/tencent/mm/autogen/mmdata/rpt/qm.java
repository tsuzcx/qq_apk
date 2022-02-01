package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qm
  extends a
{
  private long jrZ = 0L;
  private long jsa = 0L;
  public String jsc = "";
  public long jsd = 0L;
  public String jse = "";
  public long jsf = 0L;
  public long jsg = 0L;
  public long jsh = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jrZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jse);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.jrZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.jsa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.jsc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.jsd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.jse);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.jsf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.jsg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.jsh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final qm xG(String paramString)
  {
    AppMethodBeat.i(74989);
    this.jse = F("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qm
 * JD-Core Version:    0.7.0.1
 */