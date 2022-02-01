package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

class AppCompatDelegateImpl$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
  boolean Tz;
  int Xs;
  Bundle rm;
  
  static SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    boolean bool = true;
    SavedState localSavedState = new SavedState();
    localSavedState.Xs = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localSavedState.Tz = bool;
      if (localSavedState.Tz) {
        localSavedState.rm = paramParcel.readBundle(paramClassLoader);
      }
      return localSavedState;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Xs);
    if (this.Tz) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.Tz) {
        paramParcel.writeBundle(this.rm);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImpl.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0.1
 */