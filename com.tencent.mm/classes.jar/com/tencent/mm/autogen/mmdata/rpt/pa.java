package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pa
  extends a
{
  public long iuE = 0L;
  public long jjn = 0L;
  public long jkC = 0L;
  private String jlb = "";
  private String jlc = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.jjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.jkC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.iuE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.jlb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.jlc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final pa wB(String paramString)
  {
    AppMethodBeat.i(118512);
    this.jlb = F("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final pa wC(String paramString)
  {
    AppMethodBeat.i(118513);
    this.jlc = F("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pa
 * JD-Core Version:    0.7.0.1
 */