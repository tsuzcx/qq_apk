package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed
  extends c<e>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "private_onWebPageUrlExposed";
  public static final a ovZ;
  
  static
  {
    AppMethodBeat.i(277954);
    ovZ = new a((byte)0);
    AppMethodBeat.o(277954);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(277953);
    Log.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    String str;
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("urlList");
    }
    while (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (parame != null)
      {
        parame.j(paramInt, agS("fail:urlList is null"));
        AppMethodBeat.o(277953);
        return;
        str = null;
      }
      else
      {
        AppMethodBeat.o(277953);
        return;
      }
    }
    if (paramJSONObject != null) {}
    for (int i = paramJSONObject.optInt("bizType");; i = 0)
    {
      new WebPagePrefetchTask((o)this, parame, paramInt, str, i).bsM();
      AppMethodBeat.o(277953);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "bizType", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private int hDp;
    private int okO;
    private o okP;
    private e okQ;
    private String owa;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(279011);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(279011);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(279010);
      this.owa = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.success = bool;
        this.hDp = paramParcel.readInt();
        AppMethodBeat.o(279010);
        return;
        bool = false;
      }
    }
    
    public WebPagePrefetchTask(o paramo, e parame, int paramInt1, String paramString, int paramInt2)
    {
      this();
      this.okP = paramo;
      this.okQ = parame;
      this.okO = paramInt1;
      this.owa = paramString;
      this.hDp = paramInt2;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(279006);
      this.success = false;
      if (Util.isNullOrNil(this.owa))
      {
        this.errMsg = "fail:urlList is null";
        Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      com.tencent.mm.ad.f localf;
      for (;;)
      {
        bPt();
        AppMethodBeat.o(279006);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new com.tencent.mm.ad.f(this.owa);
          if (localf.length() > 0) {
            break;
          }
          this.errMsg = "fail:urlList is decode array fail";
          Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
        catch (Exception localException)
        {
          this.errMsg = "fail:parse error";
          Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
      }
      int j = localf.length();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = localf.sy(i);
          String str = ((i)localObject).optString("url");
          if ((str != null) && (n.ba((CharSequence)str) == true))
          {
            Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
          }
          else
          {
            int k = ((i)localObject).optInt("bizScene");
            localObject = ((i)localObject).optString("extInfo");
            f.a locala = new f.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.svv = 177;
            locala.svw = k;
            localException.add(locala);
          }
        }
        else
        {
          if (localException.isEmpty())
          {
            this.errMsg = "fail:decode list is empty";
            Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
            break;
          }
          Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "doOnWebPageUrlExposed  bizType:" + this.hDp);
          if (this.hDp == 1) {
            ((com.tencent.mm.plugin.brandservice.a.f)h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).cr((List)localException);
          }
          for (;;)
          {
            this.errMsg = "ok";
            this.success = true;
            break;
            ((com.tencent.mm.plugin.brandservice.a.f)h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).cq((List)localException);
          }
        }
        i += 1;
      }
    }
    
    public final void bsK()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(279007);
      super.bsK();
      bPk();
      int i;
      o localo;
      if (this.success)
      {
        locale = this.okQ;
        if (locale != null)
        {
          i = this.okO;
          localo = this.okP;
          if (localo != null)
          {
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localo.agS(str1);
          }
          locale.j(i, str1);
          AppMethodBeat.o(279007);
          return;
        }
        AppMethodBeat.o(279007);
        return;
      }
      e locale = this.okQ;
      if (locale != null)
      {
        i = this.okO;
        localo = this.okP;
        str1 = str2;
        if (localo != null)
        {
          str2 = this.errMsg;
          str1 = str2;
          if (str2 == null) {
            str1 = "fail";
          }
          str1 = localo.agS(str1);
        }
        locale.j(i, str1);
        AppMethodBeat.o(279007);
        return;
      }
      AppMethodBeat.o(279007);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      int i = 0;
      AppMethodBeat.i(279008);
      super.f(paramParcel);
      String str;
      if (paramParcel != null)
      {
        str = paramParcel.readString();
        this.owa = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label73;
        }
      }
      label73:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        if (paramParcel != null) {
          i = paramParcel.readInt();
        }
        this.hDp = i;
        AppMethodBeat.o(279008);
        return;
        str = null;
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(279009);
      p.k(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.owa);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.hDp);
        AppMethodBeat.o(279009);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "BIZ_TYPE_PREFETCH_WEB_PAGE", "", "BIZ_TYPE_PRELOAD_VIDEO", "CTRL_INDEX", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */