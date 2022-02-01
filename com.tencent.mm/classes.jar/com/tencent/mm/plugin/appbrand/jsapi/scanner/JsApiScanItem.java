package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiScanItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 869;
  private static final String NAME = "scanItem";
  public static final a lki;
  private String data = "";
  private c kfi;
  private int kmu;
  
  static
  {
    AppMethodBeat.i(223487);
    lki = new a((byte)0);
    NAME = "scanItem";
    CTRL_INDEX = 869;
    AppMethodBeat.o(223487);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class CheckScanItemTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckScanItemTask> CREATOR;
    public static final a lkk;
    private int errCode;
    private String errMsg;
    private JsApiScanItem lkj;
    
    static
    {
      AppMethodBeat.i(223484);
      lkk = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(223484);
    }
    
    public CheckScanItemTask(Parcel paramParcel)
    {
      AppMethodBeat.i(223483);
      this.errMsg = "";
      e(paramParcel);
      AppMethodBeat.o(223483);
    }
    
    public CheckScanItemTask(JsApiScanItem paramJsApiScanItem)
    {
      this.errMsg = "";
      this.lkj = paramJsApiScanItem;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(223478);
      Context localContext = ak.getContext();
      if ((com.tencent.mm.r.a.n(localContext, false)) || (e.aME()) || (com.tencent.mm.r.a.p(localContext, false)))
      {
        ae.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
        this.errCode = 1001;
      }
      for (this.errMsg = "camera is using";; this.errMsg = "ok")
      {
        biG();
        AppMethodBeat.o(223478);
        return;
        this.errCode = 0;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(223479);
      super.aOY();
      bix();
      JsApiScanItem localJsApiScanItem = this.lkj;
      if (localJsApiScanItem != null)
      {
        JsApiScanItem.a(localJsApiScanItem, this.errCode, this.errMsg);
        AppMethodBeat.o(223479);
        return;
      }
      AppMethodBeat.o(223479);
    }
    
    public final int describeContents()
    {
      AppMethodBeat.i(223480);
      int i = super.describeContents();
      AppMethodBeat.o(223480);
      return i;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(223482);
      p.h(paramParcel, "in");
      this.errCode = paramParcel.readInt();
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.errMsg = paramParcel;
      AppMethodBeat.o(223482);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(223481);
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(223481);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<JsApiScanItem.CheckScanItemTask>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "ErrCode", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResult"})
  static final class b
    implements e.c
  {
    b(JsApiScanItem paramJsApiScanItem, c paramc, int paramInt) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(223485);
      if (paramInt1 != (this.lkl.hashCode() & 0xFFFF))
      {
        AppMethodBeat.o(223485);
        return false;
      }
      boolean bool;
      if (paramIntent != null)
      {
        bool = true;
        ae.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult requestCode: %d, resultCode: %d, data != null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        switch (paramInt2)
        {
        default: 
          this.lkm.h(this.kuL, this.lkl.PO("fail"));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(223485);
        return true;
        bool = false;
        break;
        if (paramIntent != null)
        {
          HashMap localHashMap = new HashMap();
          paramIntent = paramIntent.getStringExtra("key_scan_goods_result_req_key");
          ae.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", new Object[] { paramIntent });
          Map localMap = (Map)localHashMap;
          p.g(paramIntent, "reqKey");
          localMap.put("reqKey", paramIntent);
          this.lkm.h(this.kuL, this.lkl.n("ok", (Map)localHashMap));
        }
        else
        {
          this.lkm.h(this.kuL, this.lkl.PO("fail"));
          continue;
          this.lkm.h(this.kuL, this.lkl.PO("cancel"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanItem
 * JD-Core Version:    0.7.0.1
 */