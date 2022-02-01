package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fb
  extends a
{
  public String gdM = "";
  public String gdP = "";
  public int gzl;
  public int gzm;
  
  public final String agH()
  {
    AppMethodBeat.i(282681);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(282681);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(282682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.gdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.gzl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdId:").append(this.gzm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.gdP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(282682);
    return localObject;
  }
  
  public final int getId()
  {
    return 21611;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fb
 * JD-Core Version:    0.7.0.1
 */