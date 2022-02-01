package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class d
  extends a
{
  public String dFr = "";
  public long dFs = 0L;
  public a dFt;
  
  public final String PV()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFs);
    ((StringBuffer)localObject).append(",");
    if (this.dFt != null) {}
    for (int i = this.dFt.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.dFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.dFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.dFt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43449);
    return localObject;
  }
  
  public final int getId()
  {
    return 15586;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43447);
      dFu = new a("NoDownLoad", 0, 0);
      dFv = new a("DownLoading", 1, 1);
      dFw = new a("DownLoaded", 2, 2);
      dFx = new a("DownLoadFail", 3, 3);
      dFy = new a[] { dFu, dFv, dFw, dFx };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.d
 * JD-Core Version:    0.7.0.1
 */