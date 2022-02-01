package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  public long dUt = 0L;
  private String dUu = "";
  
  public final String PV()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUu);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.dUu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final dk fX(long paramLong)
  {
    this.dUt = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final dk jK(String paramString)
  {
    AppMethodBeat.i(118502);
    this.dUu = t("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */