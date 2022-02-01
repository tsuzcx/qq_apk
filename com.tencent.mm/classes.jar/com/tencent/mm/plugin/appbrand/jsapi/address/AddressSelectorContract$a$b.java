package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode$PARCELER;", "Lkotlinx/android/parcel/Parceler;", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AddressSelectorContract$a$b
{
  public static final b rBU;
  
  static
  {
    AppMethodBeat.i(326506);
    rBU = new b();
    AppMethodBeat.o(326506);
  }
  
  public static void a(AddressSelectorContract.a parama, Parcel paramParcel)
  {
    AppMethodBeat.i(326501);
    s.u(parama, "<this>");
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(parama.ordinal());
    AppMethodBeat.o(326501);
  }
  
  public static AddressSelectorContract.a n(Parcel paramParcel)
  {
    AppMethodBeat.i(326492);
    s.u(paramParcel, "parcel");
    int i = paramParcel.readInt();
    paramParcel = (AddressSelectorContract.a)k.m(AddressSelectorContract.a.values(), i);
    if (paramParcel == null)
    {
      paramParcel = AddressSelectorContract.a.rBR;
      AppMethodBeat.o(326492);
      return paramParcel;
    }
    AppMethodBeat.o(326492);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract.a.b
 * JD-Core Version:    0.7.0.1
 */