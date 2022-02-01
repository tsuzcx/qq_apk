package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  public String dTc = "";
  public long dTd = 0L;
  public long dTe = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118481);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.dTe);
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
    return this.dTc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */