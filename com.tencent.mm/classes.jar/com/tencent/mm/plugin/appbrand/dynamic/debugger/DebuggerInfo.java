package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DebuggerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DebuggerInfo> CREATOR;
  public boolean kjt;
  public boolean kju;
  public boolean kjv;
  
  static
  {
    AppMethodBeat.i(121284);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(121284);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(121283);
    if (this.kjt)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.kju) {
        break label60;
      }
      paramInt = 1;
      label30:
      paramParcel.writeInt(paramInt);
      if (!this.kjv) {
        break label65;
      }
    }
    label60:
    label65:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(121283);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo
 * JD-Core Version:    0.7.0.1
 */