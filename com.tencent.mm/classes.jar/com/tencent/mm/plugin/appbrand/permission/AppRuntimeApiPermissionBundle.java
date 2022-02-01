package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.protocal.protobuf.xf;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  public final byte[] mhM;
  public final byte[] mhN;
  final byte[] mhO;
  
  static
  {
    AppMethodBeat.i(147639);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147639);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(147638);
    this.mhM = paramParcel.createByteArray();
    this.mhN = paramParcel.createByteArray();
    this.mhO = paramParcel.createByteArray();
    AppMethodBeat.o(147638);
  }
  
  public AppRuntimeApiPermissionBundle(xf paramxf)
  {
    AppMethodBeat.i(147635);
    this.mhM = paramxf.FWI.zr;
    this.mhN = ((b)paramxf.FWJ.get(0)).zr;
    this.mhO = ((b)paramxf.FWJ.get(1)).zr;
    AppMethodBeat.o(147635);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147636);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.mhM.length), Integer.valueOf(this.mhN.length), Integer.valueOf(this.mhO.length) });
    AppMethodBeat.o(147636);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147637);
    paramParcel.writeByteArray(this.mhM);
    paramParcel.writeByteArray(this.mhN);
    paramParcel.writeByteArray(this.mhO);
    AppMethodBeat.o(147637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */