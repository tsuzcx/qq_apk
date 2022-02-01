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
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;
import d.y;
import java.io.IOException;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final ViewGroup KAR;
  private final ViewGroup KAS;
  public RedesignVideoPlayerSeekBar KAT;
  private d.g.a.a<y> KAU;
  public boolean KAV;
  private final long KAW;
  public final Handler KAX;
  private d.g.a.b<? super View, y> KAY;
  public final b KAZ;
  private final String TAG;
  private TextureView aST;
  public g.a blq;
  public final Handler eventHandler;
  private final com.google.android.exoplayer2.h.l ksW;
  public final TextView titleTv;
  private final ImageView ubf;
  private final String userAgent;
  public v vqg;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203475);
    AppMethodBeat.o(203475);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203474);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = com.google.android.exoplayer2.i.x.i(paramContext, paramContext.getString(2131755822));
    this.ksW = new com.google.android.exoplayer2.h.l();
    this.KAW = 1000L;
    this.KAX = new Handler();
    this.KAZ = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(2131307447);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.ubf = ((ImageView)paramContext);
    paramContext = findViewById(2131307456);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(2131307454);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.aST = ((TextureView)paramContext);
    this.KAT = ((RedesignVideoPlayerSeekBar)findViewById(2131307450));
    paramContext = findViewById(2131307455);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.KAR = ((ViewGroup)paramContext);
    paramContext = findViewById(2131307448);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.KAS = ((ViewGroup)paramContext);
    this.ubf.setImageDrawable(am.e(getResources().getDrawable(2131690371), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.ksW));
    paramAttributeSet = new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k());
    this.vqg = g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramAttributeSet = (com.google.android.exoplayer2.h.x)this.ksW;
    com.google.android.exoplayer2.h.l locall = this.ksW;
    String str = this.userAgent;
    d.g.b.k.g(str, "userAgent");
    this.blq = ((g.a)new n(paramContext, paramAttributeSet, (g.a)new com.google.android.exoplayer2.h.p(str, (com.google.android.exoplayer2.h.x)locall, true)));
    paramContext = this.vqg;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramContext = this.vqg;
    if (paramContext != null) {
      paramContext.d(this.aST);
    }
    this.ubf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203452);
        d.g.a.b localb = this.KBa.getOnCloseClickListener();
        if (localb != null)
        {
          d.g.b.k.g(paramAnonymousView, "it");
          localb.aA(paramAnonymousView);
          AppMethodBeat.o(203452);
          return;
        }
        AppMethodBeat.o(203452);
      }
    });
    this.aST.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203453);
        LiveReplayVideoView.f(this.KBa);
        AppMethodBeat.o(203453);
      }
    });
    paramContext = this.KAT;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203454);
          paramAnonymousView = LiveReplayVideoView.c(this.KBa);
          if (paramAnonymousView != null)
          {
            if (paramAnonymousView.ru())
            {
              paramAnonymousView.aO(false);
              paramAnonymousView = LiveReplayVideoView.b(this.KBa);
              if (paramAnonymousView != null)
              {
                paramAnonymousView.setIsPlay(false);
                AppMethodBeat.o(203454);
                return;
              }
              AppMethodBeat.o(203454);
              return;
            }
            if (LiveReplayVideoView.g(this.KBa))
            {
              LiveReplayVideoView.i(this.KBa);
              LiveReplayVideoView.h(this.KBa);
            }
            paramAnonymousView.aO(true);
            paramAnonymousView = LiveReplayVideoView.b(this.KBa);
            if (paramAnonymousView != null)
            {
              paramAnonymousView.setIsPlay(true);
              AppMethodBeat.o(203454);
              return;
            }
            AppMethodBeat.o(203454);
            return;
          }
          AppMethodBeat.o(203454);
        }
      });
    }
    paramContext = this.KAT;
    if (paramContext != null)
    {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void bcv()
        {
          AppMethodBeat.i(203455);
          ad.i(LiveReplayVideoView.a(this.KBa), "onSeekPre");
          v localv = LiveReplayVideoView.c(this.KBa);
          if (localv != null)
          {
            localv.aO(false);
            AppMethodBeat.o(203455);
            return;
          }
          AppMethodBeat.o(203455);
        }
        
        public final void rZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(203456);
          ad.i(LiveReplayVideoView.a(this.KBa), "onSeekTo ".concat(String.valueOf(paramAnonymousInt)));
          Object localObject = LiveReplayVideoView.c(this.KBa);
          if (localObject != null) {
            ((v)localObject).seekTo(paramAnonymousInt * 1000L);
          }
          localObject = LiveReplayVideoView.c(this.KBa);
          if (localObject != null) {
            ((v)localObject).aO(true);
          }
          localObject = this.KBa.getVideoSeekBarDragCallback();
          if (localObject != null) {
            ((d.g.a.a)localObject).invoke();
          }
          if (LiveReplayVideoView.g(this.KBa))
          {
            LiveReplayVideoView.h(this.KBa);
            LiveReplayVideoView.i(this.KBa);
          }
          AppMethodBeat.o(203456);
        }
      });
      AppMethodBeat.o(203474);
      return;
    }
    AppMethodBeat.o(203474);
  }
  
  private final int getLayoutId()
  {
    return 2131496275;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(203468);
    ad.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(203468);
  }
  
  public final void aA(int paramInt)
  {
    AppMethodBeat.i(203472);
    ad.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(203472);
  }
  
  public final void aR(boolean paramBoolean)
  {
    AppMethodBeat.i(203470);
    ad.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(203470);
  }
  
  public final void b(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(203466);
    ad.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(203466);
  }
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    v localv1 = null;
    long l2 = 0L;
    AppMethodBeat.i(203469);
    ad.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    label277:
    label282:
    do
    {
      AppMethodBeat.o(203469);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      localObject = this.vqg;
      if (localObject != null)
      {
        localObject = Long.valueOf(((v)localObject).getDuration());
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        v localv2 = this.vqg;
        localObject = localv1;
        if (localv2 != null) {
          localObject = Long.valueOf(localv2.getDuration());
        }
        ad.i(str, localObject + "ms");
        localObject = this.KAT;
        if (localObject != null)
        {
          localv1 = this.vqg;
          if (localv1 == null) {
            break label277;
          }
        }
      }
      for (long l1 = localv1.getDuration();; l1 = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        localObject = this.KAT;
        if (localObject == null) {
          break label282;
        }
        localv1 = this.vqg;
        l1 = l2;
        if (localv1 != null) {
          l1 = localv1.getCurrentPosition();
        }
        ((RedesignVideoPlayerSeekBar)localObject).sa((int)(l1 / 1000L));
        AppMethodBeat.o(203469);
        return;
        localObject = null;
        break;
      }
      AppMethodBeat.o(203469);
      return;
      AppMethodBeat.o(203469);
      return;
      this.KAV = true;
      localObject = this.vqg;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.KAT;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.KAX.removeCallbacks((Runnable)this.KAZ);
      localObject = this.vqg;
    } while (localObject == null);
    ((v)localObject).aO(false);
    AppMethodBeat.o(203469);
  }
  
  public final void fQC()
  {
    AppMethodBeat.i(203465);
    this.KAX.removeCallbacks((Runnable)this.KAZ);
    this.KAX.post((Runnable)this.KAZ);
    AppMethodBeat.o(203465);
  }
  
  public final d.g.a.b<View, y> getOnCloseClickListener()
  {
    return this.KAY;
  }
  
  public final d.g.a.a<y> getVideoSeekBarDragCallback()
  {
    return this.KAU;
  }
  
  public final void rJ()
  {
    AppMethodBeat.i(203473);
    ad.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(203473);
  }
  
  public final void rK()
  {
    AppMethodBeat.i(203467);
    ad.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(203467);
  }
  
  public final void rL()
  {
    AppMethodBeat.i(203471);
    ad.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(203471);
  }
  
  public final void setOnCloseClickListener(d.g.a.b<? super View, y> paramb)
  {
    this.KAY = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(d.g.a.a<y> parama)
  {
    this.KAU = parama;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
  public final class a
    implements com.google.android.exoplayer2.source.a, h.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(203461);
      ad.d(LiveReplayVideoView.a(this.KBa), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(203461);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(203457);
      ad.d(LiveReplayVideoView.a(this.KBa), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(203457);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(203460);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = LiveReplayVideoView.b(this.KBa);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.setIsPlay(false);
      }
      ad.printErrStackTrace(LiveReplayVideoView.a(this.KBa), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(203460);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(203458);
      ad.d(LiveReplayVideoView.a(this.KBa), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(203458);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(203459);
      ad.d(LiveReplayVideoView.a(this.KBa), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(203459);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(203463);
      ad.printErrStackTrace(LiveReplayVideoView.a(this.KBa), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.KBa);
      if (paramIOException != null)
      {
        paramIOException.setIsPlay(false);
        AppMethodBeat.o(203463);
        return;
      }
      AppMethodBeat.o(203463);
    }
    
    public final void ty()
    {
      AppMethodBeat.i(203462);
      ad.d(LiveReplayVideoView.a(this.KBa), "onHasEndTag");
      AppMethodBeat.o(203462);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      Long localLong = null;
      AppMethodBeat.i(203464);
      Object localObject1 = LiveReplayVideoView.c(this.KBa);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        localObject2 = LiveReplayVideoView.c(this.KBa);
        if (localObject2 != null) {
          localLong = Long.valueOf(((v)localObject2).getBufferedPosition());
        }
        localObject2 = LiveReplayVideoView.b(this.KBa);
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label160;
          }
        }
      }
      label160:
      for (long l = ((Long)localObject1).longValue();; l = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).sa((int)(l / 1000L));
        ad.i(LiveReplayVideoView.a(this.KBa), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localLong + "ms");
        LiveReplayVideoView.d(this.KBa).postDelayed((Runnable)this, LiveReplayVideoView.e(this.KBa));
        AppMethodBeat.o(203464);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView
 * JD-Core Version:    0.7.0.1
 */