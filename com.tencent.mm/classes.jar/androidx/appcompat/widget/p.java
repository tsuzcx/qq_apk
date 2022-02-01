package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a.a;
import androidx.appcompat.b.a.c;
import androidx.core.g.aa;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

class p
  extends ListView
{
  private final Rect sg;
  private int sh;
  private int si;
  private int sj;
  private int sk;
  private int sl;
  private Field sm;
  private a sn;
  private boolean so;
  private boolean sq;
  private boolean sr;
  private aa ss;
  private f st;
  b su;
  
  p(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.a.dropDownListViewStyle);
    AppMethodBeat.i(241255);
    this.sg = new Rect();
    this.sh = 0;
    this.si = 0;
    this.sj = 0;
    this.sk = 0;
    this.sq = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.sm = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.sm.setAccessible(true);
      AppMethodBeat.o(241255);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      AppMethodBeat.o(241255);
    }
  }
  
  private void dH()
  {
    AppMethodBeat.i(241280);
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.sr) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(241280);
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    if (this.sn != null) {
      this.sn.mEnabled = paramBoolean;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(241278);
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
        this.sr = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(this.sl - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (this.ss != null)
        {
          this.ss.cancel();
          this.ss = null;
        }
      }
      if (bool1)
      {
        if (this.st == null) {
          this.st = new f(this);
        }
        this.st.ad(true);
        this.st.onTouch(this, paramMotionEvent);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(241278);
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
      this.sr = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.sl != -1)
      {
        localObject1 = getChildAt(this.sl - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      this.sl = k;
      float f3 = localView.getLeft();
      float f4 = localView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        localView.drawableHotspotChanged(f1 - f3, f2 - f4);
      }
      if (!localView.isPressed()) {
        localView.setPressed(true);
      }
      Object localObject1 = getSelector();
      label427:
      Object localObject2;
      if ((localObject1 != null) && (k != -1))
      {
        paramInt = 1;
        if (paramInt != 0) {
          ((Drawable)localObject1).setVisible(false, false);
        }
        localObject2 = this.sg;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        ((Rect)localObject2).left -= this.sh;
        ((Rect)localObject2).top -= this.si;
        ((Rect)localObject2).right += this.sj;
        ((Rect)localObject2).bottom += this.sk;
      }
      try
      {
        bool1 = this.sm.getBoolean(this);
        if (localView.isEnabled() != bool1)
        {
          localObject2 = this.sm;
          if (bool1) {
            break label717;
          }
          bool1 = true;
          label564:
          ((Field)localObject2).set(this, Boolean.valueOf(bool1));
          if (k != -1) {
            refreshDrawableState();
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label585:
        break label585;
      }
      if (paramInt != 0)
      {
        localObject2 = this.sg;
        f3 = ((Rect)localObject2).exactCenterX();
        f4 = ((Rect)localObject2).exactCenterY();
        if (getVisibility() != 0) {
          break label723;
        }
      }
      label717:
      label723:
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
        break label427;
        bool1 = false;
        break label564;
      }
      if (this.st != null) {
        this.st.ad(false);
      }
    }
  }
  
  public int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(241269);
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(241269);
      return paramInt2 + paramInt3;
    }
    paramInt3 += paramInt2;
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
        break label316;
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
        break label266;
      }
      m = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
      label193:
      localView.measure(paramInt1, m);
      localView.forceLayout();
      if (j <= 0) {
        break label327;
      }
      paramInt3 += i;
    }
    label266:
    label316:
    label327:
    for (;;)
    {
      paramInt3 = localView.getMeasuredHeight() + paramInt3;
      if (paramInt3 >= paramInt4)
      {
        if ((paramInt5 >= 0) && (j > paramInt5) && (paramInt2 > 0) && (paramInt3 != paramInt4))
        {
          AppMethodBeat.o(241269);
          return paramInt2;
          i = 0;
          break;
          m = View.MeasureSpec.makeMeasureSpec(0, 0);
          break label193;
        }
        AppMethodBeat.o(241269);
        return paramInt4;
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
        AppMethodBeat.o(241269);
        return paramInt3;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241265);
    if (!this.sg.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.sg);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(241265);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(241263);
    if (this.su != null)
    {
      AppMethodBeat.o(241263);
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    dH();
    AppMethodBeat.o(241263);
  }
  
  public boolean hasFocus()
  {
    AppMethodBeat.i(241259);
    if ((this.sq) || (super.hasFocus()))
    {
      AppMethodBeat.o(241259);
      return true;
    }
    AppMethodBeat.o(241259);
    return false;
  }
  
  public boolean hasWindowFocus()
  {
    AppMethodBeat.i(241257);
    if ((this.sq) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(241257);
      return true;
    }
    AppMethodBeat.o(241257);
    return false;
  }
  
  public boolean isFocused()
  {
    AppMethodBeat.i(241258);
    if ((this.sq) || (super.isFocused()))
    {
      AppMethodBeat.o(241258);
      return true;
    }
    AppMethodBeat.o(241258);
    return false;
  }
  
  public boolean isInTouchMode()
  {
    AppMethodBeat.i(241256);
    if (((this.sq) && (this.so)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(241256);
      return true;
    }
    AppMethodBeat.o(241256);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(241274);
    this.su = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(241274);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241273);
    if (Build.VERSION.SDK_INT < 26)
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(241273);
      return bool;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 10) && (this.su == null))
    {
      this.su = new b();
      b localb = this.su;
      localb.sv.post(localb);
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i == 9) || (i == 7))
    {
      i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i != -1) && (i != getSelectedItemPosition()))
      {
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
        if (paramMotionEvent.isEnabled()) {
          setSelectionFromTop(i, paramMotionEvent.getTop() - getTop());
        }
        dH();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(241273);
      return bool;
      setSelection(-1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241267);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.su != null)
      {
        b localb = this.su;
        localb.sv.su = null;
        localb.sv.removeCallbacks(localb);
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(241267);
      return bool;
      this.sl = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.so = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    AppMethodBeat.i(241261);
    if (paramDrawable != null) {}
    for (Object localObject = new a(paramDrawable);; localObject = null)
    {
      this.sn = ((a)localObject);
      super.setSelector(this.sn);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.sh = ((Rect)localObject).left;
      this.si = ((Rect)localObject).top;
      this.sj = ((Rect)localObject).right;
      this.sk = ((Rect)localObject).bottom;
      AppMethodBeat.o(241261);
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
      AppMethodBeat.i(241248);
      if (this.mEnabled) {
        super.draw(paramCanvas);
      }
      AppMethodBeat.o(241248);
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(241250);
      if (this.mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(241250);
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(241251);
      if (this.mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(241251);
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(241246);
      if (this.mEnabled)
      {
        boolean bool = super.setState(paramArrayOfInt);
        AppMethodBeat.o(241246);
        return bool;
      }
      AppMethodBeat.o(241246);
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(241252);
      if (this.mEnabled)
      {
        paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
        AppMethodBeat.o(241252);
        return paramBoolean1;
      }
      AppMethodBeat.o(241252);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(241253);
      p.this.su = null;
      p.this.drawableStateChanged();
      AppMethodBeat.o(241253);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.p
 * JD-Core Version:    0.7.0.1
 */