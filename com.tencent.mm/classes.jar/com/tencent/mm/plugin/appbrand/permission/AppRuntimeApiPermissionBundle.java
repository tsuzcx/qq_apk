package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.protobuf.ys;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  public final byte[] nxk;
  public final byte[] nxl;
  final byte[] nxm;
  
  static
  {
    AppMethodBeat.i(147639);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147639);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(147638);
    this.nxk = paramParcel.createByteArray();
    this.nxl = paramParcel.createByteArray();
    this.nxm = paramParcel.createByteArray();
    AppMethodBeat.o(147638);
  }
  
  public AppRuntimeApiPermissionBundle(ys paramys)
  {
    AppMethodBeat.i(147635);
    this.nxk = paramys.LjS.zy;
    this.nxl = ((b)paramys.LjT.get(0)).zy;
    this.nxm = ((b)paramys.LjT.get(1)).zy;
    AppMethodBeat.o(147635);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147636);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.nxk.length), Integer.valueOf(this.nxl.length), Integer.valueOf(this.nxm.length) });
    AppMethodBeat.o(147636);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147637);
    paramParcel.writeByteArray(this.nxk);
    paramParcel.writeByteArray(this.nxl);
    paramParcel.writeByteArray(this.nxm);
    AppMethodBeat.o(147637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */