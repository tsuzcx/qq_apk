package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  private String eFE = "";
  public long eLz;
  private long eMc;
  private String eMd = "";
  private String eMe = "";
  public long enM;
  public long erw;
  
  public final String abV()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.eMc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final hm aha()
  {
    this.eMc = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final hm vj(String paramString)
  {
    AppMethodBeat.i(184767);
    this.eFE = x("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final hm vk(String paramString)
  {
    AppMethodBeat.i(184768);
    this.eMd = x("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final hm vl(String paramString)
  {
    AppMethodBeat.i(194001);
    this.eMe = x("appusername", paramString, true);
    AppMethodBeat.o(194001);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hm
 * JD-Core Version:    0.7.0.1
 */