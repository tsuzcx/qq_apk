package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class z
  extends a
{
  public int ena = 0;
  public int enb = 0;
  public int enc = 0;
  public int ene = 0;
  private String enf = "";
  public int eng;
  public long enh = 0L;
  public long eni = 0L;
  private String enj = "";
  public long enk = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ena);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ene);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eng);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eni);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enk);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.ena);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.enb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.enc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.ene);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.enf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.eng);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.enh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.eni);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.enj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.enk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final int getId()
  {
    return 17473;
  }
  
  public final z ib(String paramString)
  {
    AppMethodBeat.i(149903);
    this.enf = x("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
  
  public final z ic(String paramString)
  {
    AppMethodBeat.i(149904);
    this.enj = x("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(149904);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */