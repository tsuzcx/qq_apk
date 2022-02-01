package android.support.design.widget;

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
import android.support.design.a.a;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.c;
import android.support.design.internal.c.b;
import android.support.design.internal.f;
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
  private static final int[] jT = { 16842912 };
  private static final int[] kf = { -16842910 };
  private final int maxWidth;
  private MenuInflater nL;
  private final android.support.design.internal.b td;
  private final c te = new c();
  a tf;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969318);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.td = new android.support.design.internal.b(paramContext);
    az localaz = f.b(paramContext, paramAttributeSet, a.a.NavigationView, paramInt, 2131821638, new int[0]);
    t.a(this, localaz.getDrawable(0));
    if (localaz.hasValue(3)) {
      t.k(this, localaz.getDimensionPixelSize(3, 0));
    }
    t.e(this, localaz.getBoolean(1, false));
    this.maxWidth = localaz.getDimensionPixelSize(2, 0);
    ColorStateList localColorStateList;
    if (localaz.hasValue(8))
    {
      localColorStateList = localaz.getColorStateList(8);
      if (!localaz.hasValue(9)) {
        break label551;
      }
      paramInt = localaz.getResourceId(9, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localaz.hasValue(10)) {
        paramAttributeSet = localaz.getColorStateList(10);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = ac(16842806);
        }
      }
      paramAttributeSet = localaz.getDrawable(5);
      if (localaz.hasValue(6))
      {
        j = localaz.getDimensionPixelSize(6, 0);
        this.te.setItemHorizontalPadding(j);
      }
      int j = localaz.getDimensionPixelSize(7, 0);
      this.td.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.tf != null) && (NavigationView.this.tf.ca());
        }
        
        public final void b(h paramAnonymoush) {}
      });
      this.te.id = 1;
      this.te.a(paramContext, this.td);
      this.te.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.te.setItemTextAppearance(paramInt);
      }
      this.te.setItemTextColor((ColorStateList)localObject);
      this.te.setItemBackground(paramAttributeSet);
      this.te.setItemIconPadding(j);
      this.td.a(this.te);
      paramContext = this.te;
      if (paramContext.kW == null)
      {
        paramContext.kW = ((NavigationMenuView)paramContext.layoutInflater.inflate(2131493703, this, false));
        if (paramContext.kZ == null) {
          paramContext.kZ = new c.b(paramContext);
        }
        paramContext.kX = ((LinearLayout)paramContext.layoutInflater.inflate(2131493700, paramContext.kW, false));
        paramContext.kW.setAdapter(paramContext.kZ);
      }
      addView((View)paramContext.kW);
      if (localaz.hasValue(11))
      {
        paramInt = localaz.getResourceId(11, 0);
        this.te.q(true);
        getMenuInflater().inflate(paramInt, this.td);
        this.te.q(false);
        this.te.p(false);
      }
      if (localaz.hasValue(4))
      {
        paramInt = localaz.getResourceId(4, 0);
        paramContext = this.te;
        paramAttributeSet = paramContext.layoutInflater.inflate(paramInt, paramContext.kX, false);
        paramContext.kX.addView(paramAttributeSet);
        paramContext.kW.setPadding(0, 0, 0, paramContext.kW.getPaddingBottom());
      }
      localaz.ayA.recycle();
      return;
      localColorStateList = ac(16842808);
      break;
      label551:
      paramInt = 0;
    }
  }
  
  private ColorStateList ac(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.m(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130968815, (TypedValue)localObject, true));
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = kf;
    int[] arrayOfInt1 = jT;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(kf, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.nL == null) {
      this.nL = new g(getContext());
    }
    return this.nL;
  }
  
  public final void a(ab paramab)
  {
    c localc = this.te;
    int i = paramab.getSystemWindowInsetTop();
    if (localc.le != i)
    {
      localc.le = i;
      if (localc.kX.getChildCount() == 0) {
        localc.kW.setPadding(0, localc.le, 0, localc.kW.getPaddingBottom());
      }
    }
    t.b(localc.kX, paramab);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.te.kZ.li;
  }
  
  public int getHeaderCount()
  {
    return this.te.kX.getChildCount();
  }
  
  public Drawable getItemBackground()
  {
    return this.te.ky;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.te.lc;
  }
  
  public int getItemIconPadding()
  {
    return this.te.ld;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.te.kR;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.te.lb;
  }
  
  public Menu getMenu()
  {
    return this.td;
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
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Pa);
    this.td.dispatchRestoreInstanceState(paramParcelable.th);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.th = new Bundle();
    this.td.e(localSavedState.th);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    MenuItem localMenuItem = this.td.findItem(paramInt);
    if (localMenuItem != null) {
      this.te.d((j)localMenuItem);
    }
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    paramMenuItem = this.td.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.te.d((j)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.te.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(android.support.v4.content.b.l(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.te.setItemHorizontalPadding(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    this.te.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.te.setItemIconPadding(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.te.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.te.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.te.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.te.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(a parama)
  {
    this.tf = parama;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    public Bundle th;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.th = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.th);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean ca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.7.0.1
 */