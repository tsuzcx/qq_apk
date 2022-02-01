package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kn
  extends a
{
  private long eHD;
  private String eWa = "";
  private String eWb = "";
  private long eWl;
  private String eWm = "";
  private String eWn = "";
  private long eWo;
  private long eWp;
  
  public final String abV()
  {
    AppMethodBeat.i(226058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226058);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.eWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.eWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.eHD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.eWn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.eWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.eWp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226059);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final kn tK(long paramLong)
  {
    this.eWl = paramLong;
    return this;
  }
  
  public final kn tL(long paramLong)
  {
    this.eHD = paramLong;
    return this;
  }
  
  public final kn tM(long paramLong)
  {
    this.eWo = paramLong;
    return this;
  }
  
  public final kn tN(long paramLong)
  {
    this.eWp = paramLong;
    return this;
  }
  
  public final kn xS(String paramString)
  {
    AppMethodBeat.i(226054);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(226054);
    return this;
  }
  
  public final kn xT(String paramString)
  {
    AppMethodBeat.i(226055);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(226055);
    return this;
  }
  
  public final kn xU(String paramString)
  {
    AppMethodBeat.i(226056);
    this.eWm = x("EventName", paramString, true);
    AppMethodBeat.o(226056);
    return this;
  }
  
  public final kn xV(String paramString)
  {
    AppMethodBeat.i(226057);
    this.eWn = x("Parent", paramString, true);
    AppMethodBeat.o(226057);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kn
 * JD-Core Version:    0.7.0.1
 */