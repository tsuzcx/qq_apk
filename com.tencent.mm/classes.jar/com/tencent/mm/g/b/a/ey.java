package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  public long eaA = 0L;
  public long eaB = 0L;
  public long eaC = 0L;
  public long eay = 0L;
  public long eaz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eay);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaC);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.eay);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.eaz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.eaA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.eaB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.eaC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43479);
    return localObject;
  }
  
  public final int getId()
  {
    return 15401;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ey
 * JD-Core Version:    0.7.0.1
 */