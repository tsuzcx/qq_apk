package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.protocal.protobuf.uw;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  public final byte[] liH;
  public final byte[] liI;
  final byte[] liJ;
  
  static
  {
    AppMethodBeat.i(147639);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147639);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(147638);
    this.liH = paramParcel.createByteArray();
    this.liI = paramParcel.createByteArray();
    this.liJ = paramParcel.createByteArray();
    AppMethodBeat.o(147638);
  }
  
  public AppRuntimeApiPermissionBundle(uw paramuw)
  {
    AppMethodBeat.i(147635);
    this.liH = paramuw.CWN.wA;
    this.liI = ((b)paramuw.CWO.get(0)).wA;
    this.liJ = ((b)paramuw.CWO.get(1)).wA;
    AppMethodBeat.o(147635);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147636);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.liH.length), Integer.valueOf(this.liI.length), Integer.valueOf(this.liJ.length) });
    AppMethodBeat.o(147636);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147637);
    paramParcel.writeByteArray(this.liH);
    paramParcel.writeByteArray(this.liI);
    paramParcel.writeByteArray(this.liJ);
    AppMethodBeat.o(147637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */