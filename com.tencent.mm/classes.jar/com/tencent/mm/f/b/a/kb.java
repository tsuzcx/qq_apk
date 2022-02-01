package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kb
  extends a
{
  private long gMA = 0L;
  private long gMn = 0L;
  private long gMo = 0L;
  private long gMp = 0L;
  private long gMq = 0L;
  private long gMr = 0L;
  private long gMs = 0L;
  private long gMt = 0L;
  private long gMu = 0L;
  private long gMv = 0L;
  private long gMw = 0L;
  private long gMx = 0L;
  private String gMy = "";
  private long gMz = 0L;
  
  public final kb AZ(String paramString)
  {
    AppMethodBeat.i(193957);
    this.gMy = z("searchKeyword", paramString, true);
    AppMethodBeat.o(193957);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(193963);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMA);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(193963);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(193965);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("hasConfirm:").append(this.gMn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchToChat:").append(this.gMo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchToFav:").append(this.gMp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchToCloud:").append(this.gMq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasClickSearch:").append(this.gMr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasClickDetail:").append(this.gMs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatFileCount:").append(this.gMt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FavFileCount:").append(this.gMu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CloudFileCount:").append(this.gMv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstScreenCount:").append(this.gMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BelowScreenCount:").append(this.gMx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchKeyword:").append(this.gMy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchToAlbum:").append(this.gMz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AlbumFileCount:").append(this.gMA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193965);
    return localObject;
  }
  
  public final kb ami()
  {
    this.gMn = 1L;
    return this;
  }
  
  public final long amj()
  {
    return this.gMo;
  }
  
  public final long amk()
  {
    return this.gMp;
  }
  
  public final long aml()
  {
    return this.gMq;
  }
  
  public final kb amm()
  {
    this.gMr = 1L;
    return this;
  }
  
  public final kb amn()
  {
    this.gMs = 1L;
    return this;
  }
  
  public final long amo()
  {
    return this.gMt;
  }
  
  public final long amp()
  {
    return this.gMu;
  }
  
  public final long amq()
  {
    return this.gMv;
  }
  
  public final long amr()
  {
    return this.gMw;
  }
  
  public final long ams()
  {
    return this.gMx;
  }
  
  public final long amt()
  {
    return this.gMz;
  }
  
  public final long amu()
  {
    return this.gMA;
  }
  
  public final int getId()
  {
    return 19359;
  }
  
  public final kb uE(long paramLong)
  {
    this.gMo = paramLong;
    return this;
  }
  
  public final kb uF(long paramLong)
  {
    this.gMp = paramLong;
    return this;
  }
  
  public final kb uG(long paramLong)
  {
    this.gMq = paramLong;
    return this;
  }
  
  public final kb uH(long paramLong)
  {
    this.gMt = paramLong;
    return this;
  }
  
  public final kb uI(long paramLong)
  {
    this.gMu = paramLong;
    return this;
  }
  
  public final kb uJ(long paramLong)
  {
    this.gMv = paramLong;
    return this;
  }
  
  public final kb uK(long paramLong)
  {
    this.gMw = paramLong;
    return this;
  }
  
  public final kb uL(long paramLong)
  {
    this.gMx = paramLong;
    return this;
  }
  
  public final kb uM(long paramLong)
  {
    this.gMz = paramLong;
    return this;
  }
  
  public final kb uN(long paramLong)
  {
    this.gMA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kb
 * JD-Core Version:    0.7.0.1
 */