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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarContainer
  extends FrameLayout
{
  private int mHeight;
  Drawable mj;
  private boolean nO;
  private View nP;
  private View nQ;
  private View nR;
  Drawable nS;
  Drawable nT;
  boolean nU;
  boolean nV;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(240013);
    androidx.core.g.w.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionBar);
    this.mj = paramContext.getDrawable(a.j.ActionBar_background);
    this.nS = paramContext.getDrawable(a.j.ActionBar_backgroundStacked);
    this.mHeight = paramContext.getDimensionPixelSize(a.j.ActionBar_height, -1);
    if (getId() == a.f.split_action_bar)
    {
      this.nU = true;
      this.nT = paramContext.getDrawable(a.j.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    if (this.nU) {
      if (this.nT != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      AppMethodBeat.o(240013);
      return;
      bool = false;
      continue;
      if ((this.mj != null) || (this.nS != null)) {
        bool = false;
      }
    }
  }
  
  private static boolean l(View paramView)
  {
    AppMethodBeat.i(240057);
    if ((paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0))
    {
      AppMethodBeat.o(240057);
      return true;
    }
    AppMethodBeat.o(240057);
    return false;
  }
  
  private static int m(View paramView)
  {
    AppMethodBeat.i(240058);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(240058);
    return k + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240033);
    super.drawableStateChanged();
    if ((this.mj != null) && (this.mj.isStateful())) {
      this.mj.setState(getDrawableState());
    }
    if ((this.nS != null) && (this.nS.isStateful())) {
      this.nS.setState(getDrawableState());
    }
    if ((this.nT != null) && (this.nT.isStateful())) {
      this.nT.setState(getDrawableState());
    }
    AppMethodBeat.o(240033);
  }
  
  public View getTabContainer()
  {
    return this.nP;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(240036);
    super.jumpDrawablesToCurrentState();
    if (this.mj != null) {
      this.mj.jumpToCurrentState();
    }
    if (this.nS != null) {
      this.nS.jumpToCurrentState();
    }
    if (this.nT != null) {
      this.nT.jumpToCurrentState();
    }
    AppMethodBeat.o(240036);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(240016);
    super.onFinishInflate();
    this.nQ = findViewById(a.f.action_bar);
    this.nR = findViewById(a.f.action_context_bar);
    AppMethodBeat.o(240016);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240046);
    super.onHoverEvent(paramMotionEvent);
    AppMethodBeat.o(240046);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240042);
    if ((this.nO) || (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(240042);
      return true;
    }
    AppMethodBeat.o(240042);
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(240064);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.nP;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.nU) {
        break label153;
      }
      if (this.nT == null) {
        break label333;
      }
      this.nT.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      AppMethodBeat.o(240064);
      return;
      paramBoolean = false;
      break;
      label153:
      if (this.mj != null) {
        if (this.nQ.getVisibility() == 0) {
          this.mj.setBounds(this.nQ.getLeft(), this.nQ.getTop(), this.nQ.getRight(), this.nQ.getBottom());
        }
      }
      label205:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.nV = paramBoolean;
        if ((paramBoolean) && (this.nS != null))
        {
          this.nS.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.nR != null) && (this.nR.getVisibility() == 0))
          {
            this.mj.setBounds(this.nR.getLeft(), this.nR.getTop(), this.nR.getRight(), this.nR.getBottom());
            break label205;
          }
          this.mj.setBounds(0, 0, 0, 0);
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
    AppMethodBeat.i(240061);
    int i = paramInt2;
    if (this.nQ == null)
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
    if (this.nQ == null)
    {
      AppMethodBeat.o(240061);
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(i);
    if ((this.nP != null) && (this.nP.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (l(this.nQ)) {
        break label156;
      }
      paramInt1 = m(this.nQ);
      if (paramInt2 != -2147483648) {
        break label182;
      }
    }
    label156:
    label182:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + m(this.nP), paramInt2));
      AppMethodBeat.o(240061);
      return;
      if (!l(this.nR))
      {
        paramInt1 = m(this.nR);
        break;
      }
      paramInt1 = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240044);
    super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(240044);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(240019);
    if (this.mj != null)
    {
      this.mj.setCallback(null);
      unscheduleDrawable(this.mj);
    }
    this.mj = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.nQ != null) {
        this.mj.setBounds(this.nQ.getLeft(), this.nQ.getTop(), this.nQ.getRight(), this.nQ.getBottom());
      }
    }
    if (this.nU) {
      if (this.nT != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(240019);
      return;
      bool = false;
      continue;
      if ((this.mj != null) || (this.nS != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(240024);
    if (this.nT != null)
    {
      this.nT.setCallback(null);
      unscheduleDrawable(this.nT);
    }
    this.nT = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.nU) && (this.nT != null)) {
        this.nT.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.nU) {
      if (this.nT != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(240024);
      return;
      bool = false;
      continue;
      if ((this.mj != null) || (this.nS != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    AppMethodBeat.i(240021);
    if (this.nS != null)
    {
      this.nS.setCallback(null);
      unscheduleDrawable(this.nS);
    }
    this.nS = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.nV) && (this.nS != null)) {
        this.nS.setBounds(this.nP.getLeft(), this.nP.getTop(), this.nP.getRight(), this.nP.getBottom());
      }
    }
    if (this.nU) {
      if (this.nT != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(240021);
      return;
      bool = false;
      continue;
      if ((this.mj != null) || (this.nS != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(w paramw)
  {
    AppMethodBeat.i(240049);
    if (this.nP != null) {
      removeView(this.nP);
    }
    this.nP = paramw;
    if (paramw != null)
    {
      addView(paramw);
      ViewGroup.LayoutParams localLayoutParams = paramw.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramw.setAllowCollapse(false);
    }
    AppMethodBeat.o(240049);
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    AppMethodBeat.i(240040);
    this.nO = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      AppMethodBeat.o(240040);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(240027);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.mj != null) {
        this.mj.setVisible(bool, false);
      }
      if (this.nS != null) {
        this.nS.setVisible(bool, false);
      }
      if (this.nT != null) {
        this.nT.setVisible(bool, false);
      }
      AppMethodBeat.o(240027);
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    AppMethodBeat.i(240054);
    if (paramInt != 0)
    {
      paramView = super.startActionModeForChild(paramView, paramCallback, paramInt);
      AppMethodBeat.o(240054);
      return paramView;
    }
    AppMethodBeat.o(240054);
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240031);
    if (((paramDrawable == this.mj) && (!this.nU)) || ((paramDrawable == this.nS) && (this.nV)) || ((paramDrawable == this.nT) && (this.nU)) || (super.verifyDrawable(paramDrawable)))
    {
      AppMethodBeat.o(240031);
      return true;
    }
    AppMethodBeat.o(240031);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */