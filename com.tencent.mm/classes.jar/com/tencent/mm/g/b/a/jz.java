package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jz
  extends a
{
  private String eCX = "";
  private String eEi = "";
  private String eEj = "";
  private int eEk = -1;
  private long eEl = 0L;
  private String eEm = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEm);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184287);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ViewId:").append(this.eEi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.eCX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LayoutId:").append(this.eEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpEvent:").append(this.eEk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeConsuming:").append(this.eEl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resName:").append(this.eEm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184288);
    return localObject;
  }
  
  public final String VC()
  {
    return this.eEm;
  }
  
  public final int getId()
  {
    return 19316;
  }
  
  public final String getPageId()
  {
    return this.eCX;
  }
  
  public final String getViewId()
  {
    return this.eEi;
  }
  
  public final jz jW(int paramInt)
  {
    this.eEk = paramInt;
    return this;
  }
  
  public final jz qD(long paramLong)
  {
    this.eEl = paramLong;
    return this;
  }
  
  public final jz sP(String paramString)
  {
    AppMethodBeat.i(195824);
    this.eEi = t("ViewId", paramString, true);
    AppMethodBeat.o(195824);
    return this;
  }
  
  public final jz sQ(String paramString)
  {
    AppMethodBeat.i(195825);
    this.eCX = t("PageId", paramString, true);
    AppMethodBeat.o(195825);
    return this;
  }
  
  public final jz sR(String paramString)
  {
    AppMethodBeat.i(195826);
    this.eEj = t("LayoutId", paramString, true);
    AppMethodBeat.o(195826);
    return this;
  }
  
  public final jz sS(String paramString)
  {
    AppMethodBeat.i(195827);
    this.eEm = t("resName", paramString, true);
    AppMethodBeat.o(195827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jz
 * JD-Core Version:    0.7.0.1
 */