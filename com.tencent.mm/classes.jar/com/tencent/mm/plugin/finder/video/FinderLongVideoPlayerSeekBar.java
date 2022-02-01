package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "downY", "hasStartTrackMove", "", "moveTime", "onCustomLoadingStatusChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isLoading", "", "getOnCustomLoadingStatusChange", "()Lkotlin/jvm/functions/Function1;", "setOnCustomLoadingStatusChange", "(Lkotlin/jvm/functions/Function1;)V", "onSeekEnd", "Lkotlin/Function0;", "getOnSeekEnd", "()Lkotlin/jvm/functions/Function0;", "setOnSeekEnd", "(Lkotlin/jvm/functions/Function0;)V", "onSeekStart", "getOnSeekStart", "setOnSeekStart", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "setPlayStatusListener", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;)V", "startTime", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "bindFinderVideoLayoutTouch", "videoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "getLayoutId", "onReplay", "onSeekTo", "timeStamp", "setIsPlay", "isPlay", "setPlayTimeText", "playTime", "updateTimeMs", "time", "", "Companion", "PlayStatusListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLongVideoPlayerSeekBar
  extends RedesignVideoPlayerSeekBar
{
  public static final FinderLongVideoPlayerSeekBar.a GnZ;
  private boolean Fmh;
  private final j Fmi;
  private int Fmj;
  b Goa;
  private kotlin.g.a.a<ah> Gob;
  private kotlin.g.a.a<ah> Goc;
  private b<? super Boolean, ah> God;
  private int qjs;
  private int qjt;
  private int startTime;
  
  static
  {
    AppMethodBeat.i(335068);
    GnZ = new FinderLongVideoPlayerSeekBar.a((byte)0);
    AppMethodBeat.o(335068);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335043);
    this.Fmi = k.cm((kotlin.g.a.a)new FinderLongVideoPlayerSeekBar.c(this));
    AppMethodBeat.o(335043);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335048);
    this.Fmi = k.cm((kotlin.g.a.a)new FinderLongVideoPlayerSeekBar.c(this));
    AppMethodBeat.o(335048);
  }
  
  private static final boolean a(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335064);
    s.u(paramFinderLongVideoPlayerSeekBar, "this$0");
    s.u(paramFinderVideoLayout, "$videoLayout");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(335064);
      return false;
      paramFinderLongVideoPlayerSeekBar.qjs = ((int)paramMotionEvent.getX());
      paramFinderLongVideoPlayerSeekBar.qjt = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(335064);
      return true;
      if (paramMotionEvent.getPointerCount() > 1)
      {
        AppMethodBeat.o(335064);
        return false;
      }
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      if ((paramFinderLongVideoPlayerSeekBar.Fmh) || ((Math.abs((j - paramFinderLongVideoPlayerSeekBar.qjs) / (i - paramFinderLongVideoPlayerSeekBar.qjt)) > 1.0F) && (Math.abs(j - paramFinderLongVideoPlayerSeekBar.qjs) > paramFinderLongVideoPlayerSeekBar.getTouchSlop())))
      {
        if (!paramFinderLongVideoPlayerSeekBar.Fmh)
        {
          paramView = paramFinderLongVideoPlayerSeekBar.getOnSeekStart();
          if (paramView != null) {
            paramView.invoke();
          }
          paramView = paramFinderVideoLayout.getVideoView();
          if (paramView != null) {
            break label309;
          }
        }
        label309:
        for (i = 0;; i = paramView.getCurrentPlaySecond())
        {
          paramFinderLongVideoPlayerSeekBar.startTime = i;
          paramFinderVideoLayout.uH(false);
          paramFinderLongVideoPlayerSeekBar.setIsPlay(false);
          Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: start track move, startTime = " + paramFinderLongVideoPlayerSeekBar.startTime + " videoTotalTime=" + paramFinderLongVideoPlayerSeekBar.getVideoTotalTime());
          paramFinderLongVideoPlayerSeekBar.Fmh = true;
          float f = (j - paramFinderLongVideoPlayerSeekBar.qjs) / paramFinderVideoLayout.getWidth();
          i = paramFinderLongVideoPlayerSeekBar.startTime;
          paramFinderLongVideoPlayerSeekBar.Fmj = (kotlin.h.a.eH(f * paramFinderLongVideoPlayerSeekBar.getVideoTotalTime()) + i);
          paramFinderLongVideoPlayerSeekBar.seek(paramFinderLongVideoPlayerSeekBar.Fmj);
          AppMethodBeat.o(335064);
          return true;
        }
        if (paramFinderLongVideoPlayerSeekBar.Fmh)
        {
          Log.i("FinderLongVideoPlayerSeekBar", s.X("onFinderVideoLayoutTouch: seek end, target time = ", Integer.valueOf(paramFinderLongVideoPlayerSeekBar.Fmj)));
          paramView = paramFinderLongVideoPlayerSeekBar.getOnSeekEnd();
          if (paramView != null) {
            paramView.invoke();
          }
          paramFinderLongVideoPlayerSeekBar.Fmh = false;
          paramFinderLongVideoPlayerSeekBar.startTime = 0;
          paramView = paramFinderVideoLayout.getVideoView();
          if (paramView != null) {
            paramView.b(paramFinderLongVideoPlayerSeekBar.Fmj, true);
          }
          paramFinderVideoLayout.uH(true);
          paramFinderLongVideoPlayerSeekBar.setIsPlay(true);
          paramFinderLongVideoPlayerSeekBar.Fmj = 0;
          AppMethodBeat.o(335064);
          return true;
        }
        if ((Math.abs(paramMotionEvent.getX() - paramFinderLongVideoPlayerSeekBar.qjs) < paramFinderLongVideoPlayerSeekBar.getTouchSlop()) && (Math.abs(paramMotionEvent.getY() - paramFinderLongVideoPlayerSeekBar.qjt) < paramFinderLongVideoPlayerSeekBar.getTouchSlop()))
        {
          Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: performClick");
          paramFinderVideoLayout.performClick();
        }
      }
    }
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(335054);
    int i = ((Number)this.Fmi.getValue()).intValue();
    AppMethodBeat.o(335054);
    return i;
  }
  
  public final void a(FinderVideoLayout paramFinderVideoLayout)
  {
    AppMethodBeat.i(335128);
    s.u(paramFinderVideoLayout, "videoLayout");
    paramFinderVideoLayout.setOnTouchListener(new FinderLongVideoPlayerSeekBar..ExternalSyntheticLambda0(this, paramFinderVideoLayout));
    AppMethodBeat.o(335128);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_video_player_seek_bar;
  }
  
  public final b<Boolean, ah> getOnCustomLoadingStatusChange()
  {
    return this.God;
  }
  
  public final kotlin.g.a.a<ah> getOnSeekEnd()
  {
    return this.Goc;
  }
  
  public final kotlin.g.a.a<ah> getOnSeekStart()
  {
    return this.Gob;
  }
  
  public final b getPlayStatusListener()
  {
    return this.Goa;
  }
  
  public final void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(335116);
    if (this.hJg == paramBoolean)
    {
      AppMethodBeat.o(335116);
      return;
    }
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(335116);
  }
  
  public final void setOnCustomLoadingStatusChange(b<? super Boolean, ah> paramb)
  {
    this.God = paramb;
  }
  
  public final void setOnSeekEnd(kotlin.g.a.a<ah> parama)
  {
    this.Goc = parama;
  }
  
  public final void setOnSeekStart(kotlin.g.a.a<ah> parama)
  {
    this.Gob = parama;
  }
  
  public final void setPlayStatusListener(b paramb)
  {
    this.Goa = paramb;
  }
  
  public final void setPlayTimeText(int paramInt)
  {
    AppMethodBeat.i(335123);
    this.sHq.setText((CharSequence)(Bf(paramInt / 60) + ':' + Bf(paramInt % 60)));
    AppMethodBeat.o(335123);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onReplay", "onSeekTo", "timeStamp", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void qU(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */