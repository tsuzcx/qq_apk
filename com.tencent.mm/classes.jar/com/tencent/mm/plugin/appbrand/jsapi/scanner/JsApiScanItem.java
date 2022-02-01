package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiScanItem
  extends d<c>
{
  private static final int CTRL_INDEX = 869;
  private static final String NAME = "scanItem";
  public static final a mpQ;
  private String data = "";
  private c liR;
  private int lqe;
  
  static
  {
    AppMethodBeat.i(228517);
    mpQ = new a((byte)0);
    NAME = "scanItem";
    CTRL_INDEX = 869;
    AppMethodBeat.o(228517);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class CheckScanItemTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckScanItemTask> CREATOR;
    public static final a mpS;
    private int errCode;
    private String errMsg;
    private JsApiScanItem mpR;
    
    static
    {
      AppMethodBeat.i(228514);
      mpS = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(228514);
    }
    
    public CheckScanItemTask(Parcel paramParcel)
    {
      AppMethodBeat.i(228513);
      this.errMsg = "";
      f(paramParcel);
      AppMethodBeat.o(228513);
    }
    
    public CheckScanItemTask(JsApiScanItem paramJsApiScanItem)
    {
      this.errMsg = "";
      this.mpR = paramJsApiScanItem;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(228508);
      Context localContext = MMApplicationContext.getContext();
      if ((a.o(localContext, false)) || (e.bgF()) || (a.r(localContext, false)))
      {
        Log.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
        this.errCode = 1001;
      }
      for (this.errMsg = "camera is using";; this.errMsg = "ok")
      {
        bDU();
        AppMethodBeat.o(228508);
        return;
        this.errCode = 0;
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(228509);
      super.bjk();
      bDK();
      JsApiScanItem localJsApiScanItem = this.mpR;
      if (localJsApiScanItem != null)
      {
        JsApiScanItem.a(localJsApiScanItem, this.errCode, this.errMsg);
        AppMethodBeat.o(228509);
        return;
      }
      AppMethodBeat.o(228509);
    }
    
    public final int describeContents()
    {
      AppMethodBeat.i(228510);
      int i = super.describeContents();
      AppMethodBeat.o(228510);
      return i;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(228512);
      p.h(paramParcel, "in");
      this.errCode = paramParcel.readInt();
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.errMsg = paramParcel;
      AppMethodBeat.o(228512);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(228511);
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(228511);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<JsApiScanItem.CheckScanItemTask>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "ErrCode", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResult"})
  static final class b
    implements f.c
  {
    b(JsApiScanItem paramJsApiScanItem, c paramc, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(228515);
      if (paramInt1 != (this.mpT.hashCode() & 0xFFFF))
      {
        AppMethodBeat.o(228515);
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
          this.mpU.i(this.lyo, this.mpT.Zf("fail"));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(228515);
        return true;
        bool = false;
        break;
        if (paramIntent != null)
        {
          HashMap localHashMap = new HashMap();
          paramIntent = paramIntent.getStringExtra("key_scan_goods_result_req_key");
          Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", new Object[] { paramIntent });
          Map localMap = (Map)localHashMap;
          p.g(paramIntent, "reqKey");
          localMap.put("reqKey", paramIntent);
          this.mpU.i(this.lyo, this.mpT.n("ok", (Map)localHashMap));
        }
        else
        {
          this.mpU.i(this.lyo, this.mpT.Zf("fail"));
          continue;
          this.mpU.i(this.lyo, this.mpT.Zf("cancel"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanItem
 * JD-Core Version:    0.7.0.1
 */