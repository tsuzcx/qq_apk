package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiScanItem
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 869;
  private static final String NAME = "scanItem";
  public static final a pnW;
  private String data = "";
  private com.tencent.mm.plugin.appbrand.service.c odA;
  private int okO;
  
  static
  {
    AppMethodBeat.i(273188);
    pnW = new a((byte)0);
    NAME = "scanItem";
    CTRL_INDEX = 869;
    AppMethodBeat.o(273188);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class CheckScanItemTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckScanItemTask> CREATOR;
    public static final a pnY;
    private int errCode;
    private String errMsg;
    private JsApiScanItem pnX;
    
    static
    {
      AppMethodBeat.i(270946);
      pnY = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(270946);
    }
    
    public CheckScanItemTask(Parcel paramParcel)
    {
      AppMethodBeat.i(270945);
      this.errMsg = "";
      f(paramParcel);
      AppMethodBeat.o(270945);
    }
    
    public CheckScanItemTask(JsApiScanItem paramJsApiScanItem)
    {
      this.errMsg = "";
      this.pnX = paramJsApiScanItem;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(270940);
      Context localContext = MMApplicationContext.getContext();
      if ((a.p(localContext, false)) || (e.bpU()) || (a.t(localContext, false)))
      {
        Log.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
        this.errCode = 1001;
      }
      for (this.errMsg = "camera is using";; this.errMsg = "ok")
      {
        bPt();
        AppMethodBeat.o(270940);
        return;
        this.errCode = 0;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(270941);
      super.bsK();
      bPk();
      JsApiScanItem localJsApiScanItem = this.pnX;
      if (localJsApiScanItem != null)
      {
        JsApiScanItem.a(localJsApiScanItem, this.errCode, this.errMsg);
        AppMethodBeat.o(270941);
        return;
      }
      AppMethodBeat.o(270941);
    }
    
    public final int describeContents()
    {
      AppMethodBeat.i(270942);
      int i = super.describeContents();
      AppMethodBeat.o(270942);
      return i;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(270944);
      p.k(paramParcel, "in");
      this.errCode = paramParcel.readInt();
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.errMsg = paramParcel;
      AppMethodBeat.o(270944);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(270943);
      p.k(paramParcel, "dest");
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(270943);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<JsApiScanItem.CheckScanItemTask>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "ErrCode", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResult"})
  static final class b
    implements f.c
  {
    b(JsApiScanItem paramJsApiScanItem, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(276244);
      if (paramInt1 != (this.pnZ.hashCode() & 0xFFFF))
      {
        AppMethodBeat.o(276244);
        return false;
      }
      boolean bool;
      if (paramIntent != null)
      {
        bool = true;
        Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult requestCode: %d, resultCode: %d, data != null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        switch (paramInt2)
        {
        default: 
          this.poa.j(this.otk, this.pnZ.agS("fail"));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(276244);
        return true;
        bool = false;
        break;
        if (paramIntent != null)
        {
          HashMap localHashMap = new HashMap();
          paramIntent = paramIntent.getStringExtra("key_scan_goods_result_req_key");
          Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", new Object[] { paramIntent });
          Map localMap = (Map)localHashMap;
          p.j(paramIntent, "reqKey");
          localMap.put("reqKey", paramIntent);
          this.poa.j(this.otk, this.pnZ.m("ok", (Map)localHashMap));
        }
        else
        {
          this.poa.j(this.otk, this.pnZ.agS("fail"));
          continue;
          this.poa.j(this.otk, this.pnZ.agS("cancel"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanItem
 * JD-Core Version:    0.7.0.1
 */