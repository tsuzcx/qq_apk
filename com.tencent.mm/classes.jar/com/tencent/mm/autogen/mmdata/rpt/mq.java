package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mq
  extends a
{
  public int ipH;
  private String irF = "";
  public int jbU = -1;
  public int jbV = -1;
  public String jbW = "";
  public String jbX = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368353);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368353);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368357);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Publishid:").append(this.irF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstallMiaoJian:").append(this.jbU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ifEg:").append(this.jbV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EgID:").append(this.jbW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicID:").append(this.jbX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368357);
    return localObject;
  }
  
  public final int getId()
  {
    return 22624;
  }
  
  public final mq vc(String paramString)
  {
    AppMethodBeat.i(368349);
    this.irF = F("Publishid", paramString, true);
    AppMethodBeat.o(368349);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mq
 * JD-Core Version:    0.7.0.1
 */