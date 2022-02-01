package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.e;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiScanItem
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final JsApiScanItem.a ssJ;
  private String data = "";
  private com.tencent.mm.plugin.appbrand.service.c reu;
  private int ror;
  
  static
  {
    AppMethodBeat.i(325752);
    ssJ = new JsApiScanItem.a((byte)0);
    NAME = "scanItem";
    CTRL_INDEX = 869;
    AppMethodBeat.o(325752);
  }
  
  private static final boolean a(JsApiScanItem paramJsApiScanItem, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(325745);
    s.u(paramJsApiScanItem, "this$0");
    if (paramInt2 != (paramJsApiScanItem.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(325745);
      return false;
    }
    boolean bool;
    if (paramIntent != null)
    {
      bool = true;
      Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult requestCode: %d, resultCode: %d, data != null: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      switch (paramInt3)
      {
      default: 
        paramc.callback(paramInt1, paramJsApiScanItem.ZP("fail"));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(325745);
      return true;
      bool = false;
      break;
      if (paramIntent != null)
      {
        HashMap localHashMap = new HashMap();
        paramIntent = paramIntent.getStringExtra("key_scan_goods_result_req_key");
        Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", new Object[] { paramIntent });
        Map localMap = (Map)localHashMap;
        s.checkNotNull(paramIntent);
        localMap.put("reqKey", paramIntent);
        paramc.callback(paramInt1, paramJsApiScanItem.m("ok", (Map)localHashMap));
      }
      else
      {
        paramc.callback(paramInt1, paramJsApiScanItem.ZP("fail"));
        continue;
        paramc.callback(paramInt1, paramJsApiScanItem.ZP("cancel"));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class CheckScanItemTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckScanItemTask> CREATOR;
    public static final JsApiScanItem.CheckScanItemTask.a ssK;
    private int errCode;
    private String errMsg;
    private JsApiScanItem ssL;
    
    static
    {
      AppMethodBeat.i(325746);
      ssK = new JsApiScanItem.CheckScanItemTask.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(325746);
    }
    
    public CheckScanItemTask(Parcel paramParcel)
    {
      AppMethodBeat.i(325743);
      this.errMsg = "";
      h(paramParcel);
      AppMethodBeat.o(325743);
    }
    
    public CheckScanItemTask(JsApiScanItem paramJsApiScanItem)
    {
      this.errMsg = "";
      this.ssL = paramJsApiScanItem;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(325747);
      Context localContext = MMApplicationContext.getContext();
      if ((a.p(localContext, false)) || (e.bNA()) || (a.u(localContext, false)))
      {
        Log.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
        this.errCode = 1001;
      }
      for (this.errMsg = "camera is using";; this.errMsg = "ok")
      {
        cpA();
        AppMethodBeat.o(325747);
        return;
        this.errCode = 0;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(325750);
      super.bQr();
      cpx();
      JsApiScanItem localJsApiScanItem = this.ssL;
      if (localJsApiScanItem != null) {
        JsApiScanItem.a(localJsApiScanItem, this.errCode, this.errMsg);
      }
      AppMethodBeat.o(325750);
    }
    
    public final int describeContents()
    {
      AppMethodBeat.i(325753);
      int i = super.describeContents();
      AppMethodBeat.o(325753);
      return i;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(325760);
      s.u(paramParcel, "in");
      this.errCode = paramParcel.readInt();
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.errMsg = paramParcel;
      AppMethodBeat.o(325760);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(325756);
      s.u(paramParcel, "dest");
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(325756);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<JsApiScanItem.CheckScanItemTask>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanItem
 * JD-Core Version:    0.7.0.1
 */