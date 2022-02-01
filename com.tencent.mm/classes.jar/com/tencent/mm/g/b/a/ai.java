package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ai
  extends a
{
  private String eoj = "";
  private long eok;
  private long eol;
  private String eom = "";
  private String eon = "";
  private String eoo = "";
  private long eop;
  
  public final String abV()
  {
    AppMethodBeat.i(208835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eok);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eol);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eom);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eon);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eop);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208835);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontimestampms:").append(this.eok);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("atcion:").append(this.eol);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperId:").append(this.eom);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperWording:").append(this.eon);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.eoo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagClickable:").append(this.eop);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208836);
    return localObject;
  }
  
  public final ai bY(long paramLong)
  {
    AppMethodBeat.i(208831);
    this.eok = paramLong;
    super.bj("actiontimestampms", this.eok);
    AppMethodBeat.o(208831);
    return this;
  }
  
  public final ai bZ(long paramLong)
  {
    this.eol = paramLong;
    return this;
  }
  
  public final ai ca(long paramLong)
  {
    this.eop = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21559;
  }
  
  public final ai il(String paramString)
  {
    AppMethodBeat.i(208830);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(208830);
    return this;
  }
  
  public final ai im(String paramString)
  {
    AppMethodBeat.i(208832);
    this.eom = x("DailyPaperId", paramString, true);
    AppMethodBeat.o(208832);
    return this;
  }
  
  public final ai in(String paramString)
  {
    AppMethodBeat.i(208833);
    this.eon = x("DailyPaperWording", paramString, true);
    AppMethodBeat.o(208833);
    return this;
  }
  
  public final ai io(String paramString)
  {
    AppMethodBeat.i(208834);
    this.eoo = x("SessionBuffer", paramString, true);
    AppMethodBeat.o(208834);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ai
 * JD-Core Version:    0.7.0.1
 */