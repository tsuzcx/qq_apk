package com.tencent.mm.plugin.appbrand.jsapi.al.e.c;

import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;

public class a
{
  public static final BigInteger sSB;
  public a sSC;
  
  static
  {
    AppMethodBeat.i(139618);
    sSB = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.sSC = new a();
    AppMethodBeat.o(139616);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, j.b paramb)
  {
    AppMethodBeat.i(327258);
    if (parame != null)
    {
      if (paramb.sGy) {
        parame.d(1234L, 134L, 1L);
      }
      if (paramb.sGz) {
        parame.d(1234L, 135L, 1L);
      }
    }
    AppMethodBeat.o(327258);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, g paramg, String paramString)
  {
    AppMethodBeat.i(327266);
    if (this.sSC.sSI < this.sSC.sSH)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.sSC.reset();
      AppMethodBeat.o(327266);
      return;
    }
    int k;
    int j;
    int i;
    d locald1;
    d locald2;
    if (parama != null)
    {
      parama = parama.getAppId();
      k = 0;
      j = 0;
      i = 0;
      locald1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.c.k.sGD;
      locald2 = com.tencent.mm.plugin.appbrand.jsapi.video.e.c.k.sGD;
      paramg = (m)paramg.aU(m.class);
      if (paramg == null) {
        break label1033;
      }
      k = paramg.cwK();
      j = paramg.cwL();
      i = paramg.cwM();
      locald1 = paramg.cwQ();
    }
    label1027:
    label1033:
    for (paramg = paramg.cwP();; paramg = locald2)
    {
      int i3 = locald1.cKL;
      int i4 = locald1.cKN;
      int i5 = locald1.cKO;
      int i6 = paramg.cKL;
      int i7 = paramg.cKN;
      int i8 = paramg.cKO;
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s, fixNotifyErrorChannel: %d, lockCache: %b, useCronet: %b, interruptCache: %b, notifyErrorFix2FailCount: %d, audioRenderedCount: %d, audioDroppedCount: %d, audioMaxConsecutiveDroppedCount: %d, videoRenderedCount: %d, videoDroppedCount: %d, videoMaxConsecutiveDroppedCount: %d", new Object[] { paramString, parama, Boolean.valueOf(i.cvD().sAx), Integer.valueOf(this.sSC.sJh), Long.valueOf(this.sSC.sSF), this.sSC.videoPath, Long.valueOf(this.sSC.sSG), Long.valueOf(this.sSC.duration), Long.valueOf(this.sSC.sSJ), Integer.valueOf(this.sSC.sSK), Long.valueOf(this.sSC.sSL), Integer.valueOf(this.sSC.sSQ), Integer.valueOf(this.sSC.sSR), this.sSC.errorMsg, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.sSC.sSS.sGP), Boolean.valueOf(this.sSC.sSS.sGQ), Boolean.valueOf(this.sSC.sSS.useCronet), Boolean.valueOf(this.sSC.sSS.sGR), Integer.valueOf(this.sSC.sST), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8) });
      int i9 = this.sSC.sJh;
      paramg = this.sSC.videoPath;
      long l1 = this.sSC.sSJ;
      long l2 = this.sSC.duration;
      long l3 = this.sSC.sSG;
      int i10 = this.sSC.sSQ;
      int i11 = this.sSC.sSR;
      paramString = this.sSC.errorMsg;
      int m;
      label581:
      int i12;
      long l4;
      long l5;
      long l6;
      long l7;
      long l8;
      long l9;
      int i13;
      int n;
      label672:
      int i1;
      if (i.cvD().sAx)
      {
        m = 1;
        i12 = this.sSC.sSK;
        l4 = this.sSC.sSL;
        l5 = this.sSC.sSF;
        l6 = this.sSC.sSH;
        l7 = this.sSC.sSI;
        l8 = this.sSC.sSO;
        l9 = this.sSC.sSP;
        i13 = this.sSC.sSS.sGP;
        if (!this.sSC.sSS.sGQ) {
          break label1015;
        }
        n = 1;
        if (!this.sSC.sSS.useCronet) {
          break label1021;
        }
        i1 = 1;
        label688:
        if (!this.sSC.sSS.sGR) {
          break label1027;
        }
      }
      for (int i2 = 1;; i2 = 0)
      {
        parame.h(new Object[] { parama, Integer.valueOf(i9), paramg, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i10), Integer.valueOf(i11), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i12), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i13), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(this.sSC.sST), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8) });
        this.sSC.reset();
        AppMethodBeat.o(327266);
        return;
        parama = "";
        break;
        m = 0;
        break label581;
        label1015:
        n = 0;
        break label672;
        label1021:
        i1 = 0;
        break label688;
      }
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, g paramg, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(327262);
    if ((paramg != null) && (parame != null))
    {
      parame.d(1234L, 65L, 1L);
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
        break label148;
      }
      parame.d(1234L, 75L, 1L);
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.d(paramg)) {
        break label265;
      }
      if (!Util.isNullOrNil(paramString))
      {
        if (!paramString.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
          break label195;
        }
        parame.d(1234L, 72L, 1L);
      }
    }
    label265:
    for (;;)
    {
      this.sSC.sSQ = paramInt1;
      this.sSC.sSR = paramInt2;
      this.sSC.errorMsg = paramString;
      AppMethodBeat.o(327262);
      return;
      label148:
      if (g(paramg))
      {
        parame.d(1234L, 109L, 1L);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.d(paramg)) {
        break;
      }
      parame.d(1234L, 70L, 1L);
      break;
      label195:
      if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
      {
        parame.d(1234L, 73L, 1L);
      }
      else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
      {
        parame.d(1234L, 71L, 1L);
      }
      else
      {
        parame.d(1234L, 74L, 1L);
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.video.e.e locale = fD(paramInt1, paramInt2);
        if (locale != null) {
          switch (2.sSE[locale.ordinal()])
          {
          default: 
            break;
          case 1: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 116L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 125L, 1L);
            }
            break;
          case 2: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 117L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 126L, 1L);
            }
            break;
          case 3: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 118L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 127L, 1L);
            }
            break;
          case 4: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 119L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 128L, 1L);
            }
            break;
          case 5: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 120L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 129L, 1L);
            }
            break;
          case 6: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 121L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 130L, 1L);
            }
            break;
          case 7: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 122L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 131L, 1L);
            }
            break;
          case 8: 
            if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
              parame.d(1234L, 123L, 1L);
            } else if (g(paramg)) {
              parame.d(1234L, 132L, 1L);
            }
            break;
          }
        }
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.jsapi.video.e.e fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327260);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.e locale = com.tencent.mm.plugin.appbrand.jsapi.video.e.e.fD(paramInt1, paramInt2);
    AppMethodBeat.o(327260);
    return locale;
  }
  
  public boolean g(g paramg)
  {
    return false;
  }
  
  public final class a
  {
    public long duration = 0L;
    String errorMsg = "";
    public int sJh = 0;
    public long sSF = 0L;
    public long sSG = 0L;
    public long sSH = 0L;
    public long sSI = 0L;
    public long sSJ = 0L;
    public int sSK = 0;
    public long sSL = 0L;
    public long sSM = 0L;
    public long sSN = 0L;
    public long sSO = 0L;
    public long sSP = 0L;
    int sSQ = 0;
    int sSR = 0;
    public m.b sSS = m.b.sGO;
    int sST = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.sJh = 0;
      this.sSF = 0L;
      this.duration = 0L;
      this.sSG = 0L;
      this.sSH = 0L;
      this.sSI = 0L;
      this.sSJ = 0L;
      this.sSK = 0;
      this.sSM = 0L;
      this.sSN = 0L;
      this.sSL = 0L;
      this.sSO = 0L;
      this.sSP = 0L;
      this.sSQ = 0;
      this.sSR = 0;
      this.errorMsg = "";
      this.sSS = m.b.sGO;
      this.sST = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a
 * JD-Core Version:    0.7.0.1
 */