package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  public long eEP;
  public long eEQ;
  public long eER;
  public long eES;
  public long eET;
  public String emL = "";
  public long etp = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(231475);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eER);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eES);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eET);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231475);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.eEP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeStamp:").append(this.eEQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterChatType:").append(this.eER);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitChatType:").append(this.eES);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitHiddenStatus:").append(this.eET);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231476);
    return localObject;
  }
  
  public final int getId()
  {
    return 21169;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa
 * JD-Core Version:    0.7.0.1
 */