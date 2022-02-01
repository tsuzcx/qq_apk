package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.MenuItem;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.u;
import androidx.transition.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class BottomNavigationPresenter
  implements o
{
  BottomNavigationMenuView bxj;
  boolean bxk = false;
  private h gU;
  int id;
  
  public final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(235206);
    if (this.bxk)
    {
      AppMethodBeat.o(235206);
      return;
    }
    if (paramBoolean)
    {
      this.bxj.wl();
      AppMethodBeat.o(235206);
      return;
    }
    BottomNavigationMenuView localBottomNavigationMenuView = this.bxj;
    if ((localBottomNavigationMenuView.gU == null) || (localBottomNavigationMenuView.bwY == null))
    {
      AppMethodBeat.o(235206);
      return;
    }
    int j = localBottomNavigationMenuView.gU.size();
    if (j != localBottomNavigationMenuView.bwY.length)
    {
      localBottomNavigationMenuView.wl();
      AppMethodBeat.o(235206);
      return;
    }
    int k = localBottomNavigationMenuView.bwZ;
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = localBottomNavigationMenuView.gU.getItem(i);
      if (localMenuItem.isChecked())
      {
        localBottomNavigationMenuView.bwZ = localMenuItem.getItemId();
        localBottomNavigationMenuView.bxa = i;
      }
      i += 1;
    }
    if (k != localBottomNavigationMenuView.bwZ) {
      t.a(localBottomNavigationMenuView, localBottomNavigationMenuView.bwP);
    }
    paramBoolean = BottomNavigationMenuView.bz(localBottomNavigationMenuView.labelVisibilityMode, localBottomNavigationMenuView.gU.ci().size());
    i = 0;
    while (i < j)
    {
      localBottomNavigationMenuView.bxh.bxk = true;
      localBottomNavigationMenuView.bwY[i].setLabelVisibilityMode(localBottomNavigationMenuView.labelVisibilityMode);
      localBottomNavigationMenuView.bwY[i].setShifting(paramBoolean);
      localBottomNavigationMenuView.bwY[i].a((j)localBottomNavigationMenuView.gU.getItem(i));
      localBottomNavigationMenuView.bxh.bxk = false;
      i += 1;
    }
    AppMethodBeat.o(235206);
  }
  
  public final void a(Context paramContext, h paramh)
  {
    this.gU = paramh;
    this.bxj.gU = this.gU;
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final void b(o.a parama) {}
  
  public final boolean bS()
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean d(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(235214);
    if ((paramParcelable instanceof SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = this.bxj;
      int j = ((SavedState)paramParcelable).bwZ;
      int k = localBottomNavigationMenuView.gU.size();
      int i = 0;
      while (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.gU.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.bwZ = j;
          localBottomNavigationMenuView.bxa = i;
          paramParcelable.setChecked(true);
          AppMethodBeat.o(235214);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(235214);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(235212);
    SavedState localSavedState = new SavedState();
    localSavedState.bwZ = this.bxj.getSelectedItemId();
    AppMethodBeat.o(235212);
    return localSavedState;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int bwZ;
    
    static
    {
      AppMethodBeat.i(235198);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(235198);
    }
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(235195);
      this.bwZ = paramParcel.readInt();
      AppMethodBeat.o(235195);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235196);
      paramParcel.writeInt(this.bwZ);
      AppMethodBeat.o(235196);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */