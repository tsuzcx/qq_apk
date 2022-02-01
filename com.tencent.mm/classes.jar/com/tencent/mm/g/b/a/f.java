package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class f
  extends a
{
  public String dQb = "";
  public long dQc = 0L;
  public a dQd;
  
  public final String RD()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQc);
    ((StringBuffer)localObject).append(",");
    if (this.dQd != null) {}
    for (int i = this.dQd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.dQb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.dQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.dQd);
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
      dQe = new a("NoDownLoad", 0, 0);
      dQf = new a("DownLoading", 1, 1);
      dQg = new a("DownLoaded", 2, 2);
      dQh = new a("DownLoadFail", 3, 3);
      dQi = new a[] { dQe, dQf, dQg, dQh };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.f
 * JD-Core Version:    0.7.0.1
 */