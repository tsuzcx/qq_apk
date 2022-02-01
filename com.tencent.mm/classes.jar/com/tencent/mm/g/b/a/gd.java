package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gd
  extends a
{
  private long dUB = 0L;
  private long elh = 0L;
  private String enc = "";
  private String ene = "";
  private long enf = 0L;
  private String eng = "";
  private String enh = "";
  
  public final String RD()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
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
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.enc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.ene);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.enf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.eng);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.enh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String TV()
  {
    return this.enc;
  }
  
  public final String TW()
  {
    return this.eng;
  }
  
  public final String TX()
  {
    return this.enh;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final gd lC(long paramLong)
  {
    this.dUB = paramLong;
    return this;
  }
  
  public final gd lD(long paramLong)
  {
    this.elh = paramLong;
    return this;
  }
  
  public final gd lE(long paramLong)
  {
    this.enf = paramLong;
    return this;
  }
  
  public final gd oY(String paramString)
  {
    AppMethodBeat.i(118516);
    this.enc = t("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final gd oZ(String paramString)
  {
    AppMethodBeat.i(118517);
    this.eng = t("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final gd pa(String paramString)
  {
    AppMethodBeat.i(118518);
    this.enh = t("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gd
 * JD-Core Version:    0.7.0.1
 */