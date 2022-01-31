package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  private long cOA = 0L;
  private String cVF = "";
  public long cVG = 0L;
  private long cVH = 0L;
  private long cVa = 0L;
  private long cVb = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(108850);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVH);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108850);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108851);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.cOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.cVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.cVF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.cVG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.cVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.cVH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108851);
    return localObject;
  }
  
  public final at Fv()
  {
    this.cVb = 1L;
    return this;
  }
  
  public final at Fw()
  {
    this.cVH = 1L;
    return this;
  }
  
  public final at bW(long paramLong)
  {
    this.cOA = paramLong;
    return this;
  }
  
  public final at bX(long paramLong)
  {
    this.cVa = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final at gf(String paramString)
  {
    AppMethodBeat.i(108849);
    this.cVF = t("SourceUserName", paramString, true);
    AppMethodBeat.o(108849);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */