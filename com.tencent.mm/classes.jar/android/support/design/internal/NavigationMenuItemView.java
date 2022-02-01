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
  private static final int[] jT = { 16842912 };
  private final int hA;
  boolean iH;
  private boolean kO;
  final CheckedTextView kP;
  FrameLayout kQ;
  private ColorStateList kR;
  private boolean kS;
  private Drawable kT;
  private final android.support.v4.view.a kU = new android.support.v4.view.a()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
      paramAnonymousc.setCheckable(NavigationMenuItemView.this.iH);
    }
  };
  private j ke;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(2131493704, this, true);
    this.hA = paramContext.getResources().getDimensionPixelSize(2131166115);
    this.kP = ((CheckedTextView)findViewById(2131299014));
    this.kP.setDuplicateParentStateEnabled(true);
    t.a(this.kP, this.kU);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.kQ == null) {
        this.kQ = ((FrameLayout)((ViewStub)findViewById(2131299013)).inflate());
      }
      this.kQ.removeAllViews();
      this.kQ.addView(paramView);
    }
  }
  
  public final void a(j paramj)
  {
    this.ke = paramj;
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
        localStateListDrawable.addState(jT, new ColorDrawable(localTypedValue.data));
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
      if ((this.ke.getTitle() != null) || (this.ke.getIcon() != null) || (this.ke.getActionView() == null)) {
        break label252;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label257;
      }
      this.kP.setVisibility(8);
      if (this.kQ != null)
      {
        paramj = (LinearLayoutCompat.LayoutParams)this.kQ.getLayoutParams();
        paramj.width = -1;
        this.kQ.setLayoutParams(paramj);
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
      this.kP.setVisibility(0);
    } while (this.kQ == null);
    label257:
    paramj = (LinearLayoutCompat.LayoutParams)this.kQ.getLayoutParams();
    paramj.width = -2;
    this.kQ.setLayoutParams(paramj);
  }
  
  public final boolean bA()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.ke;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.ke != null) && (this.ke.isCheckable()) && (this.ke.isChecked())) {
      mergeDrawableStates(arrayOfInt, jT);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.iH != paramBoolean)
    {
      this.iH = paramBoolean;
      this.kU.sendAccessibilityEvent(this.kP, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.kP.setChecked(paramBoolean);
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
      if (this.kS)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.kR);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.hA, this.hA);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      q.a(this.kP, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.kO)
      {
        if (this.kT == null)
        {
          this.kT = f.c(getResources(), 2131233417, getContext().getTheme());
          if (this.kT != null) {
            this.kT.setBounds(0, 0, this.hA, this.hA);
          }
        }
        paramDrawable = this.kT;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    this.kP.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.kR = paramColorStateList;
    if (this.kR != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.kS = bool;
      if (this.ke != null) {
        setIcon(this.ke.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.kO = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    q.d(this.kP, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.kP.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.kP.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */