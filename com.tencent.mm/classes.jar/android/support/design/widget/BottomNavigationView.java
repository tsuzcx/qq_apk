package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.c;
import android.support.design.a.d;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ax;
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
  private static final int[] cL = { 16842912 };
  private static final int[] fd = { -16842910 };
  private final BottomNavigationPresenter dl = new BottomNavigationPresenter();
  private final h dm;
  private final BottomNavigationMenuView jdField_do;
  private MenuInflater fe;
  private BottomNavigationView.b ff;
  private BottomNavigationView.a fg;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o.G(paramContext);
    this.dm = new a(paramContext);
    this.jdField_do = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.jdField_do.setLayoutParams(localLayoutParams);
    this.dl.jdField_do = this.jdField_do;
    this.dl.mId = 1;
    this.jdField_do.setPresenter(this.dl);
    this.dm.a(this.dl);
    this.dl.a(getContext(), this.dm);
    paramAttributeSet = ax.a(paramContext, paramAttributeSet, a.k.BottomNavigationView, paramInt, a.j.Widget_Design_BottomNavigationView);
    if (paramAttributeSet.hasValue(a.k.BottomNavigationView_itemIconTint))
    {
      this.jdField_do.setIconTintList(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemIconTint));
      if (!paramAttributeSet.hasValue(a.k.BottomNavigationView_itemTextColor)) {
        break label389;
      }
      this.jdField_do.setItemTextColor(paramAttributeSet.getColorStateList(a.k.BottomNavigationView_itemTextColor));
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(a.k.BottomNavigationView_elevation)) {
        q.h(this, paramAttributeSet.getDimensionPixelSize(a.k.BottomNavigationView_elevation, 0));
      }
      paramInt = paramAttributeSet.getResourceId(a.k.BottomNavigationView_itemBackground, 0);
      this.jdField_do.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(a.k.BottomNavigationView_menu))
      {
        paramInt = paramAttributeSet.getResourceId(a.k.BottomNavigationView_menu, 0);
        this.dl.dp = true;
        getMenuInflater().inflate(paramInt, this.dm);
        this.dl.dp = false;
        this.dl.o(true);
      }
      paramAttributeSet.alZ.recycle();
      addView(this.jdField_do, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(android.support.v4.content.b.i(paramContext, a.c.design_bottom_navigation_shadow_color));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_shadow_height)));
        addView(paramAttributeSet);
      }
      this.dm.a(new BottomNavigationView.1(this));
      return;
      this.jdField_do.setIconTintList(as());
      break;
      label389:
      this.jdField_do.setItemTextColor(as());
    }
  }
  
  private ColorStateList as()
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = android.support.v7.c.a.b.h(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true));
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = fd;
    int[] arrayOfInt1 = cL;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(fd, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.fe == null) {
      this.fe = new g(getContext());
    }
    return this.fe;
  }
  
  public int getItemBackgroundResource()
  {
    return this.jdField_do.getItemBackgroundRes();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.jdField_do.getIconTintList();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.jdField_do.getItemTextColor();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.dm;
  }
  
  public int getSelectedItemId()
  {
    return this.jdField_do.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof BottomNavigationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (BottomNavigationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.EA);
    this.dm.d(paramParcelable.fi);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BottomNavigationView.SavedState localSavedState = new BottomNavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.fi = new Bundle();
    this.dm.c(localSavedState.fi);
    return localSavedState;
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.jdField_do.setItemBackgroundRes(paramInt);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.jdField_do.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.jdField_do.setItemTextColor(paramColorStateList);
  }
  
  public void setOnNavigationItemReselectedListener(BottomNavigationView.a parama)
  {
    this.fg = parama;
  }
  
  public void setOnNavigationItemSelectedListener(BottomNavigationView.b paramb)
  {
    this.ff = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.dm.findItem(paramInt);
    if ((localMenuItem != null) && (!this.dm.a(localMenuItem, this.dl, 0))) {
      localMenuItem.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */