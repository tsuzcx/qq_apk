package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "downY", "hasStartTrackMove", "", "moveTime", "onCustomLoadingStatusChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isLoading", "", "getOnCustomLoadingStatusChange", "()Lkotlin/jvm/functions/Function1;", "setOnCustomLoadingStatusChange", "(Lkotlin/jvm/functions/Function1;)V", "onSeekEnd", "Lkotlin/Function0;", "getOnSeekEnd", "()Lkotlin/jvm/functions/Function0;", "setOnSeekEnd", "(Lkotlin/jvm/functions/Function0;)V", "onSeekStart", "getOnSeekStart", "setOnSeekStart", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "setPlayStatusListener", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;)V", "startTime", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "bindFinderVideoLayoutTouch", "videoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "getLayoutId", "onSeekTo", "timeStamp", "setIsPlay", "isPlay", "setPlayTimeText", "playTime", "updateTimeMs", "time", "", "Companion", "PlayStatusListener", "plugin-finder_release"})
public final class FinderLongVideoPlayerSeekBar
  extends RedesignVideoPlayerSeekBar
{
  public static final a wcL;
  private int dvv;
  private int kuv;
  private int kuw;
  b uKd;
  private kotlin.g.a.a<x> wcF;
  private kotlin.g.a.a<x> wcG;
  private b<? super Boolean, x> wcH;
  private boolean wcI;
  private final f wcJ;
  private int wcK;
  
  static
  {
    AppMethodBeat.i(254058);
    wcL = new a((byte)0);
    AppMethodBeat.o(254058);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254056);
    this.wcJ = g.ah((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(254056);
  }
  
  public FinderLongVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254057);
    this.wcJ = g.ah((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(254057);
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(254055);
    int i = ((Number)this.wcJ.getValue()).intValue();
    AppMethodBeat.o(254055);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131494672;
  }
  
  public final b<Boolean, x> getOnCustomLoadingStatusChange()
  {
    return this.wcH;
  }
  
  public final kotlin.g.a.a<x> getOnSeekEnd()
  {
    return this.wcG;
  }
  
  public final kotlin.g.a.a<x> getOnSeekStart()
  {
    return this.wcF;
  }
  
  public final b getPlayStatusListener()
  {
    return this.uKd;
  }
  
  public final void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(254053);
    super.setIsPlay(paramBoolean);
    b localb = this.uKd;
    if (localb != null)
    {
      localb.kr(paramBoolean);
      AppMethodBeat.o(254053);
      return;
    }
    AppMethodBeat.o(254053);
  }
  
  public final void setOnCustomLoadingStatusChange(b<? super Boolean, x> paramb)
  {
    this.wcH = paramb;
  }
  
  public final void setOnSeekEnd(kotlin.g.a.a<x> parama)
  {
    this.wcG = parama;
  }
  
  public final void setOnSeekStart(kotlin.g.a.a<x> parama)
  {
    this.wcF = parama;
  }
  
  public final void setPlayStatusListener(b paramb)
  {
    this.uKd = paramb;
  }
  
  public final void setPlayTimeText(int paramInt)
  {
    AppMethodBeat.i(254054);
    TextView localTextView = this.mCQ;
    p.g(localTextView, "mPlaytimeTv");
    localTextView.setText((CharSequence)(xt((getVideoTotalTime() - paramInt) / 60) + ":" + xt((getVideoTotalTime() - paramInt) % 60)));
    AppMethodBeat.o(254054);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void kr(boolean paramBoolean);
    
    public abstract void onProgress(long paramLong);
    
    public abstract void rk(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(254051);
      p.g(paramMotionEvent, "event");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(254051);
        return false;
        FinderLongVideoPlayerSeekBar.a(this.wcM, (int)paramMotionEvent.getX());
        FinderLongVideoPlayerSeekBar.b(this.wcM, (int)paramMotionEvent.getY());
        AppMethodBeat.o(254051);
        return true;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          AppMethodBeat.o(254051);
          return false;
        }
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        if ((FinderLongVideoPlayerSeekBar.c(this.wcM)) || ((Math.abs((j - FinderLongVideoPlayerSeekBar.a(this.wcM)) / (i - FinderLongVideoPlayerSeekBar.b(this.wcM))) > 1.0F) && (Math.abs(j - FinderLongVideoPlayerSeekBar.a(this.wcM)) > FinderLongVideoPlayerSeekBar.d(this.wcM))))
        {
          if (!FinderLongVideoPlayerSeekBar.c(this.wcM))
          {
            paramView = this.wcM.getOnSeekStart();
            if (paramView != null) {
              paramView.invoke();
            }
            paramView = this.wcM;
            paramMotionEvent = this.wcN.getVideoView();
            if (paramMotionEvent == null) {
              break label369;
            }
          }
          label369:
          for (i = paramMotionEvent.getCurrentPlaySecond();; i = 0)
          {
            FinderLongVideoPlayerSeekBar.c(paramView, i);
            this.wcN.oQ(false);
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: start track move, startTime = " + FinderLongVideoPlayerSeekBar.e(this.wcM) + " videoTotalTime=" + this.wcM.getVideoTotalTime());
            FinderLongVideoPlayerSeekBar.a(this.wcM, true);
            float f = (j - FinderLongVideoPlayerSeekBar.a(this.wcM)) / this.wcN.getWidth();
            paramView = this.wcM;
            i = FinderLongVideoPlayerSeekBar.e(this.wcM);
            FinderLongVideoPlayerSeekBar.d(paramView, kotlin.h.a.cR(f * this.wcM.getVideoTotalTime()) + i);
            this.wcM.seek(FinderLongVideoPlayerSeekBar.f(this.wcM));
            AppMethodBeat.o(254051);
            return true;
          }
          if (FinderLongVideoPlayerSeekBar.c(this.wcM))
          {
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: seek end, target time = " + FinderLongVideoPlayerSeekBar.f(this.wcM));
            paramView = this.wcM.getOnSeekEnd();
            if (paramView != null) {
              paramView.invoke();
            }
            FinderLongVideoPlayerSeekBar.a(this.wcM, false);
            FinderLongVideoPlayerSeekBar.c(this.wcM, 0);
            paramView = this.wcN.getVideoView();
            if (paramView != null) {
              paramView.c(FinderLongVideoPlayerSeekBar.f(this.wcM), true);
            }
            this.wcN.oQ(true);
            FinderLongVideoPlayerSeekBar.d(this.wcM, 0);
            AppMethodBeat.o(254051);
            return true;
          }
          if ((Math.abs(paramMotionEvent.getX() - FinderLongVideoPlayerSeekBar.a(this.wcM)) < FinderLongVideoPlayerSeekBar.d(this.wcM)) && (Math.abs(paramMotionEvent.getY() - FinderLongVideoPlayerSeekBar.b(this.wcM)) < FinderLongVideoPlayerSeekBar.d(this.wcM)))
          {
            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: performClick");
            this.wcN.performClick();
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */