package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.a;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.c;
import android.support.design.internal.c.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.t;
import android.support.v7.c.a.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.widget.az;
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
  private static final int[] dP = { 16842912 };
  private static final int[] gc = { -16842910 };
  private MenuInflater gd;
  private final android.support.design.internal.b kh;
  private final c ki = new c();
  NavigationView.a kj;
  private int mMaxWidth;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.F(paramContext);
    this.kh = new android.support.design.internal.b(paramContext);
    az localaz = az.a(paramContext, paramAttributeSet, a.a.NavigationView, paramInt, 2131493840);
    t.a(this, localaz.getDrawable(0));
    if (localaz.hasValue(3)) {
      t.i(this, localaz.getDimensionPixelSize(3, 0));
    }
    t.e(this, localaz.getBoolean(1, false));
    this.mMaxWidth = localaz.getDimensionPixelSize(2, 0);
    ColorStateList localColorStateList;
    if (localaz.hasValue(5))
    {
      localColorStateList = localaz.getColorStateList(5);
      if (!localaz.hasValue(8)) {
        break label503;
      }
      paramInt = localaz.getResourceId(8, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localaz.hasValue(6)) {
        paramAttributeSet = localaz.getColorStateList(6);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = J(16842806);
        }
      }
      paramAttributeSet = localaz.getDrawable(7);
      this.kh.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.kj != null) && (NavigationView.this.kj.aX());
        }
        
        public final void b(h paramAnonymoush) {}
      });
      this.ki.mId = 1;
      this.ki.a(paramContext, this.kh);
      this.ki.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.ki.setItemTextAppearance(paramInt);
      }
      this.ki.setItemTextColor((ColorStateList)localObject);
      this.ki.setItemBackground(paramAttributeSet);
      this.kh.a(this.ki);
      paramContext = this.ki;
      if (paramContext.eL == null)
      {
        paramContext.eL = ((NavigationMenuView)paramContext.mLayoutInflater.inflate(2130969315, this, false));
        if (paramContext.eO == null) {
          paramContext.eO = new c.b(paramContext);
        }
        paramContext.eM = ((LinearLayout)paramContext.mLayoutInflater.inflate(2130969312, paramContext.eL, false));
        paramContext.eL.setAdapter(paramContext.eO);
      }
      addView((View)paramContext.eL);
      if (localaz.hasValue(4))
      {
        paramInt = localaz.getResourceId(4, 0);
        this.ki.o(true);
        getMenuInflater().inflate(paramInt, this.kh);
        this.ki.o(false);
        this.ki.n(false);
      }
      if (localaz.hasValue(9))
      {
        paramInt = localaz.getResourceId(9, 0);
        paramContext = this.ki;
        paramAttributeSet = paramContext.mLayoutInflater.inflate(paramInt, paramContext.eM, false);
        paramContext.eM.addView(paramAttributeSet);
        paramContext.eL.setPadding(0, 0, 0, paramContext.eL.getPaddingBottom());
      }
      localaz.aoo.recycle();
      return;
      localColorStateList = J(16842808);
      break;
      label503:
      paramInt = 0;
    }
  }
  
  private ColorStateList J(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.l(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130772206, (TypedValue)localObject, true));
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = gc;
    int[] arrayOfInt1 = dP;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(gc, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.gd == null) {
      this.gd = new g(getContext());
    }
    return this.gd;
  }
  
  public final void a(ab paramab)
  {
    c localc = this.ki;
    int i = paramab.getSystemWindowInsetTop();
    if (localc.eT != i)
    {
      localc.eT = i;
      if (localc.eM.getChildCount() == 0) {
        localc.eL.setPadding(0, localc.eT, 0, localc.eL.getPaddingBottom());
      }
    }
    t.b(localc.eM, paramab);
  }
  
  public int getHeaderCount()
  {
    return this.ki.eM.getChildCount();
  }
  
  public Drawable getItemBackground()
  {
    return this.ki.eS;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.ki.eG;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.ki.eR;
  }
  
  public Menu getMenu()
  {
    return this.kh;
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
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.mMaxWidth), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
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
    super.onRestoreInstanceState(paramParcelable.Fo);
    this.kh.dispatchRestoreInstanceState(paramParcelable.kl);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NavigationView.SavedState localSavedState = new NavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.kl = new Bundle();
    this.kh.c(localSavedState.kl);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    Object localObject = this.kh.findItem(paramInt);
    if (localObject != null)
    {
      c localc = this.ki;
      localObject = (j)localObject;
      localc.eO.d((j)localObject);
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.ki.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(android.support.v4.content.b.k(getContext(), paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.ki.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.ki.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.ki.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(NavigationView.a parama)
  {
    this.kj = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.7.0.1
 */