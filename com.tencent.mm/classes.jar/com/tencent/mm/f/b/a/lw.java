package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lw
  extends a
{
  private String gSf = "";
  public long gnG = 0L;
  
  public final lw Cs(String paramString)
  {
    AppMethodBeat.i(118502);
    this.gSf = z("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.gnG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.gSf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final lw wl(long paramLong)
  {
    this.gnG = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lw
 * JD-Core Version:    0.7.0.1
 */