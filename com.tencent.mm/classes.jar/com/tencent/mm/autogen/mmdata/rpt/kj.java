package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kj
  extends a
{
  public long iCW;
  public long iTq;
  public long iWo;
  public long iWp;
  public long iWq;
  public long ikE;
  public String ipT = "";
  public long iqr;
  
  public final String aIE()
  {
    AppMethodBeat.i(368810);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368810);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368815);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserAction:").append(this.iWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreen:").append(this.iTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskCount:").append(this.iWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterChatting:").append(this.iWq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368815);
    return localObject;
  }
  
  public final int getId()
  {
    return 21920;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kj
 * JD-Core Version:    0.7.0.1
 */