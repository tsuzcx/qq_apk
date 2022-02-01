package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/mini/LiveMiniView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentState", "", "mAnimationRunnable", "com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Lcom/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1;", "mAnimationStartPos", "Landroid/graphics/Point;", "mAnimationTargetPos", "mFingerPosOnDown", "Landroid/graphics/PointF;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mScreenResolution", "mStartTime", "", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mViewPosOnDown", "mWindowManager", "Landroid/view/WindowManager;", "stateTextView", "Landroid/widget/TextView;", "addStateView", "", "onAnimationBegin", "onAnimationEnd", "onMoveStop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "startAbsorbAnimation", "x", "", "y", "updateState", "state", "updateWindowPosition", "", "Companion", "plugin-core_release"})
public final class LiveMiniView
  extends RelativeLayout
{
  public static final LiveMiniView.a gNo;
  private final PointF gNg;
  private final Point gNh;
  private final Point gNi;
  private final Point gNj;
  private Point gNk;
  private WindowManager gNl;
  private aq gNm;
  private final b gNn;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(196935);
    gNo = new LiveMiniView.a((byte)0);
    AppMethodBeat.o(196935);
  }
  
  public LiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196934);
    this.gNg = new PointF();
    this.gNh = new Point();
    this.gNi = new Point();
    this.gNj = new Point();
    this.gNm = new aq();
    this.gNn = new b(this);
    paramAttributeSet = paramContext.getSystemService("window");
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(196934);
      throw paramContext;
    }
    this.gNl = ((WindowManager)paramAttributeSet);
    paramAttributeSet = this.gNl;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getDefaultDisplay();
      if (paramAttributeSet == null) {}
    }
    for (int i = paramAttributeSet.getWidth();; i = 0)
    {
      paramAttributeSet = this.gNl;
      int j = k;
      if (paramAttributeSet != null)
      {
        paramAttributeSet = paramAttributeSet.getDefaultDisplay();
        j = k;
        if (paramAttributeSet != null) {
          j = paramAttributeSet.getHeight();
        }
      }
      this.gNk = new Point(i, j);
      setBackgroundColor(paramContext.getResources().getColor(2131100017));
      AppMethodBeat.o(196934);
      return;
    }
  }
  
  private final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196932);
    if (this.gNl != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(196932);
        throw ((Throwable)localObject);
      }
      localObject = (WindowManager.LayoutParams)localObject;
      ((WindowManager.LayoutParams)localObject).x = paramInt1;
      ((WindowManager.LayoutParams)localObject).y = paramInt2;
      ae.d("MicroMsg.LiveCoreMini", "updateWindowPosition, x: %d, y: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y) });
      try
      {
        if (getParent() != null)
        {
          WindowManager localWindowManager = this.gNl;
          if (localWindowManager != null)
          {
            localWindowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(196932);
            return;
          }
          AppMethodBeat.o(196932);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.LiveCoreMini", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(196932);
  }
  
  public final View.OnClickListener getMOnClickListener()
  {
    return this.mOnClickListener;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(196933);
    super.onAnimationEnd();
    AppMethodBeat.o(196933);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    AppMethodBeat.i(196931);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(196931);
        return true;
        this.gNg.x = paramMotionEvent.getRawX();
        this.gNg.y = paramMotionEvent.getRawY();
        paramMotionEvent = getLayoutParams();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
          AppMethodBeat.o(196931);
          throw paramMotionEvent;
        }
        paramMotionEvent = (WindowManager.LayoutParams)paramMotionEvent;
        this.gNh.x = paramMotionEvent.x;
        this.gNh.y = paramMotionEvent.y;
        paramMotionEvent = this.gNl;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.getDefaultDisplay();
          if (paramMotionEvent == null) {}
        }
        for (i = paramMotionEvent.getWidth();; i = 0)
        {
          paramMotionEvent = this.gNl;
          int j = k;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.getDefaultDisplay();
            j = k;
            if (paramMotionEvent != null) {
              j = paramMotionEvent.getHeight();
            }
          }
          this.gNk = new Point(i, j);
          break;
        }
        cR((int)Math.max(Math.min(this.gNh.x + paramMotionEvent.getRawX() - this.gNg.x, this.gNk.x), 0.0F), (int)Math.max(Math.min(this.gNh.y + paramMotionEvent.getRawY() - this.gNg.y, this.gNk.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.gNg.x) < BackwardSupportUtil.b.h(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.gNg.y) < BackwardSupportUtil.b.h(getContext(), 3.0F)) && (this.mOnClickListener != null))
    {
      View.OnClickListener localOnClickListener = this.mOnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick((View)this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gNi.x = ((int)Math.max(Math.min(f1 + this.gNh.x - this.gNg.x, this.gNk.x), 0.0F));
    this.gNi.y = ((int)Math.max(Math.min(f2 + this.gNh.y - this.gNg.y, this.gNk.y), 0.0F));
    int i = BackwardSupportUtil.b.h(getContext(), 5.0F);
    if (this.gNi.x + getWidth() / 2 <= this.gNk.x / 2) {}
    for (this.gNj.x = i;; this.gNj.x = (this.gNk.x - getWidth() - i))
    {
      this.gNj.y = this.gNi.y;
      this.mStartTime = System.currentTimeMillis();
      this.gNm.postDelayed((Runnable)this.gNn, 5L);
      break;
    }
  }
  
  public final void setMOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(196930);
      float f = (float)(System.currentTimeMillis() - LiveMiniView.a(this.gNp)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        LiveMiniView.b(this.gNp).postDelayed((Runnable)this, 5L);
        LiveMiniView localLiveMiniView = this.gNp;
        int i = LiveMiniView.c(this.gNp).x;
        int j = (int)((LiveMiniView.d(this.gNp).x * 1.0F - LiveMiniView.c(this.gNp).x) * f);
        int k = LiveMiniView.c(this.gNp).y;
        LiveMiniView.a(localLiveMiniView, i + j, (int)(f * (LiveMiniView.d(this.gNp).y * 1.0F - LiveMiniView.c(this.gNp).y)) + k);
        AppMethodBeat.o(196930);
        return;
      }
      LiveMiniView.a(this.gNp, LiveMiniView.d(this.gNp).x, LiveMiniView.d(this.gNp).y);
      this.gNp.onAnimationEnd();
      AppMethodBeat.o(196930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveMiniView
 * JD-Core Version:    0.7.0.1
 */