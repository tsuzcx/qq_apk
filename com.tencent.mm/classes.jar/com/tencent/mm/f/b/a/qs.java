package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qs
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
  
  public final qs Es(long paramLong)
  {
    this.guX = paramLong;
    return this;
  }
  
  public final qs HC(String paramString)
  {
    AppMethodBeat.i(208959);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(208959);
    return this;
  }
  
  public final qs HD(String paramString)
  {
    AppMethodBeat.i(208960);
    this.guT = z("findercontextid", paramString, true);
    AppMethodBeat.o(208960);
    return this;
  }
  
  public final qs HE(String paramString)
  {
    AppMethodBeat.i(208961);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(208961);
    return this;
  }
  
  public final qs HF(String paramString)
  {
    AppMethodBeat.i(208962);
    this.guV = z("event_time", paramString, true);
    AppMethodBeat.o(208962);
    return this;
  }
  
  public final qs HG(String paramString)
  {
    AppMethodBeat.i(208963);
    this.gnS = z("finderusername", paramString, true);
    AppMethodBeat.o(208963);
    return this;
  }
  
  public final qs HH(String paramString)
  {
    AppMethodBeat.i(208964);
    this.guW = z("udf_kv", paramString, true);
    AppMethodBeat.o(208964);
    return this;
  }
  
  public final qs HI(String paramString)
  {
    AppMethodBeat.i(208965);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(208965);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(208967);
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
    AppMethodBeat.o(208967);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208968);
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
    AppMethodBeat.o(208968);
    return localObject;
  }
  
  public final int getId()
  {
    return 21874;
  }
  
  public final qs pk(int paramInt)
  {
    this.guU = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qs
 * JD-Core Version:    0.7.0.1
 */