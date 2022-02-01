package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class f
  extends a
{
  public String dRr = "";
  public long dRs = 0L;
  public a dRt;
  
  public final String RC()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRs);
    ((StringBuffer)localObject).append(",");
    if (this.dRt != null) {}
    for (int i = this.dRt.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.dRr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.dRs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.dRt);
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
      dRu = new a("NoDownLoad", 0, 0);
      dRv = new a("DownLoading", 1, 1);
      dRw = new a("DownLoaded", 2, 2);
      dRx = new a("DownLoadFail", 3, 3);
      dRy = new a[] { dRu, dRv, dRw, dRx };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.f
 * JD-Core Version:    0.7.0.1
 */