package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  private long eIk;
  private String eIl = "";
  private long eIm;
  private long elF;
  private String els = "";
  private String elt = "";
  private String erH = "";
  private String eui = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209271);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209271);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209272);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.elF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpScene:").append(this.eIk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniSessionId:").append(this.eIl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskOrder:").append(this.eIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209272);
    return localObject;
  }
  
  public final fy agI()
  {
    this.elF = 5L;
    return this;
  }
  
  public final fy agJ()
  {
    this.eIk = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21155;
  }
  
  public final fy pI(long paramLong)
  {
    this.eIm = paramLong;
    return this;
  }
  
  public final fy ta(String paramString)
  {
    AppMethodBeat.i(209266);
    this.eIl = x("MiniSessionId", paramString, true);
    AppMethodBeat.o(209266);
    return this;
  }
  
  public final fy tb(String paramString)
  {
    AppMethodBeat.i(209267);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(209267);
    return this;
  }
  
  public final fy tc(String paramString)
  {
    AppMethodBeat.i(209268);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209268);
    return this;
  }
  
  public final fy td(String paramString)
  {
    AppMethodBeat.i(209269);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209269);
    return this;
  }
  
  public final fy te(String paramString)
  {
    AppMethodBeat.i(209270);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209270);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fy
 * JD-Core Version:    0.7.0.1
 */