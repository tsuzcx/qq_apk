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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed
  extends a<c>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "onWebPageUrlExposed";
  public static final a jYM;
  
  static
  {
    AppMethodBeat.i(187159);
    jYM = new a((byte)0);
    AppMethodBeat.o(187159);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(187158);
    ac.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("urlList");
    }
    while (bs.isNullOrNil(paramJSONObject))
    {
      ac.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (paramc != null)
      {
        paramc.h(paramInt, LM("fail:urlList is null"));
        AppMethodBeat.o(187158);
        return;
        paramJSONObject = null;
      }
      else
      {
        AppMethodBeat.o(187158);
        return;
      }
    }
    paramc = new WebPagePrefetchTask((m)this, paramc, paramInt, paramJSONObject);
    paramc.bej();
    paramc.aLt();
    AppMethodBeat.o(187158);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private int jOT;
    private m jOU;
    private c jOV;
    private String jYN;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(187157);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(187157);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(187156);
      this.jYN = paramParcel.readString();
      AppMethodBeat.o(187156);
    }
    
    public WebPagePrefetchTask(m paramm, c paramc, int paramInt, String paramString)
    {
      this();
      this.jOU = paramm;
      this.jOV = paramc;
      this.jOT = paramInt;
      this.jYN = paramString;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(187152);
      this.success = false;
      if (bs.isNullOrNil(this.jYN))
      {
        this.errMsg = "fail:urlList is null";
        ac.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      f localf;
      for (;;)
      {
        bet();
        AppMethodBeat.o(187152);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new f(this.jYN);
          if (localf.length() > 0) {
            break;
          }
          this.errMsg = "fail:urlList is decode array fail";
          ac.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
        catch (Exception localException)
        {
          this.errMsg = "fail:parse error";
          ac.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
        }
      }
      int j = localf.length();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = localf.mk(0);
          String str = ((i)localObject).optString("url");
          if ((str != null) && (n.aD((CharSequence)str) == true))
          {
            ac.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
          }
          else
          {
            localObject = ((i)localObject).optString("extInfo");
            d.a locala = new d.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            localException.add(locala);
          }
        }
        else
        {
          if (localException.isEmpty())
          {
            this.errMsg = "fail:decode list is empty";
            ac.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
            break;
          }
          ((d)g.ab(d.class)).cc((List)localException);
          this.errMsg = "ok";
          this.success = true;
          break;
        }
        i += 1;
      }
    }
    
    public final void aLr()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(187153);
      super.aLr();
      bek();
      int i;
      m localm;
      if (this.success)
      {
        localc = this.jOV;
        if (localc != null)
        {
          i = this.jOT;
          localm = this.jOU;
          if (localm != null)
          {
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localm.LM(str1);
          }
          localc.h(i, str1);
          AppMethodBeat.o(187153);
          return;
        }
        AppMethodBeat.o(187153);
        return;
      }
      c localc = this.jOV;
      if (localc != null)
      {
        i = this.jOT;
        localm = this.jOU;
        str1 = str2;
        if (localm != null)
        {
          str2 = this.errMsg;
          str1 = str2;
          if (str2 == null) {
            str1 = "fail";
          }
          str1 = localm.LM(str1);
        }
        localc.h(i, str1);
        AppMethodBeat.o(187153);
        return;
      }
      AppMethodBeat.o(187153);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(187154);
      super.e(paramParcel);
      String str;
      if (paramParcel != null)
      {
        str = paramParcel.readString();
        this.jYN = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(187154);
        return;
        str = null;
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(187155);
      k.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.jYN);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(187155);
        return;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */