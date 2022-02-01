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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.j;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private RecyclerView anl;
  private boolean canScroll = true;
  private Rect dbr = new Rect();
  private GestureDetector lsn;
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  private Vibrator mUw;
  private boolean mWt = false;
  private h mYA = null;
  private boolean mYB = false;
  private Runnable mYC;
  private Animator.AnimatorListener mYD = new Animator.AnimatorListener()
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
  protected int mYn;
  private Runnable mYo;
  private j mYp;
  private RecyclerView.w mYq;
  int mYr = -1;
  private View mYs;
  protected Rect mYt = new Rect();
  protected Rect mYu = new Rect();
  private boolean mYv = true;
  private LinearLayout mYw;
  private ImageView mYx;
  private TextView mYy;
  private boolean mYz = false;
  
  public DragFeatureView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
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
  
  private boolean L(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private void bDf()
  {
    try
    {
      this.mYy.setText(2131755381);
      this.mYy.setTextSize(1, getRubbishViewTextSize());
      this.mYx.setImageResource(2131230962);
      this.mYw.setBackgroundColor(getContext().getResources().getColor(2131099935));
      return;
    }
    catch (Exception localException) {}
  }
  
  private View bDg()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131099935));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.mYn);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setId(2131304271);
    localLinearLayout.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(2131230962);
    ((ImageView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ad.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", new Object[] { Integer.valueOf(((ImageView)localObject1).getMeasuredWidth()), Integer.valueOf(((ImageView)localObject1).getMeasuredHeight()) });
    ((LinearLayout.LayoutParams)localObject2).width = ((int)(((ImageView)localObject1).getMeasuredWidth() * d.eb(getContext())));
    ((LinearLayout.LayoutParams)localObject2).height = ((int)(((ImageView)localObject1).getMeasuredHeight() * d.eb(getContext())));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setText(2131755381);
    ((TextView)localObject2).setTextSize(1, getRubbishViewTextSize());
    ((TextView)localObject2).setTextColor(getContext().getResources().getColor(2131101182));
    ((TextView)localObject2).setPadding(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 4), 0, 0);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView((View)localObject2);
    this.mYw = localLinearLayout;
    this.mYx = ((ImageView)localObject1);
    this.mYy = ((TextView)localObject2);
    return localLinearLayout;
  }
  
  private float getRubbishViewTextSize()
  {
    return 12.0F * d.eb(getContext());
  }
  
  private void ie(final boolean paramBoolean)
  {
    if (this.mYC == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49645);
          ad.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(paramBoolean) });
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean)
          {
            i = -10;
            ad.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
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
      this.mYC = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void init(Context paramContext)
  {
    this.mYn = ((int)getResources().getDimension(2131166753));
    setVisibility(8);
    this.lsn = new GestureDetector(paramContext, this);
    this.mUw = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(bDg());
  }
  
  private void setItemDragCallback(j paramj)
  {
    this.mYp = paramj;
  }
  
  protected abstract j N(RecyclerView.w paramw);
  
  protected RecyclerView.w d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.mYt.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.w localw = getRecyclerView().bh(getRecyclerView().getChildAt(i));
      localw.auu.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localw;
      }
      i += 1;
    }
    if (this.mYu.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.mYt != null) {
      paramCanvas.drawRect(this.mYt, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.mYu != null) {
      paramCanvas.drawRect(this.mYu, this.mPaint);
    }
  }
  
  public final void gB(boolean paramBoolean)
  {
    ad.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.mYt;
  }
  
  public j getItemDragCallback()
  {
    return this.mYp;
  }
  
  public h getRecyclerScrollComputer()
  {
    return this.mYA;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.anl;
  }
  
  public Rect getRubbishRect()
  {
    return this.dbr;
  }
  
  public Rect getTopScrollRect()
  {
    return this.mYu;
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
    getGlobalVisibleRect(this.mYt);
    this.mYt.set(this.mYt.left, this.mYt.bottom - this.mYn * 2, this.mYt.right, this.mYt.bottom - this.mYn);
    getRecyclerView().getGlobalVisibleRect(this.mYu);
    this.mYu.set(this.mYu.left, 0, this.mYu.right, this.mYu.top + this.mYn);
    findViewById(2131304271).getGlobalVisibleRect(this.dbr);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new b();
    ((b)localObject1).bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject1).ahq());
    for (;;)
    {
      try
      {
        if (this.mYz)
        {
          ad.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
          this.mYz = false;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          return;
        }
        this.mYz = true;
        localObject1 = d(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
        setItemDragCallback(N((RecyclerView.w)localObject1));
        if (localObject1 == null) {
          continue;
        }
        localObject2 = this.mYp;
        getRecyclerView();
        if (!((j)localObject2).O((RecyclerView.w)localObject1)) {
          continue;
        }
        this.mYs = this.mYp.g(getRecyclerView(), (RecyclerView.w)localObject1);
        if (this.mYs == null) {
          continue;
        }
        setVisibility(8);
        this.mYr = ((RecyclerView.w)localObject1).lN();
        this.mYq = ((RecyclerView.w)localObject1);
        this.mUw.vibrate(30L);
        setRubbishViewVisible(0);
        setVisibility(0);
        paramMotionEvent.setAction(0);
        localObject1 = this.lsn;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        paramMotionEvent.setAction(3);
        localObject1 = this.lsn;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.DragFeatureView", localException, "alvinluo onLongPress exception", new Object[0]);
        paramMotionEvent.setAction(0);
        GestureDetector localGestureDetector = this.lsn;
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        paramMotionEvent.setAction(3);
        localGestureDetector = this.lsn;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
      paramMotionEvent1 = d(paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY(), false);
      if (this.canScroll) {
        break;
      }
      paramMotionEvent2 = this.mYp;
      getRecyclerView();
      paramMotionEvent2.a(this.mYs, paramFloat1, paramFloat2, paramMotionEvent1, i);
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.mYt.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.mYu.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (L(f1, f2))
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
          getRecyclerView().bh(getRecyclerView().getChildAt(i)).auu.getGlobalVisibleRect(this.mRect);
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
      j = paramMotionEvent1.auy;
      label308:
      ad.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label615;
      }
      if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label541;
      }
      ie(true);
      label404:
      paramMotionEvent2 = this.mYp;
      getRecyclerView();
      paramMotionEvent2.a(this.mYs, paramFloat1, paramFloat2, paramMotionEvent1, i);
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.mYC);
        this.mYC = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.mYo);
        paramMotionEvent2 = this.mYp;
        getRecyclerView();
        if ((!paramMotionEvent2.P(paramMotionEvent1)) || (i == 2)) {
          break label663;
        }
        this.mYp.m(getRecyclerView());
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
        ie(false);
        break label404;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label404;
      }
      removeCallbacks(this.mYo);
      removeCallbacks(this.mYC);
      this.mYC = null;
      break label404;
      label615:
      if ((i != 3) && (i != 4))
      {
        paramMotionEvent2 = this.mYp;
        getRecyclerView();
        if (!paramMotionEvent2.P(paramMotionEvent1)) {
          break label404;
        }
      }
      this.mYp.m(getRecyclerView());
      break label404;
      label663:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.auy == 7))
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.mYo = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.mYo = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 150L);
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (!this.mYv)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView = this.lsn;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      return true;
      if (L(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.mYr = -1;
        this.mWt = false;
        this.mYp.h(getRecyclerView(), this.mYq);
        removeCallbacks(this.mYo);
        removeCallbacks(this.mYC);
        if (this.mYs != null) {
          this.mYs.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
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
        removeCallbacks(this.mYo);
        removeCallbacks(this.mYC);
        setRubbishViewVisible(8);
        int i = this.mYr;
        this.mYr = -1;
        this.mWt = false;
        this.mYp.a(getRecyclerView(), this.mYq, i, new Runnable()
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
        if (L(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.mYw.setBackgroundColor(getContext().getResources().getColor(2131099936));
          this.mYy.setText(2131755386);
          this.mYy.setTextSize(2, getRubbishViewTextSize());
          this.mYx.setImageResource(2131230964);
        }
        else
        {
          bDf();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.anl = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(h paramh)
  {
    this.mYA = paramh;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(2131304271);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.mYD).start();
      return;
    }
    this.mYB = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.mYD).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.mYv = paramBoolean;
  }
  
  final class a
    implements Runnable
  {
    final RecyclerView.w amB;
    
    a(RecyclerView.w paramw)
    {
      this.amB = paramw;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.amB == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.amB.lN();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.b(DragFeatureView.this) != this.amB) {}
      for (boolean bool = true;; bool = false)
      {
        j localj = DragFeatureView.c(DragFeatureView.this);
        DragFeatureView.this.getRecyclerView();
        DragFeatureView.b(DragFeatureView.this);
        ad.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localj.R(this.amB)), Integer.valueOf(i), Integer.valueOf(j) });
        if (DragFeatureView.b(DragFeatureView.this) != this.amB)
        {
          localj = DragFeatureView.c(DragFeatureView.this);
          DragFeatureView.this.getRecyclerView();
          DragFeatureView.b(DragFeatureView.this);
          if ((localj.R(this.amB)) && (DragFeatureView.c(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.b(DragFeatureView.this), this.amB, i, j))) {
            DragFeatureView.a(DragFeatureView.this, j);
          }
        }
        AppMethodBeat.o(49648);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */