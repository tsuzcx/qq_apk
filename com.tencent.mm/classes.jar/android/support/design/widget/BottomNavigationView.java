package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.a;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.t;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int[] dP = { 16842912 };
  private static final int[] gc = { -16842910 };
  private final BottomNavigationPresenter ep = new BottomNavigationPresenter();
  private final h eq;
  private final BottomNavigationMenuView es;
  private MenuInflater gd;
  private BottomNavigationView.b ge;
  private BottomNavigationView.a gf;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.F(paramContext);
    this.eq = new android.support.design.internal.a(paramContext);
    this.es = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.es.setLayoutParams(localLayoutParams);
    this.ep.es = this.es;
    this.ep.mId = 1;
    this.es.setPresenter(this.ep);
    this.eq.a(this.ep);
    this.ep.a(getContext(), this.eq);
    paramAttributeSet = az.a(paramContext, paramAttributeSet, a.a.BottomNavigationView, paramInt, 2131493835);
    if (paramAttributeSet.hasValue(2))
    {
      this.es.setIconTintList(paramAttributeSet.getColorStateList(2));
      if (!paramAttributeSet.hasValue(3)) {
        break label368;
      }
      this.es.setItemTextColor(paramAttributeSet.getColorStateList(3));
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(0)) {
        t.i(this, paramAttributeSet.getDimensionPixelSize(0, 0));
      }
      paramInt = paramAttributeSet.getResourceId(4, 0);
      this.es.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(1))
      {
        paramInt = paramAttributeSet.getResourceId(1, 0);
        this.ep.et = true;
        getMenuInflater().inflate(paramInt, this.eq);
        this.ep.et = false;
        this.ep.n(true);
      }
      paramAttributeSet.aoo.recycle();
      addView(this.es, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(b.m(paramContext, 2131689930));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131428285)));
        addView(paramAttributeSet);
      }
      this.eq.a(new BottomNavigationView.1(this));
      return;
      this.es.setIconTintList(aW());
      break;
      label368:
      this.es.setItemTextColor(aW());
    }
  }
  
  private ColorStateList aW()
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = android.support.v7.c.a.a.l(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130772206, (TypedValue)localObject, true));
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = gc;
    int[] arrayOfInt1 = dP;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(gc, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.gd == null) {
      this.gd = new g(getContext());
    }
    return this.gd;
  }
  
  public int getItemBackgroundResource()
  {
    return this.es.getItemBackgroundRes();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.es.getIconTintList();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.es.getItemTextColor();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.eq;
  }
  
  public int getSelectedItemId()
  {
    return this.es.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof BottomNavigationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (BottomNavigationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Fo);
    this.eq.dispatchRestoreInstanceState(paramParcelable.gh);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BottomNavigationView.SavedState localSavedState = new BottomNavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.gh = new Bundle();
    this.eq.c(localSavedState.gh);
    return localSavedState;
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.es.setItemBackgroundRes(paramInt);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.es.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.es.setItemTextColor(paramColorStateList);
  }
  
  public void setOnNavigationItemReselectedListener(BottomNavigationView.a parama)
  {
    this.gf = parama;
  }
  
  public void setOnNavigationItemSelectedListener(BottomNavigationView.b paramb)
  {
    this.ge = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.eq.findItem(paramInt);
    if ((localMenuItem != null) && (!this.eq.a(localMenuItem, this.ep, 0))) {
      localMenuItem.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */