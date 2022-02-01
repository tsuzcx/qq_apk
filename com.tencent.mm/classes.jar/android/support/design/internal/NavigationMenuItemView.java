package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.a.f;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.bb;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements p.a
{
  private static final int[] jV = { 16842912 };
  private final int hC;
  boolean iJ;
  private boolean kQ;
  final CheckedTextView kR;
  FrameLayout kS;
  private ColorStateList kT;
  private boolean kU;
  private Drawable kV;
  private final android.support.v4.view.a kW = new android.support.v4.view.a()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
      paramAnonymousc.setCheckable(NavigationMenuItemView.this.iJ);
    }
  };
  private j kg;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(2131493835, this, true);
    this.hC = paramContext.getResources().getDimensionPixelSize(2131166156);
    this.kR = ((CheckedTextView)findViewById(2131299517));
    this.kR.setDuplicateParentStateEnabled(true);
    u.a(this.kR, this.kW);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.kS == null) {
        this.kS = ((FrameLayout)((ViewStub)findViewById(2131299516)).inflate());
      }
      this.kS.removeAllViews();
      this.kS.addView(paramView);
    }
  }
  
  public final void a(j paramj)
  {
    this.kg = paramj;
    int i;
    StateListDrawable localStateListDrawable;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(2130968821, localTypedValue, true)) {
          break label247;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(jV, new ColorDrawable(localTypedValue.data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label95:
        u.a(this, localStateListDrawable);
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      bb.a(this, paramj.getTooltipText());
      if ((this.kg.getTitle() != null) || (this.kg.getIcon() != null) || (this.kg.getActionView() == null)) {
        break label252;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label257;
      }
      this.kR.setVisibility(8);
      if (this.kS != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.kS.getLayoutParams();
        paramj.width = -1;
        this.kS.setLayoutParams(paramj);
      }
    }
    label247:
    label252:
    do
    {
      return;
      i = 8;
      break;
      localStateListDrawable = null;
      break label95;
      i = 0;
      break label196;
      this.kR.setVisibility(0);
    } while (this.kS == null);
    label257:
    paramj = (LinearLayoutCompat.LayoutParams)this.kS.getLayoutParams();
    paramj.width = -2;
    this.kS.setLayoutParams(paramj);
  }
  
  public final boolean bC()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.kg;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.kg != null) && (this.kg.isCheckable()) && (this.kg.isChecked())) {
      mergeDrawableStates(arrayOfInt, jV);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.iJ != paramBoolean)
    {
      this.iJ = paramBoolean;
      this.kW.sendAccessibilityEvent(this.kR, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.kR.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.kU)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.kT);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.hC, this.hC);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      q.a(this.kR, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.kQ)
      {
        if (this.kV == null)
        {
          this.kV = f.c(getResources(), 2131234215, getContext().getTheme());
          if (this.kV != null) {
            this.kV.setBounds(0, 0, this.hC, this.hC);
          }
        }
        paramDrawable = this.kV;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    this.kR.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.kT = paramColorStateList;
    if (this.kT != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.kU = bool;
      if (this.kg != null) {
        setIcon(this.kg.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.kQ = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    q.d(this.kR, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.kR.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.kR.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */