package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "functionHash", "", "(I)V", "getFunctionHash", "()I", "setFunctionHash", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  int lPB;
  
  static
  {
    AppMethodBeat.i(189445);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(189445);
  }
  
  public ProxyRequest(int paramInt)
  {
    this.lPB = paramInt;
  }
  
  public final Class<l> bgN()
  {
    return l.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(189444);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.lPB);
    AppMethodBeat.o(189444);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */