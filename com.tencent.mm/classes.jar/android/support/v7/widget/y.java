package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.x;
import android.support.v4.widget.m;
import android.support.v7.d.a.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class y
  extends ListView
{
  private final Rect akO = new Rect();
  private int akP = 0;
  private int akQ = 0;
  private int akR = 0;
  private int akS = 0;
  private int akT;
  private Field akU;
  private a akV;
  private boolean akW;
  private boolean akX;
  private boolean akY;
  private x akZ;
  private m ala;
  b alb;
  
  y(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130968938);
    this.akX = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.akU = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.akU.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext) {}
  }
  
  private void jh()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.akY) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    if (this.akV != null) {
      this.akV.mEnabled = paramBoolean;
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    int i = 0;
    int j = paramMotionEvent.getActionMasked();
    View localView;
    switch (j)
    {
    default: 
      paramInt = i;
      bool1 = bool2;
      if ((!bool1) || (paramInt != 0))
      {
        this.akY = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(this.akT - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (this.akZ != null)
        {
          this.akZ.cancel();
          this.akZ = null;
        }
      }
      if (bool1)
      {
        if (this.ala == null) {
          this.ala = new m(this);
        }
        this.ala.M(true);
        this.ala.onTouch(this, paramMotionEvent);
      }
      break;
    }
    label418:
    label555:
    label576:
    label708:
    label714:
    while (this.ala == null)
    {
      return bool1;
      bool1 = false;
      paramInt = i;
      break;
      bool1 = false;
      int k = paramMotionEvent.findPointerIndex(paramInt);
      if (k < 0)
      {
        bool1 = false;
        paramInt = i;
        break;
      }
      paramInt = (int)paramMotionEvent.getX(k);
      int m = (int)paramMotionEvent.getY(k);
      k = pointToPosition(paramInt, m);
      if (k == -1)
      {
        paramInt = 1;
        break;
      }
      localView = getChildAt(k - getFirstVisiblePosition());
      float f1 = paramInt;
      float f2 = m;
      this.akY = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.akT != -1)
      {
        localObject1 = getChildAt(this.akT - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      this.akT = k;
      float f3 = localView.getLeft();
      float f4 = localView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        localView.drawableHotspotChanged(f1 - f3, f2 - f4);
      }
      if (!localView.isPressed()) {
        localView.setPressed(true);
      }
      Object localObject1 = getSelector();
      Object localObject2;
      if ((localObject1 != null) && (k != -1))
      {
        paramInt = 1;
        if (paramInt != 0) {
          ((Drawable)localObject1).setVisible(false, false);
        }
        localObject2 = this.akO;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        ((Rect)localObject2).left -= this.akP;
        ((Rect)localObject2).top -= this.akQ;
        ((Rect)localObject2).right += this.akR;
        ((Rect)localObject2).bottom += this.akS;
      }
      try
      {
        bool1 = this.akU.getBoolean(this);
        if (localView.isEnabled() != bool1)
        {
          localObject2 = this.akU;
          if (bool1) {
            break label708;
          }
          bool1 = true;
          ((Field)localObject2).set(this, Boolean.valueOf(bool1));
          if (k != -1) {
            refreshDrawableState();
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label576;
      }
      if (paramInt != 0)
      {
        localObject2 = this.akO;
        f3 = ((Rect)localObject2).exactCenterX();
        f4 = ((Rect)localObject2).exactCenterY();
        if (getVisibility() != 0) {
          break label714;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        ((Drawable)localObject1).setVisible(bool1, false);
        a.a((Drawable)localObject1, f3, f4);
        localObject1 = getSelector();
        if ((localObject1 != null) && (k != -1)) {
          a.a((Drawable)localObject1, f1, f2);
        }
        setSelectorEnabled(false);
        refreshDrawableState();
        bool2 = true;
        bool1 = bool2;
        paramInt = i;
        if (j != 1) {
          break;
        }
        performItemClick(localView, k, getItemIdAtPosition(k));
        bool1 = bool2;
        paramInt = i;
        break;
        paramInt = 0;
        break label418;
        bool1 = false;
        break label555;
      }
    }
    this.ala.M(false);
    return bool1;
  }
  
  public int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      paramInt2 += paramInt3;
      return paramInt2;
    }
    paramInt3 += paramInt2;
    label63:
    int m;
    int j;
    int k;
    View localView;
    if ((i > 0) && (localObject != null))
    {
      paramInt2 = 0;
      localObject = null;
      m = 0;
      int i1 = localListAdapter.getCount();
      j = 0;
      if (j >= i1) {
        break label292;
      }
      int n = localListAdapter.getItemViewType(j);
      k = m;
      if (n != m)
      {
        localObject = null;
        k = n;
      }
      localView = localListAdapter.getView(j, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (((ViewGroup.LayoutParams)localObject).height <= 0) {
        break label251;
      }
      m = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
      label183:
      localView.measure(paramInt1, m);
      localView.forceLayout();
      if (j <= 0) {
        break label297;
      }
      paramInt3 += i;
    }
    label292:
    label297:
    for (;;)
    {
      paramInt3 = localView.getMeasuredHeight() + paramInt3;
      if (paramInt3 >= paramInt4)
      {
        if ((paramInt5 >= 0) && (j > paramInt5) && (paramInt2 > 0) && (paramInt3 != paramInt4)) {
          break;
        }
        return paramInt4;
        i = 0;
        break label63;
        label251:
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label183;
      }
      if ((paramInt5 >= 0) && (j >= paramInt5)) {
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        j += 1;
        m = k;
        localObject = localView;
        break;
        return paramInt3;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.akO.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.akO);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.alb != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    jh();
  }
  
  public boolean hasFocus()
  {
    return (this.akX) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.akX) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.akX) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.akX) && (this.akW)) || (super.isInTouchMode());
  }
  
  protected void onDetachedFromWindow()
  {
    this.alb = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 26) {
      bool1 = super.onHoverEvent(paramMotionEvent);
    }
    int i;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        i = paramMotionEvent.getActionMasked();
        if ((i == 10) && (this.alb == null))
        {
          this.alb = new b();
          b localb = this.alb;
          localb.alc.post(localb);
        }
        bool2 = super.onHoverEvent(paramMotionEvent);
        if ((i != 9) && (i != 7)) {
          break;
        }
        i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        bool1 = bool2;
      } while (i == -1);
      bool1 = bool2;
    } while (i == getSelectedItemPosition());
    paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
    if (paramMotionEvent.isEnabled()) {
      setSelectionFromTop(i, paramMotionEvent.getTop() - getTop());
    }
    jh();
    return bool2;
    setSelection(-1);
    return bool2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.alb != null)
      {
        b localb = this.alb;
        localb.alc.alb = null;
        localb.alc.removeCallbacks(localb);
      }
      return super.onTouchEvent(paramMotionEvent);
      this.akT = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.akW = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (Object localObject = new a(paramDrawable);; localObject = null)
    {
      this.akV = ((a)localObject);
      super.setSelector(this.akV);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.akP = ((Rect)localObject).left;
      this.akQ = ((Rect)localObject).top;
      this.akR = ((Rect)localObject).right;
      this.akS = ((Rect)localObject).bottom;
      return;
    }
  }
  
  static final class a
    extends c
  {
    boolean mEnabled = true;
    
    a(Drawable paramDrawable)
    {
      super();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (this.mEnabled) {
        super.draw(paramCanvas);
      }
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      if (this.mEnabled) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.mEnabled) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      y.this.alb = null;
      y.this.drawableStateChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.y
 * JD-Core Version:    0.7.0.1
 */