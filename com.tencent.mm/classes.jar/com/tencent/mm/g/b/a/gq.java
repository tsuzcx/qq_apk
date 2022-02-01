package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  public long ecE = 0L;
  public long ecF = 0L;
  public long ecG = 0L;
  public long ecH = 0L;
  public long ecI = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecI);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.ecE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.ecF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.ecG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.ecH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.ecI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43479);
    return localObject;
  }
  
  public final int getId()
  {
    return 15401;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gq
 * JD-Core Version:    0.7.0.1
 */