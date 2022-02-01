package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddFileToFavorites", "", "activity", "Landroid/app/Activity;", "filePath", "", "fileExt", "fileName", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "DoFavoriteParams", "plugin-appbrand-integration_release"})
public final class JsApiAddFileToFavorites
  extends c<e>
{
  private static final int CTRL_INDEX = 958;
  private static final String NAME = "addFileToFavorites";
  public static final a osZ;
  
  static
  {
    AppMethodBeat.i(277374);
    osZ = new a((byte)0);
    AppMethodBeat.o(277374);
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    CharSequence localCharSequence = null;
    AppMethodBeat.i(277373);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, env is null");
      AppMethodBeat.o(277373);
      return;
    }
    Object localObject2 = parame.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    final Activity localActivity = (Activity)localObject1;
    if (localActivity == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, activity is null");
      parame.j(paramInt, agS("fail:activity is null"));
      AppMethodBeat.o(277373);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, data is null");
      parame.j(paramInt, agS("fail:data is null"));
      AppMethodBeat.o(277373);
      return;
    }
    Object localObject3 = paramJSONObject.optString("filePath");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is empty");
      parame.j(paramInt, agS("fail:filePath is empty"));
      AppMethodBeat.o(277373);
      return;
    }
    if (n.M((String)localObject3, "wxfile://", false))
    {
      localObject1 = org.apache.commons.a.c.bIf((String)localObject3);
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath: " + (String)localObject3 + ", fileExt: " + (String)localObject1);
      r localr = parame.getFileSystem();
      localObject2 = localCharSequence;
      if (localr != null)
      {
        localObject3 = localr.adL((String)localObject3);
        localObject2 = localCharSequence;
        if (localObject3 != null) {
          localObject2 = ((com.tencent.mm.vfs.q)localObject3).bOF();
        }
      }
      localCharSequence = (CharSequence)localObject2;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label343;
      }
    }
    label343:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label349;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is illegal");
      parame.j(paramInt, agS("fail:filePath is illegal"));
      AppMethodBeat.o(277373);
      return;
      localObject1 = "";
      break;
    }
    label349:
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, realFilePath: ".concat(String.valueOf(localObject2)));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, fileName: ".concat(String.valueOf(paramJSONObject)));
    com.tencent.e.h.ZvG.be((Runnable)new d(this, localActivity, (String)localObject2, (String)localObject1, paramJSONObject, parame, paramInt));
    AppMethodBeat.o(277373);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$DoFavoriteParams;", "Landroid/os/Parcelable;", "filePath", "", "fileExt", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class DoFavoriteParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String fileName;
    final String filePath;
    final String jmx;
    
    static
    {
      AppMethodBeat.i(274293);
      CREATOR = new a();
      AppMethodBeat.o(274293);
    }
    
    public DoFavoriteParams(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(274287);
      this.filePath = paramString1;
      this.jmx = paramString2;
      this.fileName = paramString3;
      AppMethodBeat.o(274287);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(274291);
      if (this != paramObject)
      {
        if ((paramObject instanceof DoFavoriteParams))
        {
          paramObject = (DoFavoriteParams)paramObject;
          if ((!p.h(this.filePath, paramObject.filePath)) || (!p.h(this.jmx, paramObject.jmx)) || (!p.h(this.fileName, paramObject.fileName))) {}
        }
      }
      else
      {
        AppMethodBeat.o(274291);
        return true;
      }
      AppMethodBeat.o(274291);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(274290);
      String str = this.filePath;
      int i;
      if (str != null)
      {
        i = str.hashCode();
        str = this.jmx;
        if (str == null) {
          break label80;
        }
      }
      label80:
      for (int j = str.hashCode();; j = 0)
      {
        str = this.fileName;
        if (str != null) {
          k = str.hashCode();
        }
        AppMethodBeat.o(274290);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(274288);
      String str = "DoFavoriteParams(filePath=" + this.filePath + ", fileExt=" + this.jmx + ", fileName=" + this.fileName + ")";
      AppMethodBeat.o(274288);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(274292);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.jmx);
      paramParcel.writeString(this.fileName);
      AppMethodBeat.o(274292);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(275158);
        p.k(paramParcel, "in");
        paramParcel = new JsApiAddFileToFavorites.DoFavoriteParams(paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
        AppMethodBeat.o(275158);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiAddFileToFavorites.DoFavoriteParams[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$DoFavoriteParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements m<JsApiAddFileToFavorites.DoFavoriteParams, IPCInteger>
  {
    public static final b ota;
    
    static
    {
      AppMethodBeat.i(254224);
      ota = new b();
      AppMethodBeat.o(254224);
    }
    
    private static IPCInteger a(JsApiAddFileToFavorites.DoFavoriteParams paramDoFavoriteParams)
    {
      AppMethodBeat.i(254222);
      try
      {
        String str1 = paramDoFavoriteParams.filePath;
        String str2 = paramDoFavoriteParams.jmx;
        paramDoFavoriteParams = paramDoFavoriteParams.fileName;
        dd localdd = new dd();
        ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a(localdd, 6, str1, dc.E(str1, str2, paramDoFavoriteParams), "");
        EventCenter.instance.publish((IEvent)localdd);
        i = localdd.fyJ.ret;
        Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "doFavoriteMainProcess, ret: ".concat(String.valueOf(i)));
        Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "doFavoriteMainProcess, result: ".concat(String.valueOf(i)));
        paramDoFavoriteParams = new IPCInteger(i);
        AppMethodBeat.o(254222);
        return paramDoFavoriteParams;
      }
      catch (Exception paramDoFavoriteParams)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "doFavoriteMainProcess, fail since ".concat(String.valueOf(paramDoFavoriteParams)));
          int i = -2147483648;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<x>
  {
    c(int paramInt, Activity paramActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(JsApiAddFileToFavorites paramJsApiAddFileToFavorites, Activity paramActivity, String paramString1, String paramString2, String paramString3, e parame, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(278590);
      boolean bool = JsApiAddFileToFavorites.a(localActivity, this.otg, this.oth, paramJSONObject);
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, success: ".concat(String.valueOf(bool)));
      e locale = parame;
      int i = paramInt;
      JsApiAddFileToFavorites localJsApiAddFileToFavorites = this.otf;
      if (bool) {}
      for (String str = "ok";; str = "fail")
      {
        locale.j(i, localJsApiAddFileToFavorites.agS(str));
        AppMethodBeat.o(278590);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddFileToFavorites
 * JD-Core Version:    0.7.0.1
 */