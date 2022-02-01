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
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.io.IOException;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final String TAG;
  private TextureView bec;
  public g.a bwl;
  public final Handler eventHandler;
  private final ImageView hTd;
  public v hWJ;
  private final ViewGroup hWK;
  private final ViewGroup hWL;
  public RedesignVideoPlayerSeekBar hWM;
  private kotlin.g.a.a<kotlin.x> hWN;
  private final com.google.android.exoplayer2.h.l hWO;
  public boolean hWP;
  private final long hWQ;
  public final Handler hWR;
  private kotlin.g.a.b<? super View, kotlin.x> hWS;
  public final b hWT;
  public final TextView titleTv;
  private final String userAgent;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208588);
    AppMethodBeat.o(208588);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208587);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = com.google.android.exoplayer2.i.x.h(paramContext, paramContext.getString(2131755908));
    this.hWO = new com.google.android.exoplayer2.h.l();
    this.hWQ = 1000L;
    this.hWR = new Handler();
    this.hWT = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(2131303278);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.hTd = ((ImageView)paramContext);
    paramContext = findViewById(2131303287);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(2131303285);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.bec = ((TextureView)paramContext);
    this.hWM = ((RedesignVideoPlayerSeekBar)findViewById(2131303281));
    paramContext = findViewById(2131303286);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.hWK = ((ViewGroup)paramContext);
    paramContext = findViewById(2131303279);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.hWL = ((ViewGroup)paramContext);
    this.hTd.setImageDrawable(ar.e(getResources().getDrawable(2131690514), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.hWO));
    paramAttributeSet = new com.google.android.exoplayer2.c(new k());
    this.hWJ = g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    paramAttributeSet = (w)this.hWO;
    com.google.android.exoplayer2.h.l locall = this.hWO;
    String str = this.userAgent;
    kotlin.g.b.p.g(str, "userAgent");
    this.bwl = ((g.a)new n(paramContext, paramAttributeSet, (g.a)new com.google.android.exoplayer2.h.p(str, (w)locall, true)));
    paramContext = this.hWJ;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramContext = this.hWJ;
    if (paramContext != null) {
      paramContext.c(this.bec);
    }
    this.hTd.setOnClickListener((View.OnClickListener)new LiveReplayVideoView.1(this));
    this.bec.setOnClickListener((View.OnClickListener)new LiveReplayVideoView.2(this));
    paramContext = this.hWM;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(208567);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LiveReplayVideoView.c(this.hWU);
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.tj()) {
              break label93;
            }
            paramAnonymousView.aO(false);
            paramAnonymousView = LiveReplayVideoView.b(this.hWU);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(false);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208567);
            return;
            label93:
            if (LiveReplayVideoView.g(this.hWU))
            {
              LiveReplayVideoView.i(this.hWU);
              LiveReplayVideoView.h(this.hWU);
            }
            paramAnonymousView.aO(true);
            paramAnonymousView = LiveReplayVideoView.b(this.hWU);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(true);
            }
          }
        }
      });
    }
    paramContext = this.hWM;
    if (paramContext != null)
    {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aJq()
        {
          AppMethodBeat.i(208568);
          Log.i(LiveReplayVideoView.a(this.hWU), "onSeekPre");
          v localv = LiveReplayVideoView.c(this.hWU);
          if (localv != null)
          {
            localv.aO(false);
            AppMethodBeat.o(208568);
            return;
          }
          AppMethodBeat.o(208568);
        }
        
        public final void rk(int paramAnonymousInt)
        {
          AppMethodBeat.i(208569);
          Log.i(LiveReplayVideoView.a(this.hWU), "onSeekTo ".concat(String.valueOf(paramAnonymousInt)));
          Object localObject = LiveReplayVideoView.c(this.hWU);
          if (localObject != null) {
            ((v)localObject).seekTo(paramAnonymousInt * 1000L);
          }
          localObject = LiveReplayVideoView.c(this.hWU);
          if (localObject != null) {
            ((v)localObject).aO(true);
          }
          localObject = this.hWU.getVideoSeekBarDragCallback();
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
          if (LiveReplayVideoView.g(this.hWU))
          {
            LiveReplayVideoView.h(this.hWU);
            LiveReplayVideoView.i(this.hWU);
          }
          AppMethodBeat.o(208569);
        }
      });
      AppMethodBeat.o(208587);
      return;
    }
    AppMethodBeat.o(208587);
  }
  
  private final int getLayoutId()
  {
    return 2131495223;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(208581);
    Log.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(208581);
  }
  
  public final void aA(int paramInt)
  {
    AppMethodBeat.i(208585);
    Log.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(208585);
  }
  
  public final void aJp()
  {
    AppMethodBeat.i(208578);
    this.hWR.removeCallbacks((Runnable)this.hWT);
    this.hWR.post((Runnable)this.hWT);
    AppMethodBeat.o(208578);
  }
  
  public final void aR(boolean paramBoolean)
  {
    AppMethodBeat.i(208583);
    Log.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(208583);
  }
  
  public final void b(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(208579);
    Log.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(208579);
  }
  
  public final void c(boolean paramBoolean, int paramInt)
  {
    v localv1 = null;
    long l2 = 0L;
    AppMethodBeat.i(208582);
    Log.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    label277:
    label282:
    do
    {
      AppMethodBeat.o(208582);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      localObject = this.hWJ;
      if (localObject != null)
      {
        localObject = Long.valueOf(((v)localObject).getDuration());
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        v localv2 = this.hWJ;
        localObject = localv1;
        if (localv2 != null) {
          localObject = Long.valueOf(localv2.getDuration());
        }
        Log.i(str, localObject + "ms");
        localObject = this.hWM;
        if (localObject != null)
        {
          localv1 = this.hWJ;
          if (localv1 == null) {
            break label277;
          }
        }
      }
      for (long l1 = localv1.getDuration();; l1 = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        localObject = this.hWM;
        if (localObject == null) {
          break label282;
        }
        localv1 = this.hWJ;
        l1 = l2;
        if (localv1 != null) {
          l1 = localv1.getCurrentPosition();
        }
        ((RedesignVideoPlayerSeekBar)localObject).xv((int)(l1 / 1000L));
        AppMethodBeat.o(208582);
        return;
        localObject = null;
        break;
      }
      AppMethodBeat.o(208582);
      return;
      AppMethodBeat.o(208582);
      return;
      this.hWP = true;
      localObject = this.hWJ;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.hWM;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.hWR.removeCallbacks((Runnable)this.hWT);
      localObject = this.hWJ;
    } while (localObject == null);
    ((v)localObject).aO(false);
    AppMethodBeat.o(208582);
  }
  
  public final kotlin.g.a.b<View, kotlin.x> getOnCloseClickListener()
  {
    return this.hWS;
  }
  
  public final kotlin.g.a.a<kotlin.x> getVideoSeekBarDragCallback()
  {
    return this.hWN;
  }
  
  public final void setOnCloseClickListener(kotlin.g.a.b<? super View, kotlin.x> paramb)
  {
    this.hWS = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(kotlin.g.a.a<kotlin.x> parama)
  {
    this.hWN = parama;
  }
  
  public final void tA()
  {
    AppMethodBeat.i(208584);
    Log.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(208584);
  }
  
  public final void ty()
  {
    AppMethodBeat.i(208586);
    Log.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(208586);
  }
  
  public final void tz()
  {
    AppMethodBeat.i(208580);
    Log.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(208580);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
  public final class a
    implements com.google.android.exoplayer2.source.b, h.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(208574);
      Log.d(LiveReplayVideoView.a(this.hWU), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(208574);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(208570);
      Log.d(LiveReplayVideoView.a(this.hWU), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(208570);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(208573);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = LiveReplayVideoView.b(this.hWU);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.setIsPlay(false);
      }
      Log.printErrStackTrace(LiveReplayVideoView.a(this.hWU), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(208573);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(208571);
      Log.d(LiveReplayVideoView.a(this.hWU), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(208571);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(208572);
      Log.d(LiveReplayVideoView.a(this.hWU), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(208572);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(208576);
      Log.printErrStackTrace(LiveReplayVideoView.a(this.hWU), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.hWU);
      if (paramIOException != null)
      {
        paramIOException.setIsPlay(false);
        AppMethodBeat.o(208576);
        return;
      }
      AppMethodBeat.o(208576);
    }
    
    public final void vl()
    {
      AppMethodBeat.i(208575);
      Log.d(LiveReplayVideoView.a(this.hWU), "onHasEndTag");
      AppMethodBeat.o(208575);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      Long localLong = null;
      AppMethodBeat.i(208577);
      Object localObject1 = LiveReplayVideoView.c(this.hWU);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        localObject2 = LiveReplayVideoView.c(this.hWU);
        if (localObject2 != null) {
          localLong = Long.valueOf(((v)localObject2).getBufferedPosition());
        }
        localObject2 = LiveReplayVideoView.b(this.hWU);
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label160;
          }
        }
      }
      label160:
      for (long l = ((Long)localObject1).longValue();; l = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).xv((int)(l / 1000L));
        Log.i(LiveReplayVideoView.a(this.hWU), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localLong + "ms");
        LiveReplayVideoView.d(this.hWU).postDelayed((Runnable)this, LiveReplayVideoView.e(this.hWU));
        AppMethodBeat.o(208577);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView
 * JD-Core Version:    0.7.0.1
 */