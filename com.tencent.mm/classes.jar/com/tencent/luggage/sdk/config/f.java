package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/WindowOpacityParceler;", "Lkotlinx/android/parcel/Parceler;", "Lcom/tencent/mm/plugin/appbrand/config/WindowOpacity;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f eqr;
  
  static
  {
    AppMethodBeat.i(220253);
    eqr = new f();
    AppMethodBeat.o(220253);
  }
  
  public static void a(z paramz, Parcel paramParcel)
  {
    AppMethodBeat.i(220251);
    s.u(paramParcel, "parcel");
    z.b(paramz, paramParcel);
    AppMethodBeat.o(220251);
  }
  
  public static z b(Parcel paramParcel)
  {
    AppMethodBeat.i(220247);
    s.u(paramParcel, "parcel");
    paramParcel = z.m(paramParcel);
    AppMethodBeat.o(220247);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.f
 * JD-Core Version:    0.7.0.1
 */