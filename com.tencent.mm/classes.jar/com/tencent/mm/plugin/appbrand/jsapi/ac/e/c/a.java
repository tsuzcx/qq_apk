package com.tencent.mm.plugin.appbrand.jsapi.ac.e.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.math.BigInteger;

public final class a
{
  public static final BigInteger lBe;
  public a lBf;
  
  static
  {
    AppMethodBeat.i(139618);
    lBe = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.lBf = new a();
    AppMethodBeat.o(139616);
  }
  
  public final void a(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(186958);
    if (this.lBf.lBj < this.lBf.lBi)
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.lBf.reset();
      AppMethodBeat.o(186958);
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
      i = ((c)paramb).bop();
      if (!(paramb instanceof c)) {
        break label632;
      }
      j = ((c)paramb).boq();
      if (!(paramb instanceof c)) {
        break label638;
      }
      k = ((c)paramb).bor();
      ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, parama, Boolean.valueOf(j.bnr().llS), Integer.valueOf(this.lBf.ltm), Long.valueOf(this.lBf.lBg), this.lBf.videoPath, Long.valueOf(this.lBf.lBh), Long.valueOf(this.lBf.duration), Long.valueOf(this.lBf.lBk), Integer.valueOf(this.lBf.lBl), Long.valueOf(this.lBf.lBm), Integer.valueOf(this.lBf.lBr), Integer.valueOf(this.lBf.lBs), this.lBf.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      n = this.lBf.ltm;
      paramb = this.lBf.videoPath;
      l1 = this.lBf.lBk;
      l2 = this.lBf.duration;
      l3 = this.lBf.lBh;
      i1 = this.lBf.lBr;
      i2 = this.lBf.lBs;
      paramString = this.lBf.errorMsg;
      if (!j.bnr().llS) {
        break label644;
      }
    }
    label644:
    for (int m = 1;; m = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(n), paramb, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(this.lBf.lBl), Long.valueOf(this.lBf.lBm), Long.valueOf(this.lBf.lBg), Long.valueOf(this.lBf.lBi), Long.valueOf(this.lBf.lBj), Long.valueOf(this.lBf.lBp), Long.valueOf(this.lBf.lBq), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.lBf.reset();
      AppMethodBeat.o(186958);
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
    public long lBg = 0L;
    public long lBh = 0L;
    public long lBi = 0L;
    public long lBj = 0L;
    public long lBk = 0L;
    public int lBl = 0;
    public long lBm = 0L;
    public long lBn = 0L;
    public long lBo = 0L;
    public long lBp = 0L;
    public long lBq = 0L;
    public int lBr = 0;
    public int lBs = 0;
    public int ltm = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.ltm = 0;
      this.lBg = 0L;
      this.duration = 0L;
      this.lBh = 0L;
      this.lBi = 0L;
      this.lBj = 0L;
      this.lBk = 0L;
      this.lBl = 0;
      this.lBn = 0L;
      this.lBo = 0L;
      this.lBm = 0L;
      this.lBp = 0L;
      this.lBq = 0L;
      this.lBr = 0;
      this.lBs = 0;
      this.errorMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a
 * JD-Core Version:    0.7.0.1
 */