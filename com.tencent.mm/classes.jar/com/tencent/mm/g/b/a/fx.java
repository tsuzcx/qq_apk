package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fx
  extends a
{
  public long emv = 0L;
  private String emw = "";
  
  public final String RD()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emw);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.emv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.emw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final fx kW(long paramLong)
  {
    this.emv = paramLong;
    return this;
  }
  
  public final fx oN(String paramString)
  {
    AppMethodBeat.i(118502);
    this.emw = t("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fx
 * JD-Core Version:    0.7.0.1
 */