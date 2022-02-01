package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sh
  extends a
{
  public long jxR = 0L;
  public long jxS = 0L;
  public long jxT = 0L;
  public long jxU = 0L;
  public long jxV = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jxR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.jxR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.jxS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.jxT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.jxU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.jxV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43479);
    return localObject;
  }
  
  public final int getId()
  {
    return 15401;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sh
 * JD-Core Version:    0.7.0.1
 */