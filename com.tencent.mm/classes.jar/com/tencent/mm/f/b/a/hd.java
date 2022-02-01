package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd
  extends a
{
  private long gEn;
  private long gEo;
  private String gEp = "";
  private String gEq = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gEn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208846);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NewMsgCount:").append(this.gEn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnReadLiveEndCount:").append(this.gEo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewTipsIDs:").append(this.gEp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteTipsIDs:").append(this.gEq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208847);
    return localObject;
  }
  
  public final int getId()
  {
    return 22623;
  }
  
  public final hd qm(long paramLong)
  {
    this.gEn = paramLong;
    return this;
  }
  
  public final hd qn(long paramLong)
  {
    this.gEo = paramLong;
    return this;
  }
  
  public final hd wc(String paramString)
  {
    AppMethodBeat.i(208844);
    this.gEp = z("NewTipsIDs", paramString, true);
    AppMethodBeat.o(208844);
    return this;
  }
  
  public final hd wd(String paramString)
  {
    AppMethodBeat.i(208845);
    this.gEq = z("DeleteTipsIDs", paramString, true);
    AppMethodBeat.o(208845);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hd
 * JD-Core Version:    0.7.0.1
 */