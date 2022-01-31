package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.protocal.protobuf.se;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  final byte[] iBL;
  final byte[] iBM;
  final byte[] iBN;
  
  static
  {
    AppMethodBeat.i(102278);
    CREATOR = new AppRuntimeApiPermissionBundle.1();
    AppMethodBeat.o(102278);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(102277);
    this.iBL = paramParcel.createByteArray();
    this.iBM = paramParcel.createByteArray();
    this.iBN = paramParcel.createByteArray();
    AppMethodBeat.o(102277);
  }
  
  public AppRuntimeApiPermissionBundle(se paramse)
  {
    AppMethodBeat.i(102274);
    this.iBL = paramse.wKA.toByteArray();
    this.iBM = ((b)paramse.wKB.get(0)).toByteArray();
    this.iBN = ((b)paramse.wKB.get(1)).toByteArray();
    AppMethodBeat.o(102274);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(102275);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.iBL.length), Integer.valueOf(this.iBM.length), Integer.valueOf(this.iBN.length) });
    AppMethodBeat.o(102275);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102276);
    paramParcel.writeByteArray(this.iBL);
    paramParcel.writeByteArray(this.iBM);
    paramParcel.writeByteArray(this.iBN);
    AppMethodBeat.o(102276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */