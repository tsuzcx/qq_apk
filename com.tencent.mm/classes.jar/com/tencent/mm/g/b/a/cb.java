package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private String eiC = "";
  private long ejW;
  private String erU = "";
  private String erV = "";
  private String euI = "";
  private long euJ;
  private long euK;
  
  public final String abV()
  {
    AppMethodBeat.i(208951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208951);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.euJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.euK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208952);
    return localObject;
  }
  
  public final cb fm(long paramLong)
  {
    this.euJ = paramLong;
    return this;
  }
  
  public final cb fn(long paramLong)
  {
    this.euK = paramLong;
    return this;
  }
  
  public final cb fo(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20353;
  }
  
  public final cb kM(String paramString)
  {
    AppMethodBeat.i(208947);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(208947);
    return this;
  }
  
  public final cb kN(String paramString)
  {
    AppMethodBeat.i(208948);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208948);
    return this;
  }
  
  public final cb kO(String paramString)
  {
    AppMethodBeat.i(208949);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(208949);
    return this;
  }
  
  public final cb kP(String paramString)
  {
    AppMethodBeat.i(208950);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208950);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */