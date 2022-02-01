package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetRuntimeConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetRuntimeConfig> CREATOR;
  public String appId;
  public int rmS;
  public int rnj = 32;
  public boolean rnk = false;
  public boolean rnl = true;
  
  static
  {
    AppMethodBeat.i(121412);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(121412);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(121411);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.rmS);
    paramParcel.writeInt(this.rnj);
    if (this.rnk)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.rnl) {
        break label70;
      }
    }
    label70:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(121411);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig
 * JD-Core Version:    0.7.0.1
 */