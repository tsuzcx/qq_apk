package com.tencent.mm.plugin.appbrand.jsapi.ag.e.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigInteger;

public final class a
{
  public static final BigInteger mNl;
  public a mNm;
  
  static
  {
    AppMethodBeat.i(139618);
    mNl = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.mNm = new a();
    AppMethodBeat.o(139616);
  }
  
  public static void a(e parame, f.b paramb)
  {
    AppMethodBeat.i(215907);
    if (parame != null)
    {
      if (paramb.mCy) {
        parame.c(1234L, 134L, 1L);
      }
      if (paramb.mCz) {
        parame.c(1234L, 135L, 1L);
      }
    }
    AppMethodBeat.o(215907);
  }
  
  public final void a(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, c paramc, String paramString)
  {
    AppMethodBeat.i(215908);
    if (this.mNm.mNr < this.mNm.mNq)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.mNm.reset();
      AppMethodBeat.o(215908);
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
      if (!(paramc instanceof f)) {
        break label626;
      }
      i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)paramc).bKD();
      if (!(paramc instanceof f)) {
        break label632;
      }
      j = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)paramc).bKE();
      if (!(paramc instanceof f)) {
        break label638;
      }
      k = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)paramc).bKF();
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, parama, Boolean.valueOf(j.bJE().mwX), Integer.valueOf(this.mNm.mEJ), Long.valueOf(this.mNm.mNo), this.mNm.videoPath, Long.valueOf(this.mNm.mNp), Long.valueOf(this.mNm.duration), Long.valueOf(this.mNm.mNs), Integer.valueOf(this.mNm.mNt), Long.valueOf(this.mNm.mNu), Integer.valueOf(this.mNm.mNz), Integer.valueOf(this.mNm.mNA), this.mNm.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      n = this.mNm.mEJ;
      paramc = this.mNm.videoPath;
      l1 = this.mNm.mNs;
      l2 = this.mNm.duration;
      l3 = this.mNm.mNp;
      i1 = this.mNm.mNz;
      i2 = this.mNm.mNA;
      paramString = this.mNm.errorMsg;
      if (!j.bJE().mwX) {
        break label644;
      }
    }
    label644:
    for (int m = 1;; m = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(n), paramc, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(this.mNm.mNt), Long.valueOf(this.mNm.mNu), Long.valueOf(this.mNm.mNo), Long.valueOf(this.mNm.mNq), Long.valueOf(this.mNm.mNr), Long.valueOf(this.mNm.mNx), Long.valueOf(this.mNm.mNy), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.mNm.reset();
      AppMethodBeat.o(215908);
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
    public int mEJ = 0;
    public int mNA = 0;
    public long mNo = 0L;
    public long mNp = 0L;
    public long mNq = 0L;
    public long mNr = 0L;
    public long mNs = 0L;
    public int mNt = 0;
    public long mNu = 0L;
    public long mNv = 0L;
    public long mNw = 0L;
    public long mNx = 0L;
    public long mNy = 0L;
    public int mNz = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.mEJ = 0;
      this.mNo = 0L;
      this.duration = 0L;
      this.mNp = 0L;
      this.mNq = 0L;
      this.mNr = 0L;
      this.mNs = 0L;
      this.mNt = 0;
      this.mNv = 0L;
      this.mNw = 0L;
      this.mNu = 0L;
      this.mNx = 0L;
      this.mNy = 0L;
      this.mNz = 0;
      this.mNA = 0;
      this.errorMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a
 * JD-Core Version:    0.7.0.1
 */