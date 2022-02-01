package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fw
  extends a
{
  private long eIh;
  private long eIi;
  private long eIj;
  private String els = "";
  private String elt = "";
  private String eoj = "";
  private String erH = "";
  private long esI;
  private String eui = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209257);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209257);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209258);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.esI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongvideoLen:").append(this.eIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveGuide:").append(this.eIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayLen:").append(this.eIj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209258);
    return localObject;
  }
  
  public final fw agH()
  {
    this.esI = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21152;
  }
  
  public final fw pD(long paramLong)
  {
    this.eIh = paramLong;
    return this;
  }
  
  public final fw pE(long paramLong)
  {
    this.eIi = paramLong;
    return this;
  }
  
  public final fw pF(long paramLong)
  {
    this.eIj = paramLong;
    return this;
  }
  
  public final fw sQ(String paramString)
  {
    AppMethodBeat.i(209252);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(209252);
    return this;
  }
  
  public final fw sR(String paramString)
  {
    AppMethodBeat.i(209253);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(209253);
    return this;
  }
  
  public final fw sS(String paramString)
  {
    AppMethodBeat.i(209254);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209254);
    return this;
  }
  
  public final fw sT(String paramString)
  {
    AppMethodBeat.i(209255);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209255);
    return this;
  }
  
  public final fw sU(String paramString)
  {
    AppMethodBeat.i(209256);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209256);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fw
 * JD-Core Version:    0.7.0.1
 */