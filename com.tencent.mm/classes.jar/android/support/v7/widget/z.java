package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.support.v4.widget.k;
import android.support.v7.a.a.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class z
  extends ListView
{
  private final Rect acb = new Rect();
  private int acc = 0;
  private int acd = 0;
  private int ace = 0;
  private int acf = 0;
  private int acg;
  private Field ach;
  private a aci;
  private boolean acj;
  private boolean ack;
  private boolean acl;
  private u acm;
  private k acn;
  private b aco;
  
  z(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.a.dropDownListViewStyle);
    this.ack = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.ach = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.ach.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext) {}
  }
  
  private void gD()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.acl) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    if (this.aci != null) {
      this.aci.IL = paramBoolean;
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
        this.acl = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(this.acg - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (this.acm != null)
        {
          this.acm.cancel();
          this.acm = null;
        }
      }
      if (bool1)
      {
        if (this.acn == null) {
          this.acn = new k(this);
        }
        this.acn.H(true);
        this.acn.onTouch(this, paramMotionEvent);
      }
      break;
    }
    label418:
    label555:
    label576:
    label708:
    label714:
    while (this.acn == null)
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
      this.acl = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.acg != -1)
      {
        localObject1 = getChildAt(this.acg - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      this.acg = k;
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
        localObject2 = this.acb;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        ((Rect)localObject2).left -= this.acc;
        ((Rect)localObject2).top -= this.acd;
        ((Rect)localObject2).right += this.ace;
        ((Rect)localObject2).bottom += this.acf;
      }
      try
      {
        bool1 = this.ach.getBoolean(this);
        if (localView.isEnabled() != bool1)
        {
          localObject2 = this.ach;
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
        localObject2 = this.acb;
        f3 = ((Rect)localObject2).exactCenterX();
        f4 = ((Rect)localObject2).exactCenterY();
        if (getVisibility() != 0) {
          break label714;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        ((Drawable)localObject1).setVisible(bool1, false);
        android.support.v4.a.a.a.a((Drawable)localObject1, f3, f4);
        localObject1 = getSelector();
        if ((localObject1 != null) && (k != -1)) {
          android.support.v4.a.a.a.a((Drawable)localObject1, f1, f2);
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
    this.acn.H(false);
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
    if (!this.acb.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.acb);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.aco != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    gD();
  }
  
  public boolean hasFocus()
  {
    return (this.ack) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.ack) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.ack) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.ack) && (this.acj)) || (super.isInTouchMode());
  }
  
  protected void onDetachedFromWindow()
  {
    this.aco = null;
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
        if ((i == 10) && (this.aco == null))
        {
          this.aco = new b((byte)0);
          b localb = this.aco;
          localb.acp.post(localb);
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
    gD();
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
      if (this.aco != null)
      {
        b localb = this.aco;
        localb.acp.aco = null;
        localb.acp.removeCallbacks(localb);
      }
      return super.onTouchEvent(paramMotionEvent);
      this.acg = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.acj = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (Object localObject = new a(paramDrawable);; localObject = null)
    {
      this.aci = ((a)localObject);
      super.setSelector(this.aci);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.acc = ((Rect)localObject).left;
      this.acd = ((Rect)localObject).top;
      this.ace = ((Rect)localObject).right;
      this.acf = ((Rect)localObject).bottom;
      return;
    }
  }
  
  private static final class a
    extends android.support.v7.d.a.a
  {
    boolean IL = true;
    
    a(Drawable paramDrawable)
    {
      super();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (this.IL) {
        super.draw(paramCanvas);
      }
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.IL) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.IL) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      if (this.IL) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.IL) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      z.a(z.this);
      z.this.drawableStateChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */