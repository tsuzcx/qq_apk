package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  private long dJw = 0L;
  private long dTd = 0L;
  private String dVa = "";
  private String dVb = "";
  private long dVc = 0L;
  private String dVd = "";
  private String dVe = "";
  
  public final String PV()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.dVe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String Rm()
  {
    return this.dVa;
  }
  
  public final String Rn()
  {
    return this.dVd;
  }
  
  public final String Ro()
  {
    return this.dVe;
  }
  
  public final dq gD(long paramLong)
  {
    this.dJw = paramLong;
    return this;
  }
  
  public final dq gE(long paramLong)
  {
    this.dTd = paramLong;
    return this;
  }
  
  public final dq gF(long paramLong)
  {
    this.dVc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final dq jV(String paramString)
  {
    AppMethodBeat.i(118516);
    this.dVa = t("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final dq jW(String paramString)
  {
    AppMethodBeat.i(118517);
    this.dVd = t("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final dq jX(String paramString)
  {
    AppMethodBeat.i(118518);
    this.dVe = t("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dq
 * JD-Core Version:    0.7.0.1
 */