package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fx
  extends a
{
  private String els = "";
  private String elt = "";
  private long enl;
  private String eoj = "";
  private String erH = "";
  private long esJ;
  private String eui = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209264);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209264);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209265);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.esJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209265);
    return localObject;
  }
  
  public final int getId()
  {
    return 21151;
  }
  
  public final fx pG(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final fx pH(long paramLong)
  {
    this.esJ = paramLong;
    return this;
  }
  
  public final fx sV(String paramString)
  {
    AppMethodBeat.i(209259);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(209259);
    return this;
  }
  
  public final fx sW(String paramString)
  {
    AppMethodBeat.i(209260);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(209260);
    return this;
  }
  
  public final fx sX(String paramString)
  {
    AppMethodBeat.i(209261);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209261);
    return this;
  }
  
  public final fx sY(String paramString)
  {
    AppMethodBeat.i(209262);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209262);
    return this;
  }
  
  public final fx sZ(String paramString)
  {
    AppMethodBeat.i(209263);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209263);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fx
 * JD-Core Version:    0.7.0.1
 */