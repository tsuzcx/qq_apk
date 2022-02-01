package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class je
  extends a
{
  public String gKO = "";
  public int gKP;
  public int ggl;
  public String gqd = "";
  
  public final String agH()
  {
    AppMethodBeat.i(273357);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(273357);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(273358);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.gKO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.gKP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(273358);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.je
 * JD-Core Version:    0.7.0.1
 */