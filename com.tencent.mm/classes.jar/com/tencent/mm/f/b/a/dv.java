package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  private String ggA = "";
  private String gnS = "";
  private String gnV = "";
  private String gob = "";
  private String goj = "";
  private String guT = "";
  private int guU;
  private String guV = "";
  private String guW = "";
  private long guX;
  
  public final String agH()
  {
    AppMethodBeat.i(232068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(232068);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(232069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("findercontextid:").append(this.guT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_code:").append(this.guU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.guV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.gnS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.guW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.gob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTime:").append(this.guX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(232069);
    return localObject;
  }
  
  public final int getId()
  {
    return 21874;
  }
  
  public final dv jV(long paramLong)
  {
    this.guX = paramLong;
    return this;
  }
  
  public final dv lM(int paramInt)
  {
    this.guU = paramInt;
    return this;
  }
  
  public final dv qT(String paramString)
  {
    AppMethodBeat.i(232062);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(232062);
    return this;
  }
  
  public final dv qU(String paramString)
  {
    AppMethodBeat.i(232063);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(232063);
    return this;
  }
  
  public final dv qV(String paramString)
  {
    AppMethodBeat.i(232065);
    this.guV = z("event_time", paramString, true);
    AppMethodBeat.o(232065);
    return this;
  }
  
  public final dv qW(String paramString)
  {
    AppMethodBeat.i(232066);
    this.gnS = z("finderusername", paramString, true);
    AppMethodBeat.o(232066);
    return this;
  }
  
  public final dv qX(String paramString)
  {
    AppMethodBeat.i(232067);
    this.guW = z("udf_kv", paramString, true);
    AppMethodBeat.o(232067);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dv
 * JD-Core Version:    0.7.0.1
 */