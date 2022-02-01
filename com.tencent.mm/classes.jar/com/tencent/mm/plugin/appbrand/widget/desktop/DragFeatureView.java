package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private boolean canScroll = true;
  private Rect dtb = new Rect();
  private GestureDetector mDJ;
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  private RecyclerView mRecyclerView;
  private boolean omQ = false;
  protected int ooH;
  private Runnable ooI;
  private c ooJ;
  private RecyclerView.v ooK;
  int ooL = -1;
  private Vibrator ooM;
  private View ooN;
  protected Rect ooO = new Rect();
  protected Rect ooP = new Rect();
  private boolean ooQ = true;
  private LinearLayout ooR;
  private ImageView ooS;
  private TextView ooT;
  private boolean ooU = false;
  private f ooV = null;
  private boolean ooW = false;
  private Runnable ooX;
  private Animator.AnimatorListener ooY = new Animator.AnimatorListener()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      AppMethodBeat.i(49647);
      DragFeatureView.e(DragFeatureView.this);
      DragFeatureView.this.requestLayout();
      if ((DragFeatureView.h(DragFeatureView.this)) && ((DragFeatureView.i(DragFeatureView.this) instanceof DragRecyclerView)))
      {
        ((DragRecyclerView)DragFeatureView.i(DragFeatureView.this)).setLongPress(false);
        DragFeatureView.j(DragFeatureView.this);
        DragFeatureView.k(DragFeatureView.this);
      }
      AppMethodBeat.o(49647);
    }
    
    public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationStart(Animator paramAnonymousAnimator) {}
  };
  
  public DragFeatureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DragFeatureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private boolean P(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private void caH()
  {
    try
    {
      this.ooT.setText(2131755419);
      this.ooT.setTextSize(1, getRubbishViewTextSize());
      this.ooS.setImageResource(2131230985);
      this.ooR.setBackgroundColor(getContext().getResources().getColor(2131099954));
      return;
    }
    catch (Exception localException) {}
  }
  
  private View caI()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131099954));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.ooH);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setId(2131307194);
    localLinearLayout.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(2131230985);
    ((ImageView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    Log.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", new Object[] { Integer.valueOf(((ImageView)localObject1).getMeasuredWidth()), Integer.valueOf(((ImageView)localObject1).getMeasuredHeight()) });
    ((LinearLayout.LayoutParams)localObject2).width = ((int)(((ImageView)localObject1).getMeasuredWidth() * b.ez(getContext())));
    ((LinearLayout.LayoutParams)localObject2).height = ((int)(((ImageView)localObject1).getMeasuredHeight() * b.ez(getContext())));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setText(2131755419);
    ((TextView)localObject2).setTextSize(1, getRubbishViewTextSize());
    ((TextView)localObject2).setTextColor(getContext().getResources().getColor(2131101427));
    ((TextView)localObject2).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 4), 0, 0);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView((View)localObject2);
    this.ooR = localLinearLayout;
    this.ooS = ((ImageView)localObject1);
    this.ooT = ((TextView)localObject2);
    return localLinearLayout;
  }
  
  private float getRubbishViewTextSize()
  {
    return 12.0F * b.ez(getContext());
  }
  
  private void init(Context paramContext)
  {
    this.ooH = ((int)getResources().getDimension(2131166873));
    setVisibility(8);
    this.mDJ = new GestureDetector(paramContext, this);
    this.ooM = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(caI());
  }
  
  private void je(final boolean paramBoolean)
  {
    if (this.ooX == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49645);
          Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(paramBoolean) });
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean)
          {
            i = -10;
            Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
            localRecyclerView = DragFeatureView.this.getRecyclerView();
            if (!paramBoolean) {
              break label111;
            }
          }
          label111:
          for (int i = -20;; i = 20)
          {
            localRecyclerView.scrollBy(0, i);
            DragFeatureView.this.post(this);
            AppMethodBeat.o(49645);
            return;
            i = 10;
            break;
          }
        }
      };
      this.ooX = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void setItemDragCallback(c paramc)
  {
    this.ooJ = paramc;
  }
  
  protected abstract c P(RecyclerView.v paramv);
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.ooO != null) {
      paramCanvas.drawRect(this.ooO, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.ooP != null) {
      paramCanvas.drawRect(this.ooP, this.mPaint);
    }
  }
  
  protected RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.ooO.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().bi(getRecyclerView().getChildAt(i));
      localv.aus.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.ooP.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.ooO;
  }
  
  public c getItemDragCallback()
  {
    return this.ooJ;
  }
  
  public f getRecyclerScrollComputer()
  {
    return this.ooV;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public Rect getRubbishRect()
  {
    return this.dtb;
  }
  
  public Rect getTopScrollRect()
  {
    return this.ooP;
  }
  
  public final void hx(boolean paramBoolean)
  {
    Log.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.ooO);
    this.ooO.set(this.ooO.left, this.ooO.bottom - this.ooH * 2, this.ooO.right, this.ooO.bottom - this.ooH);
    getRecyclerView().getGlobalVisibleRect(this.ooP);
    this.ooP.set(this.ooP.left, 0, this.ooP.right, this.ooP.top + this.ooH);
    findViewById(2131307194).getGlobalVisibleRect(this.dtb);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    for (;;)
    {
      try
      {
        if (this.ooU)
        {
          Log.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
          this.ooU = false;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          return;
        }
        this.ooU = true;
        localObject1 = e(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
        setItemDragCallback(P((RecyclerView.v)localObject1));
        if (localObject1 == null) {
          continue;
        }
        localObject2 = this.ooJ;
        getRecyclerView();
        if (!((c)localObject2).R((RecyclerView.v)localObject1)) {
          continue;
        }
        this.ooN = this.ooJ.g(getRecyclerView(), (RecyclerView.v)localObject1);
        if (this.ooN == null) {
          continue;
        }
        setVisibility(8);
        this.ooL = ((RecyclerView.v)localObject1).lR();
        this.ooK = ((RecyclerView.v)localObject1);
        this.ooM.vibrate(30L);
        setRubbishViewVisible(0);
        setVisibility(0);
        paramMotionEvent.setAction(0);
        localObject1 = this.mDJ;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        paramMotionEvent.setAction(3);
        localObject1 = this.mDJ;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.DragFeatureView", localException, "alvinluo onLongPress exception", new Object[0]);
        paramMotionEvent.setAction(0);
        GestureDetector localGestureDetector = this.mDJ;
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        paramMotionEvent.setAction(3);
        localGestureDetector = this.mDJ;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
      setRubbishViewVisible(8);
      setVisibility(8);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (getVisibility() == 8) {
      return false;
    }
    float f1 = paramMotionEvent2.getRawX();
    float f2 = paramMotionEvent2.getRawY();
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    int i;
    if (!this.mRect.contains((int)f1, (int)f2)) {
      if (f1 < this.mRect.left) {
        i = 3;
      }
    }
    for (;;)
    {
      paramMotionEvent1 = e(paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY(), false);
      if (this.canScroll) {
        break;
      }
      paramMotionEvent2 = this.ooJ;
      getRecyclerView();
      paramMotionEvent2.a(this.ooN, paramFloat1, paramFloat2, paramMotionEvent1, i);
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.ooO.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.ooP.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (P(f1, f2))
      {
        i = 6;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= getRecyclerView().getChildCount()) {
            break label272;
          }
          getRecyclerView().bi(getRecyclerView().getChildAt(i)).aus.getGlobalVisibleRect(this.mRect);
          if (this.mRect.contains((int)f1, (int)f2))
          {
            i = 5;
            break;
          }
          i += 1;
        }
        label272:
        i = 7;
      }
    }
    boolean bool;
    int j;
    if (paramMotionEvent1 == null)
    {
      bool = true;
      f1 = paramMotionEvent2.getRawX();
      f2 = paramMotionEvent2.getRawY();
      if (paramMotionEvent1 == null) {
        break label535;
      }
      j = paramMotionEvent1.auw;
      label308:
      Log.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label615;
      }
      if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label541;
      }
      je(true);
      label404:
      paramMotionEvent2 = this.ooJ;
      getRecyclerView();
      paramMotionEvent2.a(this.ooN, paramFloat1, paramFloat2, paramMotionEvent1, i);
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.ooX);
        this.ooX = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.ooI);
        paramMotionEvent2 = this.ooJ;
        getRecyclerView();
        if ((!paramMotionEvent2.S(paramMotionEvent1)) || (i == 2)) {
          break label663;
        }
        this.ooJ.h(getRecyclerView());
      }
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label535:
      j = -1;
      break label308;
      label541:
      if (getBottomScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY()))
      {
        je(false);
        break label404;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label404;
      }
      removeCallbacks(this.ooI);
      removeCallbacks(this.ooX);
      this.ooX = null;
      break label404;
      label615:
      if ((i != 3) && (i != 4))
      {
        paramMotionEvent2 = this.ooJ;
        getRecyclerView();
        if (!paramMotionEvent2.S(paramMotionEvent1)) {
          break label404;
        }
      }
      this.ooJ.h(getRecyclerView());
      break label404;
      label663:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.auw == 7))
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.ooI = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.ooI = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 150L);
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.ooQ) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView = this.mDJ;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      return true;
      if (P(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.ooL = -1;
        this.omQ = false;
        this.ooJ.h(getRecyclerView(), this.ooK);
        removeCallbacks(this.ooI);
        removeCallbacks(this.ooX);
        if (this.ooN != null) {
          this.ooN.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(49644);
              DragFeatureView.this.removeView(DragFeatureView.d(DragFeatureView.this));
              DragFeatureView.e(DragFeatureView.this);
              DragFeatureView.this.setRubbishViewVisible(8);
              AppMethodBeat.o(49644);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          }).setDuration(300L).start();
        }
      }
      else
      {
        removeCallbacks(this.ooI);
        removeCallbacks(this.ooX);
        setRubbishViewVisible(8);
        int i = this.ooL;
        this.ooL = -1;
        this.omQ = false;
        this.ooJ.a(getRecyclerView(), this.ooK, i, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49646);
            DragFeatureView.this.setVisibility(8);
            DragFeatureView.f(DragFeatureView.this);
            DragFeatureView.g(DragFeatureView.this);
            AppMethodBeat.o(49646);
          }
        });
        continue;
        if (P(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.ooR.setBackgroundColor(getContext().getResources().getColor(2131099955));
          this.ooT.setText(2131755424);
          this.ooT.setTextSize(2, getRubbishViewTextSize());
          this.ooS.setImageResource(2131230990);
        }
        else
        {
          caH();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(f paramf)
  {
    this.ooV = paramf;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(2131307194);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.ooY).start();
      return;
    }
    this.ooW = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.ooY).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.ooQ = paramBoolean;
  }
  
  final class a
    implements Runnable
  {
    final RecyclerView.v amO;
    
    a(RecyclerView.v paramv)
    {
      this.amO = paramv;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.amO == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.amO.lR();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.b(DragFeatureView.this) != this.amO) {}
      for (boolean bool = true;; bool = false)
      {
        c localc = DragFeatureView.c(DragFeatureView.this);
        DragFeatureView.this.getRecyclerView();
        DragFeatureView.b(DragFeatureView.this);
        Log.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localc.T(this.amO)), Integer.valueOf(i), Integer.valueOf(j) });
        if (DragFeatureView.b(DragFeatureView.this) != this.amO)
        {
          localc = DragFeatureView.c(DragFeatureView.this);
          DragFeatureView.this.getRecyclerView();
          DragFeatureView.b(DragFeatureView.this);
          if ((localc.T(this.amO)) && (DragFeatureView.c(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.b(DragFeatureView.this), this.amO, i, j))) {
            DragFeatureView.a(DragFeatureView.this, j);
          }
        }
        AppMethodBeat.o(49648);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */