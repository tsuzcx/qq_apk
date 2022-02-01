package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  public int dSJ = 0;
  public int dSK = 0;
  public int dSL = 0;
  public String dSM;
  public String dSN;
  public String dSO;
  public String dSP;
  public String dSQ;
  public String dSR;
  public String dSS;
  public String dST;
  
  public final String RD()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dST);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.dSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.dSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.dSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.dSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.dSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.dSP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.dSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.dSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.dST);
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
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */