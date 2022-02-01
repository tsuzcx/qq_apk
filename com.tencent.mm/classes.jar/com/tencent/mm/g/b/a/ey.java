package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  public long dWf = 0L;
  private String dWg = "";
  
  public final String PR()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.dWf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.dWg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final ey jk(long paramLong)
  {
    this.dWf = paramLong;
    return this;
  }
  
  public final ey mA(String paramString)
  {
    AppMethodBeat.i(118502);
    this.dWg = t("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ey
 * JD-Core Version:    0.7.0.1
 */