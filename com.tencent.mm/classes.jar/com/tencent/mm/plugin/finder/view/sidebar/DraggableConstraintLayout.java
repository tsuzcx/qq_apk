package com.tencent.mm.plugin.finder.view.sidebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MIN_DISTANCE_FOR_FLING", "angleRate", "", "dragListener", "Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout$DragListener;", "getDragListener", "()Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout$DragListener;", "setDragListener", "(Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout$DragListener;)V", "dragMode", "isNeedIntercept", "", "mActivePointerId", "mIsBeingDragged", "mLastMotionX", "mLastMotionY", "mTouchSlop", "mVelocityTracker", "Landroid/view/VelocityTracker;", "maxTotalDistance", "maxVelocity", "minVelocity", "springBackDistance", "totalDistance", "calcTotalDistance", "", "stepDistance", "checkAngle", "x", "y", "checkCanStart", "distance", "matchDirection", "ev", "Landroid/view/MotionEvent;", "dealMotionEnd", "debugLog", "log", "", "determineSpringBack", "disableDrag", "enableDrag", "directionToLeft", "initOrResetVelocityTracker", "initVelocityTrackerIfNotExists", "isEnableDrag", "onInterceptTouchEvent", "onTouchEvent", "recycleVelocityTracker", "requestDisallowInterceptTouchEvent", "disallowIntercept", "setAngle", "angle", "setNeedIntercept", "need", "Companion", "DragListener", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DraggableConstraintLayout
  extends ConstraintLayout
{
  public static final DraggableConstraintLayout.a GIg;
  public static final int GIp = 0;
  private static final int GIq;
  private static final int GIr;
  private static int GIs;
  private static final int INVALID_POINTER;
  private static final String TAG;
  private boolean FhA;
  private int GIh;
  private int GIi;
  private double GIj;
  public int GIk;
  private int GIl;
  private int GIm;
  private b GIn;
  private int GIo;
  private int GlE;
  private int MIN_DISTANCE_FOR_FLING;
  private int bwC;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(344662);
    GIg = new DraggableConstraintLayout.a((byte)0);
    TAG = "Finder.DraggableConstraintLayout";
    INVALID_POINTER = -1;
    GIq = 1;
    GIr = 2;
    GIs = 45;
    AppMethodBeat.o(344662);
  }
  
  public DraggableConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344585);
    this.mTouchSlop = 8;
    this.GIh = 8000;
    this.MIN_DISTANCE_FOR_FLING = 25;
    this.GIi = 400;
    this.GIj = Math.tan(GIs / 180.0F * 3.141592653589793D);
    this.GIk = GIp;
    this.GIm = 2147483647;
    this.mActivePointerId = INVALID_POINTER;
    this.FhA = true;
    paramContext = ViewConfiguration.get(getContext());
    if (paramContext == null)
    {
      this.mTouchSlop = i;
      if (paramContext != null) {
        break label167;
      }
    }
    label167:
    for (i = 8000;; i = paramContext.getScaledMaximumFlingVelocity())
    {
      this.GIh = i;
      this.MIN_DISTANCE_FOR_FLING = a.fromDPToPix(getContext(), 25);
      this.GIi = a.fromDPToPix(getContext(), 400);
      AppMethodBeat.o(344585);
      return;
      i = paramContext.getScaledTouchSlop();
      break;
    }
  }
  
  public DraggableConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344590);
    this.mTouchSlop = 8;
    this.GIh = 8000;
    this.MIN_DISTANCE_FOR_FLING = 25;
    this.GIi = 400;
    this.GIj = Math.tan(GIs / 180.0F * 3.141592653589793D);
    this.GIk = GIp;
    this.GIm = 2147483647;
    this.mActivePointerId = INVALID_POINTER;
    this.FhA = true;
    paramContext = ViewConfiguration.get(getContext());
    if (paramContext == null)
    {
      paramInt = i;
      this.mTouchSlop = paramInt;
      if (paramContext != null) {
        break label172;
      }
    }
    label172:
    for (paramInt = 8000;; paramInt = paramContext.getScaledMaximumFlingVelocity())
    {
      this.GIh = paramInt;
      this.MIN_DISTANCE_FOR_FLING = a.fromDPToPix(getContext(), 25);
      this.GIi = a.fromDPToPix(getContext(), 400);
      AppMethodBeat.o(344590);
      return;
      paramInt = paramContext.getScaledTouchSlop();
      break;
    }
  }
  
  private final void Fk()
  {
    AppMethodBeat.i(344619);
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    AppMethodBeat.o(344619);
  }
  
  private final void Fl()
  {
    AppMethodBeat.i(344626);
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.mVelocityTracker = null;
    AppMethodBeat.o(344626);
  }
  
  private final boolean UN(int paramInt)
  {
    AppMethodBeat.i(344632);
    if (Math.abs(paramInt) > this.GIl)
    {
      AppMethodBeat.o(344632);
      return false;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(1000, this.GIh);
    }
    localVelocityTracker = this.mVelocityTracker;
    float f;
    int i;
    if (localVelocityTracker == null)
    {
      f = 0.0F;
      if (this.GIk != GIq) {
        break label131;
      }
      if (f >= 0.0F) {
        break label126;
      }
      i = 1;
    }
    for (;;)
    {
      if ((Math.abs(paramInt) <= this.MIN_DISTANCE_FOR_FLING) || (i == 0) || (Math.abs(f) <= this.GIi)) {
        break label147;
      }
      AppMethodBeat.o(344632);
      return false;
      f = localVelocityTracker.getXVelocity(this.mActivePointerId);
      break;
      label126:
      i = 0;
      continue;
      label131:
      if (f > 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label147:
    AppMethodBeat.o(344632);
    return true;
  }
  
  private final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344605);
    if ((Math.abs(paramInt1) > this.mTouchSlop) && (paramBoolean) && (iF(paramInt2, paramInt3)))
    {
      this.GlE = paramInt2;
      this.bwC = paramInt3;
      this.mIsBeingDragged = true;
      Object localObject = this.GIn;
      if (localObject != null) {
        ((b)localObject).fmg();
      }
      Fk();
      localObject = this.mVelocityTracker;
      if (localObject != null) {
        ((VelocityTracker)localObject).addMovement(paramMotionEvent);
      }
      paramMotionEvent = getParent();
      if (paramMotionEvent != null)
      {
        paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        AppMethodBeat.o(344605);
      }
    }
    else if (Math.abs(paramInt1) > this.mTouchSlop)
    {
      this.GlE = paramInt2;
      this.bwC = paramInt3;
    }
    AppMethodBeat.o(344605);
  }
  
  private final void fmc()
  {
    AppMethodBeat.i(344612);
    b localb = this.GIn;
    if (localb != null) {
      localb.ve(UN(this.GIo));
    }
    this.mIsBeingDragged = false;
    this.mActivePointerId = INVALID_POINTER;
    this.GIo = 0;
    this.GlE = 0;
    this.bwC = 0;
    Fl();
    AppMethodBeat.o(344612);
  }
  
  private final boolean iF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344598);
    int i = paramInt1 - this.GlE;
    int j = paramInt2 - this.bwC;
    double d1 = Math.abs(i * this.GIj);
    double d2 = -1.0D * d1;
    Log.i("lxl layout", "checkAngle angleRate:" + this.GIj + ", x,y:(" + paramInt1 + ", " + paramInt2 + "), lastX,Y:(" + this.GlE + ", " + this.bwC + "), x1,y1:(" + i + ", " + j + "), minY:" + d2 + ", maxY:" + d1);
    if ((j >= d2) && (j <= d1))
    {
      AppMethodBeat.o(344598);
      return true;
    }
    AppMethodBeat.o(344598);
    return false;
  }
  
  public final b getDragListener()
  {
    return this.GIn;
  }
  
  public final void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344687);
    if (paramBoolean) {}
    for (int i = GIq;; i = GIr)
    {
      this.GIk = i;
      this.GIm = paramInt2;
      this.GIl = paramInt1;
      Log.i("lxl layout", "enableDrag, dragMode:" + this.GIk + ", maxTotalDistance:" + paramInt2 + ", springBackDistance:" + paramInt1);
      AppMethodBeat.o(344687);
      return;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    AppMethodBeat.i(344700);
    s.checkNotNull(paramMotionEvent);
    Log.i("lxl layout", s.X("onInterceptTouchEvent, ", Integer.valueOf(paramMotionEvent.getAction() & 0xFF)));
    boolean bool1;
    if ((this.GIk == GIp) || (!this.FhA))
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(344700);
      return bool1;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged))
    {
      AppMethodBeat.o(344700);
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      bool1 = this.mIsBeingDragged;
      AppMethodBeat.o(344700);
      return bool1;
      i = this.mActivePointerId;
      if (i == INVALID_POINTER)
      {
        bool1 = this.mIsBeingDragged;
        AppMethodBeat.o(344700);
        return bool1;
      }
      int j = paramMotionEvent.findPointerIndex(i);
      if (j == -1)
      {
        bool1 = this.mIsBeingDragged;
        AppMethodBeat.o(344700);
        return bool1;
      }
      i = (int)paramMotionEvent.getX(j);
      j = (int)paramMotionEvent.getY(j);
      int k = i - this.GlE;
      label236:
      Object localObject;
      if (this.GIk == GIq) {
        if (k < 0)
        {
          bool1 = true;
          localObject = new StringBuilder("onInterceptTouchEvent ACTION_MOVE x:").append(i).append(", distance:").append(k).append(", matchDirection:").append(bool1).append(", check: ");
          if (Math.abs(k) <= this.mTouchSlop) {
            break label365;
          }
          bool2 = bool3;
          if (!this.mIsBeingDragged) {
            if (!bool1) {
              break label365;
            }
          }
        }
      }
      label365:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        Log.i("lxl layout", bool2);
        a(k, bool1, i, j, paramMotionEvent);
        break;
        bool1 = false;
        break label236;
        if (k > 0)
        {
          bool1 = true;
          break label236;
        }
        bool1 = false;
        break label236;
      }
      if (!this.mIsBeingDragged)
      {
        Log.i("lxl layout", "onInterceptTouchEvent ACTION_DOWN begin");
        this.GlE = ((int)paramMotionEvent.getX());
        this.bwC = ((int)paramMotionEvent.getY());
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        if (this.mVelocityTracker == null) {
          this.mVelocityTracker = VelocityTracker.obtain();
        }
        for (;;)
        {
          localObject = this.mVelocityTracker;
          if (localObject == null) {
            break;
          }
          ((VelocityTracker)localObject).addMovement(paramMotionEvent);
          break;
          localObject = this.mVelocityTracker;
          if (localObject != null) {
            ((VelocityTracker)localObject).clear();
          }
        }
        Log.i("lxl layout", s.X("onInterceptTouchEvent ACTION_UP/ACTION_CANCEL mIsBeingDragged:", Boolean.valueOf(this.mIsBeingDragged)));
        if (this.mIsBeingDragged) {
          fmc();
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344715);
    s.checkNotNull(paramMotionEvent);
    Log.i("lxl layout", s.X("onTouchEvent , ", Integer.valueOf(paramMotionEvent.getAction() & 0xFF)));
    boolean bool;
    if (this.GIk == GIp)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(344715);
      return bool;
    }
    Fk();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(344715);
      return true;
      int i = this.mActivePointerId;
      if (i == INVALID_POINTER)
      {
        AppMethodBeat.o(344715);
        return true;
      }
      int j = paramMotionEvent.findPointerIndex(i);
      if (j == -1)
      {
        AppMethodBeat.o(344715);
        return true;
      }
      i = (int)paramMotionEvent.getX(j);
      j = (int)paramMotionEvent.getY(j);
      int k = i - this.GlE;
      if (this.GIk == GIq) {
        if (k < 0) {
          bool = true;
        }
      }
      for (;;)
      {
        Log.i("lxl layout", "onTouchEvent ACTION_MOVE x:" + i + ", distance:" + k + ", mTouchSlop:" + this.mTouchSlop + ", matchDirection:" + bool);
        if (this.mIsBeingDragged) {
          break label289;
        }
        a(k, bool, i, j, paramMotionEvent);
        break;
        bool = false;
        continue;
        if (k > 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      label289:
      this.GIo = (i - this.GlE + this.GIo);
      if ((this.GIo > 0) && (this.GIk == GIq))
      {
        this.GIo = 0;
        label326:
        if (Math.abs(this.GIo) > this.GIm) {
          if (this.GIo <= 0) {
            break label453;
          }
        }
      }
      label453:
      for (this.GIo = this.GIm;; this.GIo = (-this.GIm))
      {
        Object localObject = this.GIn;
        if (localObject != null) {
          ((b)localObject).UP(this.GIo);
        }
        this.mIsBeingDragged = true;
        this.GlE = i;
        this.bwC = j;
        localObject = this.mVelocityTracker;
        if (localObject != null) {
          ((VelocityTracker)localObject).addMovement(paramMotionEvent);
        }
        paramMotionEvent = getParent();
        if (paramMotionEvent == null) {
          break;
        }
        paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        break;
        if ((this.GIo >= 0) || (this.GIk != GIr)) {
          break label326;
        }
        this.GIo = 0;
        break label326;
      }
      Log.i("lxl layout", s.X("onTouchEvent ACTION_UP/ACTION_CANCEL mIsBeingDragged:", Boolean.valueOf(this.mIsBeingDragged)));
      if (this.mIsBeingDragged) {
        fmc();
      }
    }
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(344723);
    if (!this.mIsBeingDragged)
    {
      Log.i("lxl layout", s.X("requestDisallowInterceptTouchEvent ", Boolean.valueOf(paramBoolean)));
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(344723);
  }
  
  public final void setAngle(int paramInt)
  {
    AppMethodBeat.i(344705);
    this.GIj = Math.tan(paramInt % 180 / 180.0F * 3.141592653589793D);
    AppMethodBeat.o(344705);
  }
  
  public final void setDragListener(b paramb)
  {
    this.GIn = paramb;
  }
  
  public final void setNeedIntercept(boolean paramBoolean)
  {
    AppMethodBeat.i(370631);
    this.FhA = paramBoolean;
    Log.i("lxl layout", s.X("setNeedIntercept, ", Boolean.valueOf(this.FhA)));
    AppMethodBeat.o(370631);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout$DragListener;", "", "onDragEnd", "", "shouldSpringBack", "", "onDragMove", "distance", "", "onDragStart", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void UP(int paramInt);
    
    public abstract void fmg();
    
    public abstract void ve(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.sidebar.DraggableConstraintLayout
 * JD-Core Version:    0.7.0.1
 */