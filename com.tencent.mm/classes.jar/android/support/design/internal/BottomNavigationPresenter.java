package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.transition.s;
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
  private h kE;
  public BottomNavigationMenuView kG;
  public boolean kH = false;
  
  public final void a(Context paramContext, h paramh)
  {
    this.kE = paramh;
    this.kG.kE = this.kE;
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
  
  public final boolean bF()
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
      localBottomNavigationMenuView = this.kG;
      j = ((SavedState)paramParcelable).ks;
      k = localBottomNavigationMenuView.kE.size();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.kE.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.ks = j;
          localBottomNavigationMenuView.kt = i;
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
    localSavedState.ks = this.kG.getSelectedItemId();
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.kH) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.kG.bE();
        return;
      }
      BottomNavigationMenuView localBottomNavigationMenuView = this.kG;
      if ((localBottomNavigationMenuView.kE != null) && (localBottomNavigationMenuView.kr != null))
      {
        int j = localBottomNavigationMenuView.kE.size();
        if (j != localBottomNavigationMenuView.kr.length)
        {
          localBottomNavigationMenuView.bE();
          return;
        }
        int k = localBottomNavigationMenuView.ks;
        int i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = localBottomNavigationMenuView.kE.getItem(i);
          if (localMenuItem.isChecked())
          {
            localBottomNavigationMenuView.ks = localMenuItem.getItemId();
            localBottomNavigationMenuView.kt = i;
          }
          i += 1;
        }
        if (k != localBottomNavigationMenuView.ks) {
          s.a(localBottomNavigationMenuView, localBottomNavigationMenuView.ki);
        }
        paramBoolean = BottomNavigationMenuView.m(localBottomNavigationMenuView.ka, localBottomNavigationMenuView.kE.jdMethod_if().size());
        i = 0;
        while (i < j)
        {
          localBottomNavigationMenuView.kD.kH = true;
          localBottomNavigationMenuView.kr[i].setLabelVisibilityMode(localBottomNavigationMenuView.ka);
          localBottomNavigationMenuView.kr[i].setShifting(paramBoolean);
          localBottomNavigationMenuView.kr[i].a((j)localBottomNavigationMenuView.kE.getItem(i));
          localBottomNavigationMenuView.kD.kH = false;
          i += 1;
        }
      }
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int ks;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.ks = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.ks);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */