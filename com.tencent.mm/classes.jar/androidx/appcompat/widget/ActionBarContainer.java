package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.a.f;
import androidx.appcompat.a.j;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarContainer
  extends FrameLayout
{
  private int mHeight;
  Drawable ni;
  private boolean oN;
  private View oO;
  private View oP;
  private View oQ;
  Drawable oR;
  Drawable oS;
  boolean oT;
  boolean oU;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199432);
    z.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionBar);
    this.ni = paramContext.getDrawable(a.j.ActionBar_background);
    this.oR = paramContext.getDrawable(a.j.ActionBar_backgroundStacked);
    this.mHeight = paramContext.getDimensionPixelSize(a.j.ActionBar_height, -1);
    if (getId() == a.f.split_action_bar)
    {
      this.oT = true;
      this.oS = paramContext.getDrawable(a.j.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    if (this.oT) {
      if (this.oS != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      AppMethodBeat.o(199432);
      return;
      bool = false;
      continue;
      if ((this.ni != null) || (this.oR != null)) {
        bool = false;
      }
    }
  }
  
  private static boolean l(View paramView)
  {
    AppMethodBeat.i(199442);
    if ((paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0))
    {
      AppMethodBeat.o(199442);
      return true;
    }
    AppMethodBeat.o(199442);
    return false;
  }
  
  private static int m(View paramView)
  {
    AppMethodBeat.i(199452);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(199452);
    return k + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(199545);
    super.drawableStateChanged();
    if ((this.ni != null) && (this.ni.isStateful())) {
      this.ni.setState(getDrawableState());
    }
    if ((this.oR != null) && (this.oR.isStateful())) {
      this.oR.setState(getDrawableState());
    }
    if ((this.oS != null) && (this.oS.isStateful())) {
      this.oS.setState(getDrawableState());
    }
    AppMethodBeat.o(199545);
  }
  
  public View getTabContainer()
  {
    return this.oO;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(199557);
    super.jumpDrawablesToCurrentState();
    if (this.ni != null) {
      this.ni.jumpToCurrentState();
    }
    if (this.oR != null) {
      this.oR.jumpToCurrentState();
    }
    if (this.oS != null) {
      this.oS.jumpToCurrentState();
    }
    AppMethodBeat.o(199557);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(199463);
    super.onFinishInflate();
    this.oP = findViewById(a.f.action_bar);
    this.oQ = findViewById(a.f.action_context_bar);
    AppMethodBeat.o(199463);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199599);
    super.onHoverEvent(paramMotionEvent);
    AppMethodBeat.o(199599);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199578);
    if ((this.oN) || (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(199578);
      return true;
    }
    AppMethodBeat.o(199578);
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(199665);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.oO;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.oT) {
        break label153;
      }
      if (this.oS == null) {
        break label333;
      }
      this.oS.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      AppMethodBeat.o(199665);
      return;
      paramBoolean = false;
      break;
      label153:
      if (this.ni != null) {
        if (this.oP.getVisibility() == 0) {
          this.ni.setBounds(this.oP.getLeft(), this.oP.getTop(), this.oP.getRight(), this.oP.getBottom());
        }
      }
      label205:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.oU = paramBoolean;
        if ((paramBoolean) && (this.oR != null))
        {
          this.oR.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.oQ != null) && (this.oQ.getVisibility() == 0))
          {
            this.ni.setBounds(this.oQ.getLeft(), this.oQ.getTop(), this.oQ.getRight(), this.oQ.getBottom());
            break label205;
          }
          this.ni.setBounds(0, 0, 0, 0);
          break label205;
        }
        break;
      }
      label333:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199655);
    int i = paramInt2;
    if (this.oP == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
      {
        i = paramInt2;
        if (this.mHeight >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (this.oP == null)
    {
      AppMethodBeat.o(199655);
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(i);
    if ((this.oO != null) && (this.oO.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (l(this.oP)) {
        break label156;
      }
      paramInt1 = m(this.oP);
      if (paramInt2 != -2147483648) {
        break label182;
      }
    }
    label156:
    label182:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + m(this.oO), paramInt2));
      AppMethodBeat.o(199655);
      return;
      if (!l(this.oQ))
      {
        paramInt1 = m(this.oQ);
        break;
      }
      paramInt1 = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199589);
    super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(199589);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(199481);
    if (this.ni != null)
    {
      this.ni.setCallback(null);
      unscheduleDrawable(this.ni);
    }
    this.ni = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.oP != null) {
        this.ni.setBounds(this.oP.getLeft(), this.oP.getTop(), this.oP.getRight(), this.oP.getBottom());
      }
    }
    if (this.oT) {
      if (this.oS != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(199481);
      return;
      bool = false;
      continue;
      if ((this.ni != null) || (this.oR != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(199512);
    if (this.oS != null)
    {
      this.oS.setCallback(null);
      unscheduleDrawable(this.oS);
    }
    this.oS = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.oT) && (this.oS != null)) {
        this.oS.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.oT) {
      if (this.oS != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(199512);
      return;
      bool = false;
      continue;
      if ((this.ni != null) || (this.oR != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(199501);
    if (this.oR != null)
    {
      this.oR.setCallback(null);
      unscheduleDrawable(this.oR);
    }
    this.oR = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.oU) && (this.oR != null)) {
        this.oR.setBounds(this.oO.getLeft(), this.oO.getTop(), this.oO.getRight(), this.oO.getBottom());
      }
    }
    if (this.oT) {
      if (this.oS != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(199501);
      return;
      bool = false;
      continue;
      if ((this.ni != null) || (this.oR != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(w paramw)
  {
    AppMethodBeat.i(199613);
    if (this.oO != null) {
      removeView(this.oO);
    }
    this.oO = paramw;
    if (paramw != null)
    {
      addView(paramw);
      ViewGroup.LayoutParams localLayoutParams = paramw.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramw.setAllowCollapse(false);
    }
    AppMethodBeat.o(199613);
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    AppMethodBeat.i(199567);
    this.oN = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      AppMethodBeat.o(199567);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199524);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.ni != null) {
        this.ni.setVisible(bool, false);
      }
      if (this.oR != null) {
        this.oR.setVisible(bool, false);
      }
      if (this.oS != null) {
        this.oS.setVisible(bool, false);
      }
      AppMethodBeat.o(199524);
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    AppMethodBeat.i(199641);
    if (paramInt != 0)
    {
      paramView = super.startActionModeForChild(paramView, paramCallback, paramInt);
      AppMethodBeat.o(199641);
      return paramView;
    }
    AppMethodBeat.o(199641);
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199536);
    if (((paramDrawable == this.ni) && (!this.oT)) || ((paramDrawable == this.oR) && (this.oU)) || ((paramDrawable == this.oS) && (this.oT)) || (super.verifyDrawable(paramDrawable)))
    {
      AppMethodBeat.o(199536);
      return true;
    }
    AppMethodBeat.o(199536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */