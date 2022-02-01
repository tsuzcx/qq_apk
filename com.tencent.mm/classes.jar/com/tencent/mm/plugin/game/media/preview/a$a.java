package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class a$a
  implements h.a
{
  private a$a(a parama) {}
  
  public final void a(final String paramString, final int paramInt, d paramd)
  {
    AppMethodBeat.i(41227);
    ad.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onFinish[mediaId:%s, ret:%d]", new Object[] { Integer.valueOf(this.rTT.hashCode()), paramString, Integer.valueOf(paramInt) });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41223);
        if (a.a.this.rTT.rTQ != null) {
          a.a.this.rTT.rTQ.am(paramString, paramInt);
        }
        AppMethodBeat.o(41223);
      }
    });
    AppMethodBeat.o(41227);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(204997);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41220);
        if (a.a.this.rTT.rTQ != null) {
          a.a.this.rTT.rTQ.Bl(paramLong1);
        }
        AppMethodBeat.o(41220);
      }
    });
    AppMethodBeat.o(204997);
  }
  
  public final void k(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41226);
    ad.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onProgress[mediaId:%s, offset:%d, total:%d]", new Object[] { Integer.valueOf(this.rTT.hashCode()), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41222);
        if (a.a.this.rTT.rTQ != null) {
          a.a.this.rTT.rTQ.k(paramString, paramLong1, this.rTo);
        }
        AppMethodBeat.o(41222);
      }
    });
    AppMethodBeat.o(41226);
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41225);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41221);
        if (a.a.this.rTT.rTQ != null) {
          a.a.this.rTT.rTQ.onDataAvailable(paramString, paramLong1, this.knN);
        }
        AppMethodBeat.o(41221);
      }
    });
    AppMethodBeat.o(41225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.a.a
 * JD-Core Version:    0.7.0.1
 */