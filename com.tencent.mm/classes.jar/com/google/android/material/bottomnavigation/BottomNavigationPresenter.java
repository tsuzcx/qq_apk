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
  BottomNavigationMenuView dqm;
  boolean dqn = false;
  private h hP;
  int id;
  
  public final void J(boolean paramBoolean)
  {
    AppMethodBeat.i(209654);
    if (this.dqn)
    {
      AppMethodBeat.o(209654);
      return;
    }
    if (paramBoolean)
    {
      this.dqm.VK();
      AppMethodBeat.o(209654);
      return;
    }
    BottomNavigationMenuView localBottomNavigationMenuView = this.dqm;
    if ((localBottomNavigationMenuView.hP == null) || (localBottomNavigationMenuView.dqb == null))
    {
      AppMethodBeat.o(209654);
      return;
    }
    int j = localBottomNavigationMenuView.hP.size();
    if (j != localBottomNavigationMenuView.dqb.length)
    {
      localBottomNavigationMenuView.VK();
      AppMethodBeat.o(209654);
      return;
    }
    int k = localBottomNavigationMenuView.dqc;
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = localBottomNavigationMenuView.hP.getItem(i);
      if (localMenuItem.isChecked())
      {
        localBottomNavigationMenuView.dqc = localMenuItem.getItemId();
        localBottomNavigationMenuView.dqd = i;
      }
      i += 1;
    }
    if (k != localBottomNavigationMenuView.dqc) {
      t.a(localBottomNavigationMenuView, localBottomNavigationMenuView.dpS);
    }
    paramBoolean = BottomNavigationMenuView.cu(localBottomNavigationMenuView.labelVisibilityMode, localBottomNavigationMenuView.hP.db().size());
    i = 0;
    while (i < j)
    {
      localBottomNavigationMenuView.dqk.dqn = true;
      localBottomNavigationMenuView.dqb[i].setLabelVisibilityMode(localBottomNavigationMenuView.labelVisibilityMode);
      localBottomNavigationMenuView.dqb[i].setShifting(paramBoolean);
      localBottomNavigationMenuView.dqb[i].a((j)localBottomNavigationMenuView.hP.getItem(i));
      localBottomNavigationMenuView.dqk.dqn = false;
      i += 1;
    }
    AppMethodBeat.o(209654);
  }
  
  public final void a(Context paramContext, h paramh)
  {
    this.hP = paramh;
    this.dqm.hP = this.hP;
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final void b(o.a parama) {}
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean cL()
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
    AppMethodBeat.i(209733);
    if ((paramParcelable instanceof SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = this.dqm;
      int j = ((SavedState)paramParcelable).dqc;
      int k = localBottomNavigationMenuView.hP.size();
      int i = 0;
      while (i < k)
      {
        paramParcelable = localBottomNavigationMenuView.hP.getItem(i);
        if (j == paramParcelable.getItemId())
        {
          localBottomNavigationMenuView.dqc = j;
          localBottomNavigationMenuView.dqd = i;
          paramParcelable.setChecked(true);
          AppMethodBeat.o(209733);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209733);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(209717);
    SavedState localSavedState = new SavedState();
    localSavedState.dqc = this.dqm.getSelectedItemId();
    AppMethodBeat.o(209717);
    return localSavedState;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int dqc;
    
    static
    {
      AppMethodBeat.i(209624);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(209624);
    }
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(209618);
      this.dqc = paramParcel.readInt();
      AppMethodBeat.o(209618);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209639);
      paramParcel.writeInt(this.dqc);
      AppMethodBeat.o(209639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */