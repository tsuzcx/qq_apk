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
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.am;
import d.y;
import java.io.IOException;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final String TAG;
  private TextureView aTL;
  public com.google.android.exoplayer2.h.g.a blV;
  public final Handler eventHandler;
  private final ImageView gDM;
  private final ViewGroup gHA;
  private final ViewGroup gHB;
  public RedesignVideoPlayerSeekBar gHC;
  private d.g.a.a<y> gHD;
  private final com.google.android.exoplayer2.h.l gHE;
  public boolean gHF;
  private final long gHG;
  public final Handler gHH;
  private d.g.a.b<? super View, y> gHI;
  public final b gHJ;
  public v gHz;
  public final TextView titleTv;
  private final String userAgent;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190703);
    AppMethodBeat.o(190703);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190702);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = x.i(paramContext, paramContext.getString(2131755822));
    this.gHE = new com.google.android.exoplayer2.h.l();
    this.gHG = 1000L;
    this.gHH = new Handler();
    this.gHJ = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(2131307523);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.gDM = ((ImageView)paramContext);
    paramContext = findViewById(2131307532);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(2131307530);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.aTL = ((TextureView)paramContext);
    this.gHC = ((RedesignVideoPlayerSeekBar)findViewById(2131307526));
    paramContext = findViewById(2131307531);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.gHA = ((ViewGroup)paramContext);
    paramContext = findViewById(2131307524);
    d.g.b.k.g(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.gHB = ((ViewGroup)paramContext);
    this.gDM.setImageDrawable(am.e(getResources().getDrawable(2131690371), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.gHE));
    paramAttributeSet = new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k());
    this.gHz = g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramAttributeSet = (w)this.gHE;
    com.google.android.exoplayer2.h.l locall = this.gHE;
    String str = this.userAgent;
    d.g.b.k.g(str, "userAgent");
    this.blV = ((com.google.android.exoplayer2.h.g.a)new n(paramContext, paramAttributeSet, (com.google.android.exoplayer2.h.g.a)new com.google.android.exoplayer2.h.p(str, (w)locall, true)));
    paramContext = this.gHz;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramContext = this.gHz;
    if (paramContext != null) {
      paramContext.c(this.aTL);
    }
    this.gDM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190680);
        d.g.a.b localb = this.gHK.getOnCloseClickListener();
        if (localb != null)
        {
          d.g.b.k.g(paramAnonymousView, "it");
          localb.ay(paramAnonymousView);
          AppMethodBeat.o(190680);
          return;
        }
        AppMethodBeat.o(190680);
      }
    });
    this.aTL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190681);
        LiveReplayVideoView.f(this.gHK);
        AppMethodBeat.o(190681);
      }
    });
    paramContext = this.gHC;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190682);
          paramAnonymousView = LiveReplayVideoView.c(this.gHK);
          if (paramAnonymousView != null)
          {
            if (paramAnonymousView.rF())
            {
              paramAnonymousView.aO(false);
              paramAnonymousView = LiveReplayVideoView.b(this.gHK);
              if (paramAnonymousView != null)
              {
                paramAnonymousView.setIsPlay(false);
                AppMethodBeat.o(190682);
                return;
              }
              AppMethodBeat.o(190682);
              return;
            }
            if (LiveReplayVideoView.g(this.gHK))
            {
              LiveReplayVideoView.i(this.gHK);
              LiveReplayVideoView.h(this.gHK);
            }
            paramAnonymousView.aO(true);
            paramAnonymousView = LiveReplayVideoView.b(this.gHK);
            if (paramAnonymousView != null)
            {
              paramAnonymousView.setIsPlay(true);
              AppMethodBeat.o(190682);
              return;
            }
            AppMethodBeat.o(190682);
            return;
          }
          AppMethodBeat.o(190682);
        }
      });
    }
    paramContext = this.gHC;
    if (paramContext != null)
    {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void anR()
        {
          AppMethodBeat.i(190683);
          ac.i(LiveReplayVideoView.a(this.gHK), "onSeekPre");
          v localv = LiveReplayVideoView.c(this.gHK);
          if (localv != null)
          {
            localv.aO(false);
            AppMethodBeat.o(190683);
            return;
          }
          AppMethodBeat.o(190683);
        }
        
        public final void nn(int paramAnonymousInt)
        {
          AppMethodBeat.i(190684);
          ac.i(LiveReplayVideoView.a(this.gHK), "onSeekTo ".concat(String.valueOf(paramAnonymousInt)));
          Object localObject = LiveReplayVideoView.c(this.gHK);
          if (localObject != null) {
            ((v)localObject).seekTo(paramAnonymousInt * 1000L);
          }
          localObject = LiveReplayVideoView.c(this.gHK);
          if (localObject != null) {
            ((v)localObject).aO(true);
          }
          localObject = this.gHK.getVideoSeekBarDragCallback();
          if (localObject != null) {
            ((d.g.a.a)localObject).invoke();
          }
          if (LiveReplayVideoView.g(this.gHK))
          {
            LiveReplayVideoView.h(this.gHK);
            LiveReplayVideoView.i(this.gHK);
          }
          AppMethodBeat.o(190684);
        }
      });
      AppMethodBeat.o(190702);
      return;
    }
    AppMethodBeat.o(190702);
  }
  
  private final int getLayoutId()
  {
    return 2131496284;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(190696);
    ac.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(190696);
  }
  
  public final void aA(int paramInt)
  {
    AppMethodBeat.i(190700);
    ac.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(190700);
  }
  
  public final void aR(boolean paramBoolean)
  {
    AppMethodBeat.i(190698);
    ac.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(190698);
  }
  
  public final void anQ()
  {
    AppMethodBeat.i(190693);
    this.gHH.removeCallbacks((Runnable)this.gHJ);
    this.gHH.post((Runnable)this.gHJ);
    AppMethodBeat.o(190693);
  }
  
  public final void b(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(190694);
    ac.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(190694);
  }
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    v localv1 = null;
    long l2 = 0L;
    AppMethodBeat.i(190697);
    ac.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    label277:
    label282:
    do
    {
      AppMethodBeat.o(190697);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      localObject = this.gHz;
      if (localObject != null)
      {
        localObject = Long.valueOf(((v)localObject).getDuration());
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        v localv2 = this.gHz;
        localObject = localv1;
        if (localv2 != null) {
          localObject = Long.valueOf(localv2.getDuration());
        }
        ac.i(str, localObject + "ms");
        localObject = this.gHC;
        if (localObject != null)
        {
          localv1 = this.gHz;
          if (localv1 == null) {
            break label277;
          }
        }
      }
      for (long l1 = localv1.getDuration();; l1 = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        localObject = this.gHC;
        if (localObject == null) {
          break label282;
        }
        localv1 = this.gHz;
        l1 = l2;
        if (localv1 != null) {
          l1 = localv1.getCurrentPosition();
        }
        ((RedesignVideoPlayerSeekBar)localObject).sQ((int)(l1 / 1000L));
        AppMethodBeat.o(190697);
        return;
        localObject = null;
        break;
      }
      AppMethodBeat.o(190697);
      return;
      AppMethodBeat.o(190697);
      return;
      this.gHF = true;
      localObject = this.gHz;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.gHC;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.gHH.removeCallbacks((Runnable)this.gHJ);
      localObject = this.gHz;
    } while (localObject == null);
    ((v)localObject).aO(false);
    AppMethodBeat.o(190697);
  }
  
  public final d.g.a.b<View, y> getOnCloseClickListener()
  {
    return this.gHI;
  }
  
  public final d.g.a.a<y> getVideoSeekBarDragCallback()
  {
    return this.gHD;
  }
  
  public final void rU()
  {
    AppMethodBeat.i(190701);
    ac.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(190701);
  }
  
  public final void rV()
  {
    AppMethodBeat.i(190695);
    ac.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(190695);
  }
  
  public final void rW()
  {
    AppMethodBeat.i(190699);
    ac.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(190699);
  }
  
  public final void setOnCloseClickListener(d.g.a.b<? super View, y> paramb)
  {
    this.gHI = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(d.g.a.a<y> parama)
  {
    this.gHD = parama;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
  public final class a
    implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(190689);
      ac.d(LiveReplayVideoView.a(this.gHK), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(190689);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(190685);
      ac.d(LiveReplayVideoView.a(this.gHK), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(190685);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(190688);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = LiveReplayVideoView.b(this.gHK);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.setIsPlay(false);
      }
      ac.printErrStackTrace(LiveReplayVideoView.a(this.gHK), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(190688);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(190686);
      ac.d(LiveReplayVideoView.a(this.gHK), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(190686);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(190687);
      ac.d(LiveReplayVideoView.a(this.gHK), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(190687);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(190691);
      ac.printErrStackTrace(LiveReplayVideoView.a(this.gHK), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.gHK);
      if (paramIOException != null)
      {
        paramIOException.setIsPlay(false);
        AppMethodBeat.o(190691);
        return;
      }
      AppMethodBeat.o(190691);
    }
    
    public final void tG()
    {
      AppMethodBeat.i(190690);
      ac.d(LiveReplayVideoView.a(this.gHK), "onHasEndTag");
      AppMethodBeat.o(190690);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      Long localLong = null;
      AppMethodBeat.i(190692);
      Object localObject1 = LiveReplayVideoView.c(this.gHK);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        localObject2 = LiveReplayVideoView.c(this.gHK);
        if (localObject2 != null) {
          localLong = Long.valueOf(((v)localObject2).getBufferedPosition());
        }
        localObject2 = LiveReplayVideoView.b(this.gHK);
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label160;
          }
        }
      }
      label160:
      for (long l = ((Long)localObject1).longValue();; l = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).sQ((int)(l / 1000L));
        ac.i(LiveReplayVideoView.a(this.gHK), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localLong + "ms");
        LiveReplayVideoView.d(this.gHK).postDelayed((Runnable)this, LiveReplayVideoView.e(this.gHK));
        AppMethodBeat.o(190692);
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