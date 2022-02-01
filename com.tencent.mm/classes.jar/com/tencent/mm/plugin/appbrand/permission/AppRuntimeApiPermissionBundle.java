package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.protobuf.aat;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  public static AppRuntimeApiPermissionBundle tEi;
  public final byte[] tEj;
  public final byte[] tEk;
  final byte[] tEl;
  
  static
  {
    AppMethodBeat.i(147639);
    tEi = new AppRuntimeApiPermissionBundle();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147639);
  }
  
  private AppRuntimeApiPermissionBundle()
  {
    AppMethodBeat.i(318743);
    this.tEj = new byte[0];
    this.tEk = new byte[0];
    this.tEl = new byte[0];
    AppMethodBeat.o(318743);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(147638);
    this.tEj = paramParcel.createByteArray();
    this.tEk = paramParcel.createByteArray();
    this.tEl = paramParcel.createByteArray();
    AppMethodBeat.o(147638);
  }
  
  public AppRuntimeApiPermissionBundle(aat paramaat)
  {
    AppMethodBeat.i(147635);
    this.tEj = paramaat.Zjj.Op;
    this.tEk = ((b)paramaat.Zjk.get(0)).Op;
    this.tEl = ((b)paramaat.Zjk.get(1)).Op;
    AppMethodBeat.o(147635);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147636);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.tEj.length), Integer.valueOf(this.tEk.length), Integer.valueOf(this.tEl.length) });
    AppMethodBeat.o(147636);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147637);
    paramParcel.writeByteArray(this.tEj);
    paramParcel.writeByteArray(this.tEk);
    paramParcel.writeByteArray(this.tEl);
    AppMethodBeat.o(147637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */