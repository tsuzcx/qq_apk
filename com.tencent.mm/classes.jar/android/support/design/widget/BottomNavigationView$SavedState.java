package android.support.design.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

class BottomNavigationView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new BottomNavigationView.SavedState.1();
  Bundle fi;
  
  public BottomNavigationView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.fi = paramParcel.readBundle(paramClassLoader);
  }
  
  public BottomNavigationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(this.fi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView.SavedState
 * JD-Core Version:    0.7.0.1
 */