package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rz
  extends a
{
  public String ijk = "";
  public long ioV;
  public String ioY = "";
  public long izg;
  public String jvE = "";
  public String jwY = "";
  public long jwZ;
  public long jxa;
  
  public final String aIE()
  {
    AppMethodBeat.i(368664);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368664);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.izg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.jwY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.ioY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.jvE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentType:").append(this.jwZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeStamp:").append(this.jxa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368669);
    return localObject;
  }
  
  public final int getId()
  {
    return 21174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rz
 * JD-Core Version:    0.7.0.1
 */