package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oo
  extends a
{
  public long hcd = 0L;
  public long hce = 0L;
  public long hcf = 0L;
  public long hcg = 0L;
  public long hch = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(43478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hcd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hce);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hch);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43478);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AllPackageSize:").append(this.hcd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllPackageClientStoragePercent:").append(this.hce);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientStorageFreePercent:").append(this.hcf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.hcg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappCountThatHasPackage:").append(this.hch);
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
 * Qualified Name:     com.tencent.mm.f.b.a.oo
 * JD-Core Version:    0.7.0.1
 */