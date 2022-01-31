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
import android.support.v4.view.a.b;
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
  private static final int[] dP = { 16842912 };
  private j dZ;
  private final int eB;
  private boolean eC;
  boolean eD;
  final CheckedTextView eE;
  FrameLayout eF;
  private ColorStateList eG;
  private boolean eH;
  private Drawable eI;
  private final android.support.v4.view.a eJ = new android.support.v4.view.a()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, b paramAnonymousb)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousb);
      paramAnonymousb.setCheckable(NavigationMenuItemView.this.eD);
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
    LayoutInflater.from(paramContext).inflate(2130969316, this, true);
    this.eB = paramContext.getResources().getDimensionPixelSize(2131428297);
    this.eE = ((CheckedTextView)findViewById(2131823380));
    this.eE.setDuplicateParentStateEnabled(true);
    t.a(this.eE, this.eJ);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.eF == null) {
        this.eF = ((FrameLayout)((ViewStub)findViewById(2131823381)).inflate());
      }
      this.eF.removeAllViews();
      this.eF.addView(paramView);
    }
  }
  
  public final void a(j paramj)
  {
    this.dZ = paramj;
    int i;
    StateListDrawable localStateListDrawable;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(2130772211, localTypedValue, true)) {
          break label247;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(dP, new ColorDrawable(localTypedValue.data));
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
      if ((this.dZ.getTitle() != null) || (this.dZ.getIcon() != null) || (this.dZ.getActionView() == null)) {
        break label252;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label257;
      }
      this.eE.setVisibility(8);
      if (this.eF != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.eF.getLayoutParams();
        paramj.width = -1;
        this.eF.setLayoutParams(paramj);
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
      this.eE.setVisibility(0);
    } while (this.eF == null);
    label257:
    paramj = (LinearLayoutCompat.LayoutParams)this.eF.getLayoutParams();
    paramj.width = -2;
    this.eF.setLayoutParams(paramj);
  }
  
  public final boolean aE()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.dZ;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.dZ != null) && (this.dZ.isCheckable()) && (this.dZ.isChecked())) {
      mergeDrawableStates(arrayOfInt, dP);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.eD != paramBoolean)
    {
      this.eD = paramBoolean;
      this.eJ.sendAccessibilityEvent(this.eE, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.eE.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.eH)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.graphics.drawable.a.e(paramDrawable).mutate();
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.eG);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.eB, this.eB);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      q.a(this.eE, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.eC)
      {
        if (this.eI == null)
        {
          this.eI = f.c(getResources(), 2130839775, getContext().getTheme());
          if (this.eI != null) {
            this.eI.setBounds(0, 0, this.eB, this.eB);
          }
        }
        paramDrawable = this.eI;
      }
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.eG = paramColorStateList;
    if (this.eG != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.eH = bool;
      if (this.dZ != null) {
        setIcon(this.dZ.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.eC = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    q.b(this.eE, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.eE.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.eE.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */