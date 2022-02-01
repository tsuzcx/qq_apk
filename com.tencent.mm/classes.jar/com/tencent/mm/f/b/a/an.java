package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class an
  extends a
{
  public int giY = 0;
  public int giZ = 0;
  public int gja = 0;
  public String gjb = "";
  public String gjc = "";
  public String gjd = "";
  public String gje = "";
  public String gjf = "";
  public String gjg = "";
  public String gjh = "";
  public String gji = "";
  
  public final String agH()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gji);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.giY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.giZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.gja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.gjb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.gjc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.gjd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.gje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.gjf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.gjg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.gjh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.gji);
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
 * Qualified Name:     com.tencent.mm.f.b.a.an
 * JD-Core Version:    0.7.0.1
 */