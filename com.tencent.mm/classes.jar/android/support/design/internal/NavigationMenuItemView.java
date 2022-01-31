package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.v4.content.a.b;
import android.support.v4.view.q;
import android.support.v4.widget.o;
import android.support.v7.a.a.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.az;
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
  private static final int[] cL = { 16842912 };
  private j cV;
  private boolean dA;
  boolean dB;
  final CheckedTextView dC;
  FrameLayout dD;
  private ColorStateList dE;
  private boolean dF;
  private Drawable dG;
  private final android.support.v4.view.a dH = new NavigationMenuItemView.1(this);
  private final int dz;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(a.h.design_navigation_menu_item, this, true);
    this.dz = paramContext.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
    this.dC = ((CheckedTextView)findViewById(a.f.design_menu_item_text));
    this.dC.setDuplicateParentStateEnabled(true);
    q.a(this.dC, this.dH);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.dD == null) {
        this.dD = ((FrameLayout)((ViewStub)findViewById(a.f.design_menu_item_action_area_stub)).inflate());
      }
      this.dD.removeAllViews();
      this.dD.addView(paramView);
    }
  }
  
  public final boolean T()
  {
    return false;
  }
  
  public final void a(j paramj)
  {
    this.cV = paramj;
    int i;
    StateListDrawable localStateListDrawable;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.a.colorControlHighlight, localTypedValue, true)) {
          break label248;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(cL, new ColorDrawable(localTypedValue.data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label96:
        q.a(this, localStateListDrawable);
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      az.a(this, paramj.getTooltipText());
      if ((this.cV.getTitle() != null) || (this.cV.getIcon() != null) || (this.cV.getActionView() == null)) {
        break label253;
      }
      i = 1;
      label197:
      if (i == 0) {
        break label258;
      }
      this.dC.setVisibility(8);
      if (this.dD != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.dD.getLayoutParams();
        paramj.width = -1;
        this.dD.setLayoutParams(paramj);
      }
    }
    label248:
    label253:
    do
    {
      return;
      i = 8;
      break;
      localStateListDrawable = null;
      break label96;
      i = 0;
      break label197;
      this.dC.setVisibility(0);
    } while (this.dD == null);
    label258:
    paramj = (LinearLayoutCompat.LayoutParams)this.dD.getLayoutParams();
    paramj.width = -2;
    this.dD.setLayoutParams(paramj);
  }
  
  public j getItemData()
  {
    return this.cV;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.cV != null) && (this.cV.isCheckable()) && (this.cV.isChecked())) {
      mergeDrawableStates(arrayOfInt, cL);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.dB != paramBoolean)
    {
      this.dB = paramBoolean;
      android.support.v4.view.a.sendAccessibilityEvent(this.dC, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.dC.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.dF)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.a.a.a.f(paramDrawable).mutate();
          android.support.v4.a.a.a.a((Drawable)localObject, this.dE);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.dz, this.dz);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      o.a(this.dC, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.dA)
      {
        if (this.dG == null)
        {
          this.dG = b.b(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
          if (this.dG != null) {
            this.dG.setBounds(0, 0, this.dz, this.dz);
          }
        }
        paramDrawable = this.dG;
      }
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.dE = paramColorStateList;
    if (this.dE != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.dF = bool;
      if (this.cV != null) {
        setIcon(this.cV.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.dA = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    o.b(this.dC, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.dC.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.dC.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */