package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  private String eFc = "";
  public long eLz;
  public long eMc;
  private String eMd = "";
  private String eMe = "";
  public long eMf;
  public long ejW;
  public long enM;
  
  public final String abV()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.eMc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.eMf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final ho vp(String paramString)
  {
    AppMethodBeat.i(184775);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final ho vq(String paramString)
  {
    AppMethodBeat.i(194003);
    this.eMd = x("todoid", paramString, true);
    AppMethodBeat.o(194003);
    return this;
  }
  
  public final ho vr(String paramString)
  {
    AppMethodBeat.i(194004);
    this.eMe = x("appusername", paramString, true);
    AppMethodBeat.o(194004);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ho
 * JD-Core Version:    0.7.0.1
 */