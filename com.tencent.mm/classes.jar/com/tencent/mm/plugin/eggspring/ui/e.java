package com.tencent.mm.plugin.eggspring.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.d.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "videoView", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "url", "", "(Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "value", "", "mute", "setMute", "(Z)V", "playDuration", "", "playStartTime", "uiHandler", "Landroid/os/Handler;", "videoDuration", "getVideoDuration", "()J", "setVideoDuration", "(J)V", "videoMediaId", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "path", "isVideoDataAvailable", "offset", "length", "onDataAvailable", "", "onDownloadFinish", "isPlayNow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onM3U8Ready", "p0", "p1", "onMoovReady", "svrflag", "onPrepared", "onProgress", "total", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "pause", "release", "requestVideoData", "resume", "setIEngineCallback", "callback", "start", "startHttpStream", "stop", "totalDuration", "Companion", "plugin-eggspring_release"})
public final class e
  implements h.a, f, i.a, i.b
{
  public static final e.a uza;
  private final Handler cQo;
  int count;
  private boolean lhf;
  long playDuration;
  long sTg;
  final SpringEggVideoView uyF;
  private f.a uyX;
  String uyY;
  long uyZ;
  final c uyf;
  
  static
  {
    AppMethodBeat.i(249563);
    uza = new e.a((byte)0);
    AppMethodBeat.o(249563);
  }
  
  public e(SpringEggVideoView paramSpringEggVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(249561);
    this.uyF = paramSpringEggVideoView;
    this.uyf = paramc;
    this.cQo = new Handler(Looper.getMainLooper());
    this.lhf = true;
    this.uyF.setLoop(true);
    this.uyF.setIMMVideoViewCallback((i.b)this);
    this.uyF.setIMMDownloadFinish((i.a)this);
    this.uyF.setIOnlineVideoProxy((f)this);
    this.uyF.c(false, paramString, 0);
    this.uyF.setFilepath(PluginEggSpring.uwL + "MMVideo_" + paramString.hashCode() + ".mp4.temp");
    this.uyf.uyG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249667);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.uzb;
        if (!e.b(this.uzb)) {}
        for (boolean bool = true;; bool = false)
        {
          e.a(paramAnonymousView, bool);
          a.a(this, "com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249667);
          return;
        }
      }
    });
    AppMethodBeat.o(249561);
  }
  
  public final void Kj(String paramString) {}
  
  public final void a(f.a parama)
  {
    this.uyX = parama;
  }
  
  public final void a(final String paramString, final int paramInt, d paramd)
  {
    AppMethodBeat.i(249560);
    p.k(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.uyX != null) && (this.uyY != null) && (p.h(this.uyY, paramString))) {
      this.cQo.post((Runnable)new c(this, paramString, paramInt));
    }
    AppMethodBeat.o(249560);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(249556);
    p.k(paramString1, "mediaId");
    Log.i("MicroMsg.VideoController", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.uyX != null) && (this.uyY != null) && (p.h(this.uyY, paramString1))) {
      this.cQo.post((Runnable)new d(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(249556);
  }
  
  public final void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249546);
    if (paramString != null)
    {
      String str = n.l(paramString, ".temp", "", false);
      if ((!u.agG(str)) && (n.pu(paramString, ".temp"))) {
        u.on(paramString, str);
      }
      AppMethodBeat.o(249546);
      return;
    }
    AppMethodBeat.o(249546);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249536);
    Log.i("MicroMsg.VideoController", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    this.uyf.uyB.setVisibility(0);
    this.uyF.setVisibility(8);
    this.uyf.uyG.setVisibility(8);
    this.playDuration += Util.milliSecondsToNow(this.uyZ);
    this.uyZ = 0L;
    AppMethodBeat.o(249536);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249539);
    Log.i("MicroMsg.VideoController", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249539);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249537);
    Log.i("MicroMsg.VideoController", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    this.uyZ = Util.nowMilliSecond();
    this.sTg = (this.uyF.getVideoDurationSec() * 1000L);
    AppMethodBeat.o(249537);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249538);
    Log.i("MicroMsg.VideoController", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249538);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249540);
    Log.i("MicroMsg.VideoController", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249540);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249541);
    Log.i("MicroMsg.VideoController", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(this.uyF.getVideoDurationSec()) });
    this.count += 1;
    AppMethodBeat.o(249541);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249542);
    Log.i("MicroMsg.VideoController", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249542);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249543);
    Log.i("MicroMsg.VideoController", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249543);
  }
  
  public final void fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249544);
    Log.i("MicroMsg.VideoController", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(249544);
  }
  
  public final void h(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(249559);
    p.k(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.uyX != null) && (this.uyY != null) && (p.h(this.uyY, paramString))) {
      this.cQo.post((Runnable)new e(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(249559);
  }
  
  public final void hR(String paramString)
  {
    AppMethodBeat.i(249551);
    p.k(paramString, "mediaId");
    Log.w("MicroMsg.VideoController", "stop ".concat(String.valueOf(paramString)));
    String str = this.uyY;
    if (str != null)
    {
      if (p.h(str, paramString)) {
        s.bqC().l(paramString, null);
      }
      AppMethodBeat.o(249551);
      return;
    }
    AppMethodBeat.o(249551);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(249553);
    Log.i("MicroMsg.VideoController", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.uyY;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (p.h(str, paramString)) {
        bool1 = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(249553);
    return bool1;
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(249557);
    p.k(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.uyX != null) && (this.uyY != null) && (p.h(this.uyY, paramString))) {
      this.cQo.post((Runnable)new b(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(249557);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249552);
    String str = this.uyY;
    if (str != null)
    {
      if (p.h(str, paramString))
      {
        Log.w("MicroMsg.VideoController", "requestVideoData offset=" + paramInt1 + ", length=" + paramInt2);
        s.bqC();
        com.tencent.mm.aq.e.s(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(249552);
      return;
    }
    AppMethodBeat.o(249552);
  }
  
  public final void s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(249548);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "path");
    p.k(paramString3, "url");
    this.uyY = paramString1;
    if (u.agG(PluginEggSpring.uwL + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(249548);
      return;
    }
    com.tencent.mm.aq.e locale = s.bqC();
    h localh = new h();
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.iVd = 1;
    localh.iUX = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.iVn = ((h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(249548);
  }
  
  final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(249535);
    this.lhf = paramBoolean;
    this.uyF.setMute(paramBoolean);
    WeImageView localWeImageView = this.uyf.uyG;
    if (paramBoolean) {}
    for (int i = d.g.icon_volume_off;; i = d.g.icon_volume_on)
    {
      localWeImageView.setImageResource(i);
      AppMethodBeat.o(249535);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(249516);
      f.a locala = e.a(this.uzb);
      if (locala == null) {
        p.iCn();
      }
      locala.onDataAvailable(paramString, paramLong1, this.pBP);
      AppMethodBeat.o(249516);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(249334);
      f.a locala = e.a(this.uzb);
      if (locala == null) {
        p.iCn();
      }
      locala.aP(paramString, paramInt);
      AppMethodBeat.o(249334);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(249264);
      f.a locala = e.a(this.uzb);
      if (locala == null) {
        p.iCn();
      }
      locala.GQ(paramLong1);
      AppMethodBeat.o(249264);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(e parame, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(249360);
      f.a locala = e.a(this.uzb);
      if (locala == null) {
        p.iCn();
      }
      locala.h(paramString, paramLong1, this.uze);
      AppMethodBeat.o(249360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.e
 * JD-Core Version:    0.7.0.1
 */