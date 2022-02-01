package com.tencent.mm.plugin.appbrand.permission.appidABTest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.l;

public class AppRuntimeAppidABTestPermissionBundle
  implements Parcelable, l
{
  public static final Parcelable.Creator<AppRuntimeAppidABTestPermissionBundle> CREATOR;
  public final byte[] qAa;
  
  static
  {
    AppMethodBeat.i(243177);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(243177);
  }
  
  protected AppRuntimeAppidABTestPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(243175);
    this.qAa = paramParcel.createByteArray();
    AppMethodBeat.o(243175);
  }
  
  public AppRuntimeAppidABTestPermissionBundle(byte[] paramArrayOfByte)
  {
    this.qAa = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(243176);
    paramParcel.writeByteArray(this.qAa);
    AppMethodBeat.o(243176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle
 * JD-Core Version:    0.7.0.1
 */