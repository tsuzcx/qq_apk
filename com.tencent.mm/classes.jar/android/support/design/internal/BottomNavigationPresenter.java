package android.support.design.internal;

import android.content.Context;
import android.os.Parcelable;
import android.support.transition.ae;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.view.MenuItem;

public final class BottomNavigationPresenter
  implements o
{
  private h eq;
  public BottomNavigationMenuView es;
  public boolean et = false;
  public int mId;
  
  public final void a(Context paramContext, h paramh)
  {
    this.es.eq = this.eq;
    this.eq = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final void a(o.a parama) {}
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final boolean aG()
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
  
  public final void n(boolean paramBoolean)
  {
    if (this.et) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.es.aF();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.es;
      int j = localBottomNavigationMenuView.eq.size();
      if (j != localBottomNavigationMenuView.eh.length)
      {
        localBottomNavigationMenuView.aF();
        return;
      }
      int k = localBottomNavigationMenuView.ei;
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = localBottomNavigationMenuView.eq.getItem(i);
        if (localMenuItem.isChecked())
        {
          localBottomNavigationMenuView.ei = localMenuItem.getItemId();
          localBottomNavigationMenuView.ej = i;
        }
        i += 1;
      }
      if (k != localBottomNavigationMenuView.ei) {
        ae.a(localBottomNavigationMenuView, localBottomNavigationMenuView.eb);
      }
      i = 0;
      while (i < j)
      {
        localBottomNavigationMenuView.ep.et = true;
        localBottomNavigationMenuView.eh[i].a((j)localBottomNavigationMenuView.eq.getItem(i));
        localBottomNavigationMenuView.ep.et = false;
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
      localBottomNavigationMenuView = this.es;
      j = ((BottomNavigationPresenter.SavedState)paramParcelable).eu;
      k = localBottomNavigationMenuView.eq.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.eq.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.ei = j;
          localBottomNavigationMenuView.ej = i;
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
    localSavedState.eu = this.es.getSelectedItemId();
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */