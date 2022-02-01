package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  public int ipI = 0;
  public int ipJ = 0;
  public int ipK = 0;
  public String ipL = "";
  public String ipM = "";
  public String ipN = "";
  public String ipO = "";
  public String ipP = "";
  public String ipQ = "";
  public String ipR = "";
  public String ipS = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.ipI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.ipJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.ipK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.ipL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.ipM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.ipN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.ipO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.ipP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.ipQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.ipR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.ipS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63298);
    return localObject;
  }
  
  public final int getId()
  {
    return 15548;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.aw
 * JD-Core Version:    0.7.0.1
 */