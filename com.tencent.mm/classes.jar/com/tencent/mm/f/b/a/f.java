package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class f
  extends a
{
  public int gdH;
  private String gdI = "";
  public int gdJ;
  public int gdK;
  private String gdL = "";
  
  public final String agH()
  {
    AppMethodBeat.i(240034);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(240034);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(240037);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NeedSync:").append(this.gdH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.gdI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScorePos:").append(this.gdJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigPos:").append(this.gdK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryStr:").append(this.gdL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(240037);
    return localObject;
  }
  
  public final int getId()
  {
    return 22176;
  }
  
  public final f iC(String paramString)
  {
    AppMethodBeat.i(240028);
    this.gdI = z("Score", paramString, true);
    AppMethodBeat.o(240028);
    return this;
  }
  
  public final f iD(String paramString)
  {
    AppMethodBeat.i(240030);
    this.gdL = z("HistoryStr", paramString, true);
    AppMethodBeat.o(240030);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.f
 * JD-Core Version:    0.7.0.1
 */