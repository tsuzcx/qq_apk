package com.tencent.mm.ak;

import com.tencent.mm.h.a.lf;
import com.tencent.mm.h.a.lf.a;
import com.tencent.mm.j.g;
import com.tencent.mm.j.g.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class e$5
  implements Runnable
{
  e$5(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    boolean bool = false;
    g localg = (g)this.ejo.eiI.get(this.BF);
    if (localg != null)
    {
      localg.dmm = this.ejr;
      if (localg.dmn == null) {
        break label64;
      }
      localg.dmn.onMoovReady(this.BF, this.ejr, this.ejs);
    }
    label64:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!r.nL(localg.field_fullpath)) {
              break;
            }
            y.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localg.dmg);
          } while (localg.dmg != 1);
          e.h(localg.field_mediaId, 0, localg.field_totalLen);
          h.nFQ.a(354L, 19L, 1L, false);
          return;
          localObject = new lf();
          ((lf)localObject).bUh.bNb = 1;
          ((lf)localObject).bUh.retCode = 0;
          ((lf)localObject).bUh.bUi = this.BF;
          ((lf)localObject).bUh.offset = this.ejr;
          ((lf)localObject).bUh.length = this.ejs;
          ((lf)localObject).bUh.bUj = localg.dmd;
          lf.a locala = ((lf)localObject).bUh;
          if (localg.initialDownloadLength > 0) {
            bool = true;
          }
          locala.bUk = bool;
          a.udP.m((b)localObject);
          localObject = u.oe(localg.filename);
        } while (localObject == null);
        y.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((s)localObject).getFileName() + " status : " + ((s)localObject).status);
      } while ((((s)localObject).status == 130) || (((s)localObject).status == 122));
      Object localObject = u.oe(localg.filename);
      if (localObject != null)
      {
        ((s)localObject).status = 121;
        ((s)localObject).bcw = 256;
        o.Sr().c((s)localObject);
      }
    } while (localg.dmg != 0);
    y.i("MicroMsg.OnlineVideoService", "stop download video");
    o.Sw().SN();
    o.Sw().run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.e.5
 * JD-Core Version:    0.7.0.1
 */