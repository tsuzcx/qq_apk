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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/mini/LiveMiniView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentState", "", "mAnimationRunnable", "com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Lcom/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1;", "mAnimationStartPos", "Landroid/graphics/Point;", "mAnimationTargetPos", "mFingerPosOnDown", "Landroid/graphics/PointF;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mScreenResolution", "mStartTime", "", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mViewPosOnDown", "mWindowManager", "Landroid/view/WindowManager;", "stateTextView", "Landroid/widget/TextView;", "addStateView", "", "onAnimationBegin", "onAnimationEnd", "onMoveStop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "startAbsorbAnimation", "x", "", "y", "updateState", "state", "updateWindowPosition", "", "Companion", "plugin-core_release"})
public final class LiveMiniView
  extends RelativeLayout
{
  public static final LiveMiniView.a gqV;
  private final PointF gqN;
  private final Point gqO;
  private final Point gqP;
  private final Point gqQ;
  private Point gqR;
  private WindowManager gqS;
  private ao gqT;
  private final b gqU;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(209265);
    gqV = new LiveMiniView.a((byte)0);
    AppMethodBeat.o(209265);
  }
  
  public LiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209264);
    this.gqN = new PointF();
    this.gqO = new Point();
    this.gqP = new Point();
    this.gqQ = new Point();
    this.gqT = new ao();
    this.gqU = new b(this);
    paramAttributeSet = paramContext.getSystemService("window");
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(209264);
      throw paramContext;
    }
    this.gqS = ((WindowManager)paramAttributeSet);
    paramAttributeSet = this.gqS;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getDefaultDisplay();
      if (paramAttributeSet == null) {}
    }
    for (int i = paramAttributeSet.getWidth();; i = 0)
    {
      paramAttributeSet = this.gqS;
      int j = k;
      if (paramAttributeSet != null)
      {
        paramAttributeSet = paramAttributeSet.getDefaultDisplay();
        j = k;
        if (paramAttributeSet != null) {
          j = paramAttributeSet.getHeight();
        }
      }
      this.gqR = new Point(i, j);
      setBackgroundColor(paramContext.getResources().getColor(2131100017));
      AppMethodBeat.o(209264);
      return;
    }
  }
  
  private final void cP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209262);
    if (this.gqS != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(209262);
        throw ((Throwable)localObject);
      }
      localObject = (WindowManager.LayoutParams)localObject;
      ((WindowManager.LayoutParams)localObject).x = paramInt1;
      ((WindowManager.LayoutParams)localObject).y = paramInt2;
      ac.d("MicroMsg.LiveCoreMini", "updateWindowPosition, x: %d, y: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y) });
      try
      {
        if (getParent() != null)
        {
          WindowManager localWindowManager = this.gqS;
          if (localWindowManager != null)
          {
            localWindowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(209262);
            return;
          }
          AppMethodBeat.o(209262);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.LiveCoreMini", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(209262);
  }
  
  public final View.OnClickListener getMOnClickListener()
  {
    return this.mOnClickListener;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(209263);
    super.onAnimationEnd();
    AppMethodBeat.o(209263);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    AppMethodBeat.i(209261);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(209261);
        return true;
        this.gqN.x = paramMotionEvent.getRawX();
        this.gqN.y = paramMotionEvent.getRawY();
        paramMotionEvent = getLayoutParams();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
          AppMethodBeat.o(209261);
          throw paramMotionEvent;
        }
        paramMotionEvent = (WindowManager.LayoutParams)paramMotionEvent;
        this.gqO.x = paramMotionEvent.x;
        this.gqO.y = paramMotionEvent.y;
        paramMotionEvent = this.gqS;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.getDefaultDisplay();
          if (paramMotionEvent == null) {}
        }
        for (i = paramMotionEvent.getWidth();; i = 0)
        {
          paramMotionEvent = this.gqS;
          int j = k;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.getDefaultDisplay();
            j = k;
            if (paramMotionEvent != null) {
              j = paramMotionEvent.getHeight();
            }
          }
          this.gqR = new Point(i, j);
          break;
        }
        cP((int)Math.max(Math.min(this.gqO.x + paramMotionEvent.getRawX() - this.gqN.x, this.gqR.x), 0.0F), (int)Math.max(Math.min(this.gqO.y + paramMotionEvent.getRawY() - this.gqN.y, this.gqR.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.gqN.x) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.gqN.y) < BackwardSupportUtil.b.g(getContext(), 3.0F)) && (this.mOnClickListener != null))
    {
      View.OnClickListener localOnClickListener = this.mOnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick((View)this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gqP.x = ((int)Math.max(Math.min(f1 + this.gqO.x - this.gqN.x, this.gqR.x), 0.0F));
    this.gqP.y = ((int)Math.max(Math.min(f2 + this.gqO.y - this.gqN.y, this.gqR.y), 0.0F));
    int i = BackwardSupportUtil.b.g(getContext(), 5.0F);
    if (this.gqP.x + getWidth() / 2 <= this.gqR.x / 2) {}
    for (this.gqQ.x = i;; this.gqQ.x = (this.gqR.x - getWidth() - i))
    {
      this.gqQ.y = this.gqP.y;
      this.mStartTime = System.currentTimeMillis();
      this.gqT.postDelayed((Runnable)this.gqU, 5L);
      break;
    }
  }
  
  public final void setMOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/mini/LiveMiniView$mAnimationRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(209260);
      float f = (float)(System.currentTimeMillis() - LiveMiniView.a(this.gqW)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        LiveMiniView.b(this.gqW).postDelayed((Runnable)this, 5L);
        LiveMiniView localLiveMiniView = this.gqW;
        int i = LiveMiniView.c(this.gqW).x;
        int j = (int)((LiveMiniView.d(this.gqW).x * 1.0F - LiveMiniView.c(this.gqW).x) * f);
        int k = LiveMiniView.c(this.gqW).y;
        LiveMiniView.a(localLiveMiniView, i + j, (int)(f * (LiveMiniView.d(this.gqW).y * 1.0F - LiveMiniView.c(this.gqW).y)) + k);
        AppMethodBeat.o(209260);
        return;
      }
      LiveMiniView.a(this.gqW, LiveMiniView.d(this.gqW).x, LiveMiniView.d(this.gqW).y);
      this.gqW.onAnimationEnd();
      AppMethodBeat.o(209260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveMiniView
 * JD-Core Version:    0.7.0.1
 */