package com.tencent.mm.plugin.eggspring.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "videoView", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "url", "", "(Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "value", "", "mute", "setMute", "(Z)V", "playDuration", "", "playStartTime", "uiHandler", "Landroid/os/Handler;", "videoDuration", "getVideoDuration", "()J", "setVideoDuration", "(J)V", "videoMediaId", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "path", "isVideoDataAvailable", "offset", "length", "onDataAvailable", "", "onDownloadFinish", "isPlayNow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onM3U8Ready", "p0", "p1", "onMoovReady", "svrflag", "onPrepared", "onProgress", "total", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "pause", "release", "requestVideoData", "resume", "setIEngineCallback", "callback", "start", "startHttpStream", "stop", "totalDuration", "Companion", "plugin-eggspring_release"})
public final class d
  implements h.a, b, i.a, i.b
{
  public static final d.a qWq;
  private final Handler cPw;
  int count;
  private boolean isb;
  long pLQ;
  long playDuration;
  final SpringEggVideoView qVU;
  final c qVv;
  private b.a qWn;
  String qWo;
  long qWp;
  
  static
  {
    AppMethodBeat.i(194671);
    qWq = new d.a((byte)0);
    AppMethodBeat.o(194671);
  }
  
  public d(SpringEggVideoView paramSpringEggVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(194670);
    this.qVU = paramSpringEggVideoView;
    this.qVv = paramc;
    this.cPw = new Handler(Looper.getMainLooper());
    this.isb = true;
    this.qVU.setLoop(true);
    this.qVU.setIMMVideoViewCallback((i.b)this);
    this.qVU.setIMMDownloadFinish((i.a)this);
    this.qVU.setIOnlineVideoProxy((b)this);
    this.qVU.c(false, paramString, 0);
    this.qVU.setFilepath(PluginEggSpring.qUF + "MMVideo_" + paramString.hashCode() + ".mp4.temp");
    this.qVv.qVV.setOnClickListener((View.OnClickListener)new d.1(this));
    AppMethodBeat.o(194670);
  }
  
  public final void Ds(String paramString) {}
  
  public final void a(b.a parama)
  {
    this.qWn = parama;
  }
  
  public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(194669);
    p.h(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.qWn != null) && (this.qWo != null) && (p.j(this.qWo, paramString))) {
      this.cPw.post((Runnable)new c(this, paramString, paramInt));
    }
    AppMethodBeat.o(194669);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(194666);
    p.h(paramString1, "mediaId");
    Log.i("MicroMsg.VideoController", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.qWn != null) && (this.qWo != null) && (p.j(this.qWo, paramString1))) {
      this.cPw.post((Runnable)new d(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(194666);
  }
  
  public final void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(194661);
    if (paramString != null)
    {
      String str = n.j(paramString, ".temp", "", false);
      if ((!s.YS(str)) && (n.K(paramString, ".temp", false))) {
        s.nw(paramString, str);
      }
      AppMethodBeat.o(194661);
      return;
    }
    AppMethodBeat.o(194661);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194652);
    Log.i("MicroMsg.VideoController", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    this.qVv.qVQ.setVisibility(0);
    this.qVU.setVisibility(8);
    this.qVv.qVV.setVisibility(8);
    this.playDuration += Util.milliSecondsToNow(this.qWp);
    this.qWp = 0L;
    AppMethodBeat.o(194652);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194655);
    Log.i("MicroMsg.VideoController", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194655);
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194653);
    Log.i("MicroMsg.VideoController", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    this.qWp = Util.nowMilliSecond();
    this.pLQ = (this.qVU.getVideoDurationSec() * 1000L);
    AppMethodBeat.o(194653);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194654);
    Log.i("MicroMsg.VideoController", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194654);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194656);
    Log.i("MicroMsg.VideoController", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194656);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194657);
    Log.i("MicroMsg.VideoController", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(this.qVU.getVideoDurationSec()) });
    this.count += 1;
    AppMethodBeat.o(194657);
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194658);
    Log.i("MicroMsg.VideoController", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194658);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194659);
    Log.i("MicroMsg.VideoController", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194659);
  }
  
  public final void fo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194660);
    Log.i("MicroMsg.VideoController", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(194660);
  }
  
  public final void he(String paramString)
  {
    AppMethodBeat.i(194663);
    p.h(paramString, "mediaId");
    Log.w("MicroMsg.VideoController", "stop ".concat(String.valueOf(paramString)));
    String str = this.qWo;
    if (str != null)
    {
      if (p.j(str, paramString)) {
        o.bhk().m(paramString, null);
      }
      AppMethodBeat.o(194663);
      return;
    }
    AppMethodBeat.o(194663);
  }
  
  public final void i(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194668);
    p.h(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.qWn != null) && (this.qWo != null) && (p.j(this.qWo, paramString))) {
      this.cPw.post((Runnable)new e(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(194668);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(194665);
    Log.i("MicroMsg.VideoController", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.qWo;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (p.j(str, paramString)) {
        bool1 = o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(194665);
    return bool1;
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194667);
    p.h(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.qWn != null) && (this.qWo != null) && (p.j(this.qWo, paramString))) {
      this.cPw.post((Runnable)new b(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(194667);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194662);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "path");
    p.h(paramString3, "url");
    this.qWo = paramString1;
    if (s.YS(PluginEggSpring.qUF + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(194662);
      return;
    }
    e locale = o.bhk();
    h localh = new h();
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.gqU = 1;
    localh.gqP = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.gre = ((h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(194662);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194664);
    String str = this.qWo;
    if (str != null)
    {
      if (p.j(str, paramString))
      {
        Log.w("MicroMsg.VideoController", "requestVideoData offset=" + paramInt1 + ", length=" + paramInt2);
        o.bhk();
        e.r(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(194664);
      return;
    }
    AppMethodBeat.o(194664);
  }
  
  final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194651);
    this.isb = paramBoolean;
    this.qVU.setMute(paramBoolean);
    WeImageView localWeImageView = this.qVv.qVV;
    if (paramBoolean) {}
    for (int i = 2131690469;; i = 2131690470)
    {
      localWeImageView.setImageResource(i);
      AppMethodBeat.o(194651);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(194647);
      b.a locala = d.a(this.qWr);
      if (locala == null) {
        p.hyc();
      }
      locala.onDataAvailable(paramString, paramLong1, this.qWu);
      AppMethodBeat.o(194647);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(194648);
      b.a locala = d.a(this.qWr);
      if (locala == null) {
        p.hyc();
      }
      locala.ax(paramString, paramInt);
      AppMethodBeat.o(194648);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(d paramd, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(194649);
      b.a locala = d.a(this.qWr);
      if (locala == null) {
        p.hyc();
      }
      locala.AI(paramLong1);
      AppMethodBeat.o(194649);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(194650);
      b.a locala = d.a(this.qWr);
      if (locala == null) {
        p.hyc();
      }
      locala.i(paramString, paramLong1, this.qWx);
      AppMethodBeat.o(194650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.d
 * JD-Core Version:    0.7.0.1
 */