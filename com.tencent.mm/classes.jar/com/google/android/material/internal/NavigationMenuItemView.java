package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.a.a;
import androidx.appcompat.view.menu.p.a;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.ae;
import androidx.core.content.a.f;
import androidx.core.g.a.d;
import androidx.core.g.z;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements p.a
{
  private static final int[] xk = { 16842912 };
  private androidx.appcompat.view.menu.j dpQ;
  boolean dsb;
  private Drawable dvA;
  private final androidx.core.g.a dvB;
  private boolean dvv;
  final CheckedTextView dvw;
  FrameLayout dvx;
  private ColorStateList dvy;
  private boolean dvz;
  private final int iconSize;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209427);
    this.dvB = new androidx.core.g.a()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
      {
        AppMethodBeat.i(209373);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
        paramAnonymousd.setCheckable(NavigationMenuItemView.this.dsb);
        AppMethodBeat.o(209373);
      }
    };
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(a.h.design_navigation_menu_item, this, true);
    this.iconSize = paramContext.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
    this.dvw = ((CheckedTextView)findViewById(a.f.design_menu_item_text));
    this.dvw.setDuplicateParentStateEnabled(true);
    z.a(this.dvw, this.dvB);
    AppMethodBeat.o(209427);
  }
  
  private void setActionView(View paramView)
  {
    AppMethodBeat.i(209436);
    if (paramView != null)
    {
      if (this.dvx == null) {
        this.dvx = ((FrameLayout)((ViewStub)findViewById(a.f.design_menu_item_action_area_stub)).inflate());
      }
      this.dvx.removeAllViews();
      this.dvx.addView(paramView);
    }
    AppMethodBeat.o(209436);
  }
  
  public final void a(androidx.appcompat.view.menu.j paramj)
  {
    AppMethodBeat.i(209453);
    this.dpQ = paramj;
    StateListDrawable localStateListDrawable;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.a.colorControlHighlight, localTypedValue, true)) {
          break label258;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(xk, new ColorDrawable(localTypedValue.data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label101:
        z.a(this, localStateListDrawable);
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      ae.a(this, paramj.getTooltipText());
      if ((this.dpQ.getTitle() != null) || (this.dpQ.getIcon() != null) || (this.dpQ.getActionView() == null)) {
        break label263;
      }
    }
    label258:
    label263:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label268;
      }
      this.dvw.setVisibility(8);
      if (this.dvx == null) {
        break label308;
      }
      paramj = (LinearLayoutCompat.LayoutParams)this.dvx.getLayoutParams();
      paramj.width = -1;
      this.dvx.setLayoutParams(paramj);
      AppMethodBeat.o(209453);
      return;
      i = 8;
      break;
      localStateListDrawable = null;
      break label101;
    }
    label268:
    this.dvw.setVisibility(0);
    if (this.dvx != null)
    {
      paramj = (LinearLayoutCompat.LayoutParams)this.dvx.getLayoutParams();
      paramj.width = -2;
      this.dvx.setLayoutParams(paramj);
    }
    label308:
    AppMethodBeat.o(209453);
  }
  
  public final boolean cE()
  {
    return false;
  }
  
  public androidx.appcompat.view.menu.j getItemData()
  {
    return this.dpQ;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(209496);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.dpQ != null) && (this.dpQ.isCheckable()) && (this.dpQ.isChecked())) {
      mergeDrawableStates(arrayOfInt, xk);
    }
    AppMethodBeat.o(209496);
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(209470);
    refreshDrawableState();
    if (this.dsb != paramBoolean)
    {
      this.dsb = paramBoolean;
      this.dvB.sendAccessibilityEvent(this.dvw, 2048);
    }
    AppMethodBeat.o(209470);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(209477);
    refreshDrawableState();
    this.dvw.setChecked(paramBoolean);
    AppMethodBeat.o(209477);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(209535);
    setPadding(paramInt, 0, paramInt, 0);
    AppMethodBeat.o(209535);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209483);
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.dvz)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = androidx.core.graphics.drawable.a.s(paramDrawable).mutate();
          androidx.core.graphics.drawable.a.a((Drawable)localObject, this.dvy);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.iconSize, this.iconSize);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      androidx.core.widget.j.a(this.dvw, paramDrawable, null, null, null);
      AppMethodBeat.o(209483);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.dvv)
      {
        if (this.dvA == null)
        {
          this.dvA = f.b(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
          if (this.dvA != null) {
            this.dvA.setBounds(0, 0, this.iconSize, this.iconSize);
          }
        }
        paramDrawable = this.dvA;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    AppMethodBeat.i(209542);
    this.dvw.setCompoundDrawablePadding(paramInt);
    AppMethodBeat.o(209542);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209504);
    this.dvy = paramColorStateList;
    if (this.dvy != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.dvz = bool;
      if (this.dpQ != null) {
        setIcon(this.dpQ.getIcon());
      }
      AppMethodBeat.o(209504);
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.dvv = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    AppMethodBeat.i(209512);
    androidx.core.widget.j.a(this.dvw, paramInt);
    AppMethodBeat.o(209512);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209520);
    this.dvw.setTextColor(paramColorStateList);
    AppMethodBeat.o(209520);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209464);
    this.dvw.setText(paramCharSequence);
    AppMethodBeat.o(209464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */