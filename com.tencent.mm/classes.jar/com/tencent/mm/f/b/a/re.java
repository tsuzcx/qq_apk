package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class re
  extends a
{
  private long gDO;
  private long glY;
  private String nCd = "";
  private long nLX;
  private long nLY;
  private long nLZ;
  private long nMa;
  private String nMb = "";
  private String nMc = "";
  private String nMd = "";
  private String nMk = "";
  private long nMl;
  private long nMm;
  private long nmK;
  private long nmS;
  private String nmT = "";
  private long rnA;
  private String rnB = "";
  private String rnC = "";
  private String rnz = "";
  
  public final re SF(long paramLong)
  {
    this.nmK = paramLong;
    return this;
  }
  
  public final re SM(long paramLong)
  {
    this.glY = paramLong;
    return this;
  }
  
  public final re SN(long paramLong)
  {
    this.nLX = paramLong;
    return this;
  }
  
  public final re TN(long paramLong)
  {
    this.nLY = paramLong;
    return this;
  }
  
  public final re Wr(long paramLong)
  {
    this.nLZ = paramLong;
    return this;
  }
  
  public final re XP(long paramLong)
  {
    this.nMa = paramLong;
    return this;
  }
  
  public final re XQ(long paramLong)
  {
    this.nMl = paramLong;
    return this;
  }
  
  public final re XR(long paramLong)
  {
    this.nMm = paramLong;
    return this;
  }
  
  public final re XS(long paramLong)
  {
    this.gDO = paramLong;
    return this;
  }
  
  public final re XT(long paramLong)
  {
    this.rnA = paramLong;
    return this;
  }
  
  public final re abf(String paramString)
  {
    AppMethodBeat.i(293156);
    this.nmT = z("doubleLinkStatus", paramString, true);
    AppMethodBeat.o(293156);
    return this;
  }
  
  public final re abg(String paramString)
  {
    AppMethodBeat.i(293157);
    this.nCd = z("previewSize", paramString, true);
    AppMethodBeat.o(293157);
    return this;
  }
  
  public final re abh(String paramString)
  {
    AppMethodBeat.i(293158);
    this.nMb = z("decodeChange", paramString, true);
    AppMethodBeat.o(293158);
    return this;
  }
  
  public final re abi(String paramString)
  {
    AppMethodBeat.i(293159);
    this.nMc = z("encodeChange", paramString, true);
    AppMethodBeat.o(293159);
    return this;
  }
  
  public final re abj(String paramString)
  {
    AppMethodBeat.i(293160);
    this.nMd = z("miniViewChange", paramString, true);
    AppMethodBeat.o(293160);
    return this;
  }
  
  public final re abk(String paramString)
  {
    AppMethodBeat.i(293161);
    this.nMk = z("fullViewChange", paramString, true);
    AppMethodBeat.o(293161);
    return this;
  }
  
  public final re adA(String paramString)
  {
    AppMethodBeat.i(293164);
    this.rnC = z("batteryTemperate", paramString, true);
    AppMethodBeat.o(293164);
    return this;
  }
  
  public final re ady(String paramString)
  {
    AppMethodBeat.i(293162);
    this.rnz = z("audioDevicePlugChange", paramString, true);
    AppMethodBeat.o(293162);
    return this;
  }
  
  public final re adz(String paramString)
  {
    AppMethodBeat.i(293163);
    this.rnB = z("encodeSizeChange", paramString, true);
    AppMethodBeat.o(293163);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(293165);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.nmK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nmS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nCd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nLX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nLY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nLZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nMm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.rnz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.rnA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.rnB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.rnC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(293165);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(293166);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("voipType:").append(this.nmK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalTime:").append(this.glY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audioDevicePlugs:").append(this.nmS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("doubleLinkStatus:").append(this.nmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewSize:").append(this.nCd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useRemovePreviewCallback:").append(this.nLX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useRgb2Yuv:").append(this.nLY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useFaceBeauty:").append(this.nLZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useSTFilter:").append(this.nMa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("decodeChange:").append(this.nMb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("encodeChange:").append(this.nMc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("miniViewChange:").append(this.nMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fullViewChange:").append(this.nMk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("avgBatteryCost:").append(this.nMl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useSurfaceEncode:").append(this.nMm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audioDevicePlugChange:").append(this.rnz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.gDO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeReason:").append(this.rnA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("encodeSizeChange:").append(this.rnB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("batteryTemperate:").append(this.rnC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(293166);
    return localObject;
  }
  
  public final int getId()
  {
    return 23241;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.re
 * JD-Core Version:    0.7.0.1
 */