package androidx.appcompat.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppCompatDelegateImpl$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  int gP;
  boolean gZ;
  Bundle he;
  
  static
  {
    AppMethodBeat.i(238178);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(238178);
  }
  
  static SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    boolean bool = true;
    AppMethodBeat.i(238177);
    SavedState localSavedState = new SavedState();
    localSavedState.gP = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localSavedState.gZ = bool;
      if (localSavedState.gZ) {
        localSavedState.he = paramParcel.readBundle(paramClassLoader);
      }
      AppMethodBeat.o(238177);
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
    AppMethodBeat.i(238176);
    paramParcel.writeInt(this.gP);
    if (this.gZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.gZ) {
        paramParcel.writeBundle(this.he);
      }
      AppMethodBeat.o(238176);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0.1
 */