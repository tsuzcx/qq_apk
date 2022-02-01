package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  private String eCG = "";
  private String eCH = "";
  private long eCI;
  private long eCJ;
  private long eCK;
  private String eiC = "";
  private String erU = "";
  private String erV = "";
  private long erW;
  private long ery;
  
  public final String abV()
  {
    AppMethodBeat.i(209226);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209226);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209227);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.eCG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.eCH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.eCI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.eCJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.eCK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209227);
    return localObject;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final ej lT(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ej lU(long paramLong)
  {
    this.eCI = paramLong;
    return this;
  }
  
  public final ej lV(long paramLong)
  {
    this.eCJ = paramLong;
    return this;
  }
  
  public final ej lW(long paramLong)
  {
    this.eCK = paramLong;
    return this;
  }
  
  public final ej lX(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final ej qW(String paramString)
  {
    AppMethodBeat.i(209221);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(209221);
    return this;
  }
  
  public final ej qX(String paramString)
  {
    AppMethodBeat.i(209222);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(209222);
    return this;
  }
  
  public final ej qY(String paramString)
  {
    AppMethodBeat.i(209223);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209223);
    return this;
  }
  
  public final ej qZ(String paramString)
  {
    AppMethodBeat.i(209224);
    this.eCG = x("PoiText", paramString, true);
    AppMethodBeat.o(209224);
    return this;
  }
  
  public final ej ra(String paramString)
  {
    AppMethodBeat.i(209225);
    this.eCH = x("FilterTextItems", paramString, true);
    AppMethodBeat.o(209225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ej
 * JD-Core Version:    0.7.0.1
 */