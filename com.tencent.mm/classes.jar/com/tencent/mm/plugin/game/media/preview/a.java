package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements f
{
  private MMVideoView IBd;
  private String IBe;
  private a IBf;
  boolean idO;
  
  public a(MMVideoView paramMMVideoView)
  {
    AppMethodBeat.i(41228);
    this.IBf = new a((byte)0);
    this.IBd = paramMMVideoView;
    AppMethodBeat.o(41228);
  }
  
  private static h a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(41233);
    h localh = new h();
    localh.taskName = "task_GameOnlineVideoProxy";
    localh.field_mediaId = paramString1;
    localh.url = paramString2;
    localh.lxi = 1;
    localh.lxc = 3;
    localh.concurrentCount = 4;
    localh.field_fullpath = paramString3;
    localh.lxs = parama;
    AppMethodBeat.o(41233);
    return localh;
  }
  
  public final void a(f.a parama) {}
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(41232);
    Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.nullAsNil(this.IBe).equals(paramString)) {
      bool = v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41232);
    return bool;
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(41230);
    Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (Util.nullAsNil(this.IBe).equals(paramString)) {
      v.bOi().l(paramString, null);
    }
    AppMethodBeat.o(41230);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41231);
    Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.nullAsNil(this.IBe).equals(paramString))
    {
      v.bOi();
      j.v(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41231);
  }
  
  public final void w(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(41229);
    Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    this.IBe = paramString1;
    if (this.idO)
    {
      this.idO = false;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41219);
          v.bOi().a(a.b(paramString1, paramString3, paramString2, a.a(a.this)), false);
          AppMethodBeat.o(41219);
        }
      }, 1000L);
      AppMethodBeat.o(41229);
      return;
    }
    v.bOi().a(a(paramString1, paramString3, paramString2, this.IBf), false);
    AppMethodBeat.o(41229);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
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
            a.b(a.this).bb(paramString, paramInt);
          }
          AppMethodBeat.o(41223);
        }
      });
      AppMethodBeat.o(41227);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(276871);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41220);
          if (a.b(a.this) != null) {
            a.b(a.this).jb(paramLong1);
          }
          AppMethodBeat.o(41220);
        }
      });
      AppMethodBeat.o(276871);
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
            a.b(a.this).h(paramString, paramLong1, this.IAr);
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
            a.b(a.this).onDataAvailable(paramString, paramLong1, this.IBh);
          }
          AppMethodBeat.o(41221);
        }
      });
      AppMethodBeat.o(41225);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.a
 * JD-Core Version:    0.7.0.1
 */