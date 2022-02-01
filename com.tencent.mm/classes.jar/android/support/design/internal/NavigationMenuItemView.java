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
  private static final int[] gZ = { 16842912 };
  private final int eI;
  boolean fN;
  private boolean hU;
  final CheckedTextView hV;
  FrameLayout hW;
  private ColorStateList hX;
  private boolean hY;
  private Drawable hZ;
  private j hk;
  private final android.support.v4.view.a ia = new android.support.v4.view.a()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
      paramAnonymousc.setCheckable(NavigationMenuItemView.this.fN);
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
    this.eI = paramContext.getResources().getDimensionPixelSize(2131166115);
    this.hV = ((CheckedTextView)findViewById(2131299014));
    this.hV.setDuplicateParentStateEnabled(true);
    t.a(this.hV, this.ia);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.hW == null) {
        this.hW = ((FrameLayout)((ViewStub)findViewById(2131299013)).inflate());
      }
      this.hW.removeAllViews();
      this.hW.addView(paramView);
    }
  }
  
  public final void a(j paramj)
  {
    this.hk = paramj;
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
        localStateListDrawable.addState(gZ, new ColorDrawable(localTypedValue.data));
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
      if ((this.hk.getTitle() != null) || (this.hk.getIcon() != null) || (this.hk.getActionView() == null)) {
        break label252;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label257;
      }
      this.hV.setVisibility(8);
      if (this.hW != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.hW.getLayoutParams();
        paramj.width = -1;
        this.hW.setLayoutParams(paramj);
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
      this.hV.setVisibility(0);
    } while (this.hW == null);
    label257:
    paramj = (LinearLayoutCompat.LayoutParams)this.hW.getLayoutParams();
    paramj.width = -2;
    this.hW.setLayoutParams(paramj);
  }
  
  public final boolean be()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.hk;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.hk != null) && (this.hk.isCheckable()) && (this.hk.isChecked())) {
      mergeDrawableStates(arrayOfInt, gZ);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.fN != paramBoolean)
    {
      this.fN = paramBoolean;
      this.ia.sendAccessibilityEvent(this.hV, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.hV.setChecked(paramBoolean);
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
      if (this.hY)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.hX);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.eI, this.eI);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      q.a(this.hV, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.hU)
      {
        if (this.hZ == null)
        {
          this.hZ = f.c(getResources(), 2131233417, getContext().getTheme());
          if (this.hZ != null) {
            this.hZ.setBounds(0, 0, this.eI, this.eI);
          }
        }
        paramDrawable = this.hZ;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    this.hV.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.hX = paramColorStateList;
    if (this.hX != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.hY = bool;
      if (this.hk != null) {
        setIcon(this.hk.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.hU = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    q.d(this.hV, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.hV.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.hV.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */