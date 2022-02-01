package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed
  extends a<c>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "private_onWebPageUrlExposed";
  public static final a kwy;
  
  static
  {
    AppMethodBeat.i(223328);
    kwy = new a((byte)0);
    AppMethodBeat.o(223328);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(223327);
    ae.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("urlList");
    }
    while (bu.isNullOrNil(paramJSONObject))
    {
      ae.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (paramc != null)
      {
        paramc.h(paramInt, PO("fail:urlList is null"));
        AppMethodBeat.o(223327);
        return;
        paramJSONObject = null;
      }
      else
      {
        AppMethodBeat.o(223327);
        return;
      }
    }
    paramc = new WebPagePrefetchTask((m)this, paramc, paramInt, paramJSONObject);
    paramc.biw();
    paramc.aPa();
    AppMethodBeat.o(223327);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private int kmu;
    private m kmv;
    private c kmw;
    private String kwz;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(223326);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(223326);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(223325);
      this.kwz = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.success = bool;
        AppMethodBeat.o(223325);
        return;
        bool = false;
      }
    }
    
    public WebPagePrefetchTask(m paramm, c paramc, int paramInt, String paramString)
    {
      this();
      this.kmv = paramm;
      this.kmw = paramc;
      this.kmu = paramInt;
      this.kwz = paramString;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(223321);
      this.success = false;
      if (bu.isNullOrNil(this.kwz))
      {
        this.errMsg = "fail:urlList is null";
        ae.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      f localf;
      for (;;)
      {
        biG();
        AppMethodBeat.o(223321);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new f(this.kwz);
          if (localf.length() > 0) {
            break;
          }
          this.errMsg = "fail:urlList is decode array fail";
          ae.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
        catch (Exception localException)
        {
          this.errMsg = "fail:parse error";
          ae.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
      }
      int j = localf.length();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = localf.mM(i);
          String str = ((i)localObject).optString("url");
          if ((str != null) && (n.aD((CharSequence)str) == true))
          {
            ae.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
          }
          else
          {
            localObject = ((i)localObject).optString("extInfo");
            d.a locala = new d.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.obQ = 177;
            localException.add(locala);
          }
        }
        else
        {
          if (localException.isEmpty())
          {
            this.errMsg = "fail:decode list is empty";
            ae.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
            break;
          }
          ((d)g.ab(d.class)).cf((List)localException);
          this.errMsg = "ok";
          this.success = true;
          break;
        }
        i += 1;
      }
    }
    
    public final void aOY()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(223322);
      super.aOY();
      bix();
      int i;
      m localm;
      if (this.success)
      {
        localc = this.kmw;
        if (localc != null)
        {
          i = this.kmu;
          localm = this.kmv;
          if (localm != null)
          {
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localm.PO(str1);
          }
          localc.h(i, str1);
          AppMethodBeat.o(223322);
          return;
        }
        AppMethodBeat.o(223322);
        return;
      }
      c localc = this.kmw;
      if (localc != null)
      {
        i = this.kmu;
        localm = this.kmv;
        str1 = str2;
        if (localm != null)
        {
          str2 = this.errMsg;
          str1 = str2;
          if (str2 == null) {
            str1 = "fail";
          }
          str1 = localm.PO(str1);
        }
        localc.h(i, str1);
        AppMethodBeat.o(223322);
        return;
      }
      AppMethodBeat.o(223322);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(223323);
      super.e(paramParcel);
      String str;
      if (paramParcel != null)
      {
        str = paramParcel.readString();
        this.kwz = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(223323);
        return;
        str = null;
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(223324);
      p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.kwz);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(223324);
        return;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */