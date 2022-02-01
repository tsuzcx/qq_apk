package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  public long eod = 0L;
  private String eoe = "";
  
  public final String RC()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eod);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoe);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.eod);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.eoe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final fz lh(long paramLong)
  {
    this.eod = paramLong;
    return this;
  }
  
  public final fz pi(String paramString)
  {
    AppMethodBeat.i(118502);
    this.eoe = t("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fz
 * JD-Core Version:    0.7.0.1
 */