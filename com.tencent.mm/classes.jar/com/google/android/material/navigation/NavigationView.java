package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.appcompat.a.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ac;
import androidx.core.g.ae;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g.b;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] wo = { 16842912 };
  private static final int[] wp = { -16842910 };
  private final f bDg;
  private final com.google.android.material.internal.g bDh;
  a bDi;
  private MenuInflater bxl;
  private final int maxWidth;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.navigationViewStyle);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238588);
    this.bDh = new com.google.android.material.internal.g();
    this.bDg = new f(paramContext);
    ac localac = k.b(paramContext, paramAttributeSet, a.k.NavigationView, paramInt, a.j.Widget_Design_NavigationView, new int[0]);
    w.a(this, localac.getDrawable(a.k.NavigationView_android_background));
    if (localac.aC(a.k.NavigationView_elevation)) {
      w.j(this, localac.p(a.k.NavigationView_elevation, 0));
    }
    w.c(this, localac.c(a.k.NavigationView_android_fitsSystemWindows, false));
    this.maxWidth = localac.p(a.k.NavigationView_android_maxWidth, 0);
    ColorStateList localColorStateList;
    if (localac.aC(a.k.NavigationView_itemIconTint))
    {
      localColorStateList = localac.getColorStateList(a.k.NavigationView_itemIconTint);
      if (!localac.aC(a.k.NavigationView_itemTextAppearance)) {
        break label592;
      }
      paramInt = localac.r(a.k.NavigationView_itemTextAppearance, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localac.aC(a.k.NavigationView_itemTextColor)) {
        paramAttributeSet = localac.getColorStateList(a.k.NavigationView_itemTextColor);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = ga(16842806);
        }
      }
      paramAttributeSet = localac.getDrawable(a.k.NavigationView_itemBackground);
      if (localac.aC(a.k.NavigationView_itemHorizontalPadding))
      {
        j = localac.p(a.k.NavigationView_itemHorizontalPadding, 0);
        this.bDh.setItemHorizontalPadding(j);
      }
      int j = localac.p(a.k.NavigationView_itemIconPadding, 0);
      this.bDg.a(new h.a()
      {
        public final void a(h paramAnonymoush) {}
        
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(238480);
          if ((NavigationView.this.bDi != null) && (NavigationView.this.bDi.wm()))
          {
            AppMethodBeat.o(238480);
            return true;
          }
          AppMethodBeat.o(238480);
          return false;
        }
      });
      this.bDh.id = 1;
      this.bDh.a(paramContext, this.bDg);
      this.bDh.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.bDh.setItemTextAppearance(paramInt);
      }
      this.bDh.setItemTextColor((ColorStateList)localObject);
      this.bDh.setItemBackground(paramAttributeSet);
      this.bDh.setItemIconPadding(j);
      this.bDg.a(this.bDh);
      paramContext = this.bDh;
      if (paramContext.bCC == null)
      {
        paramContext.bCC = ((NavigationMenuView)paramContext.layoutInflater.inflate(a.h.design_navigation_menu, this, false));
        if (paramContext.bCF == null) {
          paramContext.bCF = new g.b(paramContext);
        }
        paramContext.bCD = ((LinearLayout)paramContext.layoutInflater.inflate(a.h.design_navigation_item_header, paramContext.bCC, false));
        paramContext.bCC.setAdapter(paramContext.bCF);
      }
      addView((View)paramContext.bCC);
      if (localac.aC(a.k.NavigationView_menu))
      {
        paramInt = localac.r(a.k.NavigationView_menu, 0);
        this.bDh.bh(true);
        getMenuInflater().inflate(paramInt, this.bDg);
        this.bDh.bh(false);
        this.bDh.F(false);
      }
      if (localac.aC(a.k.NavigationView_headerLayout))
      {
        paramInt = localac.r(a.k.NavigationView_headerLayout, 0);
        paramContext = this.bDh;
        paramAttributeSet = paramContext.layoutInflater.inflate(paramInt, paramContext.bCD, false);
        paramContext.bCD.addView(paramAttributeSet);
        paramContext.bCC.setPadding(0, 0, 0, paramContext.bCC.getPaddingBottom());
      }
      localac.wA.recycle();
      AppMethodBeat.o(238588);
      return;
      localColorStateList = ga(16842808);
      break;
      label592:
      paramInt = 0;
    }
  }
  
  private ColorStateList ga(int paramInt)
  {
    AppMethodBeat.i(238630);
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(238630);
      return null;
    }
    ColorStateList localColorStateList = androidx.appcompat.a.a.a.l(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(238630);
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = wp;
    int[] arrayOfInt1 = wo;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(wp, i);
    localColorStateList = new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
    AppMethodBeat.o(238630);
    return localColorStateList;
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(238629);
    if (this.bxl == null) {
      this.bxl = new androidx.appcompat.view.g(getContext());
    }
    MenuInflater localMenuInflater = this.bxl;
    AppMethodBeat.o(238629);
    return localMenuInflater;
  }
  
  public final void b(ae paramae)
  {
    AppMethodBeat.i(238600);
    com.google.android.material.internal.g localg = this.bDh;
    int i = paramae.hd();
    if (localg.bCJ != i)
    {
      localg.bCJ = i;
      if (localg.bCD.getChildCount() == 0) {
        localg.bCC.setPadding(0, localg.bCJ, 0, localg.bCC.getPaddingBottom());
      }
    }
    w.b(localg.bCD, paramae);
    AppMethodBeat.o(238600);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.bDh.bCF.bCN;
  }
  
  public int getHeaderCount()
  {
    AppMethodBeat.i(238605);
    int i = this.bDh.bCD.getChildCount();
    AppMethodBeat.o(238605);
    return i;
  }
  
  public Drawable getItemBackground()
  {
    return this.bDh.bxe;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.bDh.itemHorizontalPadding;
  }
  
  public int getItemIconPadding()
  {
    return this.bDh.itemIconPadding;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.bDh.bCx;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.bDh.bCI;
  }
  
  public Menu getMenu()
  {
    return this.bDg;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238597);
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      AppMethodBeat.o(238597);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(238593);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(238593);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    this.bDg.f(paramParcelable.he);
    AppMethodBeat.o(238593);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(238590);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.he = new Bundle();
    this.bDg.e(localSavedState.he);
    AppMethodBeat.o(238590);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    AppMethodBeat.i(238623);
    MenuItem localMenuItem = this.bDg.findItem(paramInt);
    if (localMenuItem != null) {
      this.bDh.h((j)localMenuItem);
    }
    AppMethodBeat.o(238623);
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(238625);
    paramMenuItem = this.bDg.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.bDh.h((j)paramMenuItem);
      AppMethodBeat.o(238625);
      return;
    }
    paramMenuItem = new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    AppMethodBeat.o(238625);
    throw paramMenuItem;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(238613);
    this.bDh.setItemBackground(paramDrawable);
    AppMethodBeat.o(238613);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(238612);
    setItemBackground(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(238612);
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(238614);
    this.bDh.setItemHorizontalPadding(paramInt);
    AppMethodBeat.o(238614);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    AppMethodBeat.i(238616);
    this.bDh.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(238616);
  }
  
  public void setItemIconPadding(int paramInt)
  {
    AppMethodBeat.i(238618);
    this.bDh.setItemIconPadding(paramInt);
    AppMethodBeat.o(238618);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    AppMethodBeat.i(238621);
    this.bDh.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(238621);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238607);
    this.bDh.setItemIconTintList(paramColorStateList);
    AppMethodBeat.o(238607);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    AppMethodBeat.i(238628);
    this.bDh.setItemTextAppearance(paramInt);
    AppMethodBeat.o(238628);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238611);
    this.bDh.setItemTextColor(paramColorStateList);
    AppMethodBeat.o(238611);
  }
  
  public void setNavigationItemSelectedListener(a parama)
  {
    this.bDi = parama;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public Bundle he;
    
    static
    {
      AppMethodBeat.i(238549);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(238549);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(238542);
      this.he = paramParcel.readBundle(paramClassLoader);
      AppMethodBeat.o(238542);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(238545);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.he);
      AppMethodBeat.o(238545);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean wm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView
 * JD-Core Version:    0.7.0.1
 */