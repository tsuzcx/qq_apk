package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.s.b;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.dash.f.a;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.IOException;

public final class b
  implements d
{
  private com.google.android.exoplayer2.source.j aRt;
  Handler azU;
  private Context context;
  v rdN;
  e rdO;
  private l rdP;
  boolean rdQ;
  a rdR;
  protected String userAgent;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(148900);
    this.rdR = new a((byte)0);
    this.azU = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148895);
        if (100 == paramAnonymousMessage.what)
        {
          ad.d("MicroMsg.FlutterExoVideoPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(b.this.rdN.getDuration()), Long.valueOf(b.this.rdN.getCurrentPosition()), Long.valueOf(b.this.rdN.getBufferedPosition()), Long.valueOf(b.this.rdN.getBufferedPercentage()) });
          b.this.azU.removeMessages(100);
          if (b.this.rdQ) {
            b.this.azU.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(148895);
      }
    };
    this.context = paramContext;
    paramContext = new com.google.android.exoplayer2.g.c();
    this.rdN = g.a(this.context, paramContext);
    this.rdN.a(new q.a()
    {
      public final void a(com.google.android.exoplayer2.e paramAnonymouse)
      {
        AppMethodBeat.i(148893);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onPlayerError ");
        AppMethodBeat.o(148893);
      }
      
      public final void aA(int paramAnonymousInt)
      {
        AppMethodBeat.i(148892);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onRepeatModeChanged ");
        AppMethodBeat.o(148892);
      }
      
      public final void aR(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(148890);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onLoadingChanged ");
        AppMethodBeat.o(148890);
      }
      
      public final void b(com.google.android.exoplayer2.p paramAnonymousp)
      {
        AppMethodBeat.i(148894);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onPlaybackParametersChanged ");
        AppMethodBeat.o(148894);
      }
      
      public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(148891);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onPlayerStateChanged ");
        if ((paramAnonymousInt == 3) && (b.this.rdO != null)) {
          b.this.rdO.e(true, 3);
        }
        AppMethodBeat.o(148891);
      }
      
      public final void rJ()
      {
        AppMethodBeat.i(148888);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onTimelineChanged ");
        AppMethodBeat.o(148888);
      }
      
      public final void rK()
      {
        AppMethodBeat.i(148889);
        ad.d("MicroMsg.FlutterExoVideoPlayer", "onTracksChanged ");
        AppMethodBeat.o(148889);
      }
      
      public final void rL() {}
    });
    AppMethodBeat.o(148900);
  }
  
  private g.a cuO()
  {
    AppMethodBeat.i(148902);
    n localn = new n(aj.getContext(), null, cuP());
    AppMethodBeat.o(148902);
    return localn;
  }
  
  private s.b cuP()
  {
    AppMethodBeat.i(148903);
    com.google.android.exoplayer2.h.p localp = new com.google.android.exoplayer2.h.p(this.userAgent, this.rdP);
    AppMethodBeat.o(148903);
    return localp;
  }
  
  public final void a(e parame)
  {
    this.rdO = parame;
  }
  
  public final boolean cuQ()
  {
    AppMethodBeat.i(148905);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "prepare");
    this.rdN.a(this.aRt);
    AppMethodBeat.o(148905);
    return false;
  }
  
  public final long cuR()
  {
    AppMethodBeat.i(148911);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "getDurationMs");
    long l = this.rdN.getDuration();
    AppMethodBeat.o(148911);
    return l;
  }
  
  public final void cuS()
  {
    AppMethodBeat.i(148918);
    if (Build.VERSION.SDK_INT >= 21)
    {
      v localv = this.rdN;
      com.google.android.exoplayer2.a.b.a locala = new com.google.android.exoplayer2.a.b.a();
      locala.aTB = 3;
      localv.a(locala.rT());
      AppMethodBeat.o(148918);
      return;
    }
    this.rdN.rN();
    AppMethodBeat.o(148918);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(148917);
    int i = this.rdN.getBufferedPercentage();
    AppMethodBeat.o(148917);
    return i;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(148916);
    long l = this.rdN.getCurrentPosition();
    AppMethodBeat.o(148916);
    return l;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(148913);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "getWidth");
    Format localFormat = this.rdN.aSN;
    if (localFormat != null)
    {
      int i = localFormat.height;
      int j = localFormat.aSi;
      if ((j == 90) || (j == 270)) {
        i = this.rdN.aSN.width;
      }
      AppMethodBeat.o(148913);
      return i;
    }
    AppMethodBeat.o(148913);
    return 0;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(148912);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "getWidth");
    Format localFormat = this.rdN.aSN;
    if (localFormat != null)
    {
      int i = localFormat.width;
      int j = localFormat.aSi;
      if ((j == 90) || (j == 270)) {
        i = this.rdN.aSN.height;
      }
      AppMethodBeat.o(148912);
      return i;
    }
    AppMethodBeat.o(148912);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(148907);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "pause");
    this.rdN.aO(false);
    AppMethodBeat.o(148907);
  }
  
  public final void release()
  {
    AppMethodBeat.i(148910);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "release");
    this.rdN.release();
    AppMethodBeat.o(148910);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(148908);
    this.rdN.seekTo(paramInt);
    AppMethodBeat.o(148908);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(148914);
    if (paramBoolean) {
      this.rdN.setRepeatMode(2);
    }
    AppMethodBeat.o(148914);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(148901);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "setPath %s", new Object[] { paramString });
    Uri localUri = Uri.parse(paramString);
    if ((localUri.getScheme().equals("asset")) || (localUri.getScheme().equals("file"))) {}
    for (paramString = new n(this.context, "ExoPlayer");; paramString = new com.google.android.exoplayer2.h.p("ExoPlayer", null, true))
    {
      int i = x.ba(localUri.getLastPathSegment());
      switch (i)
      {
      default: 
        paramString = new IllegalStateException("Unsupported type: ".concat(String.valueOf(i)));
        AppMethodBeat.o(148901);
        throw paramString;
      }
    }
    paramString = new com.google.android.exoplayer2.source.c.d(localUri, cuO(), new a.a(paramString), this.azU, this.rdR);
    for (;;)
    {
      this.aRt = paramString;
      AppMethodBeat.o(148901);
      return;
      paramString = new com.google.android.exoplayer2.source.dash.c(localUri, cuO(), new f.a(paramString), this.azU, this.rdR);
      continue;
      paramString = new com.google.android.exoplayer2.source.b.h(localUri, paramString, this.azU, this.rdR);
      continue;
      paramString = new com.google.android.exoplayer2.source.h(localUri, paramString, new com.google.android.exoplayer2.c.c(), this.azU, this.rdR);
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(148904);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "setSurface %s", new Object[] { Integer.valueOf(paramSurface.hashCode()) });
    this.rdN.c(paramSurface);
    AppMethodBeat.o(148904);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148906);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "start");
    this.rdN.aO(true);
    AppMethodBeat.o(148906);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(148909);
    ad.d("MicroMsg.FlutterExoVideoPlayer", "stop");
    this.rdN.stop();
    AppMethodBeat.o(148909);
  }
  
  public final void v(double paramDouble)
  {
    AppMethodBeat.i(148915);
    this.rdN.setVolume((float)paramDouble);
    AppMethodBeat.o(148915);
  }
  
  static final class a
    implements a, h.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(177446);
      if ((paramj != null) && (paramFormat != null)) {
        ad.e("MicroMsg.FlutterExoVideoPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      AppMethodBeat.o(177446);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177447);
      ad.d("MicroMsg.FlutterExoVideoPlayer", "onLoadCompleted");
      AppMethodBeat.o(177447);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(148898);
      ad.printErrStackTrace("MicroMsg.FlutterExoVideoPlayer", paramIOException, "onLoadError", new Object[0]);
      AppMethodBeat.o(148898);
    }
    
    public final void ty()
    {
      AppMethodBeat.i(148899);
      ad.d("MicroMsg.FlutterExoVideoPlayer", "onHasEndTag");
      AppMethodBeat.o(148899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.b
 * JD-Core Version:    0.7.0.1
 */