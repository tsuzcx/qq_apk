package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class z
  extends a
{
  public String imE = "";
  public long imF = 0L;
  public a imG;
  
  public final String aIE()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imF);
    ((StringBuffer)localObject).append(",");
    if (this.imG != null) {}
    for (int i = this.imG.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.imE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.imF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.imG);
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
      imH = new a("NoDownLoad", 0, 0);
      imI = new a("DownLoading", 1, 1);
      imJ = new a("DownLoaded", 2, 2);
      imK = new a("DownLoadFail", 3, 3);
      imL = new a[] { imH, imI, imJ, imK };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.z
 * JD-Core Version:    0.7.0.1
 */