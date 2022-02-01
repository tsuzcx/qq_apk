package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dc
  extends a
{
  private String ggB = "";
  private String gjB = "";
  private String gjm = "";
  private String gnO = "";
  private long grA;
  private String gse = "";
  private long gsf;
  private long gsg;
  private long gsh;
  private String gsi = "";
  private long gsj;
  private String gsk = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210206);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gse);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210206);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210209);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.gse);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.gsf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.gsg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTime:").append(this.gsh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.gsi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.gsj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.gsk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.grA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gjB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210209);
    return localObject;
  }
  
  public final int getId()
  {
    return 21564;
  }
  
  public final dc hn(long paramLong)
  {
    this.gsf = paramLong;
    return this;
  }
  
  public final dc ho(long paramLong)
  {
    this.gsg = paramLong;
    return this;
  }
  
  public final dc hp(long paramLong)
  {
    this.gsh = paramLong;
    return this;
  }
  
  public final dc hq(long paramLong)
  {
    this.gsj = paramLong;
    return this;
  }
  
  public final dc hr(long paramLong)
  {
    this.grA = paramLong;
    return this;
  }
  
  public final dc oA(String paramString)
  {
    AppMethodBeat.i(210186);
    this.gse = z("clickTabContextId", paramString, true);
    AppMethodBeat.o(210186);
    return this;
  }
  
  public final dc oB(String paramString)
  {
    AppMethodBeat.i(210192);
    this.gsi = z("cardid", paramString, true);
    AppMethodBeat.o(210192);
    return this;
  }
  
  public final dc oC(String paramString)
  {
    AppMethodBeat.i(210194);
    this.gsk = z("cardTag", paramString, true);
    AppMethodBeat.o(210194);
    return this;
  }
  
  public final dc oD(String paramString)
  {
    AppMethodBeat.i(210197);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(210197);
    return this;
  }
  
  public final dc oE(String paramString)
  {
    AppMethodBeat.i(210203);
    this.gjB = z("SessionBuffer", paramString, true);
    AppMethodBeat.o(210203);
    return this;
  }
  
  public final dc oy(String paramString)
  {
    AppMethodBeat.i(210181);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(210181);
    return this;
  }
  
  public final dc oz(String paramString)
  {
    AppMethodBeat.i(210183);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(210183);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dc
 * JD-Core Version:    0.7.0.1
 */