package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jn
  extends a
{
  private String eRJ = "";
  public long erR = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118503);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.erR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryId:").append(this.eRJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118504);
    return localObject;
  }
  
  public final int getId()
  {
    return 16657;
  }
  
  public final jn sj(long paramLong)
  {
    this.erR = paramLong;
    return this;
  }
  
  public final jn wR(String paramString)
  {
    AppMethodBeat.i(118502);
    this.eRJ = x("StoryId", paramString, true);
    AppMethodBeat.o(118502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jn
 * JD-Core Version:    0.7.0.1
 */