package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bn
  extends a
{
  public int dJu;
  public String dKt;
  public String dPN;
  public int dPO;
  
  public final String PV()
  {
    AppMethodBeat.i(191126);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(191126);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(191127);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.dPN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.dPO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(191127);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bn
 * JD-Core Version:    0.7.0.1
 */