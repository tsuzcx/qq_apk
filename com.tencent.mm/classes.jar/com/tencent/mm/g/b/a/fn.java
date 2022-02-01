package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fn
  extends a
{
  public String dTi = "";
  public long elh = 0L;
  public long eli = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eli);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118481);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.eli);
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
    return this.dTi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fn
 * JD-Core Version:    0.7.0.1
 */