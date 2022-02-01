package com.tencent.mm.plugin.appbrand.jsapi.aa.e.c;

import com.tencent.luggage.k.a.a.b.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.math.BigInteger;

public final class a
{
  public static final BigInteger kCN;
  public a kCO;
  
  static
  {
    AppMethodBeat.i(139618);
    kCN = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.kCO = new a();
    AppMethodBeat.o(139616);
  }
  
  public final void a(e parame, com.tencent.luggage.k.a.a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(195126);
    if (this.kCO.kCS < this.kCO.kCR)
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.kCO.reset();
      AppMethodBeat.o(195126);
      return;
    }
    int i;
    label70:
    int j;
    label86:
    int k;
    label102:
    int n;
    long l1;
    long l2;
    long l3;
    int i1;
    int i2;
    if (parama != null)
    {
      parama = parama.getAppId();
      if (!(paramb instanceof c)) {
        break label626;
      }
      i = ((c)paramb).bdK();
      if (!(paramb instanceof c)) {
        break label632;
      }
      j = ((c)paramb).bdL();
      if (!(paramb instanceof c)) {
        break label638;
      }
      k = ((c)paramb).bdM();
      ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, parama, Boolean.valueOf(j.bcK().knV), Integer.valueOf(this.kCO.kuZ), Long.valueOf(this.kCO.kCP), this.kCO.videoPath, Long.valueOf(this.kCO.kCQ), Long.valueOf(this.kCO.duration), Long.valueOf(this.kCO.kCT), Integer.valueOf(this.kCO.kCU), Long.valueOf(this.kCO.kCV), Integer.valueOf(this.kCO.kDa), Integer.valueOf(this.kCO.kDb), this.kCO.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      n = this.kCO.kuZ;
      paramb = this.kCO.videoPath;
      l1 = this.kCO.kCT;
      l2 = this.kCO.duration;
      l3 = this.kCO.kCQ;
      i1 = this.kCO.kDa;
      i2 = this.kCO.kDb;
      paramString = this.kCO.errorMsg;
      if (!j.bcK().knV) {
        break label644;
      }
    }
    label644:
    for (int m = 1;; m = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(n), paramb, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(this.kCO.kCU), Long.valueOf(this.kCO.kCV), Long.valueOf(this.kCO.kCP), Long.valueOf(this.kCO.kCR), Long.valueOf(this.kCO.kCS), Long.valueOf(this.kCO.kCY), Long.valueOf(this.kCO.kCZ), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.kCO.reset();
      AppMethodBeat.o(195126);
      return;
      parama = "";
      break;
      label626:
      i = 0;
      break label70;
      label632:
      j = 0;
      break label86;
      label638:
      k = 0;
      break label102;
    }
  }
  
  public final class a
  {
    public long duration = 0L;
    public String errorMsg = "";
    public long kCP = 0L;
    public long kCQ = 0L;
    public long kCR = 0L;
    public long kCS = 0L;
    public long kCT = 0L;
    public int kCU = 0;
    public long kCV = 0L;
    public long kCW = 0L;
    public long kCX = 0L;
    public long kCY = 0L;
    public long kCZ = 0L;
    public int kDa = 0;
    public int kDb = 0;
    public int kuZ = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.kuZ = 0;
      this.kCP = 0L;
      this.duration = 0L;
      this.kCQ = 0L;
      this.kCR = 0L;
      this.kCS = 0L;
      this.kCT = 0L;
      this.kCU = 0;
      this.kCW = 0L;
      this.kCX = 0L;
      this.kCV = 0L;
      this.kCY = 0L;
      this.kCZ = 0L;
      this.kDa = 0;
      this.kDb = 0;
      this.errorMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a
 * JD-Core Version:    0.7.0.1
 */