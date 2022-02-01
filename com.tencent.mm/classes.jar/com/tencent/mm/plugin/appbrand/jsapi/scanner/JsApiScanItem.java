package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiScanItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 869;
  private static final String NAME = "scanItem";
  public static final a lgw;
  private String data = "";
  private c kbR;
  private int kje;
  
  static
  {
    AppMethodBeat.i(189230);
    lgw = new a((byte)0);
    NAME = "scanItem";
    CTRL_INDEX = 869;
    AppMethodBeat.o(189230);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class CheckScanItemTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckScanItemTask> CREATOR;
    public static final a lgy;
    private int errCode;
    private String errMsg;
    private JsApiScanItem lgx;
    
    static
    {
      AppMethodBeat.i(189227);
      lgy = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(189227);
    }
    
    public CheckScanItemTask(Parcel paramParcel)
    {
      AppMethodBeat.i(189226);
      this.errMsg = "";
      e(paramParcel);
      AppMethodBeat.o(189226);
    }
    
    public CheckScanItemTask(JsApiScanItem paramJsApiScanItem)
    {
      this.errMsg = "";
      this.lgx = paramJsApiScanItem;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(189221);
      Context localContext = aj.getContext();
      if ((com.tencent.mm.s.a.n(localContext, false)) || (e.aMh()) || (com.tencent.mm.s.a.p(localContext, false)))
      {
        ad.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
        this.errCode = 1001;
      }
      for (this.errMsg = "camera is using";; this.errMsg = "ok")
      {
        bhX();
        AppMethodBeat.o(189221);
        return;
        this.errCode = 0;
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(189222);
      super.aOB();
      bhO();
      JsApiScanItem localJsApiScanItem = this.lgx;
      if (localJsApiScanItem != null)
      {
        JsApiScanItem.a(localJsApiScanItem, this.errCode, this.errMsg);
        AppMethodBeat.o(189222);
        return;
      }
      AppMethodBeat.o(189222);
    }
    
    public final int describeContents()
    {
      AppMethodBeat.i(189223);
      int i = super.describeContents();
      AppMethodBeat.o(189223);
      return i;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(189225);
      p.h(paramParcel, "in");
      this.errCode = paramParcel.readInt();
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.errMsg = paramParcel;
      AppMethodBeat.o(189225);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189224);
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(189224);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<JsApiScanItem.CheckScanItemTask>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "ErrCode", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResult"})
  static final class b
    implements e.c
  {
    b(JsApiScanItem paramJsApiScanItem, c paramc, int paramInt) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(189228);
      if (paramInt1 != (this.lgz.hashCode() & 0xFFFF))
      {
        AppMethodBeat.o(189228);
        return false;
      }
      boolean bool;
      if (paramIntent != null)
      {
        bool = true;
        ad.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult requestCode: %d, resultCode: %d, data != null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        switch (paramInt2)
        {
        default: 
          this.lgA.h(this.krv, this.lgz.Pg("fail"));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189228);
        return true;
        bool = false;
        break;
        if (paramIntent != null)
        {
          HashMap localHashMap = new HashMap();
          paramIntent = paramIntent.getStringExtra("key_scan_goods_result_req_key");
          ad.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", new Object[] { paramIntent });
          Map localMap = (Map)localHashMap;
          p.g(paramIntent, "reqKey");
          localMap.put("reqKey", paramIntent);
          this.lgA.h(this.krv, this.lgz.m("ok", (Map)localHashMap));
        }
        else
        {
          this.lgA.h(this.krv, this.lgz.Pg("fail"));
          continue;
          this.lgA.h(this.krv, this.lgz.Pg("cancel"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanItem
 * JD-Core Version:    0.7.0.1
 */