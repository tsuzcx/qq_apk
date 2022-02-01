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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarContextView
  extends a
{
  private CharSequence cZ;
  private CharSequence da;
  private TextView eM;
  private View nW;
  private View nX;
  private LinearLayout nY;
  private TextView nZ;
  private int oa;
  private int ob;
  public boolean oc;
  private int od;
  
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
    AppMethodBeat.i(240090);
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.ActionMode, paramInt, 0);
    w.a(this, paramContext.getDrawable(a.j.ActionMode_background));
    this.oa = paramContext.r(a.j.ActionMode_titleTextStyle, 0);
    this.ob = paramContext.r(a.j.ActionMode_subtitleTextStyle, 0);
    this.nH = paramContext.q(a.j.ActionMode_height, 0);
    this.od = paramContext.r(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
    paramContext.wA.recycle();
    AppMethodBeat.o(240090);
  }
  
  private void cD()
  {
    int m = 8;
    int j = 1;
    AppMethodBeat.i(240103);
    if (this.nY == null)
    {
      LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
      this.nY = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.eM = ((TextView)this.nY.findViewById(a.f.action_bar_title));
      this.nZ = ((TextView)this.nY.findViewById(a.f.action_bar_subtitle));
      if (this.oa != 0) {
        this.eM.setTextAppearance(getContext(), this.oa);
      }
      if (this.ob != 0) {
        this.nZ.setTextAppearance(getContext(), this.ob);
      }
    }
    this.eM.setText(this.cZ);
    this.nZ.setText(this.da);
    int i;
    label172:
    Object localObject;
    if (!TextUtils.isEmpty(this.cZ))
    {
      i = 1;
      if (TextUtils.isEmpty(this.da)) {
        break label244;
      }
      localObject = this.nZ;
      if (j == 0) {
        break label249;
      }
    }
    label244:
    label249:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.nY;
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
      if (this.nY.getParent() == null) {
        addView(this.nY);
      }
      AppMethodBeat.o(240103);
      return;
      i = 0;
      break;
      j = 0;
      break label172;
    }
  }
  
  public final void c(final b paramb)
  {
    AppMethodBeat.i(240106);
    if (this.nW == null)
    {
      this.nW = LayoutInflater.from(getContext()).inflate(this.od, this, false);
      addView(this.nW);
    }
    for (;;)
    {
      this.nW.findViewById(a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240073);
          paramb.finish();
          AppMethodBeat.o(240073);
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.nG != null) {
        this.nG.cP();
      }
      this.nG = new ActionMenuPresenter(getContext());
      this.nG.cO();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.nG, this.nE);
      this.nF = ((ActionMenuView)this.nG.a(this));
      w.a(this.nF, null);
      addView(this.nF, localLayoutParams);
      AppMethodBeat.o(240106);
      return;
      if (this.nW.getParent() == null) {
        addView(this.nW);
      }
    }
  }
  
  public final boolean cC()
  {
    AppMethodBeat.i(240111);
    if (this.nG != null)
    {
      boolean bool = this.nG.cC();
      AppMethodBeat.o(240111);
      return bool;
    }
    AppMethodBeat.o(240111);
    return false;
  }
  
  public final void cE()
  {
    AppMethodBeat.i(240108);
    if (this.nW == null)
    {
      cF();
      AppMethodBeat.o(240108);
      return;
    }
    AppMethodBeat.o(240108);
  }
  
  public final void cF()
  {
    AppMethodBeat.i(240109);
    removeAllViews();
    this.nX = null;
    this.nF = null;
    AppMethodBeat.o(240109);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(240113);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
    AppMethodBeat.o(240113);
    return localMarginLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(240115);
    paramAttributeSet = new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(240115);
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
    AppMethodBeat.i(240092);
    super.onDetachedFromWindow();
    if (this.nG != null)
    {
      this.nG.cL();
      this.nG.cQ();
    }
    AppMethodBeat.o(240092);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(240121);
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.cZ);
      AppMethodBeat.o(240121);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(240121);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240120);
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
      if (this.nW != null)
      {
        paramInt2 = i;
        if (this.nW.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.nW.getLayoutParams();
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
          paramInt2 = a(i, paramInt2, paramBoolean);
          paramInt2 = a(paramInt2 + a(this.nW, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.nY != null)
      {
        paramInt4 = paramInt2;
        if (this.nX == null)
        {
          paramInt4 = paramInt2;
          if (this.nY.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.nY, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.nX != null) {
        a(this.nX, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label285;
      }
      paramInt1 = getPaddingLeft();
      label219:
      if (this.nF != null)
      {
        localObject = this.nF;
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
      AppMethodBeat.o(240120);
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
    AppMethodBeat.i(240117);
    Object localObject;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      localObject = new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
      AppMethodBeat.o(240117);
      throw ((Throwable)localObject);
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      localObject = new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
      AppMethodBeat.o(240117);
      throw ((Throwable)localObject);
    }
    int n = View.MeasureSpec.getSize(paramInt1);
    int i;
    int m;
    int j;
    if (this.nH > 0)
    {
      i = this.nH;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      if (this.nW != null)
      {
        paramInt1 = b(this.nW, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.nW.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.nF != null)
      {
        paramInt1 = paramInt2;
        if (this.nF.getParent() == this) {
          paramInt1 = b(this.nF, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.nY != null)
      {
        paramInt2 = paramInt1;
        if (this.nX == null)
        {
          if (!this.oc) {
            break label518;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.nY.measure(paramInt2, j);
          int i2 = this.nY.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label506;
          }
          j = 1;
          label314:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.nY;
          if (j == 0) {
            break label512;
          }
          paramInt1 = 0;
          label339:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label345:
      if (this.nX != null)
      {
        localObject = this.nX.getLayoutParams();
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
        this.nX.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label410:
      label430:
      if (this.nH > 0) {
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
      paramInt2 = b(this.nY, paramInt1, j);
      break label345;
      paramInt1 = -2147483648;
      break label375;
      paramInt2 = -2147483648;
      break label410;
      k = m;
      break label430;
      setMeasuredDimension(n, paramInt1);
      AppMethodBeat.o(240117);
      return;
      setMeasuredDimension(n, i);
      AppMethodBeat.o(240117);
      return;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.nH = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    AppMethodBeat.i(240096);
    if (this.nX != null) {
      removeView(this.nX);
    }
    this.nX = paramView;
    if ((paramView != null) && (this.nY != null))
    {
      removeView(this.nY);
      this.nY = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
    AppMethodBeat.o(240096);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240099);
    this.da = paramCharSequence;
    cD();
    AppMethodBeat.o(240099);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240098);
    this.cZ = paramCharSequence;
    cD();
    AppMethodBeat.o(240098);
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    AppMethodBeat.i(240122);
    if (paramBoolean != this.oc) {
      requestLayout();
    }
    this.oc = paramBoolean;
    AppMethodBeat.o(240122);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */