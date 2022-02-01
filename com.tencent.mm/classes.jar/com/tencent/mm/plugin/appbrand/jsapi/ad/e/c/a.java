package com.tencent.mm.plugin.appbrand.jsapi.ad.e.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.math.BigInteger;

public final class a
{
  public static final BigInteger lFC;
  public a lFD;
  
  static
  {
    AppMethodBeat.i(139618);
    lFC = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.lFD = new a();
    AppMethodBeat.o(139616);
  }
  
  public final void a(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(220656);
    if (this.lFD.lFH < this.lFD.lFG)
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.lFD.reset();
      AppMethodBeat.o(220656);
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
      i = ((c)paramb).boZ();
      if (!(paramb instanceof c)) {
        break label632;
      }
      j = ((c)paramb).bpa();
      if (!(paramb instanceof c)) {
        break label638;
      }
      k = ((c)paramb).bpb();
      ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, parama, Boolean.valueOf(j.bob().lqs), Integer.valueOf(this.lFD.lxL), Long.valueOf(this.lFD.lFE), this.lFD.videoPath, Long.valueOf(this.lFD.lFF), Long.valueOf(this.lFD.duration), Long.valueOf(this.lFD.lFI), Integer.valueOf(this.lFD.lFJ), Long.valueOf(this.lFD.lFK), Integer.valueOf(this.lFD.lFP), Integer.valueOf(this.lFD.lFQ), this.lFD.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      n = this.lFD.lxL;
      paramb = this.lFD.videoPath;
      l1 = this.lFD.lFI;
      l2 = this.lFD.duration;
      l3 = this.lFD.lFF;
      i1 = this.lFD.lFP;
      i2 = this.lFD.lFQ;
      paramString = this.lFD.errorMsg;
      if (!j.bob().lqs) {
        break label644;
      }
    }
    label644:
    for (int m = 1;; m = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(n), paramb, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(this.lFD.lFJ), Long.valueOf(this.lFD.lFK), Long.valueOf(this.lFD.lFE), Long.valueOf(this.lFD.lFG), Long.valueOf(this.lFD.lFH), Long.valueOf(this.lFD.lFN), Long.valueOf(this.lFD.lFO), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.lFD.reset();
      AppMethodBeat.o(220656);
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
    public long lFE = 0L;
    public long lFF = 0L;
    public long lFG = 0L;
    public long lFH = 0L;
    public long lFI = 0L;
    public int lFJ = 0;
    public long lFK = 0L;
    public long lFL = 0L;
    public long lFM = 0L;
    public long lFN = 0L;
    public long lFO = 0L;
    public int lFP = 0;
    public int lFQ = 0;
    public int lxL = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.lxL = 0;
      this.lFE = 0L;
      this.duration = 0L;
      this.lFF = 0L;
      this.lFG = 0L;
      this.lFH = 0L;
      this.lFI = 0L;
      this.lFJ = 0;
      this.lFL = 0L;
      this.lFM = 0L;
      this.lFK = 0L;
      this.lFN = 0L;
      this.lFO = 0L;
      this.lFP = 0;
      this.lFQ = 0;
      this.errorMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a
 * JD-Core Version:    0.7.0.1
 */