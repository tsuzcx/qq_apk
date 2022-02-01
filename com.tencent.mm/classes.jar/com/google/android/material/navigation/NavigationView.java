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
import androidx.core.g.ah;
import androidx.core.g.z;
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
  private static final int[] xk = { 16842912 };
  private static final int[] xl = { -16842910 };
  private MenuInflater dqo;
  private final f dwh;
  private final com.google.android.material.internal.g dwi;
  a dwj;
  private final int maxWidth;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.navigationViewStyle);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209602);
    this.dwi = new com.google.android.material.internal.g();
    this.dwh = new f(paramContext);
    ac localac = k.b(paramContext, paramAttributeSet, a.k.NavigationView, paramInt, a.j.Widget_Design_NavigationView, new int[0]);
    z.a(this, localac.getDrawable(a.k.NavigationView_android_background));
    if (localac.az(a.k.NavigationView_elevation)) {
      z.k(this, localac.u(a.k.NavigationView_elevation, 0));
    }
    z.c(this, localac.m(a.k.NavigationView_android_fitsSystemWindows, false));
    this.maxWidth = localac.u(a.k.NavigationView_android_maxWidth, 0);
    ColorStateList localColorStateList;
    if (localac.az(a.k.NavigationView_itemIconTint))
    {
      localColorStateList = localac.getColorStateList(a.k.NavigationView_itemIconTint);
      if (!localac.az(a.k.NavigationView_itemTextAppearance)) {
        break label592;
      }
      paramInt = localac.w(a.k.NavigationView_itemTextAppearance, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localac.az(a.k.NavigationView_itemTextColor)) {
        paramAttributeSet = localac.getColorStateList(a.k.NavigationView_itemTextColor);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = jp(16842806);
        }
      }
      paramAttributeSet = localac.getDrawable(a.k.NavigationView_itemBackground);
      if (localac.az(a.k.NavigationView_itemHorizontalPadding))
      {
        j = localac.u(a.k.NavigationView_itemHorizontalPadding, 0);
        this.dwi.setItemHorizontalPadding(j);
      }
      int j = localac.u(a.k.NavigationView_itemIconPadding, 0);
      this.dwh.a(new h.a()
      {
        public final void a(h paramAnonymoush) {}
        
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(209577);
          if ((NavigationView.this.dwj != null) && (NavigationView.this.dwj.VL()))
          {
            AppMethodBeat.o(209577);
            return true;
          }
          AppMethodBeat.o(209577);
          return false;
        }
      });
      this.dwi.id = 1;
      this.dwi.a(paramContext, this.dwh);
      this.dwi.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.dwi.setItemTextAppearance(paramInt);
      }
      this.dwi.setItemTextColor((ColorStateList)localObject);
      this.dwi.setItemBackground(paramAttributeSet);
      this.dwi.setItemIconPadding(j);
      this.dwh.a(this.dwi);
      paramContext = this.dwi;
      if (paramContext.dvD == null)
      {
        paramContext.dvD = ((NavigationMenuView)paramContext.dvH.inflate(a.h.design_navigation_menu, this, false));
        if (paramContext.dvG == null) {
          paramContext.dvG = new g.b(paramContext);
        }
        paramContext.dvE = ((LinearLayout)paramContext.dvH.inflate(a.h.design_navigation_item_header, paramContext.dvD, false));
        paramContext.dvD.setAdapter(paramContext.dvG);
      }
      addView((View)paramContext.dvD);
      if (localac.az(a.k.NavigationView_menu))
      {
        paramInt = localac.w(a.k.NavigationView_menu, 0);
        this.dwi.bO(true);
        getMenuInflater().inflate(paramInt, this.dwh);
        this.dwi.bO(false);
        this.dwi.J(false);
      }
      if (localac.az(a.k.NavigationView_headerLayout))
      {
        paramInt = localac.w(a.k.NavigationView_headerLayout, 0);
        paramContext = this.dwi;
        paramAttributeSet = paramContext.dvH.inflate(paramInt, paramContext.dvE, false);
        paramContext.dvE.addView(paramAttributeSet);
        paramContext.dvD.setPadding(0, 0, 0, paramContext.dvD.getPaddingBottom());
      }
      localac.xv.recycle();
      AppMethodBeat.o(209602);
      return;
      localColorStateList = jp(16842808);
      break;
      label592:
      paramInt = 0;
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(209612);
    if (this.dqo == null) {
      this.dqo = new androidx.appcompat.view.g(getContext());
    }
    MenuInflater localMenuInflater = this.dqo;
    AppMethodBeat.o(209612);
    return localMenuInflater;
  }
  
  private ColorStateList jp(int paramInt)
  {
    AppMethodBeat.i(209626);
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(209626);
      return null;
    }
    ColorStateList localColorStateList = androidx.appcompat.a.a.a.l(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(209626);
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = xl;
    int[] arrayOfInt1 = xk;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(xl, i);
    localColorStateList = new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
    AppMethodBeat.o(209626);
    return localColorStateList;
  }
  
  public final void c(ah paramah)
  {
    AppMethodBeat.i(209671);
    com.google.android.material.internal.g localg = this.dwi;
    int i = paramah.En();
    if (localg.dvL != i)
    {
      localg.dvL = i;
      if (localg.dvE.getChildCount() == 0) {
        localg.dvD.setPadding(0, localg.dvL, 0, localg.dvD.getPaddingBottom());
      }
    }
    z.b(localg.dvE, paramah);
    AppMethodBeat.o(209671);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.dwi.dvG.dvP;
  }
  
  public int getHeaderCount()
  {
    AppMethodBeat.i(209686);
    int i = this.dwi.dvE.getChildCount();
    AppMethodBeat.o(209686);
    return i;
  }
  
  public Drawable getItemBackground()
  {
    return this.dwi.dqh;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.dwi.itemHorizontalPadding;
  }
  
  public int getItemIconPadding()
  {
    return this.dwi.itemIconPadding;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.dwi.dvy;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.dwi.dvK;
  }
  
  public Menu getMenu()
  {
    return this.dwh;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209665);
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      AppMethodBeat.o(209665);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(209650);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(209650);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    this.dwh.g(paramParcelable.hZ);
    AppMethodBeat.o(209650);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(209643);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.hZ = new Bundle();
    this.dwh.f(localSavedState.hZ);
    AppMethodBeat.o(209643);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    AppMethodBeat.i(209813);
    MenuItem localMenuItem = this.dwh.findItem(paramInt);
    if (localMenuItem != null) {
      this.dwi.h((j)localMenuItem);
    }
    AppMethodBeat.o(209813);
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(209821);
    paramMenuItem = this.dwh.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.dwi.h((j)paramMenuItem);
      AppMethodBeat.o(209821);
      return;
    }
    paramMenuItem = new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    AppMethodBeat.o(209821);
    throw paramMenuItem;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209755);
    this.dwi.setItemBackground(paramDrawable);
    AppMethodBeat.o(209755);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(209735);
    setItemBackground(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(209735);
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(209773);
    this.dwi.setItemHorizontalPadding(paramInt);
    AppMethodBeat.o(209773);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209780);
    this.dwi.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(209780);
  }
  
  public void setItemIconPadding(int paramInt)
  {
    AppMethodBeat.i(209796);
    this.dwi.setItemIconPadding(paramInt);
    AppMethodBeat.o(209796);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209805);
    this.dwi.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
    AppMethodBeat.o(209805);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209704);
    this.dwi.setItemIconTintList(paramColorStateList);
    AppMethodBeat.o(209704);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    AppMethodBeat.i(209835);
    this.dwi.setItemTextAppearance(paramInt);
    AppMethodBeat.o(209835);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209716);
    this.dwi.setItemTextColor(paramColorStateList);
    AppMethodBeat.o(209716);
  }
  
  public void setNavigationItemSelectedListener(a parama)
  {
    this.dwj = parama;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public Bundle hZ;
    
    static
    {
      AppMethodBeat.i(209585);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(209585);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(209571);
      this.hZ = paramParcel.readBundle(paramClassLoader);
      AppMethodBeat.o(209571);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209592);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.hZ);
      AppMethodBeat.o(209592);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean VL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView
 * JD-Core Version:    0.7.0.1
 */