package com.tencent.mm.plugin.eggspring.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.e.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "videoView", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "url", "", "(Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "value", "", "mute", "setMute", "(Z)V", "playDuration", "", "playStartTime", "uiHandler", "Landroid/os/Handler;", "videoDuration", "getVideoDuration", "()J", "setVideoDuration", "(J)V", "videoMediaId", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "path", "isVideoDataAvailable", "offset", "length", "onDataAvailable", "", "onDownloadFinish", "isPlayNow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onM3U8Ready", "p0", "p1", "onMoovReady", "svrflag", "onPrepared", "onProgress", "total", "onSeekComplete", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "pause", "release", "requestVideoData", "resume", "setIEngineCallback", "callback", "start", "startHttpStream", "stop", "totalDuration", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements h.a, f, i.a, i.b
{
  public static final d.a xFB;
  int count;
  private final Handler eLs;
  private boolean nLP;
  long playDuration;
  long vYw;
  final b xEO;
  private f.a xFC;
  String xFD;
  long xFE;
  final SpringEggVideoView xFl;
  
  static
  {
    AppMethodBeat.i(266590);
    xFB = new d.a((byte)0);
    AppMethodBeat.o(266590);
  }
  
  public d(SpringEggVideoView paramSpringEggVideoView, b paramb, String paramString)
  {
    AppMethodBeat.i(266557);
    this.xFl = paramSpringEggVideoView;
    this.xEO = paramb;
    this.eLs = new Handler(Looper.getMainLooper());
    this.nLP = true;
    this.xFl.setLoop(true);
    this.xFl.setIMMVideoViewCallback((i.b)this);
    this.xFl.setIMMDownloadFinish((i.a)this);
    this.xFl.setIOnlineVideoProxy((f)this);
    this.xFl.b(false, paramString, 0);
    this.xFl.setFilepath(PluginEggSpring.xDm + "MMVideo_" + paramString.hashCode() + ".mp4.temp");
    this.xEO.xFm.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(266557);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(266565);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/eggspring/ui/VideoController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if (!paramd.nLP) {}
    for (boolean bool = true;; bool = false)
    {
      paramd.setMute(bool);
      a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/VideoController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266565);
      return;
    }
  }
  
  private static final void a(d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(266587);
    s.u(paramd, "this$0");
    s.u(paramString, "$mediaId");
    paramd = paramd.xFC;
    s.checkNotNull(paramd);
    paramd.bb(paramString, paramInt);
    AppMethodBeat.o(266587);
  }
  
  private static final void a(d paramd, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266579);
    s.u(paramd, "this$0");
    s.u(paramString, "$mediaId");
    paramd = paramd.xFC;
    s.checkNotNull(paramd);
    paramd.onDataAvailable(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(266579);
  }
  
  private static final void a(d paramd, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(266572);
    s.u(paramd, "this$0");
    s.u(paramString1, "$mediaId");
    paramd = paramd.xFC;
    s.checkNotNull(paramd);
    paramd.jb(paramLong1);
    AppMethodBeat.o(266572);
  }
  
  private static final void b(d paramd, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266584);
    s.u(paramd, "this$0");
    s.u(paramString, "$mediaId");
    paramd = paramd.xFC;
    s.checkNotNull(paramd);
    paramd.h(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(266584);
  }
  
  public final void a(f.a parama)
  {
    this.xFC = parama;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(266711);
    s.u(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.xFC != null) && (this.xFD != null) && (s.p(this.xFD, paramString))) {
      this.eLs.post(new d..ExternalSyntheticLambda1(this, paramString, paramInt));
    }
    AppMethodBeat.o(266711);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(266692);
    s.u(paramString1, "mediaId");
    Log.i("MicroMsg.VideoController", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.xFC != null) && (this.xFD != null) && (s.p(this.xFD, paramString1))) {
      this.eLs.post(new d..ExternalSyntheticLambda4(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(266692);
  }
  
  public final void bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(266662);
    if (paramString != null)
    {
      String str = n.m(paramString, ".temp", "", false);
      if ((!y.ZC(str)) && (n.rs(paramString, ".temp"))) {
        y.O(paramString, str, false);
      }
    }
    AppMethodBeat.o(266662);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266627);
    Log.i("MicroMsg.VideoController", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    this.xEO.xFh.setVisibility(0);
    this.xFl.setVisibility(8);
    this.xEO.xFm.setVisibility(8);
    this.playDuration += Util.milliSecondsToNow(this.xFE);
    this.xFE = 0L;
    AppMethodBeat.o(266627);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266641);
    Log.i("MicroMsg.VideoController", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266641);
  }
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266633);
    Log.i("MicroMsg.VideoController", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    this.xFE = Util.nowMilliSecond();
    this.vYw = (this.xFl.getVideoDurationSec() * 1000L);
    AppMethodBeat.o(266633);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266637);
    Log.i("MicroMsg.VideoController", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266637);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266646);
    Log.i("MicroMsg.VideoController", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266646);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266651);
    Log.i("MicroMsg.VideoController", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(this.xFl.getVideoDurationSec()) });
    this.count += 1;
    AppMethodBeat.o(266651);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266655);
    Log.i("MicroMsg.VideoController", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266655);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266657);
    Log.i("MicroMsg.VideoController", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266657);
  }
  
  public final void gE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266659);
    Log.i("MicroMsg.VideoController", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(266659);
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266706);
    s.u(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.xFC != null) && (this.xFD != null) && (s.p(this.xFD, paramString))) {
      this.eLs.post(new d..ExternalSyntheticLambda2(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(266706);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(266677);
    Log.i("MicroMsg.VideoController", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.xFD;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (s.p(str, paramString)) {
        bool1 = v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(266677);
    return bool1;
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(266667);
    s.u(paramString, "mediaId");
    Log.w("MicroMsg.VideoController", s.X("stop ", paramString));
    String str = this.xFD;
    if ((str != null) && (s.p(str, paramString))) {
      v.bOi().l(paramString, null);
    }
    AppMethodBeat.o(266667);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266701);
    s.u(paramString, "mediaId");
    Log.i("MicroMsg.VideoController", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.xFC != null) && (this.xFD != null) && (s.p(this.xFD, paramString))) {
      this.eLs.post(new d..ExternalSyntheticLambda3(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(266701);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2) {}
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266670);
    String str = this.xFD;
    if ((str != null) && (s.p(str, paramString)))
    {
      Log.w("MicroMsg.VideoController", "requestVideoData offset=" + paramInt1 + ", length=" + paramInt2);
      v.bOi();
      j.v(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(266670);
  }
  
  final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(266621);
    this.nLP = paramBoolean;
    this.xFl.setMute(paramBoolean);
    WeImageView localWeImageView = this.xEO.xFm;
    if (paramBoolean) {}
    for (int i = e.g.icon_volume_off;; i = e.g.icon_volume_on)
    {
      localWeImageView.setImageResource(i);
      AppMethodBeat.o(266621);
      return;
    }
  }
  
  public final void w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(266666);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "path");
    s.u(paramString3, "url");
    this.xFD = paramString1;
    if (y.ZC(PluginEggSpring.xDm + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(266666);
      return;
    }
    j localj = v.bOi();
    h localh = new h();
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.lxi = 1;
    localh.lxc = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.lxs = ((h.a)this);
    localj.a(localh, false);
    AppMethodBeat.o(266666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.d
 * JD-Core Version:    0.7.0.1
 */