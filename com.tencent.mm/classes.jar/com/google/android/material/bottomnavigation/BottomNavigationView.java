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
import androidx.core.g.z;
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
  private final BottomNavigationPresenter dqk;
  private final BottomNavigationMenuView dqm;
  private MenuInflater dqo;
  private b dqp;
  private a dqq;
  private final h hP;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209635);
    this.dqk = new BottomNavigationPresenter();
    this.hP = new a(paramContext);
    this.dqm = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.dqm.setLayoutParams(localLayoutParams);
    this.dqk.dqm = this.dqm;
    this.dqk.id = 1;
    this.dqm.setPresenter(this.dqk);
    this.hP.a(this.dqk);
    this.dqk.a(getContext(), this.hP);
    paramAttributeSet = k.b(paramContext, paramAttributeSet, a.k.BottomNavigationView, paramInt, a.j.Widget_Design_BottomNavigationView, new int[] { a.k.BottomNavigationView_itemTextAppearanceInactive, a.k.BottomNavigationView_itemTextAppearanceActive });
    if (paramAttributeSet.az(a.k.BottomNavigationView_itemIconTint)) {
      this.dqm.setIconTintList(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemIconTint));
    }
    for (;;)
    {
      setItemIconSize(paramAttributeSet.u(a.k.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_icon_size)));
      if (paramAttributeSet.az(a.k.BottomNavigationView_itemTextAppearanceInactive)) {
        setItemTextAppearanceInactive(paramAttributeSet.w(a.k.BottomNavigationView_itemTextAppearanceInactive, 0));
      }
      if (paramAttributeSet.az(a.k.BottomNavigationView_itemTextAppearanceActive)) {
        setItemTextAppearanceActive(paramAttributeSet.w(a.k.BottomNavigationView_itemTextAppearanceActive, 0));
      }
      if (paramAttributeSet.az(a.k.BottomNavigationView_itemTextColor)) {
        setItemTextColor(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemTextColor));
      }
      if (paramAttributeSet.az(a.k.BottomNavigationView_elevation)) {
        z.k(this, paramAttributeSet.u(a.k.BottomNavigationView_elevation, 0));
      }
      setLabelVisibilityMode(paramAttributeSet.s(a.k.BottomNavigationView_labelVisibilityMode, -1));
      setItemHorizontalTranslationEnabled(paramAttributeSet.m(a.k.BottomNavigationView_itemHorizontalTranslationEnabled, true));
      paramInt = paramAttributeSet.w(a.k.BottomNavigationView_itemBackground, 0);
      this.dqm.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.az(a.k.BottomNavigationView_menu))
      {
        paramInt = paramAttributeSet.w(a.k.BottomNavigationView_menu, 0);
        this.dqk.dqn = true;
        getMenuInflater().inflate(paramInt, this.hP);
        this.dqk.dqn = false;
        this.dqk.J(true);
      }
      paramAttributeSet.xv.recycle();
      addView(this.dqm, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(androidx.core.content.a.w(paramContext, a.c.design_bottom_navigation_shadow_color));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_shadow_height)));
        addView(paramAttributeSet);
      }
      this.hP.a(new h.a()
      {
        public final void a(h paramAnonymoush) {}
        
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(209660);
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()))
          {
            BottomNavigationView.a(BottomNavigationView.this);
            AppMethodBeat.o(209660);
            return true;
          }
          if ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).VL()))
          {
            AppMethodBeat.o(209660);
            return true;
          }
          AppMethodBeat.o(209660);
          return false;
        }
      });
      AppMethodBeat.o(209635);
      return;
      this.dqm.setIconTintList(this.dqm.VJ());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(209646);
    if (this.dqo == null) {
      this.dqo = new g(getContext());
    }
    MenuInflater localMenuInflater = this.dqo;
    AppMethodBeat.o(209646);
    return localMenuInflater;
  }
  
  public Drawable getItemBackground()
  {
    AppMethodBeat.i(209761);
    Drawable localDrawable = this.dqm.getItemBackground();
    AppMethodBeat.o(209761);
    return localDrawable;
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    AppMethodBeat.i(209742);
    int i = this.dqm.getItemBackgroundRes();
    AppMethodBeat.o(209742);
    return i;
  }
  
  public int getItemIconSize()
  {
    AppMethodBeat.i(209721);
    int i = this.dqm.getItemIconSize();
    AppMethodBeat.o(209721);
    return i;
  }
  
  public ColorStateList getItemIconTintList()
  {
    AppMethodBeat.i(209691);
    ColorStateList localColorStateList = this.dqm.getIconTintList();
    AppMethodBeat.o(209691);
    return localColorStateList;
  }
  
  public int getItemTextAppearanceActive()
  {
    AppMethodBeat.i(209831);
    int i = this.dqm.getItemTextAppearanceActive();
    AppMethodBeat.o(209831);
    return i;
  }
  
  public int getItemTextAppearanceInactive()
  {
    AppMethodBeat.i(209819);
    int i = this.dqm.getItemTextAppearanceInactive();
    AppMethodBeat.o(209819);
    return i;
  }
  
  public ColorStateList getItemTextColor()
  {
    AppMethodBeat.i(209727);
    ColorStateList localColorStateList = this.dqm.getItemTextColor();
    AppMethodBeat.o(209727);
    return localColorStateList;
  }
  
  public int getLabelVisibilityMode()
  {
    AppMethodBeat.i(209804);
    int i = this.dqm.getLabelVisibilityMode();
    AppMethodBeat.o(209804);
    return i;
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.hP;
  }
  
  public int getSelectedItemId()
  {
    AppMethodBeat.i(209774);
    int i = this.dqm.getSelectedItemId();
    AppMethodBeat.o(209774);
    return i;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(209853);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(209853);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    this.hP.g(paramParcelable.dqs);
    AppMethodBeat.o(209853);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(209846);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.dqs = new Bundle();
    this.hP.f(localSavedState.dqs);
    AppMethodBeat.o(209846);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209769);
    this.dqm.setItemBackground(paramDrawable);
    AppMethodBeat.o(209769);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(209753);
    this.dqm.setItemBackgroundRes(paramInt);
    AppMethodBeat.o(209753);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(209838);
    if (this.dqm.dqa != paramBoolean)
    {
      this.dqm.setItemHorizontalTranslationEnabled(paramBoolean);
      this.dqk.J(false);
    }
    AppMethodBeat.o(209838);
  }
  
  public void setItemIconSize(int paramInt)
  {
    AppMethodBeat.i(209707);
    this.dqm.setItemIconSize(paramInt);
    AppMethodBeat.o(209707);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    AppMethodBeat.i(209714);
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(209714);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209699);
    this.dqm.setIconTintList(paramColorStateList);
    AppMethodBeat.o(209699);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(209825);
    this.dqm.setItemTextAppearanceActive(paramInt);
    AppMethodBeat.o(209825);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(209812);
    this.dqm.setItemTextAppearanceInactive(paramInt);
    AppMethodBeat.o(209812);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209730);
    this.dqm.setItemTextColor(paramColorStateList);
    AppMethodBeat.o(209730);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    AppMethodBeat.i(209792);
    if (this.dqm.getLabelVisibilityMode() != paramInt)
    {
      this.dqm.setLabelVisibilityMode(paramInt);
      this.dqk.J(false);
    }
    AppMethodBeat.o(209792);
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.dqq = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.dqp = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    AppMethodBeat.i(209784);
    MenuItem localMenuItem = this.hP.findItem(paramInt);
    if ((localMenuItem != null) && (!this.hP.a(localMenuItem, this.dqk, 0))) {
      localMenuItem.setChecked(true);
    }
    AppMethodBeat.o(209784);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Bundle dqs;
    
    static
    {
      AppMethodBeat.i(209657);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(209657);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(209653);
      this.dqs = paramParcel.readBundle(paramClassLoader);
      AppMethodBeat.o(209653);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209663);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.dqs);
      AppMethodBeat.o(209663);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean VL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */