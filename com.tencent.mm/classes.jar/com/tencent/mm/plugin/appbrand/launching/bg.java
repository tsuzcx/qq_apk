package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/UpdateStateParceler;", "Lkotlinx/android/parcel/Parceler;", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
{
  public static final bg tcy;
  
  static
  {
    AppMethodBeat.i(320996);
    tcy = new bg();
    AppMethodBeat.o(320996);
  }
  
  public static void a(c paramc, Parcel paramParcel)
  {
    AppMethodBeat.i(320989);
    s.u(paramc, "<this>");
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(paramc.ordinal());
    AppMethodBeat.o(320989);
  }
  
  public static c p(Parcel paramParcel)
  {
    AppMethodBeat.i(320981);
    s.u(paramParcel, "parcel");
    int i = paramParcel.readInt();
    paramParcel = (c)k.m(c.values(), i);
    if (paramParcel == null)
    {
      paramParcel = c.syZ;
      AppMethodBeat.o(320981);
      return paramParcel;
    }
    AppMethodBeat.o(320981);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bg
 * JD-Core Version:    0.7.0.1
 */