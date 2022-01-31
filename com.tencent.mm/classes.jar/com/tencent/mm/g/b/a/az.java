package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  public long cWn = 0L;
  private String cWo = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(108860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cWn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWo);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108860);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108861);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.cWn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.cWo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108861);
    return localObject;
  }
  
  public final az cC(long paramLong)
  {
    this.cWn = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final az gm(String paramString)
  {
    AppMethodBeat.i(108859);
    this.cWo = t("StoryId", paramString, true);
    AppMethodBeat.o(108859);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */