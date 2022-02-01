package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public int dFE = 0;
  public int dFF = 0;
  public int dFG = 0;
  public String dFH;
  public String dFI;
  public String dFJ;
  public String dFK;
  public String dFL;
  public String dFM;
  public String dFN;
  public String dFO;
  
  public final String PR()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFO);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.dFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.dFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dFG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.dFH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.dFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.dFK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.dFL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.dFM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.dFN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.dFO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63298);
    return localObject;
  }
  
  public final int getId()
  {
    return 15548;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.p
 * JD-Core Version:    0.7.0.1
 */