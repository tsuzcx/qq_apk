package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nw
  extends a
{
  public int eRI;
  public int eki;
  public long exh;
  public String fiF = "";
  public String fiG = "";
  
  public final String abV()
  {
    AppMethodBeat.i(186337);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(186337);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(186338);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.exh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.fiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.fiG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eRI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186338);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nw
 * JD-Core Version:    0.7.0.1
 */