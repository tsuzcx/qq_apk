package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  public long cZP = 0L;
  public long cZQ = 0L;
  public long cZR = 0L;
  public long cZS = 0L;
  public long cZT = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128641);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZT);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(128641);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128642);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.cZP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.cZQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.cZR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.cZS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.cZT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128642);
    return localObject;
  }
  
  public final int getId()
  {
    return 15401;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bz
 * JD-Core Version:    0.7.0.1
 */