package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.widget.ac;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.c;
import com.google.android.material.a.d;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BottomNavigationView
  extends FrameLayout
{
  private final BottomNavigationPresenter bxh;
  private final BottomNavigationMenuView bxj;
  private MenuInflater bxl;
  private b bxm;
  private a bxn;
  private final h gU;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235247);
    this.bxh = new BottomNavigationPresenter();
    this.gU = new a(paramContext);
    this.bxj = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.bxj.setLayoutParams(localLayoutParams);
    this.bxh.bxj = this.bxj;
    this.bxh.id = 1;
    this.bxj.setPresenter(this.bxh);
    this.gU.a(this.bxh);
    this.bxh.a(getContext(), this.gU);
    paramAttributeSet = k.b(paramContext, paramAttributeSet, a.k.BottomNavigationView, paramInt, a.j.Widget_Design_BottomNavigationView, new int[] { a.k.BottomNavigationView_itemTextAppearanceInactive, a.k.BottomNavigationView_itemTextAppearanceActive });
    if (paramAttributeSet.aC(a.k.BottomNavigationView_itemIconTint)) {
      this.bxj.setIconTintList(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemIconTint));
    }
    for (;;)
    {
      setItemIconSize(paramAttributeSet.p(a.k.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_icon_size)));
      if (paramAttributeSet.aC(a.k.BottomNavigationView_itemTextAppearanceInactive)) {
        setItemTextAppearanceInactive(paramAttributeSet.r(a.k.BottomNavigationView_itemTextAppearanceInactive, 0));
      }
      if (paramAttributeSet.aC(a.k.BottomNavigationView_itemTextAppearanceActive)) {
        setItemTextAppearanceActive(paramAttributeSet.r(a.k.BottomNavigationView_itemTextAppearanceActive, 0));
      }
      if (paramAttributeSet.aC(a.k.BottomNavigationView_itemTextColor)) {
        setItemTextColor(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemTextColor));
      }
      if (paramAttributeSet.aC(a.k.BottomNavigationView_elevation)) {
        w.j(this, paramAttributeSet.p(a.k.BottomNavigationView_elevation, 0));
      }
      setLabelVisibilityMode(paramAttributeSet.n(a.k.BottomNavigationView_labelVisibilityMode, -1));
      setItemHorizontalTranslationEnabled(paramAttributeSet.c(a.k.BottomNavigationView_itemHorizontalTranslationEnabled, true));
      paramInt = paramAttributeSet.r(a.k.BottomNavigationView_itemBackground, 0);
      this.bxj.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.aC(a.k.BottomNavigationView_menu))
      {
        paramInt = paramAttributeSet.r(a.k.BottomNavigationView_menu, 0);
        this.bxh.bxk = true;
        getMenuInflater().inflate(paramInt, this.gU);
        this.bxh.bxk = false;
        this.bxh.F(true);
      }
      paramAttributeSet.wA.recycle();
      addView(this.bxj, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(androidx.core.content.a.w(paramContext, a.c.design_bottom_navigation_shadow_color));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_shadow_height)));
        addView(paramAttributeSet);
      }
      this.gU.a(new h.a()
      {
        public final void a(h paramAnonymoush) {}
        
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(235218);
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()))
          {
            BottomNavigationView.a(BottomNavigationView.this);
            AppMethodBeat.o(235218);
            return true;
          }
          if ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).wm()))
          {
            AppMethodBeat.o(235218);
            return true;
          }
          AppMethodBeat.o(235218);
          return false;
        }
      });
      AppMethodBeat.o(235247);
      return;
      this.bxj.setIconTintList(this.bxj.wk());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(235289);
    if (this.bxl == null) {
      this.bxl = new g(getContext());
    }
    MenuInflater localMenuInflater = this.bxl;
    AppMethodBeat.o(235289);
    return localMenuInflater;
  }
  
  public Drawable getItemBackground()
  {
    AppMethodBeat.i(235269);
    Drawable localDrawable = this.bxj.getItemBackground();
    AppMethodBeat.o(235269);
    return localDrawable;
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    AppMethodBeat.i(235266);
    int i = this.bxj.getItemBackgroundRes();
    AppMethodBeat.o(235266);
    return i;
  }
  
  public int getItemIconSize()
  {
    AppMethodBeat.i(235263);
    int i = this.bxj.getItemIconSize();
    AppMethodBeat.o(235263);
    return i;
  }
  
  public ColorStateList getItemIconTintList()
  {
    AppMethodBeat.i(235256);
    ColorStateList localColorStateList = this.bxj.getIconTintList();
    AppMethodBeat.o(235256);
    return localColorStateList;
  }
  
  public int getItemTextAppearanceActive()
  {
    AppMethodBeat.i(235285);
    int i = this.bxj.getItemTextAppearanceActive();
    AppMethodBeat.o(235285);
    return i;
  }
  
  public int getItemTextAppearanceInactive()
  {
    AppMethodBeat.i(235281);
    int i = this.bxj.getItemTextAppearanceInactive();
    AppMethodBeat.o(235281);
    return i;
  }
  
  public ColorStateList getItemTextColor()
  {
    AppMethodBeat.i(235264);
    ColorStateList localColorStateList = this.bxj.getItemTextColor();
    AppMethodBeat.o(235264);
    return localColorStateList;
  }
  
  public int getLabelVisibilityMode()
  {
    AppMethodBeat.i(235278);
    int i = this.bxj.getLabelVisibilityMode();
    AppMethodBeat.o(235278);
    return i;
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.gU;
  }
  
  public int getSelectedItemId()
  {
    AppMethodBeat.i(235273);
    int i = this.bxj.getSelectedItemId();
    AppMethodBeat.o(235273);
    return i;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(235291);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(235291);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    this.gU.f(paramParcelable.bxp);
    AppMethodBeat.o(235291);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(235290);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.bxp = new Bundle();
    this.gU.e(localSavedState.bxp);
    AppMethodBeat.o(235290);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235271);
    this.bxj.setItemBackground(paramDrawable);
    AppMethodBeat.o(235271);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(235267);
    this.bxj.setItemBackgroundRes(paramInt);
    AppMethodBeat.o(235267);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235287);
    if (this.bxj.bwX != paramBoolean)
    {
      this.bxj.setItemHorizontalTranslationEnabled(paramBoolean);
      this.bxh.F(false);
    }
    AppMethodBeat.o(235287);
  }
  
  public void setItemIconSize(int paramInt)
  {
    AppMethodBeat.i(235260);
    this.bxj.setItemIconSize(paramInt);
    AppMethodBeat.o(235260);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    AppMethodBeat.i(235261);
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(235261);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235259);
    this.bxj.setIconTintList(paramColorStateList);
    AppMethodBeat.o(235259);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(235283);
    this.bxj.setItemTextAppearanceActive(paramInt);
    AppMethodBeat.o(235283);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(235280);
    this.bxj.setItemTextAppearanceInactive(paramInt);
    AppMethodBeat.o(235280);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235265);
    this.bxj.setItemTextColor(paramColorStateList);
    AppMethodBeat.o(235265);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    AppMethodBeat.i(235277);
    if (this.bxj.getLabelVisibilityMode() != paramInt)
    {
      this.bxj.setLabelVisibilityMode(paramInt);
      this.bxh.F(false);
    }
    AppMethodBeat.o(235277);
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.bxn = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.bxm = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    AppMethodBeat.i(235275);
    MenuItem localMenuItem = this.gU.findItem(paramInt);
    if ((localMenuItem != null) && (!this.gU.a(localMenuItem, this.bxh, 0))) {
      localMenuItem.setChecked(true);
    }
    AppMethodBeat.o(235275);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Bundle bxp;
    
    static
    {
      AppMethodBeat.i(235234);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(235234);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(235231);
      this.bxp = paramParcel.readBundle(paramClassLoader);
      AppMethodBeat.o(235231);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235233);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.bxp);
      AppMethodBeat.o(235233);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean wm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */