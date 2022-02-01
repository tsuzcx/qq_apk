package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.j;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.h;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarContextView
  extends a
{
  private CharSequence cZ;
  private CharSequence da;
  private TextView fO;
  private View oV;
  private View oW;
  private LinearLayout oX;
  private TextView oY;
  private int oZ;
  private int pa;
  public boolean pb;
  private int pc;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199741);
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.ActionMode, paramInt, 0);
    z.a(this, paramContext.getDrawable(a.j.ActionMode_background));
    this.oZ = paramContext.w(a.j.ActionMode_titleTextStyle, 0);
    this.pa = paramContext.w(a.j.ActionMode_subtitleTextStyle, 0);
    this.oG = paramContext.v(a.j.ActionMode_height, 0);
    this.pc = paramContext.w(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
    paramContext.xv.recycle();
    AppMethodBeat.o(199741);
  }
  
  private void dw()
  {
    int m = 8;
    int j = 1;
    AppMethodBeat.i(199753);
    if (this.oX == null)
    {
      LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
      this.oX = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.fO = ((TextView)this.oX.findViewById(a.f.action_bar_title));
      this.oY = ((TextView)this.oX.findViewById(a.f.action_bar_subtitle));
      if (this.oZ != 0) {
        this.fO.setTextAppearance(getContext(), this.oZ);
      }
      if (this.pa != 0) {
        this.oY.setTextAppearance(getContext(), this.pa);
      }
    }
    this.fO.setText(this.cZ);
    this.oY.setText(this.da);
    int i;
    label172:
    Object localObject;
    if (!TextUtils.isEmpty(this.cZ))
    {
      i = 1;
      if (TextUtils.isEmpty(this.da)) {
        break label244;
      }
      localObject = this.oY;
      if (j == 0) {
        break label249;
      }
    }
    label244:
    label249:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.oX;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (this.oX.getParent() == null) {
        addView(this.oX);
      }
      AppMethodBeat.o(199753);
      return;
      i = 0;
      break;
      j = 0;
      break label172;
    }
  }
  
  public final void c(final b paramb)
  {
    AppMethodBeat.i(199821);
    if (this.oV == null)
    {
      this.oV = LayoutInflater.from(getContext()).inflate(this.pc, this, false);
      addView(this.oV);
    }
    for (;;)
    {
      this.oV.findViewById(a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199719);
          paramb.finish();
          AppMethodBeat.o(199719);
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.oF != null) {
        this.oF.dI();
      }
      this.oF = new ActionMenuPresenter(getContext());
      this.oF.dH();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.oF, this.oD);
      this.oE = ((ActionMenuView)this.oF.a(this));
      z.a(this.oE, null);
      addView(this.oE, localLayoutParams);
      AppMethodBeat.o(199821);
      return;
      if (this.oV.getParent() == null) {
        addView(this.oV);
      }
    }
  }
  
  public final boolean dv()
  {
    AppMethodBeat.i(199854);
    if (this.oF != null)
    {
      boolean bool = this.oF.dv();
      AppMethodBeat.o(199854);
      return bool;
    }
    AppMethodBeat.o(199854);
    return false;
  }
  
  public final void dx()
  {
    AppMethodBeat.i(199831);
    if (this.oV == null)
    {
      dy();
      AppMethodBeat.o(199831);
      return;
    }
    AppMethodBeat.o(199831);
  }
  
  public final void dy()
  {
    AppMethodBeat.i(199840);
    removeAllViews();
    this.oW = null;
    this.oE = null;
    AppMethodBeat.o(199840);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(199863);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
    AppMethodBeat.o(199863);
    return localMarginLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(199874);
    paramAttributeSet = new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(199874);
    return paramAttributeSet;
  }
  
  public CharSequence getSubtitle()
  {
    return this.da;
  }
  
  public CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(199763);
    super.onDetachedFromWindow();
    if (this.oF != null)
    {
      this.oF.dE();
      this.oF.dJ();
    }
    AppMethodBeat.o(199763);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(199931);
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.cZ);
      AppMethodBeat.o(199931);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(199931);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199918);
    paramBoolean = ai.s(this);
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      paramInt2 = i;
      if (this.oV != null)
      {
        paramInt2 = i;
        if (this.oV.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.oV.getLayoutParams();
          if (!paramBoolean) {
            break label266;
          }
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
          label95:
          if (!paramBoolean) {
            break label275;
          }
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          label106:
          paramInt2 = b(i, paramInt2, paramBoolean);
          paramInt2 = b(paramInt2 + a(this.oV, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.oX != null)
      {
        paramInt4 = paramInt2;
        if (this.oW == null)
        {
          paramInt4 = paramInt2;
          if (this.oX.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.oX, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.oW != null) {
        a(this.oW, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label285;
      }
      paramInt1 = getPaddingLeft();
      label219:
      if (this.oE != null)
      {
        localObject = this.oE;
        if (paramBoolean) {
          break label298;
        }
      }
    }
    label266:
    label275:
    label285:
    label298:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a((View)localObject, paramInt1, j, k, paramBoolean);
      AppMethodBeat.o(199918);
      return;
      i = getPaddingLeft();
      break;
      paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      break label95;
      paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      break label106;
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
      break label219;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1073741824;
    AppMethodBeat.i(199890);
    Object localObject;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      localObject = new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
      AppMethodBeat.o(199890);
      throw ((Throwable)localObject);
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      localObject = new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
      AppMethodBeat.o(199890);
      throw ((Throwable)localObject);
    }
    int n = View.MeasureSpec.getSize(paramInt1);
    int i;
    int m;
    int j;
    if (this.oG > 0)
    {
      i = this.oG;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      if (this.oV != null)
      {
        paramInt1 = b(this.oV, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.oV.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.oE != null)
      {
        paramInt1 = paramInt2;
        if (this.oE.getParent() == this) {
          paramInt1 = b(this.oE, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.oX != null)
      {
        paramInt2 = paramInt1;
        if (this.oW == null)
        {
          if (!this.pb) {
            break label518;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.oX.measure(paramInt2, j);
          int i2 = this.oX.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label506;
          }
          j = 1;
          label314:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.oX;
          if (j == 0) {
            break label512;
          }
          paramInt1 = 0;
          label339:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label345:
      if (this.oW != null)
      {
        localObject = this.oW.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject).width == -2) {
          break label532;
        }
        paramInt1 = 1073741824;
        label375:
        j = paramInt2;
        if (((ViewGroup.LayoutParams)localObject).width >= 0) {
          j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -2) {
          break label539;
        }
        paramInt2 = k;
        if (((ViewGroup.LayoutParams)localObject).height < 0) {
          break label546;
        }
        k = Math.min(((ViewGroup.LayoutParams)localObject).height, m);
        this.oW.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label410:
      label430:
      if (this.oG > 0) {
        break label567;
      }
      j = getChildCount();
      paramInt2 = 0;
      paramInt1 = 0;
      label466:
      if (paramInt2 >= j) {
        break label553;
      }
      i = getChildAt(paramInt2).getMeasuredHeight() + i1;
      if (i <= paramInt1) {
        break label581;
      }
      paramInt1 = i;
    }
    label512:
    label518:
    label532:
    label539:
    label546:
    label553:
    label567:
    label581:
    for (;;)
    {
      paramInt2 += 1;
      break label466;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      label506:
      j = 0;
      break label314;
      paramInt1 = 8;
      break label339;
      paramInt2 = b(this.oX, paramInt1, j);
      break label345;
      paramInt1 = -2147483648;
      break label375;
      paramInt2 = -2147483648;
      break label410;
      k = m;
      break label430;
      setMeasuredDimension(n, paramInt1);
      AppMethodBeat.o(199890);
      return;
      setMeasuredDimension(n, i);
      AppMethodBeat.o(199890);
      return;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.oG = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    AppMethodBeat.i(199777);
    if (this.oW != null) {
      removeView(this.oW);
    }
    this.oW = paramView;
    if ((paramView != null) && (this.oX != null))
    {
      removeView(this.oX);
      this.oX = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
    AppMethodBeat.o(199777);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199794);
    this.da = paramCharSequence;
    dw();
    AppMethodBeat.o(199794);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199786);
    this.cZ = paramCharSequence;
    dw();
    AppMethodBeat.o(199786);
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    AppMethodBeat.i(199940);
    if (paramBoolean != this.pb) {
      requestLayout();
    }
    this.pb = paramBoolean;
    AppMethodBeat.o(199940);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */