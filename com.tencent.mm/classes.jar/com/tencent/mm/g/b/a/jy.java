package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jy
  extends a
{
  public int dRj;
  public String eEg = "";
  public String eEh = "";
  public long ege;
  public int eoc;
  
  public final String RC()
  {
    AppMethodBeat.i(218188);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ege);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoc);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218188);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218189);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ege);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.eEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.eEh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eoc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218189);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jy
 * JD-Core Version:    0.7.0.1
 */