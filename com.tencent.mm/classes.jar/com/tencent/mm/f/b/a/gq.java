package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  public long gDb;
  public long gDc;
  public long gDd;
  public long gDe;
  public long gDf;
  public String ggg = "";
  public long gpu = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(284758);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(284758);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(284760);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.gDb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeStamp:").append(this.gDc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterChatType:").append(this.gDd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitChatType:").append(this.gDe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitHiddenStatus:").append(this.gDf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(284760);
    return localObject;
  }
  
  public final int getId()
  {
    return 21169;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gq
 * JD-Core Version:    0.7.0.1
 */