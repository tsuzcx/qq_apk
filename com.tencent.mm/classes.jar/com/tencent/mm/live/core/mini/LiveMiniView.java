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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/mini/LiveMiniView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentState", "", "mAnimationRunnable", "com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Lcom/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1;", "mAnimationStartPos", "Landroid/graphics/Point;", "mAnimationTargetPos", "mFingerPosOnDown", "Landroid/graphics/PointF;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mScreenResolution", "mStartTime", "", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mViewPosOnDown", "mWindowManager", "Landroid/view/WindowManager;", "stateTextView", "Landroid/widget/TextView;", "addStateView", "", "onAnimationBegin", "onAnimationEnd", "onMoveStop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "startAbsorbAnimation", "x", "", "y", "updateState", "state", "updateWindowPosition", "", "Companion", "plugin-core_release"})
public final class LiveMiniView
  extends RelativeLayout
{
  public static final LiveMiniView.a gKF;
  private final Point gKA;
  private Point gKB;
  private WindowManager gKC;
  private ap gKD;
  private final b gKE;
  private final PointF gKx;
  private final Point gKy;
  private final Point gKz;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(216923);
    gKF = new LiveMiniView.a((byte)0);
    AppMethodBeat.o(216923);
  }
  
  public LiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216922);
    this.gKx = new PointF();
    this.gKy = new Point();
    this.gKz = new Point();
    this.gKA = new Point();
    this.gKD = new ap();
    this.gKE = new b(this);
    paramAttributeSet = paramContext.getSystemService("window");
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(216922);
      throw paramContext;
    }
    this.gKC = ((WindowManager)paramAttributeSet);
    paramAttributeSet = this.gKC;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getDefaultDisplay();
      if (paramAttributeSet == null) {}
    }
    for (int i = paramAttributeSet.getWidth();; i = 0)
    {
      paramAttributeSet = this.gKC;
      int j = k;
      if (paramAttributeSet != null)
      {
        paramAttributeSet = paramAttributeSet.getDefaultDisplay();
        j = k;
        if (paramAttributeSet != null) {
          j = paramAttributeSet.getHeight();
        }
      }
      this.gKB = new Point(i, j);
      setBackgroundColor(paramContext.getResources().getColor(2131100017));
      AppMethodBeat.o(216922);
      return;
    }
  }
  
  private final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216920);
    if (this.gKC != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(216920);
        throw ((Throwable)localObject);
      }
      localObject = (WindowManager.LayoutParams)localObject;
      ((WindowManager.LayoutParams)localObject).x = paramInt1;
      ((WindowManager.LayoutParams)localObject).y = paramInt2;
      ad.d("MicroMsg.LiveCoreMini", "updateWindowPosition, x: %d, y: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y) });
      try
      {
        if (getParent() != null)
        {
          WindowManager localWindowManager = this.gKC;
          if (localWindowManager != null)
          {
            localWindowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(216920);
            return;
          }
          AppMethodBeat.o(216920);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.LiveCoreMini", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(216920);
  }
  
  public final View.OnClickListener getMOnClickListener()
  {
    return this.mOnClickListener;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(216921);
    super.onAnimationEnd();
    AppMethodBeat.o(216921);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    AppMethodBeat.i(216919);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(216919);
        return true;
        this.gKx.x = paramMotionEvent.getRawX();
        this.gKx.y = paramMotionEvent.getRawY();
        paramMotionEvent = getLayoutParams();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
          AppMethodBeat.o(216919);
          throw paramMotionEvent;
        }
        paramMotionEvent = (WindowManager.LayoutParams)paramMotionEvent;
        this.gKy.x = paramMotionEvent.x;
        this.gKy.y = paramMotionEvent.y;
        paramMotionEvent = this.gKC;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.getDefaultDisplay();
          if (paramMotionEvent == null) {}
        }
        for (i = paramMotionEvent.getWidth();; i = 0)
        {
          paramMotionEvent = this.gKC;
          int j = k;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.getDefaultDisplay();
            j = k;
            if (paramMotionEvent != null) {
              j = paramMotionEvent.getHeight();
            }
          }
          this.gKB = new Point(i, j);
          break;
        }
        cR((int)Math.max(Math.min(this.gKy.x + paramMotionEvent.getRawX() - this.gKx.x, this.gKB.x), 0.0F), (int)Math.max(Math.min(this.gKy.y + paramMotionEvent.getRawY() - this.gKx.y, this.gKB.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.gKx.x) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.gKx.y) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (this.mOnClickListener != null))
    {
      View.OnClickListener localOnClickListener = this.mOnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick((View)this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gKz.x = ((int)Math.max(Math.min(f1 + this.gKy.x - this.gKx.x, this.gKB.x), 0.0F));
    this.gKz.y = ((int)Math.max(Math.min(f2 + this.gKy.y - this.gKx.y, this.gKB.y), 0.0F));
    int i = BackwardSupportUtil.b.g(getContext(), 5.0F);
    if (this.gKz.x + getWidth() / 2 <= this.gKB.x / 2) {}
    for (this.gKA.x = i;; this.gKA.x = (this.gKB.x - getWidth() - i))
    {
      this.gKA.y = this.gKz.y;
      this.mStartTime = System.currentTimeMillis();
      this.gKD.postDelayed((Runnable)this.gKE, 5L);
      break;
    }
  }
  
  public final void setMOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(216918);
      float f = (float)(System.currentTimeMillis() - LiveMiniView.a(this.gKG)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        LiveMiniView.b(this.gKG).postDelayed((Runnable)this, 5L);
        LiveMiniView localLiveMiniView = this.gKG;
        int i = LiveMiniView.c(this.gKG).x;
        int j = (int)((LiveMiniView.d(this.gKG).x * 1.0F - LiveMiniView.c(this.gKG).x) * f);
        int k = LiveMiniView.c(this.gKG).y;
        LiveMiniView.a(localLiveMiniView, i + j, (int)(f * (LiveMiniView.d(this.gKG).y * 1.0F - LiveMiniView.c(this.gKG).y)) + k);
        AppMethodBeat.o(216918);
        return;
      }
      LiveMiniView.a(this.gKG, LiveMiniView.d(this.gKG).x, LiveMiniView.d(this.gKG).y);
      this.gKG.onAnimationEnd();
      AppMethodBeat.o(216918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveMiniView
 * JD-Core Version:    0.7.0.1
 */