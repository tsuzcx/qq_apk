package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  public int dTZ = 0;
  public int dUa = 0;
  public int dUb = 0;
  public String dUc = "";
  public String dUd = "";
  public String dUe = "";
  public String dUf = "";
  public String dUg = "";
  public String dUh = "";
  public String dUi = "";
  public String dUj = "";
  
  public final String RC()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUj);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.dTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.dUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.dUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.dUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.dUe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.dUf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.dUg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.dUh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.dUi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.dUj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63298);
    return localObject;
  }
  
  public final int getId()
  {
    return 15548;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */