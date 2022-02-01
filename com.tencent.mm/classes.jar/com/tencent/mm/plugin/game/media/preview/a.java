package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  implements b
{
  boolean dyo;
  MMVideoView tbI;
  private String tbJ;
  a tbK;
  
  public a(MMVideoView paramMMVideoView)
  {
    AppMethodBeat.i(41228);
    this.tbK = new a((byte)0);
    this.tbI = paramMMVideoView;
    AppMethodBeat.o(41228);
  }
  
  static h a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(41233);
    h localh = new h();
    localh.field_mediaId = paramString1;
    localh.url = paramString2;
    localh.frw = 1;
    localh.frr = 3;
    localh.concurrentCount = 4;
    localh.field_fullpath = paramString3;
    localh.frE = parama;
    AppMethodBeat.o(41233);
    return localh;
  }
  
  public final void a(b.a parama) {}
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(41230);
    ac.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bs.nullAsNil(this.tbJ).equals(paramString)) {
      o.aJz().k(paramString, null);
    }
    AppMethodBeat.o(41230);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(41232);
    ac.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bs.nullAsNil(this.tbJ).equals(paramString)) {
      bool = o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41232);
    return bool;
  }
  
  public final void q(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(41229);
    ac.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    this.tbJ = paramString1;
    if (this.dyo)
    {
      this.dyo = false;
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41219);
          o.aJz().a(a.a(paramString1, paramString3, paramString2, a.this.tbK), false);
          AppMethodBeat.o(41219);
        }
      }, 1000L);
      AppMethodBeat.o(41229);
      return;
    }
    o.aJz().a(a(paramString1, paramString3, paramString2, this.tbK), false);
    AppMethodBeat.o(41229);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41231);
    ac.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bs.nullAsNil(this.tbJ).equals(paramString))
    {
      o.aJz();
      e.p(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41231);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
    public final void a(final String paramString, final int paramInt, d paramd)
    {
      AppMethodBeat.i(41227);
      ac.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onFinish[mediaId:%s, ret:%d]", new Object[] { Integer.valueOf(a.this.hashCode()), paramString, Integer.valueOf(paramInt) });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41223);
          if (a.this.tbI != null) {
            a.this.tbI.aq(paramString, paramInt);
          }
          AppMethodBeat.o(41223);
        }
      });
      AppMethodBeat.o(41227);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(199212);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41220);
          if (a.this.tbI != null) {
            a.this.tbI.qq(paramLong1);
          }
          AppMethodBeat.o(41220);
        }
      });
      AppMethodBeat.o(199212);
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(41226);
      ac.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onProgress[mediaId:%s, offset:%d, total:%d]", new Object[] { Integer.valueOf(a.this.hashCode()), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41222);
          if (a.this.tbI != null) {
            a.this.tbI.i(paramString, paramLong1, this.tbg);
          }
          AppMethodBeat.o(41222);
        }
      });
      AppMethodBeat.o(41226);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(41225);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41221);
          if (a.this.tbI != null) {
            a.this.tbI.onDataAvailable(paramString, paramLong1, this.kPh);
          }
          AppMethodBeat.o(41221);
        }
      });
      AppMethodBeat.o(41225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.a
 * JD-Core Version:    0.7.0.1
 */