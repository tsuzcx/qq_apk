package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  private String ggA = "";
  private String gnV = "";
  private String gnZ = "";
  private String gob = "";
  private String goj = "";
  private String guT = "";
  private int guU;
  private String guV = "";
  private String guW = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208345);
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
    ((StringBuffer)localObject).append(this.gnZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gob);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208345);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208346);
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
    ((StringBuffer)localObject).append("eid:").append(this.gnZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.guW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.gob);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208346);
    return localObject;
  }
  
  public final int getId()
  {
    return 21875;
  }
  
  public final ew mq(int paramInt)
  {
    this.guU = paramInt;
    return this;
  }
  
  public final ew th(String paramString)
  {
    AppMethodBeat.i(208336);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(208336);
    return this;
  }
  
  public final ew ti(String paramString)
  {
    AppMethodBeat.i(208338);
    this.guT = z("findercontextid", paramString, true);
    AppMethodBeat.o(208338);
    return this;
  }
  
  public final ew tj(String paramString)
  {
    AppMethodBeat.i(208339);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(208339);
    return this;
  }
  
  public final ew tk(String paramString)
  {
    AppMethodBeat.i(208340);
    this.guV = z("event_time", paramString, true);
    AppMethodBeat.o(208340);
    return this;
  }
  
  public final ew tl(String paramString)
  {
    AppMethodBeat.i(208341);
    this.gnZ = z("eid", paramString, true);
    AppMethodBeat.o(208341);
    return this;
  }
  
  public final ew tm(String paramString)
  {
    AppMethodBeat.i(208342);
    this.guW = z("udf_kv", paramString, true);
    AppMethodBeat.o(208342);
    return this;
  }
  
  public final ew tn(String paramString)
  {
    AppMethodBeat.i(208343);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(208343);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ew
 * JD-Core Version:    0.7.0.1
 */