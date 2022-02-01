package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  private long dHy = 0L;
  private long dUP = 0L;
  private String dWM = "";
  private String dWN = "";
  private long dWO = 0L;
  private String dWP = "";
  private String dWQ = "";
  
  public final String PR()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.dWM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.dWN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dWO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.dWP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.dWQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String RO()
  {
    return this.dWM;
  }
  
  public final String RP()
  {
    return this.dWP;
  }
  
  public final String RQ()
  {
    return this.dWQ;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final fe jQ(long paramLong)
  {
    this.dHy = paramLong;
    return this;
  }
  
  public final fe jR(long paramLong)
  {
    this.dUP = paramLong;
    return this;
  }
  
  public final fe jS(long paramLong)
  {
    this.dWO = paramLong;
    return this;
  }
  
  public final fe mL(String paramString)
  {
    AppMethodBeat.i(118516);
    this.dWM = t("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final fe mM(String paramString)
  {
    AppMethodBeat.i(118517);
    this.dWP = t("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final fe mN(String paramString)
  {
    AppMethodBeat.i(118518);
    this.dWQ = t("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fe
 * JD-Core Version:    0.7.0.1
 */