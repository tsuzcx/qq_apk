package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class c
  extends a
{
  private String cOo = "";
  public long cOp = 0L;
  public a cOq;
  
  public final String Ff()
  {
    AppMethodBeat.i(128637);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOp);
    ((StringBuffer)localObject).append(",");
    if (this.cOq != null) {}
    for (int i = this.cOq.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128637);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128638);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Url:").append(this.cOo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownLoadCostStampMs:").append(this.cOp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreLoadStatus:").append(this.cOq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128638);
    return localObject;
  }
  
  public final c eP(String paramString)
  {
    AppMethodBeat.i(128636);
    this.cOo = t("Url", paramString, true);
    AppMethodBeat.o(128636);
    return this;
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
      AppMethodBeat.i(128635);
      cOr = new a("NoDownLoad", 0, 0);
      cOs = new a("DownLoading", 1, 1);
      cOt = new a("DownLoaded", 2, 2);
      cOu = new a("DownLoadFail", 3, 3);
      cOv = new a[] { cOr, cOs, cOt, cOu };
      AppMethodBeat.o(128635);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */