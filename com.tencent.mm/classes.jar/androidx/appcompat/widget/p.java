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
import androidx.core.g.ad;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

class p
  extends ListView
{
  private final Rect te;
  private int tf;
  private int tg;
  private int th;
  private int ti;
  private int tj;
  private Field tk;
  private a tl;
  private boolean tn;
  private boolean tp;
  private boolean tq;
  private ad tr;
  private f tt;
  b tu;
  
  p(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.a.dropDownListViewStyle);
    AppMethodBeat.i(199971);
    this.te = new Rect();
    this.tf = 0;
    this.tg = 0;
    this.th = 0;
    this.ti = 0;
    this.tp = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.tk = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.tk.setAccessible(true);
      AppMethodBeat.o(199971);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      AppMethodBeat.o(199971);
    }
  }
  
  private void eG()
  {
    AppMethodBeat.i(199989);
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.tq) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(199989);
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    if (this.tl != null) {
      this.tl.mEnabled = paramBoolean;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(200120);
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
        this.tq = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(this.tj - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (this.tr != null)
        {
          this.tr.cancel();
          this.tr = null;
        }
      }
      if (bool1)
      {
        if (this.tt == null) {
          this.tt = new f(this);
        }
        this.tt.aM(true);
        this.tt.onTouch(this, paramMotionEvent);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(200120);
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
      this.tq = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.tj != -1)
      {
        localObject1 = getChildAt(this.tj - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      this.tj = k;
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
        localObject2 = this.te;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        ((Rect)localObject2).left -= this.tf;
        ((Rect)localObject2).top -= this.tg;
        ((Rect)localObject2).right += this.th;
        ((Rect)localObject2).bottom += this.ti;
      }
      try
      {
        bool1 = this.tk.getBoolean(this);
        if (localView.isEnabled() != bool1)
        {
          localObject2 = this.tk;
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
        localObject2 = this.te;
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
      if (this.tt != null) {
        this.tt.aM(false);
      }
    }
  }
  
  public int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(200074);
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(200074);
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
          AppMethodBeat.o(200074);
          return paramInt2;
          i = 0;
          break;
          m = View.MeasureSpec.makeMeasureSpec(0, 0);
          break label193;
        }
        AppMethodBeat.o(200074);
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
        AppMethodBeat.o(200074);
        return paramInt3;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200049);
    if (!this.te.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.te);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(200049);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200039);
    if (this.tu != null)
    {
      AppMethodBeat.o(200039);
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    eG();
    AppMethodBeat.o(200039);
  }
  
  public boolean hasFocus()
  {
    AppMethodBeat.i(200023);
    if ((this.tp) || (super.hasFocus()))
    {
      AppMethodBeat.o(200023);
      return true;
    }
    AppMethodBeat.o(200023);
    return false;
  }
  
  public boolean hasWindowFocus()
  {
    AppMethodBeat.i(200009);
    if ((this.tp) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(200009);
      return true;
    }
    AppMethodBeat.o(200009);
    return false;
  }
  
  public boolean isFocused()
  {
    AppMethodBeat.i(200015);
    if ((this.tp) || (super.isFocused()))
    {
      AppMethodBeat.o(200015);
      return true;
    }
    AppMethodBeat.o(200015);
    return false;
  }
  
  public boolean isInTouchMode()
  {
    AppMethodBeat.i(199999);
    if (((this.tp) && (this.tn)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(199999);
      return true;
    }
    AppMethodBeat.o(199999);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(200102);
    this.tu = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(200102);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200092);
    if (Build.VERSION.SDK_INT < 26)
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(200092);
      return bool;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 10) && (this.tu == null))
    {
      this.tu = new b();
      b localb = this.tu;
      localb.tv.post(localb);
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
        eG();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200092);
      return bool;
      setSelection(-1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200060);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.tu != null)
      {
        b localb = this.tu;
        localb.tv.tu = null;
        localb.tv.removeCallbacks(localb);
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200060);
      return bool;
      this.tj = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.tn = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    AppMethodBeat.i(200031);
    if (paramDrawable != null) {}
    for (Object localObject = new a(paramDrawable);; localObject = null)
    {
      this.tl = ((a)localObject);
      super.setSelector(this.tl);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.tf = ((Rect)localObject).left;
      this.tg = ((Rect)localObject).top;
      this.th = ((Rect)localObject).right;
      this.ti = ((Rect)localObject).bottom;
      AppMethodBeat.o(200031);
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
      AppMethodBeat.i(199416);
      if (this.mEnabled) {
        super.draw(paramCanvas);
      }
      AppMethodBeat.o(199416);
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(199423);
      if (this.mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(199423);
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(199433);
      if (this.mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(199433);
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(199408);
      if (this.mEnabled)
      {
        boolean bool = super.setState(paramArrayOfInt);
        AppMethodBeat.o(199408);
        return bool;
      }
      AppMethodBeat.o(199408);
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(199441);
      if (this.mEnabled)
      {
        paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
        AppMethodBeat.o(199441);
        return paramBoolean1;
      }
      AppMethodBeat.o(199441);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(199404);
      p.this.tu = null;
      p.this.drawableStateChanged();
      AppMethodBeat.o(199404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.p
 * JD-Core Version:    0.7.0.1
 */