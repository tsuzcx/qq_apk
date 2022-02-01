package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class b
  extends a
{
  private String gcU = "";
  private String gcV = "";
  private String gcW = "";
  private long gcX;
  private long gcY;
  private String gcZ = "";
  private long gda;
  private String gdb = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208024);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208024);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208026);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.gcW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.gcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventCode:").append(this.gcY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.gcZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.gda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityId:").append(this.gdb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208026);
    return localObject;
  }
  
  public final b agJ()
  {
    this.gda = 1L;
    return this;
  }
  
  public final b bS(long paramLong)
  {
    this.gcX = paramLong;
    return this;
  }
  
  public final b bT(long paramLong)
  {
    this.gcY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21851;
  }
  
  public final b iq(String paramString)
  {
    AppMethodBeat.i(208016);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208016);
    return this;
  }
  
  public final b ir(String paramString)
  {
    AppMethodBeat.i(208017);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208017);
    return this;
  }
  
  public final b is(String paramString)
  {
    AppMethodBeat.i(208018);
    this.gcW = z("FinderContexId", paramString, true);
    AppMethodBeat.o(208018);
    return this;
  }
  
  public final b it(String paramString)
  {
    AppMethodBeat.i(208019);
    this.gcZ = z("EventTime", paramString, true);
    AppMethodBeat.o(208019);
    return this;
  }
  
  public final b iu(String paramString)
  {
    AppMethodBeat.i(208022);
    this.gdb = z("ActivityId", paramString, true);
    AppMethodBeat.o(208022);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.b
 * JD-Core Version:    0.7.0.1
 */