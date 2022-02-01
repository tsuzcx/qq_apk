package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  public String gfY = "";
  public long gfZ = 0L;
  public a gga;
  
  public final String agH()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfZ);
    ((StringBuffer)localObject).append(",");
    if (this.gga != null) {}
    for (int i = this.gga.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.gfY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.gfZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.gga);
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
      ggb = new a("NoDownLoad", 0, 0);
      ggc = new a("DownLoading", 1, 1);
      ggd = new a("DownLoaded", 2, 2);
      gge = new a("DownLoadFail", 3, 3);
      ggf = new a[] { ggb, ggc, ggd, gge };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.x
 * JD-Core Version:    0.7.0.1
 */