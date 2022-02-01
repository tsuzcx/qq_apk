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
  int hK;
  boolean hU;
  Bundle hZ;
  
  static
  {
    AppMethodBeat.i(200468);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(200468);
  }
  
  static SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    boolean bool = true;
    AppMethodBeat.i(200459);
    SavedState localSavedState = new SavedState();
    localSavedState.hK = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localSavedState.hU = bool;
      if (localSavedState.hU) {
        localSavedState.hZ = paramParcel.readBundle(paramClassLoader);
      }
      AppMethodBeat.o(200459);
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
    AppMethodBeat.i(200489);
    paramParcel.writeInt(this.hK);
    if (this.hU) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.hU) {
        paramParcel.writeBundle(this.hZ);
      }
      AppMethodBeat.o(200489);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0.1
 */