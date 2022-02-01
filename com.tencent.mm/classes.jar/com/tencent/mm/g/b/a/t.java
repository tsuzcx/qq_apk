package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public String ela = "";
  public long elb = 0L;
  public a elc;
  
  public final String abV()
  {
    AppMethodBeat.i(43448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ela);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elb);
    ((StringBuffer)localObject).append(",");
    if (this.elc != null) {}
    for (int i = this.elc.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43448);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.ela);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.elb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.elc);
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
      eld = new a("NoDownLoad", 0, 0);
      ele = new a("DownLoading", 1, 1);
      elf = new a("DownLoaded", 2, 2);
      elg = new a("DownLoadFail", 3, 3);
      elh = new a[] { eld, ele, elf, elg };
      AppMethodBeat.o(43447);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.t
 * JD-Core Version:    0.7.0.1
 */