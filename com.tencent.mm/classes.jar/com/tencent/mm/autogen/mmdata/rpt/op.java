package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class op
  extends a
{
  public long itb = 0L;
  private String jjQ = "";
  public long jjR = 0L;
  public long jjS = 0L;
  public long jjn = 0L;
  public long jjo = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.itb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.itb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.jjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.jjQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.jjR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.jjo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.jjS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final op ws(String paramString)
  {
    AppMethodBeat.i(118485);
    this.jjQ = F("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.op
 * JD-Core Version:    0.7.0.1
 */