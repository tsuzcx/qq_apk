package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements f
{
  int gHq = 0;
  com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c gHr;
  private f.a gHs;
  private am gHt = new am(new a.2(this), true);
  c wuF;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c paramc, f.a parama, c paramc1)
  {
    this.gHr = paramc;
    this.gHs = parama;
    this.wuF = paramc1;
  }
  
  final void als()
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "reset error count");
    this.gHq = 0;
  }
  
  public final void cb(int paramInt1, int paramInt2)
  {
    this.gHq += 1;
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d), error count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gHq) });
    if (this.gHq >= 5)
    {
      als();
      if (this.gHs != null)
      {
        locala = this.gHs;
        if (paramInt1 != -1024) {
          break label91;
        }
        str = "VIDEO_ERROR";
        locala.G(str, paramInt1, paramInt2);
      }
    }
    label91:
    while (this.gHr == null) {
      for (;;)
      {
        f.a locala;
        String str;
        return;
        if (paramInt1 == -1010) {
          str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
        } else if (paramInt1 == -1007) {
          str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
        } else if (paramInt1 == -1004)
        {
          if (!aq.isConnected(ae.getContext())) {
            str = "MEDIA_ERR_NETWORK";
          } else {
            str = "MEDIA_ERR_DECODE";
          }
        }
        else if (!aq.isConnected(ae.getContext())) {
          str = "MEDIA_ERR_NETWORK";
        } else {
          str = "MEDIA_ERR_DECODE";
        }
      }
    }
    ai.l(new a.1(this, this.gHr.isPlaying(), this.gHr.getCurrentPosition()), 200L);
  }
  
  public final void destroy()
  {
    if (this.gHt != null)
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "stop error check timer");
      this.gHt.stopTimer();
    }
  }
  
  public final void init()
  {
    if ((this.gHq > 0) && (this.gHt != null))
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "start error check timer");
      this.gHt.S(5000L, 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.a
 * JD-Core Version:    0.7.0.1
 */