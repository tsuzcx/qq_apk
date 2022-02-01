package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "downY", "hasStartTrackMove", "", "moveTime", "onCustomLoadingStatusChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isLoading", "", "getOnCustomLoadingStatusChange", "()Lkotlin/jvm/functions/Function1;", "setOnCustomLoadingStatusChange", "(Lkotlin/jvm/functions/Function1;)V", "onSeekEnd", "Lkotlin/Function0;", "getOnSeekEnd", "()Lkotlin/jvm/functions/Function0;", "setOnSeekEnd", "(Lkotlin/jvm/functions/Function0;)V", "onSeekStart", "getOnSeekStart", "setOnSeekStart", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "setPlayStatusListener", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;)V", "startTime", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "bindFinderVideoLayoutTouch", "videoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "getLayoutId", "onReplay", "onSeekTo", "timeStamp", "setIsPlay", "isPlay", "setPlayTimeText", "playTime", "updateTimeMs", "time", "", "Companion", "PlayStatusListener", "plugin-finder_release"})
public final class FinderLongVideoPlayerSeekBar
  extends RedesignVideoPlayerSeekBar
{
  public static final a ALu;
  private kotlin.g.a.a<x> ALo;
  private kotlin.g.a.a<x> ALp;
  private b<? super Boolean, x> ALq;
  private boolean ALr;
  private final f ALs;
  private int ALt;
  private int fod;
  private int nmj;
  private int nmk;
  b zvL;
  
  static
  {
    AppMethodBeat.i(280318);
    ALu = new a((byte)0);
    AppMethodBeat.o(280318);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280316);
    this.ALs = g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(280316);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280317);
    this.ALs = g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(280317);
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(280315);
    int i = ((Number)this.ALs.getValue()).intValue();
    AppMethodBeat.o(280315);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_video_player_seek_bar;
  }
  
  public final b<Boolean, x> getOnCustomLoadingStatusChange()
  {
    return this.ALq;
  }
  
  public final kotlin.g.a.a<x> getOnSeekEnd()
  {
    return this.ALp;
  }
  
  public final kotlin.g.a.a<x> getOnSeekStart()
  {
    return this.ALo;
  }
  
  public final b getPlayStatusListener()
  {
    return this.zvL;
  }
  
  public final void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(280312);
    super.setIsPlay(paramBoolean);
    b localb = this.zvL;
    if (localb != null)
    {
      localb.lE(paramBoolean);
      AppMethodBeat.o(280312);
      return;
    }
    AppMethodBeat.o(280312);
  }
  
  public final void setOnCustomLoadingStatusChange(b<? super Boolean, x> paramb)
  {
    this.ALq = paramb;
  }
  
  public final void setOnSeekEnd(kotlin.g.a.a<x> parama)
  {
    this.ALp = parama;
  }
  
  public final void setOnSeekStart(kotlin.g.a.a<x> parama)
  {
    this.ALo = parama;
  }
  
  public final void setPlayStatusListener(b paramb)
  {
    this.zvL = paramb;
  }
  
  public final void setPlayTimeText(int paramInt)
  {
    AppMethodBeat.i(280314);
    TextView localTextView = this.pCd;
    p.j(localTextView, "mPlaytimeTv");
    localTextView.setText((CharSequence)(AQ(paramInt / 60) + ":" + AQ(paramInt % 60)));
    AppMethodBeat.o(280314);
  }
  
  public final void tY(int paramInt)
  {
    AppMethodBeat.i(280313);
    b localb = this.zvL;
    if (localb != null)
    {
      localb.tY(paramInt);
      AppMethodBeat.o(280313);
      return;
    }
    AppMethodBeat.o(280313);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onReplay", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void LX(long paramLong);
    
    public abstract void dJB();
    
    public abstract void lE(boolean paramBoolean);
    
    public abstract void tY(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(274025);
      p.j(paramMotionEvent, "event");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(274025);
        return false;
        FinderLongVideoPlayerSeekBar.a(this.ALv, (int)paramMotionEvent.getX());
        FinderLongVideoPlayerSeekBar.b(this.ALv, (int)paramMotionEvent.getY());
        AppMethodBeat.o(274025);
        return true;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          AppMethodBeat.o(274025);
          return false;
        }
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        if ((FinderLongVideoPlayerSeekBar.c(this.ALv)) || ((Math.abs((j - FinderLongVideoPlayerSeekBar.a(this.ALv)) / (i - FinderLongVideoPlayerSeekBar.b(this.ALv))) > 1.0F) && (Math.abs(j - FinderLongVideoPlayerSeekBar.a(this.ALv)) > FinderLongVideoPlayerSeekBar.d(this.ALv))))
        {
          if (!FinderLongVideoPlayerSeekBar.c(this.ALv))
          {
            paramView = this.ALv.getOnSeekStart();
            if (paramView != null) {
              paramView.invoke();
            }
            paramView = this.ALv;
            paramMotionEvent = this.ALw.getVideoView();
            if (paramMotionEvent == null) {
              break label377;
            }
          }
          label377:
          for (i = paramMotionEvent.getCurrentPlaySecond();; i = 0)
          {
            FinderLongVideoPlayerSeekBar.c(paramView, i);
            this.ALw.rg(false);
            this.ALv.setIsPlay(false);
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: start track move, startTime = " + FinderLongVideoPlayerSeekBar.e(this.ALv) + " videoTotalTime=" + this.ALv.getVideoTotalTime());
            FinderLongVideoPlayerSeekBar.a(this.ALv, true);
            float f = (j - FinderLongVideoPlayerSeekBar.a(this.ALv)) / this.ALw.getWidth();
            paramView = this.ALv;
            i = FinderLongVideoPlayerSeekBar.e(this.ALv);
            FinderLongVideoPlayerSeekBar.d(paramView, kotlin.h.a.dm(f * this.ALv.getVideoTotalTime()) + i);
            this.ALv.seek(FinderLongVideoPlayerSeekBar.f(this.ALv));
            AppMethodBeat.o(274025);
            return true;
          }
          if (FinderLongVideoPlayerSeekBar.c(this.ALv))
          {
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: seek end, target time = " + FinderLongVideoPlayerSeekBar.f(this.ALv));
            paramView = this.ALv.getOnSeekEnd();
            if (paramView != null) {
              paramView.invoke();
            }
            FinderLongVideoPlayerSeekBar.a(this.ALv, false);
            FinderLongVideoPlayerSeekBar.c(this.ALv, 0);
            this.ALv.tY(FinderLongVideoPlayerSeekBar.f(this.ALv));
            paramView = this.ALw.getVideoView();
            if (paramView != null) {
              paramView.a(FinderLongVideoPlayerSeekBar.f(this.ALv), true);
            }
            this.ALw.rg(true);
            this.ALv.setIsPlay(true);
            FinderLongVideoPlayerSeekBar.d(this.ALv, 0);
            AppMethodBeat.o(274025);
            return true;
          }
          if ((Math.abs(paramMotionEvent.getX() - FinderLongVideoPlayerSeekBar.a(this.ALv)) < FinderLongVideoPlayerSeekBar.d(this.ALv)) && (Math.abs(paramMotionEvent.getY() - FinderLongVideoPlayerSeekBar.b(this.ALv)) < FinderLongVideoPlayerSeekBar.d(this.ALv)))
          {
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: performClick");
            this.ALw.performClick();
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */