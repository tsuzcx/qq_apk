package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b
{
  int iiL;
  a iiM;
  private b.a iiN;
  private ap iiO;
  
  public b()
  {
    AppMethodBeat.i(140076);
    this.iiL = 0;
    this.iiO = new ap(new b.2(this), true);
    AppMethodBeat.o(140076);
  }
  
  public final void a(b.a parama)
  {
    this.iiN = parama;
  }
  
  public final void a(a parama)
  {
    this.iiM = parama;
  }
  
  final void aGv()
  {
    AppMethodBeat.i(117371);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "reset error count");
    this.iiL = 0;
    AppMethodBeat.o(117371);
  }
  
  public final void bL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117370);
    this.iiL += 1;
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d), error count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.iiL) });
    if (this.iiL >= 5)
    {
      aGv();
      if (this.iiN != null)
      {
        b.a locala = this.iiN;
        String str;
        if (paramInt1 == -1024) {
          str = "VIDEO_ERROR";
        }
        for (;;)
        {
          locala.f(str, paramInt1, paramInt2);
          AppMethodBeat.o(117370);
          return;
          if (paramInt1 == -1010) {
            str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
          } else if (paramInt1 == -1007) {
            str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
          } else if (paramInt1 == -1004)
          {
            if (!at.isConnected(ah.getContext())) {
              str = "MEDIA_ERR_NETWORK";
            } else {
              str = "MEDIA_ERR_DECODE";
            }
          }
          else if (!at.isConnected(ah.getContext())) {
            str = "MEDIA_ERR_NETWORK";
          } else {
            str = "MEDIA_ERR_DECODE";
          }
        }
      }
    }
    else
    {
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117365);
          ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "retry play video, error count:%d", new Object[] { Integer.valueOf(b.this.iiL) });
          if (b.this.iiM != null)
          {
            a locala = b.this.iiM;
            if (locala.bHu != null) {
              if (locala.bHG)
              {
                ab.i(locala.xo(), "retry when error, video has prepared");
                locala.pause();
                if (locala.bHu != null)
                {
                  int i = locala.bHu.getCurrentPosition();
                  locala.bHA = true;
                  locala.seek(i);
                  AppMethodBeat.o(117365);
                }
              }
              else
              {
                ab.i(locala.xo(), "retry when error, video has not prepared");
                locala.prepareAsync();
              }
            }
          }
          AppMethodBeat.o(117365);
        }
      }, 200L);
    }
    AppMethodBeat.o(117370);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(117369);
    if (this.iiO != null)
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "stop error check timer");
      this.iiO.stopTimer();
    }
    AppMethodBeat.o(117369);
  }
  
  public final void init()
  {
    AppMethodBeat.i(117368);
    if ((this.iiL > 0) && (this.iiO != null))
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "start error check timer");
      this.iiO.ag(5000L, 5000L);
    }
    AppMethodBeat.o(117368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.b
 * JD-Core Version:    0.7.0.1
 */