package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  implements b
{
  boolean dLQ;
  MMVideoView ukA;
  private String ukB;
  a.a ukC;
  
  public a(MMVideoView paramMMVideoView)
  {
    AppMethodBeat.i(41228);
    this.ukC = new a.a(this, (byte)0);
    this.ukA = paramMMVideoView;
    AppMethodBeat.o(41228);
  }
  
  static h a(String paramString1, String paramString2, String paramString3, a.a parama)
  {
    AppMethodBeat.i(41233);
    h localh = new h();
    localh.fLl = "task_GameOnlineVideoProxy";
    localh.field_mediaId = paramString1;
    localh.url = paramString2;
    localh.fLI = 1;
    localh.fLD = 3;
    localh.concurrentCount = 4;
    localh.field_fullpath = paramString3;
    localh.fLQ = parama;
    AppMethodBeat.o(41233);
    return localh;
  }
  
  public final void a(b.a parama) {}
  
  public final void gp(String paramString)
  {
    AppMethodBeat.i(41230);
    ae.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bu.nullAsNil(this.ukB).equals(paramString)) {
      o.aNi().m(paramString, null);
    }
    AppMethodBeat.o(41230);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(41232);
    ae.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bu.nullAsNil(this.ukB).equals(paramString)) {
      bool = o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41232);
    return bool;
  }
  
  public final void p(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(41229);
    ae.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    this.ukB = paramString1;
    if (this.dLQ)
    {
      this.dLQ = false;
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41219);
          o.aNi().a(a.a(paramString1, paramString3, paramString2, a.this.ukC), false);
          AppMethodBeat.o(41219);
        }
      }, 1000L);
      AppMethodBeat.o(41229);
      return;
    }
    o.aNi().a(a(paramString1, paramString3, paramString2, this.ukC), false);
    AppMethodBeat.o(41229);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41231);
    ae.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bu.nullAsNil(this.ukB).equals(paramString))
    {
      o.aNi();
      e.r(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.a
 * JD-Core Version:    0.7.0.1
 */