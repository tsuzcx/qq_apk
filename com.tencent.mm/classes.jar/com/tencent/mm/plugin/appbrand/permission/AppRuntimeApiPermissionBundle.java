package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.protocal.protobuf.vg;
import java.util.LinkedList;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR;
  public final byte[] lIA;
  final byte[] lIB;
  public final byte[] lIz;
  
  static
  {
    AppMethodBeat.i(147639);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147639);
  }
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(147638);
    this.lIz = paramParcel.createByteArray();
    this.lIA = paramParcel.createByteArray();
    this.lIB = paramParcel.createByteArray();
    AppMethodBeat.o(147638);
  }
  
  public AppRuntimeApiPermissionBundle(vg paramvg)
  {
    AppMethodBeat.i(147635);
    this.lIz = paramvg.Epw.xy;
    this.lIA = ((b)paramvg.Epx.get(0)).xy;
    this.lIB = ((b)paramvg.Epx.get(1)).xy;
    AppMethodBeat.o(147635);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147636);
    String str = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.lIz.length), Integer.valueOf(this.lIA.length), Integer.valueOf(this.lIB.length) });
    AppMethodBeat.o(147636);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147637);
    paramParcel.writeByteArray(this.lIz);
    paramParcel.writeByteArray(this.lIA);
    paramParcel.writeByteArray(this.lIB);
    AppMethodBeat.o(147637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */