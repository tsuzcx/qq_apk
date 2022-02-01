package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  public long euQ = 0L;
  public long euR = 0L;
  public long euS = 0L;
  public long euT = 0L;
  public long euU = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euU);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.euQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.euS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.euT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.euU);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hv
 * JD-Core Version:    0.7.0.1
 */