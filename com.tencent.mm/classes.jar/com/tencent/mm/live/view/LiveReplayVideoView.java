package com.tencent.mm.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
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
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.i.x;
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
import com.tencent.mm.ui.bb;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveReplayVideoView
  extends RelativeLayout
  implements q.a
{
  private final String TAG;
  private TextureView cHz;
  public g.a cZG;
  public final Handler eventHandler;
  private final ImageView nkq;
  public v nno;
  private final ViewGroup nnp;
  private final ViewGroup nnq;
  public RedesignVideoPlayerSeekBar nnr;
  private kotlin.g.a.a<ah> nns;
  private final l nnt;
  public boolean nnu;
  private final long nnv;
  public final Handler nnw;
  private kotlin.g.a.b<? super View, ah> nnx;
  public final b nny;
  public final TextView titleTv;
  private final String userAgent;
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246259);
    AppMethodBeat.o(246259);
  }
  
  public LiveReplayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246252);
    this.TAG = "MicroMsg.LiveReplayVideoView";
    this.eventHandler = new Handler(Looper.getMainLooper());
    this.userAgent = x.m(paramContext, paramContext.getString(b.h.app_name));
    this.nnt = new l();
    this.nnv = 1000L;
    this.nnw = new Handler();
    this.nny = new b(this);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(b.e.live_after_replay_close_icon);
    s.s(paramContext, "findViewById(R.id.live_after_replay_close_icon)");
    this.nkq = ((ImageView)paramContext);
    paramContext = findViewById(b.e.live_after_replay_title_tv);
    s.s(paramContext, "findViewById(R.id.live_after_replay_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramContext = findViewById(b.e.live_after_replay_texture_view);
    s.s(paramContext, "findViewById(R.id.live_after_replay_texture_view)");
    this.cHz = ((TextureView)paramContext);
    this.nnr = ((RedesignVideoPlayerSeekBar)findViewById(b.e.live_after_replay_seek_bar));
    paramContext = findViewById(b.e.live_after_replay_title_group);
    s.s(paramContext, "findViewById(R.id.live_after_replay_title_group)");
    this.nnp = ((ViewGroup)paramContext);
    paramContext = findViewById(b.e.live_after_replay_footer_group);
    s.s(paramContext, "findViewById(R.id.live_after_replay_footer_group)");
    this.nnq = ((ViewGroup)paramContext);
    this.nkq.setImageDrawable(bb.e(getResources().getDrawable(b.g.icons_filled_close), -1));
    paramContext = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)this.nnt));
    paramAttributeSet = new com.google.android.exoplayer2.c(new k());
    this.nno = com.google.android.exoplayer2.g.a((u)new com.google.android.exoplayer2.d(getContext()), (h)paramContext, (m)paramAttributeSet);
    paramContext = getContext();
    s.s(paramContext, "context");
    paramAttributeSet = (com.google.android.exoplayer2.h.w)this.nnt;
    l locall = this.nnt;
    String str = this.userAgent;
    s.s(str, "userAgent");
    this.cZG = ((g.a)new n(paramContext, paramAttributeSet, (g.a)new com.google.android.exoplayer2.h.p(str, (com.google.android.exoplayer2.h.w)locall, true)));
    paramContext = this.nno;
    if (paramContext != null) {
      paramContext.a((q.a)this);
    }
    paramAttributeSet = this.nno;
    if (paramAttributeSet != null)
    {
      paramContext = this.cHz;
      paramAttributeSet.QV();
      paramAttributeSet.cHz = paramContext;
      if (paramContext != null) {
        break label534;
      }
      paramContext = null;
    }
    for (;;)
    {
      paramAttributeSet.a(paramContext, true);
      this.nkq.setOnClickListener(new LiveReplayVideoView..ExternalSyntheticLambda0(this));
      this.cHz.setOnClickListener(new LiveReplayVideoView..ExternalSyntheticLambda2(this));
      paramContext = this.nnr;
      if (paramContext != null) {
        paramContext.setPlayBtnOnClickListener(new LiveReplayVideoView..ExternalSyntheticLambda1(this));
      }
      paramContext = this.nnr;
      if (paramContext != null) {
        paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new com.tencent.mm.plugin.sight.decode.ui.b()
        {
          public final void blc()
          {
            AppMethodBeat.i(246044);
            Log.i(LiveReplayVideoView.a(this.nnz), "onSeekPre");
            v localv = LiveReplayVideoView.c(this.nnz);
            if (localv != null) {
              localv.bv(false);
            }
            AppMethodBeat.o(246044);
          }
          
          public final void tS(int paramAnonymousInt)
          {
            AppMethodBeat.i(246056);
            Log.i(LiveReplayVideoView.a(this.nnz), s.X("onSeekTo ", Integer.valueOf(paramAnonymousInt)));
            Object localObject = LiveReplayVideoView.c(this.nnz);
            if (localObject != null) {
              ((v)localObject).seekTo(paramAnonymousInt * 1000L);
            }
            localObject = LiveReplayVideoView.c(this.nnz);
            if (localObject != null) {
              ((v)localObject).bv(true);
            }
            localObject = this.nnz.getVideoSeekBarDragCallback();
            if (localObject != null) {
              ((kotlin.g.a.a)localObject).invoke();
            }
            if (LiveReplayVideoView.f(this.nnz))
            {
              LiveReplayVideoView.g(this.nnz);
              LiveReplayVideoView.h(this.nnz);
            }
            AppMethodBeat.o(246056);
          }
          
          public final void tT(int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(246252);
      return;
      label534:
      paramContext.getSurfaceTextureListener();
      paramContext.setSurfaceTextureListener(paramAttributeSet.cHo);
      if (paramContext.isAvailable()) {}
      for (paramContext = paramContext.getSurfaceTexture();; paramContext = null)
      {
        if (paramContext != null) {
          break label573;
        }
        paramContext = null;
        break;
      }
      label573:
      paramContext = new Surface(paramContext);
    }
  }
  
  private static final void a(LiveReplayVideoView paramLiveReplayVideoView, View paramView)
  {
    AppMethodBeat.i(246271);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveReplayVideoView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveReplayVideoView, "this$0");
    paramLiveReplayVideoView = paramLiveReplayVideoView.getOnCloseClickListener();
    if (paramLiveReplayVideoView != null)
    {
      s.s(paramView, "it");
      paramLiveReplayVideoView.invoke(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246271);
  }
  
  private static final void b(LiveReplayVideoView paramLiveReplayVideoView, View paramView)
  {
    AppMethodBeat.i(246277);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveReplayVideoView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveReplayVideoView, "this$0");
    if (paramLiveReplayVideoView.nnp.getVisibility() == 0)
    {
      paramLiveReplayVideoView.nnp.setVisibility(8);
      if (paramLiveReplayVideoView.nnq.getVisibility() != 0) {
        break label137;
      }
      paramLiveReplayVideoView.nnq.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246277);
      return;
      paramLiveReplayVideoView.nnp.setVisibility(0);
      break;
      label137:
      paramLiveReplayVideoView.nnq.setVisibility(0);
    }
  }
  
  private static final void c(LiveReplayVideoView paramLiveReplayVideoView, View paramView)
  {
    AppMethodBeat.i(246287);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveReplayVideoView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveReplayVideoView, "this$0");
    paramView = paramLiveReplayVideoView.nno;
    if (paramView != null)
    {
      if (!paramView.QD()) {
        break label123;
      }
      paramView.bv(false);
      paramLiveReplayVideoView = paramLiveReplayVideoView.nnr;
      if (paramLiveReplayVideoView != null) {
        paramLiveReplayVideoView.setIsPlay(false);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/LiveReplayVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246287);
      return;
      label123:
      if (paramLiveReplayVideoView.nnu)
      {
        paramLiveReplayVideoView.blb();
        paramLiveReplayVideoView.nnu = false;
      }
      paramView.bv(true);
      paramLiveReplayVideoView = paramLiveReplayVideoView.nnr;
      if (paramLiveReplayVideoView != null) {
        paramLiveReplayVideoView.setIsPlay(true);
      }
    }
  }
  
  private final int getLayoutId()
  {
    return b.f.live_after_replay_ui;
  }
  
  public final void blb()
  {
    AppMethodBeat.i(246389);
    this.nnw.removeCallbacks((Runnable)this.nny);
    this.nnw.post((Runnable)this.nny);
    AppMethodBeat.o(246389);
  }
  
  public final kotlin.g.a.b<View, ah> getOnCloseClickListener()
  {
    return this.nnx;
  }
  
  public final kotlin.g.a.a<ah> getVideoSeekBarDragCallback()
  {
    return this.nns;
  }
  
  public final void onLoadingChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(246428);
    Log.i(this.TAG, "onLoadingChanged");
    AppMethodBeat.o(246428);
  }
  
  public final void onPlaybackParametersChanged(com.google.android.exoplayer2.p paramp)
  {
    AppMethodBeat.i(246396);
    Log.i(this.TAG, "onPlaybackParametersChanged");
    AppMethodBeat.o(246396);
  }
  
  public final void onPlayerError(e parame)
  {
    AppMethodBeat.i(246413);
    Log.i(this.TAG, "onPlayerError");
    AppMethodBeat.o(246413);
  }
  
  public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    v localv = null;
    long l2 = 0L;
    AppMethodBeat.i(246423);
    Log.i(this.TAG, "onPlayerStateChanged playWhenReady:" + paramBoolean + " playbackState:" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246423);
      return;
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("duration:");
      Object localObject = this.nno;
      if (localObject == null)
      {
        localObject = null;
        localStringBuilder = localStringBuilder.append(localObject).append("ms curPosition:");
        localObject = this.nno;
        if (localObject != null) {
          break label257;
        }
        localObject = localv;
        label145:
        Log.i(str, localObject + "ms");
        localObject = this.nnr;
        if (localObject != null)
        {
          localv = this.nno;
          if (localv != null) {
            break label270;
          }
          l1 = 0L;
          label190:
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)(l1 / 1000L));
        }
        localObject = this.nnr;
        if (localObject == null) {
          continue;
        }
        localv = this.nno;
        if (localv != null) {
          break label279;
        }
      }
      label257:
      label270:
      label279:
      for (long l1 = l2;; l1 = localv.getCurrentPosition())
      {
        ((RedesignVideoPlayerSeekBar)localObject).Bh((int)(l1 / 1000L));
        AppMethodBeat.o(246423);
        return;
        localObject = Long.valueOf(((v)localObject).getDuration());
        break;
        localObject = Long.valueOf(((v)localObject).getDuration());
        break label145;
        l1 = localv.getDuration();
        break label190;
      }
      AppMethodBeat.o(246423);
      return;
      this.nnu = true;
      localObject = this.nno;
      if (localObject != null) {
        ((v)localObject).seekTo(0L);
      }
      localObject = this.nnr;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).setIsPlay(false);
      }
      this.nnw.removeCallbacks((Runnable)this.nny);
      localObject = this.nno;
      if (localObject != null) {
        ((v)localObject).bv(false);
      }
    }
  }
  
  public final void onPositionDiscontinuity()
  {
    AppMethodBeat.i(246430);
    Log.i(this.TAG, "onPositionDiscontinuity");
    AppMethodBeat.o(246430);
  }
  
  public final void onRepeatModeChanged(int paramInt)
  {
    AppMethodBeat.i(246435);
    Log.i(this.TAG, "onRepeatModeChanged");
    AppMethodBeat.o(246435);
  }
  
  public final void onTimelineChanged(com.google.android.exoplayer2.w paramw, Object paramObject)
  {
    AppMethodBeat.i(246442);
    Log.i(this.TAG, "onTimelineChanged");
    AppMethodBeat.o(246442);
  }
  
  public final void onTracksChanged(r paramr, com.google.android.exoplayer2.g.g paramg)
  {
    AppMethodBeat.i(246406);
    Log.i(this.TAG, "onTracksChanged");
    AppMethodBeat.o(246406);
  }
  
  public final void setOnCloseClickListener(kotlin.g.a.b<? super View, ah> paramb)
  {
    this.nnx = paramb;
  }
  
  public final void setVideoSeekBarDragCallback(kotlin.g.a.a<ah> parama)
  {
    this.nns = parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements com.google.android.exoplayer2.source.b, h.a
  {
    public a()
    {
      AppMethodBeat.i(246246);
      AppMethodBeat.o(246246);
    }
    
    public final void SM()
    {
      AppMethodBeat.i(246289);
      Log.d(LiveReplayVideoView.a(this.nnz), "onHasEndTag");
      AppMethodBeat.o(246289);
    }
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(246282);
      Log.d(LiveReplayVideoView.a(this.nnz), "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(246282);
    }
    
    public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(246275);
      paramObject = LiveReplayVideoView.b(this.nnz);
      if (paramObject != null) {
        paramObject.setIsPlay(false);
      }
      Log.printErrStackTrace(LiveReplayVideoView.a(this.nnz), (Throwable)paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(246275);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(246254);
      Log.d(LiveReplayVideoView.a(this.nnz), "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(246254);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(246261);
      Log.d(LiveReplayVideoView.a(this.nnz), "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(246261);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(246267);
      Log.d(LiveReplayVideoView.a(this.nnz), "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(246267);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(246297);
      Log.printErrStackTrace(LiveReplayVideoView.a(this.nnz), (Throwable)paramIOException, "onLoadError2, IOException", new Object[0]);
      paramIOException = LiveReplayVideoView.b(this.nnz);
      if (paramIOException != null) {
        paramIOException.setIsPlay(false);
      }
      AppMethodBeat.o(246297);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(LiveReplayVideoView paramLiveReplayVideoView) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(246248);
      Object localObject1 = LiveReplayVideoView.c(this.nnz);
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = LiveReplayVideoView.c(this.nnz);
        if (localObject3 != null) {
          break label147;
        }
        label36:
        localObject3 = LiveReplayVideoView.b(this.nnz);
        if (localObject3 != null) {
          if (localObject1 != null) {
            break label160;
          }
        }
      }
      label147:
      label160:
      for (long l = 0L;; l = ((Long)localObject1).longValue())
      {
        ((RedesignVideoPlayerSeekBar)localObject3).Bh((int)(l / 1000L));
        Log.i(LiveReplayVideoView.a(this.nnz), "repeaterTask curPosition:" + localObject1 + "ms bufferedPosition:" + localObject2 + "ms");
        LiveReplayVideoView.d(this.nnz).postDelayed((Runnable)this, LiveReplayVideoView.e(this.nnz));
        AppMethodBeat.o(246248);
        return;
        localObject1 = Long.valueOf(((v)localObject1).getCurrentPosition());
        break;
        localObject2 = Long.valueOf(((v)localObject3).QF());
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView
 * JD-Core Version:    0.7.0.1
 */