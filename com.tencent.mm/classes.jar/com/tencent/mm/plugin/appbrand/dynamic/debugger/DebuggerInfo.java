package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DebuggerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DebuggerInfo> CREATOR;
  public boolean hox;
  public boolean hoy;
  public boolean hoz;
  
  static
  {
    AppMethodBeat.i(10802);
    CREATOR = new DebuggerInfo.1();
    AppMethodBeat.o(10802);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(10801);
    if (this.hox)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.hoy) {
        break label62;
      }
      paramInt = 1;
      label31:
      paramParcel.writeInt(paramInt);
      if (!this.hoz) {
        break label67;
      }
    }
    label62:
    label67:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(10801);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo
 * JD-Core Version:    0.7.0.1
 */