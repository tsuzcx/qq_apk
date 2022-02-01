package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  public long etj = 0L;
  public long etk = 0L;
  public long etl = 0L;
  public long etm = 0L;
  public long etn = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etn);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.etj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.etk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.etl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.etm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.etn);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ht
 * JD-Core Version:    0.7.0.1
 */