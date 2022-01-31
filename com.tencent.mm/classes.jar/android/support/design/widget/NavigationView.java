package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.c;
import android.support.design.internal.c.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.support.v7.a.a.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.widget.ax;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] cL = { 16842912 };
  private static final int[] fd = { -16842910 };
  private int eg;
  private MenuInflater fe;
  private final android.support.design.internal.b jj;
  private final c jk = new c();
  NavigationView.a jl;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o.G(paramContext);
    this.jj = new android.support.design.internal.b(paramContext);
    ax localax = ax.a(paramContext, paramAttributeSet, a.k.NavigationView, paramInt, a.j.Widget_Design_NavigationView);
    q.a(this, localax.getDrawable(a.k.NavigationView_android_background));
    if (localax.hasValue(a.k.NavigationView_elevation)) {
      q.h(this, localax.getDimensionPixelSize(a.k.NavigationView_elevation, 0));
    }
    q.e(this, localax.getBoolean(a.k.NavigationView_android_fitsSystemWindows, false));
    this.eg = localax.getDimensionPixelSize(a.k.NavigationView_android_maxWidth, 0);
    ColorStateList localColorStateList;
    if (localax.hasValue(a.k.NavigationView_itemIconTint))
    {
      localColorStateList = localax.getColorStateList(a.k.NavigationView_itemIconTint);
      if (!localax.hasValue(a.k.NavigationView_itemTextAppearance)) {
        break label532;
      }
      paramInt = localax.getResourceId(a.k.NavigationView_itemTextAppearance, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localax.hasValue(a.k.NavigationView_itemTextColor)) {
        paramAttributeSet = localax.getColorStateList(a.k.NavigationView_itemTextColor);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = K(16842806);
        }
      }
      paramAttributeSet = localax.getDrawable(a.k.NavigationView_itemBackground);
      this.jj.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.jl != null) && (NavigationView.this.jl.at());
        }
        
        public final void b(h paramAnonymoush) {}
      });
      this.jk.mId = 1;
      this.jk.a(paramContext, this.jj);
      this.jk.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.jk.setItemTextAppearance(paramInt);
      }
      this.jk.setItemTextColor((ColorStateList)localObject);
      this.jk.setItemBackground(paramAttributeSet);
      this.jj.a(this.jk);
      paramContext = this.jk;
      if (paramContext.dJ == null)
      {
        paramContext.dJ = ((NavigationMenuView)paramContext.mLayoutInflater.inflate(a.h.design_navigation_menu, this, false));
        if (paramContext.dM == null) {
          paramContext.dM = new c.b(paramContext);
        }
        paramContext.dK = ((LinearLayout)paramContext.mLayoutInflater.inflate(a.h.design_navigation_item_header, paramContext.dJ, false));
        paramContext.dJ.setAdapter(paramContext.dM);
      }
      addView((View)paramContext.dJ);
      if (localax.hasValue(a.k.NavigationView_menu))
      {
        paramInt = localax.getResourceId(a.k.NavigationView_menu, 0);
        this.jk.p(true);
        getMenuInflater().inflate(paramInt, this.jj);
        this.jk.p(false);
        this.jk.o(false);
      }
      if (localax.hasValue(a.k.NavigationView_headerLayout))
      {
        paramInt = localax.getResourceId(a.k.NavigationView_headerLayout, 0);
        paramContext = this.jk;
        paramAttributeSet = paramContext.mLayoutInflater.inflate(paramInt, paramContext.dK, false);
        paramContext.dK.addView(paramAttributeSet);
        paramContext.dJ.setPadding(0, 0, 0, paramContext.dJ.getPaddingBottom());
      }
      localax.alZ.recycle();
      return;
      localColorStateList = K(16842808);
      break;
      label532:
      paramInt = 0;
    }
  }
  
  private ColorStateList K(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = android.support.v7.c.a.b.h(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true));
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = fd;
    int[] arrayOfInt1 = cL;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(fd, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.fe == null) {
      this.fe = new g(getContext());
    }
    return this.fe;
  }
  
  protected final void a(y paramy)
  {
    c localc = this.jk;
    int i = paramy.getSystemWindowInsetTop();
    if (localc.dR != i)
    {
      localc.dR = i;
      if (localc.dK.getChildCount() == 0) {
        localc.dJ.setPadding(0, localc.dR, 0, localc.dJ.getPaddingBottom());
      }
    }
    q.b(localc.dK, paramy);
  }
  
  public int getHeaderCount()
  {
    return this.jk.dK.getChildCount();
  }
  
  public Drawable getItemBackground()
  {
    return this.jk.dQ;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.jk.dE;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.jk.dP;
  }
  
  public Menu getMenu()
  {
    return this.jj;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.eg), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.eg, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NavigationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NavigationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.EA);
    this.jj.d(paramParcelable.jn);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NavigationView.SavedState localSavedState = new NavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.jn = new Bundle();
    this.jj.c(localSavedState.jn);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    Object localObject = this.jj.findItem(paramInt);
    if (localObject != null)
    {
      c localc = this.jk;
      localObject = (j)localObject;
      localc.dM.d((j)localObject);
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.jk.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(android.support.v4.content.b.g(getContext(), paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.jk.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.jk.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.jk.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(NavigationView.a parama)
  {
    this.jl = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.7.0.1
 */