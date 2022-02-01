package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nt
  extends a
{
  public int jfS = 0;
  public int jfT = 0;
  public int jfU = 0;
  public int jfV = 0;
  public int jfW = 0;
  public int jfX = 0;
  public int jfY = 0;
  public int jfZ = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(367819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jfS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367819);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FPS:").append(this.jfS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceLevel:").append(this.jfT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropBest:").append(this.jfU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropNormal:").append(this.jfV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropMiddle:").append(this.jfW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropHigh:").append(this.jfX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropFrozen:").append(this.jfY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sensitivity:").append(this.jfZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367839);
    return localObject;
  }
  
  public final int getId()
  {
    return 22765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nt
 * JD-Core Version:    0.7.0.1
 */