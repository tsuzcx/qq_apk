package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hz
  extends a
{
  private String dKI;
  private long dKe;
  private long dkQ;
  private String dkR;
  private String jiI;
  private String lZl;
  private String lZm;
  private long lZn;
  private long lZp;
  private long lZq;
  
  public final String PV()
  {
    AppMethodBeat.i(203810);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203810);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203811);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.jiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.lZl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.lZm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.lZn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.lZp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.lZq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203811);
    return localObject;
  }
  
  public final hz aSD(String paramString)
  {
    AppMethodBeat.i(203805);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203805);
    return this;
  }
  
  public final hz aSE(String paramString)
  {
    AppMethodBeat.i(203806);
    this.dkR = t("Contextid", paramString, true);
    AppMethodBeat.o(203806);
    return this;
  }
  
  public final hz aSF(String paramString)
  {
    AppMethodBeat.i(203807);
    this.jiI = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(203807);
    return this;
  }
  
  public final hz aSG(String paramString)
  {
    AppMethodBeat.i(203808);
    this.lZl = t("PoiText", paramString, true);
    AppMethodBeat.o(203808);
    return this;
  }
  
  public final hz aSH(String paramString)
  {
    AppMethodBeat.i(203809);
    this.lZm = t("FilterTextItems", paramString, true);
    AppMethodBeat.o(203809);
    return this;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final hz zs(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final hz zt(long paramLong)
  {
    this.lZn = paramLong;
    return this;
  }
  
  public final hz zu(long paramLong)
  {
    this.lZp = paramLong;
    return this;
  }
  
  public final hz zv(long paramLong)
  {
    this.lZq = paramLong;
    return this;
  }
  
  public final hz zw(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hz
 * JD-Core Version:    0.7.0.1
 */