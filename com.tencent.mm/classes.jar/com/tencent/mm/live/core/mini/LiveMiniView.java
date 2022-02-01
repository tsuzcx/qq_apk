package com.tencent.mm.live.core.mini;

import android.content.Context;
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
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveMiniView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentState", "", "mAnimationRunnable", "com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Lcom/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1;", "mAnimationStartPos", "Landroid/graphics/Point;", "mAnimationTargetPos", "mFingerPosOnDown", "Landroid/graphics/PointF;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mScreenResolution", "mStartTime", "", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mViewPosOnDown", "mWindowManager", "Landroid/view/WindowManager;", "stateTextView", "Landroid/widget/TextView;", "addStateView", "", "onAnimationBegin", "onAnimationEnd", "onMoveStop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "startAbsorbAnimation", "x", "", "y", "updateState", "state", "updateWindowPosition", "", "Companion", "plugin-core_release"})
public final class LiveMiniView
  extends RelativeLayout
{
  public static final a qPl;
  private final PointF lPG;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private WindowManager oEl;
  private ap oFl;
  private final b qPk;
  private final Point zAO;
  private final Point zAP;
  private final Point zAQ;
  private Point zAR;
  
  static
  {
    AppMethodBeat.i(205729);
    qPl = new a((byte)0);
    AppMethodBeat.o(205729);
  }
  
  public LiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205728);
    this.lPG = new PointF();
    this.zAO = new Point();
    this.zAP = new Point();
    this.zAQ = new Point();
    this.oFl = new ap();
    this.qPk = new b(this);
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(205728);
      throw paramContext;
    }
    this.oEl = ((WindowManager)paramContext);
    paramContext = this.oEl;
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      if (paramContext == null) {}
    }
    for (int i = paramContext.getWidth();; i = 0)
    {
      paramContext = this.oEl;
      int j = k;
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        j = k;
        if (paramContext != null) {
          j = paramContext.getHeight();
        }
      }
      this.zAR = new Point(i, j);
      AppMethodBeat.o(205728);
      return;
    }
  }
  
  private final void iC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205726);
    if (this.oEl != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(205726);
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
          WindowManager localWindowManager = this.oEl;
          if (localWindowManager != null)
          {
            localWindowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(205726);
            return;
          }
          AppMethodBeat.o(205726);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.LiveCoreMini", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(205726);
  }
  
  public final View.OnClickListener getMOnClickListener()
  {
    return this.mOnClickListener;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(205727);
    super.onAnimationEnd();
    AppMethodBeat.o(205727);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    AppMethodBeat.i(205725);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(205725);
        return true;
        this.lPG.x = paramMotionEvent.getRawX();
        this.lPG.y = paramMotionEvent.getRawY();
        paramMotionEvent = getLayoutParams();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
          AppMethodBeat.o(205725);
          throw paramMotionEvent;
        }
        paramMotionEvent = (WindowManager.LayoutParams)paramMotionEvent;
        this.zAO.x = paramMotionEvent.x;
        this.zAO.y = paramMotionEvent.y;
        paramMotionEvent = this.oEl;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.getDefaultDisplay();
          if (paramMotionEvent == null) {}
        }
        for (i = paramMotionEvent.getWidth();; i = 0)
        {
          paramMotionEvent = this.oEl;
          int j = k;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.getDefaultDisplay();
            j = k;
            if (paramMotionEvent != null) {
              j = paramMotionEvent.getHeight();
            }
          }
          this.zAR = new Point(i, j);
          break;
        }
        iC((int)Math.max(Math.min(this.zAO.x + paramMotionEvent.getRawX() - this.lPG.x, this.zAR.x), 0.0F), (int)Math.max(Math.min(this.zAO.y + paramMotionEvent.getRawY() - this.lPG.y, this.zAR.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.lPG.x) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.lPG.y) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (this.mOnClickListener != null))
    {
      View.OnClickListener localOnClickListener = this.mOnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick((View)this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.zAP.x = ((int)Math.max(Math.min(f1 + this.zAO.x - this.lPG.x, this.zAR.x), 0.0F));
    this.zAP.y = ((int)Math.max(Math.min(f2 + this.zAO.y - this.lPG.y, this.zAR.y), 0.0F));
    int i = BackwardSupportUtil.b.g(getContext(), 5.0F);
    if (this.zAP.x + getWidth() / 2 <= this.zAR.x / 2) {}
    for (this.zAQ.x = i;; this.zAQ.x = (this.zAR.x - getWidth() - i))
    {
      this.zAQ.y = this.zAP.y;
      this.mStartTime = System.currentTimeMillis();
      this.oFl.postDelayed((Runnable)this.qPk, 5L);
      break;
    }
  }
  
  public final void setMOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveMiniView$Companion;", "", "()V", "DURATION_ANIMATION", "", "INTERVAL_UPDATE_POS", "LIVE_WIDGET_MARGIN", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(205724);
      float f = (float)(System.currentTimeMillis() - LiveMiniView.a(this.qPm)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        LiveMiniView.b(this.qPm).postDelayed((Runnable)this, 5L);
        LiveMiniView localLiveMiniView = this.qPm;
        int i = LiveMiniView.c(this.qPm).x;
        int j = (int)((LiveMiniView.d(this.qPm).x * 1.0F - LiveMiniView.c(this.qPm).x) * f);
        int k = LiveMiniView.c(this.qPm).y;
        LiveMiniView.a(localLiveMiniView, i + j, (int)(f * (LiveMiniView.d(this.qPm).y * 1.0F - LiveMiniView.c(this.qPm).y)) + k);
        AppMethodBeat.o(205724);
        return;
      }
      LiveMiniView.a(this.qPm, LiveMiniView.d(this.qPm).x, LiveMiniView.d(this.qPm).y);
      this.qPm.onAnimationEnd();
      AppMethodBeat.o(205724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveMiniView
 * JD-Core Version:    0.7.0.1
 */