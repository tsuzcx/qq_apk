package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jx
  extends a
{
  private String eBo;
  private String eCA;
  private int eCB = -1;
  private long eCC = 0L;
  private String eCD;
  private String eCz;
  
  public final String RD()
  {
    AppMethodBeat.i(184287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184287);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ViewId:").append(this.eCz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.eBo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LayoutId:").append(this.eCA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpEvent:").append(this.eCB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeConsuming:").append(this.eCC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resName:").append(this.eCD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184288);
    return localObject;
  }
  
  public final String Vu()
  {
    return this.eCD;
  }
  
  public final int getId()
  {
    return 19316;
  }
  
  public final String getPageId()
  {
    return this.eBo;
  }
  
  public final String getViewId()
  {
    return this.eCz;
  }
  
  public final jx jU(int paramInt)
  {
    this.eCB = paramInt;
    return this;
  }
  
  public final jx qq(long paramLong)
  {
    this.eCC = paramLong;
    return this;
  }
  
  public final jx su(String paramString)
  {
    AppMethodBeat.i(210184);
    this.eCz = t("ViewId", paramString, true);
    AppMethodBeat.o(210184);
    return this;
  }
  
  public final jx sv(String paramString)
  {
    AppMethodBeat.i(210185);
    this.eBo = t("PageId", paramString, true);
    AppMethodBeat.o(210185);
    return this;
  }
  
  public final jx sw(String paramString)
  {
    AppMethodBeat.i(210186);
    this.eCA = t("LayoutId", paramString, true);
    AppMethodBeat.o(210186);
    return this;
  }
  
  public final jx sx(String paramString)
  {
    AppMethodBeat.i(210187);
    this.eCD = t("resName", paramString, true);
    AppMethodBeat.o(210187);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jx
 * JD-Core Version:    0.7.0.1
 */