package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kv
  extends a
{
  public int gPc = 0;
  public int gPd = 0;
  public int gPe = 0;
  public int gPf = 0;
  public int gPg = 0;
  public int gPh = 0;
  public int gPi = 0;
  public int gPj = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(195424);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gPc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(195424);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(195432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FPS:").append(this.gPc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceLevel:").append(this.gPd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropBest:").append(this.gPe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropNormal:").append(this.gPf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropMiddle:").append(this.gPg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropHigh:").append(this.gPh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropFrozen:").append(this.gPi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sensitivity:").append(this.gPj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195432);
    return localObject;
  }
  
  public final int getId()
  {
    return 22765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kv
 * JD-Core Version:    0.7.0.1
 */