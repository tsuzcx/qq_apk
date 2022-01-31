package com.tencent.mm.plugin.appbrand.app;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.e;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$BatchSyncWxaAttr;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class f$a
  implements i<Parcel, IPCVoid>
{
  private static IPCVoid g(Parcel paramParcel)
  {
    AppMethodBeat.i(134455);
    if (paramParcel != null) {}
    try
    {
      paramParcel = paramParcel.createStringArrayList();
      if (paramParcel != null) {
        ((e)g.E(e.class)).av((List)paramParcel);
      }
    }
    catch (Exception paramParcel)
    {
      label35:
      break label35;
    }
    paramParcel = IPCVoid.eER;
    j.p(paramParcel, "IPCVoid.VOID");
    AppMethodBeat.o(134455);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.f.a
 * JD-Core Version:    0.7.0.1
 */