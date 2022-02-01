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
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.io.IOException;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final String TAG;
  private TextureView aND;
  public g.a bfN;
  public final Handler eventHandler;
  private final ImageView kHA;
  public v kLl;
  private final ViewGroup kLm;
  private final ViewGroup kLn;
  public RedesignVideoPlayerSeekBar kLo;
  private kotlin.g.a.a<kotlin.x> kLp;
  private final com.google.android.exoplayer2.h.l kLq;
  public boolean kLr;
  private final long kLs;
  public final Handler kLt;
  private kotlin.g.a.b<? super View, kotlin.x> kLu;
  public final b kLv;
  public final TextView titleTv;
  private final String userAgent;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(197540);
    AppMethodBeat.o(197540);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197537);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = com.google.android.exoplayer2.i.x.i(paramContext, paramContext.getString(b.h.app_name));
    this.kLq = new com.google.android.exoplayer2.h.l();
    this.kLs = 1000L;
    this.kLt = new Handler();
    this.kLv = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(b.e.live_after_replay_close_icon);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.kHA = ((ImageView)paramContext);
    paramContext = findViewById(b.e.live_after_replay_title_tv);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(b.e.live_after_replay_texture_view);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.aND = ((TextureView)paramContext);
    this.kLo = ((RedesignVideoPlayerSeekBar)findViewById(b.e.live_after_replay_seek_bar));
    paramContext = findViewById(b.e.live_after_replay_title_group);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.kLm = ((ViewGroup)paramContext);
    paramContext = findViewById(b.e.live_after_replay_footer_group);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.kLn = ((ViewGroup)paramContext);
    this.kHA.setImageDrawable(au.e(getResources().getDrawable(b.g.icons_filled_close), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.kLq));
    paramAttributeSet = new com.google.android.exoplayer2.c(new k());
    this.kLl = com.google.android.exoplayer2.g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    kotlin.g.b.p.j(paramContext, "context");
    paramAttributeSet = (com.google.android.exoplayer2.h.w)this.kLq;
    com.google.android.exoplayer2.h.l locall = this.kLq;
    String str = this.userAgent;
    kotlin.g.b.p.j(str, "userAgent");
    this.bfN = ((g.a)new n(paramContext, paramAttributeSet, (g.a)new com.google.android.exoplayer2.h.p(str, (com.google.android.exoplayer2.h.w)locall, true)));
    paramContext = this.kLl;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramContext = this.kLl;
    if (paramContext != null) {
      paramContext.c(this.aND);
    }
    this.kHA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.kLw.getOnCloseClickListener();
        if (localObject != null)
        {
          kotlin.g.b.p.j(paramAnonymousView, "it");
          ((kotlin.g.a.b)localObject).invoke(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202132);
      }
    });
    this.aND.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LiveReplayVideoView.f(this.kLw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198980);
      }
    });
    paramContext = this.kLo;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199245);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = LiveReplayVideoView.c(this.kLw);
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.rb()) {
              break label93;
            }
            paramAnonymousView.aM(false);
            paramAnonymousView = LiveReplayVideoView.b(this.kLw);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(false);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199245);
            return;
            label93:
            if (LiveReplayVideoView.g(this.kLw))
            {
              LiveReplayVideoView.i(this.kLw);
              LiveReplayVideoView.h(this.kLw);
            }
            paramAnonymousView.aM(true);
            paramAnonymousView = LiveReplayVideoView.b(this.kLw);
            if (paramAnonymousView != null) {
              paramAnonymousView.setIsPlay(true);
            }
          }
        }
      });
    }
    paramContext = this.kLo;
    if (paramContext != null)
    {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aRo()
        {
          AppMethodBeat.i(189317);
          Log.i(LiveReplayVideoView.a(this.kLw), "onSeekPre");
          v localv = LiveReplayVideoView.c(this.kLw);
          if (localv != null)
          {
            localv.aM(false);
            AppMethodBeat.o(189317);
            return;
          }
          AppMethodBeat.o(189317);
        }
        
        public final void tY(int paramAnonymousInt)
        {
          AppMethodBeat.i(189319);
          Log.i(LiveReplayVideoView.a(this.kLw), "onSeekTo ".concat(String.valueOf(paramAnonymousInt)));
          Object localObject = LiveReplayVideoView.c(this.kLw);
          if (localObject != null) {
            ((v)localObject).seekTo(paramAnonymousInt * 1000L);
          }
          localObject = LiveReplayVideoView.c(this.kLw);
          if (localObject != null) {
            ((v)localObject).aM(true);
          }
          localObject = this.kLw.getVideoSeekBarDragCallback();
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
          if (LiveReplayVideoView.g(this.kLw))
          {
            LiveReplayVideoView.h(this.kLw);
            LiveReplayVideoView.i(this.kLw);
          }
          AppMethodBeat.o(189319);
        }
      });
      AppMethodBeat.o(197537);
      return;
    }
    AppMethodBeat.o(197537);
  }
  
  private final int getLayoutId()
  {
    return b.f.live_after_replay_ui;
  }
  
  public final void I(int paramInt)
  {
    AppMethodBeat.i(197523);
    Log.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(197523);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(197516);
    Log.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(197516);
  }
  
  public final void a(r paramr, com.google.android.exoplayer2.g.g paramg)
  {
    AppMethodBeat.i(197515);
    Log.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(197515);
  }
  
  public final void aP(boolean paramBoolean)
  {
    AppMethodBeat.i(197521);
    Log.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(197521);
  }
  
  public final void aRn()
  {
    AppMethodBeat.i(197511);
    this.kLt.removeCallbacks((Runnable)this.kLv);
    this.kLt.post((Runnable)this.kLv);
    AppMethodBeat.o(197511);
  }
  
  public final void b(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(197513);
    Log.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(197513);
  }
  
  public final void b(com.google.android.exoplayer2.w paramw, Object paramObject)
  {
    AppMethodBeat.i(197525);
    Log.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(197525);
  }
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    v localv1 = null;
    long l2 = 0L;
    AppMethodBeat.i(197520);
    Log.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    label277:
    label282:
    do
    {
      AppMethodBeat.o(197520);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      localObject = this.kLl;
      if (localObject != null)
      {
        localObject = Long.valueOf(((v)localObject).getDuration());
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        v localv2 = this.kLl;
        localObject = localv1;
        if (localv2 != null) {
          localObject = Long.valueOf(localv2.getDuration());
        }
        Log.i(str, localObject + "ms");
        localObject = this.kLo;
        if (localObject != null)
        {
          localv1 = this.kLl;
          if (localv1 == null) {
            break label277;
          }
        }
      }
      for (long l1 = localv1.getDuration();; l1 = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        localObject = this.kLo;
        if (localObject == null) {
          break label282;
        }
        localv1 = this.kLl;
        l1 = l2;
        if (localv1 != null) {
          l1 = localv1.getCurrentPosition();
        }
        ((RedesignVideoPlayerSeekBar)localObject).AS((int)(l1 / 1000L));
        AppMethodBeat.o(197520);
        return;
        localObject = null;
        break;
      }
      AppMethodBeat.o(197520);
      return;
      AppMethodBeat.o(197520);
      return;
      this.kLr = true;
      localObject = this.kLl;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.kLo;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.kLt.removeCallbacks((Runnable)this.kLv);
      localObject = this.kLl;
    } while (localObject == null);
    ((v)localObject).aM(false);
    AppMethodBeat.o(197520);
  }
  
  public final kotlin.g.a.b<View, kotlin.x> getOnCloseClickListener()
  {
    return this.kLu;
  }
  
  public final kotlin.g.a.a<kotlin.x> getVideoSeekBarDragCallback()
  {
    return this.kLp;
  }
  
  public final void rs()
  {
    AppMethodBeat.i(197522);
    Log.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(197522);
  }
  
  public final void setOnCloseClickListener(kotlin.g.a.b<? super View, kotlin.x> paramb)
  {
    this.kLu = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(kotlin.g.a.a<kotlin.x> parama)
  {
    this.kLp = parama;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
  public final class a
    implements com.google.android.exoplayer2.source.b, h.a
  {
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(194576);
      Log.d(LiveReplayVideoView.a(this.kLw), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(194576);
    }
    
    public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(194573);
      paramObject = LiveReplayVideoView.b(this.kLw);
      if (paramObject != null) {
        paramObject.setIsPlay(false);
      }
      Log.printErrStackTrace(LiveReplayVideoView.a(this.kLw), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(194573);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194560);
      Log.d(LiveReplayVideoView.a(this.kLw), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194560);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194564);
      Log.d(LiveReplayVideoView.a(this.kLw), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194564);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194568);
      Log.d(LiveReplayVideoView.a(this.kLw), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194568);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(194581);
      Log.printErrStackTrace(LiveReplayVideoView.a(this.kLw), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.kLw);
      if (paramIOException != null)
      {
        paramIOException.setIsPlay(false);
        AppMethodBeat.o(194581);
        return;
      }
      AppMethodBeat.o(194581);
    }
    
    public final void tj()
    {
      AppMethodBeat.i(194577);
      Log.d(LiveReplayVideoView.a(this.kLw), "onHasEndTag");
      AppMethodBeat.o(194577);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      Long localLong = null;
      AppMethodBeat.i(199552);
      Object localObject1 = LiveReplayVideoView.c(this.kLw);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        localObject2 = LiveReplayVideoView.c(this.kLw);
        if (localObject2 != null) {
          localLong = Long.valueOf(((v)localObject2).rd());
        }
        localObject2 = LiveReplayVideoView.b(this.kLw);
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label160;
          }
        }
      }
      label160:
      for (long l = ((Long)localObject1).longValue();; l = 0L)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).AS((int)(l / 1000L));
        Log.i(LiveReplayVideoView.a(this.kLw), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localLong + "ms");
        LiveReplayVideoView.d(this.kLw).postDelayed((Runnable)this, LiveReplayVideoView.e(this.kLw));
        AppMethodBeat.o(199552);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView
 * JD-Core Version:    0.7.0.1
 */