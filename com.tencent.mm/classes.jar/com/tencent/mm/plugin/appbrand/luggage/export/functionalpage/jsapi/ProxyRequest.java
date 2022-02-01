package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "functionHash", "", "(I)V", "getFunctionHash", "()I", "setFunctionHash", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  int nbK;
  
  static
  {
    AppMethodBeat.i(228928);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228928);
  }
  
  public ProxyRequest(int paramInt)
  {
    this.nbK = paramInt;
  }
  
  public final Class<m> bCJ()
  {
    return m.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228927);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.nbK);
    AppMethodBeat.o(228927);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */