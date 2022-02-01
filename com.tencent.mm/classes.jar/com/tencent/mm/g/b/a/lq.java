package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lq
  extends a
{
  public long eZm = 0L;
  public long eZn = 0L;
  public long eZo = 0L;
  public long eZp = 0L;
  public long eZq = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eZm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.eZm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.eZn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.eZo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.eZp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.eZq);
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
 * Qualified Name:     com.tencent.mm.g.b.a.lq
 * JD-Core Version:    0.7.0.1
 */