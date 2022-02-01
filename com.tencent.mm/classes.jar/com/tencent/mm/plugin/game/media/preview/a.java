package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements f
{
  private MMVideoView CGT;
  private String CGU;
  private a CGV;
  boolean fXO;
  
  public a(MMVideoView paramMMVideoView)
  {
    AppMethodBeat.i(41228);
    this.CGV = new a((byte)0);
    this.CGT = paramMMVideoView;
    AppMethodBeat.o(41228);
  }
  
  private static h a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(41233);
    h localh = new h();
    localh.taskName = "task_GameOnlineVideoProxy";
    localh.field_mediaId = paramString1;
    localh.url = paramString2;
    localh.iVd = 1;
    localh.iUX = 3;
    localh.concurrentCount = 4;
    localh.field_fullpath = paramString3;
    localh.iVn = parama;
    AppMethodBeat.o(41233);
    return localh;
  }
  
  public final void a(f.a parama) {}
  
  public final void hR(String paramString)
  {
    AppMethodBeat.i(41230);
    Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (Util.nullAsNil(this.CGU).equals(paramString)) {
      s.bqC().l(paramString, null);
    }
    AppMethodBeat.o(41230);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(41232);
    Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.nullAsNil(this.CGU).equals(paramString)) {
      bool = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41232);
    return bool;
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41231);
    Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.nullAsNil(this.CGU).equals(paramString))
    {
      s.bqC();
      e.s(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41231);
  }
  
  public final void s(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(41229);
    Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    this.CGU = paramString1;
    if (this.fXO)
    {
      this.fXO = false;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41219);
          s.bqC().a(a.b(paramString1, paramString3, paramString2, a.a(a.this)), false);
          AppMethodBeat.o(41219);
        }
      }, 1000L);
      AppMethodBeat.o(41229);
      return;
    }
    s.bqC().a(a(paramString1, paramString3, paramString2, this.CGV), false);
    AppMethodBeat.o(41229);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
    public final void Kj(String paramString) {}
    
    public final void a(final String paramString, final int paramInt, d paramd)
    {
      AppMethodBeat.i(41227);
      Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onFinish[mediaId:%s, ret:%d]", new Object[] { Integer.valueOf(a.this.hashCode()), paramString, Integer.valueOf(paramInt) });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41223);
          if (a.b(a.this) != null) {
            a.b(a.this).aP(paramString, paramInt);
          }
          AppMethodBeat.o(41223);
        }
      });
      AppMethodBeat.o(41227);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(190867);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41220);
          if (a.b(a.this) != null) {
            a.b(a.this).GQ(paramLong1);
          }
          AppMethodBeat.o(41220);
        }
      });
      AppMethodBeat.o(190867);
    }
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(41226);
      Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onProgress[mediaId:%s, offset:%d, total:%d]", new Object[] { Integer.valueOf(a.this.hashCode()), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41222);
          if (a.b(a.this) != null) {
            a.b(a.this).h(paramString, paramLong1, this.CGr);
          }
          AppMethodBeat.o(41222);
        }
      });
      AppMethodBeat.o(41226);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(41225);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41221);
          if (a.b(a.this) != null) {
            a.b(a.this).onDataAvailable(paramString, paramLong1, this.CGX);
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