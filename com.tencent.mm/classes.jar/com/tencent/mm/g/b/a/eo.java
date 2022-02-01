package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eo
  extends a
{
  public String dGd = "";
  public long dUP = 0L;
  public long dUQ = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118481);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dGd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.dUQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118482);
    return localObject;
  }
  
  public final int getId()
  {
    return 16656;
  }
  
  public final String getUserName()
  {
    return this.dGd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eo
 * JD-Core Version:    0.7.0.1
 */