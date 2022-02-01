package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mc
  extends a
{
  private long gQR = 0L;
  private String gSL = "";
  private String gSM = "";
  private String gSN = "";
  private String gSO = "";
  private long gdX = 0L;
  private long glw = 0L;
  
  public final mc CD(String paramString)
  {
    AppMethodBeat.i(118516);
    this.gSL = z("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final mc CE(String paramString)
  {
    AppMethodBeat.i(118517);
    this.gSN = z("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final mc CF(String paramString)
  {
    AppMethodBeat.i(118518);
    this.gSO = z("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSO);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.gQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.gSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.gSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.gdX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.gSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.gSO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String ann()
  {
    return this.gSL;
  }
  
  public final String ano()
  {
    return this.gSN;
  }
  
  public final String anp()
  {
    return this.gSO;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final mc wQ(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
  
  public final mc wR(long paramLong)
  {
    this.gQR = paramLong;
    return this;
  }
  
  public final mc wS(long paramLong)
  {
    this.gdX = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mc
 * JD-Core Version:    0.7.0.1
 */