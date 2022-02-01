package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed
  extends d<f>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "private_onWebPageUrlExposed";
  public static final a lAI;
  
  static
  {
    AppMethodBeat.i(228294);
    lAI = new a((byte)0);
    AppMethodBeat.o(228294);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228293);
    Log.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("urlList");
    }
    while (Util.isNullOrNil(paramJSONObject))
    {
      Log.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (paramf != null)
      {
        paramf.i(paramInt, Zf("fail:urlList is null"));
        AppMethodBeat.o(228293);
        return;
        paramJSONObject = null;
      }
      else
      {
        AppMethodBeat.o(228293);
        return;
      }
    }
    paramf = new WebPagePrefetchTask((p)this, paramf, paramInt, paramJSONObject);
    paramf.bDJ();
    paramf.bjm();
    AppMethodBeat.o(228293);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private String lAJ;
    private int lqe;
    private p lqf;
    private f lqg;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(228292);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(228292);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(228291);
      this.lAJ = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.success = bool;
        AppMethodBeat.o(228291);
        return;
        bool = false;
      }
    }
    
    public WebPagePrefetchTask(p paramp, f paramf, int paramInt, String paramString)
    {
      this();
      this.lqf = paramp;
      this.lqg = paramf;
      this.lqe = paramInt;
      this.lAJ = paramString;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(228287);
      this.success = false;
      if (Util.isNullOrNil(this.lAJ))
      {
        this.errMsg = "fail:urlList is null";
        Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      com.tencent.mm.ab.f localf;
      for (;;)
      {
        bDU();
        AppMethodBeat.o(228287);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new com.tencent.mm.ab.f(this.lAJ);
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
          Object localObject = localf.pZ(i);
          String str = ((i)localObject).optString("url");
          if ((str != null) && (n.aL((CharSequence)str) == true))
          {
            Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
          }
          else
          {
            int k = ((i)localObject).optInt("bizScene");
            localObject = ((i)localObject).optString("extInfo");
            e.a locala = new e.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.pmM = 177;
            locala.pmN = k;
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
          ((e)g.af(e.class)).cu((List)localException);
          this.errMsg = "ok";
          this.success = true;
          break;
        }
        i += 1;
      }
    }
    
    public final void bjk()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(228288);
      super.bjk();
      bDK();
      int i;
      p localp;
      if (this.success)
      {
        localf = this.lqg;
        if (localf != null)
        {
          i = this.lqe;
          localp = this.lqf;
          if (localp != null)
          {
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localp.Zf(str1);
          }
          localf.i(i, str1);
          AppMethodBeat.o(228288);
          return;
        }
        AppMethodBeat.o(228288);
        return;
      }
      f localf = this.lqg;
      if (localf != null)
      {
        i = this.lqe;
        localp = this.lqf;
        str1 = str2;
        if (localp != null)
        {
          str2 = this.errMsg;
          str1 = str2;
          if (str2 == null) {
            str1 = "fail";
          }
          str1 = localp.Zf(str1);
        }
        localf.i(i, str1);
        AppMethodBeat.o(228288);
        return;
      }
      AppMethodBeat.o(228288);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(228289);
      super.f(paramParcel);
      String str;
      if (paramParcel != null)
      {
        str = paramParcel.readString();
        this.lAJ = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(228289);
        return;
        str = null;
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(228290);
      kotlin.g.b.p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.lAJ);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(228290);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */