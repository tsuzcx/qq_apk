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
  private static final int[] gZ = { 16842912 };
  private static final int[] hl = { -16842910 };
  private MenuInflater kT;
  private final int maxWidth;
  private final android.support.design.internal.b qi;
  private final c qj = new c();
  a qk;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969318);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.qi = new android.support.design.internal.b(paramContext);
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
        this.qj.setItemHorizontalPadding(j);
      }
      int j = localaz.getDimensionPixelSize(7, 0);
      this.qi.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.this.qk != null) && (NavigationView.this.qk.bE());
        }
        
        public final void b(h paramAnonymoush) {}
      });
      this.qj.id = 1;
      this.qj.a(paramContext, this.qi);
      this.qj.setItemIconTintList(localColorStateList);
      if (i != 0) {
        this.qj.setItemTextAppearance(paramInt);
      }
      this.qj.setItemTextColor((ColorStateList)localObject);
      this.qj.setItemBackground(paramAttributeSet);
      this.qj.setItemIconPadding(j);
      this.qi.a(this.qj);
      paramContext = this.qj;
      if (paramContext.ic == null)
      {
        paramContext.ic = ((NavigationMenuView)paramContext.layoutInflater.inflate(2131493703, this, false));
        if (paramContext.ig == null) {
          paramContext.ig = new c.b(paramContext);
        }
        paramContext.ie = ((LinearLayout)paramContext.layoutInflater.inflate(2131493700, paramContext.ic, false));
        paramContext.ic.setAdapter(paramContext.ig);
      }
      addView((View)paramContext.ic);
      if (localaz.hasValue(11))
      {
        paramInt = localaz.getResourceId(11, 0);
        this.qj.q(true);
        getMenuInflater().inflate(paramInt, this.qi);
        this.qj.q(false);
        this.qj.p(false);
      }
      if (localaz.hasValue(4))
      {
        paramInt = localaz.getResourceId(4, 0);
        paramContext = this.qj;
        paramAttributeSet = paramContext.layoutInflater.inflate(paramInt, paramContext.ie, false);
        paramContext.ie.addView(paramAttributeSet);
        paramContext.ic.setPadding(0, 0, 0, paramContext.ic.getPaddingBottom());
      }
      localaz.avP.recycle();
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
    localObject = hl;
    int[] arrayOfInt1 = gZ;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(hl, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.kT == null) {
      this.kT = new g(getContext());
    }
    return this.kT;
  }
  
  public final void a(ab paramab)
  {
    c localc = this.qj;
    int i = paramab.getSystemWindowInsetTop();
    if (localc.il != i)
    {
      localc.il = i;
      if (localc.ie.getChildCount() == 0) {
        localc.ic.setPadding(0, localc.il, 0, localc.ic.getPaddingBottom());
      }
    }
    t.b(localc.ie, paramab);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.qj.ig.ir;
  }
  
  public int getHeaderCount()
  {
    return this.qj.ie.getChildCount();
  }
  
  public Drawable getItemBackground()
  {
    return this.qj.hE;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.qj.ij;
  }
  
  public int getItemIconPadding()
  {
    return this.qj.ik;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.qj.hX;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.qj.ii;
  }
  
  public Menu getMenu()
  {
    return this.qi;
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
    super.onRestoreInstanceState(paramParcelable.Mm);
    this.qi.dispatchRestoreInstanceState(paramParcelable.qm);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.qm = new Bundle();
    this.qi.e(localSavedState.qm);
    return localSavedState;
  }
  
  public void setCheckedItem(int paramInt)
  {
    MenuItem localMenuItem = this.qi.findItem(paramInt);
    if (localMenuItem != null) {
      this.qj.d((j)localMenuItem);
    }
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    paramMenuItem = this.qi.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.qj.d((j)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.qj.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(android.support.v4.content.b.l(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.qj.setItemHorizontalPadding(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    this.qj.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.qj.setItemIconPadding(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.qj.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.qj.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.qj.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.qj.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(a parama)
  {
    this.qk = parama;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    public Bundle qm;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.qm = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.qm);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean bE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.NavigationView
 * JD-Core Version:    0.7.0.1
 */