package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ry
  extends a
{
  private String ijk = "";
  public long ioV = 0L;
  public long iow = 0L;
  public long izg = 0L;
  private String jvE = "";
  public long jwW = 0L;
  public long jwX = 0L;
  private String jwY = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368654);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368654);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368658);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DismissType:").append(this.jwW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionSourceType:").append(this.jwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.iow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.izg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.jwY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.jvE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368658);
    return localObject;
  }
  
  public final int getId()
  {
    return 20996;
  }
  
  public final ry yJ(String paramString)
  {
    AppMethodBeat.i(368638);
    this.jwY = F("EnterSceneId", paramString, true);
    AppMethodBeat.o(368638);
    return this;
  }
  
  public final ry yK(String paramString)
  {
    AppMethodBeat.i(368647);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368647);
    return this;
  }
  
  public final ry yL(String paramString)
  {
    AppMethodBeat.i(368651);
    this.jvE = F("QueryKey", paramString, true);
    AppMethodBeat.o(368651);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ry
 * JD-Core Version:    0.7.0.1
 */