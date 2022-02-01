package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  implements b
{
  boolean dAC;
  MMVideoView rTQ;
  private String rTR;
  a.a rTS;
  
  public a(MMVideoView paramMMVideoView)
  {
    AppMethodBeat.i(41228);
    this.rTS = new a.a(this, (byte)0);
    this.rTQ = paramMMVideoView;
    AppMethodBeat.o(41228);
  }
  
  static h a(String paramString1, String paramString2, String paramString3, a.a parama)
  {
    AppMethodBeat.i(41233);
    h localh = new h();
    localh.field_mediaId = paramString1;
    localh.url = paramString2;
    localh.foc = 1;
    localh.fnX = 3;
    localh.concurrentCount = 4;
    localh.field_fullpath = paramString3;
    localh.foj = parama;
    AppMethodBeat.o(41233);
    return localh;
  }
  
  public final void a(b.a parama) {}
  
  public final void fy(String paramString)
  {
    AppMethodBeat.i(41230);
    ad.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bt.nullAsNil(this.rTR).equals(paramString)) {
      o.aCJ().k(paramString, null);
    }
    AppMethodBeat.o(41230);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(41232);
    ad.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bt.nullAsNil(this.rTR).equals(paramString)) {
      bool = o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41232);
    return bool;
  }
  
  public final void q(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(41229);
    ad.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    this.rTR = paramString1;
    if (this.dAC)
    {
      this.dAC = false;
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41219);
          o.aCJ().a(a.a(paramString1, paramString3, paramString2, a.this.rTS), false);
          AppMethodBeat.o(41219);
        }
      }, 1000L);
      AppMethodBeat.o(41229);
      return;
    }
    o.aCJ().a(a(paramString1, paramString3, paramString2, this.rTS), false);
    AppMethodBeat.o(41229);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41231);
    ad.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bt.nullAsNil(this.rTR).equals(paramString))
    {
      o.aCJ();
      e.q(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.a
 * JD-Core Version:    0.7.0.1
 */