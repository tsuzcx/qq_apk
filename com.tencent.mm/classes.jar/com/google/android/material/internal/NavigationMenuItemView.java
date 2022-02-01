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
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p.a;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.ae;
import androidx.core.content.a.f;
import androidx.core.g.a.d;
import androidx.core.g.w;
import androidx.core.widget.i;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements p.a
{
  private static final int[] wo = { 16842912 };
  private final androidx.core.g.a bCA;
  private boolean bCu;
  final CheckedTextView bCv;
  FrameLayout bCw;
  private ColorStateList bCx;
  private boolean bCy;
  private Drawable bCz;
  private j bwN;
  boolean bzb;
  private final int iconSize;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237774);
    this.bCA = new androidx.core.g.a()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
      {
        AppMethodBeat.i(237755);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
        paramAnonymousd.setCheckable(NavigationMenuItemView.this.bzb);
        AppMethodBeat.o(237755);
      }
    };
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(a.h.design_navigation_menu_item, this, true);
    this.iconSize = paramContext.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
    this.bCv = ((CheckedTextView)findViewById(a.f.design_menu_item_text));
    this.bCv.setDuplicateParentStateEnabled(true);
    w.a(this.bCv, this.bCA);
    AppMethodBeat.o(237774);
  }
  
  private void setActionView(View paramView)
  {
    AppMethodBeat.i(237782);
    if (paramView != null)
    {
      if (this.bCw == null) {
        this.bCw = ((FrameLayout)((ViewStub)findViewById(a.f.design_menu_item_action_area_stub)).inflate());
      }
      this.bCw.removeAllViews();
      this.bCw.addView(paramView);
    }
    AppMethodBeat.o(237782);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(237779);
    this.bwN = paramj;
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
        localStateListDrawable.addState(wo, new ColorDrawable(localTypedValue.data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label101:
        w.a(this, localStateListDrawable);
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      ae.a(this, paramj.getTooltipText());
      if ((this.bwN.getTitle() != null) || (this.bwN.getIcon() != null) || (this.bwN.getActionView() == null)) {
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
      this.bCv.setVisibility(8);
      if (this.bCw == null) {
        break label308;
      }
      paramj = (LinearLayoutCompat.LayoutParams)this.bCw.getLayoutParams();
      paramj.width = -1;
      this.bCw.setLayoutParams(paramj);
      AppMethodBeat.o(237779);
      return;
      i = 8;
      break;
      localStateListDrawable = null;
      break label101;
    }
    label268:
    this.bCv.setVisibility(0);
    if (this.bCw != null)
    {
      paramj = (LinearLayoutCompat.LayoutParams)this.bCw.getLayoutParams();
      paramj.width = -2;
      this.bCw.setLayoutParams(paramj);
    }
    label308:
    AppMethodBeat.o(237779);
  }
  
  public final boolean bL()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.bwN;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(237796);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.bwN != null) && (this.bwN.isCheckable()) && (this.bwN.isChecked())) {
      mergeDrawableStates(arrayOfInt, wo);
    }
    AppMethodBeat.o(237796);
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(237786);
    refreshDrawableState();
    if (this.bzb != paramBoolean)
    {
      this.bzb = paramBoolean;
      this.bCA.sendAccessibilityEvent(this.bCv, 2048);
    }
    AppMethodBeat.o(237786);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(237787);
    refreshDrawableState();
    this.bCv.setChecked(paramBoolean);
    AppMethodBeat.o(237787);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(237807);
    setPadding(paramInt, 0, paramInt, 0);
    AppMethodBeat.o(237807);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(237791);
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.bCy)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = androidx.core.graphics.drawable.a.p(paramDrawable).mutate();
          androidx.core.graphics.drawable.a.a((Drawable)localObject, this.bCx);
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
      i.a(this.bCv, paramDrawable, null, null, null);
      AppMethodBeat.o(237791);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.bCu)
      {
        if (this.bCz == null)
        {
          this.bCz = f.b(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
          if (this.bCz != null) {
            this.bCz.setBounds(0, 0, this.iconSize, this.iconSize);
          }
        }
        paramDrawable = this.bCz;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    AppMethodBeat.i(237810);
    this.bCv.setCompoundDrawablePadding(paramInt);
    AppMethodBeat.o(237810);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237799);
    this.bCx = paramColorStateList;
    if (this.bCx != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bCy = bool;
      if (this.bwN != null) {
        setIcon(this.bwN.getIcon());
      }
      AppMethodBeat.o(237799);
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.bCu = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    AppMethodBeat.i(237801);
    i.a(this.bCv, paramInt);
    AppMethodBeat.o(237801);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237803);
    this.bCv.setTextColor(paramColorStateList);
    AppMethodBeat.o(237803);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(237783);
    this.bCv.setText(paramCharSequence);
    AppMethodBeat.o(237783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */