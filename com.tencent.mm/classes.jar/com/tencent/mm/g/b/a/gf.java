package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gf
  extends a
{
  private long dVR = 0L;
  private long emO = 0L;
  private String eoL = "";
  private String eoM = "";
  private long eoN = 0L;
  private String eoO = "";
  private String eoP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.eoL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.eoM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.eoN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.eoO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.eoP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String Ub()
  {
    return this.eoL;
  }
  
  public final String Uc()
  {
    return this.eoO;
  }
  
  public final String Ud()
  {
    return this.eoP;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final gf lN(long paramLong)
  {
    this.dVR = paramLong;
    return this;
  }
  
  public final gf lO(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
  
  public final gf lP(long paramLong)
  {
    this.eoN = paramLong;
    return this;
  }
  
  public final gf pu(String paramString)
  {
    AppMethodBeat.i(118516);
    this.eoL = t("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final gf pv(String paramString)
  {
    AppMethodBeat.i(118517);
    this.eoO = t("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final gf pw(String paramString)
  {
    AppMethodBeat.i(118518);
    this.eoP = t("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gf
 * JD-Core Version:    0.7.0.1
 */