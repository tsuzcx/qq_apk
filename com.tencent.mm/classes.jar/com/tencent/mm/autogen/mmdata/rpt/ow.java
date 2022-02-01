package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ow
  extends a
{
  public long iwZ = 0L;
  private String jkB = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iwZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.iwZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.jkB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final ow wy(String paramString)
  {
    AppMethodBeat.i(118502);
    this.jkB = F("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ow
 * JD-Core Version:    0.7.0.1
 */