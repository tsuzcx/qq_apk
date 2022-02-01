package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  public String dUy = "";
  public long emO = 0L;
  public long emP = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118481);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.emP);
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
    return this.dUy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fp
 * JD-Core Version:    0.7.0.1
 */