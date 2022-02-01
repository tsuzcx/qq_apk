package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gr
  extends a
{
  private String gDg = "";
  private int gDh = 0;
  private int gDi = 0;
  private int gDj = 0;
  private int gDk = 0;
  private String gDl = "";
  private int gDm = 0;
  private String gDn = "";
  private String gDo = "";
  private int gDp = 0;
  private int ggm = 0;
  private int gmI = 0;
  private long gpj;
  
  public final String agH()
  {
    AppMethodBeat.i(211479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211479);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211480);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Status:").append(this.gpj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DictName:").append(this.gDg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.gDh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DictRequiredType:").append(this.gDi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceType:").append(this.gmI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataType:").append(this.gDj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressionAlgo:").append(this.gDk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedMd5:").append(this.gDl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TypeId:").append(this.gDm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnUrl:").append(this.gDn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriMd5:").append(this.gDo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatchVersion:").append(this.gDp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ggm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211480);
    return localObject;
  }
  
  public final int getId()
  {
    return 22358;
  }
  
  public final gr mV(int paramInt)
  {
    this.gDh = paramInt;
    return this;
  }
  
  public final gr mW(int paramInt)
  {
    this.gDi = paramInt;
    return this;
  }
  
  public final gr mX(int paramInt)
  {
    this.gmI = paramInt;
    return this;
  }
  
  public final gr mY(int paramInt)
  {
    this.gDj = paramInt;
    return this;
  }
  
  public final gr mZ(int paramInt)
  {
    this.gDk = paramInt;
    return this;
  }
  
  public final gr na(int paramInt)
  {
    this.gDm = paramInt;
    return this;
  }
  
  public final gr nb(int paramInt)
  {
    this.gDp = paramInt;
    return this;
  }
  
  public final gr nc(int paramInt)
  {
    this.ggm = paramInt;
    return this;
  }
  
  public final gr pk(long paramLong)
  {
    this.gpj = paramLong;
    return this;
  }
  
  public final gr vE(String paramString)
  {
    AppMethodBeat.i(211467);
    this.gDg = z("DictName", paramString, true);
    AppMethodBeat.o(211467);
    return this;
  }
  
  public final gr vF(String paramString)
  {
    AppMethodBeat.i(211474);
    this.gDl = z("CompressedMd5", paramString, true);
    AppMethodBeat.o(211474);
    return this;
  }
  
  public final gr vG(String paramString)
  {
    AppMethodBeat.i(211476);
    this.gDn = z("CdnUrl", paramString, true);
    AppMethodBeat.o(211476);
    return this;
  }
  
  public final gr vH(String paramString)
  {
    AppMethodBeat.i(211478);
    this.gDo = z("OriMd5", paramString, true);
    AppMethodBeat.o(211478);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gr
 * JD-Core Version:    0.7.0.1
 */