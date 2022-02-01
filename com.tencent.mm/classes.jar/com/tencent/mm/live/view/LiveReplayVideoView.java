package com.tencent.mm.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import d.z;
import java.io.IOException;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final String TAG;
  private TextureView bef;
  public com.google.android.exoplayer2.h.g.a bwq;
  public final Handler eventHandler;
  private final ImageView hai;
  public v hdX;
  private final ViewGroup hdY;
  private final ViewGroup hdZ;
  public RedesignVideoPlayerSeekBar hea;
  private d.g.a.a<z> heb;
  private final com.google.android.exoplayer2.h.l hec;
  public boolean hed;
  private final long hee;
  public final Handler hef;
  private d.g.a.b<? super View, z> heg;
  public final b heh;
  public final TextView titleTv;
  private final String userAgent;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216623);
    AppMethodBeat.o(216623);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216622);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = x.h(paramContext, paramContext.getString(2131755822));
    this.hec = new com.google.android.exoplayer2.h.l();
    this.hee = 1000L;
    this.hef = new Handler();
    this.heh = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(2131307523);
    d.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.hai = ((ImageView)paramContext);
    paramContext = findViewById(2131307532);
    d.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(2131307530);
    d.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.bef = ((TextureView)paramContext);
    this.hea = ((RedesignVideoPlayerSeekBar)findViewById(2131307526));
    paramContext = findViewById(2131307531);
    d.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.hdY = ((ViewGroup)paramContext);
    paramContext = findViewById(2131307524);
    d.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.hdZ = ((ViewGroup)paramContext);
    this.hai.setImageDrawable(ao.e(getResources().getDrawable(2131690371), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.hec));
    paramAttributeSet = new com.google.android.exoplayer2.c(new k());
    this.hdX = g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    d.g.b.p.g(paramContext, "context");
    paramAttributeSet = (w)this.hec;
    com.google.android.exoplayer2.h.l locall = this.hec;
    String str = this.userAgent;
    d.g.b.p.g(str, "userAgent");
    this.bwq = ((com.google.android.exoplayer2.h.g.a)new n(paramContext, paramAttributeSet, (com.google.android.exoplayer2.h.g.a)new com.google.android.exoplayer2.h.p(str, (w)locall, true)));
    paramContext = this.hdX;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramContext = this.hdX;
    if (paramContext != null) {
      paramContext.c(this.bef);
    }
    this.hai.setOnClickListener((View.OnClickListener)new LiveReplayVideoView.1(this));
    this.bef.setOnClickListener((View.OnClickListener)new LiveReplayVideoView.2(this));
    paramContext = this.hea;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(216602);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = LiveReplayVideoView.c(this.hei);
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.te()) {
              break label93;
            }
            paramAnonymousView.aP(false);
            paramAnonymousView = LiveReplayVideoView.b(this.hei);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(false);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216602);
            return;
            label93:
            if (LiveReplayVideoView.g(this.hei))
            {
              LiveReplayVideoView.i(this.hei);
              LiveReplayVideoView.h(this.hei);
            }
            paramAnonymousView.aP(true);
            paramAnonymousView = LiveReplayVideoView.b(this.hei);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(true);
            }
          }
        }
      });
    }
    paramContext = this.hea;
    if (paramContext != null)
    {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aqS()
        {
          AppMethodBeat.i(216603);
          ae.i(LiveReplayVideoView.a(this.hei), "onSeekPre");
          v localv = LiveReplayVideoView.c(this.hei);
          if (localv != null)
          {
            localv.aP(false);
            AppMethodBeat.o(216603);
            return;
          }
          AppMethodBeat.o(216603);
        }
        
        public final void nP(int paramAnonymousInt)
        {
          AppMethodBeat.i(216604);
          ae.i(LiveReplayVideoView.a(this.hei), "onSeekTo ".concat(String.valueOf(paramAnonymousInt)));
          Object localObject = LiveReplayVideoView.c(this.hei);
          if (localObject != null) {
            ((v)localObject).seekTo(paramAnonymousInt * 1000L);
          }
          localObject = LiveReplayVideoView.c(this.hei);
          if (localObject != null) {
            ((v)localObject).aP(true);
          }
          localObject = this.hei.getVideoSeekBarDragCallback();
          if (localObject != null) {
            ((d.g.a.a)localObject).invoke();
          }
          if (LiveReplayVideoView.g(this.hei))
          {
            LiveReplayVideoView.h(this.hei);
            LiveReplayVideoView.i(this.hei);
          }
          AppMethodBeat.o(216604);
        }
      });
      AppMethodBeat.o(216622);
      return;
    }
    AppMethodBeat.o(216622);
  }
  
  private final int getLayoutId()
  {
    return 2131496284;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(216616);
    ae.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(216616);
  }
  
  public final void aA(int paramInt)
  {
    AppMethodBeat.i(216620);
    ae.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(216620);
  }
  
  public final void aS(boolean paramBoolean)
  {
    AppMethodBeat.i(216618);
    ae.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(216618);
  }
  
  public final void aqR()
  {
    AppMethodBeat.i(216613);
    this.hef.removeCallbacks((Runnable)this.heh);
    this.hef.post((Runnable)this.heh);
    AppMethodBeat.o(216613);
  }
  
  public final void b(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(216614);
    ae.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(216614);
  }
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    v localv1 = null;
    long l2 = 0L;
    AppMethodBeat.i(216617);
    ae.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    label277:
    label282:
    do
    {
      AppMethodBeat.o(216617);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      localObject = this.hdX;
      if (localObject != null)
      {
        localObject = Long.valueOf(((v)localObject).getDuration());
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        v localv2 = this.hdX;
        localObject = localv1;
        if (localv2 != null) {
          localObject = Long.valueOf(localv2.getDuration());
        }
        ae.i(str, localObject + "ms");
        localObject = this.hea;
        if (localObject != null)
        {
          localv1 = this.hdX;
          if (localv1 == null) {
            break label277;
          }
        }
      }
      for (long l1 = localv1.getDuration();; l1 = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        localObject = this.hea;
        if (localObject == null) {
          break label282;
        }
        localv1 = this.hdX;
        l1 = l2;
        if (localv1 != null) {
          l1 = localv1.getCurrentPosition();
        }
        ((RedesignVideoPlayerSeekBar)localObject).tx((int)(l1 / 1000L));
        AppMethodBeat.o(216617);
        return;
        localObject = null;
        break;
      }
      AppMethodBeat.o(216617);
      return;
      AppMethodBeat.o(216617);
      return;
      this.hed = true;
      localObject = this.hdX;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.hea;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.hef.removeCallbacks((Runnable)this.heh);
      localObject = this.hdX;
    } while (localObject == null);
    ((v)localObject).aP(false);
    AppMethodBeat.o(216617);
  }
  
  public final d.g.a.b<View, z> getOnCloseClickListener()
  {
    return this.heg;
  }
  
  public final d.g.a.a<z> getVideoSeekBarDragCallback()
  {
    return this.heb;
  }
  
  public final void setOnCloseClickListener(d.g.a.b<? super View, z> paramb)
  {
    this.heg = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(d.g.a.a<z> parama)
  {
    this.heb = parama;
  }
  
  public final void tt()
  {
    AppMethodBeat.i(216621);
    ae.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(216621);
  }
  
  public final void tu()
  {
    AppMethodBeat.i(216615);
    ae.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(216615);
  }
  
  public final void tv()
  {
    AppMethodBeat.i(216619);
    ae.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(216619);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
  public final class a
    implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(216609);
      ae.d(LiveReplayVideoView.a(this.hei), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(216609);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(216605);
      ae.d(LiveReplayVideoView.a(this.hei), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(216605);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(216608);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = LiveReplayVideoView.b(this.hei);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.setIsPlay(false);
      }
      ae.printErrStackTrace(LiveReplayVideoView.a(this.hei), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(216608);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(216606);
      ae.d(LiveReplayVideoView.a(this.hei), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(216606);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(216607);
      ae.d(LiveReplayVideoView.a(this.hei), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(216607);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(216611);
      ae.printErrStackTrace(LiveReplayVideoView.a(this.hei), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.hei);
      if (paramIOException != null)
      {
        paramIOException.setIsPlay(false);
        AppMethodBeat.o(216611);
        return;
      }
      AppMethodBeat.o(216611);
    }
    
    public final void vf()
    {
      AppMethodBeat.i(216610);
      ae.d(LiveReplayVideoView.a(this.hei), "onHasEndTag");
      AppMethodBeat.o(216610);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      Long localLong = null;
      AppMethodBeat.i(216612);
      Object localObject1 = LiveReplayVideoView.c(this.hei);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        localObject2 = LiveReplayVideoView.c(this.hei);
        if (localObject2 != null) {
          localLong = Long.valueOf(((v)localObject2).getBufferedPosition());
        }
        localObject2 = LiveReplayVideoView.b(this.hei);
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label160;
          }
        }
      }
      label160:
      for (long l = ((Long)localObject1).longValue();; l = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).tx((int)(l / 1000L));
        ae.i(LiveReplayVideoView.a(this.hei), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localLong + "ms");
        LiveReplayVideoView.d(this.hei).postDelayed((Runnable)this, LiveReplayVideoView.e(this.hei));
        AppMethodBeat.o(216612);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView
 * JD-Core Version:    0.7.0.1
 */