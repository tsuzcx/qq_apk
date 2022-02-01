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
  public int id;
  private h kC;
  public BottomNavigationMenuView kE;
  public boolean kF = false;
  
  public final void a(Context paramContext, h paramh)
  {
    this.kC = paramh;
    this.kE.kC = this.kC;
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
  
  public final boolean bD()
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
      localBottomNavigationMenuView = this.kE;
      j = ((SavedState)paramParcelable).kq;
      k = localBottomNavigationMenuView.kC.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.kC.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.kq = j;
          localBottomNavigationMenuView.kr = i;
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
    localSavedState.kq = this.kE.getSelectedItemId();
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.kF) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.kE.bC();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.kE;
      if ((localBottomNavigationMenuView.kC != null) && (localBottomNavigationMenuView.kp != null))
      {
        int j = localBottomNavigationMenuView.kC.size();
        if (j != localBottomNavigationMenuView.kp.length)
        {
          localBottomNavigationMenuView.bC();
          return;
        }
        int k = localBottomNavigationMenuView.kq;
        int i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = localBottomNavigationMenuView.kC.getItem(i);
          if (localMenuItem.isChecked())
          {
            localBottomNavigationMenuView.kq = localMenuItem.getItemId();
            localBottomNavigationMenuView.kr = i;
          }
          i += 1;
        }
        if (k != localBottomNavigationMenuView.kq) {
          r.a(localBottomNavigationMenuView, localBottomNavigationMenuView.kg);
        }
        paramBoolean = BottomNavigationMenuView.m(localBottomNavigationMenuView.jY, localBottomNavigationMenuView.kC.hV().size());
        i = 0;
        while (i < j)
        {
          localBottomNavigationMenuView.kB.kF = true;
          localBottomNavigationMenuView.kp[i].setLabelVisibilityMode(localBottomNavigationMenuView.jY);
          localBottomNavigationMenuView.kp[i].setShifting(paramBoolean);
          localBottomNavigationMenuView.kp[i].a((j)localBottomNavigationMenuView.kC.getItem(i));
          localBottomNavigationMenuView.kB.kF = false;
          i += 1;
        }
      }
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int kq;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.kq = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.kq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */