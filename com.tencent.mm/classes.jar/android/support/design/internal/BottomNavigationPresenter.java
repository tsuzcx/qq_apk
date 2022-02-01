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
  private h iL;
  public BottomNavigationMenuView iN;
  public boolean iO = false;
  public int id;
  
  public final void a(Context paramContext, h paramh)
  {
    this.iL = paramh;
    this.iN.iL = this.iL;
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
  
  public final boolean bo()
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
      localBottomNavigationMenuView = this.iN;
      j = ((SavedState)paramParcelable).iz;
      k = localBottomNavigationMenuView.iL.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.iL.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.iz = j;
          localBottomNavigationMenuView.iA = i;
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
    localSavedState.iz = this.iN.getSelectedItemId();
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.iO) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.iN.bn();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.iN;
      if ((localBottomNavigationMenuView.iL != null) && (localBottomNavigationMenuView.iy != null))
      {
        int j = localBottomNavigationMenuView.iL.size();
        if (j != localBottomNavigationMenuView.iy.length)
        {
          localBottomNavigationMenuView.bn();
          return;
        }
        int k = localBottomNavigationMenuView.iz;
        int i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = localBottomNavigationMenuView.iL.getItem(i);
          if (localMenuItem.isChecked())
          {
            localBottomNavigationMenuView.iz = localMenuItem.getItemId();
            localBottomNavigationMenuView.iA = i;
          }
          i += 1;
        }
        if (k != localBottomNavigationMenuView.iz) {
          r.a(localBottomNavigationMenuView, localBottomNavigationMenuView.im);
        }
        paramBoolean = BottomNavigationMenuView.f(localBottomNavigationMenuView.ie, localBottomNavigationMenuView.iL.hF().size());
        i = 0;
        while (i < j)
        {
          localBottomNavigationMenuView.iK.iO = true;
          localBottomNavigationMenuView.iy[i].setLabelVisibilityMode(localBottomNavigationMenuView.ie);
          localBottomNavigationMenuView.iy[i].setShifting(paramBoolean);
          localBottomNavigationMenuView.iy[i].a((j)localBottomNavigationMenuView.iL.getItem(i));
          localBottomNavigationMenuView.iK.iO = false;
          i += 1;
        }
      }
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int iz;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.iz = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.iz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */