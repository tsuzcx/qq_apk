package com.tencent.mm.plugin.appbrand.jsapi.ai.e.c;

import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;

public class a
{
  public static final BigInteger pOd;
  public a pOe;
  
  static
  {
    AppMethodBeat.i(139618);
    pOd = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.pOe = new a();
    AppMethodBeat.o(139616);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, g.b paramb)
  {
    AppMethodBeat.i(223322);
    if (parame != null)
    {
      if (paramb.pBx) {
        parame.c(1234L, 134L, 1L);
      }
      if (paramb.pBy) {
        parame.c(1234L, 135L, 1L);
      }
    }
    AppMethodBeat.o(223322);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame1, String paramString)
  {
    AppMethodBeat.i(223372);
    if (this.pOe.pOk < this.pOe.pOj)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.pOe.reset();
      AppMethodBeat.o(223372);
      return;
    }
    int i;
    label70:
    int j;
    label86:
    int k;
    label102:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    long l1;
    long l2;
    long l3;
    int i10;
    int i11;
    int m;
    label602:
    int i12;
    long l4;
    long l5;
    long l6;
    long l7;
    long l8;
    long l9;
    int i13;
    int n;
    label693:
    int i1;
    if (parama != null)
    {
      parama = parama.getAppId();
      if (!(parame1 instanceof g)) {
        break label1030;
      }
      i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)parame1).bWy();
      if (!(parame1 instanceof g)) {
        break label1036;
      }
      j = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)parame1).bWz();
      if (!(parame1 instanceof g)) {
        break label1042;
      }
      k = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)parame1).bWA();
      d locald2 = h.pBB;
      d locald1 = h.pBB;
      if ((parame1 instanceof g))
      {
        parame1 = (g)parame1;
        locald2 = parame1.bWD();
        locald1 = parame1.bWC();
      }
      i3 = locald2.aQP;
      i4 = locald2.aQR;
      i5 = locald2.aQS;
      i6 = locald1.aQP;
      i7 = locald1.aQR;
      i8 = locald1.aQS;
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s, fixNotifyErrorChannel: %d, lockCache: %b, useCronet: %b, interruptCache: %b, notifyErrorFix2FailCount: %d, audioRenderedCount: %d, audioDroppedCount: %d, audioMaxConsecutiveDroppedCount: %d, videoRenderedCount: %d, videoDroppedCount: %d, videoMaxConsecutiveDroppedCount: %d", new Object[] { paramString, parama, Boolean.valueOf(com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().pvr), Integer.valueOf(this.pOe.pDV), Long.valueOf(this.pOe.pOh), this.pOe.videoPath, Long.valueOf(this.pOe.pOi), Long.valueOf(this.pOe.duration), Long.valueOf(this.pOe.pOl), Integer.valueOf(this.pOe.pOm), Long.valueOf(this.pOe.pOn), Integer.valueOf(this.pOe.pOs), Integer.valueOf(this.pOe.pOt), this.pOe.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.pOe.pOu.pAJ), Boolean.valueOf(this.pOe.pOu.pAK), Boolean.valueOf(this.pOe.pOu.useCronet), Boolean.valueOf(this.pOe.pOu.pAL), Integer.valueOf(this.pOe.pOv), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8) });
      i9 = this.pOe.pDV;
      parame1 = this.pOe.videoPath;
      l1 = this.pOe.pOl;
      l2 = this.pOe.duration;
      l3 = this.pOe.pOi;
      i10 = this.pOe.pOs;
      i11 = this.pOe.pOt;
      paramString = this.pOe.errorMsg;
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().pvr) {
        break label1048;
      }
      m = 1;
      i12 = this.pOe.pOm;
      l4 = this.pOe.pOn;
      l5 = this.pOe.pOh;
      l6 = this.pOe.pOj;
      l7 = this.pOe.pOk;
      l8 = this.pOe.pOq;
      l9 = this.pOe.pOr;
      i13 = this.pOe.pOu.pAJ;
      if (!this.pOe.pOu.pAK) {
        break label1054;
      }
      n = 1;
      if (!this.pOe.pOu.useCronet) {
        break label1060;
      }
      i1 = 1;
      label709:
      if (!this.pOe.pOu.pAL) {
        break label1066;
      }
    }
    label1030:
    label1036:
    label1042:
    label1048:
    label1054:
    label1060:
    label1066:
    for (int i2 = 1;; i2 = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(i9), parame1, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i10), Integer.valueOf(i11), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i12), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i13), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(this.pOe.pOv), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8) });
      this.pOe.reset();
      AppMethodBeat.o(223372);
      return;
      parama = "";
      break;
      i = 0;
      break label70;
      j = 0;
      break label86;
      k = 0;
      break label102;
      m = 0;
      break label602;
      n = 0;
      break label693;
      i1 = 0;
      break label709;
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame1, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(223316);
    if ((parame1 != null) && (parame != null))
    {
      parame.c(1234L, 65L, 1L);
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!(parame1 instanceof g)) {
        break label147;
      }
      parame.c(1234L, 75L, 1L);
      if (!(parame1 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i)) {
        break label264;
      }
      if (!Util.isNullOrNil(paramString))
      {
        if (!paramString.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
          break label194;
        }
        parame.c(1234L, 72L, 1L);
      }
    }
    label264:
    for (;;)
    {
      this.pOe.pOs = paramInt1;
      this.pOe.pOt = paramInt2;
      this.pOe.errorMsg = paramString;
      AppMethodBeat.o(223316);
      return;
      label147:
      if (h(parame1))
      {
        parame.c(1234L, 109L, 1L);
        break;
      }
      if (!(parame1 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i)) {
        break;
      }
      parame.c(1234L, 70L, 1L);
      break;
      label194:
      if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
      {
        parame.c(1234L, 73L, 1L);
      }
      else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
      {
        parame.c(1234L, 71L, 1L);
      }
      else
      {
        parame.c(1234L, 74L, 1L);
        continue;
        c localc = eJ(paramInt1, paramInt2);
        if (localc != null) {
          switch (2.pOg[localc.ordinal()])
          {
          default: 
            break;
          case 1: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 116L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 125L, 1L);
            }
            break;
          case 2: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 117L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 126L, 1L);
            }
            break;
          case 3: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 118L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 127L, 1L);
            }
            break;
          case 4: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 119L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 128L, 1L);
            }
            break;
          case 5: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 120L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 129L, 1L);
            }
            break;
          case 6: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 121L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 130L, 1L);
            }
            break;
          case 7: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 122L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 131L, 1L);
            }
            break;
          case 8: 
            if ((parame1 instanceof g)) {
              parame.c(1234L, 123L, 1L);
            } else if (h(parame1)) {
              parame.c(1234L, 132L, 1L);
            }
            break;
          }
        }
      }
    }
  }
  
  protected c eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223299);
    c localc = c.eJ(paramInt1, paramInt2);
    AppMethodBeat.o(223299);
    return localc;
  }
  
  public boolean h(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    return false;
  }
  
  public final class a
  {
    public long duration = 0L;
    String errorMsg = "";
    public int pDV = 0;
    public long pOh = 0L;
    public long pOi = 0L;
    public long pOj = 0L;
    public long pOk = 0L;
    public long pOl = 0L;
    public int pOm = 0;
    public long pOn = 0L;
    public long pOo = 0L;
    public long pOp = 0L;
    public long pOq = 0L;
    public long pOr = 0L;
    int pOs = 0;
    int pOt = 0;
    public a.b pOu = a.b.pAI;
    int pOv = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.pDV = 0;
      this.pOh = 0L;
      this.duration = 0L;
      this.pOi = 0L;
      this.pOj = 0L;
      this.pOk = 0L;
      this.pOl = 0L;
      this.pOm = 0;
      this.pOo = 0L;
      this.pOp = 0L;
      this.pOn = 0L;
      this.pOq = 0L;
      this.pOr = 0L;
      this.pOs = 0;
      this.pOt = 0;
      this.errorMsg = "";
      this.pOu = a.b.pAI;
      this.pOv = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a
 * JD-Core Version:    0.7.0.1
 */