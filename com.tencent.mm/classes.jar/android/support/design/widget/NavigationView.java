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
import android.support.v4.view.ac;
import android.support.v4.view.u;
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
  private static final int[] jV = { 16842912 };
  private static final int[] kh = { -16842910 };
  private final int maxWidth;
  private MenuInflater nN;
  private final android.support.design.internal.b th;
  private final c ti = new c();
  a tj;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969392);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.th = new android.support.design.internal.b(paramContext);
    az localaz = f.b(paramContext, paramAttributeSet, a.a.NavigationView, paramInt, 2131821686, new int[0]);
    u.a(this, localaz.getDrawable(0));
    if (localaz.hasValue(3)) {
      u.l(this, localaz.getDimensionPixelSize(3, 0));
    }
    u.e(this, localaz.getBoolean(1, false));
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
          localObject = aa(16842806);
        }
      }
      paramAttributeSet = localaz.getDrawable(5);
      if (localaz.hasValue(6))
      {
        j = localaz.getDimensionPixelSize(6, 0);
        this.ti.setItemHorizontalPadding(j);
      }
      int j = localaz.getDimensionPixelSize(7, 0);
      this.th.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.tj != null) && (NavigationView.this.tj.cc());
        }
        
        public final void b(h paramAnonymoush) {}
      });
      this.ti.id = 1;
      this.ti.a(paramContext, this.th);
      this.ti.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.ti.setItemTextAppearance(paramInt);
      }
      this.ti.setItemTextColor((ColorStateList)localObject);
      this.ti.setItemBackground(paramAttributeSet);
      this.ti.setItemIconPadding(j);
      this.th.a(this.ti);
      paramContext = this.ti;
      if (paramContext.kY == null)
      {
        paramContext.kY = ((NavigationMenuView)paramContext.layoutInflater.inflate(2131493834, this, false));
        if (paramContext.lb == null) {
          paramContext.lb = new c.b(paramContext);
        }
        paramContext.kZ = ((LinearLayout)paramContext.layoutInflater.inflate(2131493831, paramContext.kY, false));
        paramContext.kY.setAdapter(paramContext.lb);
      }
      addView((View)paramContext.kY);
      if (localaz.hasValue(11))
      {
        paramInt = localaz.getResourceId(11, 0);
        this.ti.q(true);
        getMenuInflater().inflate(paramInt, this.th);
        this.ti.q(false);
        this.ti.p(false);
      }
      if (localaz.hasValue(4))
      {
        paramInt = localaz.getResourceId(4, 0);
        paramContext = this.ti;
        paramAttributeSet = paramContext.layoutInflater.inflate(paramInt, paramContext.kZ, false);
        paramContext.kZ.addView(paramAttributeSet);
        paramContext.kY.setPadding(0, 0, 0, paramContext.kY.getPaddingBottom());
      }
      localaz.ayy.recycle();
      return;
      localColorStateList = aa(16842808);
      break;
      label551:
      paramInt = 0;
    }
  }
  
  private ColorStateList aa(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.m(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130968830, (TypedValue)localObject, true));
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = kh;
    int[] arrayOfInt1 = jV;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(kh, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.nN == null) {
      this.nN = new g(getContext());
    }
    return this.nN;
  }
  
  public final void a(ac paramac)
  {
    c localc = this.ti;
    int i = paramac.getSystemWindowInsetTop();
    if (localc.lg != i)
    {
      localc.lg = i;
      if (localc.kZ.getChildCount() == 0) {
        localc.kY.setPadding(0, localc.lg, 0, localc.kY.getPaddingBottom());
      }
    }
    u.b(localc.kZ, paramac);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.ti.lb.lk;
  }
  
  public int getHeaderCount()
  {
    return this.ti.kZ.getChildCount();
  }
  
  public Drawable getItemBackground()
  {
    return this.ti.kA;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.ti.le;
  }
  
  public int getItemIconPadding()
  {
    return this.ti.lf;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.ti.kT;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.ti.ld;
  }
  
  public Menu getMenu()
  {
    return this.th;
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
    super.onRestoreInstanceState(paramParcelable.Pm);
    this.th.dispatchRestoreInstanceState(paramParcelable.tl);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.tl = new Bundle();
    this.th.e(localSavedState.tl);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    MenuItem localMenuItem = this.th.findItem(paramInt);
    if (localMenuItem != null) {
      this.ti.d((j)localMenuItem);
    }
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    paramMenuItem = this.th.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.ti.d((j)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.ti.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(android.support.v4.content.b.l(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.ti.setItemHorizontalPadding(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    this.ti.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.ti.setItemIconPadding(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.ti.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.ti.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.ti.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.ti.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(a parama)
  {
    this.tj = parama;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    public Bundle tl;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.tl = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.tl);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean cc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.7.0.1
 */