package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lk
  extends a
{
  public String eXp = "";
  public String eYE = "";
  public long eYF;
  public long eYG;
  public String eiB = "";
  public long enl;
  public String eno = "";
  public long etp;
  
  public final String abV()
  {
    AppMethodBeat.i(187817);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYG);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187817);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187818);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.eYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.eXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentType:").append(this.eYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeStamp:").append(this.eYG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187818);
    return localObject;
  }
  
  public final int getId()
  {
    return 21174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lk
 * JD-Core Version:    0.7.0.1
 */