package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  private long ejW;
  private String els = "";
  private long epY;
  private long esA;
  private String esd = "";
  private String esx = "";
  private String esy = "";
  private String esz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208876);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208876);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208877);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("finderUsername:").append(this.esx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUsername:").append(this.esy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toFinderUsername:").append(this.esz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.epY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.esA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208877);
    return localObject;
  }
  
  public final String acA()
  {
    return this.els;
  }
  
  public final String acB()
  {
    return this.esd;
  }
  
  public final bj dI(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final bj dJ(long paramLong)
  {
    this.epY = paramLong;
    return this;
  }
  
  public final bj dK(long paramLong)
  {
    this.esA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20671;
  }
  
  public final bj jj(String paramString)
  {
    AppMethodBeat.i(208871);
    this.esx = x("finderUsername", paramString, true);
    AppMethodBeat.o(208871);
    return this;
  }
  
  public final bj jk(String paramString)
  {
    AppMethodBeat.i(208872);
    this.esy = x("toUsername", paramString, true);
    AppMethodBeat.o(208872);
    return this;
  }
  
  public final bj jl(String paramString)
  {
    AppMethodBeat.i(208873);
    this.esz = x("toFinderUsername", paramString, true);
    AppMethodBeat.o(208873);
    return this;
  }
  
  public final bj jm(String paramString)
  {
    AppMethodBeat.i(208874);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(208874);
    return this;
  }
  
  public final bj jn(String paramString)
  {
    AppMethodBeat.i(208875);
    this.esd = x("clicktabcontextid", paramString, true);
    AppMethodBeat.o(208875);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bj
 * JD-Core Version:    0.7.0.1
 */