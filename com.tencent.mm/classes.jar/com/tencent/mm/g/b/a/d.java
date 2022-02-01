package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class d
  extends a
{
  public String dDe = "";
  public long dDf = 0L;
  public a dDg;
  
  public final String PR()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDf);
    ((StringBuffer)localObject).append(",");
    if (this.dDg != null) {}
    for (int i = this.dDg.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.dDe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.dDf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.dDg);
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
      dDh = new a("NoDownLoad", 0, 0);
      dDi = new a("DownLoading", 1, 1);
      dDj = new a("DownLoaded", 2, 2);
      dDk = new a("DownLoadFail", 3, 3);
      dDl = new a[] { dDh, dDi, dDj, dDk };
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