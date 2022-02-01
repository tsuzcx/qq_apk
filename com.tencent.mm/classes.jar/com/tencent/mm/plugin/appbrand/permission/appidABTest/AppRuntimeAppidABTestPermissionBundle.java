package com.tencent.mm.plugin.appbrand.permission.appidABTest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;

public class AppRuntimeAppidABTestPermissionBundle
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppRuntimeAppidABTestPermissionBundle> CREATOR;
  public final byte[] tEZ;
  
  static
  {
    AppMethodBeat.i(318783);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(318783);
  }
  
  protected AppRuntimeAppidABTestPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(318778);
    this.tEZ = paramParcel.createByteArray();
    AppMethodBeat.o(318778);
  }
  
  public AppRuntimeAppidABTestPermissionBundle(byte[] paramArrayOfByte)
  {
    this.tEZ = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318789);
    paramParcel.writeByteArray(this.tEZ);
    AppMethodBeat.o(318789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle
 * JD-Core Version:    0.7.0.1
 */