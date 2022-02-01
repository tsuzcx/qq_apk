package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jd
  extends a
{
  public long eQv = 0L;
  public long eQw = 0L;
  public String eoK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(118481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQw);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118481);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.eQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.eQw);
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
    return this.eoK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jd
 * JD-Core Version:    0.7.0.1
 */