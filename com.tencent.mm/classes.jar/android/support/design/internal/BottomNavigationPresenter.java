package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.transition.r;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.view.MenuItem;
import java.util.ArrayList;

public final class BottomNavigationPresenter
  implements o
{
  private h hI;
  public BottomNavigationMenuView hK;
  public boolean hL = false;
  public int id;
  
  public final void a(Context paramContext, h paramh)
  {
    this.hI = paramh;
    this.hK.hI = this.hI;
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
  
  public final boolean bh()
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    BottomNavigationMenuView localBottomNavigationMenuView;
    int j;
    int k;
    int i;
    if ((paramParcelable instanceof SavedState))
    {
      localBottomNavigationMenuView = this.hK;
      j = ((SavedState)paramParcelable).hw;
      k = localBottomNavigationMenuView.hI.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.hI.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.hw = j;
          localBottomNavigationMenuView.hx = i;
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
    SavedState localSavedState = new SavedState();
    localSavedState.hw = this.hK.getSelectedItemId();
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.hL) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.hK.bg();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.hK;
      if ((localBottomNavigationMenuView.hI != null) && (localBottomNavigationMenuView.hv != null))
      {
        int j = localBottomNavigationMenuView.hI.size();
        if (j != localBottomNavigationMenuView.hv.length)
        {
          localBottomNavigationMenuView.bg();
          return;
        }
        int k = localBottomNavigationMenuView.hw;
        int i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = localBottomNavigationMenuView.hI.getItem(i);
          if (localMenuItem.isChecked())
          {
            localBottomNavigationMenuView.hw = localMenuItem.getItemId();
            localBottomNavigationMenuView.hx = i;
          }
          i += 1;
        }
        if (k != localBottomNavigationMenuView.hw) {
          r.a(localBottomNavigationMenuView, localBottomNavigationMenuView.hm);
        }
        paramBoolean = BottomNavigationMenuView.f(localBottomNavigationMenuView.he, localBottomNavigationMenuView.hI.hx().size());
        i = 0;
        while (i < j)
        {
          localBottomNavigationMenuView.hH.hL = true;
          localBottomNavigationMenuView.hv[i].setLabelVisibilityMode(localBottomNavigationMenuView.he);
          localBottomNavigationMenuView.hv[i].setShifting(paramBoolean);
          localBottomNavigationMenuView.hv[i].a((j)localBottomNavigationMenuView.hI.getItem(i));
          localBottomNavigationMenuView.hH.hL = false;
          i += 1;
        }
      }
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int hw;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.hw = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.hw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */