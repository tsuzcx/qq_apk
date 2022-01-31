package android.support.design.internal;

import android.content.Context;
import android.os.Parcelable;
import android.support.transition.af;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.view.MenuItem;

public final class BottomNavigationPresenter
  implements o
{
  private h dm;
  public BottomNavigationMenuView jdField_do;
  public boolean dp = false;
  public int mId;
  
  public final boolean V()
  {
    return false;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    this.jdField_do.dm = this.dm;
    this.dm = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final void a(o.a parama) {}
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.dp) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_do.U();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.jdField_do;
      int j = localBottomNavigationMenuView.dm.size();
      if (j != localBottomNavigationMenuView.dd.length)
      {
        localBottomNavigationMenuView.U();
        return;
      }
      int k = localBottomNavigationMenuView.de;
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = localBottomNavigationMenuView.dm.getItem(i);
        if (localMenuItem.isChecked())
        {
          localBottomNavigationMenuView.de = localMenuItem.getItemId();
          localBottomNavigationMenuView.dg = i;
        }
        i += 1;
      }
      if (k != localBottomNavigationMenuView.de) {
        af.a(localBottomNavigationMenuView, localBottomNavigationMenuView.cX);
      }
      i = 0;
      while (i < j)
      {
        localBottomNavigationMenuView.dl.dp = true;
        localBottomNavigationMenuView.dd[i].a((j)localBottomNavigationMenuView.dm.getItem(i));
        localBottomNavigationMenuView.dl.dp = false;
        i += 1;
      }
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    BottomNavigationMenuView localBottomNavigationMenuView;
    int j;
    int k;
    int i;
    if ((paramParcelable instanceof BottomNavigationPresenter.SavedState))
    {
      localBottomNavigationMenuView = this.jdField_do;
      j = ((BottomNavigationPresenter.SavedState)paramParcelable).dq;
      k = localBottomNavigationMenuView.dm.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.dm.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.de = j;
          localBottomNavigationMenuView.dg = i;
          paramParcelable.setChecked(true);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    BottomNavigationPresenter.SavedState localSavedState = new BottomNavigationPresenter.SavedState();
    localSavedState.dq = this.jdField_do.getSelectedItemId();
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */