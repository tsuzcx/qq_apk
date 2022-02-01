package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed
  extends a<c>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "private_onWebPageUrlExposed";
  public static final a kti;
  
  static
  {
    AppMethodBeat.i(189069);
    kti = new a((byte)0);
    AppMethodBeat.o(189069);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(189068);
    ad.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("urlList");
    }
    while (bt.isNullOrNil(paramJSONObject))
    {
      ad.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (paramc != null)
      {
        paramc.h(paramInt, Pg("fail:urlList is null"));
        AppMethodBeat.o(189068);
        return;
        paramJSONObject = null;
      }
      else
      {
        AppMethodBeat.o(189068);
        return;
      }
    }
    paramc = new WebPagePrefetchTask((m)this, paramc, paramInt, paramJSONObject);
    paramc.bhN();
    paramc.aOD();
    AppMethodBeat.o(189068);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private int kje;
    private m kjf;
    private c kjg;
    private String ktj;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(189067);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(189067);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(189066);
      this.ktj = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.success = bool;
        AppMethodBeat.o(189066);
        return;
        bool = false;
      }
    }
    
    public WebPagePrefetchTask(m paramm, c paramc, int paramInt, String paramString)
    {
      this();
      this.kjf = paramm;
      this.kjg = paramc;
      this.kje = paramInt;
      this.ktj = paramString;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(189062);
      this.success = false;
      if (bt.isNullOrNil(this.ktj))
      {
        this.errMsg = "fail:urlList is null";
        ad.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      f localf;
      for (;;)
      {
        bhX();
        AppMethodBeat.o(189062);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new f(this.ktj);
          if (localf.length() > 0) {
            break;
          }
          this.errMsg = "fail:urlList is decode array fail";
          ad.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
        catch (Exception localException)
        {
          this.errMsg = "fail:parse error";
          ad.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
      }
      int j = localf.length();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = localf.mJ(i);
          String str = ((i)localObject).optString("url");
          if ((str != null) && (n.aE((CharSequence)str) == true))
          {
            ad.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
          }
          else
          {
            localObject = ((i)localObject).optString("extInfo");
            d.a locala = new d.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.nWh = 177;
            localException.add(locala);
          }
        }
        else
        {
          if (localException.isEmpty())
          {
            this.errMsg = "fail:decode list is empty";
            ad.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
            break;
          }
          ((d)g.ab(d.class)).cd((List)localException);
          this.errMsg = "ok";
          this.success = true;
          break;
        }
        i += 1;
      }
    }
    
    public final void aOB()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(189063);
      super.aOB();
      bhO();
      int i;
      m localm;
      if (this.success)
      {
        localc = this.kjg;
        if (localc != null)
        {
          i = this.kje;
          localm = this.kjf;
          if (localm != null)
          {
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localm.Pg(str1);
          }
          localc.h(i, str1);
          AppMethodBeat.o(189063);
          return;
        }
        AppMethodBeat.o(189063);
        return;
      }
      c localc = this.kjg;
      if (localc != null)
      {
        i = this.kje;
        localm = this.kjf;
        str1 = str2;
        if (localm != null)
        {
          str2 = this.errMsg;
          str1 = str2;
          if (str2 == null) {
            str1 = "fail";
          }
          str1 = localm.Pg(str1);
        }
        localc.h(i, str1);
        AppMethodBeat.o(189063);
        return;
      }
      AppMethodBeat.o(189063);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(189064);
      super.e(paramParcel);
      String str;
      if (paramParcel != null)
      {
        str = paramParcel.readString();
        this.ktj = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(189064);
        return;
        str = null;
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189065);
      p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.ktj);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(189065);
        return;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */