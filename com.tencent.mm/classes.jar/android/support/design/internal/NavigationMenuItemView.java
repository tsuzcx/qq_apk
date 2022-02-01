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
import android.support.v4.view.t;
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
  private static final int[] hY = { 16842912 };
  private final int fJ;
  boolean gM;
  private boolean iX;
  final CheckedTextView iY;
  FrameLayout iZ;
  private j ik;
  private ColorStateList ja;
  private boolean jb;
  private Drawable jc;
  private final android.support.v4.view.a jd = new android.support.v4.view.a()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
      paramAnonymousc.setCheckable(NavigationMenuItemView.this.gM);
    }
  };
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(2131493704, this, true);
    this.fJ = paramContext.getResources().getDimensionPixelSize(2131166115);
    this.iY = ((CheckedTextView)findViewById(2131299014));
    this.iY.setDuplicateParentStateEnabled(true);
    t.a(this.iY, this.jd);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.iZ == null) {
        this.iZ = ((FrameLayout)((ViewStub)findViewById(2131299013)).inflate());
      }
      this.iZ.removeAllViews();
      this.iZ.addView(paramView);
    }
  }
  
  public final void a(j paramj)
  {
    this.ik = paramj;
    int i;
    StateListDrawable localStateListDrawable;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(2130968806, localTypedValue, true)) {
          break label247;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(hY, new ColorDrawable(localTypedValue.data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label95:
        t.a(this, localStateListDrawable);
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      bb.a(this, paramj.getTooltipText());
      if ((this.ik.getTitle() != null) || (this.ik.getIcon() != null) || (this.ik.getActionView() == null)) {
        break label252;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label257;
      }
      this.iY.setVisibility(8);
      if (this.iZ != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.iZ.getLayoutParams();
        paramj.width = -1;
        this.iZ.setLayoutParams(paramj);
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
      this.iY.setVisibility(0);
    } while (this.iZ == null);
    label257:
    paramj = (LinearLayoutCompat.LayoutParams)this.iZ.getLayoutParams();
    paramj.width = -2;
    this.iZ.setLayoutParams(paramj);
  }
  
  public final boolean bl()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.ik;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.ik != null) && (this.ik.isCheckable()) && (this.ik.isChecked())) {
      mergeDrawableStates(arrayOfInt, hY);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.gM != paramBoolean)
    {
      this.gM = paramBoolean;
      this.jd.sendAccessibilityEvent(this.iY, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.iY.setChecked(paramBoolean);
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
      if (this.jb)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.ja);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.fJ, this.fJ);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      q.a(this.iY, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.iX)
      {
        if (this.jc == null)
        {
          this.jc = f.c(getResources(), 2131233417, getContext().getTheme());
          if (this.jc != null) {
            this.jc.setBounds(0, 0, this.fJ, this.fJ);
          }
        }
        paramDrawable = this.jc;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    this.iY.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.ja = paramColorStateList;
    if (this.ja != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jb = bool;
      if (this.ik != null) {
        setIcon(this.ik.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.iX = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    q.d(this.iY, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.iY.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.iY.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */