package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOnWebPageUrlExposed
  extends c<f>
{
  public static final int CTRL_INDEX = 865;
  public static final String NAME = "private_onWebPageUrlExposed";
  public static final a rzt;
  
  static
  {
    AppMethodBeat.i(325645);
    rzt = new a((byte)0);
    AppMethodBeat.o(325645);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325648);
    Log.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
    if (paramJSONObject == null) {}
    for (String str = null; Util.isNullOrNil(str); str = paramJSONObject.optString("urlList"))
    {
      Log.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
      if (paramf != null) {
        paramf.callback(paramInt, ZP("fail:urlList is null"));
      }
      AppMethodBeat.o(325648);
      return;
    }
    if (paramJSONObject == null) {}
    for (int i = 0;; i = paramJSONObject.optInt("bizType"))
    {
      new WebPagePrefetchTask((p)this, paramf, paramInt, str, i).bQt();
      AppMethodBeat.o(325648);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "bizType", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", "in", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class WebPagePrefetchTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg;
    private int hyY;
    private int ror;
    private p ros;
    private f rot;
    private String rzu;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(325525);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(325525);
    }
    
    public WebPagePrefetchTask() {}
    
    public WebPagePrefetchTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(325523);
      this.rzu = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.success = bool;
        this.hyY = paramParcel.readInt();
        AppMethodBeat.o(325523);
        return;
        bool = false;
      }
    }
    
    public WebPagePrefetchTask(p paramp, f paramf, int paramInt1, String paramString, int paramInt2)
    {
      this();
      this.ros = paramp;
      this.rot = paramf;
      this.ror = paramInt1;
      this.rzu = paramString;
      this.hyY = paramInt2;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(325529);
      this.success = false;
      if (Util.isNullOrNil(this.rzu))
      {
        this.errMsg = "fail:urlList is null";
        Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
      }
      com.tencent.mm.ad.f localf;
      for (;;)
      {
        cpA();
        AppMethodBeat.o(325529);
        return;
        ArrayList localArrayList = new ArrayList();
        try
        {
          localf = new com.tencent.mm.ad.f(this.rzu);
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
      int k = localf.length();
      if (k > 0) {}
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        Object localObject = localf.su(i);
        String str1;
        if (localObject != null)
        {
          str1 = ((i)localObject).optString("url");
          if ((str1 == null) || (n.bp((CharSequence)str1) != true)) {
            break label213;
          }
          i = 1;
          label171:
          if (i == 0) {
            break label218;
          }
          Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
        }
        for (;;)
        {
          if (j >= k)
          {
            if (localException.isEmpty())
            {
              this.errMsg = "fail:decode list is empty";
              Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
              break;
              label213:
              i = 0;
              break label171;
              label218:
              i = ((i)localObject).optInt("bizScene");
              String str2 = ((i)localObject).optString("extInfo");
              h.a locala = new h.a();
              locala.url = str1;
              locala.extInfo = str2;
              locala.vAZ = 177;
              locala.vBa = i;
              locala.vAY = ((i)localObject).optString("prefetchId", "");
              localObject = ah.aiuX;
              localException.add(locala);
              continue;
            }
            Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", s.X("doOnWebPageUrlExposed  bizType:", Integer.valueOf(this.hyY)));
            if (this.hyY == 1) {
              ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ej((List)localException);
            }
            for (;;)
            {
              this.errMsg = "ok";
              this.success = true;
              break;
              ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ei((List)localException);
            }
          }
        }
      }
    }
    
    public final void bQr()
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(325533);
      super.bQr();
      cpx();
      f localf;
      int i;
      p localp;
      if (this.success)
      {
        localf = this.rot;
        if (localf != null)
        {
          i = this.ror;
          localp = this.ros;
          if (localp == null) {}
          for (;;)
          {
            localf.callback(i, str1);
            AppMethodBeat.o(325533);
            return;
            str2 = this.errMsg;
            str1 = str2;
            if (str2 == null) {
              str1 = "ok";
            }
            str1 = localp.ZP(str1);
          }
        }
      }
      else
      {
        localf = this.rot;
        if (localf != null)
        {
          i = this.ror;
          localp = this.ros;
          if (localp != null) {
            break label134;
          }
        }
      }
      for (str1 = str2;; str1 = localp.ZP(str1))
      {
        localf.callback(i, str1);
        AppMethodBeat.o(325533);
        return;
        label134:
        str2 = this.errMsg;
        str1 = str2;
        if (str2 == null) {
          str1 = "fail";
        }
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      int i = 0;
      AppMethodBeat.i(325536);
      super.h(paramParcel);
      String str;
      boolean bool;
      if (paramParcel == null)
      {
        str = null;
        this.rzu = str;
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label70;
        }
        bool = true;
        label40:
        this.success = bool;
        if (paramParcel != null) {
          break label75;
        }
      }
      for (;;)
      {
        this.hyY = i;
        AppMethodBeat.o(325536);
        return;
        str = paramParcel.readString();
        break;
        label70:
        bool = false;
        break label40;
        label75:
        i = paramParcel.readInt();
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(325537);
      s.u(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.rzu);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.hyY);
        AppMethodBeat.o(325537);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOnWebPageUrlExposed.WebPagePrefetchTask>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "BIZ_TYPE_PREFETCH_WEB_PAGE", "", "BIZ_TYPE_PRELOAD_VIDEO", "CTRL_INDEX", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed
 * JD-Core Version:    0.7.0.1
 */