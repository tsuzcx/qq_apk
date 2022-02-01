package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  public int enX = 0;
  public int enY = 0;
  public int enZ = 0;
  public String eoa = "";
  public String eob = "";
  public String eoc = "";
  public String eod = "";
  public String eoe = "";
  public String eog = "";
  public String eoh = "";
  public String eoi = "";
  
  public final String abV()
  {
    AppMethodBeat.i(63297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eod);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoi);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(63297);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(63298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.enX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.enY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.enZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.eoa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.eob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.eoc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.eod);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.eoe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.eog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.eoh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.eoi);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */